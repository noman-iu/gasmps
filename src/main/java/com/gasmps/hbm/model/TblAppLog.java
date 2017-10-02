package com.gasmps.hbm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tbl_app_log database table.
 * 
 */
@Entity
@Table(name="tbl_app_log")
@NamedQuery(name="TblAppLog.findAll", query="SELECT t FROM TblAppLog t")
public class TblAppLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="log_id")
	private String logId;

	@Column(name="log_class")
	private String logClass;

	@Column(name="log_description")
	private String logDescription;

	@Column(name="log_status")
	private String logStatus;

	@Column(name="log_time")
	private Timestamp logTime;

	public TblAppLog() {
	}

	public String getLogId() {
		return this.logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getLogClass() {
		return this.logClass;
	}

	public void setLogClass(String logClass) {
		this.logClass = logClass;
	}

	public String getLogDescription() {
		return this.logDescription;
	}

	public void setLogDescription(String logDescription) {
		this.logDescription = logDescription;
	}

	public String getLogStatus() {
		return this.logStatus;
	}

	public void setLogStatus(String logStatus) {
		this.logStatus = logStatus;
	}

	public Timestamp getLogTime() {
		return this.logTime;
	}

	public void setLogTime(Timestamp logTime) {
		this.logTime = logTime;
	}

}