package com.gx.soft.common.util;

import java.security.interfaces.RSAPublicKey;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;


/**
 * 房产使用的工具类，提供通用方法。
 * 
 * @method
 * 方法列表：
 * 加解
 * 解密
 * 签名
 * 验签
 * 
 * @author hyy
 *
 */


public class EncryptUtil {
	
	//日志打印
	public static final Logger log = Logger.getLogger(EncryptUtil.class);
	
	/**
	 * 将字符串加密并且把原文和密文返回
	 * @param plainText 原文
	 * @return {"cipher":"密文","plainText":"原文"}
	 */
	public static Map<String,String> encrypt(String plainText,String publicKeyStr){
		Map<String,String> returnMap = new HashMap<String, String>();
		log.debug("");
		byte[] cipherData;
		String cipher = "";
		try {
			//用对方提供的公钥进行加密
			RSAPublicKey publicKey = RSAEncrypt.loadPublicKeyByStr(publicKeyStr);
			cipherData = RSAEncrypt.encrypt(publicKey,plainText.getBytes("UTF-8"));
			cipher=Util.getHexString(cipherData);
//			returnMap.put("publicKey", publicKeyStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("plainText:"+plainText);
		log.info("cipher:"+cipher);
		returnMap.put("cipher", cipher);
		returnMap.put("plainText", plainText);
		return returnMap;
	}
	
	/**
	 * 解密，返回解密后的明文
	 * @param cipher(密文)
	 * @param privateKey(私钥)
	 * @return
	 */
	public static String decrypt(String cipher, String privateKey){
		byte[] res;
		String restr = "";
		log.info("privateKey:" + privateKey);
		try {
			//使用自己的私钥解密
			res = RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(privateKey), Util.hexToByte(cipher));
			restr=new String(res,"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug (System.getProperty ("os.name"));
		log.info("cipher:"+cipher);
		log.info("restr:"+restr);
		return restr;
	}
	
	/**
	 * 签名，对字符串进行签名，并返回签名后的字符串、签名前的字符串和用于验签的公钥
	 * @param content 需要签名的字符串
	 * @return
	 */
	public static Map<String,String> signStr(String content, String pfxPath){
		Map<String,String> returnMap = new HashMap<String, String>();
		String signStr = "";
		try{
			//获取自己的公钥，用作返回
			RSAPublicKey publicKey = RSAEncrypt.loadPublicKeyByFile(pfxPath,"123456");
			String publicKeyStr = Util.getHexString(publicKey.getEncoded());
			returnMap.put("publicKey", publicKeyStr);
			//签名操作
			signStr=RSASignature.sign(content,Util.getHexString(RSAEncrypt.loadPrivateKeyByFile(pfxPath,"123456").getEncoded()));
		}catch(Exception e){
			e.printStackTrace();
		}
		log.info("content:"+content);
		log.info("signStr:"+signStr);
		log.debug("");
		returnMap.put("signStr", signStr);
		returnMap.put("content", content);
		return returnMap;
	}
	
	/**
	 * 签名，对map进行签名，并返回签名后的字符串、签名前的字符串和用于验签的公钥
	 * @param param 请求参数（不包括签名和公钥）
	 * @return
	 */
	public static Map<String,String> signMap(Map<String,String> signMap, String pfxPath){
		Map<String,String> returnMap = new HashMap<String, String>();
		String signStr = "";
		
		signMap = sortMapByKey(signMap);
		String content=getParams(signMap);
		try{
			//获取自己的公钥，用作返回
			RSAPublicKey publicKey = RSAEncrypt.loadPublicKeyByFile(pfxPath,"123456");
			String publicKeyStr = Util.getHexString(publicKey.getEncoded());
			returnMap.put("publicKey", publicKeyStr);
			//签名操作
			signStr=RSASignature.sign(content,Util.getHexString(RSAEncrypt.loadPrivateKeyByFile(pfxPath,"123456").getEncoded()));
		}catch(Exception e){
			e.printStackTrace();
		}
		log.info("content:"+content);
		log.info("signStr:"+signStr);
		log.debug("");
		returnMap.put("signStr", signStr);
		returnMap.put("content", content);
		return returnMap;
	}
	
	/**
	 * 对字符串验签，返回验证结果
	 * @param content
	 * @param signStr
	 * @param publicKey
	 * @return
	 */
	public static boolean doCheckString(String content,String signStr,String publicKey){
		boolean isTrue = false;
		try {
		
			//验签操作
			isTrue = RSASignature.doCheck(content, signStr, Util.getHexString(RSAEncrypt.loadPublicKeyByStr(publicKey).getEncoded()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("---------------公钥校验签名------------------");
		log.info("content:"+content);
		log.info("signStr:"+signStr);
		log.info("publicKey:"+publicKey);
		log.info("check:"+isTrue);
		log.debug("");
		return isTrue;
	}
	
	/**
	 * 对map验签，返回验证结果
	 * @param param 请求参数（不包括签名和公钥）
	 * @param signStr 签名后的字符串
	 * @param pulicKey 签名方提供的公钥
	 * @return
	 */
	public static boolean doCheckMap(Map<String,String> signMap,String signStr,String pulicKey){
		signMap = sortMapByKey(signMap);
		String content = getParams(signMap);
		boolean isTrue = false;
		try {
			//验签操作
			isTrue = RSASignature.doCheck(content, signStr, Util.getHexString(RSAEncrypt.loadPublicKeyByStr(pulicKey).getEncoded()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("---------------公钥校验签名------------------");
		log.info("content:"+content);
		log.info("signStr:"+signStr);
		log.info("check:"+isTrue);
		log.debug("");
		return isTrue;
	}
	
	/**
	 * 对参数进行排序，以防止传输过程中参数顺序出现错乱
	 * 
	 * 注：所有进行签名的和验签的开发者必须使用同样的方法进行排序
	 * 
	 * @param oriMap
	 * @return 
	 */
	public static Map<String, String> sortMapByKey(Map<String, String> oriMap) {
		if (oriMap == null || oriMap.isEmpty()) {
			return null;
		}
		Map<String, String> sortedMap = new TreeMap<String, String>(new Comparator<String>() {
			public int compare(String key1, String key2) {
				int intKey1 = 0, intKey2 = 0;
				try {
					intKey1 = getHashCode(key1);
					intKey2 = getHashCode(key2);
				} catch (Exception e) {
					intKey1 = 0; 
					intKey2 = 0;
				}
				return intKey1 - intKey2;
			}});
		sortedMap.putAll(oriMap);
		return sortedMap;
	}
	
	private static int getHashCode(String str) {
		return str.hashCode();
	}
	
	/**
	 * 获取传入参数并返回成参数字符串
	 * @param map
	 * @return AAAA=aaaa&BBBB=bbbb&...&CCCC=cccc 
	 */
	public static String getParams(Map<String,String> map){
		String params = "";
		for(Map.Entry<String, String> entity : map.entrySet()){
			params =  params + entity.getKey()+"="+entity.getValue()+"&";
		}
		params = params.substring(0, params.lastIndexOf('&'));
		log.info(params);
		return params;
	}
}
