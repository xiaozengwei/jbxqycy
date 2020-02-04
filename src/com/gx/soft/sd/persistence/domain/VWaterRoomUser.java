package com.gx.soft.sd.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "v_water_room_user", schema = "jbxqycy", catalog = "")
public class VWaterRoomUser {
    private String vKey;
    private String rowId;
    private String rowName;
    private String pFloorId;
    private String pFloorName;
    private String floorType;
    private String deviceId;
    private String deviceName;
    private String statu;
    private String userName;
    private String userCardId;
    private String userMobileNum;
    private String waterMoney;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
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
    @Column(name = "statu")
    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_card_id")
    public String getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(String userCardId) {
        this.userCardId = userCardId;
    }

    @Basic
    @Column(name = "user_mobile_num")
    public String getUserMobileNum() {
        return userMobileNum;
    }

    public void setUserMobileNum(String userMobileNum) {
        this.userMobileNum = userMobileNum;
    }

    @Basic
    @Column(name = "water_money")
    public String getWaterMoney() {
        return waterMoney;
    }

    public void setWaterMoney(String waterMoney) {
        this.waterMoney = waterMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VWaterRoomUser that = (VWaterRoomUser) o;

        if (vKey != null ? !vKey.equals(that.vKey) : that.vKey != null) return false;
        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (rowName != null ? !rowName.equals(that.rowName) : that.rowName != null) return false;
        if (pFloorId != null ? !pFloorId.equals(that.pFloorId) : that.pFloorId != null) return false;
        if (pFloorName != null ? !pFloorName.equals(that.pFloorName) : that.pFloorName != null) return false;
        if (floorType != null ? !floorType.equals(that.floorType) : that.floorType != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (deviceName != null ? !deviceName.equals(that.deviceName) : that.deviceName != null) return false;
        if (statu != null ? !statu.equals(that.statu) : that.statu != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (userCardId != null ? !userCardId.equals(that.userCardId) : that.userCardId != null) return false;
        if (userMobileNum != null ? !userMobileNum.equals(that.userMobileNum) : that.userMobileNum != null)
            return false;
        if (waterMoney != null ? !waterMoney.equals(that.waterMoney) : that.waterMoney != null) return false;

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
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (statu != null ? statu.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userCardId != null ? userCardId.hashCode() : 0);
        result = 31 * result + (userMobileNum != null ? userMobileNum.hashCode() : 0);
        result = 31 * result + (waterMoney != null ? waterMoney.hashCode() : 0);
        return result;
    }
}
