package com.gx.soft.sd.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * WxUserRoom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wx_user_room", catalog = "jbxqycy")
public class WxUserRoom implements java.io.Serializable {

	// Fields

	private String rowId;
	private String wxUserId;
	private String roomId;
	private String userName;
	private String userIdCard;
	private String userPhone;
	private Timestamp bindTime;
	private Timestamp unbindTime;
	private Timestamp inTime;
	private Timestamp outTime;
	private String dataStatus;
	private String dataType;
	private Integer dataOrder;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public WxUserRoom() {
	}

	/** full constructor */
	public WxUserRoom(String wxUserId, String roomId, String userName,
			String userIdCard, String userPhone, Timestamp bindTime,
			Timestamp unbindTime, Timestamp inTime, Timestamp outTime,
			String dataStatus, String dataType, Integer dataOrder,
			String dataDelete) {
		this.wxUserId = wxUserId;
		this.roomId = roomId;
		this.userName = userName;
		this.userIdCard = userIdCard;
		this.userPhone = userPhone;
		this.bindTime = bindTime;
		this.unbindTime = unbindTime;
		this.inTime = inTime;
		this.outTime = outTime;
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

	@Column(name = "wx_user_id", length = 40)
	public String getWxUserId() {
		return this.wxUserId;
	}

	public void setWxUserId(String wxUserId) {
		this.wxUserId = wxUserId;
	}

	@Column(name = "room_id", length = 40)
	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
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

	@Column(name = "bind_time", length = 19)
	public Timestamp getBindTime() {
		return this.bindTime;
	}

	public void setBindTime(Timestamp bindTime) {
		this.bindTime = bindTime;
	}

	@Column(name = "unbind_time", length = 19)
	public Timestamp getUnbindTime() {
		return this.unbindTime;
	}

	public void setUnbindTime(Timestamp unbindTime) {
		this.unbindTime = unbindTime;
	}

	@Column(name = "in_time", length = 19)
	public Timestamp getInTime() {
		return this.inTime;
	}

	public void setInTime(Timestamp inTime) {
		this.inTime = inTime;
	}

	@Column(name = "out_time", length = 19)
	public Timestamp getOutTime() {
		return this.outTime;
	}

	public void setOutTime(Timestamp outTime) {
		this.outTime = outTime;
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