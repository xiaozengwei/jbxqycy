package com.gx.soft.sd.persistence.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "floor_room_in_device", schema = "jbxqycy", catalog = "")
public class FloorRoomInDevice {
    private String roomId;
    private String roomName;
    private String deviceId;
    private String deviceName;
    private Timestamp startDate;
    private String settleTypeOut;
    private String settleTypeName;
    private String ext;
    private Date date;
    private Integer ext2;

    @Id
    @Column(name = "room_id")
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "room_name")
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Basic
    @Column(name = "device_id")
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "device_name")
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Basic
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "settle_type_out")
    public String getSettleTypeOut() {
        return settleTypeOut;
    }

    public void setSettleTypeOut(String settleTypeOut) {
        this.settleTypeOut = settleTypeOut;
    }

    @Basic
    @Column(name = "settle_type_name")
    public String getSettleTypeName() {
        return settleTypeName;
    }

    public void setSettleTypeName(String settleTypeName) {
        this.settleTypeName = settleTypeName;
    }

    @Basic
    @Column(name = "ext")
    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "ext2")
    public Integer getExt2() {
        return ext2;
    }

    public void setExt2(Integer ext2) {
        this.ext2 = ext2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FloorRoomInDevice that = (FloorRoomInDevice) o;

        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (roomName != null ? !roomName.equals(that.roomName) : that.roomName != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (deviceName != null ? !deviceName.equals(that.deviceName) : that.deviceName != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (settleTypeOut != null ? !settleTypeOut.equals(that.settleTypeOut) : that.settleTypeOut != null)
            return false;
        if (settleTypeName != null ? !settleTypeName.equals(that.settleTypeName) : that.settleTypeName != null)
            return false;
        if (ext != null ? !ext.equals(that.ext) : that.ext != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (ext2 != null ? !ext2.equals(that.ext2) : that.ext2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId != null ? roomId.hashCode() : 0;
        result = 31 * result + (roomName != null ? roomName.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (settleTypeOut != null ? settleTypeOut.hashCode() : 0);
        result = 31 * result + (settleTypeName != null ? settleTypeName.hashCode() : 0);
        result = 31 * result + (ext != null ? ext.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (ext2 != null ? ext2.hashCode() : 0);
        return result;
    }
}
