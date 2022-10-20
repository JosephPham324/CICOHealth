package DAO;

import Entity.Exercise;
import Entity.ExerciseType;
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
 * @author Pham Nhat Quang
 */
public class ExerciseDAO {

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query
    String query;
    String datetimePattern = "yyyy-MM-dd hh:mm:ss";
    SimpleDateFormat dateFormatter;

    public void insertExercise(Date time, int userID, ExerciseType exerciseType, double duration, double calories) throws SQLException {
        query = "insert into EXERCISE values(?,?,?,?,?,?)";

        this.dateFormatter = new SimpleDateFormat(datetimePattern);
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);

        ps.setString(1, dateFormatter.format(time));
        ps.setString(2, userID + "");
        ps.setString(3, exerciseType.getExerciseID() + "");
        ps.setString(4, exerciseType.getExerciseName());
        ps.setString(5, duration + "");
        ps.setString(6, calories + "");

        ps.executeUpdate();
    }

    public List<Exercise> getExerciseByUserID(String userID) throws SQLException {
        List<Exercise> res = new ArrayList<>();
        query = "select * from EXERCISE where USERID = ?";

        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, userID);

        rs = ps.executeQuery();

        while (rs.next()) {
            Exercise ex = new Exercise(rs.getTimestamp("DATETIME"), rs.getInt("USERID"), rs.getDouble("DURATION"),
                    rs.getDouble("CALORIE"), rs.getInt("EXERCISEID"), rs.getString("NAME"));
            res.add(ex);
        }
        return res;
    }

    public void updateExercise(String duration,String exerciseID, String userID, String date, String time) throws SQLException {
        query = "update EXERCISE\n"
                + "set duration = ?,\n"
                + "CALORIE = CAL.CALPERHOUR*(cast(? as DECIMAL(18,1))/cast(60 as DECIMAL(18,1))) \n"
                + "	FROM(SELECT CALPERHOUR as CALPERHOUR FROM EXERCISETYPES WHERE EXERCISEID = ?) AS CAL\n"
                + "where USERID = ? and \n"
                + "CAST(DATETIME as DATE) = ? and\n"
                + "CAST(DATETIME as TIME) = ?";

        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, duration);
        ps.setString(2, duration);
        ps.setString(3, exerciseID);
        ps.setString(4, userID);
        ps.setString(5, date);
        ps.setString(6, time);
        
        ps.executeUpdate();
    }

    public static void main(String[] args) {
        ExerciseDAO dao = new ExerciseDAO();
        ArrayList<Exercise> lol;
        try {
            dao.updateExercise(90.0+"", 3+"", 2 + "", "2022-10-18", "03:38:48");
        } catch (SQLException ex) {
            Logger.getLogger(ExerciseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
