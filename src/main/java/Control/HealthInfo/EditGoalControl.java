package Control.HealthInfo;

import DAO.GoalDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Pham Nhat Quang CE170036 (FPTU CANTHO)
 */
public class EditGoalControl extends HttpServlet {

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
            out.println("<title>Servlet EditGoalControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditGoalControl at " + request.getContextPath() + "</h1>");
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
        try {
            if (request.getSession().getAttribute("userID") == null) {
                response.sendRedirect("home");
            }
            String purpose = request.getParameter("purpose");
            GoalDAO gDAO = new GoalDAO();
            String userID;
            
            switch (purpose) {
                case "edit-cal":
                    String dailyCalorie = request.getParameter("dailyCalorie");
                    String proteinPerc = request.getParameter("proteinPercentage");
                    String fatPerc = request.getParameter("fatPercentage");
                    String carbPerc = request.getParameter("carbPercentage");
                    userID = request.getSession().getAttribute("userID").toString();
                    gDAO.editCalorieGoal(userID, dailyCalorie, proteinPerc, fatPerc, carbPerc);
                    request.getSession().setAttribute("panel", "healthInfo");
                    response.sendRedirect("user-info");
                    break;
                case "edit-macro":
                    String proteinWeight = request.getParameter("proteinPercentage");
                    String fatWeight = request.getParameter("fatPercentage");
                    String carbWeight = request.getParameter("carbPercentage");
                    userID = request.getSession().getAttribute("userID").toString();
                    gDAO.editMacroGoal(userID, proteinWeight, fatWeight, carbWeight);
                    request.getSession().setAttribute("panel", "healthInfo");
                    response.sendRedirect("user-info");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditGoalControl.class.getName()).log(Level.SEVERE, null, ex);
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
