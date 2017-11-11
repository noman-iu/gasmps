package com.gasmps.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gasmps.hbm.dao.info.TblSubscribeInfo;
import com.gasmps.hbm.model.TblSubscribe;

/**
 * @author akhtar
 */
public abstract class TblSubscribeService {

	@Autowired
	protected TblSubscribeInfo tblSubscribeInfo;

	public TblSubscribe getSubscribeByKey(String id) {
		return tblSubscribeInfo.getSubscribeByKey(id);
	}

	public TblSubscribe getSubscribeByEmail(String email) {
		return tblSubscribeInfo.getSubscribeByEmail(email);
	}

	public List<TblSubscribe> getAllSubscribe() {
		return tblSubscribeInfo.getAllSubscribe();
	}

	public void updateSubscribe(TblSubscribe tblSubscribe) {
		tblSubscribeInfo.updateSubscribe(tblSubscribe);
	}

	public void deleteSubscribe(String email) {
		tblSubscribeInfo.deleteSubscribe(email);
	}

	public void saveSubscribe(TblSubscribe tblSubscribe) throws Exception {
		tblSubscribeInfo.saveSubscribe(tblSubscribe);
	}
}
