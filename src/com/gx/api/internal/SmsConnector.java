package com.gx.api.internal;

public interface SmsConnector {
    void send(String to, String content);
}
