package com.gx.soft.sd.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "v_water_every_month", schema = "jbxqycy", catalog = "")
public class VWaterEveryMonth {
    private String vKey;
    private String rowId;
    private String rowName;
    private String pFloorId;
    private String pFloorName;
    private String floorType;
    private String status;
    private String deviceId;
    private String deviceName;
    private String totalWater;
    private Timestamp time;
    private String ext;
    private String ext2;
    private String ext3;
    private String ext4;

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
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @Column(name = "total_water")
    public String getTotalWater() {
        return totalWater;
    }

    public void setTotalWater(String totalWater) {
        this.totalWater = totalWater;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
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
    @Column(name = "ext2")
    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    @Basic
    @Column(name = "ext3")
    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    @Basic
    @Column(name = "ext4")
    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VWaterEveryMonth that = (VWaterEveryMonth) o;

        if (vKey != null ? !vKey.equals(that.vKey) : that.vKey != null) return false;
        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (rowName != null ? !rowName.equals(that.rowName) : that.rowName != null) return false;
        if (pFloorId != null ? !pFloorId.equals(that.pFloorId) : that.pFloorId != null) return false;
        if (pFloorName != null ? !pFloorName.equals(that.pFloorName) : that.pFloorName != null) return false;
        if (floorType != null ? !floorType.equals(that.floorType) : that.floorType != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (deviceName != null ? !deviceName.equals(that.deviceName) : that.deviceName != null) return false;
        if (totalWater != null ? !totalWater.equals(that.totalWater) : that.totalWater != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (ext != null ? !ext.equals(that.ext) : that.ext != null) return false;
        if (ext2 != null ? !ext2.equals(that.ext2) : that.ext2 != null) return false;
        if (ext3 != null ? !ext3.equals(that.ext3) : that.ext3 != null) return false;
        if (ext4 != null ? !ext4.equals(that.ext4) : that.ext4 != null) return false;

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
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (totalWater != null ? totalWater.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (ext != null ? ext.hashCode() : 0);
        result = 31 * result + (ext2 != null ? ext2.hashCode() : 0);
        result = 31 * result + (ext3 != null ? ext3.hashCode() : 0);
        result = 31 * result + (ext4 != null ? ext4.hashCode() : 0);
        return result;
    }
}
