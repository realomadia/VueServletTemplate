package kr.co.backend.config;

import java.security.SecureRandom;
import java.util.Base64;

public class SaltUtil {
    private static final int SALT_LENGTH = 16; // SALT길이

    public static String generateSalt() {
        SecureRandom random = new SecureRandom(); // 난수 생성
        byte[] saltBytes = new byte[SALT_LENGTH];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }
}