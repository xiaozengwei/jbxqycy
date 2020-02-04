package com.gx.bridge.whitelist;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gx.api.whitelist.WhitelistConnector;
import com.gx.api.whitelist.WhitelistDTO;
import com.gx.core.http.HttpHandler;
import com.gx.core.http.HttpHandlerImpl;
import com.gx.core.mapper.JsonMapper;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// http://10.237.32.107:8050/rs/whitelist/get?code=CAS
public class HttpWhitelistConnector implements WhitelistConnector {
    private static Logger logger = LoggerFactory
            .getLogger(HttpWhitelistConnector.class);
    private JsonMapper jsonMapper = new JsonMapper();
    private HttpHandler httpHandler = new HttpHandlerImpl();
    private String baseUrl;

    public WhitelistDTO getWhitelist(String code) {
        WhitelistDTO result = new WhitelistDTO();
        List<WhitelistDTO> whitelistDtos = this.getWhitelists(code);

        for (WhitelistDTO whitelistDto : whitelistDtos) {
            result.getHosts().addAll(whitelistDto.getHosts());
            result.getIps().addAll(whitelistDto.getIps());
        }

        return result;
    }

    public List<WhitelistDTO> getWhitelists(String code) {
        try {
            String text = httpHandler.readText(baseUrl + "?code=" + code);
            List<WhitelistDTO> whitelistDtos = jsonMapper.fromJson(text,
                    new TypeReference<List<WhitelistDTO>>() {
                    });

            return whitelistDtos;
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);

            return Collections.emptyList();
        }
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
