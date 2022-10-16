package Entity;

import java.sql.Date;

/**
 *
 * @author Pham Nhat Quang
 */
public class MealItem {
    private String mealName;
    private Date mealDateTime;
    private String itemName;
    private double calories;
    private double protein;
    private double fat;
    private double carbs;

    public MealItem(String mealName, Date mealDateTime, String itemName, double calories, double protein, double fat, double carbs) {
        this.mealName = mealName;
        this.mealDateTime = mealDateTime;
        this.itemName = itemName;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public Date getMealDateTime() {
        return mealDateTime;
    }

    public void setMealDateTime(Date mealDateTime) {
        this.mealDateTime = mealDateTime;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }
    
    
}
