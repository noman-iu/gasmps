/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasmps.rough;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *z
 * @author akhtar
 */
public class DBTemp{
    
    public static  Statement st;
    public static Connection con;
    static DBTemp db;
    
    
    public static DBTemp getStatementInstance() {
               
        if (db == null) {
            db = new DBTemp();
        }
        return db;
    }
    
     private DBTemp(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            try {
                
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gas","root","admin");
                 st = con.createStatement();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet toRead(String Read, Statement st1) {
        ResultSet result = null;
        try {
            result = st.executeQuery(Read);
            st.clearBatch();

        } catch (SQLException abc) {
            abc.printStackTrace();
        }
        return result;
    }

    public boolean toWrite(String wrt, Statement st1) {
        boolean b = false;
        try {

            b = st.execute(wrt);
            st.clearBatch();
        } catch (SQLException abc) {
            abc.printStackTrace();
        }
        return b;
    }

    public int toUpdate(String upt, Statement st1) {
        int u = 0;
        try {

            u = st.executeUpdate(upt);
            st.clearBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return u;
    }

    public int toDelete(String upt, Statement st1) {
        int m = 0;
        try {
            m = st.executeUpdate(upt);
            st.clearBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return m;
    }
    
}
