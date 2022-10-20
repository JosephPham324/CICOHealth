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

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query
    String query;

    public List<ExerciseType> searchExerciseTypes(String name) throws SQLException {
        List<ExerciseType> res = new ArrayList<>();

        query = "SELECT * FROM EXERCISETYPES WHERE EXERCISENAME like '%' + ? +'%'";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl
        ps.setString(1, name);
        rs = ps.executeQuery();

        while (rs.next()) {
            res.add(new ExerciseType(rs.getInt("EXERCISEID"), rs.getString("EXERCISENAME"), rs.getString("DESCRIPTION"), rs.getDouble("CALPERHOUR")));
        }

        return res;
    }

    public List<ExerciseType> getAllExerciseTypes() throws SQLException {
        List<ExerciseType> res = new ArrayList<>();

        query = "SELECT * FROM EXERCISETYPES";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl
        rs = ps.executeQuery();

        while (rs.next()) {
            res.add(new ExerciseType(rs.getInt("EXERCISEID"), rs.getString("EXERCISENAME"), rs.getString("DESCRIPTION"), rs.getDouble("CALPERHOUR")));
        }

        return res;
    }

    public ExerciseType getExerciseByName(String name) throws SQLException {
        query = "SELECT * FROM EXERCISETYPES where EXERCISENAME = ?";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl
        ps.setString(1,name);
        rs = ps.executeQuery();
        ExerciseType res = null;
        while (rs.next()){
            res = new ExerciseType(rs.getInt("EXERCISEID"), rs.getString("EXERCISENAME"), rs.getString("DESCRIPTION"),rs.getDouble("CALPERHOUR"));
        }
        return res;
    }

    public static void main(String[] args) {
        ExerciseTypeDAO dao = new ExerciseTypeDAO();
        try {
            System.out.println(dao.getExerciseByName("running"));
        } catch (SQLException ex) {
            Logger.getLogger(ExerciseTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
