package com.gx.soft.sd.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * WxUserYkt entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wx_user_ykt", catalog = "jbxqycy")
public class WxUserYkt implements java.io.Serializable {

	// Fields

	private String rowId;
	private String wxUserId;
	private String yktId;
	private Timestamp createTime;
	private String dataStatus;
	private String dataType;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public WxUserYkt() {
	}

	/** full constructor */
	public WxUserYkt(String wxUserId, String yktId, Timestamp createTime,
			String dataStatus, String dataType, String dataDelete) {
		this.wxUserId = wxUserId;
		this.yktId = yktId;
		this.createTime = createTime;
		this.dataStatus = dataStatus;
		this.dataType = dataType;
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

	@Column(name = "wx_user_id", length = 40)
	public String getWxUserId() {
		return this.wxUserId;
	}

	public void setWxUserId(String wxUserId) {
		this.wxUserId = wxUserId;
	}

	@Column(name = "ykt_id", length = 40)
	public String getYktId() {
		return this.yktId;
	}

	public void setYktId(String yktId) {
		this.yktId = yktId;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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

	@Column(name = "data_delete", length = 40)
	public String getDataDelete() {
		return this.dataDelete;
	}

	public void setDataDelete(String dataDelete) {
		this.dataDelete = dataDelete;
	}

}