/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasmps.utils.crypto;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.util.encoders.Base64;

/**
 *
 * @author akhtar
 */
public class AESAlgorithm {

    /**
     * @param args the command line arguments
     */
    private String plainText;
    private String cipherText;

    private static final String INITILIZATION_VECTOR = "SESSIONINITMYLOC";
    private static final String ALGORITHM_NAME = "AES/CFB/PKCS5Padding";
    private static final String KEY_STORE_PASSWORD = "akhtar079723";
    private static final String KEY_NAME = "mykey";
    private static final String KEY_PATH = "D:\\Rough\\mykeystore.jks";

    public AESAlgorithm() {
    }

    public AESAlgorithm(String plainText) {
        this.plainText = plainText;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getCipherText() {
        return cipherText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    public String AESEncrypt() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException {
        SecretKey key = loadKeyFromKeyStore();
        IvParameterSpec iv = getInitVector();
        return AESEncrypt(plainText, key, iv);
    }

    public String AESEncrypt(String plainText) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException {
        SecretKey key = loadKeyFromKeyStore();
        IvParameterSpec iv = getInitVector();
        return AESEncrypt(plainText, key, iv);
    }

    public String AESEncrypt(String plainText, SecretKey key) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        IvParameterSpec iv = getInitVector();
        return AESEncrypt(plainText, key, iv);
    }

    public String AESEncrypt(String plainText, SecretKey key, IvParameterSpec iv) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        this.plainText = plainText;
        if (plainText == null) {
            throw new NullPointerException("Initilize plain Text");
        }
        if (key == null) {
            throw new NullPointerException("Initilize secret key");
        }
        if (iv == null) {
            throw new NullPointerException("Initilize initilization vector");
        }
        Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] cipherText = cipher.doFinal(this.plainText.getBytes());
        String cipherString = new String(Base64.encode(cipherText));
        this.cipherText = cipherString;
        return cipherString;
    }

    public String AESDecrypt() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException {
        SecretKey key = loadKeyFromKeyStore();
        IvParameterSpec iv = getInitVector();
        return AESDecrypt(cipherText, key, iv);
    }

    public String AESDecrypt(String cipherText) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException {
        SecretKey key = loadKeyFromKeyStore();
        IvParameterSpec iv = getInitVector();
        return AESDecrypt(cipherText, key, iv);
    }

    public String AESDecrypt(String cipherText, SecretKey key) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        IvParameterSpec iv = getInitVector();
        return AESDecrypt(cipherText, key, iv);
    }

    public String AESDecrypt(String cipherText, SecretKey key, IvParameterSpec iv) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        this.cipherText = cipherText;
        if (cipherText == null) {
            throw new NullPointerException("Initilize cipher Text");
        }
        if (key == null) {
            throw new NullPointerException("Initilize secret key");
        }
        if (iv == null) {
            throw new NullPointerException("Initilize initilization vector");
        }
        Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plain = cipher.doFinal(Base64.decode(cipherText.getBytes()));
        String plainTextString = new String(plain);
        this.plainText = plainTextString;
        return plainTextString;
    }

    private IvParameterSpec getInitVector() {
        return new IvParameterSpec(INITILIZATION_VECTOR.getBytes());
    }

    public IvParameterSpec genrateRandomInitVector() {
        SecureRandom random = new SecureRandom();
        byte randomByte[] = new byte[16];
        random.nextBytes(randomByte);
        return new IvParameterSpec(randomByte);
    }

    private SecretKey loadKeyFromKeyStore() throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException {
        KeyStore ks = KeyStore.getInstance("JCEKS");
        char[] password = KEY_STORE_PASSWORD.toCharArray();
        FileInputStream fis = new FileInputStream(KEY_PATH);
        ks.load(fis, password);
        SecretKey key = (SecretKey) ks.getKey(KEY_NAME, password);
        if (fis != null) {
            fis.close();
        }
        return key;
    }

//    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
//        AESAlgorithm aes = new AESAlgorithm("1204170000000001");
//        System.err.println(aes.AESEncrypt());
//        System.err.println(aes.getPlainText());
//    }
}
