package com.gasmps.hbm.service;

import java.util.List;

import com.gasmps.hbm.model.TblContact;

/**
 * @author akhtar
 */

public interface TblContactService {

	public TblContact getContactByKey(String id);
	public TblContact getContactByEmail(String email);
	public List<TblContact> getAllContact();
	public void updateContact(TblContact TblContact);
	public void deleteContact(String email);
	public void saveContact(TblContact TblContact) throws Exception;
}
