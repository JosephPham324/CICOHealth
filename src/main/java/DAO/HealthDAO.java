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

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query

    public void insertHealthInfo(String userID, String gender, String height, String weight, String activeness, String age) throws SQLException {
        String queryInsert = "insert into [Nutrition].[dbo].[USERHEALTHINFO] values(?,?,?,?,?,?)";
        String queryEdit = "update USERHEALTHINFO\n"
                + "SET GENDER = ?,\n"
                + "HEIGHT = ?,\n"
                + "WEIGHT = ?,\n"
                + "ACTIVENESS = ?,\n"
                + "AGE = ?\n"
                + "WHERE USERID = ?";

        if (new HealthDAO().findUserID(Integer.parseInt(userID)) != null) {
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

    public UserHealthInfo findUserID(int ID) {
        String query = "select * from USERHEALTHINFO where USERID = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, ID + "");
            rs = ps.executeQuery();
            if (rs.next()) {
                UserHealthInfo info = new UserHealthInfo(ID, rs.getString("GENDER"), rs.getFloat("HEIGHT"),
                        rs.getFloat("Weight"), (float) rs.getInt("ACTIVENESS"), rs.getInt("AGE"));
                System.out.println(info.toString());
                return info;
            }
        } catch (Exception e) {
            System.err.println(e.getCause());
        }
        return null;
    }

    public List<UserHealthInfo> getAllUserHealthInfo() throws SQLException {
        String query = "select * from [Nutrition].[dbo].[USERHEALTHINFO]";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl
        rs = ps.executeQuery(); // the same with click to "excute" btn;
        List<UserHealthInfo> list = new ArrayList<>();
        while (rs.next()) {
            UserHealthInfo acc = new UserHealthInfo(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                    rs.getFloat(4), rs.getFloat(5), rs.getInt(6));
            list.add(acc);
        }
        return list;
    }
}
