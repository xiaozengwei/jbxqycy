package com.gx.soft.sd.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * SbInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sb_info", catalog = "jbxqycy")
public class SbInfo implements java.io.Serializable {

	// Fields

	private String ext1;
	private String ext2;
	private String ext3;
	private String ext4;
	private String ext5;
	private String ext6;
	private String ext7;
	private String ext8;
	private String ext9;
	private String ext10;
	private String ext11;
	private String ext12;
	private String ext13;
	private String ext14;

	// Constructors

	/** default constructor */
	public SbInfo() {
	}

	/** full constructor */
	public SbInfo(String ext2, String ext3, String ext4, String ext5,
			String ext6, String ext7, String ext8, String ext9, String ext10,
			String ext11, String ext12, String ext13, String ext14) {
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.ext4 = ext4;
		this.ext5 = ext5;
		this.ext6 = ext6;
		this.ext7 = ext7;
		this.ext8 = ext8;
		this.ext9 = ext9;
		this.ext10 = ext10;
		this.ext11 = ext11;
		this.ext12 = ext12;
		this.ext13 = ext13;
		this.ext14 = ext14;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ext_1", unique = true, nullable = false, length = 40)
	public String getExt1() {
		return this.ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	@Column(name = "ext_2")
	public String getExt2() {
		return this.ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	@Column(name = "ext_3")
	public String getExt3() {
		return this.ext3;
	}

	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}

	@Column(name = "ext_4")
	public String getExt4() {
		return this.ext4;
	}

	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}

	@Column(name = "ext_5")
	public String getExt5() {
		return this.ext5;
	}

	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}

	@Column(name = "ext_6")
	public String getExt6() {
		return this.ext6;
	}

	public void setExt6(String ext6) {
		this.ext6 = ext6;
	}

	@Column(name = "ext_7")
	public String getExt7() {
		return this.ext7;
	}

	public void setExt7(String ext7) {
		this.ext7 = ext7;
	}

	@Column(name = "ext_8")
	public String getExt8() {
		return this.ext8;
	}

	public void setExt8(String ext8) {
		this.ext8 = ext8;
	}

	@Column(name = "ext_9")
	public String getExt9() {
		return this.ext9;
	}

	public void setExt9(String ext9) {
		this.ext9 = ext9;
	}

	@Column(name = "ext_10")
	public String getExt10() {
		return this.ext10;
	}

	public void setExt10(String ext10) {
		this.ext10 = ext10;
	}

	@Column(name = "ext_11")
	public String getExt11() {
		return this.ext11;
	}

	public void setExt11(String ext11) {
		this.ext11 = ext11;
	}

	@Column(name = "ext_12")
	public String getExt12() {
		return this.ext12;
	}

	public void setExt12(String ext12) {
		this.ext12 = ext12;
	}

	@Column(name = "ext_13")
	public String getExt13() {
		return this.ext13;
	}

	public void setExt13(String ext13) {
		this.ext13 = ext13;
	}

	@Column(name = "ext_14")
	public String getExt14() {
		return this.ext14;
	}

	public void setExt14(String ext14) {
		this.ext14 = ext14;
	}

}