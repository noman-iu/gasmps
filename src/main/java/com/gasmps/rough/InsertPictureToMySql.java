package com.gasmps.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPictureToMySql 
{
  public static void main(String[] args) throws Exception, IOException, SQLException {
    
    DBTemp dt =DBTemp.getStatementInstance();
    Connection conn =  dt.con;
    String INSERT_PICTURE = "insert into tbl_email_alert (email_id , email_receiver , email_message , email_subject , email_preority , email_status , email_mode , email_path , email_attachment)\n" +
"values('0000000005','noman.akhtar2011@gmail.com','hi noman','Testing','1','0','FILE',null,?);";

    FileInputStream fis = null;
    PreparedStatement ps = null;
    try {
      conn.setAutoCommit(false);
      File file = new File("E:\\PICTURE\\20140717_180128_8_bestshot.jpg");
      fis = new FileInputStream(file);
      ps = conn.prepareStatement(INSERT_PICTURE);
      ps.setBlob(1,fis);
      //ps.setString(1, "ADMIN");
      ps.executeUpdate();
      conn.commit();
    } finally {
      ps.close();
      fis.close();
      conn.close();
    }
  }
}