package com.gx.soft.fwzl.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * GzhArticle entity. @author MyEclipse Persistence Tools
 * 公众号文章栏目表
 */
@Entity
@Table(name = "gzh_article", catalog = "jbxqycy")
public class GzhArticle implements java.io.Serializable {

	// Fields

	private String rowId;
	private String columnTitle;
	private String columnContext;
	private Timestamp createTime;
	private String createUserId;
	private String createUserName;
	private String modifyUserId;
	private String modifyUserName;
	private Timestamp modifyTime;
	private String dataType;
	private String dataStatus;
	private String dataOrder;
	private String dataDeleted;

	// Constructors

	/** default constructor */
	public GzhArticle() {
	}

	/** full constructor */
	public GzhArticle(String columnTitle, String columnContext,
			Timestamp createTime, String createUserId, String createUserName,
			String modifyUserId, String modifyUserName, Timestamp modifyTime,
			String dataType, String dataStatus, String dataOrder,
			String dataDeleted) {
		this.columnTitle = columnTitle;
		this.columnContext = columnContext;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.modifyUserId = modifyUserId;
		this.modifyUserName = modifyUserName;
		this.modifyTime = modifyTime;
		this.dataType = dataType;
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

	@Column(name = "column_title", length = 40)
	public String getColumnTitle() {
		return this.columnTitle;
	}

	public void setColumnTitle(String columnTitle) {
		this.columnTitle = columnTitle;
	}

	@Column(name = "column_context", length = 1000)
	public String getColumnContext() {
		return this.columnContext;
	}

	public void setColumnContext(String columnContext) {
		this.columnContext = columnContext;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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

	@Column(name = "data_deleted", length = 40)
	public String getDataDeleted() {
		return this.dataDeleted;
	}

	public void setDataDeleted(String dataDeleted) {
		this.dataDeleted = dataDeleted;
	}

}