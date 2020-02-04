package com.gx.api.notification;

import java.util.Collection;

public interface NotificationConnector {
    void send(NotificationDTO notificationDto);

    Collection<String> getTypes();
}
