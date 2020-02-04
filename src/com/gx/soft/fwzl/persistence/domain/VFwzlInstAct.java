package com.gx.soft.fwzl.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * ProcActInstance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_fwzl_inst_act", catalog = "jbxqycy")
public class VFwzlInstAct implements java.io.Serializable {

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

	//r
	private String businessId;
	private String enterpriseName;
	private Date applyDate;
	private String enterpriseManager;
	private String contactNumber;
	private String apartmentType;
	private Integer apartmentNumber;
	private String isAccordTzxyyd;
	private Date checkInTime;
	private String leaseTerm;
	private String createUserId;
	private String createUserName;

	// Constructors

	/** default constructor */
	public VFwzlInstAct() {
	}

	/** full constructor */
	public VFwzlInstAct(String rowId, String actId, String actName, String handleUser, String handleUser1, String actBack, String actNext, String activeState,
						Timestamp activeTime, Timestamp finishTime, String stepState, String processId, String instanceId, String instanceState, String businessId,
						String enterpriseName, Date applyDate, String enterpriseManager, String contactNumber, String apartmentType, Integer apartmentNumber,
						String isAccordTzxyyd, Date checkInTime, String leaseTerm, String createUserId, String createUserName) {
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
		this.enterpriseName = enterpriseName;
		this.applyDate = applyDate;
		this.enterpriseManager = enterpriseManager;
		this.contactNumber = contactNumber;
		this.apartmentType = apartmentType;
		this.apartmentNumber = apartmentNumber;
		this.isAccordTzxyyd = isAccordTzxyyd;
		this.checkInTime = checkInTime;
		this.leaseTerm = leaseTerm;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
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

	@Column(name = "enterprise_name", length = 120)
	public String getEnterpriseName() {
		return this.enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "apply_date", length = 10)
	public Date getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	@Column(name = "enterprise_manager", length = 40)
	public String getEnterpriseManager() {
		return this.enterpriseManager;
	}

	public void setEnterpriseManager(String enterpriseManager) {
		this.enterpriseManager = enterpriseManager;
	}

	@Column(name = "contact_number", length = 40)
	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Column(name = "apartment_type", length = 40)
	public String getApartmentType() {
		return this.apartmentType;
	}

	public void setApartmentType(String apartmentType) {
		this.apartmentType = apartmentType;
	}

	@Column(name = "apartment_number")
	public Integer getApartmentNumber() {
		return this.apartmentNumber;
	}

	public void setApartmentNumber(Integer apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	@Column(name = "is_accord_tzxyyd", length = 40)
	public String getIsAccordTzxyyd() {
		return this.isAccordTzxyyd;
	}

	public void setIsAccordTzxyyd(String isAccordTzxyyd) {
		this.isAccordTzxyyd = isAccordTzxyyd;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "check_in_time", length = 10)
	public Date getCheckInTime() {
		return this.checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	@Column(name = "lease_term", length = 40)
	public String getLeaseTerm() {
		return this.leaseTerm;
	}

	public void setLeaseTerm(String leaseTerm) {
		this.leaseTerm = leaseTerm;
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
}