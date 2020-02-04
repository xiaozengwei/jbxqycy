package com.gx.soft.hys.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * MeetingRoomUseInfo entity. @author MyEclipse Persistence Tools
 * 会议室使用情况表
 */
@Entity
@Table(name = "meeting_room_use_info", catalog = "jbxqycy")
public class MeetingRoomUseInfo implements java.io.Serializable {

	// Fields

	private String rowId;
	private String roomId;
	private Timestamp startTime;
	private Timestamp endTime;
	private String businessId;
	private Timestamp createTime;
	private String dataType;
	private String dataStatus;
	private String dataOrder;
	private String dataDeleted;

	// Constructors

	/** default constructor */
	public MeetingRoomUseInfo() {
	}

	/** full constructor */
	public MeetingRoomUseInfo(String roomId, Timestamp startTime,
			Timestamp endTime, String businessId, Timestamp createTime,
			String dataType, String dataStatus, String dataOrder,
			String dataDeleted) {
		this.roomId = roomId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.businessId = businessId;
		this.createTime = createTime;
		this.dataType = dataType;
		this.dataStatus = dataStatus;
		this.dataOrder = dataOrder;
		this.dataDeleted = dataDeleted;
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

	@Column(name = "room_id", length = 40)
	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	@Column(name = "start_time", length = 19)
	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@Column(name = "end_time", length = 19)
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Column(name = "business_id", length = 40)
	public String getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
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

	@Column(name = "data_order", length = 40)
	public String getDataOrder() {
		return this.dataOrder;
	}

	public void setDataOrder(String dataOrder) {
		this.dataOrder = dataOrder;
	}

	@Column(name = "data_deleted", length = 40)
	public String getDataDeleted() {
		return this.dataDeleted;
	}

	public void setDataDeleted(String dataDeleted) {
		this.dataDeleted = dataDeleted;
	}

}