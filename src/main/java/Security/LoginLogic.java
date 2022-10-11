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
public class LoginLogic {
    public static boolean verifyPassword(String enteredPassword, String salt, String passwordHash){
        try {
            SecretKey key = Encryption.getKeyFromPassword(enteredPassword, salt);
            
            String decrypt = Encryption.decrypt(passwordHash, key);
            
            return enteredPassword.equals(decrypt);
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(LoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(LoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(LoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(LoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(LoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(LoginLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(LoginLogic.verifyPassword("group4prj301", "ufcid\\'8+3+5(dfx[X", "EFDSzBcs1si3ZmoLc8eGBQ=="));
    }
}
