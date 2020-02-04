package com.gx.soft.sd.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gx.core.export.ExcelDataNormalStrategy;
import com.gx.core.export.ExcelExportUtil;
import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.mapper.BeanMapper;
import com.gx.core.page.Page;
import com.gx.core.util.Md5Utils;
import com.gx.core.util.StringUtils;
import com.gx.soft.common.util.HttpClient;
import com.gx.soft.sd.persistence.domain.*;
import com.gx.soft.sd.persistence.manager.*;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import com.gx.soft.sys.persistence.manager.SysUserManager;
import com.gx.soft.sys.vo.ZtreeData;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("electric")
@SessionAttributes("user_session")
public class ElectricController {
    static Logger logger = Logger.getLogger(ElectricController.class);
    @Autowired
    private ElectricDayRecordManager electricDayRecordManager;
    @Autowired
    private ElectricHistoryRecordManager electricHistoryRecordManager;
    @Autowired
    private ElectricMonthRecordManager electricMonthRecordManager;
    @Autowired
    private FloorRoomInDeviceManager floorRoomInDeviceManager;
    @Autowired
    private FloorRoomManager floorRoomManager;
    @Autowired
    private VRoomDeviceManager vRoomDeviceManager;
    @Autowired
    private DeviceOnAndOffManager deviceOnAndOffManager;
    @Autowired
    private SysUserManager userManager;
    @Autowired
    private ElectricEveryDayRecordManager electricEveryDayRecordManager;
    @Autowired
    private VRoomDeviceMonthEnergyManager vRoomDeviceMonthEnergyManager;
    @Autowired
    private VRoomDeviceEveryDayEnergyManager vRoomDeviceEveryDayEnergyManager;
    @Autowired
    private ElectricWaterReductionManager electricWaterReductionManager;
    @Autowired
    private WaterAccountManager waterAccountManager;
    @Autowired
    private VRoomDeviceCopyManager vRoomDeviceCopyManager;
    private BeanMapper beanMapper = new BeanMapper();

    @RequestMapping("t2")
    @ResponseBody
    public List<VRoomDeviceCopy>t2(){
        return vRoomDeviceCopyManager.getAll();
    }
    /**
     * 获取楼层设备相关信息，返回给小程序
     **/
    @RequestMapping("t1")
    @ResponseBody
    public List<VFloor> t1() {
        List<FloorRoom> floorRoomList = floorRoomManager.findBy("pFloorId", "1");
        List<VFloor> vFloorList = new ArrayList<>();
        for (FloorRoom f : floorRoomList) {
            vFloorList.add(new VFloor(f.getRowName(), true, f.getRowId()));
        }
        List<FloorRoom> floorRoomList1 = floorRoomManager.getAll();
        List<VRoomDeviceCopy> floorRoomInDevices = vRoomDeviceCopyManager.getAll();
        for (VFloor f : vFloorList) {
//            List<Map<String,List<FloorRoomInDevice>>>children=new ArrayList<>();
            List<VFloorRoomDev> children = new ArrayList<>();
            for (FloorRoom f1 : floorRoomList1) {
                List<Vfrm> vfrms = new ArrayList<>();
                if (f.getId().equals(f1.getpFloorId())) {
                    String name = f1.getRowName();
                    for (FloorRoom f2 : floorRoomList1) {
                        if (f2.getpFloorId().equals(f1.getRowId())) {
                            for (VRoomDeviceCopy f3 : floorRoomInDevices) {
                                if (f3.getRoomId().equals(f2.getRowId())) {
                                    Vfrm v = new Vfrm();
                                    beanMapper.copy(f3, v);
                                    v.setText(f3.getRowName());
                                    v.setBol(f3.getOnAndOff());
                                    v.setId(f3.getvKey());
//                                    v.setBol(String.valueOf(deviceOnAndOffManager.get(f3.getDeviceId()).getOnAndOff()));
                                    vfrms.add(v);
                                }
                            }
                        }
                    }
                    VFloorRoomDev vFloorRoomDev = new VFloorRoomDev(name, vfrms);

                    children.add(vFloorRoomDev);
                }
            }
            Collections.sort(children, new Comparator<VFloorRoomDev>() {
                @Override
                public int compare(VFloorRoomDev o1, VFloorRoomDev o2) {
                    int diff = Integer.valueOf(o1.getText().split("层")[0]) - Integer.valueOf(o2.getText().split("层")[0]);
                    if (diff > 0) {
                        return 1;
                    } else if (diff < 0) {
                        return -1;
                    }
                    return 0;
                }
            });
            f.setChildren(children);
        }
        return vFloorList;
    }

