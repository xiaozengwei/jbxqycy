package com.gx.soft.common.util;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpUtils {
	private static final OkHttpClient client;

	static {
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		builder.readTimeout(1, TimeUnit.MINUTES);
		client = builder.build();
	}

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	
//	public static <T extends Map<String, ?>> String postJSON(String url,String json){
//		String result = null;
//		RequestBody body = RequestBody.create(JSON, json);
//		Request request = new Request.Builder().url(url).post(body).build();
//		Response response;
//		try {
//			response = client.newCall(request).execute();
//			result = response.body().string();
//			
//			return result;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	/**
	 * post表单请求
	 * 
	 * @param url
	 * @param map
	 * @return
	 * @throws IOException
	 */
	public static <T extends Map<String, ?>> String post(String interfaceName,String url, T params) {
		String result = null;
		
		Builder builder = new Builder();
		if (params instanceof Map) {
			Map<String, ?> map = params;
			for (Entry<String, ?> entry : map.entrySet()) {
				builder.add(entry.getKey(), entry.getValue() + "");
			}
		}

		FormBody formBody = builder.build();
		Request request = new Request.Builder().url(url).post(formBody).build();
		Response response;
		try {
			response = client.newCall(request).execute();
			result = response.body().string();
			
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 发�?�get请求
	 * 
	 * @param url
	 * @param map
	 * @return
	 * @throws IOException
	 */
	public static String get(String url, Object... args) {
		if (null != args && args.length > 0) {
			url = replace(url, args);
		}

		Request request = new Request.Builder().url(url).get().build();
		Response response;
		try {
			response = client.newCall(request).execute();
			return response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] stream(String url, Object... args) {
		if (args.length > 0) {
			url = replace(url, args);
		}

		Request request = new Request.Builder().url(url).get().build();
		try {
			ResponseBody body = client.newCall(request).execute().body();
			return body.bytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String replace(String format, Object... args) {
		return String.format(format, args);
	}

}
