package com.gx.soft.sd.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * VUserDevice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_user_device", catalog = "jbxqycy")
public class VUserDevice implements java.io.Serializable {

	// Fields

	private String cardNumber;
	private String userIdCard;
	private String cardHolder;
	private Timestamp createTime;
	private String buildNum;
	private String roomNum;
	private String waterDeviceId;
	private String electricDeviceId;

	// Constructors

	/** default constructor */
	public VUserDevice() {
	}

	/** full constructor */
	public VUserDevice(String userIdCard, String cardHolder,
			Timestamp createTime, String buildNum, String roomNum,
			String waterDeviceId, String electricDeviceId) {
		this.userIdCard = userIdCard;
		this.cardHolder = cardHolder;
		this.createTime = createTime;
		this.buildNum = buildNum;
		this.roomNum = roomNum;
		this.waterDeviceId = waterDeviceId;
		this.electricDeviceId = electricDeviceId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "card_number", length = 40)
	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Column(name = "user_id_card", length = 40)
	public String getUserIdCard() {
		return this.userIdCard;
	}

	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}

	@Column(name = "card_holder", length = 40)
	public String getCardHolder() {
		return this.cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "build_num", length = 40)
	public String getBuildNum() {
		return this.buildNum;
	}

	public void setBuildNum(String buildNum) {
		this.buildNum = buildNum;
	}

	@Column(name = "room_num", length = 40)
	public String getRoomNum() {
		return this.roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	@Column(name = "water_device_id", length = 40)
	public String getWaterDeviceId() {
		return this.waterDeviceId;
	}

	public void setWaterDeviceId(String waterDeviceId) {
		this.waterDeviceId = waterDeviceId;
	}

	@Column(name = "electric_device_id", length = 40)
	public String getElectricDeviceId() {
		return this.electricDeviceId;
	}

	public void setElectricDeviceId(String electricDeviceId) {
		this.electricDeviceId = electricDeviceId;
	}

}