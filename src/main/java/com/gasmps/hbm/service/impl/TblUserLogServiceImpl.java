package com.gasmps.hbm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gasmps.hbm.model.TblUserLog;
import com.gasmps.hbm.service.TblSequenceService;
import com.gasmps.hbm.service.TblUserLogService;
import com.gasmps.utils.Constant;

/**
 *
 * @author akhtar
 */

@Service("tblUserLogServiceImpl")
@Transactional
public class TblUserLogServiceImpl extends TblUserLogService {

	@Autowired
	TblSequenceService tblSequenceService;

	public TblUserLogServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TblUserLog getLogByKey(String id) {
		return super.getLogByKey(id);
	}

	@Override
	public void saveLog(TblUserLog tblUserLog) throws Exception {
		tblUserLog.setLogId(tblSequenceService.getNextSequenceByKey(Constant.Sequence.USER_LOG.id));
		super.saveLog(tblUserLog);
	}

}
