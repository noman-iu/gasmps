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
public class CommentReceiver extends HttpServlet {/*

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
            String commentName = request.getParameter("commentName");
            String commentEmail = request.getParameter("commentEmail");
            String commentSubject = request.getParameter("commentSubject");
            String commentMessage = request.getParameter("commentMessage");
            
            
            if(commentName == null || commentEmail == null || commentSubject == null || commentMessage == null ){
            json.put("valid", false);
            json.put("msg", ApplicationUtilityLoader.getAttribute("ALERT_COMMENT_NULL"));
            return;
            }
            commentName = commentName.trim();
            commentEmail = commentEmail.trim();
            commentSubject = commentSubject.trim();
            commentMessage = commentMessage.trim();
                
            if(commentName.equalsIgnoreCase("") || commentEmail.equalsIgnoreCase("")||
                    commentSubject.equalsIgnoreCase("")||commentMessage.equalsIgnoreCase(""))
            {
                json.put("valid", false);
                json.put("msg", ApplicationUtilityLoader.getAttribute("ALERT_COMMENT_BLANK"));
                return;
            }
            else
            {
                
                String validateInput = "commentName"+"|5|"+commentName+"#";
                validateInput += "commentEmail"+"|6|"+commentEmail+"#";
                validateInput += "commentSubject"+"|7|"+commentSubject+"#";
                validateInput += "commentMessage"+"|7|"+commentMessage;
                String responseValue = Utility.validateInputData(validateInput);
                //System.err.println("response :"+responseValue);
                if(responseValue.equalsIgnoreCase("ok"))
                {
                    String id = Global.getSequence("CONTACT_ID");
                    DataSource ds = Global.getDataSourse();
                    con =  ds.getConnection();
                    String sqlInsert = "Insert into tbl_comment (comment_id,comment_name,comment_email,comment_mobile,comment_message) values (?,?,?,?,?)";
                    PreparedStatement psInsert =  con.prepareStatement(sqlInsert);
                    psInsert.setString(1, id);
                    psInsert.setString(2, commentName);
                    psInsert.setString(3, commentEmail);
                    psInsert.setString(4, commentSubject);
                    psInsert.setString(5, commentMessage);
                    psInsert.execute();
                    //System.err.println("Success");
                    json.put("valid", true);
                    json.put("msg", ApplicationUtilityLoader.getAttribute("ALERT_COMMENT_SUCCESS"));
                }
                else{
                        if(!responseValue.equalsIgnoreCase("NOK"))
                        {
                         //System.err.println("not ok");
                         json.put("valid", false);
                         json.put("msg", ApplicationUtilityLoader.getAttribute("ALERT_COMMENT_SPECIAL_CHARECTOR").replace("Field", responseValue+" Field"));
                        }else{
                         json.put("valid", false);
                         json.put("msg", ApplicationUtilityLoader.getAttribute("ALERT_COMMENT_INVALID_CHARECTOR"));
                        }
                }
                
            }
            
            
        }catch(Exception ex){
            try {
                System.err.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
                json.put("valid", false);
                json.put("msg", ApplicationUtilityLoader.getAttribute("ALERT_COMMENT_ERROR"));
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
