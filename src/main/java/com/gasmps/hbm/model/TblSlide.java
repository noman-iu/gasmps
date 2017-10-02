package com.gasmps.hbm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tbl_slide database table.
 * 
 */
@Entity
@Table(name="tbl_slide")
@NamedQuery(name="TblSlide.findAll", query="SELECT t FROM TblSlide t")
public class TblSlide implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="slide_id")
	private String slideId;

	@Column(name="slide_content")
	private String slideContent;

	@Column(name="slide_heading")
	private String slideHeading;

	@Column(name="slide_priority")
	private int slidePriority;

	@Column(name="slide_status")
	private String slideStatus;

	@Column(name="slide_time")
	private Timestamp slideTime;

	public TblSlide() {
	}

	public String getSlideId() {
		return this.slideId;
	}

	public void setSlideId(String slideId) {
		this.slideId = slideId;
	}

	public String getSlideContent() {
		return this.slideContent;
	}

	public void setSlideContent(String slideContent) {
		this.slideContent = slideContent;
	}

	public String getSlideHeading() {
		return this.slideHeading;
	}

	public void setSlideHeading(String slideHeading) {
		this.slideHeading = slideHeading;
	}

	public int getSlidePriority() {
		return this.slidePriority;
	}

	public void setSlidePriority(int slidePriority) {
		this.slidePriority = slidePriority;
	}

	public String getSlideStatus() {
		return this.slideStatus;
	}

	public void setSlideStatus(String slideStatus) {
		this.slideStatus = slideStatus;
	}

	public Timestamp getSlideTime() {
		return this.slideTime;
	}

	public void setSlideTime(Timestamp slideTime) {
		this.slideTime = slideTime;
	}

}