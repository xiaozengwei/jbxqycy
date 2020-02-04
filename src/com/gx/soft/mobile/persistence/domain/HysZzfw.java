package com.gx.soft.mobile.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * HysZzfw entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hys_zzfw", catalog = "jbxqycy")
public class HysZzfw implements java.io.Serializable {

	// Fields

	private String rowId;
	private String relationId;
	private Integer teaNum;
	private Integer waterNum;
	private Integer artisanNum;
	private Integer ceremonyNum;
	private Integer matNum;
	private Integer printNum;
	private Integer cxLuxuryNum;
	private Integer cxHighNum;
	private Integer cxRoutineNum;
	private String createUserId;
	private Timestamp createTime;
	private String modifyUserId;
	private Timestamp modifyTime;
	private String dataType;
	private String dataStatus;
	private String dataDelete;

	// Constructors

	/** default constructor */
	public HysZzfw() {
	}

	/** full constructor */
	public HysZzfw(String relationId, Integer teaNum, Integer waterNum,
			Integer artisanNum, Integer ceremonyNum, Integer matNum,
			Integer printNum, Integer cxLuxuryNum, Integer cxHighNum,
			Integer cxRoutineNum, String createUserId, Timestamp createTime,
			String modifyUserId, Timestamp modifyTime, String dataType,
			String dataStatus, String dataDelete) {
		this.relationId = relationId;
		this.teaNum = teaNum;
		this.waterNum = waterNum;
		this.artisanNum = artisanNum;
		this.ceremonyNum = ceremonyNum;
		this.matNum = matNum;
		this.printNum = printNum;
		this.cxLuxuryNum = cxLuxuryNum;
		this.cxHighNum = cxHighNum;
		this.cxRoutineNum = cxRoutineNum;
		this.createUserId = createUserId;
		this.createTime = createTime;
		this.modifyUserId = modifyUserId;
		this.modifyTime = modifyTime;
		this.dataType = dataType;
		this.dataStatus = dataStatus;
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

	@Column(name = "tea_num")
	public Integer getTeaNum() {
		return this.teaNum;
	}

	public void setTeaNum(Integer teaNum) {
		this.teaNum = teaNum;
	}

	@Column(name = "water_num")
	public Integer getWaterNum() {
		return this.waterNum;
	}

	public void setWaterNum(Integer waterNum) {
		this.waterNum = waterNum;
	}

	@Column(name = "artisan_num")
	public Integer getArtisanNum() {
		return this.artisanNum;
	}

	public void setArtisanNum(Integer artisanNum) {
		this.artisanNum = artisanNum;
	}

	@Column(name = "ceremony_num")
	public Integer getCeremonyNum() {
		return this.ceremonyNum;
	}

	public void setCeremonyNum(Integer ceremonyNum) {
		this.ceremonyNum = ceremonyNum;
	}

	@Column(name = "mat_num")
	public Integer getMatNum() {
		return this.matNum;
	}

	public void setMatNum(Integer matNum) {
		this.matNum = matNum;
	}

	@Column(name = "print_num")
	public Integer getPrintNum() {
		return this.printNum;
	}

	public void setPrintNum(Integer printNum) {
		this.printNum = printNum;
	}

	@Column(name = "cx_luxury_num")
	public Integer getCxLuxuryNum() {
		return this.cxLuxuryNum;
	}

	public void setCxLuxuryNum(Integer cxLuxuryNum) {
		this.cxLuxuryNum = cxLuxuryNum;
	}

	@Column(name = "cx_high_num")
	public Integer getCxHighNum() {
		return this.cxHighNum;
	}

	public void setCxHighNum(Integer cxHighNum) {
		this.cxHighNum = cxHighNum;
	}

	@Column(name = "cx_routine_num")
	public Integer getCxRoutineNum() {
		return this.cxRoutineNum;
	}

	public void setCxRoutineNum(Integer cxRoutineNum) {
		this.cxRoutineNum = cxRoutineNum;
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

	@Column(name = "modify_user_id", length = 40)
	public String getModifyUserId() {
		return this.modifyUserId;
	}

	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	@Column(name = "modify_time", length = 19)
	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
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

	@Column(name = "data_delete", length = 40)
	public String getDataDelete() {
		return this.dataDelete;
	}

	public void setDataDelete(String dataDelete) {
		this.dataDelete = dataDelete;
	}

}