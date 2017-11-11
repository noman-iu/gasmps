package com.gasmps.hbm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gasmps.hbm.model.TblSetting;
import com.gasmps.hbm.service.TblSequenceService;
import com.gasmps.hbm.service.TblSettingService;
import com.gasmps.utils.Constant;

/**
 * @author akhtar
 */
@Transactional
@Service("tblSettingServiceImpl")
public class TblSettingServiceImpl extends TblSettingService {

	@Autowired
	TblSequenceService tblSequenceService;

	public TblSettingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TblSetting getSettingById(String id) {
		return super.getSettingById(id);
	}

	@Override
	public TblSetting getSettingByKey(String name) {
		return super.getSettingByKey(name);
	}

	@Override
	public List<TblSetting> getAllSetting() {
		return super.getAllSetting();
	}

	@Override
	public void updateSetting(TblSetting tblSetting) {
		super.updateSetting(tblSetting);
	}

	@Override
	public void deleteSetting(String name) {
		super.deleteSetting(name);
	}

	@Override
	public void saveSetting(TblSetting tblSetting) throws Exception {
		tblSetting.setSettingId(tblSequenceService.getNextSequenceByKey(Constant.Sequence.SETTING.id));
		super.tblSettingInfo.saveSetting(tblSetting);
	}

}
