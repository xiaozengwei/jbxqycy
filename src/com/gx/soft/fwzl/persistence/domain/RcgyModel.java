package com.gx.soft.fwzl.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * RcgyModel entity. @author MyEclipse Persistence Tools
 * 样板间表
 */
@Entity
@Table(name = "rcgy_model", catalog = "jbxqycy")
public class RcgyModel implements java.io.Serializable {

	// Fields

	private String rowId;
	private String modelName;
	private String pictureName;
	private String pictureIdentifyName;
	private String pictureAddress;
	private String pictureRemark;

	// Constructors

	/** default constructor */
	public RcgyModel() {
	}

	/** full constructor */
	public RcgyModel(String modelName, String pictureName,
			String pictureIdentifyName, String pictureAddress,
			String pictureRemark) {
		this.modelName = modelName;
		this.pictureName = pictureName;
		this.pictureIdentifyName = pictureIdentifyName;
		this.pictureAddress = pictureAddress;
		this.pictureRemark = pictureRemark;
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

	@Column(name = "model_name", length = 40)
	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	@Column(name = "picture_name", length = 200)
	public String getPictureName() {
		return this.pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	@Column(name = "picture_identify_name", length = 200)
	public String getPictureIdentifyName() {
		return this.pictureIdentifyName;
	}

	public void setPictureIdentifyName(String pictureIdentifyName) {
		this.pictureIdentifyName = pictureIdentifyName;
	}

	@Column(name = "picture_address", length = 200)
	public String getPictureAddress() {
		return this.pictureAddress;
	}

	public void setPictureAddress(String pictureAddress) {
		this.pictureAddress = pictureAddress;
	}

	@Column(name = "picture_remark", length = 200)
	public String getPictureRemark() {
		return this.pictureRemark;
	}

	public void setPictureRemark(String pictureRemark) {
		this.pictureRemark = pictureRemark;
	}

}