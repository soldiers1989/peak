package com.masspick.peak.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;


/**
 * DESUtils
 */
public final class DESUtils {
    private DESUtils() {
    }

    /**
     *
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DESUtils.class);

    /**
     * RADIX
     */
    private static final int RADIX = 16;

    /**
     * hexStr
     */
    private static final int HEXSTR = 0xff;

    /**
     * 解密数据
     *
     * @param message
     * @param key
     * @return String
     * @throws Exception Exception
     */
    public static String decrypt(String message, String key) throws Exception {
        byte[] byteKey = Arrays.copyOfRange(key.getBytes("UTF-8"), 0, 8);
        byte[] bytesrc = convertHexString(message);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(byteKey);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(byteKey);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] retByte = cipher.doFinal(bytesrc);
        return new String(retByte, "utf8");
    }

    /**
     * 加密数据
     *
     * @param message
     * @param key
     * @return byte
     * @throws Exception Exception
     */
    public static byte[] encrypt(String message, String key)
            throws Exception {
        byte[] byteKey = Arrays.copyOfRange(key.getBytes("UTF-8"), 0, 8);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(byteKey);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(byteKey);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        return cipher.doFinal(message.getBytes("UTF-8"));
    }

    /**
     * @return byte
     */
    public static byte[] convertHexString(String str) {
        byte[] digest = new byte[str.length() / 2];
        for (int i = 0; i < digest.length; i++) {
            String byteString = str.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, RADIX);
            digest[i] = (byte) byteValue;
        }

        return digest;
    }

    /**
     * 加密
     *
     * @param message
     * @param key
     * @return String
     * @throws Exception Exception
     */
    public static String encryptToString(String message, String key) throws Exception {
        byte[] byteKey = Arrays.copyOfRange(key.getBytes("UTF-8"), 0, 8);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(byteKey);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(byteKey);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        String messageURLEncoder = URLEncoder.encode(message, "UTF-8");
        return toHexString(cipher.doFinal(messageURLEncoder.getBytes("UTF-8")));
    }


    /**
     * 解密数据
     *
     * @param message
     * @param key
     * @return String
     * @throws Exception Exception
     */
    public static String decryptToString(String message, String key) throws Exception {
        byte[] byteKey = Arrays.copyOfRange(key.getBytes("UTF-8"), 0, 8);
        byte[] bytesrc = convertHexString(message);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(byteKey);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(byteKey);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] retByte = cipher.doFinal(bytesrc);
        return URLDecoder.decode(new String(retByte, "UTF-8"), "UTF-8");
    }

    /**
     * @param b
     * @return String
     */
    public static String toHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String plainText = Integer.toHexString(HEXSTR & b[i]);
            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }

        return hexString.toString();
    }

    /**
     * @param str
     * @return String
     */
    public static String getBase64(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = Base64.encodeBase64String(b);
        }
        return s;
    }

    /**
     * 解密
     *
     * @return String
     */
    public static String getFromBase64(String str) {
        byte[] b = null;
        String result = null;
        if (str != null) {
            try {
                b = Base64.decodeBase64(str);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return result;
    }

    /**
     * @param strSrc
     * @return String
     * @throws Exception Exception
     */
    public static String encryptSHA1(String strSrc) throws Exception {
        MessageDigest md = null;
        String strDes = null;

        byte[] bt = strSrc.getBytes("utf8");
        md = MessageDigest.getInstance("SHA-1");
        md.update(bt);
        strDes = toHexString(md.digest()); // to HexString
        return strDes;
    }
}
