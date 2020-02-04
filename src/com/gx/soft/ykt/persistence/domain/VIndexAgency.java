package com.gx.soft.ykt.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * ProcActInstance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_index_agency", catalog = "jbxqycy")
public class VIndexAgency implements java.io.Serializable {

	// Fields

	//ai
	private String rowId;
	private String actId;
	private String actName;
	private String handleUser;
	private String handleUser1;
	private String activeState;

	//pi
	private String processId;
	private String processName;
	private String instanceId;
	private String instanceState;

	//o
	private String businessId;
	private String companyName;
	private String applicantName;
	private Timestamp createTime;


	// Constructors

	/** default constructor */
	public VIndexAgency() {
	}

	/** full constructor */
	public VIndexAgency(String rowId, String actId, String actName, String handleUser, String handleUser1, String activeState,
						String processId, String instanceId, String instanceState, String processName, String businessId,
						String companyName, String applicantName, Timestamp createTime) {
		this.rowId = rowId;
		this.actId = actId;
		this.actName = actName;
		this.handleUser = handleUser;
		this.handleUser1 = handleUser1;
		this.activeState = activeState;
		this.processId = processId;
		this.instanceId = instanceId;
		this.instanceState = instanceState;
		this.processName = processName;
		this.businessId = businessId;
		this.companyName = companyName;
		this.applicantName = applicantName;
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


	@Column(name = "active_state", length = 40)
	public String getActiveState() {
		return this.activeState;
	}

	public void setActiveState(String activeState) {
		this.activeState = activeState;
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


	@Column(name = "company_name", length = 40)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "process_name", length = 40)
	public String getProcessName() {
		return this.processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

}