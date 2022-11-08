package Security;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
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
public class RegLoginLogic {
    
    /**
     * Encrypt password
     * @param salt      salt
     * @param password  password
     * @return          String encrypted
     */
    public static String encryptPassword(String salt,String password){
        try {
            SecretKey key = Encryption.getKeyFromPassword(password, salt);
            
            String hashedPassword = Encryption.encrypt(password, key);
            
            return hashedPassword;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    /**
     * get secret key
     * @param salt      salt
     * @param password  password
     * @return          SecretKey
     */
    public static SecretKey getSecretKey(String salt, String password){
        try {
            SecretKey key = Encryption.getKeyFromPassword(password, salt);
            
            return key;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * verify password 
     * @param enteredPassword   entered password 
     * @param salt              salt
     * @param passwordHash      hash
     * @return                  boolean
     */
    public static boolean verifyPassword(String enteredPassword, String salt, String passwordHash){
        try {
            SecretKey key = Encryption.getKeyFromPassword(enteredPassword, salt);
            
            String decrypt = Encryption.decrypt(passwordHash, key);
            
            return enteredPassword.equals(decrypt);
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * decrypt password
     * @param key   key
     * @param hash  hash
     * @return String decrypted password
     */
    public static String decryptPassword(SecretKey key,String hash){
        try {
            return Encryption.decrypt(hash, key);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(RegLoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
