package com.gx.user.rs;

import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.gx.core.mapper.JsonMapper;
import com.gx.core.util.BaseDTO;
import com.gx.core.util.IoUtils;
import com.gx.core.util.StringUtils;
import com.gx.ext.store.StoreConnector;
import com.gx.ext.store.StoreDTO;
import com.gx.user.persistence.domain.UserBase;
import com.gx.user.persistence.manager.UserBaseManager;
import com.gx.user.service.UserService;
import com.gx.user.support.UserBaseWrapper;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Component
@Path("avatar")
public class AvatarResource {
    private static Logger logger = LoggerFactory
            .getLogger(AvatarResource.class);
    private UserBaseManager userBaseManager;
    private StoreConnector storeConnector;

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public InputStream view(@QueryParam("id") Long id) throws Exception {
        UserBase userBase = userBaseManager.get(id);
        StoreDTO storeDto = storeConnector.get("avatar", userBase.getAvatar());

        return storeDto.getResource().getInputStream();
    }

    // ~ ======================================================================
    @Resource
    public void setUserBaseManager(UserBaseManager userBaseManager) {
        this.userBaseManager = userBaseManager;
    }

    @Resource
    public void setStoreConnector(StoreConnector storeConnector) {
        this.storeConnector = storeConnector;
    }
}
