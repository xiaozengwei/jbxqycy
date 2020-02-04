package com.gx.soft.sd.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gx.core.export.ExcelDataNormalStrategy;
import com.gx.core.export.ExcelExportUtil;
import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.spring.DateConverter;
import com.gx.core.util.StringUtils;
import com.gx.soft.common.util.FileUtil;
import com.gx.soft.common.util.HttpClient;
import com.gx.soft.common.util.SendMessageUtil;
import com.gx.soft.common.wxpay.WXPayUtil;
import com.gx.soft.sd.persistence.domain.*;
import com.gx.soft.sd.persistence.manager.*;
import com.gx.soft.sys.persistence.domain.GxSysDicRecord;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.domain.VUser;
import com.gx.soft.sys.persistence.manager.GxRecordManager;
import com.gx.soft.sys.vo.ZtreeData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("water")
@SessionAttributes("user_session")
public class WaterController {
    static Logger logger = Logger.getLogger(ElectricController.class);
    @Autowired
    private WaterFloorRoomInDeviceManager waterFloorRoomInDeviceManager;
    @Autowired
    private WaterFloorRoomManager waterFloorRoomManager;
    @Autowired
    private VWaterRoomDeviceManager vWaterRoomDeviceManager;
    @Autowired
    private VWaterRoomUserManager vWaterRoomUserManager;
    @Autowired
    private WaterNowRecordManager waterNowRecordManager;
    @Autowired
    private WaterMonthRecordManager waterMonthRecordManager;
    @Autowired
    private VWaterEveryMonthManager vWaterEveryMonthManager;
    @Autowired
    private GxRecordManager gxRecordManager;
    @Autowired
    private WaterMonthBillManager waterMonthBillManager;
    @Autowired
    private WaterAccountManager waterAccountManager;
    @Autowired
    private CheckOutRoomManager checkOutRoomManager;
    @Autowired
    private ElectricWaterReductionManager electricWaterReductionManager;
    @Autowired
    private WxUserRoomManager wxUserRoomManager;
    @Autowired
    private VRoomDeviceManager vRoomDeviceManager;
    @Autowired
    private DeviceOnAndOffManager deviceOnAndOffManager;
    @Autowired
    private ElectricDayRecordManager electricDayRecordManager;
    @Autowired
    private FloorRoomInDeviceManager floorRoomInDeviceManager;
    private BeanMapper beanMapper=new BeanMapper();

    @RequestMapping("water-room-page")
    public String deviceRoomPage(){
        return "sd/water/water-room-page";
    }
    @RequestMapping(value = "floor-room-tree", produces = "application/json")
    public @ResponseBody
    List<ZtreeData> orgTree(@RequestParam Map<String, Object> parameterMap,
                            Model model) {
        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        List<WaterFloorRoom> floorRoomList = waterFloorRoomManager.find("pFloorName",true,propertyFilters);
        List<ZtreeData> ztreeData = new ArrayList<ZtreeData>();
        for (WaterFloorRoom floorRoom : floorRoomList) {
            ZtreeData zData = new ZtreeData(String.valueOf(floorRoom.getRowId()),
                    String.valueOf(floorRoom.getpFloorId()), floorRoom.getRowName(), floorRoom.getpFloorName());
            ztreeData.add(zData);
        }
        return ztreeData;
    }

    @RequestMapping("water-device-list")
    public String waterDeviceList(@ModelAttribute Page page, Model model, String rowId){
        Map<String,Object> map=new HashMap<>();
        map.put("filter_EQS_rowId",rowId);
        List<PropertyFilter> propertyFilters =new PropertyFilter().buildFromMap(map);
        page= vWaterRoomDeviceManager.pagedQuery(page,propertyFilters);
        model.addAttribute("page",page);
        model.addAttribute("rowId",rowId);
        return "sd/water/water-device-list";
    }

    @RequestMapping("water-user-room")
    public String WaterdeviceUserList(@ModelAttribute Page page,Model model,String roomId){
        Map<String,Object> map=new HashMap<>();
        map.put("filter_EQS_rowId",roomId);
        List<PropertyFilter> propertyFilters =new PropertyFilter().buildFromMap(map);
        page= vWaterRoomUserManager.pagedQuery(page,propertyFilters);
        model.addAttribute("page",page);
        model.addAttribute("roomId",roomId);
        return "sd/water/water-device-user-list";
    }
    @RequestMapping("water-month-list")
    public String list(@ModelAttribute Page page,Model model, @RequestParam Map<String, Object> parameterMap,String deviceId) throws Exception{
        parameterMap.put("filter_EQS_deviceId",deviceId);
        List<PropertyFilter> propertyFilters =PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("time","desc");
        WaterMonthRecord last=new WaterMonthRecord();
        Page page1=new Page();
        page1.setPageSize(page.getPageSize()+1);
        page1.setPageCurrent(page.getPageCurrent());
        page1.addOrder("time","desc");
        page1=waterMonthRecordManager.pagedQuery(page1,propertyFilters);
        if(page1.getPageCurrent()!=Math.floor((page1.getTotalCount()/11)+1)){
            last= ((List<WaterMonthRecord>)page1.getResult()).get(page1.getPageSize()-page1.getPageCurrent());
        }
        page=waterMonthRecordManager.pagedQuery(page,propertyFilters);
        List<WaterMonthRecord> list=(List<WaterMonthRecord>)page.getResult();
        for(int i=0;i<list.size();i++){
//            if()
            if(i==list.size()-1&&page1.getPageCurrent()!=Math.ceil((page1.getTotalCount()/11)+1)){
                list.get(i).setExt(String.valueOf(new DecimalFormat("0.00").format(Double.parseDouble(list.get(i).getTotalWater())-Double.parseDouble(last.getTotalWater()))));
                continue;
            }
            WaterMonthRecord monthRecord=list.get(i);
            WaterMonthRecord beforeMonthRecord;
            if(i!=list.size()-1||page1.getPageCurrent()!=Math.ceil((page1.getTotalCount()/11)+1)){
                beforeMonthRecord=list.get(i+1);
            }else {
                beforeMonthRecord=list.get(i);
            }
            monthRecord.setExt(String.valueOf(new DecimalFormat("0.00").format(Double.parseDouble(monthRecord.getTotalWater())-Double.parseDouble(beforeMonthRecord.getTotalWater()))));

        }
        model.addAttribute("page",page);
        model.addAttribute("deviceId",deviceId);
        return "sd/water/water-month-list";
    }

