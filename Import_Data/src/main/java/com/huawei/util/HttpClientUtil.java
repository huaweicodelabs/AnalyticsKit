/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
     http://www.apache.org/licenses/LICENSE-2.0
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.huawei.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HttpClientUtil
 *
 * @since 2020-05-28
 */
public class HttpClientUtil {

    private static final Log LOG = LogFactory.getLog(HttpClientUtil.class.getName());

    private static final CloseableHttpClient HTTP_CLIENT;

    public static final String CHARSET = "UTF-8";

    static {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();
        HTTP_CLIENT = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }

    public static String doPost(String url, Map<String, String> params) {
        return doPost(url, params, CHARSET, null);
    }

    public static String doPost(String url, String jsonParam, Map<String, String> headerMap) {
        return doPost(url, jsonParam, CHARSET, headerMap);
    }

    /**
     * HTTP Post
     *
     * @param url request url
     * @param jsonParams request params
     * @param charset charset
     * @return result
     */
    public static String doPost(String url, Map<String, String> jsonParams, String charset,
        Map<String, String> headerMap) {
        if (null == url || "".equals(url)) {
            return null;
        }
        List<NameValuePair> nameValuePairs = null;
        if (jsonParams != null && !jsonParams.isEmpty()) {
            nameValuePairs = new ArrayList<>(jsonParams.size());
            for (Map.Entry<String, String> entry : jsonParams.entrySet()) {
                String value = entry.getValue();
                if (value != null) {
                    nameValuePairs.add(new BasicNameValuePair(entry.getKey(), value));
                }
            }
        }
        HttpPost httpPost = setHeader(url, headerMap);
        try {
            if (nameValuePairs != null && nameValuePairs.size() > 0) {
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, CHARSET));
            }
            return getResult(httpPost);
        } catch (ParseException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * setHeader
     *
     * @param url
     * @param headerMap
     */
    private static HttpPost setHeader(String url, Map<String, String> headerMap) {
        HttpPost httpPost = new HttpPost(url);
        if (headerMap != null && !headerMap.isEmpty()) {
            for (Map.Entry<String, String> header : headerMap.entrySet()) {
                String value = header.getValue();
                if (value != null) {
                    httpPost.setHeader(header.getKey(), value);
                }
            }
        }
        return httpPost;
    }

    /**
     * getResult
     *
     * @param httpPost
     * @return String
     * @throws IOException
     */
    private static String getResult(HttpPost httpPost) throws Exception {
        CloseableHttpResponse response;
        response = HTTP_CLIENT.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            LOG.error("HttpClient,error status code :" + statusCode);
        }
        HttpEntity httpEntity = response.getEntity();
        String httpResult = null;
        if (httpEntity != null) {
            httpResult = EntityUtils.toString(httpEntity, "utf-8");
        }
        EntityUtils.consume(httpEntity);
        return httpResult;
    }

    /**
     * HTTP Post
     *
     * @param url request url
     * @param jsonParam request params
     * @param charset charset
     * @return result
     */
    public static String doPost(String url, String jsonParam, String charset, Map<String, String> headerMap) {
        if (null == url || "".equals(url)) {
            return "";
        }
        setHeader(url, headerMap);
        StringEntity requestEntity = new StringEntity(jsonParam, "utf-8");
        requestEntity.setContentEncoding("UTF-8");
        HttpPost httpPost = setHeader(url, headerMap);
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(requestEntity);
        try {
            return getResult(httpPost);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
