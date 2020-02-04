package com.gx.soft.common.wxpay;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 继承微信支付配置类
 */
public class WXPayConfigImpl extends WXPayConfig {

    public static final String appId = "wxe4bcb04f38969b18";
    public static final String mchId = "1404452802";
    public static final String key = "tN3Hi3VGsCX8ZY9ohsP6V51VLW9NI6Kn";
    public static final String path = "C:\\developTools\\apiClient_cert.p12";

    @Override
    String getAppID() { return appId; }

    @Override
    String getMchID() {
        return mchId;
    }

    @Override
    String getKey() {
        return key;
    }

    /**
     * 获取商户证书内容
     * @return 商户证书内容
     */
    @Override
    InputStream getCertStream() {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    @Override
    IWXPayDomain getWXPayDomain() {
        IWXPayDomain iwxPayDomain = new IWXPayDomainImpl();
        return iwxPayDomain;
    }
}
