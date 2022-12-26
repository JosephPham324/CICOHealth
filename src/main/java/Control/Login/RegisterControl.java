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
 * Semester: FALL 2022 Subject : FRJ301 Class : SE1606 Project : Nutrition
 *
 * @author : Group 4 CE161130 Nguyen Le Quang Thinh (Leader) CE170036 Pham Nhat
 * Quang CE160464 Nguyen The Lu CE161096 Nguyen Ngoc My Quyen CE161025 Tran Thi
 * Ngoc Hieu
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
        try (PrintWriter out = response.getWriter()) {
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
//        processRequest(request, response);
        response.sendRedirect("home-control");
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

        //Get request parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Boolean googleRegister = Boolean.parseBoolean(request.getParameter("google-register"));

        //DAOs for interacting with database 
        LoginDAO loginDAO = new LoginDAO();
        HealthDAO healthDAO = new HealthDAO();
        GoalDAO goalDAO = new GoalDAO();
        
        int checkDuplicate;
        try {
            checkDuplicate = loginDAO.checkUserNameDuplicate(username);
            if (checkDuplicate == 1 && !googleRegister) {
                request.getRequestDispatcher("register-error-control").forward(request, response);
            } else {
                String empString = "";
                
                String salt = Encryption.generateSalt(username, password);
                String hashedPassword = RegLoginLogic.encryptPassword(salt, password);
                
                if (hashedPassword.equals(empString) || salt.equals("Unable to generate salt")) {
                    //Guard clause for if unable to hash password
                    response.sendRedirect("register-error-control");
                }
                if (username == null || password == null || firstName == null || lastName == null || email == null || phone == null) {
//                    Guard clause for if any parameter is null
                    response.sendRedirect("register-error-control");
                } else {//If no guard clause is activated
                    //Add login info for new account
                    if (googleRegister != true) {//If not register using google
                        loginDAO.addLoginInfo(username, salt, hashedPassword);
                    } else if (loginDAO.checkLoginByEmail(email)==-1){//If register using google and email is not registered 
                        loginDAO.addLoginByEmailInfo(username, salt, hashedPassword);
                    } else{//If already registered, login
                        request.setAttribute("username", username);
                        request.setAttribute("password", password);
                        request.setAttribute("email", email);
                        request.setAttribute("google-login", true);
                        request.setAttribute("remember", false);
                        request.getRequestDispatcher("login-control").forward(request, response);
                    }
                    int loginID = 0;
                    loginID = loginDAO.getLastID();
                    
                    UserDAO userDAO = new UserDAO();
                    //Add user info for new account, accounts registered this way will be default normal user
                    userDAO.addUser(loginID + "", "2", firstName, lastName, phone, email);
                    loginDAO.updateUserID(loginID, loginID);//Update user ID
                    
                    request.setAttribute("userID", loginID);//Set request parameter for forwarding

                    //Insert default health and goal record for insurance
                    healthDAO.insertHealthInfo(loginID + "", 0 + "", 0 + "", 0 + "", 0 + "", 0 + "");
                    goalDAO.addGoal(loginID + "", 0 + "");
                    if (googleRegister){
                        request.setAttribute("username", username);
                        request.setAttribute("password", password);
                        request.getRequestDispatcher("google-register")
                            .forward(request, response);
                        return;
                    }
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
