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

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void addLoginInfo(String username, String salt, String hashedPassword) throws SQLException {
        String query = "insert into login values(?,?,?,null)";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl

        ps.setString(1, username);
        ps.setString(2, salt);
        ps.setString(3, hashedPassword);

        ps.executeUpdate(); // the same with click to "excute" btn;
    }

    public void updateUserID(int loginID, int userID) throws SQLException {
        String query = "UPDATE dbo.LOGIN SET USER_ID = ? where LOGINID = ?";
        con = new DBContext().getConnection();
        ps = con.prepareStatement(query);
        ps.setString(1, userID + "");
        ps.setString(2, loginID + "");
        ps.executeUpdate();
    }

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

    public List<User> getListMember() throws SQLException {
        String query = "select * from [Nutrition].[dbo].[USER]";
        con = new DBContext().getConnection(); // open connection to SQL
        ps = con.prepareStatement(query); // move query from Netbeen to SQl
        rs = ps.executeQuery(); // the same with click to "excute" btn;
        List<User> list = new ArrayList<>();
        while (rs.next()) {
            User acc = new User(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7));
            list.add(acc);
        }
        return list;
    }

    public Login checkLogin(String user, String enteredPassword) {
        try {
            String query = "select * from [Nutrition].[dbo].[LOGIN] where [USERNAME] = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            System.out.println(ps.toString());
            while (rs.next()) {
                Login a = new Login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                String salt = a.getPasswordSalt();
                String hash = a.getPasswordHash();
                System.out.println(salt);
                System.out.println(hash);

                if (Security.RegLoginLogic.verifyPassword(enteredPassword, salt, hash))
                return a;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertHealthInfo(String userId, String gender, String height, String weight, String activeness, String age) {
        String query = "insert into [Nutrition].[dbo].[USERHEALTHINFO] values(?,?,?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, userId);
            ps.setString(2, gender);
            ps.setString(3, height);
            ps.setString(4, weight);
            ps.setString(5, activeness);
            ps.setString(6, age);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

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

    public static void main(String[] args) throws SQLException {
        LoginDAO dao = new LoginDAO();
//            try {
//                //        List<User> users = dao.getListMember();
//                dao.editLoginInfo(2+"", "QuangPNCE170036", "prj301");
//            } catch (Exception ex) {
//                Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
        System.out.println(dao.checkLogin("quangthinh130102", "123")); 
        int test = dao.checkUserNameDuplicate("nlordqting4444");
        System.out.println(test);
    }
}
