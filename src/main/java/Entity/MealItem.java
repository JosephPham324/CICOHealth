package Entity;

import java.util.Date;

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
public class MealItem {
    private String mealName;    //meal name
    private Date mealDateTime;  //meal date time
    private String mealDate;    //meal date
    private String mealTime;    //meal time
    String name;                //name meal item
    double totalWeight;         //total weight
    double totalCal;            //total calorie
    double proteinWeight;       //protein weight
    double fatWeight;           //fat weight
    double carbWeight;          //carb weight

    /**
     * Constructor
     * @param mealName      meal name
     * @param mealDateTime  meal date time
     * @param name          name meal item
     * @param totalWeight   total weight
     * @param totalCal      total calorie
     * @param proteinWeight protein weight
     * @param fatWeight     fat weight
     * @param carbWeight    carb weight
     */
    public MealItem(String mealName, Date mealDateTime, String name, double totalWeight, double totalCal, double proteinWeight, double fatWeight, double carbWeight) {
        this.mealName = mealName;
        this.mealDateTime = mealDateTime;
        this.name = name;
        this.totalWeight = totalWeight;
        this.totalCal = totalCal;
        this.proteinWeight = proteinWeight;
        this.fatWeight = fatWeight;
        this.carbWeight = carbWeight;
    }
    
    /**
     * Constructor
     * @param name              name meal item
     * @param totalWeight       total weight
     * @param totalCal          total calorie
     * @param proteinWeight     protein weight
     * @param fatWeight         fat weight
     * @param carbWeight        carb weight
     */
    public MealItem(String name, double totalWeight, double totalCal, double proteinWeight, double fatWeight, double carbWeight) {
        this.name = name;
        this.totalWeight = totalWeight;
        this.totalCal = totalCal;
        this.proteinWeight = proteinWeight;
        this.fatWeight = fatWeight;
        this.carbWeight = carbWeight;
    }

    /**
     * Constructor
     * @param mealName      meal name
     * @param mealDateTime  meal date time
     * @param mealTime      meal time
     * @param name          name meal item
     * @param totalWeight   total weight
     * @param totalCal      total calorie
     * @param proteinWeight protein weight
     * @param fatWeight     fat weight
     * @param carbWeight    carb weight
     */
    public MealItem(String mealName, Date mealDateTime, String mealDate, String mealTime, String name, double totalWeight, double totalCal, double proteinWeight, double fatWeight, double carbWeight) {
        this.mealName = mealName;
        this.mealDateTime = mealDateTime;
        this.mealDate = mealDate;
        this.mealTime = mealTime;
        this.name = name;
        this.totalWeight = totalWeight;
        this.totalCal = totalCal;
        this.proteinWeight = proteinWeight;
        this.fatWeight = fatWeight;
        this.carbWeight = carbWeight;
    }
    
    /**
     * get name meal item
     * @return String name meal item
     */
    public String getName() {
        return name;
    }

    /**
     * set name meal item
     * @param name name meal item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get total weight
     * @return double total weight
     */
    public double getTotalWeight() {
        return totalWeight;
    }

    /**
     * set total weight
     * @param totalWeight total weight
     */
    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    /**
     * get total calorie
     * @return double total calorie
     */
    public double getTotalCal() {
        return totalCal;
    }

    /**
     * set total calorie
     * @param totalCal total calorie
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
     * get meal names
     * @return string meal name
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
     * @return meal date time
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
     * get meal date
     * @return String meal date
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
     * @return String meal time
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
     * to string
     * @return to string
     */
    @Override
    public String toString() {
        return "{" + "name:'" + name + "', totalWeight:" + totalWeight + ", totalCal:" + totalCal + ", proteinWeight:" + proteinWeight + ", fatWeight:" + fatWeight + ", carbWeight:" + carbWeight + '}';
    }
    
    
    
}
