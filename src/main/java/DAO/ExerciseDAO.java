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
     * String query
     */
    String query;

    /**
     * Pattern time
     */
    String datetimePattern = "yyyy-MM-dd hh:mm:ss";

    /**
     * Formatted date
     */
    SimpleDateFormat dateFormatter;

    /**
     * This function to insert exercise
     *
     * @param time              time of exercise
     * @param userID            user id of exercise
     * @param exerciseType      exercise type of exercise
     * @param duration          duration of exercise
     * @param calories          calories of exercise
     * @throws SQLException     Exception of SQL
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
     * This function to get list exercise by user id
     * 
     * @param userID user id
     * @return List [Exercise]
     * @throws SQLException Exception of SQL
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

    /**
     * This function to get exercise calorie by date and user id
     * 
     * @param userID user id
     * @param date date of exercise
     * @return double calories
     * @throws SQLException Exception of SQL
     */
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
     * This function to update exercise
     * 
     * @param duration      duration of exercise
     * @param exerciseID    exercise id of exercise
     * @param userID        user id
     * @param date          date of exercise
     * @param time          time of exercise
     * @throws SQLException Exception of SQL
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
     * This function to delete exercise
     * 
     * @param userID        user id
     * @param date          date of exercise
     * @param time          time of exercise
     * @throws SQLException Exception of SQL
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

}
