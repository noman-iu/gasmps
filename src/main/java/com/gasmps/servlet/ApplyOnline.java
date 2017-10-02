/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasmps.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import javax.naming.SizeLimitExceededException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.gasmps.utils.ApplicationUtilityLoader;
import com.gasmps.utils.Global;
import com.gasmps.utils.Utility;

/**
 *
 * @author akhtar
 */
public class ApplyOnline extends HttpServlet {/*

    private boolean isMultipart;
    private String path ;
    private final int maxFileSize =  1024 *1024/2;
    private final int maxMemSize =   1024 * 1024;
    private File filePath;
    Blob blobFile;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection con = null;
        PrintWriter out = null;
        boolean valid = false;
        String fileSequence = "";

        try {
            out = response.getWriter();
            isMultipart = ServletFileUpload.isMultipartContent(request);
            
            if (isMultipart) 
            {
                try {
                    
                        path = ApplicationUtilityLoader.getApplicationRootPath("ragistrations");
                        DiskFileItemFactory factory = new DiskFileItemFactory();
                        // maximum size that will be stored in memory
                        factory.setSizeThreshold(maxMemSize);
                        // Location to save data that is larger than maxMemSize.
                        factory.setRepository(new File(path));
                        // Create a new file upload handler
                        ServletFileUpload upload = new ServletFileUpload(factory);
                        // maximum file size to be uploaded.
                        upload.setSizeMax(maxFileSize);
                        // Parse the request to get file items.
                        List fileItems = upload.parseRequest(request);
                        // Process the uploaded file items
                        Iterator i = fileItems.iterator();
                        while (i.hasNext()) 
                        {
                            FileItem fi = (FileItem) i.next();
                            if (!fi.isFormField()) {
                                // Get the uploaded file parameters
                                String fieldName = fi.getFieldName().trim();
                                String fileName = fi.getName().trim();
                                String contentType = fi.getContentType();
                                boolean isInMemory = fi.isInMemory();
                                long sizeInBytes = fi.getSize();
                                fileSequence = Global.getSequence("APPLY_ID");
                                // Write the file
                                String extention = Files.probeContentType(new File(path+fileName).toPath());
                                if(extention != null && extention.lastIndexOf("/") >= 0)
                                {
                                    filePath = new File(path+fileSequence+"."+extention.substring(extention.lastIndexOf("/")+1));
                                }
                                else
                                {
                                    request.setAttribute("applyValidFlag", false);
                                    request.setAttribute("applyValid", false);
                                    request.setAttribute("applyMsg","Only (PDF,JPG,JPEG,PNG) Format is allowed.");
                                    return;
                                }
                                if(extention.toUpperCase().contains("PDF") || extention.toUpperCase().contains("JPG") ||
                                        extention.toUpperCase().contains("PNG")||extention.toUpperCase().contains("JPEG")
                                        )
                                {
                                    fi.write(filePath);
                                    if(extention.toUpperCase().contains("PDF"))
                                    {
                                        valid = Utility.validatePDFData(filePath.toString());
                                    }
                                    else
                                    {
                                        valid = Utility.validateImageData(filePath.toString());
                                        out.println("Uploaded Filename: " + fileName + "<br>");
                                    }
                                    if(!valid)
                                    {
                                        try{filePath.delete();}catch(Exception ex){}
                                    }
                                    else
                                    {
                                        request.setAttribute("applyValidFlag", false);
                                        request.setAttribute("applyValid", false);
                                        request.setAttribute("applyMsg","File Contain invalid charectors.");
                                    }
                                    
                                } 
                                else
                                {
                                    request.setAttribute("applyValidFlag", false);
                                    request.setAttribute("applyValid", false);
                                    request.setAttribute("applyMsg","Only (PDF,JPG,JPEG,PNG) Format is allowed.");
                                    return;
                                }
                               
                            }
                        }
                
                } catch (Exception ex) {
                    if(((SizeLimitExceededException)ex) instanceof SizeLimitExceededException)
                    {
                        request.setAttribute("applyValidFlag", false);
                        request.setAttribute("applyValid", false);
                        request.setAttribute("applyMsg","File Size should not be more than 500 Kb.");
                        ex.printStackTrace();
                    }
                    else
                    {
                        request.setAttribute("applyValidFlag", false);
                        request.setAttribute("applyValid", false);
                        request.setAttribute("applyMsg", "Exception occured in file uploading.");
                        ex.printStackTrace();
                    }
                    return;
                }

            }

            System.out.println("at 161");
            String applyFirstName = request.getParameter("applyFirst");
            String applyLastName = request.getParameter("applyLast");
            String applyFather = request.getParameter("applyFather");
            String applyMother = request.getParameter("applyMother");
            String applyDate = request.getParameter("applyDate");
            String applyMobile = request.getParameter("applyMobile");
            String applyEmail = request.getParameter("applyEmail");
            String applyGender = request.getParameter("applyGender");
            String applyStreet = request.getParameter("applyStreet");
            String applyLine2 = request.getParameter("applyLine2");
            String applyCity = request.getParameter("applyCity");
            String applyState = request.getParameter("applyState");
            String applyZip = request.getParameter("applyZip");
            String applyCountry = request.getParameter("applyCountry");

//            System.out.println("applyFirst:" + applyFirstName);
//            System.out.println("applyLast:" + applyLastName);
//            System.out.println("applyFather:" + applyFather);
//            System.out.println("applyMother:" + applyMother);
//            System.out.println("applyDate:" + applyDate);
//            System.out.println("applyMobile:" + applyMobile);
//            System.out.println("applyEmail:" + applyEmail);
//            System.out.println("applyGender:" + applyGender);
//            System.out.println("applyStreet:" + applyStreet);
//            System.out.println("applyLine2:" + applyLine2);
//            System.out.println("applyCity:" + applyCity);
//            System.out.println("applyState:" + applyState);
//            System.out.println("applyZip:" + applyZip);
//            System.out.println("applyCountry:" + applyCountry);
            
            if (applyFirstName == null || applyFather == null || applyMother == null
                    || applyDate == null || applyMobile == null || applyGender == null
                    || applyStreet == null || applyCity == null || applyState == null || applyZip == null
                    || applyCountry == null) {
                request.setAttribute("applyValidFlag", false);
                request.setAttribute("applyValid", false);
                request.setAttribute("applyMsg", ApplicationUtilityLoader.getAttribute("ALERT_APPLY_NULL"));
                return;
            }

            applyFirstName = applyFirstName.trim();
            applyFather = applyFather.trim();
            applyMother = applyMother.trim();
            applyDate = applyDate.trim();
            applyMobile = applyMobile.trim();
            applyGender = applyGender.trim();
            applyStreet = applyStreet.trim();
            applyCity = applyCity.trim();
            applyState = applyState.trim();
            applyZip = applyZip.trim();
            applyCountry = applyCountry.trim();
            if (applyEmail != null) {
                applyEmail = applyEmail.trim();
            }
            if (applyLastName != null) {
                applyLastName = applyLastName.trim();
            }
            if (applyLine2 != null) {
                applyLine2 = applyLine2.trim();
            }

            if (applyFirstName.equalsIgnoreCase("") || applyFather.equalsIgnoreCase("")
                    || applyMother.equalsIgnoreCase("") || applyDate.equalsIgnoreCase("") || applyMobile.equalsIgnoreCase("")
                    || applyGender.equalsIgnoreCase("") || applyStreet.equalsIgnoreCase("") || applyCity.equalsIgnoreCase("")
                    || applyState.equalsIgnoreCase("") || applyZip.equalsIgnoreCase("")
                    || applyCountry.equalsIgnoreCase("")) {
                request.setAttribute("applyValidFlag", false);
                request.setAttribute("applyValid", false);
                request.setAttribute("applyMsg", ApplicationUtilityLoader.getAttribute("ALERT_APPLY_BLANK"));
                return;
            } else {
                String validateInput = "applyFirstName" + "|5|" + applyFirstName + "#";
                validateInput += "applyFather" + "|8|" + applyFather + "#";
                validateInput += "applyMother" + "|8|" + applyMother;
                validateInput += "applyMobile" + "|1|" + applyMobile;
                validateInput += "applyGender" + "|2|" + applyGender;
                validateInput += "applyStreet" + "|4|" + applyStreet;
                validateInput += "applyCity" + "|4|" + applyCity;
                validateInput += "applyState" + "|4|" + applyState;
                validateInput += "applyZip" + "|1|" + applyZip;
                validateInput += "applyCountry" + "|9|" + applyCountry;
                if (applyEmail != null && !applyEmail.equalsIgnoreCase("")) {
                    validateInput += "applyEmail" + "|5|" + applyEmail;
                }
                if (applyLastName != null && !applyLastName.equalsIgnoreCase("")) {
                    validateInput += "applyLastName" + "|8|" + applyLastName;
                }
                if (applyLine2 != null && !applyLine2.equalsIgnoreCase("")) {
                    validateInput += "applyLine2" + "|4|" + applyLine2;
                }
                String responseValue = Utility.validateInputData(validateInput);
                System.err.println("response :" + responseValue);
                if (responseValue.equalsIgnoreCase("ok")) {
                    String id = Global.getSequence("APPLY_ID");
                    DataSource ds = Global.getDataSourse();
                    con = ds.getConnection();
                    if(isMultipart && valid)
                    {
                        FileInputStream fis = new FileInputStream(filePath);
                        byte tempArray[]= IOUtils.toByteArray(fis);
                        try {blobFile = new SerialBlob(tempArray);}catch(Exception ex){}
                    }
                    String sqlInsert = "Insert into tbl_apply (apply_id,apply_first_name,apply_last_name,apply_father,apply_mother,apply_dob,apply_mobile,apply_email,apply_gender,apply_street,apply_line2,apply_city,apply_state,apply_zip,apply_country,TC) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement psInsert = con.prepareStatement(sqlInsert);
                    psInsert.setString(1, id);
                    psInsert.setString(2, applyFirstName);
                    psInsert.setString(3, applyLastName);
                    psInsert.setString(4, applyFather);
                    psInsert.setString(5, applyMother);
                    psInsert.setString(6, applyDate);
                    psInsert.setString(7, applyMobile);
                    psInsert.setString(8, applyEmail);
                    psInsert.setString(9, applyGender);
                    psInsert.setString(10, applyStreet);
                    psInsert.setString(11, applyLine2);
                    psInsert.setString(12, applyCity);
                    psInsert.setString(13, applyState);
                    psInsert.setString(14, applyZip);
                    psInsert.setString(15, applyCountry);
                    psInsert.setBlob(16, blobFile);
                    psInsert.execute();
                    psInsert.close();
                    //System.err.println("Success");
                    request.setAttribute("applyValidFlag", false);
                    request.setAttribute("applyValid", true);
                    request.setAttribute("applyMsg", ApplicationUtilityLoader.getAttribute("ALERT_APPLY_SUCCESS"));
                } else {
                    if (!responseValue.equalsIgnoreCase("NOK")) {
                        //System.err.println("not ok");
                        request.setAttribute("applyValidFlag", false);
                        request.setAttribute("applyValid", false);
                        request.setAttribute("applyMsg", ApplicationUtilityLoader.getAttribute("ALERT_APPLY_SPECIAL_CHARECTOR").replace("Field", responseValue + " Field"));
                    } else {
                        request.setAttribute("applyValidFlag", false);
                        request.setAttribute("applyValid", false);
                        request.setAttribute("applyMsg", ApplicationUtilityLoader.getAttribute("ALERT_APPLY_INVALID_CHARECTOR"));
                    }
                }

            }

        } catch (Exception ex) {
            try {
                request.setAttribute("applyValidFlag", false);
                request.setAttribute("applyValid", false);
                request.setAttribute("applyMsg", ApplicationUtilityLoader.getAttribute("ALERT_APPLY_ERROR"));
                ex.printStackTrace();
            } catch (Exception exx) {
                exx.printStackTrace();
            }

        } finally {
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            request.getRequestDispatcher("apply-online.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    *//**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *//*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    *//**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *//*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    *//**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     *//*
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

*/}
