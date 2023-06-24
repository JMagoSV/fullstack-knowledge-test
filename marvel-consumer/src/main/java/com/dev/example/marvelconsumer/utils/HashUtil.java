package com.dev.example.marvelconsumer.utils;
import java.security.MessageDigest;

public class HashUtil {
    /**
     * 
     * @param text, text to hash
     * @param hashType MD5 or SHA1
     * @return hash in hashType response
     */
    public static String getHash(String text, HashType hashType) {
        try {
            MessageDigest md = MessageDigest.getInstance(hashType.toString());
            byte[] array = md.digest(text.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}