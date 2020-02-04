package com.gx.soft.sd.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SdRechargeRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sd_recharge_record", catalog = "jbxqycy")
public class SdRechargeRecord implements java.io.Serializable {

	// Fields

	private String rowId;
	private String outTradeNo;
	private String roomId;
	private String deviceId;
	private String userName;
	private String openId;
	private String userIdCard;
	private String userPhone;
	private String rechargeType;
	private String payType;
	private Double rechargeMoney;
	private Timestamp rechargeTime;
	private String dataStatus;
	private String dataType;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public SdRechargeRecord() {
	}

	/** full constructor */
	public SdRechargeRecord(String outTradeNo, String roomId, String deviceId,
			String userName, String openId, String userIdCard,
			String userPhone, String rechargeType, String payType,
			Double rechargeMoney, Timestamp rechargeTime, String dataStatus,
			String dataType, String dataDelete) {
		this.outTradeNo = outTradeNo;
		this.roomId = roomId;
		this.deviceId = deviceId;
		this.userName = userName;
		this.openId = openId;
		this.userIdCard = userIdCard;
		this.userPhone = userPhone;
		this.rechargeType = rechargeType;
		this.payType = payType;
		this.rechargeMoney = rechargeMoney;
		this.rechargeTime = rechargeTime;
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

	@Column(name = "out_trade_no", length = 40)
	public String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	@Column(name = "room_id", length = 40)
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

	@Column(name = "user_name", length = 40)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "open_id", length = 40)
	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@Column(name = "user_id_card", length = 40)
	public String getUserIdCard() {
		return this.userIdCard;
	}

	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}

	@Column(name = "user_phone", length = 40)
	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "recharge_type", length = 40)
	public String getRechargeType() {
		return this.rechargeType;
	}

	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}

	@Column(name = "pay_type", length = 40)
	public String getPayType() {
		return this.payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	@Column(name = "recharge_money", precision = 22, scale = 0)
	public Double getRechargeMoney() {
		return this.rechargeMoney;
	}

	public void setRechargeMoney(Double rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}

	@Column(name = "recharge_time", length = 19)
	public Timestamp getRechargeTime() {
		return this.rechargeTime;
	}

	public void setRechargeTime(Timestamp rechargeTime) {
		this.rechargeTime = rechargeTime;
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