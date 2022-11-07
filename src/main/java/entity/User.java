package Entity;

/**
 *
 * @author Thinh
 */
public class User {
    private int userID;
    private int loginID;
    private int userRoleId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    /**
     *
     * @param userID
     * @param loginID
     * @param userRoleId
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     */
    public User(int userID, int loginID, int userRoleId, String firstName, String lastName, String email, String phone) {
        this.userID = userID;
        this.loginID = loginID;
        this.userRoleId = userRoleId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public User(int userID, String firstName, String lastName, String email, String phone) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
    

    /**
     *
     * @return
     */
    public int getUserID() {
        return userID;
    }

    /**
     *
     * @param userID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     *
     * @return
     */
    public int getLoginID() {
        return loginID;
    }

    /**
     *
     * @param loginID
     */
    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }

    /**
     *
     * @return
     */
    public int getUserRoleId() {
        return userRoleId;
    }

    /**
     *
     * @param userRoleId
     */
    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", loginID=" + loginID + ", userRoleId=" + userRoleId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + '}';
    }
    
    
    

   
    
}
