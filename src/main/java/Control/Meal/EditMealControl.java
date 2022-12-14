package Control.Meal;

import DAO.MealDAO;
import DAO.MealItemDAO;
import Entity.Meal;
import Entity.MealItem;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

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
public class EditMealControl extends HttpServlet {

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
            out.println("<title>Servlet EditMealControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditMealControl at " + request.getContextPath() + "</h1>");
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
        Object userID = request.getSession().getAttribute("userID");
        if (userID == null) {//Guard clause
            response.sendRedirect("/Nutrition/home");
        }

        Gson gson = new Gson();
        String mealJSON = request.getParameter("meal");
        Meal meal = gson.fromJson(mealJSON, Meal.class);
        MealDAO mealDAO = new MealDAO();

        MealItemDAO mealItemDAO = new MealItemDAO();

        try {
            mealItemDAO.deleteMealItems(
                    meal.getMealDate(),
                    meal.getMealTime(),
                    meal.getMealName(),
                    userID.toString());

            mealDAO.deleteMeal(
                    meal.getMealDate(),
                    meal.getMealTime(),
                    meal.getMealName(),
                    userID.toString() + "");

            mealDAO.insertMeal(
                    meal.getMealName(),
                    meal.getMealDate() + " " + meal.getMealTime(),
                    userID.toString(), meal.getTotalCal() + "",
                    meal.getProteinWeight() + "",
                    meal.getFatWeight() + "",
                    meal.getCarbWeight() + "");

            for (MealItem item : meal.getFoodItems()) {
                mealItemDAO.insertMealItem(
                        meal.getMealName(),
                        meal.getMealDate() + " " + meal.getMealTime(),
                        userID.toString(), item.getName(),
                        item.getTotalCal() + "",
                        item.getProteinWeight() + "",
                        item.getFatWeight() + "",
                        item.getCarbWeight() + "",
                        item.getTotalWeight() + ""
                );

            }
            response.sendRedirect("/Nutrition/user/user-meals");
        } catch (IOException | NumberFormatException | SQLException | NullPointerException ex) {
            response.getWriter().write(ex.getMessage());
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
