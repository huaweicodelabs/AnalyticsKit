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

package com.huawei.importusersample.importuser;

import com.huawei.util.HttpClientUtil;
import com.huawei.util.ObjectMapperHolder;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Client for import user
 *
 * @since 2021-08-07
 */
public class ImportUserClient {
    private static final String HOST_PORT = "https://datacollector-dra.dt.hicloud.com";

    private static final String PATH = "/analytics/datacollection/import/user";

    public String importUser(ImportUserHeaders importUserHeaders, ImportUserReq importUserReq) {
        Map<String, String> headerMaps = new HashMap<>();
        headerMaps.put("Content-Type", importUserHeaders.getContentType());
        headerMaps.put("x-app-id", importUserHeaders.getAppId());
        headerMaps.put("x-product-id", importUserHeaders.getProductId());
        headerMaps.put("Authorization", importUserHeaders.getAuthorization());

        String jsonParams = ObjectMapperHolder.writeValue(importUserReq);
        String importUseRest = HttpClientUtil.doPost(HOST_PORT + PATH, jsonParams, headerMaps);
        if (StringUtils.isEmpty(importUseRest)) {
            importUseRest = "OK";
        }
        return importUseRest;
    }
}
