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

        query = "SELECT * FROM EXERCISETYPES WHERE EXERCISENAME like '%?%'";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl
        ps.setString(1, name);
        rs = ps.executeQuery();
        
        while (rs.next()){
            res.add(new ExerciseType(rs.getInt("EXERCISEID"), rs.getString("EXERCISENAME"), rs.getDouble("CALPERHOUR")));
        }

        return res;
    }
}
