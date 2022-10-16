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
    private double totalCal;
    private double proteinWeight;
    private double fatWeight;
    private double carbWeight;
    private List<MealItem> foodItems;

    public Meal(String mealName, Date mealDateTime, int userID, double totalCal, double proteinWeight, double fatWeight, double carbWeight, List<MealItem> foodItems) {
        this.mealName = mealName;
        this.mealDateTime = mealDateTime;
        this.userID = userID;
        this.totalCal = totalCal;
        this.proteinWeight = proteinWeight;
        this.fatWeight = fatWeight;
        this.carbWeight = carbWeight;
        this.foodItems = foodItems;
    }

    public Meal(String mealName, double totalCal, double proteinWeight, double fatWeight, double carbWeight, List<MealItem> foodItems) {
        this.mealName = mealName;
        this.totalCal = totalCal;
        this.proteinWeight = proteinWeight;
        this.fatWeight = fatWeight;
        this.carbWeight = carbWeight;
        this.foodItems = foodItems;
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

    public double getTotalCal() {
        return totalCal;
    }

    public void setTotalCal(double totalCal) {
        this.totalCal = totalCal;
    }

    public double getProteinWeight() {
        return proteinWeight;
    }

    public void setProteinWeight(double proteinWeight) {
        this.proteinWeight = proteinWeight;
    }

    public double getFatWeight() {
        return fatWeight;
    }

    public void setFatWeight(double fatWeight) {
        this.fatWeight = fatWeight;
    }

    public double getCarbWeight() {
        return carbWeight;
    }

    public void setCarbWeight(double carbWeight) {
        this.carbWeight = carbWeight;
    }

    public List<MealItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<MealItem> foodItems) {
        this.foodItems = foodItems;
    }

    @Override
    public String toString() {
        return "Meal{" + "mealName=" + mealName + ", mealDateTime=" + mealDateTime + ", userID=" + userID + ", totalCal=" + totalCal + ", proteinWeight=" + proteinWeight + ", fatWeight=" + fatWeight + ", carbWeight=" + carbWeight + ", foodItems=" + foodItems + '}';
    }

   
    
    
}
