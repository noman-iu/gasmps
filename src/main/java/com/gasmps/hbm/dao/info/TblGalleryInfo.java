package com.gasmps.hbm.dao.info;

import java.util.List;

import com.gasmps.hbm.model.TblGallery;

/**
 * @author akhtar
 */

public interface TblGalleryInfo {

	public TblGallery getGalleryByKey(String id);
	public List<TblGallery> getAllGallery();
	public List<TblGallery> getNextRecordFromGalleryId(String id , int maxLimit);
	public void updateGallery(TblGallery tblGallery);
	public void deleteGallery(String id);
	public void saveGallery(TblGallery tblGallery);
}
