package com.gx.api.msg;

public interface MsgConnector {
    void send(String subject, String content, String receiverId, String senderId);
}
