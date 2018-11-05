package com.masspick.peak.common.util;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * post 请求有文件上传和其他参数
 */
public final class SendHttpPost {

    private SendHttpPost() {
    }

    /**
     * @param serverUrl
     * @param fileParamName
     * @param file
     * @param params
     * @return String
     * @throws ClientProtocolException ClientProtocolException
     * @throws IOException             IOException
     */
    public static String post(String serverUrl, String fileParamName, File file, Map<String, String> params)
            throws ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost(serverUrl);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        // 上传的文件
        builder.addBinaryBody(fileParamName, file);
        // 设置其他参数
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.addTextBody(entry.getKey(), entry.getValue(), ContentType.TEXT_PLAIN.withCharset("UTF-8"));
        }
        HttpEntity httpEntity = builder.build();
        httpPost.setEntity(httpEntity);
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(httpPost);
        if (null == response || response.getStatusLine() == null) {
            System.out.println("Post Request For Url[{}] is not ok. Response is null" + serverUrl);
            return null;
        } else if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            System.out.println("Post Request For Url[{}] is not ok. Response Status Code is {}" + serverUrl
                    + response.getStatusLine().toString());
            return null;
        }
        return EntityUtils.toString(response.getEntity(), "UTF-8");
    }

    /*public static void main(String[] args) {
        String url = "http://180.169.1.10:9985/Core3Zither/winchampiond13/comService/getComGsData";
        String fileUrl = "C:/Users/Administrator/Desktop/1_yuruixin_china.jpg";
        Map<String, String> map = new HashMap<String, String>();
        map.put("channel", "bhjz");
        map.put("userName", "bhjz");
        map.put("cname", "新余和胜实业有限公司");
        map.put("sign", "54F30B85145DB3FDDEEBA770F21EE5E4");
        map.put("taxNo", "91360502MA35JE9Y4Q");
        map.put("areaCode", "36");
        map.put("legalName", "王小马");
        map.put("legalIdCard", "330102197804281511");
        map.put("mobile", "13588080975");
        map.put("startDate", "2017-05-01");
        map.put("endDate", "2018-05-01");
        try {
            System.out.println(new SendHttpPost().post(url, "file", new File(fileUrl), map));
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
