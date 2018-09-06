package com.elavon.setup;

import com.google.common.annotations.Beta;
import org.apache.commons.configuration.PropertiesConfiguration;

import javax.crypto.Cipher;
import java.io.*;
import java.security.*;
import java.util.Base64;
import java.util.ResourceBundle;

@Beta
public class CredentialKey {

    private static KeyPair keyPair;
    private static PublicKey pubKey;
    private static PrivateKey privateKey;
    private static PropertiesConfiguration config;
    private static final String configPath = "config.properties";

    public static void main(String[] args) {

        ResourceBundle config = ResourceBundle.getBundle("config");
//        String configProperty = "credentials.qa.internal.username";
//        String pathname = config.getString("credential.src") + configProperty +".txt";
//        String message = "";
//
//        generate(configProperty, message, pathname);
//
//        String s = retrieve(configProperty, pathname);
//        System.out.println(s);
    }

    public static void generate(String configProperty, String message, String pathname) throws Exception {
        keyPair = buildKeyPair();
        pubKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
        config = new PropertiesConfiguration(configPath);

        String encrypted = Base64.getEncoder().encodeToString(encrypt(privateKey, message));
        config.setProperty(configProperty, encrypted);
        config.save();

        FileOutputStream f = new FileOutputStream(new File(pathname));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(pubKey);
        o.close();
        f.close();
    }

    public static String retrieve(String configProperty, String pathname) throws Exception {
        config = new PropertiesConfiguration(configPath);
        byte[] decrypted = Base64.getDecoder().decode(config.getString(configProperty).getBytes());

        FileInputStream fi = new FileInputStream(new File(pathname));
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
