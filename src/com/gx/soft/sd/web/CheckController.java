package com.gx.soft.sd.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gx.core.hibernate.PropertyFilter;
import com.gx.core.page.Page;
import com.gx.core.util.Md5Utils;
import com.gx.soft.common.util.HttpClient;
import com.gx.soft.sd.persistence.domain.*;
import com.gx.soft.sd.persistence.manager.*;
import com.gx.soft.sys.persistence.domain.GxSysUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("user_session")
@RequestMapping("check")
public class CheckController {
    static Logger logger = Logger.getLogger(CheckController.class);
    @Autowired
    private CheckOutAmountRecordManager checkOutAmountRecordManager;
    @Autowired
    private WxUserRoomManager wxUserRoomManager;
    @Autowired
    private FloorRoomInDeviceManager floorRoomInDeviceManager;
    @Autowired
    private ElectricWaterReductionManager electricWaterReductionManager;
    @Autowired
    private ElectricDayRecordManager electricDayRecordManager;
    @Autowired
    private DeviceOnAndOffManager deviceOnAndOffManager;


    @RequestMapping("check-out-amount-record")
    public String checkOutReduce(@ModelAttribute Page page, Model model, @RequestParam Map<String, Object> parameterMap){
        page.addOrder("time","desc");
        page = checkOutAmountRecordManager.pagedQuery(page, PropertyFilter.buildFromMap(parameterMap));
        model.addAttribute("page",page);
        return "sd/check/check-out-amount-record";
    }

    @RequestMapping("check-out-amount-input")
    public String checkOutInput(@ModelAttribute Page page, Model model,String roomName)throws Exception{
        FloorRoomInDevice roomInDevice = floorRoomInDeviceManager.findUniqueBy("roomName", roomName);
        if(roomInDevice==null){
            return "";
        }
        String deviceId = roomInDevice.getDeviceId();
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        NameValuePair pair3 = new BasicNameValuePair("deviceId",deviceId);
        pairs.add(pair3);
        String result= HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getEnergyInfoForRealTime",pairs,"application/x-www-form-urlencoded");
        logger.info("实时电量: "+result);
        JSONObject jsonObject=null;
        String money="";
        try {
            jsonObject= JSON.parseObject(result);
        }catch (Exception e){
            result=HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getEnergyInfoForRealTime",pairs,"application/x-www-form-urlencoded");
            jsonObject=JSON.parseObject(result);
        }finally {
            Object code = jsonObject.get("errcode");
            if (code.toString().equals("0")) {
                if (!jsonObject.get("data").toString().equals("null")) {
                    JSONObject jsonObject1 = (JSONObject) jsonObject.get("data");
                    JSONArray jsonArray = (JSONArray) jsonObject1.get("datas");
                    JSONObject js = (JSONObject) jsonArray.get(0);
                    money=js.get("balance")!=null?js.getString("balance").toString():"";
                }
            }
        }
        WxUserRoom wxUserRoom= wxUserRoomManager.findUniqueBy("roomId",roomName);
        CheckOutAmountRecord checkOutAmountRecord=new CheckOutAmountRecord();
        if(wxUserRoom!=null){
            checkOutAmountRecord.setUserName(wxUserRoom.getUserName());
            checkOutAmountRecord.setUserIdCard(wxUserRoom.getUserIdCard());
            checkOutAmountRecord.setUserPhone(wxUserRoom.getUserPhone());
        }
        checkOutAmountRecord.setRoomName(roomName);
        checkOutAmountRecord.setElectricBalance(money);
        model.addAttribute("checkOutAmountRecord",checkOutAmountRecord);
        return "sd/check/check-out-amount-input";
    }

    @RequestMapping("check-reduce")
    public @ResponseBody
    Map<String, Object> checkReduce(CheckOutAmountRecord checkOutAmountRecord){
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "保存成功";
        double refundMoney=Double.parseDouble(checkOutAmountRecord.getElectricBalance())-Double.parseDouble(checkOutAmountRecord.getWaterMoney());
        refundMoney=new BigDecimal(refundMoney).setScale(2, RoundingMode.HALF_UP).doubleValue();
        checkOutAmountRecord.setRefundMoney(String.valueOf(refundMoney));
        checkOutAmountRecord.setTime(new Timestamp(new Date().getTime()));
        if(refundMoney>0){
            checkOutAmountRecord.setStatus("1");
        }else {
            checkOutAmountRecord.setStatus("2");
        }
        checkOutAmountRecordManager.save(checkOutAmountRecord);
        resMap.put("statusCode", statusCode);
        resMap.put("message", message);
        resMap.put("closeCurrent", true);
        resMap.put("reload", true);
        return resMap;
    }

