package DAO;

import Entity.User;
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
public class UserDAO {

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query

//    private int userID;
//    private int loginID;
//    private int userRoleId;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private String phone;
    public List<User> getListUser() {
        try {
            String query = "select * from dbo.[USER]";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            rs = ps.executeQuery(); // the same with click to "excute" btn;
            List<User> list = new ArrayList<>();
            while (rs.next()) {
                User User = new User(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                list.add(User);
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public void deleteUser(String id) {
        String query = "delete from User where MASP = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addUser(String USERID, String USERROLEID, String FIRSTNAME, String LASTNAME, String PHONE, String EMAIL) throws SQLException {
        String query = "insert into dbo.[User] values(?,?,?,?,?,?)";

        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, USERID);
        ps.setString(2, USERROLEID);
        ps.setString(3, FIRSTNAME);
        ps.setString(4, LASTNAME);
        ps.setString(5, EMAIL);
        ps.setString(6, PHONE);
        ps.executeUpdate();
    }

    public int getLastID() {
        String query = "SELECT TOP 1 * FROM dbo.[USER] ORDER BY USERID DESC";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public User getUserByID(String id) {
        String query = "select * from dbo.[User]\n"
                + "where MASP = ?";

        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl

            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void editUser(String MASP, String TENSP, String DVT, String NUOCSX, String GIA) {
        String query = "update User\n"
                + "set TENSP = ?,\n"
                + "DVT = ?,\n"
                + "NUOCSX = ?,\n"
                + "GIA = ?\n"
                + "where MASP = ?";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, TENSP);
            ps.setString(2, DVT);
            ps.setString(3, NUOCSX);
            ps.setString(4, GIA);
            ps.setString(5, MASP);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

//    public static void main(String[] args) {
//        UserDAO dao = new UserDAO();
//
//        dao.addUser("7", "2", "quang", "pham", "0857974230", "2222");
//    }
}
