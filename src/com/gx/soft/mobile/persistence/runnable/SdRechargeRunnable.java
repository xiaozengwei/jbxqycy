package com.gx.soft.mobile.persistence.runnable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gx.soft.common.util.HttpClient;
import com.gx.soft.sd.persistence.domain.DeviceOnAndOff;
import com.gx.soft.sd.persistence.manager.DeviceOnAndOffManager;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SdRechargeRunnable implements Runnable {
    static Logger logger = Logger.getLogger(SdRechargeRunnable.class);
    private String deviceId;
    private DeviceOnAndOffManager deviceOnAndOffManager;


    public SdRechargeRunnable(String deviceId, DeviceOnAndOffManager deviceOnAndOffManager) {
        super();
        this.deviceId = deviceId;
        this.deviceOnAndOffManager = deviceOnAndOffManager;
    }

    @Override
    public void run() {
        DeviceOnAndOff deviceOnAndOff = deviceOnAndOffManager.findUniqueBy("deviceId", deviceId);
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        NameValuePair pair1 = new BasicNameValuePair("deviceId",deviceId);
        pairs.add(pair1);
        NameValuePair pair2 = new BasicNameValuePair("action","1");
        pairs.add(pair2);
        try{
            String result= HttpClient.sendHttpRequestPost("http://221.226.66.78:9000/api/emcs/remoteControlDevices",pairs,"application/x-www-form-urlencoded");
            JSONObject jsonObject= JSON.parseObject(result);
            String code=jsonObject.getString("errcode");
            JSONObject jsonObject1=(JSONObject)jsonObject.get("data");
            JSONArray jsonArray=(JSONArray)jsonObject1.get("datas");
            if(code.equals("0")&&((JSONObject)jsonArray.get(0)).getString("success").equals("true")){
                deviceOnAndOff.setOnAndOff("1");
                deviceOnAndOffManager.save(deviceOnAndOff);
                logger.info("----------------------------电费充值完成-------送电完成------------设备ID："+deviceId);
            }else {
                //合闸失败
                logger.info("----------------------------电费充值完成-------送电失败------------设备ID："+deviceId);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
