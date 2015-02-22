package com.babalsharji.util;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
    private final String key = "FA8ebejabePaWugU";
    private static Encryption INSTANCE_VARIABLE = null;
    
    private Encryption(){}
    
    public static Encryption getInstance(){
        if(INSTANCE_VARIABLE == null) {
            INSTANCE_VARIABLE = new Encryption();
        }
        return INSTANCE_VARIABLE;
    }
    
    public String encryptPassword(String newPassword) {
        try {
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(newPassword.getBytes());

            return new String(encrypted);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    public String decryptPassword(String encryptedPassword) {
        try {
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(encryptedPassword.getBytes());
            String decrypted = new String(cipher.doFinal(encrypted));

            return decrypted;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
}
