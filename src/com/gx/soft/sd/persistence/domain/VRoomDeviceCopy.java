package com.gx.soft.sd.persistence.domain;

import javax.persistence.*;

/**
 * Created by adminstrator on 2019/10/28.
 */
@Entity
@Table(name = "v_room_device_copy", schema = "jbxqycy", catalog = "")
public class VRoomDeviceCopy {
    private String vKey;
    private String rowId;
    private String rowName;
    private String pFloorId;
    private String pFloorName;
    private String floorType;
    private String roomId;
    private String deviceId;
    private String deviceName;
    private String settleTypeOut;
    private String settleTypeName;
    private String onAndOff;

    @Id
    @Column(name = "v_key")
    public String getvKey() {
        return vKey;
    }

    public void setvKey(String vKey) {
        this.vKey = vKey;
    }

    @Basic
    @Column(name = "row_id")
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Basic
    @Column(name = "row_name")
    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    @Basic
    @Column(name = "p_floor_id")
    public String getpFloorId() {
        return pFloorId;
    }

    public void setpFloorId(String pFloorId) {
        this.pFloorId = pFloorId;
    }

    @Basic
    @Column(name = "p_floor_name")
    public String getpFloorName() {
        return pFloorName;
    }

    public void setpFloorName(String pFloorName) {
        this.pFloorName = pFloorName;
    }

    @Basic
    @Column(name = "floor_type")
    public String getFloorType() {
        return floorType;
    }

    public void setFloorType(String floorType) {
        this.floorType = floorType;
    }

    @Basic
    @Column(name = "room_id")
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
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
    @Column(name = "on_and_off")
    public String getOnAndOff() {
        return onAndOff;
    }

    public void setOnAndOff(String onAndOff) {
        this.onAndOff = onAndOff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VRoomDeviceCopy that = (VRoomDeviceCopy) o;

        if (vKey != null ? !vKey.equals(that.vKey) : that.vKey != null) return false;
        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (rowName != null ? !rowName.equals(that.rowName) : that.rowName != null) return false;
        if (pFloorId != null ? !pFloorId.equals(that.pFloorId) : that.pFloorId != null) return false;
        if (pFloorName != null ? !pFloorName.equals(that.pFloorName) : that.pFloorName != null) return false;
        if (floorType != null ? !floorType.equals(that.floorType) : that.floorType != null) return false;
        if (roomId != null ? !roomId.equals(that.roomId) : that.roomId != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (deviceName != null ? !deviceName.equals(that.deviceName) : that.deviceName != null) return false;
        if (settleTypeOut != null ? !settleTypeOut.equals(that.settleTypeOut) : that.settleTypeOut != null)
            return false;
        if (settleTypeName != null ? !settleTypeName.equals(that.settleTypeName) : that.settleTypeName != null)
            return false;
        if (onAndOff != null ? !onAndOff.equals(that.onAndOff) : that.onAndOff != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vKey != null ? vKey.hashCode() : 0;
        result = 31 * result + (rowId != null ? rowId.hashCode() : 0);
        result = 31 * result + (rowName != null ? rowName.hashCode() : 0);
        result = 31 * result + (pFloorId != null ? pFloorId.hashCode() : 0);
        result = 31 * result + (pFloorName != null ? pFloorName.hashCode() : 0);
        result = 31 * result + (floorType != null ? floorType.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (settleTypeOut != null ? settleTypeOut.hashCode() : 0);
        result = 31 * result + (settleTypeName != null ? settleTypeName.hashCode() : 0);
        result = 31 * result + (onAndOff != null ? onAndOff.hashCode() : 0);
        return result;
    }
}
