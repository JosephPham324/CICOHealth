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
public class Login {
    private int loginID;            //login ID
    private String username;        //User name
    private String passwordSalt;    //Password salt
    private String passwordHash;    //Password Hash
    private int userID;             //User ID

    /**
     * Constructor
     * @param loginID       login ID
     * @param userID        User ID
     * @param username      User name
     * @param passwordSalt  Password salt
     * @param passwordHash  Password Hash
     */
    public Login(int loginID, String username, String passwordSalt, String passwordHash, int userID) {
        this.loginID = loginID;
        this.userID = userID;
        this.username = username;
        this.passwordSalt = passwordSalt;
        this.passwordHash = passwordHash;
    }

    /**
     * Get login ID
     * @return int login ID
     */
    public int getLoginID() {
        return loginID;
    }

    /**
     * Set login ID
     * @param loginID login ID
     */
    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }

    /**
     * get User ID
     * @return int User ID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * set User ID
     * @param userID User ID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Get User name
     * @return String User name
     */
    public String getUsername() {
        return username;
    }

    /**
     * set user name
     * @param username User name
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get Password salt
     * @return String Password salt
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * set Password salt
     * @param passwordSalt Password salt
     */
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    /**
     * get Password Hash
     * @return String Password Hash
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * set Password Hash
     * @param passwordHash Password Hash
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * To string 
     * @return String
     */
    @Override
    public String toString() {
        return "Login{" + "loginID=" + loginID + ", username=" + username + ", passwordSalt=" + passwordSalt + ", passwordHash=" + passwordHash + ", userID=" + userID + '}';
    }

    
    
    
}
