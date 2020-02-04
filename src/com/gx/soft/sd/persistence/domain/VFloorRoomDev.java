package com.gx.soft.sd.persistence.domain;

import java.util.List;

/**
 * Created by adminstrator on 2019/10/28.
 */
public class VFloorRoomDev {
    private String text;
    private List<Vfrm>children;

    public VFloorRoomDev(String text, List<Vfrm> children) {
        this.text = text;
        this.children = children;
    }

    public List<Vfrm> getChildren() {
        return children;
    }

    public void setChildren(List<Vfrm> children) {
        this.children = children;
    }

    public VFloorRoomDev() {
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
