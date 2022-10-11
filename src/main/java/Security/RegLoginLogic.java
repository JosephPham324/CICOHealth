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
 *
 * @author Pham Nhat Quang
 */
public class RegLoginLogic {
    
    public static String encryptPassword(String username,String password){
        String salt = Encryption.generateSalt(username, password);
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
    
    public static void main(String[] args) {
        System.out.println(RegLoginLogic.encryptPassword("JospehPham", "password"));
    }
}
