package DAO;

import Entity.Meal;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author M S I
 */
public class MealDAO {

    /**
     * Connection to database
     */
    Connection con = null;

    /**
     * Move query from Netbeans to SQl
     */
    PreparedStatement ps = null;

    /**
     * Save query result
     */
    ResultSet rs = null; 

    /**
     *
     */
    String query;

    /**
     *
     */
    String datetimePattern = "yyyy-MM-dd HH:mm:ss";

    /**
     *
     */
    SimpleDateFormat dateFormatter;

    /**
     *
     * @param dateFormat
     */
    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormatter = dateFormat;
    }

    /**
     *
     * @param mealName
     * @param dateTime
     * @param userID
     * @param calories
     * @param protein
     * @param fat
     * @param carbs
     * @throws java.sql.SQLException
     */
    public void insertMeal(String mealName, Date dateTime, int userID, double calories, double protein, double fat, double carbs)
            throws SQLException {
        query = "insert into dbo.MEAL values(?,?,?,?,?,?,?)";
        this.dateFormatter = new SimpleDateFormat(datetimePattern);
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, mealName);
        ps.setString(2, dateFormatter.format(dateTime));
        ps.setString(3, userID + "");
        ps.setString(4, calories + "");
        ps.setString(5, protein + "");
        ps.setString(6, fat + "");
        ps.setString(7, carbs + "");
        ps.executeUpdate();
    }
        /**
     *
     * @param mealName
     * @param dateTime
     * @param userID
     * @param calories
     * @param protein
     * @param fat
     * @param carbs
     * @throws java.sql.SQLException
     */
    public void insertMeal(String mealName, String dateTime, String userID, String calories, String protein, String fat, String carbs)
            throws SQLException {
        query = "insert into dbo.MEAL values(?,?,?,?,?,?,?)";
        this.dateFormatter = new SimpleDateFormat(datetimePattern);
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, mealName);
        ps.setString(2, dateTime);
        ps.setString(3, userID);
        ps.setString(4, calories);
        ps.setString(5, protein);
        ps.setString(6, fat);
        ps.setString(7, carbs);
        
        ps.executeUpdate();
    }

    /**
     *
     * @param userID
     * @return
     */
    public List<Meal> getMealsByUserID(String userID) {
        try {
            query = "select * from dbo.MEAL where USERID = ?";
            List<Meal> res = new ArrayList<>();
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, userID);

            rs = ps.executeQuery();

            while (rs.next()) {
                MealItemDAO miDAO = new MealItemDAO();
                Meal meal = new Meal(rs.getString("MEALNAME"), rs.getTimestamp("MEALDATETIME"), rs.getInt("USERID"),
                        rs.getDouble("CALORIE"), rs.getDouble("PROTEIN"), rs.getDouble("FAT"), rs.getDouble("CARB"),
                        miDAO.getMealItems(rs.getString("MEALNAME"), rs.getString("MEALDATETIME"), rs.getString("USERID")));

                res.add(meal);
            }

            return res;
        } catch (SQLException ex) {
            Logger.getLogger(MealDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param date
     * @param time
     * @param name
     * @param userID
     * @throws SQLException
     */
    public void deleteMeal(String date, String time, String name, String userID) throws SQLException {
        query = "delete from MEAL\n"
                + "where USERID = ? and \n"
                + "CAST(MEALDATETIME as DATE) = ? and\n"
                + "CAST(MEALDATETIME as TIME) = ? and\n"
                + "MEALNAME = ?";
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, userID);
        ps.setString(2, date);
        ps.setString(3, time);
        ps.setString(4, name);
        ps.executeUpdate();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        MealDAO dao = new MealDAO();
        System.out.println(dao.getMealsByUserID(2 + ""));
    }
}
