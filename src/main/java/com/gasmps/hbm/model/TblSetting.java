package com.gasmps.hbm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tbl_setting database table.
 * 
 */
@Entity
@Table(name="tbl_setting")
@NamedQuery(name="TblSetting.findAll", query="SELECT t FROM TblSetting t")
public class TblSetting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="setting_name")
	private String settingName;

	@Column(name="setting_enable")
	private String settingEnable;

	@Column(name="setting_id")
	private String settingId;

	@Column(name="setting_time")
	private Timestamp settingTime;

	@Column(name="setting_value")
	private String settingValue;

	public TblSetting() {
	}

	public String getSettingName() {
		return this.settingName;
	}

	public void setSettingName(String settingName) {
		this.settingName = settingName;
	}

	public String getSettingEnable() {
		return this.settingEnable;
	}

	public void setSettingEnable(String settingEnable) {
		this.settingEnable = settingEnable;
	}

	public String getSettingId() {
		return this.settingId;
	}

	public void setSettingId(String settingId) {
		this.settingId = settingId;
	}

	public Timestamp getSettingTime() {
		return this.settingTime;
	}

	public void setSettingTime(Timestamp settingTime) {
		this.settingTime = settingTime;
	}

	public String getSettingValue() {
		return this.settingValue;
	}

	public void setSettingValue(String settingValue) {
		this.settingValue = settingValue;
	}

}