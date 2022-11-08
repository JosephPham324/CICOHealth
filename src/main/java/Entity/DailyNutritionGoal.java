package Entity;

/**
 * Semester: FALL 2022
 * Subject : FRJ301
 * Class   : SE1606
 * Project : Nutrition 
 * @author : Group 4
 * CE161130  Nguyen Le Quang Thinh (Leader)
 * CE170036  Pham Nhat Quang
 * CE160464  Nguyen The Lu
 * CE161096  Nguyen Ngoc My Quyen
 * CE161025  Tran Thi Ngoc Hieu
 */
public class DailyNutritionGoal {
    private int userID;         //ID of user
    private float calories;     //Calorie of meal
    private float protein;      //Protein of meal
    private float fat;          //Fat of meal
    private float carb;         //Carb of meal

    public DailyNutritionGoal() {
        this.userID = 0;
        this.calories = 0;
        this.protein = 0;
        this.fat = 0;
        this.carb = 0;
    }
    
    
    
    /**
     * Constructor
     * @param userID ID of user
     */
    public DailyNutritionGoal(int userID) {
        this.userID = userID;
    }

    /**
     * Constructor
     * 
     * @param userID ID of user
     * @param calories Calorie of meal
     * @param protein Protein of meal
     * @param fat Fat of meal
     * @param carb Carb of meal
     */
    public DailyNutritionGoal(int userID, float calories, float protein, float fat, float carb) {
        this.userID = userID;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carb = carb;
    }

    /**
     * Get user ID
     * @return ID of user
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Set user ID
     * @param userID ID of user
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Get calories 
     * @return calories calories of meal
     */
    public float getCalories() {
        return calories;
    }

    /**
     * Set calories
     * @param calories calories of meal
     */
    public void setCalories(float calories) {
        this.calories = calories;
    }

    /**
     * Get protein 
     * @return protein protein of meal
     */
    public float getProtein() {
        return protein;
    }

    /**
     * Set protein
     * @param protein protein of meal
     */
    public void setProtein(float protein) {
        this.protein = protein;
    }

    /**
     * Get fat
     * @return fat fat of meal
     */
    public float getFat() {
        return fat;
    }

    /**
     * Set fat
     * @param fat fat of meal
     */
    public void setFat(float fat) {
        this.fat = fat;
    }

    /**
     * Get carb
     * @return carb carb of meal
     */
    public float getCarb() {
        return carb;
    }

    /**
     * Set carb
     * @param carb carb of meal
     */
    public void setCarb(float carb) {
        this.carb = carb;
    }
    
    
}
