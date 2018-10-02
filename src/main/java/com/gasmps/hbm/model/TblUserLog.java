package com.gasmps.hbm.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;


/**
 * The persistent class for the tbl_user_log database table.
 * 
 */
@Entity
@Table(name="tbl_user_log")
@NamedQuery(name="TblUserLog.findAll", query="SELECT t FROM TblUserLog t")
public class TblUserLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="log_id")
	private String logId;
	
	@Column(name="log_client")
	private String logClient;

	@Column(name="log_host")
	private String logHost;

	@Column(name="log_ip")
	private String logIp;

	@Column(name="log_location")
	private String logLocation;

	@Column(name="log_time")
	@UpdateTimestamp
	private Timestamp logTime;

	public TblUserLog() {
	}

	public String getLogClient() {
		return this.logClient;
	}

	public void setLogClient(String logClient) {
		this.logClient = logClient;
	}

	public String getLogHost() {
		return this.logHost;
	}

	public void setLogHost(String logHost) {
		this.logHost = logHost;
	}

	public String getLogId() {
		return this.logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getLogIp() {
		return this.logIp;
	}

	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}

	public String getLogLocation() {
		return this.logLocation;
	}

	public void setLogLocation(String logLocation) {
		this.logLocation = logLocation;
	}

	public Timestamp getLogTime() {
		return this.logTime;
	}

	public void setLogTime(Timestamp logTime) {
		this.logTime = logTime;
	}

}