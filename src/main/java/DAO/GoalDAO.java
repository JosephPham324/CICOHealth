/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.DailyNutritionGoal;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class GoalDAO {

    Connection con = null; // connect to SQL server
    PreparedStatement ps = null; // move query from Netbeen to SQl
    ResultSet rs = null; // save result query

    public void addGoal(String userId, String calorie) {
        //Công thức macro: 
        //Cứ 4 calo = 01g Protein
        //Cứ 9 calo = 01g Fat
        //Cứ 4 calo = 01g Carb
        //=> 
        //Công thức 
        //Protein cần nạp: (Daily calorie x ?%)/4
        //Fat cần nạp: (Daily calorie x ?%)/9
        //Carb cần nạp: (Daily calorie x ?%)/4

        double c = Double.parseDouble(calorie);  

        double protein = 0.3 * c / 4; //Mac dinh 30% protein
        double fat = 0.3 * c / 9; //Mac dinh 30% fat
        double carb = 0.4 * c / 4; //Mac dinh 40% carb


        String queryInsert = "insert into DAILYNUTRITIONGOAL values(?,?,?,?,?)";
        String queryEdit = "update DAILYNUTRITIONGOAL set CALORIE = ?,\n"
                + "							 PROTEIN = ?,\n"
                + "							 FAT = ?,\n"
                + "							 CARB = ?\n"
                + "							 where USERID = ?";
        try {
            if (new GoalDAO().getGoalbyID(Integer.parseInt(userId)) != null) {
                con = new DBContext().getConnection(); // open connection to SQL
                ps = con.prepareStatement(queryEdit); // move query from Netbeen to SQl
                ps.setString(1, calorie);
                ps.setString(2, protein+"");
                ps.setString(3, fat+"");
                ps.setString(4, carb+"");
                ps.setString(5, userId);
                ps.executeUpdate(); // the same with click to "excute" btn;
            } else {

                con = new DBContext().getConnection(); // open connection to SQL
                ps = con.prepareStatement(queryInsert); // move query from Netbeen to SQl
                ps.setString(1, userId);
                ps.setString(2, calorie);
                ps.setString(3, protein+"");
                ps.setString(4, fat+"");
                ps.setString(5, carb+"");
                ps.executeUpdate(); // the same with click to "excute" btn;
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public double calculateTDEE(String weight, String height, String age, String gender, String activity) {
        int av = Integer.parseInt(activity);
        double r = 0;
        double calories = 0;
        double[] activenessMap = {1.2,1.375,1.55,1.725};
        r = activenessMap[av];
        float w = Float.parseFloat(weight);
        float h = Float.parseFloat(height);
        int ag = Integer.parseInt(age);
        if (gender.equalsIgnoreCase("Male")) {
            calories = ((13.397 * w) + (4.799 * h) - (5.677 * ag) + 88.362) * r;
        }
        if (gender.equalsIgnoreCase("Female")) {
            calories = ((9.247 * w) + (3.098 * h) - (4.330 * ag) + 447.593) * r;
        }
        return calories;
    }

    public DailyNutritionGoal getGoalbyID(int id) {
        String query = "select * from DAILYNUTRITIONGOAL\n"
                + "where USERID = ?";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, id + "");
            rs = ps.executeQuery();
            if (rs.next()) {
                DailyNutritionGoal info = new DailyNutritionGoal(id, rs.getFloat("CALORIE"), rs.getFloat("PROTEIN"),
                        rs.getFloat("FAT"), rs.getFloat("CARB"));
                System.out.println(info.toString());
                return info;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        GoalDAO g = new GoalDAO();
        DailyNutritionGoal info = g.getGoalbyID(1);
        System.out.println(info);
    }
}
