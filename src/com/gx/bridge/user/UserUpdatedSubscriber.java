package com.gx.bridge.user;

import java.io.IOException;

import javax.annotation.Resource;

import com.gx.api.scope.ScopeConnector;
import com.gx.api.scope.ScopeDTO;
import com.gx.api.user.UserCache;
import com.gx.api.user.UserDTO;
import com.gx.api.userauth.UserAuthCache;
import com.gx.api.userauth.UserAuthConnector;
import com.gx.api.userauth.UserAuthDTO;
import com.gx.core.mapper.JsonMapper;
import com.gx.ext.message.Subscribable;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserUpdatedSubscriber implements Subscribable<String> {
    private static Logger logger = LoggerFactory
            .getLogger(UserUpdatedSubscriber.class);
    private JsonMapper jsonMapper = new JsonMapper();
    private String destinationName = "topic.user.notify.updated";
    private UserCache userCache;
    private UserAuthCache userAuthCache;
    private ScopeConnector scopeConnector;
    private UserAuthConnector userAuthConnector;

    public void handleMessage(String message) {
        try {
            UserDTO userDto = jsonMapper.fromJson(message, UserDTO.class);

            userCache.updateUser(userDto);

            for (ScopeDTO scopeDto : scopeConnector.findAll()) {
                UserAuthDTO userAuthDto = userAuthConnector.findByUsername(
                        userDto.getUsername(), scopeDto.getId());
                userAuthCache.updateUserAuth(userAuthDto);
            }

            logger.info("update user : {}", message);
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

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    @Resource
    public void setUserCache(UserCache userCache) {
        this.userCache = userCache;
    }

    @Resource
    public void setUserAuthCache(UserAuthCache userAuthCache) {
        this.userAuthCache = userAuthCache;
    }

    @Resource
    public void setScopeConnector(ScopeConnector scopeConnector) {
        this.scopeConnector = scopeConnector;
    }

    @Resource
    public void setUserAuthConnector(UserAuthConnector userAuthConnector) {
        this.userAuthConnector = userAuthConnector;
    }
}
