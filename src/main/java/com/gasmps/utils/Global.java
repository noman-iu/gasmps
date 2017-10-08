/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasmps.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author akhtar
 */

@Component
@Scope("singleton")
public class Global {

	@Autowired
	MessageSource messageSource;
	
	public Global() {
		
	}

	public String getMessage(Constant.GenricResponseCode genricResponseCode) {
		return messageSource.getMessage(genricResponseCode.toString(), null, Locale.getDefault());
	}
	

	/*public static void emailAlert(EmailAlert el) {

		Connection con = null;
		try {
			DataSource ds = Global.getDataSourse();
			con = ds.getConnection();
			String log_id = Global.getSequence("EMAIL_ID");
			String sqlInsert = "insert into tbl_email_alert (email_id , mail_receiver , email_message , email_subject , email_preority , email_status , email_mode , email_path , email_attachment_type , email_attachment)"
					+ " values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement psInsert = con.prepareStatement(sqlInsert);
			psInsert.setString(1, log_id.trim());
			psInsert.setString(2, el.getMailReceiver());
			psInsert.setString(3, el.getEmailMessage());
			psInsert.setString(4, el.getEmailSubject());
			psInsert.setString(5, el.getEmailPreority());
			psInsert.setString(6, el.getEmailStatus());
			psInsert.setString(7, el.getEmailMode());
			psInsert.setString(8, el.getEmailPath());
			psInsert.setString(9, el.getEmailAttachmentType());
			psInsert.setBlob(10, new javax.sql.rowset.serial.SerialBlob(el.getEmailAttachment()));
			psInsert.execute();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}

	}*/

}
