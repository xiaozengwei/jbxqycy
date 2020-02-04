package com.gx.soft.sd.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SdMonthBill entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sd_month_bill", catalog = "jbxqycy")
public class SdMonthBill implements java.io.Serializable {

	// Fields

	private String rowId;
	private String roomId;
	private String waterDeviceId;
	private String electricDeviceId;
	private String year;
	private String month;
	private Double monthWaterUse;
	private Double monthElectricUse;
	private Double historyWaterUse;
	private Double historyElectricUse;
	private Double monthWaterFee;
	private Double monthElectricFee;
	private Double electricBalance;
	private Double waterBalance;
	private Timestamp createTime;
	private String dataStatus;
	private String dataType;
	private Integer dataOrder;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public SdMonthBill() {
	}

	/** full constructor */
	public SdMonthBill(String roomId, String waterDeviceId,
			String electricDeviceId, String year, String month,
			Double monthWaterUse, Double monthElectricUse,
			Double historyWaterUse, Double historyElectricUse,
			Double monthWaterFee, Double monthElectricFee,
			Double electricBalance, Double waterBalance, Timestamp createTime,
			String dataStatus, String dataType, Integer dataOrder,
			String dataDelete) {
		this.roomId = roomId;
		this.waterDeviceId = waterDeviceId;
		this.electricDeviceId = electricDeviceId;
		this.year = year;
		this.month = month;
		this.monthWaterUse = monthWaterUse;
		this.monthElectricUse = monthElectricUse;
		this.historyWaterUse = historyWaterUse;
		this.historyElectricUse = historyElectricUse;
		this.monthWaterFee = monthWaterFee;
		this.monthElectricFee = monthElectricFee;
		this.electricBalance = electricBalance;
		this.waterBalance = waterBalance;
		this.createTime = createTime;
		this.dataStatus = dataStatus;
		this.dataType = dataType;
		this.dataOrder = dataOrder;
		this.dataDelete = dataDelete;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "rowId", unique = true, nullable = false, length = 40)
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

	@Column(name = "year", length = 40)
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Column(name = "month", length = 40)
	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Column(name = "month_water_use", precision = 22, scale = 0)
	public Double getMonthWaterUse() {
		return this.monthWaterUse;
	}

	public void setMonthWaterUse(Double monthWaterUse) {
		this.monthWaterUse = monthWaterUse;
	}

	@Column(name = "month_electric_use", precision = 22, scale = 0)
	public Double getMonthElectricUse() {
		return this.monthElectricUse;
	}

	public void setMonthElectricUse(Double monthElectricUse) {
		this.monthElectricUse = monthElectricUse;
	}

	@Column(name = "history_water_use", precision = 22, scale = 0)
	public Double getHistoryWaterUse() {
		return this.historyWaterUse;
	}

	public void setHistoryWaterUse(Double historyWaterUse) {
		this.historyWaterUse = historyWaterUse;
	}

	@Column(name = "history_electric_use", precision = 22, scale = 0)
	public Double getHistoryElectricUse() {
		return this.historyElectricUse;
	}

	public void setHistoryElectricUse(Double historyElectricUse) {
		this.historyElectricUse = historyElectricUse;
	}

	@Column(name = "month_water_fee", precision = 22, scale = 0)
	public Double getMonthWaterFee() {
		return this.monthWaterFee;
	}

	public void setMonthWaterFee(Double monthWaterFee) {
		this.monthWaterFee = monthWaterFee;
	}

	@Column(name = "month_electric_fee", precision = 22, scale = 0)
	public Double getMonthElectricFee() {
		return this.monthElectricFee;
	}

	public void setMonthElectricFee(Double monthElectricFee) {
		this.monthElectricFee = monthElectricFee;
	}

	@Column(name = "electric_balance", precision = 22, scale = 0)
	public Double getElectricBalance() {
		return this.electricBalance;
	}

	public void setElectricBalance(Double electricBalance) {
		this.electricBalance = electricBalance;
	}

	@Column(name = "water_balance", precision = 22, scale = 0)
	public Double getWaterBalance() {
		return this.waterBalance;
	}

	public void setWaterBalance(Double waterBalance) {
		this.waterBalance = waterBalance;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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