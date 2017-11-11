package com.gasmps.hbm.dao.info.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gasmps.hbm.dao.AbstractDAO;
import com.gasmps.hbm.dao.info.TblSettingInfo;
import com.gasmps.hbm.model.TblSetting;

/**
 * @author akhtar
 */
@Repository("tblSettingInfoImpl")
public class TblSettingInfoImpl extends AbstractDAO<Serializable, TblSetting> implements TblSettingInfo{

	@Override
	public TblSetting getSettingById(String id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("settingId", id));
		TblSetting tblSetting = (TblSetting)criteria.uniqueResult();
		return tblSetting;
	}

	@Override
	public TblSetting getSettingByKey(String name) {
		return getByKey(name);
	}

	@Override
	public List<TblSetting> getAllSetting() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("settingName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@Override
	public void updateSetting(TblSetting tblSetting) {
		update(tblSetting);
	}

	@Override
	public void deleteSetting(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("subscribeEmail", name));
		TblSetting tblSetting = (TblSetting)criteria.uniqueResult();
		delete(tblSetting);
	}

	@Override
	public void saveSetting(TblSetting tblSetting) {
		persist(tblSetting);
	}

}
