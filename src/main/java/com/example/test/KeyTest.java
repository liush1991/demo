package com.example.test;

import java.security.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class KeyTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Map m= randomKeyPair();

    }
    public static HashMap<String, String> randomKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();

        if (null == pair) {

            return null;

        }

        PrivateKey pvt = pair.getPrivate();

        PublicKey pub = pair.getPublic();

        System.out.println(pub);
        System.out.println(pvt);
        Base64.Encoder encoder = Base64.getEncoder();
        String pvtVal = encoder.encodeToString(pvt.getEncoded());

        String pubVal = encoder.encodeToString(pub.getEncoded());

        HashMap<String, String> rsaKeyMap = new HashMap<>(2);


        rsaKeyMap.put("privateKeyBase64", pvtVal);

        rsaKeyMap.put("publicKeyBase64", pubVal);

        return rsaKeyMap;

    }
}
