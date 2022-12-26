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
 * Semester: FALL 2022
 * Subject : FRJ301
 * Class   : SE1606
 * Project : Nutrition 
 * @author : Group 4
 * CE170036  Pham Nhat Quang
 */
public class MealItemDAO extends DAO{

    /**
     * Query to execute
     */
    String query;

    /**
     * DateTime pattern to store in database
     */
    String datetimePattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * To format date object into String
     */
    SimpleDateFormat dateFormatter;


    /**
     * Insert meal item into database
     *
     * @param mealName Name of meal
     * @param dateTime Date and time of that meal
     * @param userID User ID of that meal
     * @param name Name of the meal item
     * @param calories Calories of the meal item
     * @param protein Protein in grams of the meal item
     * @param fat Fat in grams of the meal item
     * @param carbs Carbs in grams of the meal item
     * @param weight Weight in grams of the meal item
     *
     * @throws SQLException When update query to database encounters error
     */
    public void insertMealItem(String mealName, Date dateTime, int userID, String name, double calories, double protein, double fat, double carbs, String weight)
            throws SQLException {
        query = "insert into dbo.MEALITEM values(?,?,?,?,?,?,?,?,?)";
        this.dateFormatter = new SimpleDateFormat(datetimePattern);

        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, mealName);
        ps.setString(2, dateFormatter.format(dateTime));
        ps.setString(3, userID + "");
        ps.setString(4, name);
        ps.setString(5, calories + "");
        ps.setString(6, protein + "");
        ps.setString(7, fat + "");
        ps.setString(8, carbs + "");
        ps.setString(9, weight);
        ps.executeUpdate();

    }

    /**
     * Insert meal item into database
     *
     * @param mealName Name of meal
     * @param dateTime Date and time of that meal
     * @param userID User ID of that meal
     * @param name Name of the meal item
     * @param calories Calories of the meal item
     * @param protein Protein in grams of the meal item
     * @param fat Fat in grams of the meal item
     * @param carbs Carbs in grams of the meal item
     * @param weight Weight in grams of the meal item
     * @throws SQLException When update query to database encounters error
     */
    public void insertMealItem(String mealName, String dateTime, String userID, String name, String calories, String protein, String fat, String carbs, String weight)
            throws SQLException {
        query = "insert into dbo.MEALITEM values(?,?,?,?,?,?,?,?,?)";
        this.dateFormatter = new SimpleDateFormat(datetimePattern);

        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, mealName);
        ps.setString(2, dateTime);
        ps.setString(3, userID + "");
        ps.setString(4, name);
        ps.setString(5, calories + "");
        ps.setString(6, protein + "");
        ps.setString(7, fat + "");
        ps.setString(8, carbs + "");
        ps.setString(9, weight);
        ps.executeUpdate();

    }


    /**
     * Get meal items related to a meal using meal name, meal date time and user
     * ID
     *
     * @param mealName Name of the meal
     * @param mealDateTime Date time of the meal, must be in format "yyyy-MM-dd
     * HH:mm:ss"
     * @param userID ID of user the meal belongs to
     * @return Meal items from a meal
     * @throws SQLException When query to database encounters error
     */
    public List<MealItem> getMealItems(String mealName, String mealDateTime, String userID) throws SQLException {
        query = "select * from MEALITEM where mealName = ? and mealDateTime = ? and userID = ?";
        List<MealItem> res = new ArrayList<>();

        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, mealName);
        ps.setString(2, mealDateTime);

        ps.setString(3, userID + "");
        rs = ps.executeQuery();
        while (rs.next()) {
            MealItem item = new MealItem(rs.getString("MEALNAME"), rs.getTimestamp("MEALDATETIME"),
                    rs.getString("ITEMNAME"), rs.getDouble("totalWEIGHT"), rs.getDouble("CALORIE"), rs.getDouble("PROTEIN"), rs.getDouble("FAT"), rs.getDouble("CARB"));
            res.add(item);
        }
        return res;
    }


    /**
     * Delete meal items related to a meal in the database
     *
     * @param date Date of the meal, must be in format "yyyy-MM-dd"
     * @param time Time of the meal, must be in format "HH:mm:ss" (hour from
     * 0-24)
     * @param name Name of the meal
     * @param userID ID of user the meal belongs to
     * @throws SQLException When update query to database encounters error
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
