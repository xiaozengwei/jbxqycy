package com.gx.soft.sys.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * GxSysUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_sys_user", catalog = "jbxqycy")
public class GxSysUser implements java.io.Serializable {

	// Fields

	private String rowId;
	private String userName;
	private String userShowName;
	private String userEnName;
	private String userId;
	private Timestamp createTime;
	private String createUserId;
	private Timestamp modifyTime;
	private String modifyUserId;
	private String dataStatus;
	private Integer dataOrder;
	private String userMobileNum;
	private String userSex;
	private String userType;
	private String userPhoto;
	private String userMail;
	private String userLevel;
	private Integer powerLevel;
	private String userCardId;
	private String sysColorId;

	// Constructors

	/** default constructor */
	public GxSysUser() {
	}

	/** full constructor */
	public GxSysUser(String userName, String userShowName, String userEnName,
			String userId, Timestamp createTime, String createUserId,
			Timestamp modifyTime, String modifyUserId, String dataStatus,
			Integer dataOrder, String userMobileNum, String userSex,
			String userType, String userPhoto, String userMail,
			String userLevel, Integer powerLevel, String userCardId,
			String sysColorId) {
		this.userName = userName;
		this.userShowName = userShowName;
		this.userEnName = userEnName;
		this.userId = userId;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.modifyTime = modifyTime;
		this.modifyUserId = modifyUserId;
		this.dataStatus = dataStatus;
		this.dataOrder = dataOrder;
		this.userMobileNum = userMobileNum;
		this.userSex = userSex;
		this.userType = userType;
		this.userPhoto = userPhoto;
		this.userMail = userMail;
		this.userLevel = userLevel;
		this.powerLevel = powerLevel;
		this.userCardId = userCardId;
		this.sysColorId = sysColorId;
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

	@Column(name = "user_name", length = 80)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_show_name", length = 180)
	public String getUserShowName() {
		return this.userShowName;
	}

	public void setUserShowName(String userShowName) {
		this.userShowName = userShowName;
	}

	@Column(name = "user_en_name", length = 80)
	public String getUserEnName() {
		return this.userEnName;
	}

	public void setUserEnName(String userEnName) {
		this.userEnName = userEnName;
	}

	@Column(name = "user_id", length = 40)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	@Column(name = "modify_time", length = 19)
	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Column(name = "modify_user_id", length = 40)
	public String getModifyUserId() {
		return this.modifyUserId;
	}

	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	@Column(name = "data_status", length = 100)
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

	@Column(name = "user_mobile_num", length = 40)
	public String getUserMobileNum() {
		return this.userMobileNum;
	}

	public void setUserMobileNum(String userMobileNum) {
		this.userMobileNum = userMobileNum;
	}

	@Column(name = "user_sex", length = 80)
	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	@Column(name = "user_type", length = 40)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "user_photo", length = 80)
	public String getUserPhoto() {
		return this.userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	@Column(name = "user_mail", length = 80)
	public String getUserMail() {
		return this.userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	@Column(name = "user_level", length = 80)
	public String getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	@Column(name = "power_level")
	public Integer getPowerLevel() {
		return this.powerLevel;
	}

	public void setPowerLevel(Integer powerLevel) {
		this.powerLevel = powerLevel;
	}

	@Column(name = "user_card_id", length = 80)
	public String getUserCardId() {
		return this.userCardId;
	}

	public void setUserCardId(String userCardId) {
		this.userCardId = userCardId;
	}

	@Column(name = "sys_color_id", length = 80)
	public String getSysColorId() {
		return this.sysColorId;
	}

	public void setSysColorId(String sysColorId) {
		this.sysColorId = sysColorId;
	}

}