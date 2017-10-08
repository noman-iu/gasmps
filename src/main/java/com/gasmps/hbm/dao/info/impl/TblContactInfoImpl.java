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
import com.gasmps.hbm.dao.info.TblContactInfo;
import com.gasmps.hbm.model.TblContact;

/**
 * @author akhtar
 */

@Repository("tblContactInfoImpl")
public class TblContactInfoImpl extends AbstractDAO<Serializable, TblContact> implements TblContactInfo{

	static final Logger logger = LoggerFactory.getLogger(TblContactInfoImpl.class);
	
	@Override
	public TblContact getContactByKey(String id) {
		return getByKey(id);
	}

	@Override
	public TblContact getContactByEmail(String email) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("contactEmail",email));
		TblContact tblContact = (TblContact)criteria.uniqueResult();
		return tblContact;
	}

	@Override
	public List<TblContact> getAllContact() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("contactName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@Override
	public void updateContact(TblContact tblContact) {
		update(tblContact);
	}

	@Override
	public void deleteContact(String email) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("contactEmail",email));
		TblContact tblContact = (TblContact)criteria.uniqueResult();
		delete(tblContact);
	}

	@Override
	public void saveContact(TblContact tblContact) {
		persist(tblContact);
	}

}