    /*
        楼层信息
    */
    @RequestMapping(value = "floorRoom", method = RequestMethod.GET, produces = "application/json")
    public void floorRoom() {
        String result = HttpClient.sendHttpRequest("http://221.226.66.78:9000/api/emcs/getRoomAndFloor", "", "POST", "application/json;charset=utf-8");
        JSONObject jsonObject = JSON.parseObject(result);
        Object code = jsonObject.get("errcode");
        if (code.toString().equals("0")) {
            JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
            JSONObject jsonObject2 = (JSONObject) jsonObject1.get("datas");
            FloorRoom floorRoom = new FloorRoom();
            floorRoom.setRowId(jsonObject2.get("id") != null ? jsonObject2.getString("id").toString() : "");
            floorRoom.setRowName(jsonObject2.get("name") != null ? jsonObject2.getString("name").toString() : "");
            floorRoom.setpFloorId(jsonObject2.get("parentId") != null ? jsonObject2.getString("parentId").toString() : "");
            floorRoom.setFloorType("0");
            floorRoomManager.save(floorRoom);
            JSONArray jsonArray = (JSONArray) jsonObject2.get("children");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject js = (JSONObject) jsonArray.get(i);
                floorRoom.setRowId(js.get("id") != null ? js.getString("id").toString() : "");
                floorRoom.setRowName(js.get("name") != null ? js.getString("name").toString() : "");
                floorRoom.setpFloorId(js.get("parentId") != null ? js.getString("parentId").toString() : "");
                floorRoom.setpFloorName(jsonObject2.get("name") != null ? jsonObject2.getString("name").toString() : "");
                floorRoom.setFloorType("1");
                floorRoomManager.save(floorRoom);
                JSONArray jsonArray1 = (JSONArray) js.get("children");
                for (int j = 0; j < jsonArray1.size(); j++) {
                    JSONObject floorJs = (JSONObject) jsonArray1.get(j);
                    floorRoom.setRowId(floorJs.get("id") != null ? floorJs.getString("id").toString() : "");
                    floorRoom.setRowName(floorJs.get("name") != null ? floorJs.getString("name").toString() : "");
                    floorRoom.setpFloorId(floorJs.get("parentId") != null ? floorJs.getString("parentId").toString() : "");
                    floorRoom.setpFloorName(js.get("name") != null ? js.getString("name").toString() : "");
                    floorRoom.setFloorType("2");
                    floorRoomManager.save(floorRoom);

                    JSONArray jsonArray2 = (JSONArray) floorJs.get("children");
                    for (int m = 0; m < jsonArray2.size(); m++) {
                        JSONObject roomJs = (JSONObject) jsonArray2.get(m);
                        floorRoom.setRowId(roomJs.get("id") != null ? roomJs.getString("id").toString() : "");
                        floorRoom.setRowName(roomJs.get("name") != null ? roomJs.getString("name").toString() : "");
                        floorRoom.setpFloorId(roomJs.get("parentId") != null ? roomJs.getString("parentId").toString() : "");
                        floorRoom.setpFloorName(floorJs.get("name") != null ? floorJs.getString("name").toString() : "");
                        floorRoom.setFloorType("3");
                        floorRoomManager.save(floorRoom);
                    }
                }
            }
        }
    }

    /*
        房间--电表关联
    */
    @Scheduled(cron = "0 0 0/2 * * ?")
    @RequestMapping(value = "deviceInRoom", method = RequestMethod.GET, produces = "application/json")
    public void deviceInRoom() {
        String result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getRoomAndDevice", "", "POST", "application/json;charset=utf-8");
        logger.info("房间--电表关联: " + result);
        JSONObject jsonObject = null;
        try {
            jsonObject = JSON.parseObject(result);
        } catch (Exception e) {
            result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getRoomAndDevice", "", "POST", "application/json;charset=utf-8");
            jsonObject = JSON.parseObject(result);
        } finally {
            Object code = jsonObject.get("errcode");
            if (code.toString().equals("0")) {
                JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
                JSONArray jsonArray = (JSONArray) jsonObject1.get("datas");
                if (floorRoomInDeviceManager.getCount() < jsonArray.size()) {
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject js = (JSONObject) jsonArray.get(i);
                        FloorRoomInDevice floorRoomInDevice = new FloorRoomInDevice();
                        String roomId = js.get("roomId") != null ? js.getString("roomId").toString() : "";
                        String roomName = js.get("roomName") != null ? js.getString("roomName").toString() : "";
                        String deviceId = js.get("deviceId") != null ? js.getString("deviceId").toString() : "";
                        String deviceName = js.get("deviceName") != null ? js.getString("deviceName").toString() : "";
                        String startDate = js.get("startDate") != null ? js.getString("startDate").toString() : "";
                        floorRoomInDevice.setRoomId(roomId);
                        floorRoomInDevice.setRoomName(roomName);
                        floorRoomInDevice.setDeviceId(deviceId);
                        floorRoomInDevice.setDeviceName(deviceName);
                        floorRoomInDevice.setStartDate(new Timestamp(Long.parseLong(startDate)));
                        floorRoomInDeviceManager.save(floorRoomInDevice);
                    }
                }
            }
        }
    }

    /*
       电表合闸分闸状态--2小时
   */
    @Scheduled(cron = "0 0 0/2 * * ?")
    @RequestMapping(value = "deviceOnAndOff", method = RequestMethod.GET, produces = "application/json")
    public void deviceOnAndOff() {

        String result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getAllDeviceControlStatus", "", "POST", "application/json;charset=utf-8");
        logger.info("电表合闸分闸状: " + result);
        JSONObject jsonObject = null;
        try {
            jsonObject = JSON.parseObject(result);
        } catch (Exception e) {
            result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getAllDeviceControlStatus", "", "POST", "application/json;charset=utf-8");
            jsonObject = JSON.parseObject(result);
        } finally {
            Object code = jsonObject.get("errcode");
            if (code.toString().equals("0")) {
                JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
                JSONArray jsonArray = (JSONArray) jsonObject1.get("datas");
                String actionTime = jsonObject1.getString("actionTime");
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject js = (JSONObject) jsonArray.get(i);
                    DeviceOnAndOff deviceOnAndOff = new DeviceOnAndOff();
                    deviceOnAndOff.setDeviceId(js.get("deviceId") != null ? js.getString("deviceId") : "");
                    deviceOnAndOff.setOnAndOff(js.get("onAndOff") != null ? js.getString("onAndOff") : "");
                    deviceOnAndOff.setActionTime(new Timestamp(Long.parseLong(actionTime)));
                    deviceOnAndOffManager.save(deviceOnAndOff);
                }
            }
        }
    }

    /*
        实时电量--历史电量------2小时
    */
    @Scheduled(cron = "0 0 0/2 * * ?")
    @RequestMapping(value = "record", method = RequestMethod.GET, produces = "application/json")
    public void electricRecord() throws Exception {
        Timestamp localRecord = new Timestamp(new Date().getTime());
//      String result=HttpClient.sendHttpRequest("http://221.226.66.78:9000/api/emcs/getEnergyInfoForRealTime",JSON.toJSONString(param),"POST","application/x-www-form-urlencoded");
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        NameValuePair pair3 = new BasicNameValuePair("deviceId", "all");
        pairs.add(pair3);
        String result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getEnergyInfoForRealTime", pairs, "application/x-www-form-urlencoded");
        logger.info("实时电量: " + result);
        JSONObject jsonObject = null;
        try {
            jsonObject = JSON.parseObject(result);
        } catch (Exception e) {
            result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getEnergyInfoForRealTime", pairs, "application/x-www-form-urlencoded");
            jsonObject = JSON.parseObject(result);
        } finally {
            Object code = jsonObject.get("errcode");
            if (code.toString().equals("0")) {
                if (!jsonObject.get("data").toString().equals("null")) {
                    JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
                    JSONArray jsonArray = (JSONArray) jsonObject1.get("datas");
                    if (jsonArray.size() != 0) {
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject js = (JSONObject) jsonArray.get(i);
                            String deviceId = js.get("deviceId") != null ? js.getString("deviceId").toString() : "";
                            String totalEnergy = js.get("totalEnergy") != null ? js.getString("totalEnergy").toString() : "";
                            String tipEnergy = js.get("tipEnergy") != null ? js.getString("tipEnergy").toString() : "";
                            String peakEnergy = js.get("peakEnergy") != null ? js.getString("peakEnergy").toString() : "";
                            String valleyEnergy = js.get("valleyEnergy") != null ? js.getString("valleyEnergy").toString() : "";
                            String flatEnergy = js.get("flatEnergy") != null ? js.getString("flatEnergy").toString() : "";
                            String balance = js.get("balance") != null ? js.getString("balance").toString() : "";
                            String timeRecord = jsonObject1.get("actionTime") != null ? jsonObject1.getString("actionTime").toString() : "";
                            java.sql.Date date = new java.sql.Date(new Date().getTime());
                            //实时
                            ElectricDayRecord electricDayRecord = new ElectricDayRecord();
                            electricDayRecord.setDeviceId(deviceId);
                            electricDayRecord.setTotalEnergy(totalEnergy);
                            electricDayRecord.setTipEnergy(tipEnergy);
                            electricDayRecord.setPeakEnergy(peakEnergy);
                            electricDayRecord.setValleyEnergy(valleyEnergy);
                            electricDayRecord.setFlatEnergy(flatEnergy);
                            electricDayRecord.setBalance(balance);
                            electricDayRecord.setTime(date);
                            electricDayRecord.setTimeLocalRecord(localRecord);
                            if (localRecord.getHours() == 0) {
                                Map<String, Object> map = new HashMap<>();
                                map.put("filter_EQS_deviceId", deviceId);
                                map.put("filter_GED_time", new java.sql.Date(new Date().getTime() - 3600000) + " 00:00:00");
                                map.put("filter_LED_time", new java.sql.Date(new Date().getTime() - 3600000) + " 23:59:59");
                                List<ElectricEveryDayRecord> list = electricEveryDayRecordManager.find(PropertyFilter.buildFromMap(map));
                                if (list != null && list.size() != 0) {
                                    ElectricEveryDayRecord before = list.get(0);
                                    before.setTotalEnergyEnd(totalEnergy);
                                    electricEveryDayRecordManager.save(before);
                                }

                                ElectricEveryDayRecord electricEveryDayRecord = new ElectricEveryDayRecord();
                                electricEveryDayRecord.setDeviceId(deviceId);
                                electricEveryDayRecord.setTotalEnergyStart(totalEnergy);
                                electricEveryDayRecord.setTipEnergy(tipEnergy);
                                electricEveryDayRecord.setPeakEnergy(peakEnergy);
                                electricEveryDayRecord.setValleyEnergy(valleyEnergy);
                                electricEveryDayRecord.setFlatEnergy(flatEnergy);
                                electricEveryDayRecord.setBalance(balance);
                                electricEveryDayRecord.setTime(new java.sql.Date(new Date().getTime()));
                                electricEveryDayRecord.setLocalRecordTime(localRecord);
                                electricDayRecordManager.save(electricEveryDayRecord);
                            }
                            electricDayRecordManager.save(electricDayRecord);
                            long endTime = System.currentTimeMillis();    //获取结束时间
                            //历史
                            ElectricHistoryRecord electricHistoryRecord = new ElectricHistoryRecord();
                            electricHistoryRecord.setRowId(null);
                            electricHistoryRecord.setDeviceId(deviceId);
                            electricHistoryRecord.setTotalEnergy(totalEnergy);
                            electricHistoryRecord.setTipEnergy(tipEnergy);
                            electricHistoryRecord.setPeakEnergy(peakEnergy);
                            electricHistoryRecord.setValleyEnergy(valleyEnergy);
                            electricHistoryRecord.setFlatEnergy(flatEnergy);
                            electricHistoryRecord.setBalance(balance);
                            electricHistoryRecord.setTime(localRecord);
                            electricHistoryRecord.setTimeLocalRecord(localRecord);
                            electricHistoryRecordManager.save(electricHistoryRecord);
                            //月初值
//                        if(localRecord.getDay()==1&&localRecord.getHours()==0){
//                            ElectricMonthRecord electricMonthRecord=new ElectricMonthRecord();
//                            electricMonthRecord.setRowId(null);
//                            electricMonthRecord.setDeviceId(floorRoomInDevice.getDeviceId());
//                            electricMonthRecord.setTotalEnergy(totalEnergy);
//                            electricMonthRecord.setTipEnergy(tipEnergy);
//                            electricMonthRecord.setPeakEnergy(peakEnergy);
//                            electricMonthRecord.setFlatEnergy(flatEnergy);
//                            electricMonthRecord.setValleyEnergy(valleyEnergy);
//                            electricMonthRecord.setBalance(balance);
//                            electricMonthRecord.setTime(new SimpleDateFormat("yyyy-MM").format(localRecord));
//                        }
                        }
                    }
                }
            }
        }


    }


    /*
        历史月耗电量---------按月定时
    */
    @Scheduled(cron = "0 0 23 28 * ?")
    @RequestMapping(value = "month", method = RequestMethod.GET, produces = "application/json")
    public void monthInput() throws Exception {
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        NameValuePair pair1 = new BasicNameValuePair("deviceId", "all");
        pairs.add(pair1);
        Date date = new Date();
//        date.setMonth(date.getMonth()-1);
        NameValuePair pair2 = new BasicNameValuePair("queryDate", new SimpleDateFormat("yyyy-MM").format(date));
//        NameValuePair pair2 = new BasicNameValuePair("queryDate","2019-05");

        pairs.add(pair2);
        String result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getEnergyInfoForHistory", pairs, "application/x-www-form-urlencoded");
        logger.info("历史月耗电量: " + result);
        JSONObject jsonObject = null;
        try {
            jsonObject = JSON.parseObject(result);
        } catch (Exception e) {
            result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getEnergyInfoForHistory", pairs, "application/x-www-form-urlencoded");
            jsonObject = JSON.parseObject(result);
        } finally {
            Object code = jsonObject.get("errcode");
            if (code.toString().equals("0")) {
                if (!jsonObject.get("data").toString().equals("null")) {
                    JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
                    JSONArray jsonArray = (JSONArray) jsonObject1.get("datas");
                    if (jsonArray.size() != 0) {
                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject js = (JSONObject) jsonArray.get(i);
                            ElectricMonthRecord electricMonthRecord = new ElectricMonthRecord();
                            electricMonthRecord.setRowId(null);
                            electricMonthRecord.setDeviceId(js.get("deviceId") != null ? js.getString("deviceId").toString() : "");
                            electricMonthRecord.setTotalEnergyStart(js.get("totalStartReading") != null ? js.getString("totalStartReading").toString() : "");
                            electricMonthRecord.setTotalEnergyEnd(js.get("totalEndReading") != null ? js.getString("totalEndReading").toString() : "");
                            electricMonthRecord.setMonthEnergy(js.get("totalEnergy") != null ? js.getString("totalEnergy").toString() : "");
                            electricMonthRecord.setTipEnergy(js.get("tipEnergy") != null ? js.getString("tipEnergy").toString() : "");
                            electricMonthRecord.setPeakEnergy(js.get("peakEnergy") != null ? js.getString("peakEnergy").toString() : "");
                            electricMonthRecord.setValleyEnergy(js.get("valleyEnergy") != null ? js.getString("valleyEnergy").toString() : "");
                            electricMonthRecord.setFlatEnergy(js.get("flatEnergy") != null ? js.getString("flatEnergy").toString() : "");
                            electricMonthRecord.setBalance(js.get("balance") != null ? js.getString("balance").toString() : "");
                            electricMonthRecord.setTime(new SimpleDateFormat("yyyy-MM").format(date));
//                            electricMonthRecord.setTime("2019-05");
                            electricMonthRecordManager.save(electricMonthRecord);
                        }
                    }
                }
            }
        }

    }

    /*
    合闸/分闸控制
    */
    @RequestMapping(value = "electric-control", produces = "application/json")
    public
    @ResponseBody
    Map<String, Object> control(boolean checked, String deviceId) throws Exception {
        Map<String, Object> resMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        DeviceOnAndOff deviceOnAndOff = deviceOnAndOffManager.findUniqueBy("deviceId", deviceId);
        if (checked) {
            deviceOnAndOff.setOnAndOff("1");
        } else {
            deviceOnAndOff.setOnAndOff("2");
        }

        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        NameValuePair pair1 = new BasicNameValuePair("deviceId", deviceId);
        pairs.add(pair1);
        NameValuePair pair2 = new BasicNameValuePair("action", deviceOnAndOff.getOnAndOff());        //1送电 2断电
        pairs.add(pair2);
        try {
            String result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/remoteControlDevices", pairs, "application/x-www-form-urlencoded");
            JSONObject jsonObject = JSON.parseObject(result);
            String code = jsonObject.getString("errcode");
            JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
            JSONArray jsonArray = (JSONArray) jsonObject1.get("datas");
            if (code.equals("0") && ((JSONObject) jsonArray.get(0)).getString("success").equals("true")) {
                deviceOnAndOffManager.save(deviceOnAndOff);
            } else {
                deviceOnAndOffManager.save(deviceOnAndOff);
                statusCode = "300";
                message = "操作失败";
                checked = checked ? false : true;
            }
        } catch (Exception e) {
            statusCode = "300";
            message = "操作失败";
        }
        resMap.put("statusCode", statusCode);
        resMap.put("message", message);
        resMap.put("checked", checked);
        return resMap;
    }

    @RequestMapping("electric-device-room-page")
    public String deviceRoomPage() {
        return "sd/electric/electric-device-room-page";
    }

    @RequestMapping(value = "floor-room-tree", produces = "application/json")
    public
    @ResponseBody
    List<ZtreeData> orgTree(@RequestParam Map<String, Object> parameterMap,
                            Model model) {
        List<PropertyFilter> propertyFilters = PropertyFilter
                .buildFromMap(parameterMap);
        List<FloorRoom> floorRoomList = floorRoomManager.find("pFloorName", true, propertyFilters);
        List<ZtreeData> ztreeData = new ArrayList<ZtreeData>();
        for (FloorRoom floorRoom : floorRoomList) {
            ZtreeData zData = new ZtreeData(String.valueOf(floorRoom.getRowId()),
                    String.valueOf(floorRoom.getpFloorId()), floorRoom.getRowName(), floorRoom.getpFloorName());
            ztreeData.add(zData);
        }
        return ztreeData;
    }

    @RequestMapping("electric-device-list")
    public String electricDeviceList(@ModelAttribute Page page, Model model, String rowId) {
        Map<String, Object> map = new HashMap<>();
        map.put("filter_EQS_rowId", rowId);
        List<PropertyFilter> propertyFilters = new PropertyFilter().buildFromMap(map);
        page = vRoomDeviceManager.pagedQuery(page, propertyFilters);
        model.addAttribute("page", page);
        model.addAttribute("rowId", rowId);
        return "sd/electric/electric-device-list";
    }

