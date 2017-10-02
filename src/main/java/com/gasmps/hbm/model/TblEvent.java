package com.gasmps.hbm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the tbl_event database table.
 * 
 */
@Entity
@Table(name="tbl_event")
@NamedQuery(name="TblEvent.findAll", query="SELECT t FROM TblEvent t")
public class TblEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="event_id")
	private String eventId;

	@Column(name="event_content")
	private String eventContent;

	@Temporal(TemporalType.DATE)
	@Column(name="event_date")
	private Date eventDate;

	@Column(name="event_heading")
	private String eventHeading;

	@Column(name="event_status")
	private String eventStatus;

	@Column(name="event_subject")
	private String eventSubject;

	@Column(name="event_time")
	private Timestamp eventTime;

	public TblEvent() {
	}

	public String getEventId() {
		return this.eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventContent() {
		return this.eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventHeading() {
		return this.eventHeading;
	}

	public void setEventHeading(String eventHeading) {
		this.eventHeading = eventHeading;
	}

	public String getEventStatus() {
		return this.eventStatus;
	}

	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public String getEventSubject() {
		return this.eventSubject;
	}

	public void setEventSubject(String eventSubject) {
		this.eventSubject = eventSubject;
	}

	public Timestamp getEventTime() {
		return this.eventTime;
	}

	public void setEventTime(Timestamp eventTime) {
		this.eventTime = eventTime;
	}

}