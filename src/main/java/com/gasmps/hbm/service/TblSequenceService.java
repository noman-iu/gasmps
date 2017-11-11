package com.gasmps.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gasmps.hbm.dao.info.TblSequenceInfo;
import com.gasmps.hbm.model.TblSequence;

/**
 * @author akhtar
 */
public abstract class TblSequenceService {

	@Autowired
	protected TblSequenceInfo tblSequenceInfo;

	public abstract String getNextSequenceByKey(String name) throws Exception;

	public List<TblSequence> getAllSequence() {
		return tblSequenceInfo.getAllSequence();
	}

	public void updateSequence(TblSequence tblSequence) {
		tblSequenceInfo.updateSequence(tblSequence);
	}

	public void deleteSequence(String name) {
		tblSequenceInfo.deleteSequence(name);
	}

	public void saveSequence(TblSequence tblSequence) {
		tblSequenceInfo.saveSequence(tblSequence);
	}

}
