/**
 * 
 */
package com.gasmps.hbm.dao.info.impl;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gasmps.hbm.dao.AbstractDAO;
import com.gasmps.hbm.dao.info.TblAppLogInfo;
import com.gasmps.hbm.model.TblAppLog;

/**
 * @author akhtar
 *
 */
@Repository("tblAppLogInfoImpl")
public class TblAppLogInfoImpl extends AbstractDAO<Serializable, TblAppLog> implements TblAppLogInfo{

	static final Logger logger = LoggerFactory.getLogger(TblAppLogInfoImpl.class);
	
	public TblAppLogInfoImpl() {
	}


	@Override
	public TblAppLog getLogByKey(String id) {
		return getByKey(id);
	}
	
	@Override
	public void saveLog(TblAppLog tblAppLog) {
		persist(tblAppLog);
	}

		
}

