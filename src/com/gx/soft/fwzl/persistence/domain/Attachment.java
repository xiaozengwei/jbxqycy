package com.gx.soft.fwzl.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Attachment entity. @author MyEclipse Persistence Tools
 * 附件表
 */
@Entity
@Table(name = "attachment", catalog = "jbxqycy")
public class Attachment implements java.io.Serializable {

	// Fields

	private String rowId;
	private String relationId;
	private String attachName;
	private String attachType;
	private String attachFileIdentifyName;
	private String attachPath;
	private String uploadUserId;
	private String uploadUserName;
	private Timestamp uploadTime;
	private String dataType;
	private String dataStatus;
	private String dataOrder;
	private String dataDeleted;

	// Constructors

	/** default constructor */
	public Attachment() {
	}

	/** full constructor */
	public Attachment(String relationId, String attachName, String attachType,
			String attachFileIdentifyName, String attachPath,
			String uploadUserId, String uploadUserName, Timestamp uploadTime,
			String dataType, String dataStatus, String dataOrder,
			String dataDeleted) {
		this.relationId = relationId;
		this.attachName = attachName;
		this.attachType = attachType;
		this.attachFileIdentifyName = attachFileIdentifyName;
		this.attachPath = attachPath;
		this.uploadUserId = uploadUserId;
		this.uploadUserName = uploadUserName;
		this.uploadTime = uploadTime;
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

	@Column(name = "relation_id", length = 40)
	public String getRelationId() {
		return this.relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	@Column(name = "attach_name", length = 200)
	public String getAttachName() {
		return this.attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	@Column(name = "attach_type", length = 40)
	public String getAttachType() {
		return this.attachType;
	}

	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}

	@Column(name = "attach_file_identify_name", length = 200)
	public String getAttachFileIdentifyName() {
		return this.attachFileIdentifyName;
	}

	public void setAttachFileIdentifyName(String attachFileIdentifyName) {
		this.attachFileIdentifyName = attachFileIdentifyName;
	}

	@Column(name = "attach_path", length = 200)
	public String getAttachPath() {
		return this.attachPath;
	}

	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}

	@Column(name = "upload_user_id", length = 40)
	public String getUploadUserId() {
		return this.uploadUserId;
	}

	public void setUploadUserId(String uploadUserId) {
		this.uploadUserId = uploadUserId;
	}

	@Column(name = "upload_user_name", length = 40)
	public String getUploadUserName() {
		return this.uploadUserName;
	}

	public void setUploadUserName(String uploadUserName) {
		this.uploadUserName = uploadUserName;
	}

	@Column(name = "upload_time", length = 19)
	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
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