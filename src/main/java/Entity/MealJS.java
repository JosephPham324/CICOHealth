package Entity;

import java.util.List;

/**
 *
 * @author Pham Nhat Quang
 */
public class MealJS {
    String mealName;
    double totalCal;
    double proteinWeight;
    double fatWeight;
    double carbWeight;
    List<FoodItem> foodItems;

    public MealJS(String mealName, double totalCal, double proteinWeight, double fatWeight, double carbWeight, List<FoodItem> foodItems) {
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

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    @Override
    public String toString() {
        return "MealJS{" + "mealName=" + mealName + ", totalCal=" + totalCal + ", proteinWeight=" + proteinWeight + ", fatWeight=" + fatWeight + ", carbWeight=" + carbWeight + ", foodItems=" + foodItems + '}';
    }
    
    
}
