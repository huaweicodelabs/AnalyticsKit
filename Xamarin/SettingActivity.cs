/*
*       Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.

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
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Support.V7.App;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Android.Util;

using Com.Huawei.Hms.Analytics;
using Com.Huawei.Hms.Analytics.Type;

namespace XamarinHmsHiAnalyticsDemo
{
    [Activity(Label = "SettingActivity")]
    public class SettingActivity : AppCompatActivity, View.IOnClickListener
    {
        public static readonly string TAG = "MainActivity";

        private EditText editFavorSport;
        private string strFavorSport;

        HiAnalyticsInstance instance;

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            SetContentView(Resource.Layout.activity_setting);
            // Create your application here

            instance = HiAnalytics.GetInstance(this);

            FindViewById(Resource.Id.save_setting_button).SetOnClickListener(this);
        }

        public void OnClick(View v)
        {
            try
            {
                switch (v.Id)
                {
                    case Resource.Id.save_setting_button:
                        editFavorSport = (EditText)FindViewById(Resource.Id.edit_favorite_sport);
                        strFavorSport = editFavorSport.Text.Trim();
                        instance.SetUserProfile("favor_sport", strFavorSport);
                        break;
                    default:
                        break;
                }
            }
            catch (Exception e)
            {
                Log.Error(TAG, "SettingActivity Exception:" + e.Message);
            }
        }
    }
}