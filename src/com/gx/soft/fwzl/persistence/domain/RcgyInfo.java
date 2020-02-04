package com.gx.soft.fwzl.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * RcgyInfo entity. @author MyEclipse Persistence Tools
 * 人才公寓信息表
 */
@Entity
@Table(name = "rcgy_info", catalog = "jbxqycy")
public class RcgyInfo implements java.io.Serializable {

	// Fields

	private String rowId;
	private String roomName;
	private String roomNumber;
	private String roomType;
	private Double roomArea;
	private String roomAddress;
	private String roomStatus;
	private Integer roomFloor;

	// Constructors

	/** default constructor */
	public RcgyInfo() {
	}

	/** full constructor */
	public RcgyInfo(String roomName, String roomNumber, String roomType,
			Double roomArea, String roomAddress, String roomStatus,
			Integer roomFloor) {
		this.roomName = roomName;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.roomArea = roomArea;
		this.roomAddress = roomAddress;
		this.roomStatus = roomStatus;
		this.roomFloor = roomFloor;
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

	@Column(name = "room_name", length = 40)
	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Column(name = "room_number", length = 40)
	public String getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Column(name = "room_type", length = 40)
	public String getRoomType() {
		return this.roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	@Column(name = "room_area", precision = 22, scale = 0)
	public Double getRoomArea() {
		return this.roomArea;
	}

	public void setRoomArea(Double roomArea) {
		this.roomArea = roomArea;
	}

	@Column(name = "room_address", length = 200)
	public String getRoomAddress() {
		return this.roomAddress;
	}

	public void setRoomAddress(String roomAddress) {
		this.roomAddress = roomAddress;
	}

	@Column(name = "room_status", length = 40)
	public String getRoomStatus() {
		return this.roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	@Column(name = "room_floor")
	public Integer getRoomFloor() {
		return this.roomFloor;
	}

	public void setRoomFloor(Integer roomFloor) {
		this.roomFloor = roomFloor;
	}

}