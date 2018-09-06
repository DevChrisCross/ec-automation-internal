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
    private static final String CONFIG_PROPERTIES = "config.properties";

    public static void main(String[] args) throws Exception {

        ResourceBundle config = ResourceBundle.getBundle("config");
        String configProperty = "credentials.qa.internal.password";
//        String pathname = config.getString("credential.src") + configProperty +".txt";
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
        config = new PropertiesConfiguration(CONFIG_PROPERTIES);

        String encrypted = Base64.getEncoder().encodeToString(encrypt(privateKey, stringToEncrypt));
        config.setProperty(configPropertyName, encrypted);
        config.save();

        String objFileName = config.getString("credentials.src") + "/" + configPropertyName +".txt";
        FileOutputStream f = new FileOutputStream(new File(objFileName));
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(pubKey);
        o.close();
        f.close();
    }

    public static String retrieve(String configPropertyName) throws Exception {
        config = new PropertiesConfiguration(CONFIG_PROPERTIES);
        byte[] decrypted = Base64.getDecoder().decode(config.getString(configPropertyName).getBytes());

        String objFileName = config.getString("credentials.src") + "/" + configPropertyName +".txt";
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
