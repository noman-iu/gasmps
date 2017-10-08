package com.gasmps.hbm.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

import java.sql.Timestamp;


/**
 * The persistent class for the tbl_contact database table.
 * 
 */
@Entity
@Table(name="tbl_contact")
@NamedQuery(name="TblContact.findAll", query="SELECT t FROM TblContact t")
public class TblContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contact_id")
	private String contactId;

	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name="contact_email")
	private String contactEmail;

	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name="contact_message")
	private String contactMessage;

	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name="contact_mobile")
	private String contactMobile;

	@NotBlank
	@NotEmpty
	@NotNull
	@Column(name="contact_name")
	private String contactName;

	@Column(name="contact_status")
	private String contactStatus;

	@Column(name="contact_time")
	private Timestamp contactTime;

	public TblContact() {
	}

	public String getContactId() {
		return this.contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactMessage() {
		return this.contactMessage;
	}

	public void setContactMessage(String contactMessage) {
		this.contactMessage = contactMessage;
	}

	public String getContactMobile() {
		return this.contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactStatus() {
		return this.contactStatus;
	}

	public void setContactStatus(String contactStatus) {
		this.contactStatus = contactStatus;
	}

	public Timestamp getContactTime() {
		return this.contactTime;
	}

	public void setContactTime(Timestamp contactTime) {
		this.contactTime = contactTime;
	}

}