package com.gasmps.hbm.dao.info;

import java.util.List;

import com.gasmps.hbm.model.TblSubscribe;

/**
 * @author akhtar
 */

public interface TblSubscribeInfo {
	
	public TblSubscribe getSubscribeByKey(String id);
	public TblSubscribe getSubscribeByEmail(String email);
	public List<TblSubscribe> getAllSubscribe();
	public void updateSubscribe(TblSubscribe tblSubscribe);
	public void deleteSubscribe(String email);
	public void saveSubscribe(TblSubscribe tblSubscribe);
}
