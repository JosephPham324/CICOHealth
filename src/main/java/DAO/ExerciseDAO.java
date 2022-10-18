package DAO;

import Entity.ExerciseType;
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
public class ExerciseDAO {

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query
    String query;
    String datetimePattern = "yyyy-MM-dd hh:mm:ss";
    SimpleDateFormat dateFormatter;
    
    public void insertExercise(Date time, int userID, ExerciseType exerciseType,double duration, double calories) throws SQLException{
        query = "insert into EXERCISE values(?,?,?,?,?,?)";
        
        this.dateFormatter = new SimpleDateFormat(datetimePattern);
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        
        ps.setString(1, dateFormatter.format(time));
        ps.setString(2, userID+"");
        ps.setString(3, exerciseType.getExerciseID()+"");
        ps.setString(4, exerciseType.getExerciseName());
        ps.setString(5, duration+"");
        ps.setString(6, calories+"");
        
        ps.executeUpdate();
    }
}