    @RequestMapping("water-day-list")
    public String dayList(@ModelAttribute Page page,Model model, @RequestParam Map<String, Object> parameterMap,String deviceId){
        parameterMap.put("filter_EQS_deviceId",deviceId);
        List<PropertyFilter> propertyFilters =PropertyFilter.buildFromMap(parameterMap);
        page =waterNowRecordManager.pagedQuery(page,propertyFilters);
        List<WaterNowRecord> list=(List<WaterNowRecord>)page.getResult();
        for(WaterNowRecord waterDayRecord:list){
            Calendar calendar=Calendar.getInstance();
            calendar.add(Calendar.MONTH,-1);
            Date date = new Date(waterDayRecord.getTime().getTime());
            parameterMap.put("filter_LED_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
            List<WaterMonthRecord> waterMonthRecordList=waterMonthRecordManager.find("time",false,PropertyFilter.buildFromMap(parameterMap));
            if(waterMonthRecordList==null&&waterMonthRecordList.size()==0){
                waterDayRecord.setExt(waterDayRecord.getTotalWater());
            }else {
                String beforeWater=waterMonthRecordList.get(1).getTotalWater();
                waterDayRecord.setExt(String.valueOf(new DecimalFormat("0.00").format(Double.parseDouble(waterDayRecord.getTotalWater())-Double.parseDouble(beforeWater))));
            }
        }
        model.addAttribute("page",page);
        model.addAttribute("deviceId",deviceId);
        model.addAttribute("day","day");
        return "sd/water/water-month-list";
    }

    @RequestMapping("water-bill-list")
    public String waterBillList(Model model,String start,String end,String filter_LIKES_rowName)throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        GxSysDicRecord gxSysDicRecord = gxRecordManager.findUniqueBy("dicId", "water_dj_1");
        List<VWaterEveryMonth> vList=new ArrayList<>();
        if(start!=null&&!(sdf.parse(start).after(sdf.parse(end)))){
//            Page page1=new Page();
//            beanMapper.copy(page,page1);
//            Map<String,Object> map=new HashMap<>();
//            map.put("filter_GED_time","20"+start+" 00:00:00");
//            map.put("filter_LED_time","20"+start+" 23:59:59");
//            map.put("time",start);
//            page1.addOrder("deviceId","asc");
            List<Object> startList=vWaterEveryMonthManager.find("select deviceId,rowName,totalWater,time,ext,ext2,ext3,ext4 FROM VWaterEveryMonth where DATE_FORMAT(time,'%Y%m%d')=? and rowName like ? group by deviceId order by deviceId",start.replaceAll("-",""),"%"+filter_LIKES_rowName+"%");

//
//            page1=vWaterEveryMonthManager.pagedQuery(page1,PropertyFilter.buildFromMap(map));
//            List<VWaterEveryMonth> vWaterEveryMonthList1= (List<VWaterEveryMonth>)page1.getResult();

//            map.put("filter_GED_time","20"+end+" 00:00:00");
//            map.put("filter_LED_time","20"+end+" 23:59:59");
//            page.addOrder("deviceId","asc");
//            page=vWaterEveryMonthManager.pagedQuery(page,PropertyFilter.buildFromMap(map));
//            List<VWaterEveryMonth> vWaterEveryMonthList= (List<VWaterEveryMonth>)page.getResult();
            List<Object> endList=vWaterEveryMonthManager.find("select deviceId,rowName,totalWater,time,ext,ext2,ext3,ext4 FROM VWaterEveryMonth where DATE_FORMAT(time,'%Y%m%d')=? and rowName like ? group by deviceId order by deviceId",end.replaceAll("-",""),"%"+filter_LIKES_rowName+"%");
            reduce(endList,startList);
            for(int i=0;i<endList.size();i++){
//                VWaterEveryMonth after= vWaterEveryMonthList.get(i);
//                VWaterEveryMonth before= vWaterEveryMonthList1.get(i);
                Object[] before=(Object[])startList.get(i);
                Object[] after=(Object[])endList.get(i);
                if(!before[0].toString().equals(after[0].toString())){
                    continue;
                }
                VWaterEveryMonth vWaterEveryMonth=new VWaterEveryMonth();
                vWaterEveryMonth.setDeviceId(after[0].toString());
                vWaterEveryMonth.setRowName(after[1].toString());
                vWaterEveryMonth.setTotalWater(after[2].toString());
                vWaterEveryMonth.setExt(before[2].toString());
                vWaterEveryMonth.setExt2(new DecimalFormat("######0.00").format(Double.parseDouble(after[2].toString())-Double.parseDouble(before[2].toString())));
                vWaterEveryMonth.setExt3(new DecimalFormat("######0.00").format(Double.parseDouble(vWaterEveryMonth.getExt2())*Double.parseDouble(gxSysDicRecord.getDicName())));
                vWaterEveryMonth.setExt4(sdf.format(before[3])+"/"+sdf.format(after[3]));
                if(before[0].toString().equals(after[0].toString())){
                    vList.add(vWaterEveryMonth);
                }
//                vWaterEveryMonth.setExt(before.getTotalWater());
//                vWaterEveryMonth.setExt2(new DecimalFormat("######0.00").format(Double.parseDouble(after.getTotalWater())-Double.parseDouble(before.getTotalWater())));
//                vWaterEveryMonth.setExt3(new DecimalFormat("######0.00").format(Double.parseDouble(after.getExt2())*Double.parseDouble(gxSysDicRecord.getDicName())));
//                vWaterEveryMonth.setExt4(sdf.format(before.getTime())+"/"+sdf.format(after.getTime()));
            }
        }
        List<String> list=waterMonthRecordManager.find("SELECT DATE_FORMAT(time,'%Y-%m-%d') FROM WaterMonthRecord GROUP BY DATE_FORMAT(time,'%Y-%m-%d') order by time desc");
        model.addAttribute("start",start);
        model.addAttribute("end",end);
        model.addAttribute("stringList",list);
        model.addAttribute("list",vList);
        return "sd/water/water-bill-list";
    }

