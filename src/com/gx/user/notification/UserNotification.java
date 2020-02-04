package com.gx.user.notification;

import com.gx.user.persistence.domain.UserBase;

public interface UserNotification {
    void insertUser(UserBase userBase);

    void updateUser(UserBase userBase);

    void removeUser(UserBase userBase);
}
