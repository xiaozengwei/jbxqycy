package com.gx.soft.fwzl.persistence.domain;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * RcgyLeseApply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rcgy_lese_apply", catalog = "jbxqycy")
public class RcgyLeseApply implements java.io.Serializable {

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
	private String modifyUserId;
	private String modifyUserName;
	private Timestamp modifyTime;
	private String dateType;
	private String dataStatus;
	private String dataOrder;
	private String dataDeleted;

	// Constructors

	/** default constructor */
	public RcgyLeseApply() {
	}

	/** minimal constructor */
	public RcgyLeseApply(Timestamp createTime) {
		this.createTime = createTime;
	}

	/** full constructor */
	public RcgyLeseApply(String enterpriseName, Date applyDate,
			String enterpriseManager, String contactNumber,
			String apartmentType, Integer apartmentNumber,
			String isAccordTzxyyd, Date checkInTime, String leaseTerm,
			String createUserId, String createUserName, Timestamp createTime,
			String modifyUserId, String modifyUserName, Timestamp modifyTime,
			String dateType, String dataStatus, String dataOrder,
			String dataDeleted) {
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
		this.modifyUserId = modifyUserId;
		this.modifyUserName = modifyUserName;
		this.modifyTime = modifyTime;
		this.dateType = dateType;
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

	@Column(name = "modify_user_id", length = 40)
	public String getModifyUserId() {
		return this.modifyUserId;
	}

	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	@Column(name = "modify_user_name", length = 40)
	public String getModifyUserName() {
		return this.modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}

	@Column(name = "modify_time", length = 19)
	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Column(name = "date_type", length = 40)
	public String getDateType() {
		return this.dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
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