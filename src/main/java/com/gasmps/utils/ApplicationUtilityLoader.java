/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasmps.utils;

import com.gasmps.listener.ServletContextListner;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

/**
 *
 * @author akhtar
 */

@Component
public class ApplicationUtilityLoader {

	private static HashMap<String, String> applicationCredential = new HashMap<>();
	public static ApplicationUtilityLoader applicationUtilityLoader;

	private ApplicationUtilityLoader() {
	}

	// Singleton pattern
	public static ApplicationUtilityLoader getInstance() {
		synchronized (ApplicationUtilityLoader.class) {
			if (applicationUtilityLoader == null)
				applicationUtilityLoader = new ApplicationUtilityLoader();
			return applicationUtilityLoader;
		}
	}

	public static String getAttribute(String attribute) throws Exception {

		Connection expconn = null;
		ResultSet rs = null;
		String ret = null;
		if (attribute == null) {
			Global.appLog("Null attribute is accessed ",
					ApplicationUtilityLoader.getInstance().getClass().getCanonicalName());
			ret = null;
		}
		attribute = attribute.trim();
		try {
			if (applicationCredential == null) {
				if (ServletContextListner.getAttributeFromServletContext("applicationCredential") != null) {
					applicationCredential = (HashMap<String, String>) ServletContextListner
							.getAttributeFromServletContext("applicationCredential");
					if (applicationCredential.containsKey(attribute)) {
						ret = applicationCredential.get(attribute);
					} else {
						ApplicationUtilityLoader.loadSingleDataFromTable(attribute);
						ServletContextListner.setAttributeToServletContext("applicationCredential",
								applicationCredential);
						ret = applicationCredential.get(attribute);
					}
				} else {
					applicationCredential = new HashMap<String, String>();
					ApplicationUtilityLoader.loadAllDataFromTable();
					ServletContextListner.setAttributeToServletContext("applicationCredential", applicationCredential);
					ret = applicationCredential.get(attribute);
				}
			} else {
				if (applicationCredential.isEmpty()) {
					ApplicationUtilityLoader.loadAllDataFromTable();
					ServletContextListner.setAttributeToServletContext("applicationCredential", applicationCredential);
					ret = applicationCredential.get(attribute);
				} else {
					if (applicationCredential.containsKey(attribute)) {
						ret = applicationCredential.get(attribute);
					} else {
						ApplicationUtilityLoader.loadSingleDataFromTable(attribute);
						ServletContextListner.setAttributeToServletContext("applicationCredential",
								applicationCredential);
						ret = applicationCredential.get(attribute);

					}
				}
			}

		} catch (Exception ex) {
			throw new Exception("");
		} finally {
			if (expconn != null) {
				try {
					expconn.close();
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
		if (ret == null) {
			Global.appLog("We could not get '" + attribute + "' attribute from Table.",
					ApplicationUtilityLoader.getInstance().getClass().getCanonicalName());
			ret = "Error";
		}
		return ret;
	}

	private static void loadAllDataFromTable() {
		Connection expconn = null;
		ResultSet rs = null;
		try {
			DataSource ds = Global.getDataSourse();
			expconn = ds.getConnection();
			Statement stmt1 = expconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "select setting_name,setting_value from tbl_setting where setting_enable = '0'";
			rs = stmt1.executeQuery(sql);
			while (rs.next()) {
				applicationCredential.put(rs.getString("setting_name").trim(), rs.getString("setting_value").trim());
			}
			// System.err.println(applicationCredential);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (expconn != null) {
				try {
					expconn.close();
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

	private static void loadSingleDataFromTable(String attribute) {
		Connection expconn = null;
		ResultSet rs = null;
		try {
			// Fetching single record from DB
			DataSource ds = Global.getDataSourse();
			expconn = ds.getConnection();
			Statement stmt1 = expconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "select setting_name,setting_value from tbl_setting where setting_name = '" + attribute
					+ "' and setting_enable = '0'";
			rs = stmt1.executeQuery(sql);
			// System.err.println("sql:"+sql);
			if (rs.next()) {
				applicationCredential.put(rs.getString("setting_name").trim(), rs.getString("setting_value").trim());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (expconn != null) {
				try {
					expconn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}

		}
	}

	public static String getApplicationRootPath(String optionalDirectoryName) {
		String attribute = "";
		String ret = "";
		Connection expconn = null;
		ResultSet rs = null;
		try {
			if (optionalDirectoryName == null || optionalDirectoryName.trim().equals("")
					|| optionalDirectoryName.equalsIgnoreCase("Dummy"))
				optionalDirectoryName = "";

			if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
				attribute = "HOME_PATH_WINDOWS";
			} else {
				attribute = "HOME_PATH_LINUX";
			}

			// Fetching single record from DB
			DataSource ds = Global.getDataSourse();
			expconn = ds.getConnection();
			Statement stmt1 = expconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "select setting_value from tbl_setting where setting_name = '" + attribute
					+ "' and setting_enable = '0'";
			rs = stmt1.executeQuery(sql);
			if (rs.next()) {
				ret = rs.getString(1).trim() + File.separator + optionalDirectoryName;
			}

			if (!ret.endsWith(File.separator))
				ret = ret + File.separator;

			try {
				File f = new File(ret);
				if (!f.isDirectory())
					f.mkdir();

			} catch (Exception e) {
				Global.appLog("We could not get '" + attribute + "' attribute from Table.",
						ApplicationUtilityLoader.getInstance().getClass().getCanonicalName());
				e.printStackTrace();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (expconn != null) {
				try {
					expconn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			return ret;
		}
	}

}