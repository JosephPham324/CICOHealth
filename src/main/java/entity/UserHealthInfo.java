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
public class UserHealthInfo {

    private int userId;     //id of user
    private String gender;  //gender of user
    private float height;   //height of user
    private float weight;   //weight of user
    private int activeness; //activeness of user
    private int age;        //age of user

    /**
     * Constructor
     * @param userID user id of user
     */
    public UserHealthInfo(int userID) {
        this.userId = userID;
    }

    /**
     * User health info
     * @param userId id of user
     * @param gender gender of user
     * @param height height of user
     * @param weight weight of user
     * @param activeness activeness of user
     * @param age age of user
     */
    public UserHealthInfo(int userId, String gender, float height, float weight, int activeness, int age) {
        this.userId = userId;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.activeness = activeness;
        this.age = age;
    }

    /**
     * Get user id
     * @return id of user
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set user id
     * @param userId id of user
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Get gender 
     * @return gender of user
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set gender
     * @param gender gender of user
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Get height 
     * @return height of user
     */
    public float getHeight() {
        return height;
    }

    /**
     * Set height
     * @param height height of user
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Get weight
     * @return weight of user
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Set weight
     * @param weight weight of user
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     *  Get activeness 
     * @return activeness of user
     */
    public int getActiveness() {
        return activeness;
    }

    /**
     * Set activeness
     * @param activeness activeness of user
     */
    public void setActiveness(int activeness) {
        this.activeness = activeness;
    }

    /**
     * Get age
     * @return age of user
     */
    public int getAge() {
        return age;
    }

    /**
     * Set age
     * @param age age of user
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get activeness string
     * @return String
     */
    public String getActivenessString() {
        switch (this.activeness) {
            case 0: return "Not active";
            case 1: return "Lightly active";
            case 2: return "Active";
            case 3: return "Very active";
        }
        return "Not active";
    }
}
