package com.example;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class MyRSA {
    public static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCktpQMbiQNfTQbFuxtT3sw/hhjSJ82sXZ53QxmMVurQzElHPGD6+W+B4q4yb5wyuTF9Q11uo53hLPjHg219wQu3Gw+c/G37RBJUvdIG3UVDtf9kobXDznQFSuLQioi4hTgNQ7oxcLF/cz7Svo9EvaFrpBC+UfvggDb6NPF1LxsqQIDAQAB";

    /*
     * -----BEGIN PUBLIC KEY-----
     * MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCktpQMbiQNfTQbFuxtT3sw/hhj
     * SJ82sXZ53QxmMVurQzElHPGD6+W+B4q4yb5wyuTF9Q11uo53hLPjHg219wQu3Gw+
     * c/G37RBJUvdIG3UVDtf9kobXDznQFSuLQioi4hTgNQ7oxcLF/cz7Svo9EvaFrpBC
     * +UfvggDb6NPF1LxsqQIDAQAB
     * -----END PUBLIC KEY-----
     * 
     */
    public static String Decode(String cipherText) {
        try {
            Cipher asymmetricCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            // asume, that publicKeyBytes contains a byte array representing
            // your public key
            byte[] publicKeyBytes = Base64.decodeBase64(publicKey);
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);

            KeyFactory keyFactory;
            keyFactory = KeyFactory.getInstance(publicKeySpec.getFormat());
            Key key = keyFactory.generatePublic(publicKeySpec);

            // initialize your cipher
            asymmetricCipher.init(Cipher.DECRYPT_MODE, key);
            // asuming, cipherText is a byte array containing your encrypted message
            byte[] inputArray = Base64.decodeBase64(cipherText.getBytes(StandardCharsets.UTF_8.name()));

            byte[] plainText = asymmetricCipher.doFinal(inputArray);

            return Base64.encodeBase64(plainText).toString();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "";
    }

    public static Key getPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] publicKeyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);

        KeyFactory keyFactory;
        keyFactory = KeyFactory.getInstance("RSA");
        Key key = keyFactory.generatePublic(publicKeySpec);
        return key;
    }

    public static String decrypt(String cipherText) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, getPublicKey());
            return new String(cipher.doFinal(Base64.decodeBase64(cipherText)), "UTF-8");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
}