    @RequestMapping("water-export")
    public @ResponseBody
    Map<String, Object> waterExport(HttpServletResponse response,String start,String end,String filter_LIKES_rowName) throws Exception{
        start = start.substring(start.lastIndexOf(",")+1);
        end = end.substring(end.lastIndexOf(",")+1);
        filter_LIKES_rowName = filter_LIKES_rowName.substring(filter_LIKES_rowName.lastIndexOf(",")+1);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
        GxSysDicRecord gxSysDicRecord = gxRecordManager.findUniqueBy("dicId", "water_dj_1");
        List<VWaterEveryMonth> vList=new ArrayList<>();
        Map<String, Object> resMap = new HashMap<String, Object>();
        Map<String, Object> metaMap = new HashMap<>();
        String statusCode = "200", message = "导出成功";
        Calendar calendar1=Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, calendar1.get(Calendar.DAY_OF_MONTH) - 45);
        Map<String,Object> map1=new HashMap<>();
        map1.put("filter_EQS_time",simpleDateFormat.format(calendar1.getTime()));
        List<WaterMonthBill> startList=waterMonthBillManager.find("deviceId",true,PropertyFilter.buildFromMap(map1));
////        List<Object> startList=vWaterEveryMonthManager.find("select deviceId,rowName,totalWater,time,ext,ext2,ext3,ext4 FROM VWaterEveryMonth where DATE_FORMAT(time,'%Y%m%d')=? and (rowName like ?) and (deviceId>=4954 and deviceId<=5143) and status is null group by deviceId order by deviceId",start.replaceAll("-",""),"%"+filter_LIKES_rowName+"%");
        List<Object> endList=vWaterEveryMonthManager.find("select deviceId,rowName,totalWater,time,ext,ext2,ext3,ext4 FROM VWaterEveryMonth where DATE_FORMAT(time,'%Y%m%d')=? and (rowName like ?) and (deviceId>=4954 and deviceId<=5143) and status is null group by deviceId order by deviceId",end.replaceAll("-",""),"%"+filter_LIKES_rowName+"%");
////        reduce(endList,startList);
////        List<Object> allList=waterFloorRoomInDeviceManager.find("select deviceId,roomName from WaterFloorRoomInDevice where deviceId>=4954 and deviceId<=5143");
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 15);
        Map<String,Object> map=new HashMap<>();
        map.put("filter_EQS_time",simpleDateFormat.format(calendar.getTime()));
        List<WaterMonthBill> checkList=waterMonthBillManager.find("localRecordTime",false,PropertyFilter.buildFromMap(map));
////        if(endList.size()==startList.size()) {
        for(WaterMonthBill before:startList){
            map1.put("filter_EQS_deviceId",before.getDeviceId());
            List<WaterMonthBill> select=waterMonthBillManager.find("localRecordTime",false,PropertyFilter.buildFromMap(map1));
            if(select.size()>1){
                if(before.getLocalRecordTime().compareTo(select.get(0).getLocalRecordTime())!=0){
                    continue;
                }
            }
            boolean out=false;
            for(int i=0;i<endList.size();i++){
                Object[] after = (Object[]) endList.get(i);
                if(before.getDeviceId().equals(after[0].toString())){
                    boolean flog=false;
                    for(WaterMonthBill waterMonthBill:checkList){
                        String roomName=waterMonthBill.getRoomName();
                        if(roomName.substring(roomName.length()-2).equals("3A")){
                            String tt=roomName.substring(0,roomName.length()-2);
                            tt=tt+"4";
                            roomName=tt;
                        }
                        if(waterMonthBill.getDeviceId().equals(before.getDeviceId())){
                            VWaterEveryMonth vWaterEveryMonth = new VWaterEveryMonth();
                            vWaterEveryMonth.setvKey(String.valueOf(vList.size())+1);
                            vWaterEveryMonth.setDeviceId(waterMonthBill.getDeviceId());
                            vWaterEveryMonth.setRowName(roomName);
                            vWaterEveryMonth.setExt4(waterMonthBill.getTimeSection().substring(11,21)+"/"+end);
                            vWaterEveryMonth.setExt(String.valueOf(waterMonthBill.getWaterCurrentUse()));
                            vWaterEveryMonth.setTotalWater(after[2].toString());
                            vWaterEveryMonth.setExt2(new DecimalFormat("######0.00").format(Double.parseDouble(after[2].toString()) - waterMonthBill.getWaterCurrentUse()));
                            vWaterEveryMonth.setExt3(new DecimalFormat("######0.00").format(Double.parseDouble(vWaterEveryMonth.getExt2()) * Double.parseDouble(gxSysDicRecord.getDicName())));
                            if(DateConverter.dateBefore(waterMonthBill.getTimeSection().substring(11,21),end)){
                                vList.add(vWaterEveryMonth);
                            }
                            flog=true;
                            out=true;
                            break;
                        }
                    }
                    if(flog){
                        continue;
                    }
                    VWaterEveryMonth vWaterEveryMonth = new VWaterEveryMonth();
                    vWaterEveryMonth.setvKey(String.valueOf(vList.size()+1));
                    vWaterEveryMonth.setDeviceId(after[0].toString());
                    vWaterEveryMonth.setRowName(after[1].toString());
                    vWaterEveryMonth.setTotalWater(after[2].toString());
                    vWaterEveryMonth.setExt(String.valueOf(before.getWaterCurrentUse()));
                    vWaterEveryMonth.setExt2(new DecimalFormat("######0.00").format(Double.parseDouble(after[2].toString()) - before.getWaterCurrentUse()));
                    vWaterEveryMonth.setExt3(new DecimalFormat("######0.00").format(Double.parseDouble(vWaterEveryMonth.getExt2()) * Double.parseDouble(gxSysDicRecord.getDicName())));
                    vWaterEveryMonth.setExt4(before.getTimeSection().substring(11,21) + "/" + end);
                    vList.add(vWaterEveryMonth);
                    out=true;
                    break;
                }
            }
            if(!out){
                VWaterEveryMonth vWaterEveryMonth = new VWaterEveryMonth();
                String roomName=before.getRoomName();
                if(roomName.substring(roomName.length()-2).equals("3A")){
                    String tt=roomName.substring(0,roomName.length()-2);
                    tt=tt+"4";
                    roomName=tt;
                }
                vWaterEveryMonth.setvKey(String.valueOf(vList.size()+1));
                vWaterEveryMonth.setDeviceId(before.getDeviceId());
                vWaterEveryMonth.setRowName(roomName);
                vWaterEveryMonth.setExt(String.valueOf(before.getWaterCurrentUse()));
                vWaterEveryMonth.setExt4(before.getTimeSection().substring(11,21)+"/"+end);
                vList.add(vWaterEveryMonth);
            }
        }
