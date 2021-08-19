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

package com.huawei.token;

import com.huawei.util.HttpClientUtil;
import com.huawei.util.ObjectMapperHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * GetAuthTokenClient
 *
 * @since 2021-08-07
 */
public class GetAuthTokenClient {
    private static String HOST_PORT = "https://oauth-login.cloud.huawei.com";

    private static String PATH = "/oauth2/v2/token";

    public AuthTokenResult authAuthToken(AuthTokenRequest authTokenRequest) {
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", authTokenRequest.getGrantType());
        params.put("client_id", String.valueOf(authTokenRequest.getClientId()));
        params.put("client_secret", authTokenRequest.getClientSecret());

        //使用方式：
        String authAuthRest = HttpClientUtil.doPost(HOST_PORT + PATH, params);
        AuthTokenResult authTokenResult = ObjectMapperHolder.readValue(authAuthRest, AuthTokenResult.class);
        return authTokenResult;
    }
}
