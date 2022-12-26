package Control.Login;

import DAO.LoginDAO;
import DAO.UserDAO;
import Entity.Login;
import Entity.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Semester: FALL 2022 Subject : FRJ301 Class : SE1606 Project : Nutrition
 *
 * @author : Group 4 CE161130 Nguyen Le Quang Thinh (Leader) CE170036 Pham Nhat
 * Quang CE160464 Nguyen The Lu CE161096 Nguyen Ngoc My Quyen CE161025 Tran Thi
 * Ngoc Hieu
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
            Boolean googleLogin = Boolean.parseBoolean(request.getParameter("google-login"));
            String remember = request.getParameter("remember");
            String email = request.getParameter("email");

            LoginDAO loginDAO = new LoginDAO();
            UserDAO userDAO = new UserDAO();
            User user = null;
            Login login = null;
            Login findUser = loginDAO.findUserName(username);
            if (googleLogin && email != null) {
//                response.getWriter().write((email instanceof String) + "");
                int existAccount = 
                        loginDAO.checkLoginByEmail(email);
                response.getWriter().write(existAccount + "");
                if (existAccount != -1) {
                    login = loginDAO.getLoginRecordFromUserID(existAccount+"");
                }
            } else {
                if (findUser != null) {
                    int userid = findUser.getUserID();
                    user = userDAO.getRoleByUserID(userid);
                }
                if (user != null) {
                    //Get an instance of Login entry if username and password is correct
                    if (user.getUserRoleId() == 2) {
                        login = loginDAO.checkLogin(username, password);
                    } else {
                        login = loginDAO.checkAdminLogin(username, password);
                    }
                }
            }

            if (login == null) {//If there's no instance, redirect to error page
                request.getRequestDispatcher("login-error-control").forward(request, response);
            } else {//If login info is correct
                HttpSession session = request.getSession();//Get current session
                session.setAttribute("userID", login.getUserID());//Set userID to logged in userID
                session.setAttribute("username", login.getUsername());//Set username to logged in username
                if (remember != null) {
                    Cookie userID = new Cookie("userID", login.getUserID() + "");
                    Cookie userName = new Cookie("username", login.getUsername());
                    userID.setMaxAge(86400 * 3);
                    userName.setMaxAge(86400 * 3);
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