//            for (int i = 0; i < endList.size(); i++) {
//                Object[] before = (Object[]) startList.get(i);
//                Object[] after = (Object[]) endList.get(i);
//                if (!before[0].toString().equals(after[0].toString())) {
//                    continue;
//                }
//                boolean flog=false;
//                for(WaterMonthBill waterMonthBill:checkList){
//                    String roomName=waterMonthBill.getRoomName();
//                    if(roomName.substring(roomName.length()-2).equals("3A")){
//                        String tt=roomName.substring(0,roomName.length()-2);
//                        tt=tt+"4";
//                        roomName=tt;
//                    }
//                    if(roomName.equals(before[1].toString())){
//                        VWaterEveryMonth vWaterEveryMonth = new VWaterEveryMonth();
//                        vWaterEveryMonth.setvKey(String.valueOf(vList.size())+1);
//                        vWaterEveryMonth.setDeviceId(waterMonthBill.getDeviceId());
//                        vWaterEveryMonth.setRowName(roomName);
//                        vWaterEveryMonth.setExt4(waterMonthBill.getTimeSection().substring(11,21)+"/"+end);
//                        vWaterEveryMonth.setExt(String.valueOf(waterMonthBill.getWaterCurrentUse()));
//                        vWaterEveryMonth.setTotalWater(after[2].toString());
//                        vWaterEveryMonth.setExt2(new DecimalFormat("######0.00").format(Double.parseDouble(after[2].toString()) - waterMonthBill.getWaterCurrentUse()));
//                        vWaterEveryMonth.setExt3(new DecimalFormat("######0.00").format(Double.parseDouble(vWaterEveryMonth.getExt2()) * Double.parseDouble(gxSysDicRecord.getDicName())));
//                        if(DateConverter.dateBefore(waterMonthBill.getTimeSection().substring(11,21),end)){
//                            vList.add(vWaterEveryMonth);
//                        }
//                        flog=true;
//                        break;
//                    }
//                }
//                for(int j = 0; j < allList.size(); j++){
//                    Object[] objects=(Object[]) allList.get(j);
//                    if(objects[0].toString().equals(after[0].toString())){
//                        allList.remove(objects);
//                        break;
//                    }
//                }
//                if(flog){
//                    continue;
//                }
//                VWaterEveryMonth vWaterEveryMonth = new VWaterEveryMonth();
//                vWaterEveryMonth.setvKey(String.valueOf(vList.size()+i+1));
//                vWaterEveryMonth.setDeviceId(after[0].toString());
//                vWaterEveryMonth.setRowName(after[1].toString());
//                vWaterEveryMonth.setTotalWater(after[2].toString());
//                vWaterEveryMonth.setExt(before[2].toString());
//                vWaterEveryMonth.setExt2(new DecimalFormat("######0.00").format(Double.parseDouble(after[2].toString()) - Double.parseDouble(before[2].toString())));
//                vWaterEveryMonth.setExt3(new DecimalFormat("######0.00").format(Double.parseDouble(vWaterEveryMonth.getExt2()) * Double.parseDouble(gxSysDicRecord.getDicName())));
//                vWaterEveryMonth.setExt4(sdf.format(before[3]) + "/" + sdf.format(after[3]));
//                vList.add(vWaterEveryMonth);
//            }
//////        }
//        for(int m = 0; m < allList.size(); m++){
//            Object[] objects=(Object[]) allList.get(m);
//            WaterMonthBill waterMonthBill=waterMonthBillManager.findUnique("from WaterMonthBill where deviceId=? order by localRecordTime desc",objects[0].toString());
//            VWaterEveryMonth vWaterEveryMonth = new VWaterEveryMonth();
//            vWaterEveryMonth.setvKey(String.valueOf(endList.size()+m+1));
//            vWaterEveryMonth.setDeviceId(objects[0].toString());
//            vWaterEveryMonth.setRowName(objects[1].toString());
//            if(waterMonthBill!=null){
//                vWaterEveryMonth.setExt(String.valueOf(waterMonthBill.getWaterCurrentUse()));
//                vWaterEveryMonth.setExt4(waterMonthBill.getTimeSection().substring(11,21)+"/"+end);
//            }
//            vList.add(vWaterEveryMonth);
//        }

        String fileName =start.replaceAll("-","")+"-"+end.replaceAll("-","")+"水结算账单";
        String[] monthColumnNameArr = {"deviceId","rowName","ext4","ext","totalWater","ext2","ext3"};
        metaMap.put("columnName", monthColumnNameArr);
        String[] columnComment = {"水表编号","房间号","抄表时间","上次抄表","本次抄表","已用水量","账单费用"};
        Integer[] columnWidth = {80,80,250,100,100,100,100};
        metaMap.put("columnWidth", columnWidth);
        metaMap.put("columnComment", columnComment);
        ExcelExportUtil excelExportUtil = new ExcelExportUtil(new ExcelDataNormalStrategy());
        try {
            excelExportUtil.exportBean(response, fileName,vList, metaMap);
        } catch (Exception e) {
            statusCode = "300";
            message = "导出失败-1 ";
            e.printStackTrace();
        }
        resMap.put("statusCode",statusCode);
        resMap.put("message",message);
        return resMap;
    }

    @RequestMapping("water-import")
    public String userImports(Model model) {
        return "sd/water/water-import";
    }

    @RequestMapping("import")
    @ResponseBody
    public	Map<String, Object> imports(@RequestParam MultipartFile file, Model model, HttpSession session) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        model.addAttribute("message", "File '" + file.getOriginalFilename());
        String fileOriginalName = file.getOriginalFilename();
        String statusCode = "200", message = "上传成功";
        String type=null;
        try {
            if (!StringUtils.isEmpty(fileOriginalName)) {
                if(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).equals(".xlsx")){
                    type="ByteArrayInputStream";
                }else if(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")).equals(".xls")){
                    type="FileInputStream";
                }
                FileUtil fileHelper = new FileUtil();
//                String decodeFileName = fileHelper.getDecodeFileName(fileOriginalName);// 文件名编码
                String mFilePath = session.getServletContext().getRealPath("") ; // 取得服务器路径
                mFilePath = mFilePath.substring(0, 2) + "\\jbxqycy" + "\\bill\\" + fileOriginalName;
                fileHelper.createFile(mFilePath, file.getBytes());
                resMap.put("fileUrl",mFilePath);
                file.getInputStream().close();

            }
        } catch (Exception e) {
            statusCode = "300";
            message = "上传失败";
            e.printStackTrace();
        }
        resMap.put("flog",false);
        resMap.put("type",type);
        resMap.put("statusCode", statusCode);
        resMap.put("message", message);
        return resMap;
    }

    @RequestMapping("import-save")
    public @ResponseBody
    Map<String, Object> UserSaveImport(@ModelAttribute("user_session") GxSysUser user,String fileUrl,String type) throws Exception {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        Workbook wb0=null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
        List<WaterMonthBill> waterMonthBillList=new ArrayList<>();
        List<WaterAccount> waterAccountList=new ArrayList<>();
        List<ElectricWaterReduction> electricWaterReductionList=new ArrayList<>();
        try {
            InputStream in= new FileInputStream(fileUrl);
            if(type.equals("ByteArrayInputStream")){
                wb0=new XSSFWorkbook(in);
            }else {
                wb0=new HSSFWorkbook(in);
            }
            Sheet sheet = wb0.getSheetAt(0);
            int n=0;
            for(Row row:sheet) {
                n++;
                if(n==1)continue;
                if(row.getCell(1)==null){
                    break;
                }
                for(int i=0;i<8;i++){
                    if(row.getCell(i)!=null&&row.getCell(i).getCellType()!=Cell.CELL_TYPE_STRING){
                        row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
                    }
                }
                String roomName=row.getCell(1).getStringCellValue();
                if(roomName.substring(roomName.length()-1).equals("4")){
                    String tt=roomName.substring(0,roomName.length()-1);
                    tt=tt+"3A";
                    roomName=tt;
                }
                WaterAccount waterAccount=waterAccountManager.findUniqueBy("roomName",roomName);
                WaterMonthBill waterMonthBill = new WaterMonthBill();                                                      //账单表
                waterMonthBill.setDeviceId(row.getCell(0).getStringCellValue());                                        //水表编号
                waterMonthBill.setRoomName(roomName);                                        //房间名
                waterMonthBill.setWaterMonthUse(Double.valueOf(row.getCell(5).getRichStringCellValue().toString()));    //月用量
                waterMonthBill.setWaterHistoryUse(Double.valueOf(row.getCell(3).getStringCellValue()));                 //上次抄表
                waterMonthBill.setWaterCurrentUse(Double.valueOf(row.getCell(4).getStringCellValue()));                 //本次抄表
                if(row.getCell(7)!=null&&row.getCell(7).getStringCellValue().equals("0000")){
                    waterMonthBill.setWaterMonthMoney(Double.valueOf("-"+0));                                              //月消费金额
                }else {
                    waterMonthBill.setWaterMonthMoney(Double.valueOf(row.getCell(6).getStringCellValue()==""?"0":row.getCell(6).getStringCellValue()));             //月消费金额
                }

                waterMonthBill.setWaterBeforeBalance(Double.valueOf(String.valueOf(waterAccount.getBalance())));           //上月结余
                waterMonthBill.setWaterBalance(waterAccount.getBalance()-waterMonthBill.getWaterMonthMoney());//余额
                Calendar calendar=Calendar.getInstance();
                calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(row.getCell(2).getStringCellValue().substring(11,21)));
                calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - 15);
                waterMonthBill.setTime(simpleDateFormat.format(calendar.getTime()));                                    //月账单时间(年月)
                waterMonthBill.setTimeSection(row.getCell(2).getStringCellValue());                                  //抄表时间段区间
                waterMonthBill.setLocalRecordTime(new Timestamp(new Date().getTime()));                                 //结算时间
                if(row.getCell(7)!=null&&row.getCell(7).getStringCellValue().equals("0000")){
                    waterAccount.setRecentReduceMoney(Double.valueOf("-"+0));                                                             //月消费金额
                }else {
                    waterAccount.setRecentReduceMoney(Double.parseDouble("-"+waterMonthBill.getWaterMonthMoney()));  //月消费金额
                }
                waterAccount.setRecentReduceTime(new Timestamp(new Date().getTime()));
                waterAccount.setBalance(waterMonthBill.getWaterBalance());
                waterMonthBillList.add(waterMonthBill);
                waterAccountList.add(waterAccount);

                ElectricWaterReduction electricWaterReduction=new ElectricWaterReduction();
                electricWaterReduction.setUserId(user.getUserId());
                electricWaterReduction.setType("1");
                electricWaterReduction.setTime(new Timestamp(new Date().getTime()));
                electricWaterReduction.setRoomName(roomName);
                electricWaterReduction.setMoney(String.valueOf(waterAccount.getRecentReduceMoney()));
                electricWaterReduction.setDeviceId(waterFloorRoomInDeviceManager.findUniqueBy("roomName",roomName).getDeviceId());
                electricWaterReductionList.add(electricWaterReduction);

            }
        } catch (Exception e) {
            statusCode = "300";
            message = "操作失败";
            e.printStackTrace();
            resMap.put("statusCode", statusCode);
            resMap.put("message", message);
            resMap.put("closeCurrent", true);
            return resMap;
        }
        for(WaterMonthBill waterMonthBill:waterMonthBillList){
            waterMonthBillManager.save(waterMonthBill);
        }
        for(WaterAccount waterAccount:waterAccountList){
            waterAccountManager.save(waterAccount);
        }
        for(ElectricWaterReduction electricWaterReduction:electricWaterReductionList){
            electricWaterReductionManager.save(electricWaterReduction);
        }
