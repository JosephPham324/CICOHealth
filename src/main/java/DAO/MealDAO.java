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

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String query;
    String datetimePattern = "yyyy-MM-dd HH:mm:ss";
    SimpleDateFormat dateFormatter;

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
    
    public List<Meal> getMealsByUserID(String userID){
        try {
            query = "select * from dbo.MEAL where USERID = ?";
            List<Meal> res = new ArrayList<>();
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, userID);
            
            rs = ps.executeQuery();
            
            while (rs.next()){
                Meal meal = new Meal(rs.getString("MEALNAME"),rs.getTimestamp("MEALDATETIME"),rs.getInt("USERID"),
                        rs.getDouble("CALORIE"), rs.getDouble("PROTEIN"), rs.getDouble("FAT"), rs.getDouble("CARB"),null);
                
                res.add(meal);
            }
            
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(MealDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void deleteMeal(){
        
    }
    
    public static void main(String[] args) {
        MealDAO dao = new MealDAO();
        System.out.println(dao.getMealsByUserID(2+""));
    }
}
