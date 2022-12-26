package DAO;

import Entity.User;
import context.DBContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Semester: FALL 2022 Subject : FRJ301 Class : SE1606 Project : Nutrition
 *
 * @author : Group 4 CE161130 Nguyen Le Quang Thinh (Leader) CE170036 Pham Nhat
 * Quang CE160464 Nguyen The Lu CE161096 Nguyen Ngoc My Quyen CE161025 Tran Thi
 * Ngoc Hieu
 */
public class UserDAO extends DAO {

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
        } finally {
            closeConnections();
        }
        return list;
    }

    /**
     * Get list admin
     *
     * @return List [user]
     */
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
        } finally {
            closeConnections();
        }
        return list;
    }

    /**
     * Add a user in the database
     *
     * @param USERID User ID
     * @param USERROLEID User role ID
     * @param FIRSTNAME First name of user
     * @param LASTNAME Last name of user
     * @param PHONE Phone of user
     * @param EMAIL Email of user
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
        closeConnections();

    }

    /**
     * Delete of user
     *
     * @param id user id
     */
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
        } finally {
            closeConnections();
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
                int res = rs.getInt(1);
                closeConnections();
                return res;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            closeConnections();
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
                User res = new User(
                        rs.getInt("USERID"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getString("EMAILADDRESS"),
                        rs.getString("PHONENUMBER")
                );
                closeConnections();
                return res;
            }
        } catch (Exception e) {
        } finally {
            closeConnections();
        }
        return null;
    }

    /**
     * Get user by name
     *
     * @param username user name
     * @return List [user]
     */
    public List<User> getUserByName(String username) {
        List<User> list = new ArrayList<>();
        String query = "Select * from [USER] where (FIRSTNAME LIKE ? OR LASTNAME LIKE ?) AND USERROLEID = 2";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl

            ps.setString(1, "%" + username + "%");
            ps.setString(2, "%" + username + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(user);
            }
        } catch (Exception e) {
        } finally {
            closeConnections();
        }

        return list;
    }

    /**
     * Get admin by name
     *
     * @param username user name
     * @return List [user]
     */
    public List<User> getAdminByName(String username) {
        List<User> list = new ArrayList<>();
        String query = "Select * from [USER] where (FIRSTNAME LIKE ? OR LASTNAME LIKE ?) AND USERROLEID = 1";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl

            ps.setString(1, "%" + username + "%");
            ps.setString(2, "%" + username + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(user);
            }
        } catch (Exception e) {
        } finally {
            closeConnections();
        }

        return list;
    }

    /**
     * Get role by user ID
     *
     * @param id User ID
     * @return object User
     * @throws SQLException Exception of SQL
     */
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
        closeConnections();
        return null;
    }

    /**
     * Get role id by user id
     *
     * @param id user id
     * @return int user role id
     * @throws SQLException Exception of SQL
     */
    public int getRoleIDByUserID(int id) throws SQLException {
        String query = "select USERROLEID from dbo.[User]\n"
                + "where USERID = ?";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl

        ps.setString(1, id + "");
        rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt("USERROLEID");
        }
        closeConnections();
        return 0;
    }

    /**
     * Edit user info in USER table
     *
     * @param USERID User ID
     * @param FIRSTNAME First name of user
     * @param LASTNAME Last name of user
     * @param PHONE Phone of user
     * @param EMAIL Email of user
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
        } finally {
            closeConnections();
        }
    }

}
