package com.gx.soft.ykt.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * WeekendWeekRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "weekend_week_record", catalog = "jbxqycy")
public class WeekendWeekRecord implements java.io.Serializable {

	// Fields

	private String rowId;
	private String dayNo;
	private String remark;
	private String year;
	private String dataStatus;
	private String dataType;
	private Integer dataOrder;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public WeekendWeekRecord() {
	}

	/** full constructor */
	public WeekendWeekRecord(String dayNo, String remark, String year,
			String dataStatus, String dataType, Integer dataOrder,
			String dataDelete) {
		this.dayNo = dayNo;
		this.remark = remark;
		this.year = year;
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

	@Column(name = "day_no", length = 40)
	public String getDayNo() {
		return this.dayNo;
	}

	public void setDayNo(String dayNo) {
		this.dayNo = dayNo;
	}

	@Column(name = "remark", length = 40)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "year", length = 40)
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
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

	@Column(name = "data_delete")
	public String getDataDelete() {
		return this.dataDelete;
	}

	public void setDataDelete(String dataDelete) {
		this.dataDelete = dataDelete;
	}

}