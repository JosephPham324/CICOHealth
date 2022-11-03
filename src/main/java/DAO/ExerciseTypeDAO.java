package DAO;

import Entity.ExerciseType;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pham Nhat Quang
 */
public class ExerciseTypeDAO {


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
     * Search an exercise type
     *
     * @param name
     * @return
     * @throws SQLException
     */
    public List<ExerciseType> searchExerciseTypes(String name) throws SQLException {
        List<ExerciseType> res = new ArrayList<>();

        query = "SELECT * FROM EXERCISETYPES WHERE EXERCISENAME like '%' + ? +'%'";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl
        ps.setString(1, name);
        rs = ps.executeQuery();

        while (rs.next()) {
            res.add(new ExerciseType(rs.getInt("EXERCISEID"), rs.getString("EXERCISENAME"), rs.getDouble("CALPERHOUR"), rs.getString("DESCRIPTION")));
        }

        return res;
    }


    /**
     * Get all exercise types
     *
     * @return
     * @throws SQLException
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
     *
     * @param name
     * @return
     * @throws SQLException
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
    
    public ExerciseType getExerciseTypeByID (String id) {
        String query = "select * from EXERCISETYPES\n" +
                        "where EXERCISEID = ?";
        try {
             con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                return new ExerciseType(rs.getInt(1), rs.getString(2), rs.getFloat(3),rs.getString(4));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void updateExercise(String id, String exercisename, String calperhour,String description) {
        String query = "update EXERCISETYPES set EXERCISENAME = ?, CALPERHOUR = ?, DESCRIPTION = ?\n" +
                        "where EXERCISEID = ?";
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
    
     public void addExerciseType(String exid, String exname, String calperhour, String description) {
        String query = "insert into EXERCISETYPES values (?,?,?,?)";

        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1,exid);
            ps.setString(2,exname);
            ps.setString(3,calperhour);
            ps.setString(4,description);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ExerciseTypeDAO dao = new ExerciseTypeDAO();
        dao.updateExercise("20", "chay cham", "19", "cu chay cham");
//        try {
//            System.out.println(dao.getExerciseByName("running"));
//        } catch (SQLException ex) {
//            Logger.getLogger(ExerciseTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
