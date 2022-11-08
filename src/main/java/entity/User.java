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
public class User {
    private int userID;         //ID of user
    private int loginID;        //ID login
    private int userRoleId;     //Role ID of user
    private String firstName;   //First name of user
    private String lastName;    //Last name of user
    private String email;       //Email of user
    private String phone;       //Phone of user

    /**
     * Constructor
     * @param userRoleId user role id
     */
    public User(int userRoleId) {
        this.userRoleId = userRoleId;
    }
    
    
    

    /**
     * Constructor
     * 
     * @param userID ID of user
     * @param userRoleId Role ID of user
     * @param firstName First name of user
     * @param lastName Last name of user
     * @param email Email of user
     * @param phone Phone of user
     */
        public User(int userID, int userRoleId, String firstName, String lastName, String email, String phone) {
        this.userID = userID;
        this.userRoleId = userRoleId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
    
    /**
     * Constructor
     * 
     * @param userID ID of user
     * @param firstName First name of user
     * @param lastName Last name of user
     * @param email Email of user
     * @param phone Phone of user
     */
    public User(int userID, String firstName, String lastName, String email, String phone) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
    

    /**
     * Get user ID
     * @returnuserID ID of user
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
     * Get login ID
     * @return loginID ID of login
     */
    public int getLoginID() {
        return loginID;
    }

    /**
     * Set login ID
     * @param loginID ID of login
     */
    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }

    /**
     * Get user role ID
     * @return userRoleId user role's ID
     */
    public int getUserRoleId() {
        return userRoleId;
    }

    /**
     * Set user role ID
     * @param userRoleId user role's ID
     */
    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * Get first name
     * @return firstName first name of user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set first name
     * @param firstName first name of user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get last name
     * @return lastName last name of user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set last name
     * @param lastName last name of user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get email
     * @return email email of user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email
     * @param email email of user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get phone
     * @return phone phone of user
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set phone 
     * @param phone phone of user
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * To string
     * @return User info of user
     */
    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", loginID=" + loginID + ", userRoleId=" + userRoleId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + '}';
    }
    
    
    

   
    
}
