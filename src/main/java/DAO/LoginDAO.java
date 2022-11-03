package DAO;

import context.DBContext;
import Entity.Login;
import Entity.User;
import Entity.UserHealthInfo;
import Security.Encryption;
import Security.RegLoginLogic;
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
 * @author Thinh
 */
public class LoginDAO {

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
     * Add a record into database Login table
     *
     * @param username Username
     * @param salt Password salt
     * @param hashedPassword Password hash
     * @throws SQLException When update query encounters error
     */
    public void addLoginInfo(String username, String salt, String hashedPassword) throws SQLException {
        String query = "insert into login values(?,?,?,null)";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl

        ps.setString(1, username);
        ps.setString(2, salt);
        ps.setString(3, hashedPassword);

        ps.executeUpdate(); // the same with click to "excute" btn;
    }

    /**
     * Update the user id for a login record
     *
     * @param loginID Login ID to identify record in login table
     * @param userID The user ID
     * @throws SQLException When update query encounters error
     */
    public void updateUserID(int loginID, int userID) throws SQLException {
        String query = "UPDATE dbo.LOGIN SET USER_ID = ? where LOGINID = ?";
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, userID + "");
        ps.setString(2, loginID + "");
        ps.executeUpdate();
    }

    /**
     * Get the last LoginID in the Login table
     * @return @throws SQLException When query encounters error
     */
    public int getLastID() throws SQLException {
        String query = "SELECT TOP 1 * FROM dbo.LOGIN ORDER BY LOGINID DESC";
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    /**
     * Check if a username already exists in the database
     * @param username Username to check
     * @return The number of that username in the database
     * @throws SQLException
     */
    public int checkUserNameDuplicate(String username) throws SQLException {
        String query = "SELECT COUNT(*) FROM [LOGIN] where username=?";
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);

        ps.setString(1, username);
        rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }


    /**
     * Get login record from username
     * @param username Username to query
     * @return A Login object
     */
    public Login findUserName(String username) {
        String query = "select * from LOGIN where USERNAME = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                Login info = new Login(rs.getInt("LOGINID"), rs.getString("USERNAME"), rs.getString("PASSWORDSALT"),
                        rs.getString("PASSWORDHASH"), rs.getInt("USER_ID"));
                System.out.println(info.toString());
                return info;
            }
        } catch (Exception e) {
            System.err.println(e.getCause());
        }
        return null;
    }

//    /**
//     * 
//     * @return @throws SQLException
//     */
//    public List<User> getListMember() throws SQLException {
//        String query = "select * from [Nutrition].[dbo].[USER]";
//        con = new DBContext().getConnection(); // open connection to SQL
//        ps = con.prepareStatement(query); // move query from Netbeen to SQl
//        rs = ps.executeQuery(); // the same with click to "excute" btn;
//        List<User> list = new ArrayList<>();
//        while (rs.next()) {
//            User acc = new User(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
//                    rs.getString(5), rs.getString(6), rs.getString(7));
//            list.add(acc);
//        }
//        return list;
//    }

    /**
     * Check if login info is correct
     * @param username Username to check
     * @param enteredPassword Password to check
     * @return Login object if login info is correct
     */
    public Login checkLogin(String username, String enteredPassword) {
        try {
            String query = "select * from [Nutrition].[dbo].[LOGIN] where [USERNAME] = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            System.out.println(ps.toString());
            while (rs.next()) {
                Login a = new Login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                String salt = a.getPasswordSalt();
                String hash = a.getPasswordHash();
                System.out.println(salt);
                System.out.println(hash);


                if (Security.RegLoginLogic.verifyPassword(enteredPassword, salt, hash)) {
                    return a;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    

    /**
     * Get login info from user ID
     * @param userID User ID
     * @return Login object of the user
     * @throws SQLException When query to database encounter error
     */
    public Login getLoginInfo(String userID) throws SQLException {
        String query = "select * from LOGIN where USER_ID = ?";
        Login res = null;
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, userID);
        rs = ps.executeQuery();
        while (rs.next()) {
            res = new Login(
                    rs.getInt("LOGINID"),
                    rs.getString("USERNAME"),
                    rs.getString("PASSWORDSALT"),
                    rs.getString("PASSWORDHASH"),
                    rs.getInt("USER_ID")
            );
        }
        return res;
    }

    /**
     * Edit login info in database (change username, password salt and password
     * hash)
     * 
     * @param userID User ID to change
     * @param username New username
     * @param password New password to generate salt and hash
     * @throws Exception When update query encounters error
     */
    public void editLoginInfo(String userID, String username, String password) throws Exception {
        String empString = "";
        String salt = Encryption.generateSalt(username, password);
        String hashedPassword = RegLoginLogic.encryptPassword(salt, password);

        if (hashedPassword.equals(empString) || salt.equals("Unable to generate salt")) {
            salt = null;
            hashedPassword = null;
        }

        String query = "update LOGIN\n"
                + "set USERNAME = ?,\n"
                + "PASSWORDSALT = ?,\n"
                + "PASSWORDHASH = ?\n"
                + "where USER_ID = ?";
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, salt);
        ps.setString(3, hashedPassword);
        ps.setString(4, userID);
        ps.executeUpdate();
    }

    /**
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        LoginDAO dao = new LoginDAO();
            try {
//                        List<User> users = dao.getListMember();
                dao.editLoginInfo(2+"", "QuangPNCE170036", "prj301");
            } catch (Exception ex) {
                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

//        System.out.println(dao.checkLogin("QuangPNCE73768665", "prj301"));
//        int test = dao.checkUserNameDuplicate("nlordqting4444");
//        System.out.println(test);
    }
}
