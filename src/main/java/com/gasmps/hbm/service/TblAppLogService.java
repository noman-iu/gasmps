/**
 * 
 */
package com.gasmps.hbm.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gasmps.hbm.dao.info.TblAppLogInfo;
import com.gasmps.hbm.model.TblAppLog;

/**
 * @author akhtar
 *
 */
public abstract class TblAppLogService {

	@Autowired
	TblAppLogInfo tblAppLogInfo;

	public TblAppLog getLogByKey(String id) {
		return tblAppLogInfo.getLogByKey(id);
	}

	public void saveLog(TblAppLog tblAppLog) throws Exception {
		tblAppLogInfo.saveLog(tblAppLog);
	}
}
