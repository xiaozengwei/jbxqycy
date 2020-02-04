package com.gx.soft.ykt.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * OneCardApply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "one_card_apply", catalog = "jbxqycy")
public class OneCardApply implements java.io.Serializable {

	// Fields

	private String rowId;
	private String applicantName;
	private String applicantPhone;
	private String applicantIdCard;
	private String companyName;
	private String receivePlace;
	private String verificationCode;
	private Integer cardNumber;
	private Integer payMoney;
	private String outTradeNo;
	private String createUserId;
	private String createUserName;
	private Timestamp createTime;
	private String modifyUserId;
	private String modifyUserName;
	private Timestamp modifyTime;
	private String dataType;
	private String dataStatus;
	private String dataOrder;
	private String dataDeleted;
	private String isReceive;

	// Constructors

	/** default constructor */
	public OneCardApply() {
	}

	/** full constructor */
	public OneCardApply(String applicantName, String applicantPhone,
			String applicantIdCard, String companyName, String receivePlace,
			String verificationCode, Integer cardNumber, Integer payMoney,
			String outTradeNo, String createUserId, String createUserName,
			Timestamp createTime, String modifyUserId, String modifyUserName,
			Timestamp modifyTime, String dataType, String dataStatus,
			String dataOrder, String dataDeleted, String isReceive) {
		this.applicantName = applicantName;
		this.applicantPhone = applicantPhone;
		this.applicantIdCard = applicantIdCard;
		this.companyName = companyName;
		this.receivePlace = receivePlace;
		this.verificationCode = verificationCode;
		this.cardNumber = cardNumber;
		this.payMoney = payMoney;
		this.outTradeNo = outTradeNo;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.createTime = createTime;
		this.modifyUserId = modifyUserId;
		this.modifyUserName = modifyUserName;
		this.modifyTime = modifyTime;
		this.dataType = dataType;
		this.dataStatus = dataStatus;
		this.dataOrder = dataOrder;
		this.dataDeleted = dataDeleted;
		this.isReceive = isReceive;
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

	@Column(name = "applicant_name", length = 40)
	public String getApplicantName() {
		return this.applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	@Column(name = "applicant_phone", length = 40)
	public String getApplicantPhone() {
		return this.applicantPhone;
	}

	public void setApplicantPhone(String applicantPhone) {
		this.applicantPhone = applicantPhone;
	}

	@Column(name = "applicant_id_card", length = 40)
	public String getApplicantIdCard() {
		return this.applicantIdCard;
	}

	public void setApplicantIdCard(String applicantIdCard) {
		this.applicantIdCard = applicantIdCard;
	}

	@Column(name = "company_name", length = 40)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "receive_place", length = 40)
	public String getReceivePlace() {
		return this.receivePlace;
	}

	public void setReceivePlace(String receivePlace) {
		this.receivePlace = receivePlace;
	}

	@Column(name = "verification_code", length = 40)
	public String getVerificationCode() {
		return this.verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	@Column(name = "card_number")
	public Integer getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Column(name = "pay_money")
	public Integer getPayMoney() {
		return this.payMoney;
	}

	public void setPayMoney(Integer payMoney) {
		this.payMoney = payMoney;
	}

	@Column(name = "out_trade_no", length = 40)
	public String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
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

	@Column(name = "is_receive", length = 40)
	public String getIsReceive() {
		return this.isReceive;
	}

	public void setIsReceive(String isReceive) {
		this.isReceive = isReceive;
	}

}