/*
* 房间绑定
* */
//    @RequestMapping("user-room")
//    public String deviceUserList(@ModelAttribute Page page,Model model,String roomId){
//        Map<String,Object> map=new HashMap<>();
//        map.put("filter_EQS_rowId",roomId);
//        List<PropertyFilter> propertyFilters =new PropertyFilter().buildFromMap(map);
//        page= vRoomUserManager.pagedQuery(page,propertyFilters);
//        model.addAttribute("page",page);
//        model.addAttribute("roomId",roomId);
//        return "sd/electric/electric-device-user-list";
//    }
//
//    @RequestMapping("device-removeUser")
//    public @ResponseBody
//    Map<String, Object> deviceRemoveUser(String rowId) {
//        Map<String, Object> resMap = new HashMap<String, Object>();
//        String statusCode = "200", message = "删除成功";
//        try {
//            electricUserInRoomManager.remove(electricUserInRoomManager.findUniqueBy("roomId",rowId));
//        } catch (Exception e) {
//            statusCode = "300";
//            message = "删除失败";
//            e.printStackTrace();
//        }
//        resMap.put("statusCode", statusCode);
//        resMap.put("message", message);
//        resMap.put("reload", true);
//        return resMap;
//    }

//    @RequestMapping("user-room-input")
//    public String deviceInput(Model model,String userMobileNum,String roomId){
//        Map<String, Object> parameterMap=new HashMap<>();
//        ElectricUserInRoom electricUserInRoom=null;
//        if(userMobileNum==null){
//            electricUserInRoom = new ElectricUserInRoom();
//        }else {
//            parameterMap.put("filter_EQS_userMobileNum",userMobileNum);
//            parameterMap.put("filter_EQS_roomId",roomId);
//            electricUserInRoom = electricUserInRoomManager.find(new PropertyFilter().buildFromMap(parameterMap)).get(0);
//        }
//
//        model.addAttribute("model",electricUserInRoom);
//        model.addAttribute("roomId",roomId);
//        return "sd/electric/electric-device-user-input";
//    }

