package com.gx.soft.fwzl.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * HistoryOpinion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "history_opinion", catalog = "jbxqycy")
public class HistoryOpinion implements java.io.Serializable {

	// Fields

	private String rowId;
	private String tableId;
	private String piId;
	private String handleStage;
	private String handleProcess;
	private String handleUser;
	private Timestamp handleTime;
	private String handleOpinion;
	private String dataType;
	private String dataStatus;
	private Integer dataOrder;
	private String dataDeleted;

	// Constructors

	/** default constructor */
	public HistoryOpinion() {
	}

	/** full constructor */
	public HistoryOpinion(String tableId, String piId, String handleStage,
			String handleProcess, String handleUser, Timestamp handleTime,
			String handleOpinion, String dataType, String dataStatus,
			Integer dataOrder, String dataDeleted) {
		this.tableId = tableId;
		this.piId = piId;
		this.handleStage = handleStage;
		this.handleProcess = handleProcess;
		this.handleUser = handleUser;
		this.handleTime = handleTime;
		this.handleOpinion = handleOpinion;
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

	@Column(name = "table_id", length = 40)
	public String getTableId() {
		return this.tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	@Column(name = "pi_id", length = 40)
	public String getPiId() {
		return this.piId;
	}

	public void setPiId(String piId) {
		this.piId = piId;
	}

	@Column(name = "handle_stage", length = 40)
	public String getHandleStage() {
		return this.handleStage;
	}

	public void setHandleStage(String handleStage) {
		this.handleStage = handleStage;
	}

	@Column(name = "handle_process", length = 40)
	public String getHandleProcess() {
		return this.handleProcess;
	}

	public void setHandleProcess(String handleProcess) {
		this.handleProcess = handleProcess;
	}

	@Column(name = "handle_user", length = 40)
	public String getHandleUser() {
		return this.handleUser;
	}

	public void setHandleUser(String handleUser) {
		this.handleUser = handleUser;
	}

	@Column(name = "handle_time", length = 19)
	public Timestamp getHandleTime() {
		return this.handleTime;
	}

	public void setHandleTime(Timestamp handleTime) {
		this.handleTime = handleTime;
	}

	@Column(name = "handle_opinion", length = 200)
	public String getHandleOpinion() {
		return this.handleOpinion;
	}

	public void setHandleOpinion(String handleOpinion) {
		this.handleOpinion = handleOpinion;
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

	@Column(name = "data_deleted", length = 40)
	public String getDataDeleted() {
		return this.dataDeleted;
	}

	public void setDataDeleted(String dataDeleted) {
		this.dataDeleted = dataDeleted;
	}

}