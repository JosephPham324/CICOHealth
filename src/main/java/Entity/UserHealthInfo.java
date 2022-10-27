package Entity;

/**
 *
 * @author Thinh
 */
public class UserHealthInfo {

    private int userId;
    private String gender;
    private float height;
    private float weight;
    private int activeness;
    private int age;

    public UserHealthInfo(int userID) {
        this.userId = userID;
    }

    /**
     *
     * @param userId
     * @param gender
     * @param height
     * @param weight
     * @param activeness
     * @param age
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
     *
     * @return
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     */
    public float getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public float getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     *
     * @return
     */
    public int getActiveness() {
        return activeness;
    }

    /**
     *
     * @param activeness
     */
    public void setActiveness(int activeness) {
        this.activeness = activeness;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

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
