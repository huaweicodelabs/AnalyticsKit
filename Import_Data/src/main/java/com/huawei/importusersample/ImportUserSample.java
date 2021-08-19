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

/**
 * Call user to import data case
 *
 * @since 2021-08-07
 */
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
     * Get the AuthToken interface request header
     *
     * @return header
     */
    private static AuthTokenRequest getAuthTokenRequest() {
        AuthTokenRequest authTokenRequest = new AuthTokenRequest();
        // grant_type fixed without moving
        authTokenRequest.setGrantType("client_credentials");
        // The value is the Client Id of the application
        authTokenRequest.setClientId(101760787);
        // The value is the Client Secret of the application
        authTokenRequest.setClientSecret("c7fd133a9116fab4f26a87151beb45fd4c6ac327b5e69e68d898b5cd59e7370a");
        return authTokenRequest;
    }

    /**
     * Get user attribute import interface request header
     *
     * @return header
     */
    private static ImportUserHeaders getImportUserHeaders(AuthTokenResult authTokenResult) {
        ImportUserHeaders importUserHeaders = new ImportUserHeaders();
        // ContentType fixed without moving
        importUserHeaders.setContentType("application/json;charset=UTF-8");
        // User's App ID on AppGallery Connect
        importUserHeaders.setAppId("99329601347532139");
        // User's Product ID on AppGallery Connect
        importUserHeaders.setProductId("401957453638926878");
        importUserHeaders.setAuthorization(authTokenResult.getTokenType() + " " + authTokenResult.getAccessToken());
        return importUserHeaders;
    }

    /**
     * Get user attribute import interface body parameter
     *
     * @return body
     */
    private static ImportUserReq getImportUserReq() {
        UserPropertyPojo userPropertyPojo1 = new UserPropertyPojo();
        // The ID of the user attribute is a combination of numbers, letters, and underscores, and cannot start with a number, with 1-256 characters. For example: favorite_sport
        userPropertyPojo1.setId("dasd1111111111");
        // User attribute value, 1-256 characters. For example: football
        userPropertyPojo1.setValue("value1");
        UserPropertyPojo userPropertyPojo2 = new UserPropertyPojo();
        userPropertyPojo2.setId("dasd22222221");
        userPropertyPojo2.setValue("value2");
        List<UserPropertyPojo> userPropertyPojos = new LinkedList<>();
        userPropertyPojos.add(userPropertyPojo1);
        userPropertyPojos.add(userPropertyPojo2);

        UserDataPojo userDataPojo = new UserDataPojo();
        // User ID, 1-256 characters
        userDataPojo.setId("1");
        userDataPojo.setProperties(userPropertyPojos);
        // UserDataSet
        List<UserDataPojo> userDataPojos = new LinkedList<>();
        userDataPojos.add(userDataPojo);

        ImportUserReq importUserReq = new ImportUserReq();
        importUserReq.setDataType(1);
        importUserReq.setUserDataSet(userDataPojos);
        return importUserReq;
    }
}
