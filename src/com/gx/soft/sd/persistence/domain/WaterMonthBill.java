package com.gx.soft.sd.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "water_month_bill", schema = "jbxqycy", catalog = "")
public class WaterMonthBill {
    private String rowId;
    private String roomName;
    private String deviceId;
    private Double waterHistoryUse;
    private Double waterCurrentUse;
    private Double waterMonthUse;
    private Double waterMonthMoney;
    private Double waterBalance;
    private Double waterBeforeBalance;
    private String time;
    private String timeSection;
    private Timestamp localRecordTime;
    private Date ext;
    private String ext2;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "row_id")
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
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
    @Column(name = "water_history_use")
    public Double getWaterHistoryUse() {
        return waterHistoryUse;
    }

    public void setWaterHistoryUse(Double waterHistoryUse) {
        this.waterHistoryUse = waterHistoryUse;
    }

    @Basic
    @Column(name = "water_current_use")
    public Double getWaterCurrentUse() {
        return waterCurrentUse;
    }

    public void setWaterCurrentUse(Double waterCurrentUse) {
        this.waterCurrentUse = waterCurrentUse;
    }

    @Basic
    @Column(name = "water_month_use")
    public Double getWaterMonthUse() {
        return waterMonthUse;
    }

    public void setWaterMonthUse(Double waterMonthUse) {
        this.waterMonthUse = waterMonthUse;
    }

    @Basic
    @Column(name = "water_month_money")
    public Double getWaterMonthMoney() {
        return waterMonthMoney;
    }

    public void setWaterMonthMoney(Double waterMonthMoney) {
        this.waterMonthMoney = waterMonthMoney;
    }

    @Basic
    @Column(name = "water_balance")
    public Double getWaterBalance() {
        return waterBalance;
    }

    public void setWaterBalance(Double waterBalance) {
        this.waterBalance = waterBalance;
    }

    @Basic
    @Column(name = "water_before_balance")
    public Double getWaterBeforeBalance() {
        return waterBeforeBalance;
    }

    public void setWaterBeforeBalance(Double waterBeforeBalance) {
        this.waterBeforeBalance = waterBeforeBalance;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "time_section")
    public String getTimeSection() {
        return timeSection;
    }

    public void setTimeSection(String timeSection) {
        this.timeSection = timeSection;
    }

    @Basic
    @Column(name = "localRecordTime")
    public Timestamp getLocalRecordTime() {
        return localRecordTime;
    }

    public void setLocalRecordTime(Timestamp localRecordTime) {
        this.localRecordTime = localRecordTime;
    }

    @Basic
    @Column(name = "ext")
    public Date getExt() {
        return ext;
    }

    public void setExt(Date ext) {
        this.ext = ext;
    }

    @Basic
    @Column(name = "ext2")
    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WaterMonthBill that = (WaterMonthBill) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (roomName != null ? !roomName.equals(that.roomName) : that.roomName != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (waterHistoryUse != null ? !waterHistoryUse.equals(that.waterHistoryUse) : that.waterHistoryUse != null)
            return false;
        if (waterCurrentUse != null ? !waterCurrentUse.equals(that.waterCurrentUse) : that.waterCurrentUse != null)
            return false;
        if (waterMonthUse != null ? !waterMonthUse.equals(that.waterMonthUse) : that.waterMonthUse != null)
            return false;
        if (waterMonthMoney != null ? !waterMonthMoney.equals(that.waterMonthMoney) : that.waterMonthMoney != null)
            return false;
        if (waterBalance != null ? !waterBalance.equals(that.waterBalance) : that.waterBalance != null) return false;
        if (waterBeforeBalance != null ? !waterBeforeBalance.equals(that.waterBeforeBalance) : that.waterBeforeBalance != null)
            return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (timeSection != null ? !timeSection.equals(that.timeSection) : that.timeSection != null) return false;
        if (localRecordTime != null ? !localRecordTime.equals(that.localRecordTime) : that.localRecordTime != null)
            return false;
        if (ext != null ? !ext.equals(that.ext) : that.ext != null) return false;
        if (ext2 != null ? !ext2.equals(that.ext2) : that.ext2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (roomName != null ? roomName.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (waterHistoryUse != null ? waterHistoryUse.hashCode() : 0);
        result = 31 * result + (waterCurrentUse != null ? waterCurrentUse.hashCode() : 0);
        result = 31 * result + (waterMonthUse != null ? waterMonthUse.hashCode() : 0);
        result = 31 * result + (waterMonthMoney != null ? waterMonthMoney.hashCode() : 0);
        result = 31 * result + (waterBalance != null ? waterBalance.hashCode() : 0);
        result = 31 * result + (waterBeforeBalance != null ? waterBeforeBalance.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (timeSection != null ? timeSection.hashCode() : 0);
        result = 31 * result + (localRecordTime != null ? localRecordTime.hashCode() : 0);
        result = 31 * result + (ext != null ? ext.hashCode() : 0);
        result = 31 * result + (ext2 != null ? ext2.hashCode() : 0);
        return result;
    }
}
