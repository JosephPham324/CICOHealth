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
    private String userId;
    private float calorie;
    private float protein;
    private float fat;
    private float carb;

    public DailyNutritionGoal(String userId, float calorie, float protein, float fat, float carb) {
        this.userId = userId;
        this.calorie = calorie;
        this.protein = protein;
        this.fat = fat;
        this.carb = carb;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getCalorie() {
        return calorie;
    }

    public void setCalorie(float calorie) {
        this.calorie = calorie;
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
