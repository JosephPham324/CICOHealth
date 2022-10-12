package DAO;

import Entity.UserHealthInfo;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class HealthDAO {

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query

    public void insertHealthInfo(String userID, String gender, String height, String weight, String activeness, String age) {
        String queryInsert = "insert into [Nutrition].[dbo].[USERHEALTHINFO] values(?,?,?,?,?,?)";
        String queryEdit = "update USERHEALTHINFO\n"
                + "SET GENDER = ?,\n"
                + "HEIGHT = ?,\n"
                + "WEIGHT = ?,\n"
                + "ACTIVENESS = ?,\n"
                + "AGE = ?\n"
                + "WHERE USERID = ?";
        try {

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
        } catch (Exception e) {
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
}
