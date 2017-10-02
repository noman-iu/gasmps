package com.gasmps.hbm.service;

import java.util.List;

import com.gasmps.hbm.model.TblSequence;

/**
 * @author akhtar
 */

public interface TblSequenceService {

	public String getNextSequenceByKey(String name) throws Exception;
	public List<TblSequence> getAllSequence();
	public void updateSequence(TblSequence tblSequence);
	public void deleteSequence(String name);
	public void saveSequence(TblSequence tblSequence);
	
}
