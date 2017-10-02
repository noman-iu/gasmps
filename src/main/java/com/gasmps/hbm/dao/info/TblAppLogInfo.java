/**
 * 
 */
package com.gasmps.hbm.dao.info;

import com.gasmps.hbm.model.TblAppLog;

/**
 * @author akhtar
 *
 */
public interface TblAppLogInfo{
	
	public TblAppLog getLogByKey(String id);
	public void saveLog(TblAppLog tblAppLog);
}
