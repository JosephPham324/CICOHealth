package DAO;

import Entity.UserHealthInfo;
import context.DBContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * FPT University Can Tho Semester: FALL 2022
 * <br>Subject : FRJ301
 * <br>Class : SE1606
 * <br>Project : Nutrition
 * <br>
 * <br>
 *
 * @author : Group 4
 * @author: CE161130 Nguyen Le Quang Thinh (Leader)
 * @author: CE170036 Pham Nhat Quang
 * @author: CE160464 Nguyen The Lu <br>CE161096 Nguyen Ngoc My Quyen
 * @author: CE161025 Tran Thi Ngoc Hieu
 */
public class HealthDAO extends DAO {

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
        con = new DBContext().getConnection();
        if (new HealthDAO().findUserHealthInfo(Integer.parseInt(userID)) != null) {
            ps = con.prepareStatement(queryEdit);
            ps.setString(1, gender);
            ps.setString(2, height);
            ps.setString(3, weight);
            ps.setString(4, activeness);
            ps.setString(5, age);
            ps.setString(6, userID);

            ps.executeUpdate();
        } else {
            ps = con.prepareStatement(queryInsert);
            ps.setString(1, userID);
            ps.setString(2, gender);
            ps.setString(3, height);
            ps.setString(4, weight);
            ps.setString(5, activeness);
            ps.setString(6, age);
            ps.executeUpdate();
        }
        closeConnections();
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
//            System.out.println(info.toString());
            closeConnections();
            return info;
        }
        closeConnections();
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
        closeConnections();
        return list;
    }
}
