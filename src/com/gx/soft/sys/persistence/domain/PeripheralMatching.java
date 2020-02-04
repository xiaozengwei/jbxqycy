package com.gx.soft.sys.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * PeripheralMatching entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "peripheral_matching", catalog = "jbxqycy")
public class PeripheralMatching implements java.io.Serializable {

	// Fields

	private String rowId;
	private String ptName;
	private String ptAddress;
	private String ptDetail;
	private String createUserId;
	private String createUserName;
	private Timestamp createTime;
	private String modifyUserId;
	private String modifyUserName;
	private Timestamp modifyTime;
	private String dataType;
	private String dataStatus;
	private Integer dataOrder;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public PeripheralMatching() {
	}

	/** full constructor */
	public PeripheralMatching(String ptName, String ptAddress, String ptDetail,
			String createUserId, String createUserName, Timestamp createTime,
			String modifyUserId, String modifyUserName, Timestamp modifyTime,
			String dataType, String dataStatus, Integer dataOrder,
			String dataDelete) {
		this.ptName = ptName;
		this.ptAddress = ptAddress;
		this.ptDetail = ptDetail;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.createTime = createTime;
		this.modifyUserId = modifyUserId;
		this.modifyUserName = modifyUserName;
		this.modifyTime = modifyTime;
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

	@Column(name = "pt_name", length = 40)
	public String getPtName() {
		return this.ptName;
	}

	public void setPtName(String ptName) {
		this.ptName = ptName;
	}

	@Column(name = "pt_address", length = 120)
	public String getPtAddress() {
		return this.ptAddress;
	}

	public void setPtAddress(String ptAddress) {
		this.ptAddress = ptAddress;
	}

	@Column(name = "pt_detail", length = 500)
	public String getPtDetail() {
		return this.ptDetail;
	}

	public void setPtDetail(String ptDetail) {
		this.ptDetail = ptDetail;
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

	@Column(name = "create_time", length = 19)
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