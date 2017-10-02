package com.gasmps.hbm.service;

import com.gasmps.hbm.model.TblUserLog;

/**
*
* @author akhtar
*/

public interface TblUserLogService {
	
	public TblUserLog getLogByKey(String id);
	public void saveLog(TblUserLog tblUserLog) throws Exception;
}
