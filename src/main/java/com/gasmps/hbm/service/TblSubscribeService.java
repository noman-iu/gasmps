package com.gasmps.hbm.service;

import java.util.List;

import com.gasmps.hbm.model.TblSubscribe;

/**
 * @author akhtar
 */

public interface TblSubscribeService {
	public TblSubscribe getSubscribeByKey(String id);
	public TblSubscribe getSubscribeByEmail(String email);
	public List<TblSubscribe> getAllSubscribe();
	public void updateSubscribe(TblSubscribe tblSubscribe);
	public void deleteSubscribe(String email);
	public void saveSubscribe(TblSubscribe tblSubscribe) throws Exception;
}
