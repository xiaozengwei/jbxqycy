package com.gx.soft.hys.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ProcActInstance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_meet_inst_act", catalog = "jbxqycy")
public class VMeetInstAct implements java.io.Serializable {

	// Fields

	//ai
	private String rowId;
	private String actId;
	private String actName;
	private String handleUser;
	private String handleUser1;
	private String actBack;
	private String actNext;
	private String activeState;
	private Timestamp activeTime;
	private Timestamp finishTime;
	private String stepState;

	//pi
	private String processId;
	private String instanceId;
	private String instanceState;

	//m
	private String businessId;
	private String applicantName;
	private String applicantPhone;
	private String applicantIdCard;
	private String companyName;
	private Timestamp startTime;
	private Timestamp endTime;
	private String selectedRoom;
	private String createUserId;
	private String createUserName;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public VMeetInstAct() {
	}

	/** full constructor */
	public VMeetInstAct(String rowId, String actId, String actName, String handleUser, String handleUser1, String actBack,
						String actNext, String activeState, Timestamp activeTime, Timestamp finishTime, String stepState,
						String processId, String instanceId, String instanceState, String businessId, String applicantName,
						String applicantPhone, String applicantIdCard, String companyName, Timestamp startTime, Timestamp endTime,
						String selectedRoom, String createUserId, String createUserName, Timestamp createTime) {
		this.rowId = rowId;
		this.actId = actId;
		this.actName = actName;
		this.handleUser = handleUser;
		this.handleUser1 = handleUser1;
		this.actBack = actBack;
		this.actNext = actNext;
		this.activeState = activeState;
		this.activeTime = activeTime;
		this.finishTime = finishTime;
		this.stepState = stepState;
		this.processId = processId;
		this.instanceId = instanceId;
		this.instanceState = instanceState;
		this.businessId = businessId;
		this.applicantName = applicantName;
		this.applicantPhone = applicantPhone;
		this.applicantIdCard = applicantIdCard;
		this.companyName = companyName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.selectedRoom = selectedRoom;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.createTime = createTime;
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

	@Column(name = "active_state", length = 40)
	public String getActiveState() {
		return this.activeState;
	}

	public void setActiveState(String activeState) {
		this.activeState = activeState;
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

	@Column(name = "instance_state", length = 40)
	public String getInstanceState() {
		return this.instanceState;
	}

	public void setInstanceState(String instanceState) {
		this.instanceState = instanceState;
	}

	@Column(name = "applicant_name", length = 40)
	public String getApplicantName() {
		return this.applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	@Column(name = "applicant_phone", length = 40)
	public String getApplicantPhone() {
		return this.applicantPhone;
	}

	public void setApplicantPhone(String applicantPhone) {
		this.applicantPhone = applicantPhone;
	}

	@Column(name = "applicant_id_card", length = 40)
	public String getApplicantIdCard() {
		return this.applicantIdCard;
	}

	public void setApplicantIdCard(String applicantIdCard) {
		this.applicantIdCard = applicantIdCard;
	}

	@Column(name = "company_name", length = 40)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	@Column(name = "selected_room", length = 40)
	public String getSelectedRoom() {
		return this.selectedRoom;
	}

	public void setSelectedRoom(String selectedRoom) {
		this.selectedRoom = selectedRoom;
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

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}