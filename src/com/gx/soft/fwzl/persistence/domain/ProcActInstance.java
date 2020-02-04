package com.gx.soft.fwzl.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ProcActInstance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "proc_act_instance", catalog = "jbxqycy")
public class ProcActInstance implements java.io.Serializable {

	// Fields

	private String rowId;
	private String processId;
	private String instanceId;
	private String businessId;
	private String actId;
	private String actName;
	private String handleUser;
	private String handleUser1;
	private String actBack;
	private String actNext;
	private Integer actOrder;
	private String actInstRemark;
	private String activeState;
	private String activeUserId;
	private String activeUserName;
	private Timestamp activeTime;
	private Timestamp finishTime;
	private String stepState;
	private Timestamp timeLimit;
	private String dataType;
	private String dataStatus;
	private String dataDeleted;

	// Constructors

	/** default constructor */
	public ProcActInstance() {
	}

	/** full constructor */
	public ProcActInstance(String processId, String instanceId,
			String businessId, String actId, String actName, String handleUser,
			String handleUser1, String actBack, String actNext,
			Integer actOrder, String actInstRemark, String activeState,
			String activeUserId, String activeUserName, Timestamp activeTime,
			Timestamp finishTime, String stepState, Timestamp timeLimit,
			String dataType, String dataStatus, String dataDeleted) {
		this.processId = processId;
		this.instanceId = instanceId;
		this.businessId = businessId;
		this.actId = actId;
		this.actName = actName;
		this.handleUser = handleUser;
		this.handleUser1 = handleUser1;
		this.actBack = actBack;
		this.actNext = actNext;
		this.actOrder = actOrder;
		this.actInstRemark = actInstRemark;
		this.activeState = activeState;
		this.activeUserId = activeUserId;
		this.activeUserName = activeUserName;
		this.activeTime = activeTime;
		this.finishTime = finishTime;
		this.stepState = stepState;
		this.timeLimit = timeLimit;
		this.dataType = dataType;
		this.dataStatus = dataStatus;
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

	@Column(name = "instance_id", length = 40)
	public String getInstanceId() {
		return this.instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	@Column(name = "business_id", length = 40)
	public String getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	@Column(name = "act_id", length = 40)
	public String getActId() {
		return this.actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	@Column(name = "act_name", length = 40)
	public String getActName() {
		return this.actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	@Column(name = "handle_user", length = 40)
	public String getHandleUser() {
		return this.handleUser;
	}

	public void setHandleUser(String handleUser) {
		this.handleUser = handleUser;
	}

	@Column(name = "handle_user1", length = 40)
	public String getHandleUser1() {
		return this.handleUser1;
	}

	public void setHandleUser1(String handleUser1) {
		this.handleUser1 = handleUser1;
	}

	@Column(name = "act_back", length = 40)
	public String getActBack() {
		return this.actBack;
	}

	public void setActBack(String actBack) {
		this.actBack = actBack;
	}

	@Column(name = "act_next", length = 40)
	public String getActNext() {
		return this.actNext;
	}

	public void setActNext(String actNext) {
		this.actNext = actNext;
	}

	@Column(name = "act_order", precision = 8, scale = 0)
	public Integer getActOrder() {
		return this.actOrder;
	}

	public void setActOrder(Integer actOrder) {
		this.actOrder = actOrder;
	}

	@Column(name = "act_inst_remark", length = 240)
	public String getActInstRemark() {
		return this.actInstRemark;
	}

	public void setActInstRemark(String actInstRemark) {
		this.actInstRemark = actInstRemark;
	}

	@Column(name = "active_state", length = 40)
	public String getActiveState() {
		return this.activeState;
	}

	public void setActiveState(String activeState) {
		this.activeState = activeState;
	}

	@Column(name = "active_user_id", length = 40)
	public String getActiveUserId() {
		return this.activeUserId;
	}

	public void setActiveUserId(String activeUserId) {
		this.activeUserId = activeUserId;
	}

	@Column(name = "active_user_name", length = 40)
	public String getActiveUserName() {
		return this.activeUserName;
	}

	public void setActiveUserName(String activeUserName) {
		this.activeUserName = activeUserName;
	}

	@Column(name = "active_time", length = 19)
	public Timestamp getActiveTime() {
		return this.activeTime;
	}

	public void setActiveTime(Timestamp activeTime) {
		this.activeTime = activeTime;
	}

	@Column(name = "finish_time", length = 19)
	public Timestamp getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}

	@Column(name = "step_state", length = 40)
	public String getStepState() {
		return this.stepState;
	}

	public void setStepState(String stepState) {
		this.stepState = stepState;
	}

	@Column(name = "time_limit", length = 19)
	public Timestamp getTimeLimit() {
		return this.timeLimit;
	}

	public void setTimeLimit(Timestamp timeLimit) {
		this.timeLimit = timeLimit;
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

	@Column(name = "data_deleted", length = 40)
	public String getDataDeleted() {
		return this.dataDeleted;
	}

	public void setDataDeleted(String dataDeleted) {
		this.dataDeleted = dataDeleted;
	}

}