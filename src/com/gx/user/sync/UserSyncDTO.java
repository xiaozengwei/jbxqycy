package com.gx.user.sync;

public interface UserSyncDTO {
    String getId();

    boolean hasModified(UserSyncDTO userSyncDto);
}
