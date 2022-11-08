/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Control.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Semester: FALL 2022
 * Subject : FRJ301
 * Class   : SE1606
 * Project : Nutrition 
 * @author : Group 4
 * CE161130  Nguyen Le Quang Thinh (Leader)
 * CE170036  Pham Nhat Quang
 * CE160464  Nguyen The Lu
 * CE161096  Nguyen Ngoc My Quyen
 * CE161025  Tran Thi Ngoc Hieu
 */
public class AdminControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();//Get current session
        if (session.getAttribute("username") == null) {
            response.sendRedirect("login");
        }
        if (action == null) {
            response.sendRedirect("admin");
            return;
        }
        switch (action) {
            case "SEARCH USER":
                request.getRequestDispatcher("user-load-control").forward(request, response);
                break;
            case "USER INFO":
                request.getRequestDispatcher("user-load-control").forward(request, response);
                break;
            case "EXERCISE MANAGEMENT":
                request.getRequestDispatcher("admin-exercisetype-control").forward(request, response);
                break;
            case "LOG OUT":
                response.sendRedirect("logout-control");
                break;
            default:
                response.sendRedirect("admin");
        }

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
        String action = request.getParameter("action");
        HttpSession session = request.getSession();//Get current session
        if (session.getAttribute("username") == null) {
            response.sendRedirect("login");
        }
        if (action == null) {
            response.sendRedirect("admin");
            return;
        }
        switch (action) {
            case "HOME":
                response.sendRedirect("home-control");
                break;
            case "ADMIN INFO":
                request.getRequestDispatcher("admin-load-control").forward(request, response);
                break;
            case "USER INFO":
                request.getRequestDispatcher("user-load-control").forward(request, response);
                break;
            case "EXERCISE MANAGEMENT":
                request.getRequestDispatcher("admin-exercisetype-control").forward(request, response);
                break;
            case "LOG OUT":
                response.sendRedirect("logout-control");
                break;
            default:
                response.sendRedirect("admin");
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
        processRequest(request, response);
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
