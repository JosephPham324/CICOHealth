package Entity;

/**
 *
 * @author Nguyen Le Quang Thinh
 */
public class DailyNutritionGoal {
    private int userID;
    private float calories;
    private float protein;
    private float fat;
    private float carb;

    public DailyNutritionGoal() {
        this.userID = 0;
        this.calories = 0;
        this.protein = 0;
        this.fat = 0;
        this.carb = 0;
    }
    
    
    
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
