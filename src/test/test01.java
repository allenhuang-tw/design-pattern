package test;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class test01 {

	private static final int GCM_NONCE_LENGTH = 12;
    private static final int GCM_TAG_LENGTH = 16;
    private static final String AES_KEY_ALGORITHM = "AES";
    private static final String AES_CIPHER_ALGORITHM = "AES/GCM/NoPadding";
    private static final String FIXED_IV_STRING = "M7Aq3z!eSEt+";
	public static void main(String[] args) {
		try {
            String plaintext = "GID81870341298815|ios|3.3";
            String key = "AuzhX35vAFCahv6PAgr9rFe8EVGTZgZ2"; // 256�쪺�K�_�]32�Ӧr���^

            // �[�K
            String encryptedText = encrypt(plaintext, key);
            System.out.println("Encrypted Text: " + encryptedText);

            // �ѱK
            String decryptedText = decrypt(encryptedText, key);
            String[] a = decryptedText.split("\\|");
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
	public static String encrypt(String plaintext, String key) throws Exception {
        // �T�wIV��
		byte[] iv = FIXED_IV_STRING.getBytes(StandardCharsets.UTF_8);

        // �ഫ�K�_��SecretKey����
        SecretKey secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), AES_KEY_ALGORITHM);

        // ��l�ƥ[�K��
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmParameterSpec);

        // ����[�K
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

        // �N�K��i��Base64�s�X
        String encodedCiphertext = Base64.getEncoder().encodeToString(ciphertext);
        String urlEncoded = URLEncoder.encode(encodedCiphertext, StandardCharsets.UTF_8);

        // ��^IV�M�K�媺���X
        return urlEncoded;
    }
	public static String decrypt(String encryptedText, String key) throws Exception {
        // �qBase64�s�X���r�ꤤ�ѪR�XIV�M�K��
		String base64Encoded = URLDecoder.decode(encryptedText, StandardCharsets.UTF_8);
        byte[] iv = FIXED_IV_STRING.getBytes(StandardCharsets.UTF_8);
        byte[] ciphertext = Base64.getDecoder().decode(base64Encoded);

        // �ഫ�K�_��SecretKey����
        SecretKey secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), AES_KEY_ALGORITHM);

        // ��l�ƸѱK��
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmParameterSpec);

        // ����ѱK
        byte[] plaintext = cipher.doFinal(ciphertext);

        // ��^�ѱK�᪺�r��
        return new String(plaintext, StandardCharsets.UTF_8);
    }

}
