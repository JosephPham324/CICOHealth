package Entity;

/**
 *
 * @author ASUS
 */
public class Login {
    private int loginID;
    private String username;
    private String passwordSalt;
    private String passwordHash;
    private int userID;

    /**
     *
     * @param loginID
     * @param userID
     * @param username
     * @param passwordSalt
     * @param passwordHash
     */
    public Login(int loginID, String username, String passwordSalt, String passwordHash, int userID) {
        this.loginID = loginID;
        this.userID = userID;
        this.username = username;
        this.passwordSalt = passwordSalt;
        this.passwordHash = passwordHash;
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
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     *
     * @param passwordSalt
     */
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    /**
     *
     * @return
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     *
     * @param passwordHash
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        return "Login{" + "loginID=" + loginID + ", username=" + username + ", passwordSalt=" + passwordSalt + ", passwordHash=" + passwordHash + ", userID=" + userID + '}';
    }

    
    
    
}
