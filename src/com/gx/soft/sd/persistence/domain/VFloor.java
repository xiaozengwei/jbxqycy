package com.gx.soft.sd.persistence.domain;

import java.util.List;

/**
 * Created by adminstrator on 2019/10/25.
 */
public class VFloor {
    private String text;
    private Boolean disabled;
    private List<VFloorRoomDev>Children;
    private String id;

    public List<VFloorRoomDev> getChildren() {
        return Children;
    }

    public void setChildren(List<VFloorRoomDev> children) {
        Children = children;
    }

    public VFloor(String text, Boolean disabled, String id) {
        this.text = text;
        this.disabled = disabled;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }


}
