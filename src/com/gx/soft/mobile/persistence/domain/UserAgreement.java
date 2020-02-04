package com.gx.soft.mobile.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * UserAgreement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_agreement", catalog = "jbxqycy")
public class UserAgreement implements java.io.Serializable {

	// Fields

	private String rowId;
	private String openId;
	private String isAgree;
	private String agreementType;
	private String dataType;
	private String dataStatus;
	private String dataOrder;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public UserAgreement() {
	}

	/** full constructor */
	public UserAgreement(String openId, String isAgree, String agreementType,
			String dataType, String dataStatus, String dataOrder,
			String dataDelete) {
		this.openId = openId;
		this.isAgree = isAgree;
		this.agreementType = agreementType;
		this.dataType = dataType;
		this.dataStatus = dataStatus;
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

	@Column(name = "open_id", length = 40)
	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@Column(name = "is_agree", length = 40)
	public String getIsAgree() {
		return this.isAgree;
	}

	public void setIsAgree(String isAgree) {
		this.isAgree = isAgree;
	}

	@Column(name = "agreement_type", length = 40)
	public String getAgreementType() {
		return this.agreementType;
	}

	public void setAgreementType(String agreementType) {
		this.agreementType = agreementType;
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

	@Column(name = "data_order", length = 40)
	public String getDataOrder() {
		return this.dataOrder;
	}

	public void setDataOrder(String dataOrder) {
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