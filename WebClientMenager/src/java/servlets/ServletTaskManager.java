/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import clientmenager.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class ServletTaskManager extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getServletContext().getRequestDispatcher("/taskManager.jsp").forward(req, resp);
        req.setAttribute("records", Controller.getRecords());
        req.getRequestDispatcher("taskManager.jsp").forward(req, resp);
    }
}
