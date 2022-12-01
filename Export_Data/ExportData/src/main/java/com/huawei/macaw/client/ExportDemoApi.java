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

package com.huawei.macaw.client;

import com.huawei.macaw.client.util.ObjectMapperHolder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @since 2020-05-28
 */

public class ExportDemoApi {

    private final static Log LOG = LogFactory.getLog(ExportDemoApi.class.getName());

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static String tokenUri = "https://oauth-login.cloud.huawei.com/oauth2/v2/token";

    private String clientSecret = "please input your clientSecret";

    private String clientId = "101957209";

    private String grantType = "client_credentials";

    private String productId = "9105385871708612208";

    private String createRawDataExportTaskUri =
        "https://datacollector-dra.dt.hicloud.com/analytics/export/raw_data_requests/v2";

    private String startDate = "2020-8-10";

    private String endDate = "2020-8-11";

    private String fileFormat = "csv";

    /**
     * get token info.
     * @return GetTokenResp
     */
    private GetTokenResp getToken() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("client_id", clientId);
        params.put("client_secret", clientSecret);
        params.put("grant_type", grantType);
        String tokenResult = HttpClientUtil.doPost(tokenUri, params);
        GetTokenResp tokenResp = null;
        try {
            tokenResp = OBJECT_MAPPER.readValue(tokenResult, GetTokenResp.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return tokenResp;
    }

    /**
     * build header.
     * @return Map
     */
    private Map<String, String> buildHeader() {
        GetTokenResp tokenResp = getToken();
        String authorization = tokenResp.getTokenType() + " " + tokenResp.getAccessToken();
        Map<String, String> headerMaps = new HashMap<String, String>();
        headerMaps.put(HttpHeaders.AUTHORIZATION, authorization);
        headerMaps.put(HttpHeaders.CONTENT_TYPE, "application/json");
        headerMaps.put("x-app-id", clientId);
        headerMaps.put("x-product-id", productId);
        return headerMaps;
    }

    /**
     * create rawData export task
     * @return
     */
    private void createRawDataExportTask() {
        Map<String, String> headerMaps = buildHeader();
        DateRange dateRange = new DateRange();
        dateRange.setStartExportDataDate(startDate);
        dateRange.setEndExportDataDate(endDate);
        RawDataExportTaskReq req = new RawDataExportTaskReq();
        req.setDateRange(dateRange);
        req.setFileFormat(fileFormat);
        req.setFilters(new ArrayList());
        String jsonParams = ObjectMapperHolder.writeValue(req);
        String result = HttpClientUtil.doPost(createRawDataExportTaskUri, jsonParams, headerMaps);
        LOG.info("result : " + result);
    }

    /**
     * main function
     * @return
     */
    public static void main(String[] args) {
       ExportDemoApi api = new ExportDemoApi();
       api.createRawDataExportTask();
    }
}
