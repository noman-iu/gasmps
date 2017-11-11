package com.gasmps.hbm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tbl_login database table.
 * 
 */
@Entity
@Table(name="tbl_login")
@NamedQuery(name="TblLogin.findAll", query="SELECT t FROM TblLogin t")
public class TblLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="login_email")
	private String loginEmail;

	@Column(name="login_id")
	private String loginId;

	@Column(name="login_last")
	private Timestamp loginLast;

	@Column(name="login_name")
	private String loginName;

	@Column(name="login_password")
	private String loginPassword;

	@Column(name="login_status")
	private String loginStatus;

	@Column(name="login_time")
	private Timestamp loginTime;

	@Column(name="login_type")
	private String loginType;

	public TblLogin() {
	}

	public String getLoginEmail() {
		return this.loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public Timestamp getLoginLast() {
		return this.loginLast;
	}

	public void setLoginLast(Timestamp loginLast) {
		this.loginLast = loginLast;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getLoginStatus() {
		return this.loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginType() {
		return this.loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

}