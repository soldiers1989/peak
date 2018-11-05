package com.masspick.peak.common.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;

/**
 * AES 加密算法
 */
public final class AES {



    /**
     * 私有构造函数
     */
    private AES() {
    }


    /**
     * 算法名
     */
    public static final String KEY_NAME = "AES";

    /**
     * 加密算法的长度
     */
    public static final int AES_128 = 128;

    /**
     * 加解密算法/模式/填充方式
     * ECB模式只用密钥即可对数据进行加密解密，CBC模式需要添加一个iv
     */
    public static final String CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";

    /**
     * 微信 数据解密<br/>
     * 对称解密使用的算法为 AES-128-CBC，数据采用PKCS#7填充<br/>
     * 对称解密的目标密文:encrypted=Base64_Decode(encryptData)<br/>
     * 对称解密秘钥:key = Base64_Decode(session_key),aeskey是16字节<br/>
     * 对称解密算法初始向量:iv = Base64_Decode(iv),同样是16字节<br/>
     *
     * @param encrypted   目标密文
     * @param sessionKey 会话ID
     * @param iv          加密算法的初始向量
     * @return String
     */
    public static String wxDecrypt(String encrypted, String sessionKey, String iv) {
        String json = null;
        byte[] encrypted64 = Base64.decodeBase64(encrypted);
        byte[] key64 = Base64.decodeBase64(sessionKey);
        byte[] iv64 = Base64.decodeBase64(iv);
        byte[] data;
        try {
            init();
            json = new String(decrypt(encrypted64, key64, generateIV(iv64)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }


    /**
     *  初始化密钥
     * @throws Exception 加密异常
     */
    public static void init() throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        KeyGenerator.getInstance(KEY_NAME).init(AES_128);
    }


    /**
     * 生成iv
     * @param iv byte[]
     * @return AlgorithmParameters
     * @throws Exception 加密异常
     */
    public static AlgorithmParameters generateIV(byte[] iv) throws Exception {
        // iv 为一个 16 字节的数组，这里采用和 iOS 端一样的构造方法，数据全为0
        // Arrays.fill(iv, (byte) 0x00);
        AlgorithmParameters params = AlgorithmParameters.getInstance(KEY_NAME);
        params.init(new IvParameterSpec(iv));
        return params;
    }


    /**
     * @param encryptedData 待加密数据
     * @param keyBytes 密钥
     * @param iv 算法
     * @return byte[]
     * @throws Exception 加密异常
     */
    public static byte[] decrypt(byte[] encryptedData, byte[] keyBytes, AlgorithmParameters iv)
            throws Exception {
        Key key = new SecretKeySpec(keyBytes, KEY_NAME);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        // 设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        return cipher.doFinal(encryptedData);
    }
}
