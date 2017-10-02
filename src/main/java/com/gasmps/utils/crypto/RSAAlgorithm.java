/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gasmps.utils.crypto;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.bouncycastle.util.encoders.Base64;

/**
 *
 * @author akhtar
 */
public class RSAAlgorithm {

    private String plainText;
    private String cipherText;
    private Key publicKey;
    private Key privateKey;
    private static final String ALGORITHM_NAME = "RSA/None/NoPadding";

    public RSAAlgorithm() {
    }

    public RSAAlgorithm(String plainText) {
        this.plainText = plainText;
    }

    public RSAAlgorithm(String plainText, Key publicKey, Key privateKey) {
        this.plainText = plainText;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
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

    public Key getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(Key publicKey) {
        this.publicKey = publicKey;
    }

    public Key getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(Key privateKey) {
        this.privateKey = privateKey;
    }

    public void genrateKeyPair() throws NoSuchAlgorithmException, NoSuchProviderException {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        SecureRandom random = new SecureRandom();
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");
        generator.initialize(256, random);
        KeyPair pair = generator.generateKeyPair();
        this.publicKey = pair.getPublic();
        this.privateKey = pair.getPrivate();
    }

    public String RSAEncrypt() throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        return RSAEncrypt(plainText, publicKey);
    }

    public String RSAEncrypt(String plainText) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        return RSAEncrypt(plainText, publicKey);
    }

    public String RSAEncrypt(String plainText, String base64EncodedPublicKey) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        Key publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(base64EncodedPublicKey)));
        return RSAEncrypt(plainText, publicKey);
    }

    public String RSAEncrypt(String plainText, Key publicKey) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        this.publicKey = publicKey;
        this.publicKey = publicKey;
        if (plainText == null) {
            throw new NullPointerException("Initilize plain Text");
        }
        if (publicKey == null) {
            throw new NullPointerException("Initilize public key");
        }
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(ALGORITHM_NAME, "BC");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        String cipherTextString = new String(Base64.encode(cipherText));
        this.cipherText = cipherTextString;
        return cipherTextString;
    }

    public String RSADecrypt() throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        return RSADecrypt(cipherText, privateKey);
    }

    public String RSADecrypt(String cipherText) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        return RSADecrypt(cipherText, privateKey);
    }

    public String RSADecrypt(String cipherText, String base64EncodedPrivateKey) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {
        Key privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(base64EncodedPrivateKey)));
        return RSADecrypt(cipherText, privateKey);
    }

    public String RSADecrypt(String cipherText, Key privaKey) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        this.privateKey = privaKey;
        this.cipherText = cipherText;
        if (cipherText == null) {
            throw new NullPointerException("Initilize cipher Text");
        }
        if (privateKey == null) {
            throw new NullPointerException("Initilize private key");
        }
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(ALGORITHM_NAME, "BC");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] plainText = cipher.doFinal(Base64.decode(this.cipherText.getBytes()));
        String plainTextString = new String(plainText);
        this.plainText = plainTextString;
        return plainTextString;
    }

    public String getPrivateKeyString() {
        return new String(Base64.encode(privateKey.getEncoded()));
    }

    public String getPublicKeyString() {
        return new String(Base64.encode(publicKey.getEncoded()));
    }

//    public static void main(String[] args) throws Exception {
//        RSAAlgorithm r = new RSAAlgorithm();
//        r.genrateKeyPair();
//        //System.err.println(r.RSAEncrypt("NOMAN"));
//        //System.err.println(r.RSADecrypt());
//        String pri = r.getPrivateKeyString();
//        String pub = r.getPublicKeyString();
//        
//        String str = r.RSAEncrypt("NOMAN",pub);
//        r.RSADecrypt(str,pri);
//        //System.err.println(str);
//        //System.err.println("Decrypt :" + r.RSADecrypt(str,pri));
//    }
}
