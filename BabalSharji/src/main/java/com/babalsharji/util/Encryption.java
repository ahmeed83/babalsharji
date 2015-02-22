package com.babalsharji.util;

import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {

    private final String key = "FA8ebejabePaWugU";
    private static Encryption INSTANCE_VARIABLE = null;
    private Key aesKey;
    private Cipher cipher;

    private Encryption() {
        try {
            aesKey = new SecretKeySpec(key.getBytes(), "AES");
            cipher = Cipher.getInstance("AES");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static Encryption getInstance() {
        if (INSTANCE_VARIABLE == null) {
            INSTANCE_VARIABLE = new Encryption();
        }
        return INSTANCE_VARIABLE;
    }

    public String encryptPassword(String newPassword) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(newPassword.getBytes());

            return new String(encrypted);
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }

    public String decryptPassword(String encryptedPassword) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(encryptedPassword.getBytes());
            String decrypted = new String(cipher.doFinal(encrypted));

            return decrypted;
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
}
