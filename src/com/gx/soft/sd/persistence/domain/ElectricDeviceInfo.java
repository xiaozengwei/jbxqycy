package com.gx.soft.sd.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ElectricDeviceInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "electric_device_info", catalog = "jbxqycy")
public class ElectricDeviceInfo implements java.io.Serializable {

	// Fields

	private String deviceId;
	private String deviceName;
	private String buildNum;
	private String roomNum;
	private String useStatus;
	private Timestamp createTime;
	private String dataStatus;
	private String dataType;
	private Integer dataOrder;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public ElectricDeviceInfo() {
	}

	/** full constructor */
	public ElectricDeviceInfo(String deviceName, String buildNum,
			String roomNum, String useStatus, Timestamp createTime,
			String dataStatus, String dataType, Integer dataOrder,
			String dataDelete) {
		this.deviceName = deviceName;
		this.buildNum = buildNum;
		this.roomNum = roomNum;
		this.useStatus = useStatus;
		this.createTime = createTime;
		this.dataStatus = dataStatus;
		this.dataType = dataType;
		this.dataOrder = dataOrder;
		this.dataDelete = dataDelete;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "device_id", unique = true, nullable = false, length = 40)
	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name = "device_name", length = 40)
	public String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	@Column(name = "build_num", length = 40)
	public String getBuildNum() {
		return this.buildNum;
	}

	public void setBuildNum(String buildNum) {
		this.buildNum = buildNum;
	}

	@Column(name = "room_num", length = 40)
	public String getRoomNum() {
		return this.roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	@Column(name = "use_status", length = 40)
	public String getUseStatus() {
		return this.useStatus;
	}

	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "data_status", length = 40)
	public String getDataStatus() {
		return this.dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	@Column(name = "data_type", length = 40)
	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@Column(name = "data_order")
	public Integer getDataOrder() {
		return this.dataOrder;
	}

	public void setDataOrder(Integer dataOrder) {
		this.dataOrder = dataOrder;
	}

	@Column(name = "data_delete", length = 40)
	public String getDataDelete() {
		return this.dataDelete;
	}

	public void setDataDelete(String dataDelete) {
		this.dataDelete = dataDelete;
	}

}