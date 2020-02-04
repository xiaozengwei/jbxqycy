package com.gx.soft.sd.persistence.domain;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/10/28.
 */
public class Vfrm {
    private String roomId;
    private String text;
    private String deviceId;
    private String deviceName;
    private Timestamp startDate;
    private String settleTypeOut;
    private String settleTypeName;
    private String ext;
    private Date date;
    private String bol;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBol() {
        return bol;
    }

    public void setBol(String bol) {
        this.bol = bol;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public String getSettleTypeOut() {
        return settleTypeOut;
    }

    public void setSettleTypeOut(String settleTypeOut) {
        this.settleTypeOut = settleTypeOut;
    }

    public String getSettleTypeName() {
        return settleTypeName;
    }

    public void setSettleTypeName(String settleTypeName) {
        this.settleTypeName = settleTypeName;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getExt2() {
        return ext2;
    }

    public void setExt2(Integer ext2) {
        this.ext2 = ext2;
    }

    private Integer ext2;

}
