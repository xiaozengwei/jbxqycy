package com.gx.soft.sys.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_user")
public class VUser implements java.io.Serializable {

	// Fields

	private String VUserKey;
	private String orgName;
	private String POrgId;
	private String POrgName;
	private String orgType;
	private String orgId;
	private String userName;
	private String userPassword;
	private String userId;
	private String userType;
	private String userMobileNum;
	private String userStatus;
	private String sysColorId;
	private Long dataOrder;
	private String userRowId;
	private String uioRowId;
	

	// Constructors

	/** default constructor */
	public VUser() {
	}

	/** full constructor */
	public VUser(String orgName, String POrgId, String POrgName,
			String orgType, String orgId, String userName, String userPassword,
			String userId, String userType, String userMobileNum,
			String userStatus, String sysColorId, Long dataOrder) {
		this.orgName = orgName;
		this.POrgId = POrgId;
		this.POrgName = POrgName;
		this.orgType = orgType;
		this.orgId = orgId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userId = userId;
		this.userType = userType;
		this.userMobileNum = userMobileNum;
		this.userStatus = userStatus;
		this.sysColorId = sysColorId;
		this.dataOrder = dataOrder;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "v_user_key", length = 80)
	public String getVUserKey() {
		return this.VUserKey;
	}

	public void setVUserKey(String VUserKey) {
		this.VUserKey = VUserKey;
	}

	@Column(name = "org_name", length = 80)
	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(name = "p_org_id", length = 40)
	public String getPOrgId() {
		return this.POrgId;
	}

	public void setPOrgId(String POrgId) {
		this.POrgId = POrgId;
	}

	@Column(name = "p_org_name", length = 80)
	public String getPOrgName() {
		return this.POrgName;
	}

	public void setPOrgName(String POrgName) {
		this.POrgName = POrgName;
	}

	@Column(name = "org_type", length = 40)
	public String getOrgType() {
		return this.orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	@Column(name = "org_id", nullable = false, length = 40)
	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	@Column(name = "user_name", length = 80)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_password", length = 80)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "user_id", length = 40)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "user_type", length = 40)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "user_mobile_num", length = 40)
	public String getUserMobileNum() {
		return this.userMobileNum;
	}

	public void setUserMobileNum(String userMobileNum) {
		this.userMobileNum = userMobileNum;
	}

	@Column(name = "user_status", length = 40)
	public String getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Column(name = "sys_color_id", length = 80)
	public String getSysColorId() {
		return this.sysColorId;
	}

	public void setSysColorId(String sysColorId) {
		this.sysColorId = sysColorId;
	}

	@Column(name = "data_order")
	public Long getDataOrder() {
		return this.dataOrder;
	}

	public void setDataOrder(Long dataOrder) {
		this.dataOrder = dataOrder;
	}

	@Column(name = "user_row_id", length = 40)
	public String getUserRowId() {
		return userRowId;
	}

	public void setUserRowId(String userRowId) {
		this.userRowId = userRowId;
	}

	@Column(name = "uio_row_id", length = 40)
	public String getUioRowId() {
		return uioRowId;
	}

	public void setUioRowId(String uioRowId) {
		this.uioRowId = uioRowId;
	}

}