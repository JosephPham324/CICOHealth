 package DAO;

import Entity.MealItem;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Pham Nhat Quang
 */
public class MealItemDAO {

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
     * @param mealName
     * @param dateTime
     * @param userID
     * @param name
     * @param calories
     * @param protein
     * @param fat
     * @param carbs
     * @param weight
     * @throws SQLException
     */
    public void insertMealItem(String mealName, Date dateTime, int userID,String name, double calories, double protein, double fat, double carbs, String weight)
            throws SQLException {
        query = "insert into dbo.MEALITEM values(?,?,?,?,?,?,?,?,?)";
        this.dateFormatter = new SimpleDateFormat(datetimePattern);

        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, mealName);
        ps.setString(2, dateFormatter.format(dateTime));
        ps.setString(3, userID+"");
        ps.setString(4, name);
        ps.setString(5, calories + "");
        ps.setString(6, protein + "");
        ps.setString(7, fat + "");
        ps.setString(8, carbs + "");
        ps.setString(9, weight);
        ps.executeUpdate();

    }

    /**
     *
     * @param mealName
     * @param dateTime
     * @param userID
     * @param name
     * @param calories
     * @param protein
     * @param fat
     * @param carbs
     * @param weight
     * @throws SQLException
     */
    public void insertMealItem(String mealName, String dateTime, String userID,String name, String calories, String protein, String fat, String carbs, String weight)
            throws SQLException {
        query = "insert into dbo.MEALITEM values(?,?,?,?,?,?,?,?,?)";
        this.dateFormatter = new SimpleDateFormat(datetimePattern);

        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, mealName);
        ps.setString(2, dateTime);
        ps.setString(3, userID+"");
        ps.setString(4, name);
        ps.setString(5, calories + "");
        ps.setString(6, protein + "");
        ps.setString(7, fat + "");
        ps.setString(8, carbs + "");
        ps.setString(9, weight);
        ps.executeUpdate();

    }
    
    /**
     *
     * @param mealName
     * @param mealDateTime
     * @param userID
     * @return
     * @throws SQLException
     */
    public List<MealItem> getMealItems(String mealName,String mealDateTime,String userID) throws SQLException{
        query = "select * from MEALITEM where mealName = ? and mealDateTime = ? and userID = ?";
        List<MealItem> res = new ArrayList<>();
        
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, mealName);
        ps.setString(2, mealDateTime);
        ps.setString(3, userID+"");
        rs = ps.executeQuery();
        while (rs.next()){
            MealItem item = new MealItem(rs.getString("MEALNAME"), rs.getTimestamp("MEALDATETIME"),
                    rs.getString("ITEMNAME"), rs.getDouble("totalWEIGHT"), rs.getDouble("CALORIE"),rs.getDouble("PROTEIN"),rs.getDouble("FAT"),rs.getDouble("CARB"));
            res.add(item);
        }
        return res;
    }
    
    /**
     *
     * @param date
     * @param time
     * @param name
     * @param userID
     * @throws SQLException
     */
    public void deleteMealItems(String date, String time, String name, String userID) throws SQLException {
        query = "delete from MEALITEM\n"
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
}
