package com.gasmps.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gasmps.hbm.dao.info.TblGalleryInfo;
import com.gasmps.hbm.model.TblGallery;

/**
 * @author akhtar
 */
public abstract class TblGalleryService {

	@Autowired
	protected TblGalleryInfo tblGalleryInfo;

	public TblGallery getGalleryByKey(String id) {
		return tblGalleryInfo.getGalleryByKey(id);
	}

	public List<TblGallery> getAllGallery() {
		return tblGalleryInfo.getAllGallery();
	}

	public abstract List<TblGallery> getNextRecordFromGalleryId(String id);

	public void updateGallery(TblGallery tblGallery) {
		tblGalleryInfo.updateGallery(tblGallery);
	}

	public void deleteGallery(String id) {
		tblGalleryInfo.deleteGallery(id);
	}

	public void saveGallery(TblGallery tblGallery) throws Exception {
		tblGalleryInfo.saveGallery(tblGallery);
	}
}
