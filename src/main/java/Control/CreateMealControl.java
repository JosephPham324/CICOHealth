package Control;

import DAO.MealDAO;
import DAO.MealItemDAO;
import Entity.Meal;
import Entity.MealItem;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pham Nhat Quang
 */
public class CreateMealControl extends HttpServlet {

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
            out.println("<title>Servlet CreateMealControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateMealControl at " + request.getContextPath() + "</h1>");
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
        Gson gson = new Gson();
        String mealJSON = request.getParameter("meal");
        Meal meal = gson.fromJson(mealJSON, Meal.class);
        Date now = new Date();
        MealDAO mealDAO = new MealDAO();
        Object userID = request.getSession().getAttribute("userID");
        if (userID==null){
            response.sendRedirect("MainMenu.jsp");
        }
        MealItemDAO mealItemDAO = new MealItemDAO();
        
        try {
            
            mealDAO.insertMeal(meal.getMealName(), now, Integer.parseInt(userID.toString()), meal.getTotalCal(), meal.getProteinWeight(), meal.getFatWeight(), meal.getCarbWeight());
            
            for (MealItem item: meal.getFoodItems()) {
                mealItemDAO.insertMealItem(meal.getMealName(), now, Integer.parseInt(userID.toString()),item.getName(), item.getTotalCal(),item.getProteinWeight(), item.getFatWeight(),item.getCarbWeight());
            }
            request.getSession().setAttribute("createMeal", true);
            response.sendRedirect("FoodSearch.jsp");
        } catch (Exception ex) {
            response.getWriter().write(ex.getMessage());
            response.getWriter().write(meal.getMealName());
            response.getWriter().write(userID.toString());
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
