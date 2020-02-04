package com.gx.soft.sd.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SdRefundRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sd_refund_record", catalog = "jbxqycy")
public class SdRefundRecord implements java.io.Serializable {

	// Fields

	private String rowId;
	private String roomId;
	private String deviceId;
	private String refundType;
	private Double refundMoney;
	private Timestamp refundTime;
	private String payType;
	private String outTradeNo;
	private String outRefundNo;
	private String refundDesc;
	private String refundUserId;
	private String refundUserName;
	private String operateUserId;
	private String operateUserName;

	// Constructors

	/** default constructor */
	public SdRefundRecord() {
	}

	/** full constructor */
	public SdRefundRecord(String roomId, String deviceId, String refundType,
			Double refundMoney, Timestamp refundTime, String payType,
			String outTradeNo, String outRefundNo, String refundDesc,
			String refundUserId, String refundUserName, String operateUserId,
			String operateUserName) {
		this.roomId = roomId;
		this.deviceId = deviceId;
		this.refundType = refundType;
		this.refundMoney = refundMoney;
		this.refundTime = refundTime;
		this.payType = payType;
		this.outTradeNo = outTradeNo;
		this.outRefundNo = outRefundNo;
		this.refundDesc = refundDesc;
		this.refundUserId = refundUserId;
		this.refundUserName = refundUserName;
		this.operateUserId = operateUserId;
		this.operateUserName = operateUserName;
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

	@Column(name = "roomId", length = 40)
	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	@Column(name = "device_id", length = 40)
	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Column(name = "refund_type", length = 40)
	public String getRefundType() {
		return this.refundType;
	}

	public void setRefundType(String refundType) {
		this.refundType = refundType;
	}

	@Column(name = "refund_money", precision = 22, scale = 0)
	public Double getRefundMoney() {
		return this.refundMoney;
	}

	public void setRefundMoney(Double refundMoney) {
		this.refundMoney = refundMoney;
	}

	@Column(name = "refund_time", length = 19)
	public Timestamp getRefundTime() {
		return this.refundTime;
	}

	public void setRefundTime(Timestamp refundTime) {
		this.refundTime = refundTime;
	}

	@Column(name = "pay_type", length = 40)
	public String getPayType() {
		return this.payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	@Column(name = "out_trade_no", length = 40)
	public String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	@Column(name = "out_refund_no", length = 40)
	public String getOutRefundNo() {
		return this.outRefundNo;
	}

	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}

	@Column(name = "refund_desc", length = 200)
	public String getRefundDesc() {
		return this.refundDesc;
	}

	public void setRefundDesc(String refundDesc) {
		this.refundDesc = refundDesc;
	}

	@Column(name = "refund_user_id", length = 40)
	public String getRefundUserId() {
		return this.refundUserId;
	}

	public void setRefundUserId(String refundUserId) {
		this.refundUserId = refundUserId;
	}

	@Column(name = "refund_user_name", length = 40)
	public String getRefundUserName() {
		return this.refundUserName;
	}

	public void setRefundUserName(String refundUserName) {
		this.refundUserName = refundUserName;
	}

	@Column(name = "operate_user_id", length = 40)
	public String getOperateUserId() {
		return this.operateUserId;
	}

	public void setOperateUserId(String operateUserId) {
		this.operateUserId = operateUserId;
	}

	@Column(name = "operate_user_name", length = 40)
	public String getOperateUserName() {
		return this.operateUserName;
	}

	public void setOperateUserName(String operateUserName) {
		this.operateUserName = operateUserName;
	}

}