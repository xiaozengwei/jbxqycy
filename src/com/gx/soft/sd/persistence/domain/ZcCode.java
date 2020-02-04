package com.gx.soft.sd.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ZcCode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "zc_code", catalog = "jbxqycy")
public class ZcCode implements java.io.Serializable {

	// Fields

	private String rowId;
	private String zcCode;

	// Constructors

	/** default constructor */
	public ZcCode() {
	}

	/** full constructor */
	public ZcCode(String zcCode) {
		this.zcCode = zcCode;
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

	@Column(name = "zc_code", length = 40)
	public String getZcCode() {
		return this.zcCode;
	}

	public void setZcCode(String zcCode) {
		this.zcCode = zcCode;
	}

}