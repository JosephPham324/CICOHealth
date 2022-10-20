/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ASUS
 */
public class DailyNutritionGoal {
    private int userID;
    private float calories;
    private float protein;
    private float fat;
    private float carb;
    
    public DailyNutritionGoal(int userID) {
        this.userID = userID;
    }

    public DailyNutritionGoal(int userID, float calories, float protein, float fat, float carb) {
        this.userID = userID;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carb = carb;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public float getCalories() {
        return calories;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getCarb() {
        return carb;
    }

    public void setCarb(float carb) {
        this.carb = carb;
    }
    
    
}
