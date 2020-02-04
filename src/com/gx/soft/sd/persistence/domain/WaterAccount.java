package com.gx.soft.sd.persistence.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "water_account", schema = "jbxqycy", catalog = "")
public class WaterAccount {
    private String roomName;
    private Double balance;
    private Double lastRechargeMoney;
    private Timestamp lastRechargeTime;
    private Double totalMoney;
    private Double recentReduceMoney;
    private Timestamp recentReduceTime;
    private String ext;
    private String ext2;
    private Date ext3;
    private Timestamp ext4;
    private Integer dataOrder;

    @Id
    @Column(name = "room_name")
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Basic
    @Column(name = "balance")
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "last_recharge_money")
    public Double getLastRechargeMoney() {
        return lastRechargeMoney;
    }

    public void setLastRechargeMoney(Double lastRechargeMoney) {
        this.lastRechargeMoney = lastRechargeMoney;
    }

    @Basic
    @Column(name = "last_recharge_time")
    public Timestamp getLastRechargeTime() {
        return lastRechargeTime;
    }

    public void setLastRechargeTime(Timestamp lastRechargeTime) {
        this.lastRechargeTime = lastRechargeTime;
    }

    @Basic
    @Column(name = "total_money")
    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Basic
    @Column(name = "recent_reduce_money")
    public Double getRecentReduceMoney() {
        return recentReduceMoney;
    }

    public void setRecentReduceMoney(Double recentReduceMoney) {
        this.recentReduceMoney = recentReduceMoney;
    }

    @Basic
    @Column(name = "recent_reduce_time")
    public Timestamp getRecentReduceTime() {
        return recentReduceTime;
    }

    public void setRecentReduceTime(Timestamp recentReduceTime) {
        this.recentReduceTime = recentReduceTime;
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
    public Date getExt3() {
        return ext3;
    }

    public void setExt3(Date ext3) {
        this.ext3 = ext3;
    }

    @Basic
    @Column(name = "ext4")
    public Timestamp getExt4() {
        return ext4;
    }

    public void setExt4(Timestamp ext4) {
        this.ext4 = ext4;
    }

    @Basic
    @Column(name = "data_order")
    public Integer getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(Integer dataOrder) {
        this.dataOrder = dataOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterAccount that = (WaterAccount) o;
        return Objects.equals(roomName, that.roomName) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(lastRechargeMoney, that.lastRechargeMoney) &&
                Objects.equals(lastRechargeTime, that.lastRechargeTime) &&
                Objects.equals(totalMoney, that.totalMoney) &&
                Objects.equals(recentReduceMoney, that.recentReduceMoney) &&
                Objects.equals(recentReduceTime, that.recentReduceTime) &&
                Objects.equals(ext, that.ext) &&
                Objects.equals(ext2, that.ext2) &&
                Objects.equals(ext3, that.ext3) &&
                Objects.equals(ext4, that.ext4) &&
                Objects.equals(dataOrder, that.dataOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomName, balance, lastRechargeMoney, lastRechargeTime, totalMoney, recentReduceMoney, recentReduceTime, ext, ext2, ext3, ext4, dataOrder);
    }
}
