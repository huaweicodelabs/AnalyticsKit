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

package com.huawei.importusersample;

import com.huawei.importusersample.importuser.ImportUserClient;
import com.huawei.importusersample.importuser.ImportUserHeaders;
import com.huawei.importusersample.importuser.ImportUserReq;
import com.huawei.importusersample.importuser.UserDataPojo;
import com.huawei.importusersample.importuser.UserPropertyPojo;
import com.huawei.token.AuthTokenRequest;
import com.huawei.token.AuthTokenResult;
import com.huawei.token.GetAuthTokenClient;

import java.util.LinkedList;
import java.util.List;

public class ImportUserSample {
    public static void main(String[] args) {
        AuthTokenRequest authTokenRequest = getAuthTokenRequest();
        GetAuthTokenClient getAuthTokenClient = new GetAuthTokenClient();
        AuthTokenResult authTokenResult = getAuthTokenClient.authAuthToken(authTokenRequest);

        ImportUserReq importUserReq = getImportUserReq();
        ImportUserHeaders importUserHeaders = getImportUserHeaders(authTokenResult);
        ImportUserClient importUserClient = new ImportUserClient();
        String importUserResponse = importUserClient.importUser(importUserHeaders, importUserReq);
        System.out.println(importUserResponse);
    }

    /**
     * 获取AuthToken接口请求头
     *
     * @return 请求头信息
     */
    private static AuthTokenRequest getAuthTokenRequest() {
        AuthTokenRequest authTokenRequest = new AuthTokenRequest();
        // grant_type 固定不用动
        authTokenRequest.setGrantType("client_credentials");
        // 对于AppGallery Connect类应用，该值为应用的Client Id
        authTokenRequest.setClientId(101760787);
        // 对于AppGallery Connect类应用，该值为应用的Client Secret
        authTokenRequest.setClientSecret("c7fd133a9116fab4f26a87151beb45fd4c6ac327b5e69e68d898b5cd59e7370a");
        return authTokenRequest;
    }

    /**
     * 获取用户属性导入接口请求头
     *
     * @return 请求头信息
     */
    private static ImportUserHeaders getImportUserHeaders(AuthTokenResult authTokenResult) {
        ImportUserHeaders importUserHeaders = new ImportUserHeaders();
        // ContentType 固定不用动
        importUserHeaders.setContentType("application/json;charset=UTF-8");
        // 用户在AppGallery Connect上的App ID
        importUserHeaders.setAppId("99329601347532139");
        // 用户在AppGallery Connect上的Product ID
        importUserHeaders.setProductId("401957453638926878");
        importUserHeaders.setAuthorization(authTokenResult.getTokenType() + " " + authTokenResult.getAccessToken());
        return importUserHeaders;
    }

    /**
     * 获取用户属性导入接口body参数
     *
     * @return body参数信息
     */
    private static ImportUserReq getImportUserReq() {
        // 用户属性
        UserPropertyPojo userPropertyPojo1 = new UserPropertyPojo();
        // 用户属性的ID，由数字、字母、下划线组合成，且不能以数字开头，1-256个字符。例如：favorite_sport
        userPropertyPojo1.setId("dasd1111111111");
        // 用户属性值，1-256个字符。例如：football
        userPropertyPojo1.setValue("value1");

        UserPropertyPojo userPropertyPojo2 = new UserPropertyPojo();
        userPropertyPojo2.setId("dasd22222221");
        userPropertyPojo2.setValue("value2");

        // 用户属性列表
        List<UserPropertyPojo> userPropertyPojos = new LinkedList<>();
        userPropertyPojos.add(userPropertyPojo1);
        userPropertyPojos.add(userPropertyPojo2);

        UserDataPojo userDataPojo = new UserDataPojo();
        // 用户ID，1-256个字符
        userDataPojo.setId("1");
        // 用户属性列表。
        userDataPojo.setProperties(userPropertyPojos);

        // UserDataSet数据
        List<UserDataPojo> userDataPojos = new LinkedList<>();
        userDataPojos.add(userDataPojo);

        // 请求参数
        ImportUserReq importUserReq = new ImportUserReq();
        // 自定义用户属性的数据类型
        importUserReq.setDataType(1);
        // 待导入的用户及属性列表
        importUserReq.setUserDataSet(userDataPojos);
        return importUserReq;
    }
}
