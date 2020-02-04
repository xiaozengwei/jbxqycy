package com.gx.soft.ykt.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * OneCardInfo entity. @author MyEclipse Persistence Tools
 * 一卡通信息表
 */
@Entity
@Table(name = "one_card_info", catalog = "jbxqycy")
public class OneCardInfo implements java.io.Serializable {

	// Fields

	private String rowId;
	private String cardNumber;
	private String cardHolder;
	private String password;
	private String accountBalance;
	private Timestamp createTime;
	private String accountStatus;

	// Constructors

	/** default constructor */
	public OneCardInfo() {
	}

	/** full constructor */
	public OneCardInfo(String cardNumber, String cardHolder, String password,
			String accountBalance, Timestamp createTime, String accountStatus) {
		this.cardNumber = cardNumber;
		this.cardHolder = cardHolder;
		this.password = password;
		this.accountBalance = accountBalance;
		this.createTime = createTime;
		this.accountStatus = accountStatus;
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

	@Column(name = "card_number", length = 40)
	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Column(name = "card_holder", length = 40)
	public String getCardHolder() {
		return this.cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	@Column(name = "password", length = 40)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "account_balance", length = 40)
	public String getAccountBalance() {
		return this.accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "account_status", length = 40)
	public String getAccountStatus() {
		return this.accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

}