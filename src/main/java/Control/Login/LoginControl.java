package Control.Login;

import DAO.LoginDAO;
import DAO.UserDAO;
import Entity.Login;
import Entity.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Map;

/**
 * Handles login control coming from Login.jsp
 *
 * @author Thinh
 * @author Pham Nhat Quang
 */
public class LoginControl extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try {
            //Get info from form request
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String remember = request.getParameter("remember");

            LoginDAO loginDAO = new LoginDAO();
            UserDAO userDAO   = new UserDAO();
            
            Login b = loginDAO.findUserName(username);
            int userid = b.getUserID();
            User u = userDAO.getRoleByUserID(userid);
            
            //Get an instance of Login entry if username and password is correct
            Login a = null;
            if (u.getUserRoleId() == 2){
                a = loginDAO.checkLogin(username, password);
            } else {
                a = loginDAO.checkAdminLogin(username, password);
            }
            //Get an instance of Login entry if username and password is correct
            if (a == null) {//If there's no instance, redirect to error page
                    response.sendRedirect("login-error.jsp");            
            } else {//If login info is correct
                HttpSession session = request.getSession();//Get current session

                session.setAttribute("userID", a.getUserID());//Set userID to logged in userID
                session.setAttribute("username", a.getUsername());//Set username to logged in username
                if (remember != null) {
                    Cookie userID = new Cookie("userID", a.getUserID() + "");
                    Cookie userName = new Cookie("username", a.getUsername());
                    userID.setMaxAge(86400 * 3);
                    userName.setMaxAge(86400 * 3);
                    response.addCookie(userID);
                    response.addCookie(userName);
                }
                if (u.getUserRoleId() == 2) {
                    response.sendRedirect("home-control");//Redirect to home controller
                } else {
                    response.sendRedirect("admin");//Redirect to home controller
                }

                response.sendRedirect("home-control");//Redirect to home controller
            }
        } catch (Exception e) {
            response.getWriter().println(e);
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
        processRequest(request, response);
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
        return "This servlet handles login functionality";
    }// </editor-fold>

}