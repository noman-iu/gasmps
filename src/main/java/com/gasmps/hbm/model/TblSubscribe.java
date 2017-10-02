package com.gasmps.hbm.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Timestamp;


/**
 * The persistent class for the tbl_subscribe database table.
 * 
 */
@Entity
@Table(name="tbl_subscribe")
@NamedQuery(name="TblSubscribe.findAll", query="SELECT t FROM TblSubscribe t")
public class TblSubscribe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="subscribe_id")
	private String subscribeId;

	@NotEmpty
	@NotNull
	@Email(message = "Enter a valid email.")
	@Column(name="subscribe_email", unique=true)
	private String subscribeEmail;

	@Column(name="subscribe_status")
	private String subscribeStatus = "0";

	@Column(name="subscribe_time")
	private Timestamp subscribeTime;

	public TblSubscribe() {
	}

	public String getSubscribeId() {
		return this.subscribeId;
	}

	public void setSubscribeId(String subscribeId) {
		this.subscribeId = subscribeId;
	}

	public String getSubscribeEmail() {
		return this.subscribeEmail;
	}

	public void setSubscribeEmail(String subscribeEmail) {
		this.subscribeEmail = subscribeEmail;
	}

	public String getSubscribeStatus() {
		return this.subscribeStatus;
	}

	public void setSubscribeStatus(String subscribeStatus) {
		this.subscribeStatus = subscribeStatus;
	}

	public Timestamp getSubscribeTime() {
		return this.subscribeTime;
	}

	public void setSubscribeTime(Timestamp subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

}