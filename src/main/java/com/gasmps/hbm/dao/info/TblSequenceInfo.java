package com.gasmps.hbm.dao.info;

import java.util.List;

import com.gasmps.hbm.model.TblSequence;

/**
 * @author akhtar
 */

public interface TblSequenceInfo {

	public TblSequence getSequenceByKey(String name);
	public List<TblSequence> getAllSequence();
	public void updateSequence(TblSequence tblSequence);
	public void deleteSequence(String name);
	public void saveSequence(TblSequence tblSequence);
	
}
