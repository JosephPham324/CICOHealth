package DAO;

import Entity.ExerciseType;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class ExerciseTypeDAO extends DAO{

    /**
     * String query
     */
    String query;

    /**
     * Search an exercise type
     *
     * @param name name of exercise
     * @return List [ExerciseType]
     */
    public List<ExerciseType> searchExerciseTypes(String name) {
        List<ExerciseType> res = new ArrayList<>();
        try {
            query = "SELECT * FROM EXERCISETYPES WHERE EXERCISENAME like '%' + ? +'%'";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                res.add(new ExerciseType(rs.getInt("EXERCISEID"), rs.getString("EXERCISENAME"), rs.getDouble("CALPERHOUR"), rs.getString("DESCRIPTION")));
            }
        } catch (Exception e) {
        }

        return res;
    }

    /**
     * Get all exercise types
     *
     * @return List [ExerciseType]
     */
    public List<ExerciseType> getAllExerciseTypes() {
        List<ExerciseType> res = new ArrayList<>();
        try {
            String query = "SELECT * FROM EXERCISETYPES";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            rs = ps.executeQuery();

            while (rs.next()) {
                ExerciseType ex = new ExerciseType(rs.getInt("EXERCISEID"), rs.getString("EXERCISENAME"), rs.getDouble("CALPERHOUR"), rs.getString("DESCRIPTION"));
                res.add(ex);
            }
        } catch (Exception e) {
        }

        return res;
    }

    /**
     * Get Exercise By Name
     * 
     * @param name name of exercise
     * @return ExerciseType
     * @throws SQLException Exception of SQL
     */
    public ExerciseType getExerciseByName(String name) throws SQLException {
        query = "SELECT * FROM EXERCISETYPES where EXERCISENAME = ?";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl
        ps.setString(1, name);
        rs = ps.executeQuery();
        ExerciseType res = null;
        while (rs.next()) {
            res = new ExerciseType(rs.getInt("EXERCISEID"), rs.getString("EXERCISENAME"), rs.getDouble("CALPERHOUR"), rs.getString("DESCRIPTION"));
        }
        return res;
    }

    /**
     * Delete Exercise type
     * @param id Exercise ID
     */
    public void deleteExerciseType(String id) {
        String query = "delete from EXERCISETYPES where EXERCISEID = ?";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    /**
     * Get Exercise type by ID
     * 
     * @param id    Exercise ID
     * @return      Exercise type
     */
    public ExerciseType getExerciseTypeByID(String id) {
        String query = "select * from EXERCISETYPES\n"
                + "where EXERCISEID = ?";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new ExerciseType(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Update exercise
     * 
     * @param id            Exercise ID
     * @param exercisename  Exercise name
     * @param calperhour    Calorie per hour
     * @param description   Description of exercise
     */
    public void updateExercise(String id, String exercisename, String calperhour, String description) {
        String query = "update EXERCISETYPES set EXERCISENAME = ?, CALPERHOUR = ?, DESCRIPTION = ?\n"
                + "where EXERCISEID = ?";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, exercisename);
            ps.setString(2, calperhour);
            ps.setString(3, description);
            ps.setString(4, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    /**
     * Add exercise type
     * 
     * @param exid          Exercise ID
     * @param exname        Exercise name
     * @param calperhour    Calorie per hour
     * @param description   Description of exercise
     */
    public void addExerciseType(String exid, String exname, String calperhour, String description) {
        String query = "insert into EXERCISETYPES values (?,?,?,?)";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, exid);
            ps.setString(2, exname);
            ps.setString(3, calperhour);
            ps.setString(4, description);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
