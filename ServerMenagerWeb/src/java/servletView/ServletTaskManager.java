/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletView;

import exceptions.InvalidRecordFieldException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import model.LoaderSQL;
import model.Record;

/**
 *
 * @author USER
 */
@WebServlet(name = "ServletTaskManager", urlPatterns = {"/ServletTaskManager"})
public class ServletTaskManager extends HttpServlet{
    
    private LoaderSQL service = new LoaderSQL();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NamingException, SQLException, InvalidRecordFieldException {
        //getServletContext().getRequestDispatcher("/taskManager.jsp").forward(request, response);
        Record r;
        
        char s = request.getParameter("submit").charAt(0);
        switch (s) {
            case 'a': 
                try {
                    String nn=request.getParameter("name");
                    String dd=request.getParameter("descr");
                    String tt=request.getParameter("time");
                    String cc=request.getParameter("cont");
                    r = new Record(nn, dd,tt,cc);
                    service.addDataInTableTask(r.getId(), r.getName(), r.getTimeString(), r.getContacts(), r.getDescription());
                } catch (InvalidRecordFieldException | SQLException ex) {
                   // System.out.println(ex.getMessage());
                    //Logger.getLogger(ServletTaskManager.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            
            case 'd':
                String str= request.getParameter("submit").substring(1);  
               service.deleteDataInTableTask(str);
            
                //**************************
                break;
        //**************************
            case 'c':
                String str1= request.getParameter("submit").substring(1); 
                 request.setAttribute ("id" ,str1);
                 request.getRequestDispatcher("change.jsp").forward(request, response);
                 

                break;
          
            default:
                break;
        }
        request.setAttribute("records", service.selectInTableTask());
        request.getRequestDispatcher("taskManager.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(ServletTaskManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletTaskManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidRecordFieldException ex) {
            Logger.getLogger(ServletTaskManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(ServletTaskManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletTaskManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidRecordFieldException ex) {
            Logger.getLogger(ServletTaskManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
