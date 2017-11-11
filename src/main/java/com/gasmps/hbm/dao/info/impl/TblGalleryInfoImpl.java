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
import com.gasmps.hbm.dao.info.TblGalleryInfo;
import com.gasmps.hbm.model.TblGallery;

/**
 * @author akhtar
 */
@Repository("tblGalleryInfoImpl")
public class TblGalleryInfoImpl extends AbstractDAO<Serializable, TblGallery> implements TblGalleryInfo{

	static final Logger logger = LoggerFactory.getLogger(TblGalleryInfoImpl.class);
	
	@Override
	public TblGallery getGalleryByKey(String id) {
		return getByKey(id);
	}

	@Override
	public List<TblGallery> getAllGallery() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("galleryId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
	
	@Override
	public List<TblGallery> getNextRecordFromGalleryId(String id , int maxLimit) {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("galleryId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Restrictions.gt("galleryId", id)).setMaxResults(maxLimit);
		return criteria.list();
	}

	@Override
	public void updateGallery(TblGallery tblGallery) {
		update(tblGallery);
	}

	@Override
	public void deleteGallery(String id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("galleryId", id));
		TblGallery tblGallery = (TblGallery)criteria.uniqueResult();
		delete(tblGallery);
	}

	@Override
	public void saveGallery(TblGallery tblGallery) {
		saveGallery(tblGallery);
	}

}
