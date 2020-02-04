package com.gx.api.whitelist;

import java.util.List;

public interface WhitelistConnector {
    WhitelistDTO getWhitelist(String code);

    List<WhitelistDTO> getWhitelists(String code);
}
