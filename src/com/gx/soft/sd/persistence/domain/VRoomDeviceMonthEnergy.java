package com.gx.soft.sd.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "v_room_device_month_energy", schema = "jbxqycy", catalog = "")
public class VRoomDeviceMonthEnergy {
    private String vKey;
    private String rowId;
    private String rowName;
    private String pFloorId;
    private String pFloorName;
    private String floorType;
    private String deviceId;
    private String deviceName;
    private String settleTypeOut;
    private String settleTypeName;
    private String onAndOff;
    private String monthEnergy;
    private String totalEnergyStart;
    private String totalEnergyEnd;
    private String balance;
    private String time;

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

    @Basic
    @Column(name = "month_energy")
    public String getMonthEnergy() {
        return monthEnergy;
    }

    public void setMonthEnergy(String monthEnergy) {
        this.monthEnergy = monthEnergy;
    }

    @Basic
    @Column(name = "total_energy_start")
    public String getTotalEnergyStart() {
        return totalEnergyStart;
    }

    public void setTotalEnergyStart(String totalEnergyStart) {
        this.totalEnergyStart = totalEnergyStart;
    }

    @Basic
    @Column(name = "total_energy_end")
    public String getTotalEnergyEnd() {
        return totalEnergyEnd;
    }

    public void setTotalEnergyEnd(String totalEnergyEnd) {
        this.totalEnergyEnd = totalEnergyEnd;
    }

    @Basic
    @Column(name = "balance")
    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VRoomDeviceMonthEnergy that = (VRoomDeviceMonthEnergy) o;

        if (vKey != null ? !vKey.equals(that.vKey) : that.vKey != null) return false;
        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (rowName != null ? !rowName.equals(that.rowName) : that.rowName != null) return false;
        if (pFloorId != null ? !pFloorId.equals(that.pFloorId) : that.pFloorId != null) return false;
        if (pFloorName != null ? !pFloorName.equals(that.pFloorName) : that.pFloorName != null) return false;
        if (floorType != null ? !floorType.equals(that.floorType) : that.floorType != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (deviceName != null ? !deviceName.equals(that.deviceName) : that.deviceName != null) return false;
        if (settleTypeOut != null ? !settleTypeOut.equals(that.settleTypeOut) : that.settleTypeOut != null)
            return false;
        if (settleTypeName != null ? !settleTypeName.equals(that.settleTypeName) : that.settleTypeName != null)
            return false;
        if (onAndOff != null ? !onAndOff.equals(that.onAndOff) : that.onAndOff != null) return false;
        if (monthEnergy != null ? !monthEnergy.equals(that.monthEnergy) : that.monthEnergy != null) return false;
        if (totalEnergyStart != null ? !totalEnergyStart.equals(that.totalEnergyStart) : that.totalEnergyStart != null)
            return false;
        if (totalEnergyEnd != null ? !totalEnergyEnd.equals(that.totalEnergyEnd) : that.totalEnergyEnd != null)
            return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

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
        result = 31 * result + (settleTypeOut != null ? settleTypeOut.hashCode() : 0);
        result = 31 * result + (settleTypeName != null ? settleTypeName.hashCode() : 0);
        result = 31 * result + (onAndOff != null ? onAndOff.hashCode() : 0);
        result = 31 * result + (monthEnergy != null ? monthEnergy.hashCode() : 0);
        result = 31 * result + (totalEnergyStart != null ? totalEnergyStart.hashCode() : 0);
        result = 31 * result + (totalEnergyEnd != null ? totalEnergyEnd.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
