package com.gasmps.hbm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gasmps.hbm.model.TblContact;
import com.gasmps.hbm.service.TblContactService;
import com.gasmps.hbm.service.TblSequenceService;
import com.gasmps.utils.Constant;

/**
 * @author akhtar
 */

@Service("tblContactServiceImpl")
@Transactional
public class TblContactServiceImpl extends TblContactService {

	@Autowired
	TblSequenceService tblSequenceService;

	public TblContactServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TblContact getContactByKey(String id) {
		return super.getContactByKey(id);
	}

	@Override
	public TblContact getContactByEmail(String email) {
		return super.getContactByEmail(email);
	}

	@Override
	public List<TblContact> getAllContact() {
		return super.getAllContact();
	}

	@Override
	public void updateContact(TblContact tblContact) {
		super.updateContact(tblContact);
	}

	@Override
	public void deleteContact(String email) {
		super.deleteContact(email);
	}

	@Override
	public void saveContact(TblContact tblContact) throws Exception {
		tblContact.setContactId(tblSequenceService.getNextSequenceByKey(Constant.Sequence.CONTACT.id));
		super.saveContact(tblContact);
	}

}
