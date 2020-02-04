package com.gx.soft.fwzl.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ProcInstance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "proc_instance", catalog = "jbxqycy")
public class ProcInstance implements java.io.Serializable {

	// Fields

	private String rowId;
	private String processId;
	private String processName;
	private String businessId;
	private String instanceState;
	private String activeState;
	private String activeUserName;
	private Timestamp timeLimit;
	private Timestamp createTime;
	private Timestamp endTime;
	private String createUserId;
	private String createUserName;
	private String dataType;
	private String dataStatus;
	private Integer dataOrder;
	private String dataDeleted;

	// Constructors

	/** default constructor */
	public ProcInstance() {
	}

	/** full constructor */
	public ProcInstance(String processId, String processName,
			String businessId, String instanceState, String activeState,
			String activeUserName, Timestamp timeLimit, Timestamp createTime,
			Timestamp endTime, String createUserId, String createUserName,
			String dataType, String dataStatus, Integer dataOrder,
			String dataDeleted) {
		this.processId = processId;
		this.processName = processName;
		this.businessId = businessId;
		this.instanceState = instanceState;
		this.activeState = activeState;
		this.activeUserName = activeUserName;
		this.timeLimit = timeLimit;
		this.createTime = createTime;
		this.endTime = endTime;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
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

	@Column(name = "process_id", length = 40)
	public String getProcessId() {
		return this.processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	@Column(name = "process_name", length = 40)
	public String getProcessName() {
		return this.processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	@Column(name = "business_id", length = 40)
	public String getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	@Column(name = "instance_state", length = 40)
	public String getInstanceState() {
		return this.instanceState;
	}

	public void setInstanceState(String instanceState) {
		this.instanceState = instanceState;
	}

	@Column(name = "active_state", length = 40)
	public String getActiveState() {
		return this.activeState;
	}

	public void setActiveState(String activeState) {
		this.activeState = activeState;
	}

	@Column(name = "active_user_name", length = 40)
	public String getActiveUserName() {
		return this.activeUserName;
	}

	public void setActiveUserName(String activeUserName) {
		this.activeUserName = activeUserName;
	}

	@Column(name = "time_limit", length = 19)
	public Timestamp getTimeLimit() {
		return this.timeLimit;
	}

	public void setTimeLimit(Timestamp timeLimit) {
		this.timeLimit = timeLimit;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "end_time", length = 19)
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Column(name = "create_user_id", length = 40)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "create_user_name", length = 40)
	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
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

	@Column(name = "data_order", precision = 8, scale = 0)
	public Integer getDataOrder() {
		return this.dataOrder;
	}

	public void setDataOrder(Integer dataOrder) {
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