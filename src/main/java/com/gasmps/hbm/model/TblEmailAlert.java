package com.gasmps.hbm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tbl_email_alert database table.
 * 
 */
@Entity
@Table(name="tbl_email_alert")
@NamedQuery(name="TblEmailAlert.findAll", query="SELECT t FROM TblEmailAlert t")
public class TblEmailAlert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="email_id")
	private String emailId;

	@Lob
	@Column(name="email_attachment")
	private byte[] emailAttachment;

	@Column(name="email_attachment_type")
	private String emailAttachmentType;

	@Column(name="email_message")
	private String emailMessage;

	@Column(name="email_mode")
	private String emailMode;

	@Column(name="email_path")
	private String emailPath;

	@Column(name="email_preority")
	private int emailPreority;

	@Column(name="email_receiver")
	private String emailReceiver;

	@Column(name="email_status")
	private String emailStatus;

	@Column(name="email_subject")
	private String emailSubject;

	@Column(name="email_time")
	private Timestamp emailTime;

	public TblEmailAlert() {
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public byte[] getEmailAttachment() {
		return this.emailAttachment;
	}

	public void setEmailAttachment(byte[] emailAttachment) {
		this.emailAttachment = emailAttachment;
	}

	public String getEmailAttachmentType() {
		return this.emailAttachmentType;
	}

	public void setEmailAttachmentType(String emailAttachmentType) {
		this.emailAttachmentType = emailAttachmentType;
	}

	public String getEmailMessage() {
		return this.emailMessage;
	}

	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}

	public String getEmailMode() {
		return this.emailMode;
	}

	public void setEmailMode(String emailMode) {
		this.emailMode = emailMode;
	}

	public String getEmailPath() {
		return this.emailPath;
	}

	public void setEmailPath(String emailPath) {
		this.emailPath = emailPath;
	}

	public int getEmailPreority() {
		return this.emailPreority;
	}

	public void setEmailPreority(int emailPreority) {
		this.emailPreority = emailPreority;
	}

	public String getEmailReceiver() {
		return this.emailReceiver;
	}

	public void setEmailReceiver(String emailReceiver) {
		this.emailReceiver = emailReceiver;
	}

	public String getEmailStatus() {
		return this.emailStatus;
	}

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	public String getEmailSubject() {
		return this.emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public Timestamp getEmailTime() {
		return this.emailTime;
	}

	public void setEmailTime(Timestamp emailTime) {
		this.emailTime = emailTime;
	}

}