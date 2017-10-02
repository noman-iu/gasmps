/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasmps.servlet;

import javax.servlet.http.HttpServlet;

/**
 *
 * @author akhtar
 */
public class ContactReceiver extends HttpServlet {/*

    *//**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *//*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        JSONObject json = null;
        Connection con = null;
        PrintWriter out = null;
        json = new JSONObject();
        
        try {
            out = response.getWriter();
            String contactName = request.getParameter("contactName");
            String contactEmail = request.getParameter("contactEmail");
            String contactMobile = request.getParameter("contactMobile");
            String contactMessage = request.getParameter("contactMessage");
            
            
            if(contactName == null || contactEmail == null || contactMobile == null || contactMessage == null ){
            json.put("valid", false);
            json.put("msg", ApplicationUtilityLoader.getAttribute("ALERT_CONTACT_NULL"));
            return;
            }
            
            contactName = contactName.trim();
            contactEmail = contactEmail.trim();
            contactMobile = contactMobile.trim();
            contactMessage = contactMessage.trim();
                
            if(contactName.equalsIgnoreCase("") || contactEmail.equalsIgnoreCase("")||
                    contactMobile.equalsIgnoreCase("")||contactMessage.equalsIgnoreCase(""))
            {
                json.put("valid", false);
                json.put("msg", ApplicationUtilityLoader.getAttribute("ALERT_CONTACT_BLANK"));
                return;
            }
            else
            {
                String validateInput = "contactName"+"|5|"+contactName+"#";
                validateInput += "contactEmail"+"|6|"+contactEmail+"#";
                validateInput += "contactMobile"+"|1|"+contactMobile+"#";
                validateInput += "contactMessage"+"|7|"+contactMessage;
                String responseValue = Utility.validateInputData(validateInput);
                //System.err.println("response :"+responseValue);
                if(responseValue.equalsIgnoreCase("ok"))
                {
                    String id = Global.getSequence("CONTACT_ID");
                    DataSource ds = Global.getDataSourse();
                    con =  ds.getConnection();
                    String sqlInsert = "Insert into tbl_contact (contact_id,contact_name,contact_email,contact_mobile,contact_message) values (?,?,?,?,?)";
                    PreparedStatement psInsert =  con.prepareStatement(sqlInsert);
                    psInsert.setString(1, id);
                    psInsert.setString(2, contactName);
                    psInsert.setString(3, contactEmail);
                    psInsert.setString(4, contactMobile);
                    psInsert.setString(5, contactMessage);
                    psInsert.execute();
                    //System.err.println("Success");
                    json.put("valid", true);
                    json.put("msg", ApplicationUtilityLoader.getAttribute("ALERT_CONTACT_SUCCESS"));
                }
                else{
                        if(!responseValue.equalsIgnoreCase("NOK"))
                        {
                         //System.err.println("not ok");
                         json.put("valid", false);
                         json.put("msg", ApplicationUtilityLoader.getAttribute("ALERT_CONTACT_SPECIAL_CHARECTOR").replace("Field", responseValue+" Field"));
                        }else{
                         json.put("valid", false);
                         json.put("msg", ApplicationUtilityLoader.getAttribute("ALERT_CONTACT_INVALID_CHARECTOR"));
                        }
                }
                
            }
            
            
        }catch(Exception ex){
            try {
                json.put("valid", false);
                json.put("msg", ApplicationUtilityLoader.getAttribute("ALERT_CONTACT_ERROR"));
                ex.printStackTrace();
            } catch (JSONException exx) {
                exx.printStackTrace();
            }
            
        }finally{
            out.write(json.toString());
            if(out != null){
            try {
                out.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
            if(con != null){
            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        
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
