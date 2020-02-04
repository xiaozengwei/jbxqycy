package com.gx.soft.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.net.ntp.TimeStamp;

import com.alibaba.fastjson.JSON;
import com.gx.soft.office.util.DateUtil;

public class Test {
	public static void main(String[] args) {
//		 将Base64位转换成HexString格式的公私钥
//		String publicKey = Util.base64ToHexString(PropertyUtil.clientPublicKey);
//		String privateKey = Util.base64ToHexString(PropertyUtil.clientPrivateKey);
		//通过证书路径得到公私钥
//		String pfxPath = "E:/CA/NJZJJ1质监特种设备审批CA.pfx";
//		try {
//			String publicKey = Util.getHexString(RSAEncrypt.loadPublicKeyByFile(pfxPath,"123456").getEncoded());
//			String privateKey = Util.getHexString(RSAEncrypt.loadPrivateKeyByFile(pfxPath,"123456").getEncoded());
//			System.out.println("publicKey:"+publicKey);
//			System.out.println("privateKey:"+privateKey);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String s = "10890";
//		System.out.println(s.substring(s.length() - 2));
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		System.out.println(sdf.format(new Date()));
//		System.out.println(DateUtil.getDateTime());
//		System.out.println(DateUtil.getDate().toString().substring(0, 19));
//		String fileName = "测试.txt";
//		int index = fileName.lastIndexOf(".");
//		fileName = fileName.substring(0, index);
//		System.out.println(fileName);
//		Timestamp ts = DateUtil.getDate();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("A", "shuaibilin");
//		map.put("B", ts);
//		String jsonString = JSON.toJSONString(map);
//		System.out.println(jsonString);
//		int l = PropertyUtil.hexStringPublicKey.length();
//		System.out.println(l);
//		String sha1 = "";
//		String[] str = {"nba", "abc", "cba", "zz", "qq", "haha"};
//		Arrays.sort(str);
//		for (int i = 0;i<str.length;i++){
//			sha1 += str[i];
//		}
//		System.out.println(sha1);
		String url = "http://watch.njitrip.cn/mobile/to-mobile-index.do";
		try {
			url = URLEncoder.encode(url,"utf-8");
			System.out.println(url);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		String s = ",123,123";
//		System.out.println(s.substring(1));

	}
}
