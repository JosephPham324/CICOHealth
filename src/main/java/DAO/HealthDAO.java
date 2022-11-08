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
     * Insert health info of a user into database
     *
     * @param userID ID of user
     * @param gender Gender of user (male or female)
     * @param height Height of user (centimeters)
     * @param weight Weight of user (kilograms)
     * @param activeness Activeness of user (0-3)
     * @param age Age of user
     * @throws SQLException When update query encounters error
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
     * Get health info of a user using ID
     *
     * @param ID User ID
     * @return UserHealthInfo object
     * @throws SQLException When query encounters error
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
     * Get health info records of all users
     *
     * @return List of UserHealthInfo 
     * @throws SQLException When query encounters error
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
