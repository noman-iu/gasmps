package com.gasmps.hbm.dao.info.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gasmps.hbm.dao.AbstractDAO;
import com.gasmps.hbm.dao.info.TblSubscribeInfo;
import com.gasmps.hbm.model.TblSubscribe;

/**
 * @author akhtar
 */
@Repository("tblSubscribeInfoImpl")
public class TblSubscribeInfoImpl extends AbstractDAO<Serializable, TblSubscribe> implements TblSubscribeInfo{

	@Override
	public TblSubscribe getSubscribeByKey(String id) {
		return getByKey(id);
	}
	
	@Override
	public TblSubscribe getSubscribeByEmail(String email) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("subscribeEmail", email));
		TblSubscribe tblSubscribe = (TblSubscribe)criteria.uniqueResult();
		return tblSubscribe;
	}

	@Override
	public List<TblSubscribe> getAllSubscribe() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("subscribeEmail"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@Override
	public void updateSubscribe(TblSubscribe tblSubscribe) {
		update(tblSubscribe);
	}

	@Override
	public void deleteSubscribe(String email) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("subscribeEmail", email));
		TblSubscribe tblSubscribe = (TblSubscribe)criteria.uniqueResult();
		delete(tblSubscribe);
	}

	@Override
	public void saveSubscribe(TblSubscribe tblSubscribe) {
		persist(tblSubscribe);
	}

}
