package com.gx.api.internal;

public interface MailConnector {
    void send(String to, String subject, String content);

    void send(MailDTO mailDto);
}