//    @RequestMapping("user-room-save")
//    public @ResponseBody
//    Map<String, Object> deviceUserSave(@ModelAttribute("user_session") GxSysUser user, ElectricUserInRoom electricUserInRoom) {
//        Map<String, Object> resMap = new HashMap<String, Object>();
//        String statusCode = "200", message = "保存成功";
//        boolean closeCurrent = true;
//        ElectricUserInRoom dest = null;
//        String rowId = electricUserInRoom.getRowId();
//        try{
//            if(rowId != null && rowId.length() > 0){
//                dest = electricUserInRoomManager.get(rowId);
//                beanMapper.copy(electricUserInRoom, dest);
//                dest.setModifyTime(new Timestamp(new Date().getTime()));
//                dest.setModifyUserId(user.getUserId());
//            }else{
//                dest = electricUserInRoom;
//                dest.setRowId(null);
//                dest.setCreateUserId(user.getUserId());
//                dest.setCreateTime(new Timestamp(new Date().getTime()));
//            }
//            electricUserInRoomManager.save(dest);
//        }catch (Exception e) {
//            // TODO: handle exception
//            statusCode = "300";
//            closeCurrent = false;
//            message = "保存失败！";
//            e.printStackTrace();
//        }
//        resMap.put("statusCode", statusCode);
//        resMap.put("message", message);
//        resMap.put("closeCurrent", closeCurrent);
//        return resMap;
//    }

