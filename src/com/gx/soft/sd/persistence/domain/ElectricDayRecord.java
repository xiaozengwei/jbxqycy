package com.gx.soft.sd.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "electric_day_record", schema = "jbxqycy", catalog = "")
public class ElectricDayRecord {
    private String deviceId;
    private String totalEnergy;
    private String tipEnergy;
    private String peakEnergy;
    private String valleyEnergy;
    private String flatEnergy;
    private String balance;
    private Date time;
    private Timestamp timeLocalRecord;
    private String ext;
    private Integer ext2;

    @Id
    @Column(name = "device_id")
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "total_energy")
    public String getTotalEnergy() {
        return totalEnergy;
    }

    public void setTotalEnergy(String totalEnergy) {
        this.totalEnergy = totalEnergy;
    }

    @Basic
    @Column(name = "tip_energy")
    public String getTipEnergy() {
        return tipEnergy;
    }

    public void setTipEnergy(String tipEnergy) {
        this.tipEnergy = tipEnergy;
    }

    @Basic
    @Column(name = "peak_energy")
    public String getPeakEnergy() {
        return peakEnergy;
    }

    public void setPeakEnergy(String peakEnergy) {
        this.peakEnergy = peakEnergy;
    }

    @Basic
    @Column(name = "valley_energy")
    public String getValleyEnergy() {
        return valleyEnergy;
    }

    public void setValleyEnergy(String valleyEnergy) {
        this.valleyEnergy = valleyEnergy;
    }

    @Basic
    @Column(name = "flat_energy")
    public String getFlatEnergy() {
        return flatEnergy;
    }

    public void setFlatEnergy(String flatEnergy) {
        this.flatEnergy = flatEnergy;
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
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "time_local_record")
    public Timestamp getTimeLocalRecord() {
        return timeLocalRecord;
    }

    public void setTimeLocalRecord(Timestamp timeLocalRecord) {
        this.timeLocalRecord = timeLocalRecord;
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

        ElectricDayRecord that = (ElectricDayRecord) o;

        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (totalEnergy != null ? !totalEnergy.equals(that.totalEnergy) : that.totalEnergy != null) return false;
        if (tipEnergy != null ? !tipEnergy.equals(that.tipEnergy) : that.tipEnergy != null) return false;
        if (peakEnergy != null ? !peakEnergy.equals(that.peakEnergy) : that.peakEnergy != null) return false;
        if (valleyEnergy != null ? !valleyEnergy.equals(that.valleyEnergy) : that.valleyEnergy != null) return false;
        if (flatEnergy != null ? !flatEnergy.equals(that.flatEnergy) : that.flatEnergy != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (timeLocalRecord != null ? !timeLocalRecord.equals(that.timeLocalRecord) : that.timeLocalRecord != null)
            return false;
        if (ext != null ? !ext.equals(that.ext) : that.ext != null) return false;
        if (ext2 != null ? !ext2.equals(that.ext2) : that.ext2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deviceId != null ? deviceId.hashCode() : 0;
        result = 31 * result + (totalEnergy != null ? totalEnergy.hashCode() : 0);
        result = 31 * result + (tipEnergy != null ? tipEnergy.hashCode() : 0);
        result = 31 * result + (peakEnergy != null ? peakEnergy.hashCode() : 0);
        result = 31 * result + (valleyEnergy != null ? valleyEnergy.hashCode() : 0);
        result = 31 * result + (flatEnergy != null ? flatEnergy.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (timeLocalRecord != null ? timeLocalRecord.hashCode() : 0);
        result = 31 * result + (ext != null ? ext.hashCode() : 0);
        result = 31 * result + (ext2 != null ? ext2.hashCode() : 0);
        return result;
    }
}
