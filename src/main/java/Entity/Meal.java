package Entity;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Pham Nhat Quang
 */
public class Meal {
    private String mealName;
    private Date mealDateTime;
    private int userID;
    private double calorie;
    private double fat;
    private double carb;
    private List<MealItem> mealItems;

    public Meal(String mealName, Date mealDateTime, int userID, double calorie, double fat, double carb, List<MealItem> mealItems) {
        this.mealName = mealName;
        this.mealDateTime = mealDateTime;
        this.userID = userID;
        this.calorie = calorie;
        this.fat = fat;
        this.carb = carb;
        this.mealItems = mealItems;
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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarb() {
        return carb;
    }

    public void setCarb(double carb) {
        this.carb = carb;
    }

    public List<MealItem> getMealItems() {
        return mealItems;
    }

    public void setMealItems(List<MealItem> mealItems) {
        this.mealItems = mealItems;
    }

    @Override
    public String toString() {
        return "Meal{" + "mealName=" + mealName + ", mealDateTime=" + mealDateTime + ", userID=" + userID + ", calorie=" + calorie + ", fat=" + fat + ", carb=" + carb + ", mealItems=" + mealItems + '}';
    }
    
    
    
}
