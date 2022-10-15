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
    
    public void addGoal(String userId,String calorie){
        //Công thức macro: 
    //Cứ 4 calo = 01g Protein
    //Cứ 9 calo = 01g Fat
    //Cứ 4 calo = 01g Carb
    //=> 
    //Công thức 
    //Protein cần nạp: (Calories remain x ?%)/4
    //Fat cần nạp: (Calories remain x ?%)/9
    //Carb cần nạp: (Calories remain x ?%)/4

        float c = Float.parseFloat(calorie); 
//        float protein =(c*20/100)/4; //20% protein
//        float fat =(c*30/100)/9; //30% fat
//        float carb =(c*50/100)/4; // 50 carb
//        
//        String p  =Float.toString(protein);  
//        String f  =Float.toString(fat);  
//        String cb =Float.toString(carb);  

        float protein = 20; //Mac dinh 20% protein
        float fat = 30; //Mac dinh 30% fat
        float carb = 50; //Mac dinh 50% carb
        
        String p  =Float.toString(protein);  
        String f  =Float.toString(fat);  
        String cb =Float.toString(carb);  

        
        String query = "insert into DAILYNUTRITIONGOAL values(?,?,?,?,?)";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl

            ps.setString(1, userId);
            ps.setString(2, calorie);
            ps.setString(3, p);
            ps.setString(4, f);
            ps.setString(5, cb);
            
            ps.executeUpdate(); // the same with click to "excute" btn;
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public double calculateCalo(String weight,String height,String age,String gender,String activity) {
        int av = Integer.parseInt(activity);
        float r = 0;
        double calories = 0;
        if (av == 1) r = (float) 1.2; //not active
        if (av == 2) r = (float) 1.375; //active
        if (av == 3) r = (float) 1.55; //lightly active
        if (av == 4) r = (float) 1.725; //very active
        float w = Float.parseFloat(weight);
        float h = Float.parseFloat(height);
        int ag  = Integer.parseInt(age);
        if(gender.equalsIgnoreCase("Male")) {
             calories =((13.397*w) + (4.799*h) - (5.677*ag) + 88.362)*r;
        }
         if(gender.equalsIgnoreCase("Female")) {
             calories =((9.247*w) + (3.098*h) - (4.330*ag) + 447.593)*r;
        }
        return calories;
    }
    
    public DailyNutritionGoal getGoalbyID(int id) {
        String query = "select * from DAILYNUTRITIONGOAL\n"
                    + "where USERID = ?";
        try {
            con = new DBContext().getConnection(); // open connection to SQL
            ps = con.prepareStatement(query); // move query from Netbeen to SQl
            ps.setString(1, id+"");
            rs = ps.executeQuery();
            if (rs.next()) {
                DailyNutritionGoal info = new DailyNutritionGoal(id, rs.getFloat("CALORIE"), rs.getFloat("PROTEIN"),
                        rs.getFloat("FAT"),rs.getFloat("CARB"));
                System.out.println(info.toString());
                return info;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        GoalDAO g = new GoalDAO();
        DailyNutritionGoal info = g.getGoalbyID(13);
        System.out.println(info);
    }
    
}
