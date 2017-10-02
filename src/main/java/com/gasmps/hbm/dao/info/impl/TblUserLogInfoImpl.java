package com.gasmps.hbm.dao.info.impl;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gasmps.hbm.dao.AbstractDAO;
import com.gasmps.hbm.dao.info.TblUserLogInfo;
import com.gasmps.hbm.model.TblUserLog;

@Repository("tblUserLogInfoImpl")
public class TblUserLogInfoImpl extends AbstractDAO<Serializable, TblUserLog> implements TblUserLogInfo{

	static final Logger logger = LoggerFactory.getLogger(TblUserLogInfoImpl.class);
	
	public TblUserLogInfoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public TblUserLog getLogByKey(String id) {
		return getByKey(id);
	}
	
	@Override
	public void saveLog(TblUserLog tblUserLog) {
		persist(tblUserLog);
	}

	

}
