/**
 * 
 */
package com.gasmps.hbm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gasmps.hbm.dao.info.TblAppLogInfo;
import com.gasmps.hbm.model.TblAppLog;
import com.gasmps.hbm.service.TblAppLogService;

/**
 * @author akhtar
 * @param <T>
 *
 */
@Service("tblAppLogServiceImpl")
@Transactional
public class TblAppLogServiceImpl implements TblAppLogService{

	@Autowired
	TblAppLogInfo tblAppLogInfo;
	
	public TblAppLogServiceImpl() {
	}
	
	@Override
	public void saveLog(TblAppLog tblAppLog) {
		tblAppLogInfo.saveLog(tblAppLog);
	}

	@Override
	public TblAppLog getLogByKey(String id) {
		return tblAppLogInfo.getLogByKey(id);
	}
	
}

