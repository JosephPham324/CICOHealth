package DAO;

import Entity.UserHealthInfo;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class HealthDAO {

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
     * @param userID
     * @param gender
     * @param height
     * @param weight
     * @param activeness
     * @param age
     * @throws SQLException
     */
    public void insertHealthInfo(String userID, String gender, String height, String weight, String activeness, String age) throws SQLException {
        String queryInsert = "insert into [Nutrition].[dbo].[USERHEALTHINFO] values(?,?,?,?,?,?)";
        String queryEdit = "update USERHEALTHINFO\n"
                + "SET GENDER = ?,\n"
                + "HEIGHT = ?,\n"
                + "WEIGHT = ?,\n"
                + "ACTIVENESS = ?,\n"
                + "AGE = ?\n"
                + "WHERE USERID = ?";

        if (new HealthDAO().findUserHealthInfo(Integer.parseInt(userID)) != null) {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(queryEdit);
            ps.setString(1, gender);
            ps.setString(2, height);
            ps.setString(3, weight);
            ps.setString(4, activeness);
            ps.setString(5, age);
            ps.setString(6, userID);

            ps.executeUpdate();
        } else {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(queryInsert);
            ps.setString(1, userID);
            ps.setString(2, gender);
            ps.setString(3, height);
            ps.setString(4, weight);
            ps.setString(5, activeness);
            ps.setString(6, age);
            ps.executeUpdate();
        }
    }

    /**
     *
     * @param ID
     * @return
     * @throws SQLException
     */
    public UserHealthInfo findUserHealthInfo(int ID) throws SQLException {
        String query = "select * from USERHEALTHINFO where USERID = ?";

        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, ID + "");
        rs = ps.executeQuery();
        if (rs.next()) {
            UserHealthInfo info = new UserHealthInfo(ID, rs.getString("GENDER"), rs.getFloat("HEIGHT"),
                    rs.getFloat("Weight"), rs.getInt("ACTIVENESS"), rs.getInt("AGE"));
            System.out.println(info.toString());
            return info;
        }

        return null;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<UserHealthInfo> getAllUserHealthInfo() throws SQLException {
        String query = "select * from [Nutrition].[dbo].[USERHEALTHINFO]";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl
        rs = ps.executeQuery(); // the same with click to "excute" btn;
        List<UserHealthInfo> list = new ArrayList<>();
        while (rs.next()) {
            UserHealthInfo acc = new UserHealthInfo(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                    rs.getFloat(4), rs.getInt(5), rs.getInt(6));
            list.add(acc);
        }
        return list;
    }
}
