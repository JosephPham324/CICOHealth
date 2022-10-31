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
    String datetimePattern = "yyyy-MM-dd hh:mm:ss";

    /**
     *
     */
    SimpleDateFormat dateFormatter;

    /**
     *
     * @param time
     * @param userID
     * @param exerciseType
     * @param duration
     * @param calories
     * @throws SQLException
     */
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

    /**
     *
     * @param userID
     * @return
     * @throws SQLException
     */
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

    public double getExercisesCalorieByDate(String userID, String date) throws SQLException {
        query = "select * from EXERCISE\n"
                + "WHERE USERID = ?\n"
                + "AND CAST(DATETIME as DATE) = ?";
        
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, userID);
        ps.setString(2, date);
        
        rs  = ps.executeQuery();
        ArrayList<Exercise> queryResult = new ArrayList<>();
        double res = 0;
        while (rs.next()){
            Exercise exercise = new Exercise(
                    rs.getDate("DATETIME"),
                    rs.getInt("USERID"),
                    rs.getDouble("DURATION"),
                    rs.getDouble("CALORIE"),
                    null
            );
            queryResult.add(exercise);
        }
        for (Exercise exercise:queryResult){
            res+=exercise.getCalorie();
        }
        return res;
    }

    /**
     *
     * @param duration
     * @param exerciseID
     * @param userID
     * @param date
     * @param time
     * @throws SQLException
     */
    public void updateExercise(String duration, String exerciseID, String userID, String date, String time) throws SQLException {
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

    /**
     *
     * @param userID
     * @param date
     * @param time
     * @throws SQLException
     */
    public void deleteExercise(String userID, String date, String time) throws SQLException {
        query = "delete from EXERCISE\n"
                + "where\n"
                + "USERID = ? and\n"
                + "CAST(DATETIME as DATE) = ? and\n"
                + "CAST(DATETIME as TIME) = ?";
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, userID);
        ps.setString(2, date);
        ps.setString(3, time);

        ps.executeUpdate();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ExerciseDAO dao = new ExerciseDAO();
        ArrayList<Exercise> lol;
        try {
            System.out.println(dao.getExercisesCalorieByDate("2","2022-10-25"));
        } catch (SQLException ex) {
            Logger.getLogger(ExerciseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
