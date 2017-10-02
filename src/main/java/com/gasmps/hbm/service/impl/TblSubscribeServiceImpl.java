package com.gasmps.hbm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gasmps.hbm.dao.info.TblSubscribeInfo;
import com.gasmps.hbm.model.TblSubscribe;
import com.gasmps.hbm.service.TblSequenceService;
import com.gasmps.hbm.service.TblSubscribeService;
import com.gasmps.utils.Constant;

/**
 * @author akhtar
 */

@Service("tblSubscribeServiceImpl")
@Transactional
public class TblSubscribeServiceImpl implements TblSubscribeService{

	@Autowired
	TblSubscribeInfo tblSubscribeInfo;
	
	@Autowired
	TblSequenceService tblSequenceService;
	
	@Override
	public TblSubscribe getSubscribeByKey(String id) {
		return tblSubscribeInfo.getSubscribeByKey(id);
	}
	
	@Override
	public TblSubscribe getSubscribeByEmail(String email) {
		return tblSubscribeInfo.getSubscribeByEmail(email);
	}

	@Override
	public List<TblSubscribe> getAllSubscribe() {
		return tblSubscribeInfo.getAllSubscribe();
	}

	@Override
	public void updateSubscribe(TblSubscribe tblSubscribe) {
		tblSubscribeInfo.updateSubscribe(tblSubscribe);
	}

	@Override
	public void deleteSubscribe(String email) {
		tblSubscribeInfo.deleteSubscribe(email);
	}

	@Override
	public void saveSubscribe(TblSubscribe tblSubscribe) throws Exception {
		tblSubscribe.setSubscribeId(tblSequenceService.getNextSequenceByKey(Constant.Sequence.SUBSCRIBE.id));
		tblSubscribeInfo.saveSubscribe(tblSubscribe);
	}

	

}
