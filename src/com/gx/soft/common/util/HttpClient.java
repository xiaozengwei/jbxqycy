package com.gx.soft.common.util;



import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;


public class HttpClient {
    static Logger log = Logger.getLogger(HttpClient.class);
    public final static String METHOD_GET = "GET";
    public final static String METHOD_PUT = "PUT";
    public final static String METHOD_DELETE = "DELETE";
    public final static String METHOD_POST = "POST";

    /**
     * @param serviceUrl  �����url
     * @param parameter   ����Ĳ���
     * @param restMethod  GET/PUT/DELETE/POST
     * @param contentType application/json;charset=utf-8  application/x-www-form-urlencoded  application/xml;charset=utf-8
     * @return
     */
    public static String sendHttpRequest(String serviceUrl, String parameter, String restMethod, String contentType) {
        HttpURLConnection con = null;
        BufferedReader in = null;
        String resultStr = "";

        try {
            log.debug("rest request url:" + serviceUrl);
            log.debug("url params:" + parameter);
            URL url = new URL(serviceUrl);
            trustAllHttpsCertificates();
            HttpsURLConnection.setDefaultHostnameVerifier(new THostnameVerifier());
            con = (HttpURLConnection) url.openConnection();
            //if(serviceUrl.startsWith("https")){
            //
            //	  ((HttpsURLConnection) con).setHostnameVerifier(new RongzerHostnameVerifier());
            //}
            if (contentType == null || "".equals(contentType)) {
                contentType = "application/json;charset=utf-8";
            }
            con.setRequestProperty("Content-Type", contentType);//application/x-www-form-urlencoded
            con.setRequestMethod(restMethod);
            //������󷽷�ΪPUT,POST��DELETE����DoOutputΪ��
            if (!HttpClient.METHOD_GET.equals(restMethod)) {
                con.setDoOutput(true);
                con.setDoInput(true);
                if (!HttpClient.METHOD_DELETE.equals(restMethod)) { //���󷽷�ΪPUT��POSTʱִ��
                    byte[] data = parameter.getBytes("UTF-8");
                    con.setRequestProperty("Content-Length", String.valueOf(data.length));
                    OutputStream os = con.getOutputStream();
                    con.setConnectTimeout(5 * 1000);
                    os.write(data);
                    os.flush();
                    os.close();
                }
            }
            StringBuffer buffer = new StringBuffer();
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String line = "";
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
            in.close();
            resultStr = buffer.toString();
            log.info("rest response body:" + resultStr);
        } catch (Exception e) {
            log.info("报错" + e);
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                con.disconnect();
                con = null;
            }
        }
        return resultStr;
    }


    /**
     * @param serviceUrl    �����url
     * @param parameter     ����Ĳ���
     * @param restMethod    GET/PUT/DELETE/POST
     * @param contentType   application/json;charset=utf-8  application/x-www-form-urlencoded
     * @param authorization �����û�������Ĳ���
     * @return
     */
    public static String sendHttpRequestForAuthorization(String serviceUrl, String parameter, String restMethod, String contentType, String authorization) {
        HttpURLConnection con = null;
        BufferedReader in = null;
        String resultStr = "";
        try {
            //log.info("rest request url:"+serviceUrl);
            URL url = new URL(serviceUrl);
            con = (HttpURLConnection) url.openConnection();
            if (contentType == null || "".equals(contentType)) {
                contentType = "application/json;charset=utf-8";
            }
            con.setRequestProperty("Content-Type", contentType);
            con.setRequestProperty("Authorization", authorization);
            con.setRequestMethod(restMethod);
            //������󷽷�ΪPUT,POST��DELETE����DoOutputΪ��
            if (!HttpClient.METHOD_GET.equals(restMethod)) {
                con.setDoOutput(true);
                con.setDoInput(true);
                if (!HttpClient.METHOD_DELETE.equals(restMethod)) { //���󷽷�ΪPUT��POSTʱִ��
                    byte[] data = parameter.getBytes("UTF-8");
                    con.setRequestProperty("Content-Length", String.valueOf(data.length));
                    OutputStream os = con.getOutputStream();
                    con.setConnectTimeout(5 * 1000);
                    os.write(data);
                    os.flush();
                    os.close();
                }
            }
            StringBuffer buffer = new StringBuffer();
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String line = "";
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
            in.close();
            resultStr = buffer.toString();
            //log.info("rest response body:"+resultStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                con.disconnect();
                con = null;
            }
        }
        return resultStr;
    }

    /**
     * Get method Map to url
     *
     * @param urlStr
     * @param requestMap
     * @return
     */
    public static String getRequestUrl(String urlStr, Map<String, Object> requestMap) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> entry : requestMap.entrySet()) {
            if (!"".equals(entry.getValue()) && entry.getValue() != null) {
                sb.append(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        String param = sb.toString().substring(0, sb.toString().length() - 1);
        urlStr = urlStr + "?" + param;
        return urlStr;
    }

    public static String getPostParams(Map<String, String> requestMap) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : requestMap.entrySet()) {
            if (!"".equals(entry.getValue()) && entry.getValue() != null) {
                sb.append(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        String param = sb.toString().substring(0, sb.toString().length() - 1);
        return param;
    }


    /************************�����ǽ��https˽Կ���Ϸ������� ��ʼ****************************/

    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
                .getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc
                .getSocketFactory());
    }

    static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }

    /************************�����ǽ��https˽Կ���Ϸ������� ����****************************/

    public static String sendHttpRequestPost(String url,List<NameValuePair> pairs, String contentType)throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", contentType);

//        StringEntity entity = new StringEntity(parameter,ContentType.APPLICATION_FORM_URLENCODED);
//        entity.setContentEncoding("UTF-8");
//        entity.setContentType("application/x-www.form-urlencoded");
//        httpPost.setEntity(entity);

//        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
//        NameValuePair pair3 = new BasicNameValuePair("deviceIds","{\"devices\":[{\"deviceId\":57,\"money\":1,\"secret\":\"19c285fae3d617df92522368f0473430\"}],\"ipAddress\":\"192.168.50.23\",\"actionType\":0}");
//        pairs.add(pair3);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, HTTP.UTF_8));

        try {
            CloseableHttpResponse response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity he = response.getEntity();
                respContent = EntityUtils.toString(he, "UTF-8");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return respContent;
    }

    public static String sendHttpRequestPost(String url, String parameter,String method, String contentType) {
        OutputStreamWriter out = null;
        InputStream is = null;
        String result="";
        try {
            URL url1 = new URL(url);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod(method); // 设置请求方式
            connection.setRequestProperty("Accept",contentType); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", contentType); // 设置发送数据的格式
            connection.connect();
            out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(parameter);
            out.flush();
            out.close();

            // 读取响应
            is = connection.getInputStream();
            int length = (int) connection.getContentLength();// 获取长度
            if (length != -1) {
                byte[] data = new byte[length];
                byte[] temp = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(temp)) > 0) {
                    System.arraycopy(temp, 0, data, destPos, readLen);
                    destPos += readLen;
                }
                result = new String(data, "UTF-8"); // utf-8编码
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}