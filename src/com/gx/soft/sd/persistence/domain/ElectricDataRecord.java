package com.gx.soft.sd.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ElectricDataRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "electric_data_record", catalog = "jbxqycy")
public class ElectricDataRecord implements java.io.Serializable {

	// Fields

	private String rowId;
	private String deviceId;
	private Double currentNumber;
	private Timestamp sendTime;

	// Constructors

	/** default constructor */
	public ElectricDataRecord() {
	}

	/** full constructor */
	public ElectricDataRecord(String deviceId, Double currentNumber,
			Timestamp sendTime) {
		this.deviceId = deviceId;
		this.currentNumber = currentNumber;
		this.sendTime = sendTime;
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

	@Column(name = "device_id", length = 40)
	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name = "current_number", precision = 22, scale = 0)
	public Double getCurrentNumber() {
		return this.currentNumber;
	}

	public void setCurrentNumber(Double currentNumber) {
		this.currentNumber = currentNumber;
	}

	@Column(name = "send_time", length = 19)
	public Timestamp getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

}