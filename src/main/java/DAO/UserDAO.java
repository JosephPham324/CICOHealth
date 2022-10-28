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
     * Get the full lists of users in USER table
     * @return User objects of all users in database
     */
    public List<User> getListUser() throws SQLException {
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
    }

    /**
     * Add a user in the database
     * @param USERID
     * @param USERROLEID
     * @param FIRSTNAME
     * @param LASTNAME
     * @param PHONE
     * @param EMAIL
     * @throws SQLException When update query to database encounters error
     */
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

    /**
     * Get the last ID present in USER table
     * @return ID number
     */
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

    /**
     * Get a user from database using ID
     * @param id User ID
     * @return User object
     * @throws SQLException When query to database encounters error
     */
    public User getUserByID(String id) throws SQLException {
        String query = "select * from dbo.[User]\n"
                + "where USERID = ?";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl

        ps.setString(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            return new User(
                    rs.getInt("USERID"),
                    rs.getString("FIRSTNAME"),
                    rs.getString("LASTNAME"),
                    rs.getString("EMAILADDRESS"),
                    rs.getString("PHONENUMBER")
            );
        }
        return null;
    }

    /**
     * Edit user info in USER table
     *
     * @param USERID
     * @param FIRSTNAME
     * @param LASTNAME
     * @param EMAIL
     * @param PHONE
     * @throws SQLException When query to update database encounters error
     */
    public void editUser(String USERID, String FIRSTNAME, String LASTNAME, String EMAIL, String PHONE) throws SQLException {
        String query = "update [USER]\n"
                + "set FIRSTNAME = ?,\n"
                + "LASTNAME = ?,\n"
                + "EMAILADDRESS = ?,\n"
                + "PHONENUMBER = ?\n"
                + "where USERID = ?";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl
        ps.setString(1, FIRSTNAME);
        ps.setString(2, LASTNAME);
        ps.setString(3, EMAIL);
        ps.setString(4, PHONE);
        ps.setString(5, USERID);
        ps.executeUpdate();
    }

//    public static void main(String[] args) {
//        UserDAO dao = new UserDAO();
//
//        dao.addUser("7", "2", "quang", "pham", "0857974230", "2222");
//    }
}
