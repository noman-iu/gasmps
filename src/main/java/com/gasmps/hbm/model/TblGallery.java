package com.gasmps.hbm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tbl_gallery database table.
 * 
 */
@Entity
@Table(name="tbl_gallery")
@NamedQuery(name="TblGallery.findAll", query="SELECT t FROM TblGallery t")
public class TblGallery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="gallery_id")
	private String galleryId;

	@Column(name="gallery_description")
	private String galleryDescription;

	@Column(name="gallery_heading")
	private String galleryHeading;

	@Column(name="gallery_name")
	private String galleryName;

	@Column(name="gallery_status")
	private String galleryStatus;

	@Column(name="gallery_time")
	private Timestamp galleryTime;

	public TblGallery() {
	}

	public String getGalleryId() {
		return this.galleryId;
	}

	public void setGalleryId(String galleryId) {
		this.galleryId = galleryId;
	}

	public String getGalleryDescription() {
		return this.galleryDescription;
	}

	public void setGalleryDescription(String galleryDescription) {
		this.galleryDescription = galleryDescription;
	}

	public String getGalleryHeading() {
		return this.galleryHeading;
	}

	public void setGalleryHeading(String galleryHeading) {
		this.galleryHeading = galleryHeading;
	}

	public String getGalleryName() {
		return this.galleryName;
	}

	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}

	public String getGalleryStatus() {
		return this.galleryStatus;
	}

	public void setGalleryStatus(String galleryStatus) {
		this.galleryStatus = galleryStatus;
	}

	public Timestamp getGalleryTime() {
		return this.galleryTime;
	}

	public void setGalleryTime(Timestamp galleryTime) {
		this.galleryTime = galleryTime;
	}

}