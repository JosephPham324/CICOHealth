/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import Entity.Login;
import Entity.User;
import Entity.UserHealthInfo;
import jakarta.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thinh
 */
public class LoginDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<User> getListMember() {
        try {
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
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public List<UserHealthInfo> getListMemberInfo() {
        try {
            String query = "select * from [Nutrition].[dbo].[MemberInfo]";
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            rs = ps.executeQuery(); // the same with click to "excute" btn;
            List<UserHealthInfo> list = new ArrayList<>();
            while (rs.next()) {
                UserHealthInfo acc = new UserHealthInfo(rs.getInt(1), rs.getString(2), rs.getFloat(3),
                         rs.getFloat(4), rs.getFloat(5), rs.getInt(6));
                list.add(acc);
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public void deleteAcc(String id) {
        String query = "delete from [Nutrition].[dbo].[Member] where member_id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void insertAcc(String loginID, String userID, String username, String passwordSalt, String passwordHash) {
        String query = "insert into [Nutrition].[dbo].[LOGIN] values(?,?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            passwordHash = MD5Encryption(passwordSalt);
            ps.setString(1, loginID);
            ps.setString(2, userID);
            ps.setString(3, username);
            ps.setString(4, passwordSalt);
            ps.setString(5, passwordHash);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public String MD5Encryption(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //the update() function is used to get the input string that needs to be encoded
            md.update(password.getBytes());
            //use digest() to generate hash for the string to be encrypted
            return DatatypeConverter.printHexBinary(md.digest()).toLowerCase();
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
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

                if (Security.LoginLogic.verifyPassword(enteredPassword, salt, hash));
                return a;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

//     public User getMemberByID (String id) {
//        String query = "select * from Member\n" +
//"where member_id = ?";
//        try {
//             con = new DBContext().getConnection(); // open connection to SQL
//            ps = con.prepareStatement(query); // move query from Netbeen to SQl
//            ps.setString(1, id);
//            rs = ps.executeQuery();
//            while(rs.next()) {
//                return new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
//            }
//        } catch (Exception e) {
//        }
//        return null;
//    }
//     
    public void insertUserInfo(String userID, String loginID, String userRoleId, String firstName, String lastName, String email, String phone) {
        String query = "insert into [Nutrition].[dbo].[USER] values(?,?,?,?,?,?,?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, userID);
            ps.setString(2, loginID);
            ps.setString(3, userRoleId);
            ps.setString(4, firstName);
            ps.setString(5, lastName);
            ps.setString(6, email);
            ps.setString(7, phone);
            ps.executeUpdate();
        } catch (Exception e) {
        }
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

    public static void main(String[] args) {
        LoginDAO dao = new LoginDAO();
        List<User> users = dao.getListMember();
        System.out.println(dao.checkLogin("QuangPNCE170036", "group4prj301"));
    }

}
