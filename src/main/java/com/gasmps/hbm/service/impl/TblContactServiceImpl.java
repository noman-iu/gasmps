package com.gasmps.hbm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gasmps.hbm.dao.info.TblContactInfo;
import com.gasmps.hbm.model.TblContact;
import com.gasmps.hbm.service.TblContactService;
import com.gasmps.hbm.service.TblSequenceService;
import com.gasmps.utils.Constant;

/**
 * @author akhtar
 */

@Service("tblContactServiceImpl")
@Transactional
public class TblContactServiceImpl implements TblContactService{

	@Autowired
	TblContactInfo tblContactInfo;
	
	@Autowired
	TblSequenceService tblSequenceService;

	@Override
	public TblContact getContactByKey(String id) {
		return tblContactInfo.getContactByKey(id);
	}

	@Override
	public TblContact getContactByEmail(String email) {
		return tblContactInfo.getContactByEmail(email);
	}

	@Override
	public List<TblContact> getAllContact() {
		return tblContactInfo.getAllContact();
	}

	@Override
	public void updateContact(TblContact tblContact) {
		tblContactInfo.updateContact(tblContact);
	}

	@Override
	public void deleteContact(String email) {
		tblContactInfo.deleteContact(email);
	}

	@Override
	public void saveContact(TblContact tblContact) throws Exception {
		tblContact.setContactId(tblSequenceService.getNextSequenceByKey(Constant.Sequence.CONTACT.id));
		tblContactInfo.saveContact(tblContact);
	}
	
	

}
