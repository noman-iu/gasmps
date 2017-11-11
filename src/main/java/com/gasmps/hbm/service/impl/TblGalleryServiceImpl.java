package com.gasmps.hbm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gasmps.hbm.model.TblGallery;
import com.gasmps.hbm.service.TblGalleryService;
import com.gasmps.hbm.service.TblSequenceService;
import com.gasmps.utils.Constant;

/**
 * @author akhtar
 */
@Service("tblGalleryServiceImpl")
@Transactional
public class TblGalleryServiceImpl extends TblGalleryService {

	@Autowired
	TblSequenceService tblSequenceService;

	private final static int MAX_RECORD_LIMIT = 10;

	public TblGalleryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TblGallery getGalleryByKey(String id) {
		return super.getGalleryByKey(id);
	}

	@Override
	public List<TblGallery> getAllGallery() {
		return super.getAllGallery();
	}

	@Override
	public List<TblGallery> getNextRecordFromGalleryId(String id) {
		return tblGalleryInfo.getNextRecordFromGalleryId(id, MAX_RECORD_LIMIT);
	}

	@Override
	public void updateGallery(TblGallery tblGallery) {
		super.updateGallery(tblGallery);
	}

	@Override
	public void deleteGallery(String id) {
		super.deleteGallery(id);
	}

	@Override
	public void saveGallery(TblGallery tblGallery) throws Exception {
		tblGallery.setGalleryId(tblSequenceService.getNextSequenceByKey(Constant.Sequence.GALLERY.id));
		super.saveGallery(tblGallery);
	}

}
