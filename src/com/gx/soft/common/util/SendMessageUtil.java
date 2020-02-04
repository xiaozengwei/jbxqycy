package com.gx.soft.common.util;

import com.alibaba.fastjson.JSON;
import com.gx.soft.common.wxpay.WXPayUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 发送短信工具类
 * @author ShuaiBiLin
 *
 */

public class SendMessageUtil {
	static Logger logger = Logger.getLogger(SendMessageUtil.class);
	protected SendMessageUtil(){
		
	}

	/**
	 * 发送短信
	 * @param mobile 手机号
	 * @param content 短信内容
	 */
	public static void sendMessage(String mobile, String content) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = sdf.format(new Date());
		try {
			Map<String, String> param = new HashMap<String, String>();
			param.put("userid", "273");//企业ID,273
			param.put("timestamp", timestamp);//时间戳，系统当前时间字符串，年月日时分秒
			String signStr = "nanjinglhcz"+"nanjinglhcz"+timestamp;
			String sign = WXPayUtil.MD5Lower(signStr);
			param.put("sign", sign);//签名，使用 账号+密码+时间戳 生成MD5字符串作为签名。MD5生成32位，且需要小写
			param.put("mobile", mobile);//全部被叫号码，多个号码之间用半角逗号隔开
			param.put("content", content);//发送内容，内容需要UTF-8编码
			param.put("sendTime", "");//定时发送时间，为空表示立即发送，定时发送格式2010-10-24 09:08:10
			param.put("action", "send");//发送任务命令，固定为：send
			param.put("extno", "");//扩展子号，请先询问配置的通道是否支持扩展子号，如果不支持，请填空。子号只能为数字，且最多6位数。
			String paramStr = JSON.toJSONString(param);
			String url = "http://47.96.185.189:8088/v2sms.aspx?action=send&userid=273&timestamp="+timestamp+"&sign="+sign+"&mobile="+mobile+"&content="+content+"&sendTime=&extno=";
			String response = HttpClient.sendHttpRequest(url, paramStr,"POST", "application/xml;charset=utf-8");
			Map<String, String> resMap = WXPayUtil.xmlToMap(response);
			logger.info("-------------------发送短信："+mobile+"----------"+resMap.get("message"));
			System.out.println(resMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送短信
	 * @param mobile 手机号
	 * @param content 短信内容
	 */
	public static void sendMessageBySpring(String mobile, String content) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = sdf.format(new Date());
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://47.96.185.189:8088/v2sms.aspx";
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			String signStr = "nanjinglhcz" + "nanjinglhcz" + timestamp;
			String sign = WXPayUtil.MD5Lower(signStr);
			map.add("userid", "273");
			map.add("timestamp", timestamp.toString());
			map.add("sign", sign);
			map.add("mobile", mobile);
			map.add("content", content);
			map.add("sendTime", "");
			map.add("action", "send");
			map.add("extno", "");
			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
			ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
			System.out.println(response.getBody());
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
