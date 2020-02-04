package com.gx.soft.sd.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SendMessageRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "send_message_record", catalog = "jbxqycy")
public class SendMessageRecord implements java.io.Serializable {

	// Fields


	private String rowId;
	private String roomId;
	private String balance;
	private String userName;
	private String userPhone;
	private String taskId;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public SendMessageRecord() {
	}

	/** full constructor */
	public SendMessageRecord(String roomId, String balance, String userName,
			String userPhone, String taskId, Timestamp createTime) {
		this.roomId = roomId;
		this.balance = balance;
		this.userName = userName;
		this.userPhone = userPhone;
		this.taskId = taskId;
		this.createTime = createTime;
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

	@Column(name = "balance", length = 40)
	public String getBalance() {
		return this.balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	@Column(name = "user_name", length = 40)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_phone", length = 40)
	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "task_id", length = 40)
	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}