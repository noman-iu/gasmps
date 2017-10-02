package com.gasmps.hbm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the tbl_apply database table.
 * 
 */
@Entity
@Table(name="tbl_apply")
@NamedQuery(name="TblApply.findAll", query="SELECT t FROM TblApply t")
public class TblApply implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="apply_id")
	private String applyId;

	@Column(name="apply_city")
	private String applyCity;

	@Column(name="apply_country")
	private String applyCountry;

	@Temporal(TemporalType.DATE)
	@Column(name="apply_dob")
	private Date applyDob;

	@Column(name="apply_email")
	private String applyEmail;

	@Column(name="apply_father")
	private String applyFather;

	@Column(name="apply_first_name")
	private String applyFirstName;

	@Column(name="apply_gender")
	private String applyGender;

	@Column(name="apply_last_name")
	private String applyLastName;

	@Column(name="apply_line2")
	private String applyLine2;

	@Column(name="apply_mobile")
	private String applyMobile;

	@Column(name="apply_mother")
	private String applyMother;

	@Column(name="apply_state")
	private String applyState;

	@Column(name="apply_status")
	private String applyStatus;

	@Column(name="apply_street")
	private String applyStreet;

	@Column(name="apply_time")
	private Timestamp applyTime;

	@Column(name="apply_zip")
	private String applyZip;

	@Lob
	private byte[] tc;

	public TblApply() {
	}

	public String getApplyId() {
		return this.applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getApplyCity() {
		return this.applyCity;
	}

	public void setApplyCity(String applyCity) {
		this.applyCity = applyCity;
	}

	public String getApplyCountry() {
		return this.applyCountry;
	}

	public void setApplyCountry(String applyCountry) {
		this.applyCountry = applyCountry;
	}

	public Date getApplyDob() {
		return this.applyDob;
	}

	public void setApplyDob(Date applyDob) {
		this.applyDob = applyDob;
	}

	public String getApplyEmail() {
		return this.applyEmail;
	}

	public void setApplyEmail(String applyEmail) {
		this.applyEmail = applyEmail;
	}

	public String getApplyFather() {
		return this.applyFather;
	}

	public void setApplyFather(String applyFather) {
		this.applyFather = applyFather;
	}

	public String getApplyFirstName() {
		return this.applyFirstName;
	}

	public void setApplyFirstName(String applyFirstName) {
		this.applyFirstName = applyFirstName;
	}

	public String getApplyGender() {
		return this.applyGender;
	}

	public void setApplyGender(String applyGender) {
		this.applyGender = applyGender;
	}

	public String getApplyLastName() {
		return this.applyLastName;
	}

	public void setApplyLastName(String applyLastName) {
		this.applyLastName = applyLastName;
	}

	public String getApplyLine2() {
		return this.applyLine2;
	}

	public void setApplyLine2(String applyLine2) {
		this.applyLine2 = applyLine2;
	}

	public String getApplyMobile() {
		return this.applyMobile;
	}

	public void setApplyMobile(String applyMobile) {
		this.applyMobile = applyMobile;
	}

	public String getApplyMother() {
		return this.applyMother;
	}

	public void setApplyMother(String applyMother) {
		this.applyMother = applyMother;
	}

	public String getApplyState() {
		return this.applyState;
	}

	public void setApplyState(String applyState) {
		this.applyState = applyState;
	}

	public String getApplyStatus() {
		return this.applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getApplyStreet() {
		return this.applyStreet;
	}

	public void setApplyStreet(String applyStreet) {
		this.applyStreet = applyStreet;
	}

	public Timestamp getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}

	public String getApplyZip() {
		return this.applyZip;
	}

	public void setApplyZip(String applyZip) {
		this.applyZip = applyZip;
	}

	public byte[] getTc() {
		return this.tc;
	}

	public void setTc(byte[] tc) {
		this.tc = tc;
	}

}