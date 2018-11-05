package com.masspick.peak.common.util;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/29.
 */
public final class HttpRequestUtils {

    private HttpRequestUtils() {
    }

    /**
     * @param url
     * @return HttpEntity
     * @throws IOException IOException
     */
    public static HttpEntity requestGet(String url) throws IOException {
        return doGet(url, null);
    }

    /**
     * @param url
     * @param header
     * @return HttpEntity
     * @throws IOException IOException
     */
    public static HttpEntity requestGet(String url, Map<String, String> header) throws IOException {
        return doGet(url, header);
    }

    /**
     * @param url
     * @param params
     * @return HttpEntity
     * @throws IOException IOException
     */
    public static HttpEntity requestPost(String url, Map<String, String> params) throws IOException {
        return doPost(url, params, null);
    }

    /**
     * @param url
     * @param params
     * @param header
     * @return HttpEntity
     * @throws IOException IOException
     */
    public static HttpEntity requestPost(String url, Map<String, String> params, Map<String, String> header) throws IOException {
        return doPost(url, params, header);
    }

    /**
     * @param url
     * @param params
     * @return HttpEntity
     * @throws IOException IOException
     */
    public static HttpEntity requestPut(String url, Map<String, String> params) throws IOException {
        return doPut(url, params, null);
    }

    /**
     * @param url
     * @param params
     * @param header
     * @return HttpEntity
     * @throws IOException IOException
     */
    public static HttpEntity requestPut(String url, Map<String, String> params, Map<String, String> header) throws IOException {
        return doPut(url, params, header);
    }

    /**
     * @param url
     * @param header
     * @return HttpEntity
     * @throws IOException IOException
     */
    public static HttpEntity requestDelete(String url, Map<String, String> header) throws IOException {
        return doDelete(url, header);
    }

    /**
     * @param url
     * @return HttpEntity
     * @throws IOException IOException
     */
    public static HttpEntity requestDelete(String url) throws IOException {
        return doDelete(url, null);
    }

    /**
     * Get request
     *
     * @param url
     * @param params
     * @return HttpEntity
     * @throws UnsupportedEncodingException
     */
    private static HttpEntity doPost(String url, Map<String, String> params, Map<String, String> header) throws IOException {
        List<NameValuePair> nameValueParam = new ArrayList<NameValuePair>();
        if (params != null) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                nameValueParam.add(new BasicNameValuePair(key, params.get(key)));
            }
        }

        HttpPost httppost = new HttpPost(url);
        if (header != null) {
            Set<String> headerKeySet = header.keySet();
            for (String headerKey : headerKeySet) {
                httppost.addHeader(headerKey, header.get(headerKey));
            }
        }
        httppost.setEntity(new StringEntity(JacksonUtils.toJSon(params), ContentType.APPLICATION_JSON));
        return conn(httppost);
    }

    /**
     * @param url
     * @param header
     * @return HttpEntity
     * @throws IOException
     */
    private static HttpEntity doGet(String url, Map<String, String> header) throws IOException {
        HttpGet httpget = new HttpGet(url);
        if (header != null) {
            Set<String> headerKeySet = header.keySet();
            for (String headerKey : headerKeySet) {
                httpget.addHeader(headerKey, header.get(headerKey));
            }
        }
        return conn(httpget);
    }

    /**
     * @param url
     * @param params
     * @param header
     * @return HttpEntity
     * @throws IOException
     */
    private static HttpEntity doPut(String url, Map<String, String> params, Map<String, String> header) throws IOException {
        List<NameValuePair> nameValueParam = new ArrayList<>();
        if (params != null) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                nameValueParam.add(new BasicNameValuePair(key, params.get(key)));
            }
        }
        HttpPut httpPut = new HttpPut(url);
        if (header != null) {
            Set<String> headerKeySet = header.keySet();
            for (String headerKey : headerKeySet) {
                httpPut.addHeader(headerKey, header.get(headerKey));
            }
        }
        httpPut.setEntity(new StringEntity(JacksonUtils.toJSon(params), ContentType.APPLICATION_JSON));
        return conn(httpPut);
    }

    /**
     * @param url
     * @param header
     * @return HttpEntity
     * @throws IOException
     */
    private static HttpEntity doDelete(String url, Map<String, String> header) throws IOException {
        HttpDelete httpDelete = new HttpDelete(url);
        if (header != null) {
            Set<String> headerKeySet = header.keySet();
            for (String headerKey : headerKeySet) {
                httpDelete.addHeader(headerKey, header.get(headerKey));
            }
        }

        return conn(httpDelete);
    }

    /**
     * @param url
     * @param params
     * @return String
     * @throws UnsupportedEncodingException UnsupportedEncodingException
     */
    public static String buildUrl(String url, Map<String, String> params) throws UnsupportedEncodingException {

        //判断参数是否为空
        if (params != null && !params.isEmpty()) {
            StringBuffer urlwithParams = new StringBuffer();

            //判断请求url是否包含参数，如果包含参数就不拼接"?"
            if (!StringUtils.isEmpty(url) && !url.contains("?")) {
                urlwithParams.append('?');
            }
            for (String key : params.keySet()) {
                urlwithParams.append(key).append('=').append(params.get(key) == null ? "" : URLEncoder.encode(params.get(key), "UTF-8")).append('&');
            }
            return url + urlwithParams.substring(0, urlwithParams.length() - 1);
        }
        return url;
    }

    /**
     * @param httpMethod
     * @return HttpEntity
     * @throws IOException
     */
    private static HttpEntity conn(HttpRequestBase httpMethod) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpMethod);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                entity = new BufferedHttpEntity(entity);
            }
            return entity;
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }
}
