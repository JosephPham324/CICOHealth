package DAO;

import Entity.Login;
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
     *
     * @return User objects of all users in database
     */
    public List<User> getListUser() {
        List<User> list = new ArrayList<>();
        try {
            String query = "select * from dbo.[USER] where USERROLEID = 2";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            rs = ps.executeQuery(); // the same with click to "excute" btn;

            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(user);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public List<User> getListAdmin() {
        List<User> list = new ArrayList<>();
        try {
            String query = "select * from dbo.[USER] where USERROLEID = 1";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            rs = ps.executeQuery(); // the same with click to "excute" btn;

            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(user);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    /**
     * Add a user in the database
     *
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

    public void deleteUSER(String id) {
        String query = "delete from MEALITEM where USERID = ?\n"
                + "delete from MEAL where USERID = ?\n"
                + "delete from EXERCISE where USERID = ?\n"
                + "delete from DAILYNUTRITIONGOAL where USERID = ?\n"
                + "delete from USERHEALTHINFO where USERID = ?\n"
                + "delete from [USER] where USERID = ?\n"
                + "delete from [LOGIN] where USER_ID = ?";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, id);
            ps.setString(2, id);
            ps.setString(3, id);
            ps.setString(4, id);
            ps.setString(5, id);
            ps.setString(6, id);
            ps.setString(7, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    /**
     * Get the last ID present in USER table
     *
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
     *
     * @param id User ID
     * @return User object
     */
    public User getUserByID(String id) {
        String query = "select * from dbo.[User]\n"
                + "where USERID = ?";
        try {
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
        } catch (Exception e) {
        }

        return null;
    }
    
    public List<User> getUserByName(String username) {
        List<User> list = new ArrayList<>();
        String query = "Select * from [USER] where (FIRSTNAME LIKE ? OR LASTNAME LIKE ?) AND USERROLEID = 2";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl

            ps.setString(1,"%"+username+"%");
            ps.setString(2,"%"+username+"%");
            rs = ps.executeQuery();
             while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(user);
            }
        } catch (Exception e) {
        }

        return list;
    }
    
    public List<User> getAdminByName(String username) {
        List<User> list = new ArrayList<>();
        String query = "Select * from [USER] where (FIRSTNAME LIKE ? OR LASTNAME LIKE ?) AND USERROLEID = 1";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl

            ps.setString(1,"%"+username+"%");
            ps.setString(2,"%"+username+"%");
            rs = ps.executeQuery();
             while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(user);
            }
        } catch (Exception e) {
        }

        return list;
    }


    public User getRoleByUserID(int id) throws SQLException {
        String query = "select USERROLEID from dbo.[User]\n"
                + "where USERID = ?";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl

        ps.setInt(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
            return new User(
                    rs.getInt("USERROLEID")
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
    public void editUser(String USERID, String FIRSTNAME, String LASTNAME, String EMAIL, String PHONE) {
        String query = "update [USER]\n"
                + "set FIRSTNAME = ?,\n"
                + "LASTNAME = ?,\n"
                + "EMAILADDRESS = ?,\n"
                + "PHONENUMBER = ?\n"
                + "where USERID = ?";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, FIRSTNAME);
            ps.setString(2, LASTNAME);
            ps.setString(3, EMAIL);
            ps.setString(4, PHONE);
            ps.setString(5, USERID);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) throws SQLException {
//        String username = "THINHNLQCE161130";
//        String password = "group4prj301";
//
//        LoginDAO loginDAO = new LoginDAO();
//        UserDAO userDAO = new UserDAO();
//
//        Login b = loginDAO.findUserName(username);
//        int userid = b.getUserID();
//        User u = userDAO.getRoleByUserID(userid);
//        System.out.println(u);
//        //Get an instance of Login entry if username and password is correct
//        Login a = null;
//        if (u.getUserRoleId() == 2) {
//            a = loginDAO.checkLogin(username, password);
//        } else {
//            a = loginDAO.checkAdminLogin(username, password);
//        }
//        System.out.println(a);
        String username = "Thinh";
        UserDAO user = new UserDAO();
    	List<User> list = user.getUserByName(username);
        System.out.println(list);
    }
}