//    @RequestMapping("lookup-user-list")
//    public String deviceRoomLookupList(@ModelAttribute Page page,
//                                       @RequestParam Map<String, Object> parameterMap, Model model) {
//        List<PropertyFilter> propertyFilters = PropertyFilter
//                .buildFromMap(parameterMap);
//        page = userManager.pagedQuery(page, propertyFilters);
//        List<GxSysUser> vUsers = (List<GxSysUser>) page.getResult();
//        page.setResult(vUsers);
//        model.addAttribute("page", page);
//        return "sd/electric/electric-device-list-lookup";
//    }

    @RequestMapping("electric-month-list")
    public String list(@ModelAttribute Page page, Model model, @RequestParam Map<String, Object> parameterMap, String deviceId) throws Exception {
        parameterMap.put("filter_EQS_deviceId", deviceId);
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page.addOrder("time", "desc");
        page = electricMonthRecordManager.pagedQuery(page, propertyFilters);
        List<ElectricMonthRecord> list=(List<ElectricMonthRecord>)page.getResult();
        for(ElectricMonthRecord electricMonthRecord:list){
            electricMonthRecord.setFlatEnergy(floorRoomInDeviceManager.findBy("deviceId",deviceId).get(0).getRoomName());
        }
        model.addAttribute("page", page);

        return "sd/electric/electric-month-list";
    }

    @RequestMapping("electric-day-list")
    public String dayList(@ModelAttribute Page page, Model model, @RequestParam Map<String, Object> parameterMap, String deviceId) throws Exception {
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        NameValuePair pair3 = new BasicNameValuePair("deviceId", deviceId);
        pairs.add(pair3);
        String result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getEnergyInfoForRealTime", pairs, "application/x-www-form-urlencoded");
        logger.info("实时电量: " + result);
        JSONObject jsonObject = null;
        String money = "";
        try {
            jsonObject = JSON.parseObject(result);
        } catch (Exception e) {
            result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getEnergyInfoForRealTime", pairs, "application/x-www-form-urlencoded");
            jsonObject = JSON.parseObject(result);
        } finally {
            Object code = jsonObject.get("errcode");
            if (code.toString().equals("0")) {
                if (!jsonObject.get("data").toString().equals("null")) {
                    JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
                    JSONArray jsonArray = (JSONArray) jsonObject1.get("datas");
                    JSONObject js = (JSONObject) jsonArray.get(0);
                    money = js.get("balance") != null ? js.getString("balance").toString() : "";
                }
            }
        }
        parameterMap.put("filter_EQS_deviceId", deviceId);
        List<PropertyFilter> propertyFilters = PropertyFilter.buildFromMap(parameterMap);
        page = electricDayRecordManager.pagedQuery(page, propertyFilters);
        List<ElectricDayRecord> list = (List<ElectricDayRecord>) page.getResult();
        for (ElectricDayRecord electricDayRecord : list) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -1);
            parameterMap.put("filter_EQS_time", new SimpleDateFormat("yyyy-MM").format(calendar.getTime()));
            List<ElectricMonthRecord> waterMonthRecordList = electricMonthRecordManager.find(PropertyFilter.buildFromMap(parameterMap));
            if (waterMonthRecordList == null && waterMonthRecordList.size() == 0) {
                electricDayRecord.setExt(electricDayRecord.getTotalEnergy());
            } else {
                String beforeWater = waterMonthRecordList.get(0).getTotalEnergyEnd();
                if (!money.equals("")) electricDayRecord.setBalance(money);
                electricDayRecord.setExt(String.valueOf(new DecimalFormat("0.00").format(Double.parseDouble(electricDayRecord.getTotalEnergy()) - Double.parseDouble(beforeWater))));
            }
            electricDayRecord.setFlatEnergy(floorRoomInDeviceManager.findBy("deviceId",deviceId).get(0).getRoomName());
        }
        model.addAttribute("page", page);
        return "sd/electric/electric-day-list";
    }


    /*
    * 充值
    * */
//    @RequestMapping("recharge-devices-input")
//    public String rechargeDevices(Model model,String vKey,String opt){
//        VRoomDevice vRoomDevice=vRoomDeviceManager.get(vKey);
//        model.addAttribute("balance",electricDayRecordManager.get(vRoomDevice.getDeviceId()).getBalance());
//        model.addAttribute("model",vRoomDevice);
//        model.addAttribute("opt",opt);
//        return "sd/electric/electric-recharge-input";
//    }


