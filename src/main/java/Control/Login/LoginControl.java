package Control.Login;

import DAO.LoginDAO;
import Entity.Login;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Handles login control coming from Login.jsp
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
            
            //Get an instance of Login entry if username and password is correct
            Login a = loginDAO.checkLogin(username, password);
            
            if (a == null) {//If there's no instance, redirect to error page
                response.sendRedirect("login-error.jsp");
            } else {//If login info is correct
                HttpSession session = request.getSession();//Get current session
                
                session.setAttribute("userID", a.getUserID());//Set userID to logged in userID
                session.setAttribute("username", a.getUsername());//Set username to logged in username
                if (remember!=null){
                    Cookie userID = new Cookie("userID", a.getUserID()+"");
                    Cookie userName = new Cookie("userName", a.getUsername());
                    userID.setMaxAge(86400*3);
                    userName.setMaxAge(86400*3);
                    response.addCookie(userID);
                    response.addCookie(userName);
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
