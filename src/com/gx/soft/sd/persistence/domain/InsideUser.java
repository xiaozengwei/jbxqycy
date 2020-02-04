package com.gx.soft.sd.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * InsideUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "inside_user", catalog = "jbxqycy")
public class InsideUser implements java.io.Serializable {

	// Fields

	private String rowId;
	private String mobilePhone;

	// Constructors

	/** default constructor */
	public InsideUser() {
	}

	/** full constructor */
	public InsideUser(String mobilePhone) {
		this.mobilePhone = mobilePhone;
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

	@Column(name = "mobile_phone", length = 40)
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

}