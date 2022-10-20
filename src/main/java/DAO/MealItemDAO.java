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
 * @author Pham Nhat Quang
 */
public class MealItemDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String query;
    String datetimePattern = "yyyy-MM-dd HH:mm:ss";
    SimpleDateFormat dateFormatter;

    public void insertMealItem(String mealName, Date dateTime, int userID,String name, double calories, double protein, double fat, double carbs)
            throws SQLException {
        query = "insert into dbo.MEALITEM values(?,?,?,?,?,?,?,?)";
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
        ps.executeUpdate();

    }
}
