package com.gasmps.hbm.dao.info;

import java.util.List;

import com.gasmps.hbm.model.TblSetting;

/**
 * @author akhtar
 */

public interface TblSettingInfo {

	//Here name is primary key in tables
	public TblSetting getSettingById(String id);
	public TblSetting getSettingByKey(String name);
	public List<TblSetting> getAllSetting();
	public void updateSetting(TblSetting tblSetting);
	public void deleteSetting(String name);
	public void saveSetting(TblSetting tblSetting);
}
