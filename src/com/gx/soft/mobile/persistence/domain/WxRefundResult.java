package com.gx.soft.mobile.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * WxRefundResult entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wx_refund_result", catalog = "jbxqycy")
public class WxRefundResult implements java.io.Serializable {

	// Fields

	private String rowId;
	private String transactionId;
	private String outTradeNo;
	private String outRefundNo;
	private String refundId;
	private Integer refundFee;
	private Integer totalFee;
	private Integer cashFee;
	private Timestamp refundTimeEnd;
	private String dataStatus;
	private String dataType;
	private Integer dataOrder;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public WxRefundResult() {
	}

	/** full constructor */
	public WxRefundResult(String transactionId, String outTradeNo,
			String outRefundNo, String refundId, Integer refundFee,
			Integer totalFee, Integer cashFee, Timestamp refundTimeEnd,
			String dataStatus, String dataType, Integer dataOrder,
			String dataDelete) {
		this.transactionId = transactionId;
		this.outTradeNo = outTradeNo;
		this.outRefundNo = outRefundNo;
		this.refundId = refundId;
		this.refundFee = refundFee;
		this.totalFee = totalFee;
		this.cashFee = cashFee;
		this.refundTimeEnd = refundTimeEnd;
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

	@Column(name = "transaction_id", length = 40)
	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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

	@Column(name = "refund_id", length = 40)
	public String getRefundId() {
		return this.refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}

	@Column(name = "refund_fee")
	public Integer getRefundFee() {
		return this.refundFee;
	}

	public void setRefundFee(Integer refundFee) {
		this.refundFee = refundFee;
	}

	@Column(name = "total_fee")
	public Integer getTotalFee() {
		return this.totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	@Column(name = "cash_fee")
	public Integer getCashFee() {
		return this.cashFee;
	}

	public void setCashFee(Integer cashFee) {
		this.cashFee = cashFee;
	}

	@Column(name = "refund_time_end", length = 19)
	public Timestamp getRefundTimeEnd() {
		return this.refundTimeEnd;
	}

	public void setRefundTimeEnd(Timestamp refundTimeEnd) {
		this.refundTimeEnd = refundTimeEnd;
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