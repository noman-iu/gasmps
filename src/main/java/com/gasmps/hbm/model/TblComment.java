package com.gasmps.hbm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tbl_comment database table.
 * 
 */
@Entity
@Table(name="tbl_comment")
@NamedQuery(name="TblComment.findAll", query="SELECT t FROM TblComment t")
public class TblComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="comment_id")
	private String commentId;

	@Column(name="comment_email")
	private String commentEmail;

	@Column(name="comment_message")
	private String commentMessage;

	@Column(name="comment_mobile")
	private String commentMobile;

	@Column(name="comment_name")
	private String commentName;

	@Column(name="comment_status")
	private String commentStatus;

	@Column(name="comment_time")
	private Timestamp commentTime;

	public TblComment() {
	}

	public String getCommentId() {
		return this.commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentEmail() {
		return this.commentEmail;
	}

	public void setCommentEmail(String commentEmail) {
		this.commentEmail = commentEmail;
	}

	public String getCommentMessage() {
		return this.commentMessage;
	}

	public void setCommentMessage(String commentMessage) {
		this.commentMessage = commentMessage;
	}

	public String getCommentMobile() {
		return this.commentMobile;
	}

	public void setCommentMobile(String commentMobile) {
		this.commentMobile = commentMobile;
	}

	public String getCommentName() {
		return this.commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	public String getCommentStatus() {
		return this.commentStatus;
	}

	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}

	public Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

}