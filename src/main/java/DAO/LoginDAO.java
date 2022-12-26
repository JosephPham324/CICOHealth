package DAO;

import context.DBContext;
import Entity.Login;
import Security.Encryption;
import Security.RegLoginLogic;
import java.sql.SQLException;

/**
 * Semester: FALL 2022 Subject : FRJ301 Class : SE1606 Project : Nutrition
 *
 * @author : Group 4 CE161130 Nguyen Le Quang Thinh (Leader) CE170036 Pham Nhat
 * Quang CE160464 Nguyen The Lu CE161096 Nguyen Ngoc My Quyen CE161025 Tran Thi
 * Ngoc Hieu
 */
public class LoginDAO extends DAO {

    /**
     * Add a record into database Login table
     *
     * @param username Username
     * @param salt Password salt
     * @param hashedPassword Password hash
     * @throws SQLException When update query encounters error
     */
    public void addLoginInfo(String username, String salt, String hashedPassword) throws SQLException {
        String query = "insert into login values(?,?,?,null,0)";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl

        ps.setString(1, username);
        ps.setString(2, salt);
        ps.setString(3, hashedPassword);

        ps.executeUpdate(); // the same with click to "excute" btn;
        closeConnections();
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
        closeConnections();

    }

    /**
     * Get the last LoginID in the Login table
     *
     * @return @throws SQLException When query encounters error
     */
    public int getLastID() throws SQLException {
        String query = "SELECT TOP 1 * FROM dbo.LOGIN ORDER BY LOGINID DESC";
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        while (rs.next()) {
            int res = rs.getInt(1);
            return res;
        }
        closeConnections();
        return -1;
    }

    /**
     * Check if a username already exists in the database
     *
     * @param username Username to check
     * @return The number of that username in the database
     * @throws SQLException Exception of SQL
     */
    public int checkUserNameDuplicate(String username) throws SQLException {
        String query = "SELECT COUNT(*) FROM [LOGIN] where username=?";
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);

        ps.setString(1, username);
        rs = ps.executeQuery();
        while (rs.next()) {
            int res = rs.getInt(1);
            closeConnections();
            return res;
        }
        closeConnections();
        return 0;
    }

    /**
     * Get login record from username
     *
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
                closeConnections();
                return info;
            }
        } catch (Exception e) {
            System.err.println(e.getCause());
        } finally {
            closeConnections();
        }
        return null;
    }

    /**
     * Check if user login info is correct
     *
     * @param username Username to check
     * @param enteredPassword Password to check
     * @return Login object if login info is correct
     */
    public Login checkLogin(String username, String enteredPassword) {
        try {
            String query = "Select  [LOGIN].LOGINID,[LOGIN].USERNAME,[LOGIN].PASSWORDSALT,[LOGIN].PASSWORDHASH,[LOGIN].USER_ID from [LOGIN]\n"
                    + "INNER JOIN [USER] ON [USER].USERID = [LOGIN].USER_ID\n"
                    + "where [USER].USERROLEID = 2 AND [LOGIN].USERNAME = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            System.out.println(ps.toString());
            while (rs.next()) {
                Login a = new Login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                String salt = a.getPasswordSalt();
                String hash = a.getPasswordHash();

                if (Security.RegLoginLogic.verifyPassword(enteredPassword, salt, hash)) {
                    closeConnections();
                    return a;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnections();
        }
        return null;
    }

    /**
     * Check if admin login info is correct
     *
     * @param username Username to check
     * @param enteredPassword Password to check
     * @return Login object if login info is correct
     */
    public Login checkAdminLogin(String username, String enteredPassword) {
        try {
            String query = "Select [LOGIN].LOGINID,[LOGIN].USERNAME,[LOGIN].PASSWORDSALT,[LOGIN].PASSWORDHASH,[LOGIN].USER_ID from [LOGIN]\n"
                    + "INNER JOIN [USER] ON [USER].USERID = [LOGIN].USER_ID\n"
                    + "where [USER].USERROLEID = 1 AND [LOGIN].USERNAME = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                Login userLogin = new Login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                String salt = userLogin.getPasswordSalt();
                String hash = userLogin.getPasswordHash();

                if (Security.RegLoginLogic.verifyPassword(enteredPassword, salt, hash)) {
                    closeConnections();
                    return userLogin;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnections();
        }
        return null;
    }

    /**
     * Get login info from user ID
     *
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
        closeConnections();
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
        closeConnections();

    }

    public int checkLoginByEmail(String email) throws SQLException {
        String query = "SELECT USERID as userid FROM [USER] \n"
                + "WHERE EMAILADDRESS = ?\n"
                + "AND (SELECT GOOGLELOGIN FROM LOGIN WHERE USER_ID = userid) = 1";
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, email);
        rs = ps.executeQuery();

        if (rs.next()) {
            int res = rs.getInt("userid");
            closeConnections();
            return res;
        }
        closeConnections();
        return -1;
    }

    public Entity.Login getLoginRecordFromUserID(String userID) throws SQLException {
        String query = "SELECT * FROM LOGIN WHERE USER_ID = ? AND GOOGLELOGIN = 1";
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, userID);
        rs = ps.executeQuery();
        if (rs.next()) {
            Entity.Login record = new Entity.Login(rs.getInt("LOGINID"), rs.getString("USERNAME"), rs.getString("PASSWORDSALT"), rs.getString("PASSWORDHASH"), rs.getInt("USER_ID"));
            closeConnections();
            return record;
        }
        closeConnections();
        return null;
    }

    /**
     * Add a record into database Login table
     *
     * @param username Username
     * @param salt Password salt
     * @param hashedPassword Password hash
     * @throws SQLException When update query encounters error
     */
    public void addLoginByEmailInfo(String username, String salt, String hashedPassword) throws SQLException {
        String query = "insert into LOGIN values(?,?,?,null,1)";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl

        ps.setString(1, username);
        ps.setString(2, salt);
        ps.setString(3, hashedPassword);
        ps.executeUpdate(); // the same with click to "excute" btn;
        closeConnections();
    }
}
