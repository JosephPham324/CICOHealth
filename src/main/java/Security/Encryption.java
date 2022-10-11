package Security;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author M S I
 */
public class Encryption {

    public static SecretKey getKeyFromPassword(String password, String salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
        SecretKey secret = new SecretKeySpec(factory.generateSecret(spec)
                .getEncoded(), "AES");
        return secret;
    }

    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static String encrypt(String algorithm, String input, SecretKey key,
            IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder()
                .encodeToString(cipherText);
    }

    public static String decrypt(String algorithm, String cipherText, SecretKey key,
            IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
                .decode(cipherText));
        return new String(plainText);
    }
    
    public static StringBuffer encryptCC(String text, int s)
    {
        StringBuffer result= new StringBuffer();
 
        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                                  s - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                                  s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
    
    public static String generateSpecChar(){
        int max = 47;
        int min = 33;
        String res = "";
        for (int i = 0;i<10;i++){
            int in = ((int)Math.floor(Math.random()*(max-min+1)+min));
            int num= ((int)Math.floor(Math.random()*(9+1)));
            res+=num;
            res+=(char)in;
        }
        min = ((int)Math.floor(Math.random()*(14+1)));
        return res.substring(min, min+6);
    }
    
    public static String generateSalt(String username, String password){
        System.out.println("Username: " + username + " Password: " +password);
        int max = username.length() + password.length();
        int rand = (int)Math.floor(Math.random()*(max-1+1)+1);
        if (max<10)
            return "Unable to generate salt";
        String salt = encryptCC(password+username, rand).toString();
        salt = salt.substring(0, 6) + generateSpecChar() + salt.substring(6,11);
        System.out.println("Salt: "+ salt);
        return salt;
    }
    
    public static void main(String[] args) {
        generateSalt("QuangPNCE170036", "group4prj301");
        generateSalt("QuangPNCE170036", "group4prj301");
        generateSalt("QuangPNCE170036", "group4prj301");
//        System.out.println(generateSalt("QuangPNCE170036", "group4prj301"));
    }
}
