package com.gasmps.hbm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gasmps.hbm.model.TblSequence;
import com.gasmps.hbm.service.TblSequenceService;
import com.gasmps.utils.IdGenrator;

/**
 * @author akhtar
 */
@Service("tblSequenceServiceImpl")
@Transactional
public class TblSequenceServiceImpl extends TblSequenceService {

	public TblSequenceServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getNextSequenceByKey(String name) throws Exception {
		TblSequence tblSequence = tblSequenceInfo.getSequenceByKey(name);
		if (tblSequence == null) {
			tblSequence = new TblSequence();
			tblSequence.setName(name);
			saveSequence(tblSequence);
		}
		String genratedId = IdGenrator.genrateShortId(tblSequence.getValue(), false);
		tblSequence.setValue(genratedId);
		updateSequence(tblSequence);
		return genratedId;
	}

	@Override
	public List<TblSequence> getAllSequence() {
		return super.getAllSequence();
	}

	@Override
	public void updateSequence(TblSequence tblSequence) {
		super.updateSequence(tblSequence);
	}

	@Override
	public void deleteSequence(String name) {
		super.deleteSequence(name);
	}

	@Override
	public void saveSequence(TblSequence tblSequence) {
		super.saveSequence(tblSequence);
	}

}
