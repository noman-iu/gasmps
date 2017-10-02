/**
 * 
 */
package com.gasmps.hbm.service;

import com.gasmps.hbm.model.TblAppLog;

/**
 * @author akhtar
 *
 */
public interface TblAppLogService{
	
	public TblAppLog getLogByKey(String id);
	public void saveLog(TblAppLog tblAppLog);
}
