package com.gasmps.hbm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gasmps.hbm.model.TblSubscribe;
import com.gasmps.hbm.service.TblSequenceService;
import com.gasmps.hbm.service.TblSubscribeService;
import com.gasmps.utils.Constant;

/**
 * @author akhtar
 */
@Service("tblSubscribeServiceImpl")
@Transactional
public class TblSubscribeServiceImpl extends TblSubscribeService {

	@Autowired
	TblSequenceService tblSequenceService;

	public TblSubscribeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TblSubscribe getSubscribeByKey(String id) {
		return super.getSubscribeByKey(id);
	}

	@Override
	public TblSubscribe getSubscribeByEmail(String email) {
		return super.getSubscribeByEmail(email);
	}

	@Override
	public List<TblSubscribe> getAllSubscribe() {
		return super.getAllSubscribe();
	}

	@Override
	public void updateSubscribe(TblSubscribe tblSubscribe) {
		super.updateSubscribe(tblSubscribe);
	}

	@Override
	public void deleteSubscribe(String email) {
		super.deleteSubscribe(email);
	}

	@Override
	public void saveSubscribe(TblSubscribe tblSubscribe) throws Exception {
		tblSubscribe.setSubscribeId(tblSequenceService.getNextSequenceByKey(Constant.Sequence.SUBSCRIBE.id));
		super.saveSubscribe(tblSubscribe);
	}

}
