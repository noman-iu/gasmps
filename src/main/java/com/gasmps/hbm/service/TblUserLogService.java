package com.gasmps.hbm.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gasmps.hbm.dao.info.TblUserLogInfo;
import com.gasmps.hbm.model.TblUserLog;

/**
 *
 * @author akhtar
 */
public abstract class TblUserLogService {

	@Autowired
	TblUserLogInfo tblUserLogInfo;

	public TblUserLog getLogByKey(String id) {
		return tblUserLogInfo.getLogByKey(id);
	}

	public void saveLog(TblUserLog tblUserLog) throws Exception {
		tblUserLogInfo.saveLog(tblUserLog);
	}
}
