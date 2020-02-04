package com.gx.api.notification;

public interface NotificationHandler {
    String getType();

    void handle(NotificationDTO notificationDto);
}
