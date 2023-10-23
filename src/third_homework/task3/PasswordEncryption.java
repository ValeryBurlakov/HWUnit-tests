package third_homework.task3;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordEncryption {
    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "mySecretKey12345"; // представим, что этот секретный ключ надежно спрятан

    public static String encrypt(String password) throws NoSuchPaddingException, NoSuchAlgorithmException,
            BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedPassword) throws NoSuchPaddingException, NoSuchAlgorithmException,
            BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
        return new String(decryptedBytes);
    }

//    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException,
//            BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
//        String password = "myPassword";
//        String encryptedPassword = encrypt(password);
//        String decryptedPassword = decrypt(encryptedPassword);
//
//        System.out.println("Our Password: " + password);
//        System.out.println("Encrypted Password: " + encryptedPassword);
//        System.out.println("Decrypted Password: " + decryptedPassword);
//    }
}
