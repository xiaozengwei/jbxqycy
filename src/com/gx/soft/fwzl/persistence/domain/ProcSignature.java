package com.gx.soft.fwzl.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ProcSignature entity. @author MyEclipse Persistence Tools
 * 流程意见表
 */
@Entity
@Table(name = "proc_signature", catalog = "jbxqycy")
public class ProcSignature implements java.io.Serializable {

	// Fields

	private String rowId;
	private String tableId;
	private String tableName;
	private String piId;
	private String controlName;
	private String optionContext;
	private String createId;
	private String createName;
	private Timestamp createTime;
	private String dataDeleted;

	// Constructors

	/** default constructor */
	public ProcSignature() {
	}

	/** minimal constructor */
	public ProcSignature(Timestamp createTime) {
		this.createTime = createTime;
	}

	/** full constructor */
	public ProcSignature(String tableId, String tableName, String piId,
			String controlName, String optionContext, String createId,
			String createName, Timestamp createTime, String dataDeleted) {
		this.tableId = tableId;
		this.tableName = tableName;
		this.piId = piId;
		this.controlName = controlName;
		this.optionContext = optionContext;
		this.createId = createId;
		this.createName = createName;
		this.createTime = createTime;
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

	@Column(name = "table_id", length = 40)
	public String getTableId() {
		return this.tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	@Column(name = "table_name", length = 40)
	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Column(name = "pi_id", length = 40)
	public String getPiId() {
		return this.piId;
	}

	public void setPiId(String piId) {
		this.piId = piId;
	}

	@Column(name = "control_name", length = 40)
	public String getControlName() {
		return this.controlName;
	}

	public void setControlName(String controlName) {
		this.controlName = controlName;
	}

	@Column(name = "option_context", length = 120)
	public String getOptionContext() {
		return this.optionContext;
	}

	public void setOptionContext(String optionContext) {
		this.optionContext = optionContext;
	}

	@Column(name = "create_id", length = 40)
	public String getCreateId() {
		return this.createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	@Column(name = "create_name", length = 40)
	public String getCreateName() {
		return this.createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "data_deleted", length = 40)
	public String getDataDeleted() {
		return this.dataDeleted;
	}

	public void setDataDeleted(String dataDeleted) {
		this.dataDeleted = dataDeleted;
	}

}