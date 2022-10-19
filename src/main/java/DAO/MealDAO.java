package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author M S I
 */
public class MealDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String query;
    String datetimePattern = "yyyy-MM-dd hh:mm:ss";
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
    
    public void deleteMeal(){
        
    }
}
