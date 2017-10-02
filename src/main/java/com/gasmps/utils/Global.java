/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasmps.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.gas.pojo.EmailAlert;

/**
 *
 * @author akhtar
 */

public class Global {

	private static final String APP_JNDI = "java:jboss/datasources/gasmps";
	//private static DataSource dataSource;
	public static Global global;

	@Autowired
	IdGenrator idGenrator;
	
	public Global() {
	}

	public static Global getInstance() {
		synchronized (Global.class) {
			if (global == null)
				global = new Global();
			return global;
		}
	}

	public static DataSource getDataSourse() {
		/*try {
			if (ServletContextListner.getAttributeFromServletContext("dataSource") != null) {
				dataSource = (DataSource) ServletContextListner.getAttributeFromServletContext("dataSource");
			} else {
				Context initialContext = new InitialContext();
				dataSource = (DataSource) initialContext.lookup(APP_JNDI);
				ServletContextListner.setAttributeToServletContext("dataSource", dataSource);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}*/
		return null;//dataSource;
	}

	public static String getSequence(String sequenceName) {

		Connection con = null;
		ResultSet rs = null;
		String ret = null;
		try {
			String newValue = null;
			DataSource ds = Global.getDataSourse();
			con = ds.getConnection();
			String sqlSelect = "select * from tbl_sequence where name = ?";
			PreparedStatement psSelect = con.prepareStatement(sqlSelect);
			psSelect.setString(1, sequenceName.trim());
			rs = psSelect.executeQuery();
			if (rs.next()) {

				long id = Long.parseLong(rs.getString("value").trim());
				long min = Long.parseLong(rs.getString("min_value").trim());
				long max = Long.parseLong(rs.getString("max_value").trim());
				int inc = rs.getInt("increase");
				ret = String.valueOf(id);
				if (id >= min && id <= max) {
					id = id + inc;
					newValue = Utility.paddingString(String.valueOf(id), 10, "0", true);
				} else {
					newValue = new SimpleDateFormat("hhmmssddMM").format(new Date());
					Global.appLog("Problem in genrating '" + sequenceName + "' Sequence id in Sequence Genrator Class.",
							Global.getInstance().getClass().getCanonicalName());
				}
				String sqlUpdate = "update tbl_sequence set value = ? where name = ?";
				PreparedStatement psUpdate = con.prepareStatement(sqlUpdate);
				psUpdate.setString(1, newValue);
				psUpdate.setString(2, sequenceName);
				psUpdate.executeUpdate();

			} else {
				String sqlInsert = "insert into tbl_sequence (name,value,min_value,max_value,increase) values(?,?,?,?,?)";
				PreparedStatement psInsert = con.prepareStatement(sqlInsert);
				psInsert.setString(1, sequenceName);
				psInsert.setString(2, "0000000002");
				psInsert.setString(3, "0000000000");
				psInsert.setString(4, "9999999999");
				psInsert.setInt(5, 1);
				psInsert.execute();
				ret = "0000000001";
				Global.appLog("New Sequence '" + sequenceName + "' has been added in Sequence Table.",
						Global.getInstance().getClass().getCanonicalName());

			}

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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		return Utility.paddingString(ret, 10, "0", true).trim();
	}

	public static void emailAlert(EmailAlert el) {

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

	}

	public static void appLog(String description, String logClass) {

		Connection con = null;
		try {
			DataSource ds = Global.getDataSourse();
			con = ds.getConnection();
			String log_id = Global.getSequence("APP_LOG_ID");
			String sqlInsert = "insert into tbl_app_log (log_id,log_description,log_class) values(?,?,?)";
			PreparedStatement psInsert = con.prepareStatement(sqlInsert);
			System.err.println("app_log_id:" + log_id);
			psInsert.setString(1, log_id.trim());
			psInsert.setString(2, description.trim());
			psInsert.setString(3, logClass.trim());
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

	}

	public static void userLog(String ip, String host, String client, String location, boolean validation) {

		Connection con = null;
		ResultSet rs = null;
		try {
			DataSource ds = Global.getDataSourse();
			con = ds.getConnection();
			if (validation) {
				String sqlSelect = "select log_id,log_time from tbl_user_log where log_ip=? and log_host=? and log_client=? and log_location=? and log_id>=(select max(log_id) from tbl_user_log)";
				PreparedStatement psSelect = con.prepareStatement(sqlSelect);
				psSelect.setString(1, ip.trim());
				psSelect.setString(2, host.trim());
				psSelect.setString(3, client.trim());
				psSelect.setString(4, location.trim());
				rs = psSelect.executeQuery();
				if (rs.next()) {
					String logId = rs.getString("log_id").toString();
					System.err.println("logId:" + logId);
					String logDate = rs.getTimestamp("log_time").toString();
					SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
					Date curD = new Date();
					Date preD = sf1.parse(logDate);
					System.err.println("cur:" + curD);
					System.err.println("pre:" + preD);
					if (curD.after(preD)) {
						System.err.println("after");
						String id = Global.getSequence("USER_LOG_ID");
						String sqlInsert = "insert into tbl_user_log (log_id,log_ip,log_host,log_client,log_location) values(?,?,?,?,?)";
						PreparedStatement psInsert = con.prepareStatement(sqlInsert);
						psInsert.setString(1, id);
						psInsert.setString(2, ip.trim());
						psInsert.setString(3, host.trim());
						psInsert.setString(4, client.trim());
						psInsert.setString(5, location.trim());
						psInsert.execute();
					} else {
						return;
					}
				}

			} else {
				String id = Global.getSequence("USER_LOG_ID");
				String sqlInsert = "insert into tbl_user_log (log_id,log_ip,log_host,log_client,log_location) values(?,?,?,?,?)";
				PreparedStatement psInsert = con.prepareStatement(sqlInsert);
				psInsert.setString(1, id);
				psInsert.setString(2, ip.trim());
				psInsert.setString(3, host.trim());
				psInsert.setString(4, client.trim());
				psInsert.setString(5, location.trim());
				psInsert.execute();
			}

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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}

	}

}
