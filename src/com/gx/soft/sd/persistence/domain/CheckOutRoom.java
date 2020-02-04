package com.gx.soft.sd.persistence.domain;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * CheckOutRoom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "check_out_room", catalog = "jbxqycy")
public class CheckOutRoom implements java.io.Serializable {

	// Fields

	private String rowId;
	private String roomId;
	private String wxUserId;
	private String userName;
	private String userIdCard;
	private String userPhone;
	private Double electricBalance;
	private Double waterBalance;
	private Double waterNumberOne;
	private Double waterNumberTwo;
	private Date cbTime;
	private Double lastWaterNumberOne;
	private Double lastWaterNumberTwo;
	private Date lastCbTime;
	private Double waterUse;
	private Double refundMoney;
	private Double backMoney;
	private Timestamp createTime;
	private String dataType;
	private String dataStatus;
	private String dataOrder;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public CheckOutRoom() {
	}

	/** full constructor */
	public CheckOutRoom(String roomId, String wxUserId, String userName,
			String userIdCard, String userPhone, Double electricBalance,
			Double waterBalance, Double waterNumberOne, Double waterNumberTwo,
			Date cbTime, Double lastWaterNumberOne, Double lastWaterNumberTwo,
			Date lastCbTime, Double waterUse, Double refundMoney,
			Double backMoney, Timestamp createTime, String dataType,
			String dataStatus, String dataOrder, String dataDelete) {
		this.roomId = roomId;
		this.wxUserId = wxUserId;
		this.userName = userName;
		this.userIdCard = userIdCard;
		this.userPhone = userPhone;
		this.electricBalance = electricBalance;
		this.waterBalance = waterBalance;
		this.waterNumberOne = waterNumberOne;
		this.waterNumberTwo = waterNumberTwo;
		this.cbTime = cbTime;
		this.lastWaterNumberOne = lastWaterNumberOne;
		this.lastWaterNumberTwo = lastWaterNumberTwo;
		this.lastCbTime = lastCbTime;
		this.waterUse = waterUse;
		this.refundMoney = refundMoney;
		this.backMoney = backMoney;
		this.createTime = createTime;
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

	@Column(name = "room_id", length = 40)
	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	@Column(name = "wx_user_id", length = 40)
	public String getWxUserId() {
		return this.wxUserId;
	}

	public void setWxUserId(String wxUserId) {
		this.wxUserId = wxUserId;
	}

	@Column(name = "user_name", length = 40)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	@Column(name = "electric_balance", precision = 22, scale = 0)
	public Double getElectricBalance() {
		return this.electricBalance;
	}

	public void setElectricBalance(Double electricBalance) {
		this.electricBalance = electricBalance;
	}

	@Column(name = "water_balance", precision = 22, scale = 0)
	public Double getWaterBalance() {
		return this.waterBalance;
	}

	public void setWaterBalance(Double waterBalance) {
		this.waterBalance = waterBalance;
	}

	@Column(name = "water_number_one", precision = 22, scale = 0)
	public Double getWaterNumberOne() {
		return this.waterNumberOne;
	}

	public void setWaterNumberOne(Double waterNumberOne) {
		this.waterNumberOne = waterNumberOne;
	}

	@Column(name = "water_number_two", precision = 22, scale = 0)
	public Double getWaterNumberTwo() {
		return this.waterNumberTwo;
	}

	public void setWaterNumberTwo(Double waterNumberTwo) {
		this.waterNumberTwo = waterNumberTwo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "cb_time", length = 10)
	public Date getCbTime() {
		return this.cbTime;
	}

	public void setCbTime(Date cbTime) {
		this.cbTime = cbTime;
	}

	@Column(name = "last_water_number_one", precision = 22, scale = 0)
	public Double getLastWaterNumberOne() {
		return this.lastWaterNumberOne;
	}

	public void setLastWaterNumberOne(Double lastWaterNumberOne) {
		this.lastWaterNumberOne = lastWaterNumberOne;
	}

	@Column(name = "last_water_number_two", precision = 22, scale = 0)
	public Double getLastWaterNumberTwo() {
		return this.lastWaterNumberTwo;
	}

	public void setLastWaterNumberTwo(Double lastWaterNumberTwo) {
		this.lastWaterNumberTwo = lastWaterNumberTwo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "last_cb_time", length = 10)
	public Date getLastCbTime() {
		return this.lastCbTime;
	}

	public void setLastCbTime(Date lastCbTime) {
		this.lastCbTime = lastCbTime;
	}

	@Column(name = "water_use", precision = 22, scale = 0)
	public Double getWaterUse() {
		return this.waterUse;
	}

	public void setWaterUse(Double waterUse) {
		this.waterUse = waterUse;
	}

	@Column(name = "refund_money", precision = 22, scale = 0)
	public Double getRefundMoney() {
		return this.refundMoney;
	}

	public void setRefundMoney(Double refundMoney) {
		this.refundMoney = refundMoney;
	}

	@Column(name = "back_money", precision = 22, scale = 0)
	public Double getBackMoney() {
		return this.backMoney;
	}

	public void setBackMoney(Double backMoney) {
		this.backMoney = backMoney;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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

	@Column(name = "data_delete", length = 40)
	public String getDataDelete() {
		return this.dataDelete;
	}

	public void setDataDelete(String dataDelete) {
		this.dataDelete = dataDelete;
	}

}