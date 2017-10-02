package com.gasmps.hbm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tbl_service database table.
 * 
 */
@Entity
@Table(name="tbl_service")
@NamedQuery(name="TblService.findAll", query="SELECT t FROM TblService t")
public class TblService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="service_id")
	private String serviceId;

	@Column(name="service_name")
	private String serviceName;

	@Column(name="service_port")
	private String servicePort;

	@Column(name="service_start_time")
	private String serviceStartTime;

	@Column(name="service_status")
	private String serviceStatus;

	@Column(name="service_stop_time")
	private String serviceStopTime;

	@Column(name="service_time")
	private Timestamp serviceTime;

	public TblService() {
	}

	public String getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServicePort() {
		return this.servicePort;
	}

	public void setServicePort(String servicePort) {
		this.servicePort = servicePort;
	}

	public String getServiceStartTime() {
		return this.serviceStartTime;
	}

	public void setServiceStartTime(String serviceStartTime) {
		this.serviceStartTime = serviceStartTime;
	}

	public String getServiceStatus() {
		return this.serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getServiceStopTime() {
		return this.serviceStopTime;
	}

	public void setServiceStopTime(String serviceStopTime) {
		this.serviceStopTime = serviceStopTime;
	}

	public Timestamp getServiceTime() {
		return this.serviceTime;
	}

	public void setServiceTime(Timestamp serviceTime) {
		this.serviceTime = serviceTime;
	}

}