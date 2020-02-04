package com.gx.soft.sd.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "electric_month_record", schema = "jbxqycy", catalog = "")
public class ElectricMonthRecord {
    private String rowId;
    private String deviceId;
    private String monthEnergy;
    private String totalEnergyStart;
    private String totalEnergyEnd;
    private String tipEnergy;
    private String peakEnergy;
    private String valleyEnergy;
    private String flatEnergy;
    private String balance;
    private String time;
    private String ext;
    private Integer ext2;

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
    @Column(name = "device_id")
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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

        ElectricMonthRecord that = (ElectricMonthRecord) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (monthEnergy != null ? !monthEnergy.equals(that.monthEnergy) : that.monthEnergy != null) return false;
        if (totalEnergyStart != null ? !totalEnergyStart.equals(that.totalEnergyStart) : that.totalEnergyStart != null)
            return false;
        if (totalEnergyEnd != null ? !totalEnergyEnd.equals(that.totalEnergyEnd) : that.totalEnergyEnd != null)
            return false;
        if (tipEnergy != null ? !tipEnergy.equals(that.tipEnergy) : that.tipEnergy != null) return false;
        if (peakEnergy != null ? !peakEnergy.equals(that.peakEnergy) : that.peakEnergy != null) return false;
        if (valleyEnergy != null ? !valleyEnergy.equals(that.valleyEnergy) : that.valleyEnergy != null) return false;
        if (flatEnergy != null ? !flatEnergy.equals(that.flatEnergy) : that.flatEnergy != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (ext != null ? !ext.equals(that.ext) : that.ext != null) return false;
        if (ext2 != null ? !ext2.equals(that.ext2) : that.ext2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        result = 31 * result + (monthEnergy != null ? monthEnergy.hashCode() : 0);
        result = 31 * result + (totalEnergyStart != null ? totalEnergyStart.hashCode() : 0);
        result = 31 * result + (totalEnergyEnd != null ? totalEnergyEnd.hashCode() : 0);
        result = 31 * result + (tipEnergy != null ? tipEnergy.hashCode() : 0);
        result = 31 * result + (peakEnergy != null ? peakEnergy.hashCode() : 0);
        result = 31 * result + (valleyEnergy != null ? valleyEnergy.hashCode() : 0);
        result = 31 * result + (flatEnergy != null ? flatEnergy.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (ext != null ? ext.hashCode() : 0);
        result = 31 * result + (ext2 != null ? ext2.hashCode() : 0);
        return result;
    }
}
