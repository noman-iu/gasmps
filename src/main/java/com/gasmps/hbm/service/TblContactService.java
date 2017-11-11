package com.gasmps.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gasmps.hbm.dao.info.TblContactInfo;
import com.gasmps.hbm.model.TblContact;

/**
 * @author akhtar
 */
public abstract class TblContactService {

	@Autowired
	protected TblContactInfo tblContactInfo;

	public TblContact getContactByKey(String id) {
		return tblContactInfo.getContactByKey(id);
	}

	public TblContact getContactByEmail(String email) {
		return tblContactInfo.getContactByEmail(email);
	}

	public List<TblContact> getAllContact() {
		return tblContactInfo.getAllContact();
	}

	public void updateContact(TblContact tblContact) {
		tblContactInfo.updateContact(tblContact);
	}

	public void deleteContact(String email) {
		tblContactInfo.deleteContact(email);
	}

	public void saveContact(TblContact tblContact) throws Exception {
		tblContactInfo.saveContact(tblContact);
	}
}
