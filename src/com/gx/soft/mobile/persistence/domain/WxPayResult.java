package com.gx.soft.mobile.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * WxPayResult entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wx_pay_result", catalog = "jbxqycy")
public class WxPayResult implements java.io.Serializable {

	// Fields

	private String rowId;
	private String resultCode;
	private String errCode;
	private String errCodeDes;
	private String openid;
	private String isSubscribe;
	private String bankType;
	private Integer totalFee;
	private Integer settlementTotalFee;
	private String feeType;
	private Integer cashFee;
	private String cashFeeType;
	private Integer couponFee;
	private Integer couponCount;
	private String couponTypeSingle;
	private String couponIdSingle;
	private Integer couponFeeSingle;
	private String transactionId;
	private String outTradeNo;
	private String timeEnd;
	private String dataStatus;
	private String dataType;
	private String dataOrder;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public WxPayResult() {
	}

	/** full constructor */
	public WxPayResult(String resultCode, String errCode, String errCodeDes,
			String openid, String isSubscribe, String bankType,
			Integer totalFee, Integer settlementTotalFee, String feeType,
			Integer cashFee, String cashFeeType, Integer couponFee,
			Integer couponCount, String couponTypeSingle,
			String couponIdSingle, Integer couponFeeSingle,
			String transactionId, String outTradeNo, String timeEnd,
			String dataStatus, String dataType, String dataOrder,
			String dataDelete) {
		this.resultCode = resultCode;
		this.errCode = errCode;
		this.errCodeDes = errCodeDes;
		this.openid = openid;
		this.isSubscribe = isSubscribe;
		this.bankType = bankType;
		this.totalFee = totalFee;
		this.settlementTotalFee = settlementTotalFee;
		this.feeType = feeType;
		this.cashFee = cashFee;
		this.cashFeeType = cashFeeType;
		this.couponFee = couponFee;
		this.couponCount = couponCount;
		this.couponTypeSingle = couponTypeSingle;
		this.couponIdSingle = couponIdSingle;
		this.couponFeeSingle = couponFeeSingle;
		this.transactionId = transactionId;
		this.outTradeNo = outTradeNo;
		this.timeEnd = timeEnd;
		this.dataStatus = dataStatus;
		this.dataType = dataType;
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

	@Column(name = "result_code", length = 16)
	public String getResultCode() {
		return this.resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	@Column(name = "err_code", length = 32)
	public String getErrCode() {
		return this.errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	@Column(name = "err_code_des", length = 128)
	public String getErrCodeDes() {
		return this.errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}

	@Column(name = "openid", length = 40)
	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Column(name = "is_subscribe", length = 1)
	public String getIsSubscribe() {
		return this.isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	@Column(name = "bank_type", length = 16)
	public String getBankType() {
		return this.bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	@Column(name = "total_fee")
	public Integer getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	@Column(name = "settlement_total_fee")
	public Integer getSettlementTotalFee() {
		return this.settlementTotalFee;
	}

	public void setSettlementTotalFee(Integer settlementTotalFee) {
		this.settlementTotalFee = settlementTotalFee;
	}

	@Column(name = "fee_type", length = 8)
	public String getFeeType() {
		return this.feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	@Column(name = "cash_fee")
	public Integer getCashFee() {
		return this.cashFee;
	}

	public void setCashFee(Integer cashFee) {
		this.cashFee = cashFee;
	}

	@Column(name = "cash_fee_type", length = 16)
	public String getCashFeeType() {
		return this.cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	@Column(name = "coupon_fee")
	public Integer getCouponFee() {
		return this.couponFee;
	}

	public void setCouponFee(Integer couponFee) {
		this.couponFee = couponFee;
	}

	@Column(name = "coupon_count")
	public Integer getCouponCount() {
		return this.couponCount;
	}

	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}

	@Column(name = "coupon_type_single", length = 20)
	public String getCouponTypeSingle() {
		return this.couponTypeSingle;
	}

	public void setCouponTypeSingle(String couponTypeSingle) {
		this.couponTypeSingle = couponTypeSingle;
	}

	@Column(name = "coupon_id_single", length = 20)
	public String getCouponIdSingle() {
		return this.couponIdSingle;
	}

	public void setCouponIdSingle(String couponIdSingle) {
		this.couponIdSingle = couponIdSingle;
	}

	@Column(name = "coupon_fee_single")
	public Integer getCouponFeeSingle() {
		return this.couponFeeSingle;
	}

	public void setCouponFeeSingle(Integer couponFeeSingle) {
		this.couponFeeSingle = couponFeeSingle;
	}

	@Column(name = "transaction_id", length = 32)
	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Column(name = "out_trade_no", length = 32)
	public String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	@Column(name = "time_end", length = 14)
	public String getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
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

}