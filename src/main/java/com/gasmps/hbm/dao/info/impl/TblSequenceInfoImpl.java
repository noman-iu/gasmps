package com.gasmps.hbm.dao.info.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gasmps.hbm.dao.AbstractDAO;
import com.gasmps.hbm.dao.info.TblSequenceInfo;
import com.gasmps.hbm.model.TblSequence;

/**
 * @author akhtar
 */

@Repository("tblSequenceInfoImpl")
public class TblSequenceInfoImpl extends AbstractDAO<Serializable, TblSequence> implements TblSequenceInfo{

	static final Logger logger = LoggerFactory.getLogger(TblSequenceInfoImpl.class);
	
	public TblSequenceInfoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TblSequence getSequenceByKey(String name) {
		return getByKey(name);
	}

	@Override
	public List<TblSequence> getAllSequence() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@Override
	public void updateSequence(TblSequence tblSequence) {
		update(tblSequence);
	}

	@Override
	public void deleteSequence(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		TblSequence tblSequence = (TblSequence)criteria.uniqueResult();
		delete(tblSequence);
	}

	@Override
	public void saveSequence(TblSequence tblSequence) {
		persist(tblSequence);
	}	
	
}
