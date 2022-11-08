package Control.Login;

import DAO.GoalDAO;
import DAO.HealthDAO;
import DAO.LoginDAO;
import DAO.UserDAO;
import Security.Encryption;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Security.RegLoginLogic;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pham Nhat Quang
 */
public class RegisterControl extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        request.getSession().invalidate();//Invalidate current session when user register account
        request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        LoginDAO logDAO = new LoginDAO();
        HealthDAO heath = new HealthDAO();
        GoalDAO goal = new GoalDAO();

        int checkDuplicate;
        try {
            checkDuplicate = logDAO.checkUserNameDuplicate(username);
            if (checkDuplicate == 1) {
                response.sendRedirect("register-error-control");
            } else {
                String empString = "";

                String salt = Encryption.generateSalt(username, password);
                String hashedPassword = RegLoginLogic.encryptPassword(salt, password);

                if (hashedPassword.equals(empString) || salt.equals("Unable to generate salt")) {
                    response.sendRedirect("register-error-control");
                }
                if (username == null || password == null || firstName == null || lastName == null || email == null || phone == null) {
                    response.sendRedirect("register-error-control");
                } else {

                    logDAO.addLoginInfo(username, salt, hashedPassword);

                    int loginID = 0;
                    loginID = logDAO.getLastID();

                    UserDAO userDAO = new UserDAO();

                    userDAO.addUser(loginID + "", "2", firstName, lastName, phone, email);
//////////
                    logDAO.updateUserID(loginID, loginID);

                    request.setAttribute("userID", loginID);
//                    response.getWriter().println(loginID);
//                    response.getWriter().print(request.getAttribute("userID"));
                    
                    heath.insertHealthInfo(loginID+"",0+"",0+"", 0+"",0+"",0+"");
                    goal.addGoal(loginID+"", 0+"");

                    request.getRequestDispatcher("healthinfo")
                            .forward(request, response);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterControl.class.getName()).log(Level.SEVERE, null, ex);
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
