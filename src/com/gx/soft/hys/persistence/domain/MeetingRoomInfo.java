package com.gx.soft.hys.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * MeetingRoomInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "meeting_room_info", catalog = "jbxqycy")
public class MeetingRoomInfo implements java.io.Serializable {

	// Fields

	private String rowId;
	private String buildArea;
	private String lengthWidth;
	private String screenSize;
	private String resolution;
	private Integer siteFeeAll;
	private Integer siteFeeHalf;
	private Integer parkLzAll;
	private Integer parkLzHalf;
	private String capacityKzs;
	private String capacityJys;
	private String capacityUx;
	private String roomName;
	private String roomAddress;
	private String roomNumber;
	private Integer roomBuilding;
	private Integer roomFloor;
	private String roomStatus;
	private Timestamp createTime;
	private String dataType;
	private String dataStatus;
	private String dataOrder;
	private String dataDeleted;

	// Constructors

	/** default constructor */
	public MeetingRoomInfo() {
	}

	/** full constructor */
	public MeetingRoomInfo(String buildArea, String lengthWidth,
			String screenSize, String resolution, Integer siteFeeAll,
			Integer siteFeeHalf, Integer parkLzAll, Integer parkLzHalf,
			String capacityKzs, String capacityJys, String capacityUx,
			String roomName, String roomAddress, String roomNumber,
			Integer roomBuilding, Integer roomFloor, String roomStatus,
			Timestamp createTime, String dataType, String dataStatus,
			String dataOrder, String dataDeleted) {
		this.buildArea = buildArea;
		this.lengthWidth = lengthWidth;
		this.screenSize = screenSize;
		this.resolution = resolution;
		this.siteFeeAll = siteFeeAll;
		this.siteFeeHalf = siteFeeHalf;
		this.parkLzAll = parkLzAll;
		this.parkLzHalf = parkLzHalf;
		this.capacityKzs = capacityKzs;
		this.capacityJys = capacityJys;
		this.capacityUx = capacityUx;
		this.roomName = roomName;
		this.roomAddress = roomAddress;
		this.roomNumber = roomNumber;
		this.roomBuilding = roomBuilding;
		this.roomFloor = roomFloor;
		this.roomStatus = roomStatus;
		this.createTime = createTime;
		this.dataType = dataType;
		this.dataStatus = dataStatus;
		this.dataOrder = dataOrder;
		this.dataDeleted = dataDeleted;
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

	@Column(name = "build_area", length = 40)
	public String getBuildArea() {
		return this.buildArea;
	}

	public void setBuildArea(String buildArea) {
		this.buildArea = buildArea;
	}

	@Column(name = "length_width", length = 40)
	public String getLengthWidth() {
		return this.lengthWidth;
	}

	public void setLengthWidth(String lengthWidth) {
		this.lengthWidth = lengthWidth;
	}

	@Column(name = "screen_size", length = 40)
	public String getScreenSize() {
		return this.screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	@Column(name = "resolution", length = 40)
	public String getResolution() {
		return this.resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	@Column(name = "site_fee_all")
	public Integer getSiteFeeAll() {
		return this.siteFeeAll;
	}

	public void setSiteFeeAll(Integer siteFeeAll) {
		this.siteFeeAll = siteFeeAll;
	}

	@Column(name = "site_fee_half")
	public Integer getSiteFeeHalf() {
		return this.siteFeeHalf;
	}

	public void setSiteFeeHalf(Integer siteFeeHalf) {
		this.siteFeeHalf = siteFeeHalf;
	}

	@Column(name = "park_lz_all")
	public Integer getParkLzAll() {
		return this.parkLzAll;
	}

	public void setParkLzAll(Integer parkLzAll) {
		this.parkLzAll = parkLzAll;
	}

	@Column(name = "park_lz_half")
	public Integer getParkLzHalf() {
		return this.parkLzHalf;
	}

	public void setParkLzHalf(Integer parkLzHalf) {
		this.parkLzHalf = parkLzHalf;
	}

	@Column(name = "capacity_kzs", length = 40)
	public String getCapacityKzs() {
		return this.capacityKzs;
	}

	public void setCapacityKzs(String capacityKzs) {
		this.capacityKzs = capacityKzs;
	}

	@Column(name = "capacity_jys", length = 40)
	public String getCapacityJys() {
		return this.capacityJys;
	}

	public void setCapacityJys(String capacityJys) {
		this.capacityJys = capacityJys;
	}

	@Column(name = "capacity_ux", length = 40)
	public String getCapacityUx() {
		return this.capacityUx;
	}

	public void setCapacityUx(String capacityUx) {
		this.capacityUx = capacityUx;
	}

	@Column(name = "room_name", length = 40)
	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Column(name = "room_address", length = 120)
	public String getRoomAddress() {
		return this.roomAddress;
	}

	public void setRoomAddress(String roomAddress) {
		this.roomAddress = roomAddress;
	}

	@Column(name = "room_number", length = 40)
	public String getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Column(name = "room_building")
	public Integer getRoomBuilding() {
		return this.roomBuilding;
	}

	public void setRoomBuilding(Integer roomBuilding) {
		this.roomBuilding = roomBuilding;
	}

	@Column(name = "room_floor")
	public Integer getRoomFloor() {
		return this.roomFloor;
	}

	public void setRoomFloor(Integer roomFloor) {
		this.roomFloor = roomFloor;
	}

	@Column(name = "room_status", length = 40)
	public String getRoomStatus() {
		return this.roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
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

	@Column(name = "data_deleted", length = 40)
	public String getDataDeleted() {
		return this.dataDeleted;
	}

	public void setDataDeleted(String dataDeleted) {
		this.dataDeleted = dataDeleted;
	}

}