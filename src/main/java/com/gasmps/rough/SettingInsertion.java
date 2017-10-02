/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasmps.rough;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gasmps.utils.Utility;

/**
 *
 * @author akhtar
 */
public class SettingInsertion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con =null;
        try {
            
            String id = SettingInsertion.getSequence("SETTING_ID");
            DBTemp dt =DBTemp.getStatementInstance();
            con =  dt.con;
            String sqlInsert = "Insert into tbl_setting (setting_id,setting_name,setting_value) values (?,?,?)";
            PreparedStatement psInsert =  con.prepareStatement(sqlInsert);
            psInsert.setString(1, id);
            psInsert.setString(2, "EMAIL_PASSWORD");//name
            psInsert.setString(3, "akhtar079723");//value
            psInsert.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(SettingInsertion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                System.err.println("Setting Inserted");
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SettingInsertion.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }
    
    public static String getSequence(String sequenceName) {
        
        Connection con = null;
        ResultSet rs = null;
        String ret = null;
        try
        {
            String newValue=null;
            DBTemp dt =DBTemp.getStatementInstance();
            con =  dt.con; 
            String sqlSelect = "select * from tbl_sequence where name = ?";
            PreparedStatement psSelect =  con.prepareCall(sqlSelect);
            psSelect.setString(1, sequenceName.trim());
            rs = psSelect.executeQuery();
            if (rs.next()){
                
                long id = Long.parseLong(rs.getString("value").trim());
                long min = Long.parseLong(rs.getString("min_value").trim());
                long max = Long.parseLong(rs.getString("max_value").trim());
                int inc = rs.getInt("increase");
                ret = String.valueOf(id);
                if( id >= min && id <= max ){
                    id =id+inc;
                    newValue = Utility.paddingString(String.valueOf(id), 10, "0", true);
                }
                else{
                newValue =new SimpleDateFormat("hhmmssddMM").format(new Date());
                }
                String sqlUpdate = "update tbl_sequence set value = ? where name = ?";
                PreparedStatement psUpdate = con.prepareStatement(sqlUpdate);
                psUpdate.setString(1, newValue);
                psUpdate.setString(2, sequenceName);
                psUpdate.executeUpdate();
                    
            }
            else{
                String sqlInsert = "insert into tbl_sequence (name,value,min_value,max_value,increase) values(?,?,?,?,?)";
                PreparedStatement psInsert = con.prepareStatement(sqlInsert);
                psInsert.setString(1, sequenceName);
                psInsert.setString(2, "0000000001");
                psInsert.setString(3, "0000000000");
                psInsert.setString(4, "9999999999");
                psInsert.setInt(5, 1);
                psInsert.execute();
                ret = "0000000000";
            
            }
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return Utility.paddingString(ret, 10, "0", true).trim();
    }
    
    
}
