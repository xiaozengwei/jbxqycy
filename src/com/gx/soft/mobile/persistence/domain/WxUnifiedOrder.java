package com.gx.soft.mobile.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * WxUnifiedOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wx_unified_order", catalog = "jbxqycy")
public class WxUnifiedOrder implements java.io.Serializable {

	// Fields

	private String rowId;
	private String outTradeNo;
	private Integer totalFee;
	private String spbillCreateIp;
	private String prepayId;
	private String openid;
	private Timestamp createTime;
	private String orderState;
	private String dataStatus;
	private String dataType;
	private String dataOrder;
	private String dataDelete;
	private String roomId;
	private String rechargeType;

	// Constructors

	/** default constructor */
	public WxUnifiedOrder() {
	}

	/** full constructor */
	public WxUnifiedOrder(String outTradeNo, Integer totalFee,
			String spbillCreateIp, String prepayId, String openid,
			Timestamp createTime, String orderState, String dataStatus,
			String dataType, String dataOrder, String dataDelete,
			String roomId, String rechargeType) {
		this.outTradeNo = outTradeNo;
		this.totalFee = totalFee;
		this.spbillCreateIp = spbillCreateIp;
		this.prepayId = prepayId;
		this.openid = openid;
		this.createTime = createTime;
		this.orderState = orderState;
		this.dataStatus = dataStatus;
		this.dataType = dataType;
		this.dataOrder = dataOrder;
		this.dataDelete = dataDelete;
		this.roomId = roomId;
		this.rechargeType = rechargeType;
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

	@Column(name = "out_trade_no", length = 32)
	public String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	@Column(name = "total_fee")
	public Integer getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	@Column(name = "spbill_create_ip", length = 40)
	public String getSpbillCreateIp() {
		return this.spbillCreateIp;
	}

	public void setSpbillCreateIp(String spbillCreateIp) {
		this.spbillCreateIp = spbillCreateIp;
	}

	@Column(name = "prepay_id", length = 40)
	public String getPrepayId() {
		return this.prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	@Column(name = "openid", length = 40)
	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "order_state", length = 40)
	public String getOrderState() {
		return this.orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
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

	@Column(name = "room_id", length = 40)
	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	@Column(name = "recharge_type", length = 40)
	public String getRechargeType() {
		return this.rechargeType;
	}

	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}

}