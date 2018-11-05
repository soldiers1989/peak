package com.masspick.peak.common.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * SignAndSend
 */
public final class SignAndSend {

    private SignAndSend() {
    }

    /**
     * CONTENT_CHARSET
     */
    private static final String CONTENT_CHARSET = "UTF-8";

    /**
     * HmacSHA1
     */
    private static final String HMAC_ALGORITHM = "HmacSHA1";

    /**
     * @param secret
     * @param timeStr
     * @return String
     * @throws NoSuchAlgorithmException     NoSuchAlgorithmException
     * @throws UnsupportedEncodingException UnsupportedEncodingException
     * @throws InvalidKeyException          InvalidKeyException
     */
    public static String sign(String secret, String timeStr)
            throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        //get signStr
        String signStr = "date: " + timeStr + "\n" + "source: " + "source";
        //get sig
        String sig = null;
        Mac mac1 = Mac.getInstance(HMAC_ALGORITHM);
        byte[] hash;
        SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(CONTENT_CHARSET), mac1.getAlgorithm());
        mac1.init(secretKey);
        hash = mac1.doFinal(signStr.getBytes(CONTENT_CHARSET));
        sig = new String(Base64.encodeBase64(hash));
        System.out.println("signValue--->" + sig);
        return sig;
    }

    /**
     * @param params
     * @return String
     */
    public static String sendGet(String params) {
        String url = "http://service-o8r5mg3p-1255468759.ap-shanghai.apigateway.myqcloud.com/release/phonecheck" + params;
        String secretId = "AKIDoEqL74aMz3nYwfZzWenHw6eirVFfgcWbfKls";
        String secretKey = "ABoZunkD7HewWNfT034U5mi8lv0rkNbt8yiFE7g2";
        String result = "";
        BufferedReader in = null;
        //get current GMT time
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String timeStr = sdf.format(cd.getTime());
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            HttpURLConnection httpUrlCon = (HttpURLConnection) connection;
            // 设置通用的请求属性
            httpUrlCon.setRequestProperty("Host", url);
            httpUrlCon.setRequestProperty("Accept", "text/html, */*; q=0.01");
            httpUrlCon.setRequestProperty("Source", "source");
            httpUrlCon.setRequestProperty("Date", timeStr);
            httpUrlCon.setRequestProperty("Charsert", "UTF-8");
            String sig = sign(secretKey, timeStr);
            String authen = "hmac id=\"" + secretId + "\", algorithm=\"hmac-sha1\", headers=\"date source\", signature=\"" + sig + "\"";
            System.out.println("authen --->" + authen);
            httpUrlCon.setRequestProperty("Authorization", authen);
            httpUrlCon.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            httpUrlCon.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");

            // 建立实际的连接
            httpUrlCon.connect();

            // 获取所有响应头字段
            Map<String, List<String>> map = httpUrlCon.getHeaderFields();

            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }

            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    httpUrlCon.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            // 使用finally块来关闭输入流
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
