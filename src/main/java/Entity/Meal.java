package Entity;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class Meal {

    private String mealName;                            //meal name
    private Date mealDateTime;                          //meal date time
    private String mealDate;                            //meal date
    private String mealTime;                            //meal time
    private int userID;                                 //user ID
    private double totalCal;                            //total cal
    private double proteinWeight;                       //protein weight
    private double fatWeight;                           //fat weight
    private double carbWeight;                          //carb weight
    private List<MealItem> foodItems;                   //food items
    private final String dateFormat = "yyyy-MM-dd";     //format date
    private final String monthYearFormat = "yyyy-MM";   //format month year
    private final String monthDayFormat = "dd";         //format day
    private final String timeFormat = "HH:mm:ss";       //format time 
    private SimpleDateFormat formatter;                 //formatter

    /**
     * Constructor
     * @param mealName      meal name
     * @param mealDateTime  meal date time
     * @param userID        user ID
     * @param totalCal      total cal
     * @param proteinWeight protein weight
     * @param fatWeight     fat weight
     * @param carbWeight    carb weight
     * @param foodItems     food items
     */
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

    /**
     * Constructor
     * @param mealDate      meal date time
     * @param userID        user ID
     * @param totalCal      total cal
     * @param proteinWeight protein weight
     * @param fatWeight     fat weight
     * @param carbWeight    carb weight
     */
    public Meal(String mealDate, int userID, double totalCal, double proteinWeight, double fatWeight, double carbWeight) {
        this.mealDate = mealDate;
        this.userID = userID;
        this.totalCal = totalCal;
        this.proteinWeight = proteinWeight;
        this.fatWeight = fatWeight;
        this.carbWeight = carbWeight;
    }
    
    /**
     * Constructor
     * @param mealName      meal name
     * @param totalCal      total cal
     * @param proteinWeight protein weight
     * @param fatWeight     fat weight
     * @param carbWeight    carb weight
     * @param foodItems     food items
     */
    public Meal(String mealName, double totalCal, double proteinWeight, double fatWeight, double carbWeight, List<MealItem> foodItems) {
        this.mealName = mealName;
        this.totalCal = totalCal;
        this.proteinWeight = proteinWeight;
        this.fatWeight = fatWeight;
        this.carbWeight = carbWeight;
        this.foodItems = foodItems;
    }

    /**
     * Constructor
     * @param mealName      meal name
     * @param mealDateTime  meal date time
     * @param userID        user ID
     * @param totalCal      total cal
     * @param proteinWeight protein weight
     * @param fatWeight     fat weight
     * @param carbWeight    carb weight
     * @param foodItems     food items
     * @param mealDate      meal date
     * @param mealTime      meal time
     */
    public Meal(String mealName, Date mealDateTime, String mealDate, String mealTime, int userID, double totalCal, double proteinWeight, double fatWeight, double carbWeight, List<MealItem> foodItems) {
        this.mealName = mealName;
        this.mealDateTime = mealDateTime;
        this.mealDate = mealDate;
        this.mealTime = mealTime;
        this.userID = userID;
        this.totalCal = totalCal;
        this.proteinWeight = proteinWeight;
        this.fatWeight = fatWeight;
        this.carbWeight = carbWeight;
        this.foodItems = foodItems;
    }

    /**
     * get meal name
     * @return String meal name
     */
    public String getMealName() {
        return mealName;
    }

    /**
     * set meal name
     * @param mealName meal name
     */
    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    /**
     * get meal date time
     * @return Date meal date time
     */
    public Date getMealDateTime() {
        return mealDateTime;
    }

    /**
     * set meal date time
     * @param mealDateTime meal date time
     */
    public void setMealDateTime(Date mealDateTime) {
        this.mealDateTime = mealDateTime;
    }

    /**
     * get user ID
     * @return int user ID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * set user ID
     * @param userID user ID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * get total cal
     * @return double total cal
     */
    public double getTotalCal() {
        return totalCal;
    }

    /**
     * set total cal
     * @param totalCal total cal
     */
    public void setTotalCal(double totalCal) {
        this.totalCal = totalCal;
    }

    /**
     * get protein weight
     * @return double protein weight
     */
    public double getProteinWeight() {
        return proteinWeight;
    }

    /**
     * set protein weight
     * @param proteinWeight protein weight
     */
    public void setProteinWeight(double proteinWeight) {
        this.proteinWeight = proteinWeight;
    }

    /**
     * get fat weight
     * @return double fat weight
     */
    public double getFatWeight() {
        return fatWeight;
    }

    /**
     * set fat weight
     * @param fatWeight fat weight
     */
    public void setFatWeight(double fatWeight) {
        this.fatWeight = fatWeight;
    }

    /**
     * get carb weight
     * @return double carb weight
     */
    public double getCarbWeight() {
        return carbWeight;
    }

    /**
     * set carb weight
     * @param carbWeight carb weight
     */
    public void setCarbWeight(double carbWeight) {
        this.carbWeight = carbWeight;
    }

    /**
     * get list food items
     * @return List [MealItem]
     */
    public List<MealItem> getFoodItems() {
        return foodItems;
    }

    /**
     * set list food items
     * @param foodItems List [MealItem]
     */
    public void setFoodItems(List<MealItem> foodItems) {
        this.foodItems = foodItems;
    }

    /**
     * get date
     * @return String date
     */
    public String getDate() {
        this.formatter
                = new SimpleDateFormat(dateFormat);

        return formatter.format(this.mealDateTime);
    }
    
    /**
     * get date
     * @param format string format
     * @return string date
     */
    public String getDate(String format){
        this.formatter
                = new SimpleDateFormat(format);

        return formatter.format(this.mealDateTime);
    }

    /**
     * get time
     * @return string time
     */
    public String getTime() {
        this.formatter
                = new SimpleDateFormat(timeFormat);

        return formatter.format(this.mealDateTime);
    }

    /**
     * get month year
     * @return String month year
     */
    public String getMonthYear() {
        this.formatter = new SimpleDateFormat(monthYearFormat);

        return formatter.format(this.mealDateTime);
    }

    /**
     * get month day
     * @return String month day
     */
    public String getMonthDay() {
        this.formatter = new SimpleDateFormat(monthDayFormat);

        return formatter.format(this.mealDateTime);
    }

    /**
     * get meal date
     * @return string meal date
     */
    public String getMealDate() {
        return mealDate;
    }

    /**
     * set meal date
     * @param mealDate meal date
     */
    public void setMealDate(String mealDate) {
        this.mealDate = mealDate;
    }

    /**
     * get meal time
     * @return string meal time
     */
    public String getMealTime() {
        return mealTime;
    }

    /**
     * set meal time
     * @param mealTime meal time
     */
    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }
    
    /**
     * Calculate total calorie
     * @param list List [Exercise]
     * @return double calorie
     */
    public double calculateTotalCalorie(List<Exercise> list){
        double res = 0;
        for (Exercise exercise: list){
            res+=exercise.getCalorie();
        }
        return res;
    }

    /**
     * group meal by date
     * @param meals List [meal]
     * @return List [meal]
     */
    public static List<Meal> groupMealsByDate(List<Meal> meals) {
        String currentDate = "";
        ArrayList<Meal> res = new ArrayList<>();
        Meal resItem = null;
        for (Meal meal : meals) {
            String itemDate = meal.getDate();
            System.out.println(itemDate);
            if (itemDate.equals(currentDate) && resItem != null) {
                resItem.setProteinWeight(resItem.getProteinWeight() + meal.getProteinWeight());
                resItem.setFatWeight(resItem.getFatWeight() + meal.getFatWeight());
                resItem.setCarbWeight(resItem.getCarbWeight() + meal.getCarbWeight());
                resItem.setTotalCal(resItem.getTotalCal() + meal.getTotalCal());
            } else {
                currentDate = itemDate;
                if (resItem != null) {
                    res.add(resItem);
                }
                resItem = new Meal(itemDate, 0, 0, 0, 0, null);
                resItem.setMealDateTime(meal.getMealDateTime());
                
                resItem.setProteinWeight(resItem.getProteinWeight() + meal.getProteinWeight());
                resItem.setFatWeight(resItem.getFatWeight() + meal.getFatWeight());
                resItem.setCarbWeight(resItem.getCarbWeight() + meal.getCarbWeight());
                resItem.setTotalCal(resItem.getTotalCal() + meal.getTotalCal());
            }
            if (meal == meals.get(meals.size() - 1)) {
                resItem = new Meal(itemDate, 0, 0, 0, 0, null);
                resItem.setMealDateTime(meal.getMealDateTime());
                
                
                resItem.setProteinWeight(resItem.getProteinWeight() + meal.getProteinWeight());
                resItem.setFatWeight(resItem.getFatWeight() + meal.getFatWeight());
                resItem.setCarbWeight(resItem.getCarbWeight() + meal.getCarbWeight());
                resItem.setTotalCal(resItem.getTotalCal() + meal.getTotalCal());
                res.add(resItem);
            }
        }
        return res;
    }

    /**
     * to string 
     * @return to string
     */
    @Override
    public String toString() {
        return "{" + "mealName:'" + mealName + "', mealDate:'" + ((this.mealDateTime != null) ? this.getDate() : this.mealDate) + "',mealTime:'" + (this.mealDateTime != null ? this.getTime() : this.mealTime) + "', userID:" + userID + ", totalCal:" + totalCal + ", proteinWeight:" + proteinWeight + ", fatWeight:" + fatWeight + ", carbWeight:" + carbWeight + ", foodItems:" + foodItems + '}';
    }

}
