package com.gx.bridge.userrepo;

import java.io.IOException;

import javax.annotation.Resource;

import com.gx.api.userrepo.UserRepoCache;
import com.gx.api.userrepo.UserRepoDTO;
import com.gx.core.mapper.JsonMapper;
import com.gx.ext.message.Subscribable;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserRepoSubscriber implements Subscribable<String> {
    private static Logger logger = LoggerFactory
            .getLogger(UserRepoSubscriber.class);
    private JsonMapper jsonMapper = new JsonMapper();
    private UserRepoCache userRepoCache;
    private String destinationName = "topic.userrepo.update";

    public void handleMessage(String message) {
        try {
            UserRepoDTO userRepoDto = jsonMapper.fromJson(message,
                    UserRepoDTO.class);

            if (userRepoDto.getName() == null) {
                userRepoCache.removeUserRepo(userRepoDto);
                logger.info("remove userRepoDto : {}", message);
            } else {
                userRepoCache.updateUserRepo(userRepoDto);
                logger.info("update userRepoDto : {}", message);
            }
        } catch (IOException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }

    public boolean isTopic() {
        return true;
    }

    public String getName() {
        return destinationName;
    }

    @Resource
    public void setUserRepoCache(UserRepoCache userRepoCache) {
        this.userRepoCache = userRepoCache;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }
}
