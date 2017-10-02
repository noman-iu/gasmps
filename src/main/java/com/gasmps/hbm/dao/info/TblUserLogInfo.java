package com.gasmps.hbm.dao.info;

import com.gasmps.hbm.model.TblUserLog;

/**
*
* @author akhtar
*/

public interface TblUserLogInfo {
	
	public TblUserLog getLogByKey(String id);
	public void saveLog(TblUserLog tblUserLog);
}
