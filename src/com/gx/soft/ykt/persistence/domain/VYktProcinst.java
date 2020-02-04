package com.gx.soft.ykt.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * VYktProcinst entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_ykt_procinst", catalog = "jbxqycy")
public class VYktProcinst implements java.io.Serializable {

	// Fields

	private String rowId;
	private String applicantName;
	private String applicantPhone;
	private String applicantIdCard;
	private String companyName;
	private Integer cardNumber;
	private String receivePlace;
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
	public VYktProcinst() {
	}

	/** minimal constructor */
	public VYktProcinst(String instanceId) {
		this.instanceId = instanceId;
	}

	/** full constructor */
	public VYktProcinst(String applicantName, String applicantPhone,
			String applicantIdCard, String companyName, Integer cardNumber,
			String receivePlace, String createUserId, String createUserName,
			Timestamp createTime, String processId, String instanceId,
			String instanceState, String activeState, String activeUserName,
			Timestamp startTime, Timestamp endTime) {
		this.applicantName = applicantName;
		this.applicantPhone = applicantPhone;
		this.applicantIdCard = applicantIdCard;
		this.companyName = companyName;
		this.cardNumber = cardNumber;
		this.receivePlace = receivePlace;
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

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "row_id", nullable = false, length = 40)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
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

	@Column(name = "card_number")
	public Integer getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Column(name = "receive_place", length = 40)
	public String getReceivePlace() {
		return this.receivePlace;
	}

	public void setReceivePlace(String receivePlace) {
		this.receivePlace = receivePlace;
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

	@Column(name = "process_id", length = 40)
	public String getProcessId() {
		return this.processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	@Column(name = "instance_id", nullable = false, length = 40)
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