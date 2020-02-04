package com.gx.soft.fwzl.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * RcgyLeseApply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_fwzl_procinst", catalog = "jbxqycy")
public class VFwzlProcinst implements java.io.Serializable {

	// Fields

	private String rowId;
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
	private Timestamp createTime;

	private String processId;
	private String instanceId;

	private String instanceState;
	private String activeState;
	private String activeUserName;

	private Timestamp startTime;
	private Timestamp endTime;


	// Constructors

	/** default constructor */
	public VFwzlProcinst() {
	}

	public VFwzlProcinst(String rowId, String enterpriseName, Date applyDate, String enterpriseManager, String contactNumber, String apartmentType, Integer apartmentNumber,
						 String isAccordTzxyyd, Date checkInTime, String leaseTerm, String createUserId, String createUserName, Timestamp createTime, String processId,
						 String instanceId, String instanceState, String activeState, String activeUserName, Timestamp startTime, Timestamp endTime) {
		this.rowId = rowId;
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
		this.createTime = createTime;
		this.processId = processId;
		this.instanceId = instanceId;
		this.instanceState = instanceState;
		this.activeState = activeState;
		this.activeUserName = activeUserName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/** full constructor */


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

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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

}