package com.elavon.setup;

import com.google.common.annotations.Beta;

import javax.crypto.Cipher;
import java.io.*;
import java.security.*;
import java.util.Base64;

import static com.elavon.setup.Application.CONFIG;

@Beta
public class CredentialKey {

    private static KeyPair keyPair;
    private static PublicKey pubKey;
    private static PrivateKey privateKey;

    public static void main(String[] args) throws Exception {

        String configProperty = "credentials.qa.internal.password";
//        String pathname = CONFIG.getString("credential.src") + configProperty +".txt";
//        String message = "";
//
//        generate(configProperty, message);
//
        String s = retrieve(configProperty);
        System.out.println(s);
    }

    public static void generate(String configPropertyName, String stringToEncrypt) throws Exception {
        keyPair = buildKeyPair();
        pubKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();

        String encrypted = Base64.getEncoder().encodeToString(encrypt(privateKey, stringToEncrypt));
        CONFIG.setProperty(configPropertyName, encrypted);
        CONFIG.save();

        String objFileName = CONFIG.getString("credentials.src") + "/" + configPropertyName + ".txt";
        FileOutputStream f = new FileOutputStream(new File(objFileName));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(pubKey);
        o.close();
        f.close();
    }

    public static String retrieve(String configPropertyName) throws Exception {
        byte[] decrypted = Base64.getDecoder().decode(CONFIG.getString(configPropertyName).getBytes());

        String objFileName = CONFIG.getString("credentials.src") + "/" + configPropertyName + ".txt";
        FileInputStream fi = new FileInputStream(new File(objFileName));
        ObjectInputStream oi = new ObjectInputStream(fi);
        pubKey = (PublicKey) oi.readObject();
        oi.close();
        fi.close();

        byte[] retrievedValue = decrypt(pubKey, decrypted);
        return new String(retrievedValue);
    }

    public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
        final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);
        return keyPairGenerator.genKeyPair();
    }

    public static byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(message.getBytes());
    }

    public static byte[] decrypt(PublicKey publicKey, byte [] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(encrypted);
    }
}
