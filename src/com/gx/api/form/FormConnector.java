package com.gx.api.form;

import java.util.List;

public interface FormConnector {
    List<FormDTO> getAll(String scopeId);
}
