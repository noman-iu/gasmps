/**
 * 
 */
package com.gasmps.hbm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gasmps.hbm.model.TblAppLog;
import com.gasmps.hbm.service.TblAppLogService;
import com.gasmps.hbm.service.TblSequenceService;
import com.gasmps.utils.Constant;

/**
 * @author akhtar
 * @param <T>
 *
 */
@Service("tblAppLogServiceImpl")
@Transactional
public class TblAppLogServiceImpl extends TblAppLogService {

	@Autowired
	TblSequenceService tblSequenceService;

	public TblAppLogServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveLog(TblAppLog tblAppLog) throws Exception {
		tblAppLog.setLogId(tblSequenceService.getNextSequenceByKey(Constant.Sequence.APP_LOG.id));
		super.saveLog(tblAppLog);
	}

	@Override
	public TblAppLog getLogByKey(String id) {
		return super.getLogByKey(id);
	}

}
