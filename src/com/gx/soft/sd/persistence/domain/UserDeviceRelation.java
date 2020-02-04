package com.gx.soft.sd.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * UserDeviceRelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_device_relation", catalog = "jbxqycy")
public class UserDeviceRelation implements java.io.Serializable {

	// Fields

	private String rowId;
	private String userCardId;
	private String userYktId;
	private String waterDeviceId;
	private String electricDeviceId;
	private Timestamp createTime;
	private String dataType;
	private String dataStatus;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public UserDeviceRelation() {
	}

	/** full constructor */
	public UserDeviceRelation(String userCardId, String userYktId,
			String waterDeviceId, String electricDeviceId,
			Timestamp createTime, String dataType, String dataStatus,
			String dataDelete) {
		this.userCardId = userCardId;
		this.userYktId = userYktId;
		this.waterDeviceId = waterDeviceId;
		this.electricDeviceId = electricDeviceId;
		this.createTime = createTime;
		this.dataType = dataType;
		this.dataStatus = dataStatus;
		this.dataDelete = dataDelete;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "row_id", unique = true, nullable = false, length = 40)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "user_card_id", length = 40)
	public String getUserCardId() {
		return this.userCardId;
	}

	public void setUserCardId(String userCardId) {
		this.userCardId = userCardId;
	}

	@Column(name = "user_ykt_id", length = 40)
	public String getUserYktId() {
		return this.userYktId;
	}

	public void setUserYktId(String userYktId) {
		this.userYktId = userYktId;
	}

	@Column(name = "water_device_id", length = 40)
	public String getWaterDeviceId() {
		return this.waterDeviceId;
	}

	public void setWaterDeviceId(String waterDeviceId) {
		this.waterDeviceId = waterDeviceId;
	}

	@Column(name = "electric_device_id", length = 40)
	public String getElectricDeviceId() {
		return this.electricDeviceId;
	}

	public void setElectricDeviceId(String electricDeviceId) {
		this.electricDeviceId = electricDeviceId;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "data_type", length = 40)
	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@Column(name = "data_status", length = 40)
	public String getDataStatus() {
		return this.dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	@Column(name = "data_delete", length = 40)
	public String getDataDelete() {
		return this.dataDelete;
	}

	public void setDataDelete(String dataDelete) {
		this.dataDelete = dataDelete;
	}

}