//    @RequestMapping("recharge-save")
//    public @ResponseBody
//    Map<String, Object> rechargeSave(@ModelAttribute("user_session") GxSysUser user, String money,String deviceId,String opt){
//        Map<String, Object> resMap = new HashMap<String, Object>();
//        String statusCode = "200", message = "保存成功";
//        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
//        NameValuePair pair1 = new BasicNameValuePair("deviceId",deviceId);
//        NameValuePair pair2 = new BasicNameValuePair("money",String.format("%.2f", Double.parseDouble(money)));
//        NameValuePair pair3 = new BasicNameValuePair("actionType",opt.equals("recharge")?"0":"1");
//        NameValuePair pair4 = new BasicNameValuePair("ipAddress","192.168.50.23");
//        NameValuePair pair5 = new BasicNameValuePair("secret",Md5Utils.getMd5UpperCase(deviceId+String.format("%.2f", Double.parseDouble(money))+"tiansu"));
//        pairs.add(pair1);
//        pairs.add(pair2);
//        pairs.add(pair3);
//        pairs.add(pair4);
//        pairs.add(pair5);
//        try {
//            String result=HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/rechargeDevices",pairs,"application/x-www-form-urlencoded;charset=utf-8");
//            JSONObject jsonObject=JSON.parseObject(result);
//            JSONObject data = (JSONObject) jsonObject.get("data");
//            JSONArray jsonArray= data.getJSONArray("datas");
//            String success=((JSONObject)jsonArray.get(0)).getString("success");
//            if(success.equals("true")) {
//                ElectricDayRecord electricDayRecord=electricDayRecordManager.findUniqueBy("deviceId",deviceId);
//                ElectricRechargeRecord rechargeRecord=new ElectricRechargeRecord();
//                rechargeRecord.setRowId(null);
//                rechargeRecord.setDeviceId(deviceId);
//                if(!opt.equals("recharge")){
//                    electricDayRecord.setBalance(String.format("%.2f", Double.parseDouble(electricDayRecord.getBalance())-Double.parseDouble(String.format("%.2f",Double.parseDouble(money)))));
//                    rechargeRecord.setRechargeMoney("-"+money);
//                }else {
//                    electricDayRecord.setBalance(String.format("%.2f", Double.parseDouble(electricDayRecord.getBalance())+Double.parseDouble(String.format("%.2f",Double.parseDouble(money)))));
//                    rechargeRecord.setRechargeMoney(money);
//                }
//                rechargeRecord.setTime(new Timestamp(new Date().getTime()));
//                electricRechargeRecordManager.save(rechargeRecord);
//                electricDayRecordManager.save(electricDayRecord);
//            }else {
//                statusCode = "300";
//                message = opt.equals("recharge")?"充值":"扣费" +"失败！";
//            }
//        }catch (Exception e){
//            statusCode = "300";
//            message = opt.equals("recharge")?"充值":"扣费" +"失败！";
//        }
//        resMap.put("statusCode", statusCode);
//        resMap.put("message", message);
//        resMap.put("closeCurrent", true);
//        return resMap;
//    }

    @RequestMapping("electric-bill-list")
    public String electricBillList(@ModelAttribute Page page, Model model, @RequestParam Map<String, Object> parameterMap, String type) throws Exception {
        if (type != null && type.equals("0")) {
            if (parameterMap.get("ged") != null && !parameterMap.get("ged").toString().equals("") && parameterMap.get("led") != null && !parameterMap.get("led").equals("") && !parameterMap.get("led").toString().equals("")) {
                ArrayList<String> result = betweenMonth(parameterMap.get("ged").toString(), parameterMap.get("led").toString());
                parameterMap.put("filter_INS_time", StringUtils.join(result, ","));
//                parameterMap.put("ged",null);
//                parameterMap.put("led",null);
//                page.addOrder("rowId","desc");
                page.addOrder("settleTypeOut", "asc");
                page.addOrder("time", "desc");
                page = vRoomDeviceMonthEnergyManager.pagedQuery(page, PropertyFilter.buildFromMap(parameterMap));
            }
        } else {
            if (parameterMap.get("ged1") != null && !parameterMap.get("ged1").equals("") && parameterMap.get("led1") != null && !parameterMap.get("led1").equals("") && !parameterMap.get("led1").toString().equals("") && !new SimpleDateFormat("yyyy-MM-dd").parse(parameterMap.get("led1").toString()).before(new SimpleDateFormat("yyyy-MM-dd").parse(parameterMap.get("ged1").toString()))) {
                Page page1 = new Page();
                beanMapper.copy(page, page1);
                Map<String, Object> map = new HashMap<>();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                if (format.parse(parameterMap.get("ged1").toString()).before(format.parse("2019-08-28"))) {
                    parameterMap.put("ged1", "2019-08-28");
                }
                map.put("filter_GED_time", parameterMap.get("ged1").toString());
                map.put("filter_LED_time", parameterMap.get("ged1").toString());
                map.put("filter_LIKES_rowName", parameterMap.get("filter_LIKES_rowName"));
                page.addOrder("settleTypeOut", "asc");
                page1.addOrder("rowName", "desc");
//                page1.addOrder("deviceId","asc");
                page1.addOrder("time", "desc");
                page1 = vRoomDeviceEveryDayEnergyManager.pagedQuery(page, PropertyFilter.buildFromMap(map));
                List<VRoomDeviceEveryDayEnergy> list1 = (List<VRoomDeviceEveryDayEnergy>) page1.getResult();

                map.put("filter_GED_time", parameterMap.get("led1").toString());
                map.put("filter_LED_time", parameterMap.get("led1").toString());
                page.addOrder("settleTypeOut", "asc");
                page.addOrder("rowName", "desc");
//                page1.addOrder("deviceId","asc");
                page.addOrder("time", "desc");
                page = vRoomDeviceEveryDayEnergyManager.pagedQuery(page, PropertyFilter.buildFromMap(map));
                List<VRoomDeviceEveryDayEnergy> list = (List<VRoomDeviceEveryDayEnergy>) page.getResult();
                for (int i = 0; i < list.size(); i++) {
                    VRoomDeviceEveryDayEnergy after = list.get(i);
                    VRoomDeviceEveryDayEnergy before = list1.get(i);
                    after.setTotalEnergyStart(new DecimalFormat("######0.00").format(Double.parseDouble(before.getTotalEnergyStart())));
                    after.setExt(before.getTime() + "/" + after.getTime());
                }
//                page.addOrder();
            }
        }
        model.addAttribute("param", parameterMap);
        model.addAttribute("page", page);
        model.addAttribute("type", type);
        return "sd/electric/electric-bill-list";
    }

    @RequestMapping("export")
    public
    @ResponseBody
    Map<String, Object> export(HttpServletResponse response, String type, @RequestParam Map<String, Object> parameterMap) throws Exception {
        String[] strings = type.split(",");
        type = strings[strings.length - 1];
        Map<String, Object> resMap = new HashMap<String, Object>();
        Map<String, Object> metaMap = new HashMap<>();
        String statusCode = "200", message = "导出成功";
        String fileName = "账单";
        List<VRoomDeviceEveryDayEnergy> everyDayEnergyList = new ArrayList<>();
        List<VRoomDeviceMonthEnergy> monthEnergyList = new ArrayList<>();
        List<VRoomDeviceEveryDayEnergy> resultList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Object startTime = parameterMap.get("ged");   //年月(月账单)
        Object endTime = parameterMap.get("led");
        Object startTime1 = parameterMap.get("ged1");  //年月日(自定义)
        Object endTime1 = parameterMap.get("led1");
        Object rowName = parameterMap.get("filter_LIKES_rowName");
        if (type.equals("0")) {
            if (startTime != null && !startTime.toString().equals("") && endTime != null && !endTime.toString().equals("")) {
                Map<String, Object> map = new HashMap<>();
                ArrayList<String> result = betweenMonth(startTime.toString(), endTime.toString());
                map.put("filter_LIKES_rowName", rowName.toString());
                map.put("filter_INS_time", StringUtils.join(result, ","));
                monthEnergyList = vRoomDeviceMonthEnergyManager.find("rowId", true, PropertyFilter.buildFromMap(map));
                String[] monthColumnNameArr = {"rowName", "time", "totalEnergyStart", "totalEnergyEnd", "monthEnergy", "ext", "balance", "settleTypeName"};
                metaMap.put("columnName", monthColumnNameArr);
            }
        } else {
            if (startTime1 != null && !startTime1.toString().equals("") && endTime1 != null && !endTime1.toString().equals("") && (sdf.parse(startTime1.toString()).before(sdf.parse(endTime1.toString()))) || (endTime1 != null && !endTime1.toString().equals("") && endTime1.toString().equals(startTime1.toString()))) {
                Map<String, Object> map = new HashMap<>();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                if (format.parse(startTime1.toString()).before(format.parse("2019-08-28"))) {
                    parameterMap.put("ged1", "2019-08-28");
                    startTime1 = parameterMap.get("ged1");
                }
                map.put("filter_GED_time", startTime1.toString());
                map.put("filter_LED_time", startTime1.toString());
                map.put("filter_LIKES_rowName", rowName.toString());
                List<VRoomDeviceEveryDayEnergy> list1 = vRoomDeviceEveryDayEnergyManager.find("rowName", true, PropertyFilter.buildFromMap(map));

                map.put("filter_GED_time", endTime1.toString());
                map.put("filter_LED_time", endTime1.toString());
                List<VRoomDeviceEveryDayEnergy> list = vRoomDeviceEveryDayEnergyManager.find("rowName", true, PropertyFilter.buildFromMap(map));
                for (int i = 0; i < list.size(); i++) {
                    VRoomDeviceEveryDayEnergy after = list.get(i);
                    VRoomDeviceEveryDayEnergy before = list1.get(i);
                    after.setTotalEnergyStart(before.getTotalEnergyStart());
                    after.setExt(before.getTime() + "/" + after.getTime());
                    resultList.add(after);
                }
                String[] monthColumnNameArr = {"rowName", "time", "totalEnergyStart", "totalEnergyEnd", "ext", "ext", "balance", "settleTypeName"};
                metaMap.put("columnName", monthColumnNameArr);
            }
        }

//        String[] dayColumnNameArr = {"rowName", "ext","earlyTime","lastTime","userType","orgName"};
        String[] columnComment = {"房间号", "抄表时间", "上次抄表", "本次抄表", "已用电量", "账单费用", "余额", "模式"};
        Integer[] columnWidth = {100, 250, 100, 100, 100, 100, 100};
        metaMap.put("columnWidth", columnWidth);
        metaMap.put("columnComment", columnComment);
        ExcelExportUtil excelExportUtil = new ExcelExportUtil(new ExcelDataNormalStrategy());
        try {
            if (type.equals("0")) {
                excelExportUtil.exportBean1(response, fileName, monthEnergyList, metaMap);
            } else {
                excelExportUtil.exportBean2(response, fileName, resultList, metaMap);
            }
        } catch (Exception e) {
            statusCode = "300";
            message = "导出失败-1 ";
            e.printStackTrace();
        }
        resMap.put("statusCode", statusCode);
        resMap.put("message", message);
        return resMap;
    }

    /*
    *   日期之间全部月份
    * */
    public ArrayList<String> betweenMonth(String before, String after) {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();
            min.setTime(sdf.parse(before));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
            max.setTime(sdf.parse(after));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
            Calendar curr = min;
            while (curr.before(max)) {
                result.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /*
    * 测试电表充值761-1002,C3-C15
    * */
//    @RequestMapping("rechargetest")
//    public void rechargeTest(){
//        List<VRoomDevice> list=vRoomDeviceManager.find("from VRoomDevice where device_id>=761 and device_id<=1002");
//        List<String> list1=new ArrayList<>();
//        for(VRoomDevice vRoomDevice:list){
//            List<NameValuePair> pairs = new ArrayList<NameValuePair>();
//            NameValuePair pair1 = new BasicNameValuePair("deviceId",vRoomDevice.getDeviceId());
//            NameValuePair pair2 = new BasicNameValuePair("money","0.02");
//            NameValuePair pair3 = new BasicNameValuePair("actionType","1");
//            NameValuePair pair4 = new BasicNameValuePair("ipAddress","192.168.50.23");
//            NameValuePair pair5 = new BasicNameValuePair("secret",Md5Utils.getMd5UpperCase(vRoomDevice.getDeviceId()+"0.02"+"tiansu"));
//            pairs.add(pair1);
//            pairs.add(pair2);
//            pairs.add(pair3);
//            pairs.add(pair4);
//            pairs.add(pair5);
//            try {
//                String result=HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/rechargeDevices",pairs,"application/x-www-form-urlencoded;charset=utf-8");
//                JSONObject jsonObject=JSON.parseObject(result);
//                JSONObject data = (JSONObject) jsonObject.get("data");
//                JSONArray jsonArray= data.getJSONArray("datas");
//                String success=((JSONObject)jsonArray.get(0)).getString("success");
//                if(success.equals("true")) {
//                }else {
//                    list1.add(vRoomDevice.getDeviceId());
//                }
//                Thread.sleep(1000);
//            }catch (Exception e){
//                list1.add(vRoomDevice.getDeviceId());
//            }
//        }
//        for(String str:list1){
//            System.out.println(str);
//        }
//    }
/*
* 合闸/分闸
* */
//    @RequestMapping("controlAll")
//    public void dayList(){
////        Map<String,Object> map=new HashMap<>();
////        map.put("filter_EQS_deviceId","100");
////        map.put("filter_GED_time",new java.sql.Date(new Date().getTime())+" 00:00:00");
////        map.put("filter_LED_time",new java.sql.Date(new Date().getTime())+" 23:59:59");
////        List<ElectricDayRecord> list=(List<ElectricDayRecord>)electricDayRecordManager.find(PropertyFilter.buildFromMap(map));
////        for(ElectricDayRecord record:list){
////            record.getTotalEnergy();
////        }
////        for(int i=0;i<1436;i++){
////            ElectricEveryDayRecord electricEveryDayRecord=new ElectricEveryDayRecord();
////            electricEveryDayRecord.setRowId(null);
////            electricEveryDayRecordManager.save(electricEveryDayRecord);
////        }
//        List<VRoomDevice> list=vRoomDeviceManager.find("from VRoomDevice where device_id>=761 and device_id<=1002");
//        List<String> list1=new ArrayList<>();
//        for(VRoomDevice vRoomDevice:list){
//            List<NameValuePair> pairs = new ArrayList<NameValuePair>();
//            NameValuePair pair1 = new BasicNameValuePair("deviceId",vRoomDevice.getDeviceId());
//            pairs.add(pair1);
//            NameValuePair pair2 = new BasicNameValuePair("action","1");
//            pairs.add(pair2);
//            try{
//                String result=HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/remoteControlDevices",pairs,"application/x-www-form-urlencoded");
//                JSONObject jsonObject=JSON.parseObject(result);
//                String code=jsonObject.getString("errcode");
//                JSONObject jsonObject1=(JSONObject)jsonObject.get("data");
//                JSONArray jsonArray=(JSONArray)jsonObject1.get("datas");
//                if(code.equals("0")&&((JSONObject)jsonArray.get(0)).getString("success").equals("true")){
//                    DeviceOnAndOff deviceOnAndOff=new DeviceOnAndOff();
//                    deviceOnAndOff.setDeviceId(vRoomDevice.getDeviceId());
//                    deviceOnAndOff.setOnAndOff("1");
//                    deviceOnAndOff.setActionTime(new Timestamp(new Date().getTime()));
//                    deviceOnAndOffManager.save(deviceOnAndOff);
//                }else {
//                    list1.add(vRoomDevice.getDeviceId());
//                }
//                Thread.sleep(300);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        if(list1.size()>0){
//            for(String str:list1){
//                System.out.println(str);
//            }
//        }else {
//            System.out.println("everything is ok");
//        }
//    }

    @RequestMapping("electric-water-reduction")
    public String reduction(@ModelAttribute Page page, Model model, @RequestParam Map<String, Object> parameterMap, String roomName) throws Exception {
        page.addOrder("time", "desc");
        page = electricWaterReductionManager.pagedQuery(page, PropertyFilter.buildFromMap(parameterMap));
        model.addAttribute("page", page);
        return "sd/electric-water-reduction-list";
    }

    @RequestMapping("reduce-input")
    public String reduceInput(Model model, String type) throws Exception {
        model.addAttribute("type", type);
        return "sd/reduce-input";
    }

    @RequestMapping("reduce")
    public
    @ResponseBody
    Map<String, Object> rechargeSave(@ModelAttribute("user_session") GxSysUser user, String money, String roomName, String type) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "保存成功";
        FloorRoomInDevice floorRoomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", roomName);
        WaterAccount waterAccount = waterAccountManager.findUniqueBy("roomName", roomName);
        if (type.equals("water") && waterAccount != null) {
            ElectricWaterReduction electricWaterReduction = new ElectricWaterReduction();
            electricWaterReduction.setMoney("-" + money);
            electricWaterReduction.setRoomName(roomName);
            electricWaterReduction.setTime(new Timestamp(new Date().getTime()));
            electricWaterReduction.setUserId(user.getUserId());
            electricWaterReduction.setType("1");
            electricWaterReductionManager.save(electricWaterReduction);

            waterAccount.setRecentReduceTime(new Timestamp(new Date().getTime()));
            waterAccount.setRecentReduceMoney(Double.parseDouble("-" + money));
            waterAccount.setBalance(waterAccount.getBalance() - Double.parseDouble(money));
            waterAccountManager.save(waterAccount);

        } else if (type.equals("electric") && floorRoomInDevice != null && !floorRoomInDevice.equals("")) {
            String deviceId = floorRoomInDevice.getDeviceId();
            List<NameValuePair> pairs = new ArrayList<NameValuePair>();
            NameValuePair pair1 = new BasicNameValuePair("deviceId", deviceId);
            NameValuePair pair2 = new BasicNameValuePair("money", String.format("%.2f", Double.parseDouble(money)));
            NameValuePair pair3 = new BasicNameValuePair("actionType", "1");
            NameValuePair pair4 = new BasicNameValuePair("ipAddress", "192.168.50.23");
            NameValuePair pair5 = new BasicNameValuePair("secret", Md5Utils.getMd5UpperCase(deviceId + String.format("%.2f", Double.parseDouble(money)) + "tiansu"));
            pairs.add(pair1);
            pairs.add(pair2);
            pairs.add(pair3);
            pairs.add(pair4);
            pairs.add(pair5);
            try {
                String result = HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/rechargeDevices", pairs, "application/x-www-form-urlencoded;charset=utf-8");
                JSONObject jsonObject = JSON.parseObject(result);
                JSONObject data = (JSONObject) jsonObject.get("data");
                JSONArray jsonArray = data.getJSONArray("datas");
                String success = ((JSONObject) jsonArray.get(0)).getString("success");
                if (success.equals("true")) {
                    ElectricWaterReduction electricWaterReduction = new ElectricWaterReduction();
                    electricWaterReduction.setDeviceId(deviceId);
                    electricWaterReduction.setMoney("-" + money);
                    electricWaterReduction.setRoomName(roomName);
                    electricWaterReduction.setTime(new Timestamp(new Date().getTime()));
                    electricWaterReduction.setUserId(user.getUserId());
                    electricWaterReduction.setType("0");
                    electricWaterReductionManager.save(electricWaterReduction);

                    ElectricDayRecord electricDayRecord = electricDayRecordManager.findUniqueBy("deviceId", deviceId);
                    Double beforeBalance = Double.parseDouble(electricDayRecord.getBalance());
                    electricDayRecord.setBalance(new DecimalFormat("######0.00").format(beforeBalance - Double.parseDouble(money)));
                    electricDayRecordManager.save(electricDayRecord);
                } else {
                    statusCode = "300";
                    message = "账户余额不足，扣费失败！";
                }
            } catch (Exception e) {
                statusCode = "300";
                message = "账户余额不足，扣费失败！";
            }
        } else {
            statusCode = "300";
            message = "未找到该房间！";
        }
        resMap.put("statusCode", statusCode);
        resMap.put("message", message);
        resMap.put("closeCurrent", true);
        resMap.put("reload", true);

        return resMap;
    }


}