//        String all_mobile="";
        String PHONE_NUMBER_REG = "^(1[3-9])\\d{9}$";
        for(WxUserRoom wxUserRoom:wxUserRoomManager.getAll()){
            WaterAccount waterAccount=waterAccountManager.findUniqueBy("roomName",wxUserRoom.getRoomId());
//            boolean f =all_mobile.contains(wxUserRoom.getUserPhone());
            boolean flag = wxUserRoom.getUserPhone().matches(PHONE_NUMBER_REG);
//            all_mobile+=wxUserRoom.getUserPhone()+",";
//            if(!f&&flag&&waterAccount.getBalance()<0){
            if(flag&&waterAccount.getBalance()<0){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                String timestamp = sdf.format(new Date());
                String messageSign ="【8849人才公寓物业管理处】";
                String messageContent = "尊敬的"+wxUserRoom.getRoomId()+"业主您好,您的水费欠费请及时充值。";
                String content = messageSign+messageContent;
                if(wxUserRoom.getUserPhone()!=null){
                    SendMessageUtil.sendMessageBySpring(wxUserRoom.getUserPhone(),content);
                }
            }
        }
        resMap.put("statusCode", statusCode);
        resMap.put("message", message);
        resMap.put("closeCurrent", true);
//        resMap.put("divid", "user-manager-user-list1");
        return resMap;

    }

    @RequestMapping(value = "water-arrearage")
    public String waterArrearage(@ModelAttribute Page page,Model model,String roomName,String type) throws Exception{
        Map<String,Object> map=new HashMap<>();
        String typeSql="";
        if(type!=null&&type.equals("-1")){
            typeSql="and balance<0";
        }
        page.addOrder("roomName","asc");
        if(roomName==null||roomName.equals("")){
            page=waterAccountManager.pagedQuery("from WaterAccount where ext2 is null and dataOrder<=892 and dataOrder>=703 and roomName like 'C%'"+typeSql+"order by dataOrder",page.getPageCurrent(),page.getPageSize());
        }else{
            page=waterAccountManager.pagedQuery("from WaterAccount where ext2 is null and roomName like ?"+typeSql+" order by dataOrder",page.getPageCurrent(),page.getPageSize(),"%"+roomName+"%");
        }
        for(WaterAccount waterAccount:(List<WaterAccount>)page.getResult()){
            List<FloorRoomInDevice> floorRoomInDeviceList=floorRoomInDeviceManager.findBy("roomName",waterAccount.getRoomName());
            if(floorRoomInDeviceList.size()==0){
                map.put("filter_LIKES_roomName",waterAccount.getRoomName());
                List<PropertyFilter> propertyFilterList=PropertyFilter.buildFromMap(map);
                List<FloorRoomInDevice> floorRoomInDeviceListHasTwo=floorRoomInDeviceManager.find(propertyFilterList);
                double balance=0;
                for(FloorRoomInDevice floorRoomInDevice:floorRoomInDeviceListHasTwo){
                    balance+=Double.parseDouble(electricDayRecordManager.findBy("deviceId",floorRoomInDevice.getDeviceId()).get(0).getBalance());
                }
                waterAccount.setExt(String.valueOf(new DecimalFormat("0.00").format(balance)));
            }else {
                String elecBalance=electricDayRecordManager.findBy("deviceId",floorRoomInDeviceList.get(0).getDeviceId()).get(0).getBalance();
                waterAccount.setExt(elecBalance);
            }

        }
        DecimalFormat format = new DecimalFormat("0.00");
        String electricSum=electricDayRecordManager.findUnique("SELECT sum(balance) FROM ElectricDayRecord where device_id>=761 and device_id<=998");
        Double waterSum=waterAccountManager.findUnique("SELECT sum(balance) FROM WaterAccount where dataOrder<=892 and dataOrder>=703");
        model.addAttribute("electricSum",format.format(new BigDecimal(electricSum)));
        model.addAttribute("waterSum",waterSum);
        model.addAttribute("page",page);
        model.addAttribute("roomName",roomName);
        model.addAttribute("type",type);
        return "sd/water/water-arrearage-list";
    }

    @RequestMapping("balance-export")
    public @ResponseBody
    Map<String, Object> waterBalanceExport(String roomName,String type,HttpServletResponse response,Model model) throws Exception{
        String[] types = type.split(",");
        type = types[types.length - 1];
        String[] roomNames = roomName.split(",");
        if(roomNames.length==0){
            roomName=null;
        }else{
            roomName = roomNames[roomNames.length - 1];
        }
        Map<String,Object> map=new HashMap<>();
        Map<String, Object> resMap = new HashMap<String, Object>();
        Map<String, Object> metaMap = new HashMap<>();
        String statusCode = "200", message = "导出成功";
        List<WaterAccount> waterAccountList=null;
        String typeSql="";
        if(type!=null&&type.equals("-1")){
            typeSql="and balance<0";
        }
        if(roomName==null||roomName.equals("")){
            waterAccountList=waterAccountManager.find("from WaterAccount where ext2 is null and dataOrder<=892 and dataOrder>=703  and roomName like 'C%'"+typeSql+"order by dataOrder");
        }else{
            waterAccountList=waterAccountManager.find("from WaterAccount where ext2 is null and roomName like ?"+typeSql+" order by dataOrder","%"+roomName+"%");
        }

        for(WaterAccount waterAccount:waterAccountList){
            List<FloorRoomInDevice> floorRoomInDeviceList=floorRoomInDeviceManager.findBy("roomName",waterAccount.getRoomName());
            if(floorRoomInDeviceList.size()==0){
                map.put("filter_LIKES_roomName",waterAccount.getRoomName());
                List<PropertyFilter> propertyFilterList=PropertyFilter.buildFromMap(map);
                List<FloorRoomInDevice> floorRoomInDeviceListHasTwo=floorRoomInDeviceManager.find(propertyFilterList);
                double balance=0;
                for(FloorRoomInDevice floorRoomInDevice:floorRoomInDeviceListHasTwo){
                    balance+=Double.parseDouble(electricDayRecordManager.findBy("deviceId",floorRoomInDevice.getDeviceId()).get(0).getBalance());
                }
                waterAccount.setExt(String.valueOf(new DecimalFormat("0.00").format(balance)));
            }else {
                String elecBalance=electricDayRecordManager.findBy("deviceId",floorRoomInDeviceList.get(0).getDeviceId()).get(0).getBalance();
                waterAccount.setExt(elecBalance);
            }
        }

        String fileName =new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"_余额";
        String[] monthColumnNameArr = {"rowId","roomName","balance","ext"};
        metaMap.put("columnName", monthColumnNameArr);
        String[] columnComment = {"序号","房间号","水余额","电余额"};
        Integer[] columnWidth = {80,80,100,100};
        metaMap.put("columnWidth", columnWidth);
        metaMap.put("columnComment", columnComment);
        ExcelExportUtil excelExportUtil = new ExcelExportUtil(new ExcelDataNormalStrategy());
        try {
            excelExportUtil.exportBean(response, fileName,waterAccountList, metaMap);
        } catch (Exception e) {
            statusCode = "300";
            message = "导出失败-1 ";
            e.printStackTrace();
        }
        resMap.put("statusCode",statusCode);
        resMap.put("message",message);
        return resMap;
    }

    @RequestMapping("water-list")
    public String waterList(@ModelAttribute Page page,Model model, @RequestParam Map<String, Object> parameterMap){
        List<String> list=waterMonthBillManager.find("SELECT time FROM WaterMonthBill GROUP BY time order by time desc");
        if(!(parameterMap.size()==1||parameterMap.size()==5)){
            page=waterMonthBillManager.pagedQuery(page,PropertyFilter.buildFromMap(parameterMap));
        }
        model.addAttribute("page",page);
        model.addAttribute("stringList",list);
        return "sd/water/water-list";
    }

    @RequestMapping("bill-export")
    public @ResponseBody
    Map<String, Object> waterBillExport(HttpServletResponse response,@RequestParam Map<String, Object> parameterMap) throws Exception{
        Map<String, Object> resMap = new HashMap<String, Object>();
        Map<String, Object> metaMap = new HashMap<>();
        String statusCode = "200", message = "导出成功";
        List<WaterMonthBill> vList=waterMonthBillManager.find(PropertyFilter.buildFromMap(parameterMap));


        String fileName =parameterMap.get("filter_EQS_time")+"水月账单";
        String[] monthColumnNameArr = {"rowId","roomName","timeSection","waterHistoryUse","waterCurrentUse","waterMonthUse","waterMonthMoney"};
        metaMap.put("columnName", monthColumnNameArr);
        String[] columnComment = {"序号","房间号","抄表时间","上次抄表","本次抄表","已用水量","账单费用"};
        Integer[] columnWidth = {80,80,250,100,100,100,100};
        metaMap.put("columnWidth", columnWidth);
        metaMap.put("columnComment", columnComment);
        ExcelExportUtil excelExportUtil = new ExcelExportUtil(new ExcelDataNormalStrategy());
        try {
            excelExportUtil.exportBean(response, fileName,vList, metaMap);
        } catch (Exception e) {
            statusCode = "300";
            message = "导出失败-1 ";
            e.printStackTrace();
        }
        resMap.put("statusCode",statusCode);
        resMap.put("message",message);
        return resMap;
    }




    public void reduce(List endList,List startList){
        if(endList.size()!=startList.size()){
            int maxSize=endList.size()<startList.size()?startList.size():endList.size();
            boolean flog=endList.size()<startList.size();
            for(int m=0;m<maxSize;m++){
                Object[] before=(Object[])startList.get(m);
                Object[] after=(Object[])endList.get(m);
                if(!before[0].toString().equals(after[0].toString())){
                    if(flog){
                        startList.remove(before);
                        m--;
                        maxSize--;
                    }else {
                        endList.remove(after);
                        m--;
                        maxSize--;
                    }
                }
            }
        }
    }
    @RequestMapping("tt")
    public void dayList(){
        List<WaterFloorRoomInDevice> list=waterFloorRoomInDeviceManager.getAll();
        for(WaterFloorRoomInDevice waterFloorRoomInDevice:list){
            WaterAccount waterAccount=new WaterAccount();
            waterAccount.setRoomName(waterFloorRoomInDevice.getRoomName());
            waterAccountManager.save(waterAccount);
        }
        double t=10;
        double tt=55;
        System.out.println(tt/t);
    }
    /*
    *连续两月欠费断电
    */
    @RequestMapping("lackOfPowerInform")
    @Scheduled(cron ="0 0 0 14 * ?")
    public void lackOfPowerInform(){
        List<WxUserRoom> stringList=new ArrayList<>();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(new Date());//把当前时间赋给日历
        calendar.add(calendar.MONTH, -1);  //设置为前1月
        Date first = calendar.getTime();//获取1个月前的时间
        calendar.add(calendar.MONTH, -1);  //设置为前2月
        Date second=calendar.getTime();//获取2个月前的时间
        List<WxUserRoom> wxUserRoomList= wxUserRoomManager.getAll();
        for(WxUserRoom wxUserRoom:wxUserRoomList){
            Map<String, Object> parameterMap=new HashMap<>();
            parameterMap.put("filter_EQS_time",simpleDateFormat.format(first));
            parameterMap.put("filter_EQS_roomName",wxUserRoom.getRoomId());
            List<WaterMonthBill> waterMonthBillListFirst=waterMonthBillManager.find(PropertyFilter.buildFromMap(parameterMap));
            parameterMap.put("time",simpleDateFormat.format(second));
            List<WaterMonthBill> waterMonthBillListSecond=waterMonthBillManager.find(PropertyFilter.buildFromMap(parameterMap));
            WaterAccount waterAccount=waterAccountManager.findUniqueBy("roomName",wxUserRoom.getRoomId());
            if(waterMonthBillListFirst.size()!=0&&waterMonthBillListFirst.get(0).getWaterBeforeBalance()<0&&waterMonthBillListSecond.size()!=0&&waterMonthBillListSecond.get(0).getWaterBeforeBalance()<0&&waterAccount.getBalance()<0){
                stringList.add(wxUserRoom);
            }
        }
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "发送成功";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());
        String PHONE_NUMBER_REG = "^(1[3-9])\\d{9}$";
