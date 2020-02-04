package com.gx.soft.fwzl.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ProcAct entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "proc_act", catalog = "jbxqycy")
public class ProcAct implements java.io.Serializable {

	// Fields

	private String rowId;
	private String processId;
	private String actId;
	private String actName;
	private String actExplain;
	private String handleUserName;
	private String handleUserName1;
	private String backAct;
	private String nextAct;
	private Integer actOrder;
	private String dataType;
	private String dataStatus;
	private String dataDeleted;

	// Constructors

	/** default constructor */
	public ProcAct() {
	}

	/** full constructor */
	public ProcAct(String processId, String actId, String actName,
			String actExplain, String handleUserName, String handleUserName1,
			String backAct, String nextAct, Integer actOrder, String dataType,
			String dataStatus, String dataDeleted) {
		this.processId = processId;
		this.actId = actId;
		this.actName = actName;
		this.actExplain = actExplain;
		this.handleUserName = handleUserName;
		this.handleUserName1 = handleUserName1;
		this.backAct = backAct;
		this.nextAct = nextAct;
		this.actOrder = actOrder;
		this.dataType = dataType;
		this.dataStatus = dataStatus;
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

	@Column(name = "process_id", length = 40)
	public String getProcessId() {
		return this.processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	@Column(name = "act_id", length = 40)
	public String getActId() {
		return this.actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	@Column(name = "act_name", length = 40)
	public String getActName() {
		return this.actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	@Column(name = "act_explain", length = 240)
	public String getActExplain() {
		return this.actExplain;
	}

	public void setActExplain(String actExplain) {
		this.actExplain = actExplain;
	}

	@Column(name = "handle_user_name", length = 40)
	public String getHandleUserName() {
		return this.handleUserName;
	}

	public void setHandleUserName(String handleUserName) {
		this.handleUserName = handleUserName;
	}

	@Column(name = "handle_user_name1", length = 40)
	public String getHandleUserName1() {
		return this.handleUserName1;
	}

	public void setHandleUserName1(String handleUserName1) {
		this.handleUserName1 = handleUserName1;
	}

	@Column(name = "back_act", length = 40)
	public String getBackAct() {
		return this.backAct;
	}

	public void setBackAct(String backAct) {
		this.backAct = backAct;
	}

	@Column(name = "next_act", length = 40)
	public String getNextAct() {
		return this.nextAct;
	}

	public void setNextAct(String nextAct) {
		this.nextAct = nextAct;
	}

	@Column(name = "act_order", precision = 8, scale = 0)
	public Integer getActOrder() {
		return this.actOrder;
	}

	public void setActOrder(Integer actOrder) {
		this.actOrder = actOrder;
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

	@Column(name = "data_deleted", length = 40)
	public String getDataDeleted() {
		return this.dataDeleted;
	}

	public void setDataDeleted(String dataDeleted) {
		this.dataDeleted = dataDeleted;
	}

}