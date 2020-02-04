package com.gx.soft.ykt.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * OneCardPersonDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "one_card_person_detail", catalog = "jbxqycy")
public class OneCardPersonDetail implements java.io.Serializable {

	// Fields

	private String rowId;
	private String relationId;
	private String userName;
	private String userIdCard;
	private String userPhone;
	private String createUserId;
	private Timestamp createTime;
	private String dataType;
	private String dataStatus;
	private Integer dataOrder;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public OneCardPersonDetail() {
	}

	/** full constructor */
	public OneCardPersonDetail(String relationId, String userName,
			String userIdCard, String userPhone, String createUserId,
			Timestamp createTime, String dataType, String dataStatus,
			Integer dataOrder, String dataDelete) {
		this.relationId = relationId;
		this.userName = userName;
		this.userIdCard = userIdCard;
		this.userPhone = userPhone;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.dataType = dataType;
		this.dataStatus = dataStatus;
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

	@Column(name = "relation_id", length = 40)
	public String getRelationId() {
		return this.relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
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

	@Column(name = "create_user_id", length = 40)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
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