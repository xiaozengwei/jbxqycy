package com.gx.soft.sd.persistence.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "device_on_and_off", schema = "jbxqycy", catalog = "")
public class DeviceOnAndOff {
    private String deviceId;
    private String onAndOff;
    private Timestamp actionTime;

    @Id
    @Column(name = "device_id")
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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
    @Column(name = "action_time")
    public Timestamp getActionTime() {
        return actionTime;
    }

    public void setActionTime(Timestamp actionTime) {
        this.actionTime = actionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceOnAndOff that = (DeviceOnAndOff) o;

        if (deviceId != null ? !deviceId.equals(that.deviceId) : that.deviceId != null) return false;
        if (onAndOff != null ? !onAndOff.equals(that.onAndOff) : that.onAndOff != null) return false;
        if (actionTime != null ? !actionTime.equals(that.actionTime) : that.actionTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deviceId != null ? deviceId.hashCode() : 0;
        result = 31 * result + (onAndOff != null ? onAndOff.hashCode() : 0);
        result = 31 * result + (actionTime != null ? actionTime.hashCode() : 0);
        return result;
    }
}
