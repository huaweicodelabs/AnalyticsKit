/*
 * Copyright 2021. Huawei Technologies Co., Ltd. All rights reserved.

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

package com.huawei.hms.analyticskitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// TODO: import classes from Analytics Kit
import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.analytics.HiAnalyticsTools;
import com.huawei.hms.analytics.type.HAEventType;
import com.huawei.hms.analytics.type.HAParamType;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Initiate Analytics Kit
        // Enable Analytics Kit Log
        HiAnalyticsTools.enableLog();
        // Generate the Analytics Instance
        HiAnalyticsInstance instance = HiAnalytics.getInstance(this);


        // TODO: Report a predefined event
        Bundle bundle_pre = new Bundle();
        bundle_pre.putString(HAParamType.PRODUCTID, "item_ID");
        bundle_pre.putString(HAParamType.PRODUCTNAME, "name");
        bundle_pre.putString(HAParamType.CATEGORY, "category");
        bundle_pre.putLong(HAParamType.QUANTITY, 100L);
        bundle_pre.putDouble(HAParamType.PRICE, 10.01);
        bundle_pre.putDouble(HAParamType.REVENUE, 10.01);
        bundle_pre.putString(HAParamType.CURRNAME, "currency");
        bundle_pre.putString(HAParamType.PLACEID, "location_ID");
        instance.onEvent(HAEventType.ADDPRODUCT2WISHLIST, bundle_pre);


        // TODO: Call the setUserProfile method to set user attributes
        instance.setUserProfile("userKey","value");
    }
}