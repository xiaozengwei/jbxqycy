package com.gx.soft.sd.persistence.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 水电综合查询视图
 */
public class QueryModel {

	// Fields

	private String cardNumber;
	private String userIdCard;
	private String cardHolder;
	private String buildNum;
	private String roomNum;
	private String waterDeviceId;
	private String electricDeviceId;
	private Timestamp startTime;
	private Timestamp endTime;
	private Double waterNumber;
	private Double electricNumber;
	private Double waterMoney;
	private Double electricMoney;


	public QueryModel() {
	}

	public QueryModel(String cardNumber, String userIdCard, String cardHolder, String buildNum, String roomNum, String waterDeviceId,
					  String electricDeviceId, Timestamp startTime, Timestamp endTime, Double waterNumber, Double electricNumber,
					  Double waterMoney, Double electricMoney) {
		this.cardNumber = cardNumber;
		this.userIdCard = userIdCard;
		this.cardHolder = cardHolder;
		this.buildNum = buildNum;
		this.roomNum = roomNum;
		this.waterDeviceId = waterDeviceId;
		this.electricDeviceId = electricDeviceId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.waterNumber = waterNumber;
		this.electricNumber = electricNumber;
		this.waterMoney = waterMoney;
		this.electricMoney = electricMoney;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getUserIdCard() {
		return userIdCard;
	}

	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getBuildNum() {
		return buildNum;
	}

	public void setBuildNum(String buildNum) {
		this.buildNum = buildNum;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getWaterDeviceId() {
		return waterDeviceId;
	}

	public void setWaterDeviceId(String waterDeviceId) {
		this.waterDeviceId = waterDeviceId;
	}

	public String getElectricDeviceId() {
		return electricDeviceId;
	}

	public void setElectricDeviceId(String electricDeviceId) {
		this.electricDeviceId = electricDeviceId;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Double getWaterNumber() {
		return waterNumber;
	}

	public void setWaterNumber(Double waterNumber) {
		this.waterNumber = waterNumber;
	}

	public Double getElectricNumber() {
		return electricNumber;
	}

	public void setElectricNumber(Double electricNumber) {
		this.electricNumber = electricNumber;
	}

	public Double getWaterMoney() {
		return waterMoney;
	}

	public void setWaterMoney(Double waterMoney) {
		this.waterMoney = waterMoney;
	}

	public Double getElectricMoney() {
		return electricMoney;
	}

	public void setElectricMoney(Double electricMoney) {
		this.electricMoney = electricMoney;
	}
}