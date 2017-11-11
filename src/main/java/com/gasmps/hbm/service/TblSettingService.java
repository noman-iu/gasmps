package com.gasmps.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gasmps.hbm.dao.info.TblSettingInfo;
import com.gasmps.hbm.model.TblSetting;

/**
 * @author akhtar
 */
public abstract class TblSettingService {

	@Autowired
	protected TblSettingInfo tblSettingInfo;

	// Here name is primary key in tables
	public TblSetting getSettingById(String id) {
		return tblSettingInfo.getSettingById(id);
	}

	public TblSetting getSettingByKey(String name) {
		return tblSettingInfo.getSettingByKey(name);
	}

	public List<TblSetting> getAllSetting() {
		return tblSettingInfo.getAllSetting();
	}

	public void updateSetting(TblSetting tblSetting) {
		tblSettingInfo.updateSetting(tblSetting);
	}

	public void deleteSetting(String name) {
		tblSettingInfo.deleteSetting(name);
	}

	public abstract void saveSetting(TblSetting tblSetting) throws Exception;
}
