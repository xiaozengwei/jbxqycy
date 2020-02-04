package com.gx.api.internal;

import java.util.List;

public interface TemplateConnector {
    TemplateDTO findByCode(String code);

    List<TemplateDTO> findAll();
}