//        String all_mobile="";
        try {
            for (WxUserRoom wxUserRoom:stringList) {
//                boolean f =all_mobile.contains(wxUserRoom.getUserPhone());
                logger.info("-------------------业主您好,您的水费欠费请及时充值,如不及时充值将于明天下午5:30房间断电:"+wxUserRoom.getRoomId());
                boolean flag = wxUserRoom.getUserPhone().matches(PHONE_NUMBER_REG);
//                all_mobile+=wxUserRoom.getUserPhone()+",";
//                if(flag&&!f){
                if(flag){
                    String messageSign ="【8849人才公寓物业管理处】";
                    String messageContent = "尊敬的"+wxUserRoom.getRoomId()+"业主您好,您的水费欠费请及时充值,如不及时充值将于明天下午5:30房间断电。";
                    String content = messageSign+messageContent;
                    if(wxUserRoom.getUserPhone()!=null){
                        SendMessageUtil.sendMessageBySpring(wxUserRoom.getUserPhone(),content);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            statusCode = "300";
            message = "发送失败";
        }
        resMap.put("statusCode",statusCode);
        resMap.put("message",message);
    }

    @RequestMapping("lackOfPower")
    @Scheduled(cron ="0 30 17 15 * ?")
    public void lackOfPower(){
        List<WxUserRoom> stringList=new ArrayList<>();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(new Date());//把当前时间赋给日历
        calendar.add(calendar.MONTH, -1);  //设置为前2月
        Date first = calendar.getTime();//获取1个月前的时间
        calendar.add(calendar.MONTH, -1);  //设置为前2月
        Date second=calendar.getTime();//获取2个月前的时间
        List<WxUserRoom> wxUserRoomList= wxUserRoomManager.getAll();
        for(WxUserRoom wxUserRoom:wxUserRoomList){
            Map<String, Object> parameterMap=new HashMap<>();
            parameterMap.put("filter_EQS_time",simpleDateFormat.format(first));
            parameterMap.put("filter_EQS_roomName",wxUserRoom.getRoomId());
            List<WaterMonthBill> waterMonthBillListFirst=waterMonthBillManager.find(PropertyFilter.buildFromMap(parameterMap));
            parameterMap.put("time",simpleDateFormat.format(second));
            List<WaterMonthBill> waterMonthBillListSecond=waterMonthBillManager.find(PropertyFilter.buildFromMap(parameterMap));
            WaterAccount waterAccount=waterAccountManager.findUniqueBy("roomName",wxUserRoom.getRoomId());
            if(waterMonthBillListFirst.size()!=0&&waterMonthBillListFirst.get(0).getWaterBeforeBalance()<0&&waterMonthBillListSecond.size()!=0&&waterMonthBillListSecond.get(0).getWaterBeforeBalance()<0&&waterAccount.getBalance()<0){
                stringList.add(wxUserRoom);
            }
        }
        for(WxUserRoom wxUserRoom:stringList){
            VRoomDevice vRoomDevice=vRoomDeviceManager.findUniqueBy("rowName",wxUserRoom.getRoomId());
            List<NameValuePair> pairs = new ArrayList<NameValuePair>();
            NameValuePair pair1 = new BasicNameValuePair("deviceId",vRoomDevice.getDeviceId());
            pairs.add(pair1);
            NameValuePair pair2 = new BasicNameValuePair("action","2");        //1送电 2断电
            pairs.add(pair2);
            try{
                String result=HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/remoteControlDevices",pairs,"application/x-www-form-urlencoded");
                JSONObject jsonObject= JSON.parseObject(result);
                String code=jsonObject.getString("errcode");
                JSONObject jsonObject1=(JSONObject)jsonObject.get("data");
                JSONArray jsonArray=(JSONArray)jsonObject1.get("datas");
                if(code.equals("0")&&((JSONObject)jsonArray.get(0)).getString("success").equals("true")){
                    logger.info("-------------------连续欠水费断电:"+wxUserRoom.getRoomId());
                    DeviceOnAndOff deviceOnAndOff=deviceOnAndOffManager.findUniqueBy("deviceId",vRoomDevice.getDeviceId());
                    deviceOnAndOff.setOnAndOff("2");
                    deviceOnAndOffManager.save(deviceOnAndOff);
                }else {

                }
            }catch (Exception e){

            }

        }

    }

}