    @RequestMapping("refund-complete")
    public @ResponseBody
    Map<String, Object> refundComplete(@ModelAttribute("user_session") GxSysUser user,String roomName,String rowId) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        String statusCode = "200", message = "操作成功";
        boolean reload = true;
        try {
            FloorRoomInDevice floorRoomInDevice=floorRoomInDeviceManager.findUniqueBy("roomName",roomName);
            String deviceId=floorRoomInDevice.getDeviceId();
            String balance="0";
            List<NameValuePair> pairs1 = new ArrayList<NameValuePair>();
            NameValuePair pair33 = new BasicNameValuePair("deviceId",deviceId);
            pairs1.add(pair33);
            String result1= HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getEnergyInfoForRealTime",pairs1,"application/x-www-form-urlencoded");
            logger.info("实时电量: "+result1);
            JSONObject jsonObject22=null;
            try {
                jsonObject22= JSON.parseObject(result1);
            }catch (Exception e){
                result1=HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/getEnergyInfoForRealTime",pairs1,"application/x-www-form-urlencoded");
                jsonObject22=JSON.parseObject(result1);
            }finally {
                Object code = jsonObject22.get("errcode");
                if (code.toString().equals("0")) {
                    if (!jsonObject22.get("data").toString().equals("null")) {
                        JSONObject jsonObject1 = (JSONObject) jsonObject22.get("data");
                        JSONArray jsonArray = (JSONArray) jsonObject1.get("datas");
                        JSONObject js = (JSONObject) jsonArray.get(0);
                        balance=js.get("balance")!=null?js.getString("balance").toString():"";
                    }
                }
            }
            balance=String.valueOf(Double.parseDouble(balance)-0.02);
            DecimalFormat format = new DecimalFormat("0.00");
            balance=format.format(new BigDecimal(balance));
            //调用接口充值
            if(Double.parseDouble(balance)>=0.02){
                List<NameValuePair> pairs = new ArrayList<NameValuePair>();
                NameValuePair pair1 = new BasicNameValuePair("deviceId",deviceId);
                NameValuePair pair2 = new BasicNameValuePair("money",balance);
                NameValuePair pair3 = new BasicNameValuePair("actionType","1");
                NameValuePair pair4 = new BasicNameValuePair("ipAddress","192.168.50.23");
                NameValuePair pair5 = new BasicNameValuePair("secret", Md5Utils.getMd5UpperCase(deviceId+balance+"tiansu"));
                pairs.add(pair1);
                pairs.add(pair2);
                pairs.add(pair3);
                pairs.add(pair4);
                pairs.add(pair5);
                String result= HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/rechargeDevices",pairs,"application/x-www-form-urlencoded;charset=utf-8");
                JSONObject jsonObject= JSON.parseObject(result);
                JSONObject data = (JSONObject) jsonObject.get("data");
                JSONArray jsonArray= data.getJSONArray("datas");
                String success=((JSONObject)jsonArray.get(0)).getString("success");
                if(success.equals("true")) {
                    ElectricWaterReduction electricWaterReduction= new ElectricWaterReduction();
                    electricWaterReduction.setDeviceId(deviceId);
                    electricWaterReduction.setMoney("-"+balance);
                    electricWaterReduction.setRoomName(roomName);
                    electricWaterReduction.setTime(new Timestamp(new Date().getTime()));
                    electricWaterReduction.setUserId(user.getUserId());
                    electricWaterReduction.setType("0");
                    electricWaterReductionManager.save(electricWaterReduction);

                    DeviceOnAndOff deviceOnAndOff=deviceOnAndOffManager.findUniqueBy("deviceId",deviceId);
                    deviceOnAndOff.setOnAndOff("2");
                    deviceOnAndOff.setActionTime(new Timestamp(new Date().getTime()));
                    deviceOnAndOffManager.save(deviceOnAndOff);

                    ElectricDayRecord electricDayRecord=electricDayRecordManager.findUniqueBy("deviceId",deviceId);
                    electricDayRecord.setBalance("0.02");
                    electricDayRecordManager.save(electricDayRecord);
                }else {
                    statusCode = "300";
                    message = "扣费失败";
                    reload = false;
                }
            }
            CheckOutAmountRecord checkOutAmountRecord=checkOutAmountRecordManager.get(rowId);
            if(checkOutAmountRecord.getStatus().equals("1")){
                checkOutAmountRecord.setStatus("0");
            }else if(checkOutAmountRecord.getStatus().equals("2")){
                checkOutAmountRecord.setStatus("3");
            }
            checkOutAmountRecordManager.save(checkOutAmountRecord);
        } catch (Exception e) {
            statusCode = "300";
            message = "操作失败";
            reload = false;
        }
        resMap.put("statusCode", statusCode);
        resMap.put("message", message);
        resMap.put("reload", reload);
        return resMap;
    }
}
