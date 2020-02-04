package com.gx.soft.mobile.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * EnterpriseInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "enterprise_info", catalog = "jbxqycy")
public class EnterpriseInfo implements java.io.Serializable {

	// Fields

	private String rowId;
	private String enterpriseName;
	private String enterpriseId;
	private String password;
	private String createUserId;
	private Timestamp createTime;
	private String isFirst;
	private String orgTyshxydm;
	private String orgAddress;
	private Integer floorNum;
	private String enterpriseType;
	private String contactName;
	private String contactPhone;
	private String businessLicense;
	private String legalPerson;
	private String dataStatus;
	private String dataType;
	private Integer dataOrder;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public EnterpriseInfo() {
	}

	/** full constructor */
	public EnterpriseInfo(String enterpriseName, String enterpriseId,
			String password, String createUserId, Timestamp createTime,
			String isFirst, String orgTyshxydm, String orgAddress,
			Integer floorNum, String enterpriseType, String contactName,
			String contactPhone, String businessLicense, String legalPerson,
			String dataStatus, String dataType, Integer dataOrder,
			String dataDelete) {
		this.enterpriseName = enterpriseName;
		this.enterpriseId = enterpriseId;
		this.password = password;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.isFirst = isFirst;
		this.orgTyshxydm = orgTyshxydm;
		this.orgAddress = orgAddress;
		this.floorNum = floorNum;
		this.enterpriseType = enterpriseType;
		this.contactName = contactName;
		this.contactPhone = contactPhone;
		this.businessLicense = businessLicense;
		this.legalPerson = legalPerson;
		this.dataStatus = dataStatus;
		this.dataType = dataType;
		this.dataOrder = dataOrder;
		this.dataDelete = dataDelete;
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

	@Column(name = "enterprise_name", length = 100)
	public String getEnterpriseName() {
		return this.enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	@Column(name = "enterprise_id", length = 40)
	public String getEnterpriseId() {
		return this.enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	@Column(name = "password", length = 40)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "create_user_id", length = 40)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "is_first", length = 40)
	public String getIsFirst() {
		return this.isFirst;
	}

	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}

	@Column(name = "org_tyshxydm", length = 40)
	public String getOrgTyshxydm() {
		return this.orgTyshxydm;
	}

	public void setOrgTyshxydm(String orgTyshxydm) {
		this.orgTyshxydm = orgTyshxydm;
	}

	@Column(name = "org_address", length = 100)
	public String getOrgAddress() {
		return this.orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	@Column(name = "floor_num")
	public Integer getFloorNum() {
		return this.floorNum;
	}

	public void setFloorNum(Integer floorNum) {
		this.floorNum = floorNum;
	}

	@Column(name = "enterprise_type", length = 40)
	public String getEnterpriseType() {
		return this.enterpriseType;
	}

	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

	@Column(name = "contact_name", length = 40)
	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Column(name = "contact_phone", length = 40)
	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	@Column(name = "business_license", length = 40)
	public String getBusinessLicense() {
		return this.businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	@Column(name = "legal_person", length = 40)
	public String getLegalPerson() {
		return this.legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	@Column(name = "data_status", length = 40)
	public String getDataStatus() {
		return this.dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	@Column(name = "data_type", length = 40)
	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@Column(name = "data_order")
	public Integer getDataOrder() {
		return this.dataOrder;
	}

	public void setDataOrder(Integer dataOrder) {
		this.dataOrder = dataOrder;
	}

	@Column(name = "data_delete", length = 40)
	public String getDataDelete() {
		return this.dataDelete;
	}

	public void setDataDelete(String dataDelete) {
		this.dataDelete = dataDelete;
	}

}