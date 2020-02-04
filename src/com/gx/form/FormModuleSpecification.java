package com.gx.form;

import com.gx.ext.dbmigrate.ModuleSpecification;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

@Component
public class FormModuleSpecification implements ModuleSpecification {
    private String type;
    private boolean enabled;
    private boolean initData;

    public boolean isEnabled() {
        return enabled;
    }

    public String getSchemaTable() {
        return "SCHEMA_VERSION_FORM";
    }

    public String getSchemaLocation() {
        return "dbmigrate." + type + ".form";
    }

    public boolean isInitData() {
        return initData;
    }

    public String getDataTable() {
        return "SCHEMA_VERSION_DATA_FORM";
    }

    public String getDataLocation() {
        return "dbmigrate." + type + ".data_form";
    }

    @Value("${application.database.type}")
    public void setType(String type) {
        this.type = type;
    }

    @Value("${form.dbmigrate.enabled}")
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Value("${form.dbmigrate.initData}")
    public void setInitData(boolean initData) {
        this.initData = initData;
    }
}
