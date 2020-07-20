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
using System.Globalization;

using Android.App;
using Android.OS;
using Android.Support.V7.App;
using Android.Runtime;
using Android.Widget;
using Android.Content;
using Android.Views;
using Android.Util;

using Com.Huawei.Hms.Analytics;
using Com.Huawei.Hms.Analytics.Type;
using Com.Huawei.Agconnect.Config;

namespace XamarinHmsHiAnalyticsDemo
{
    [Activity(Label = "@string/app_name", Theme = "@style/AppTheme", MainLauncher = true)]
    public class MainActivity : AppCompatActivity, View.IOnClickListener
    {
        public static readonly string TAG = "MainActivity";

        private int[] questions = { Resource.String.q1, Resource.String.q2, Resource.String.q3, Resource.String.q4, Resource.String.q5 };
        private bool[] answers = { true, true, false, false, true };

        private int curQuestionIdx = 0;

        private TextView txtQuestion;

        private int score = 0;

        HiAnalyticsInstance instance;

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);
            // Xamarin.Essentials.Platform.Init(this, savedInstanceState);
            // Set our view from the "main" layout resource
            SetContentView(Resource.Layout.activity_main);

            // Enable Analytics Kit Log
            HiAnalyticsTools.EnableLog();

            // Generate the Analytics Instance
            instance = HiAnalytics.GetInstance(this);

            // You can also use Context initialization
            // Context context = this.getApplicationContext();
            // instance = HiAnalytics.getInstance(context);

            // Enable collection capability
            instance.SetAnalyticsEnabled(true);

            // Registering the HMS Service
            // Register the HMS service and collect automatic events (account event or InAppPurchase event, etc.).
            instance.RegHmsSvcEvent();

            txtQuestion = (TextView)FindViewById(Resource.Id.question_text_view);
            txtQuestion.SetText(questions[curQuestionIdx]);

            FindViewById(Resource.Id.setting_button).SetOnClickListener(this);
            FindViewById(Resource.Id.next_button).SetOnClickListener(this);
            FindViewById(Resource.Id.true_button).SetOnClickListener(this);
            FindViewById(Resource.Id.false_button).SetOnClickListener(this);
            FindViewById(Resource.Id.post_score_button).SetOnClickListener(this);
        }

        public override void OnRequestPermissionsResult(int requestCode, string[] permissions, [GeneratedEnum] Android.Content.PM.Permission[] grantResults)
        {
            Xamarin.Essentials.Platform.OnRequestPermissionsResult(requestCode, permissions, grantResults);

            base.OnRequestPermissionsResult(requestCode, permissions, grantResults);
        }


        public void OnClick(View v)
        {
            try
            {
                switch (v.Id)
                {
                    case Resource.Id.setting_button:
                        Intent i = new Intent(this, typeof(SettingActivity));
                        StartActivityForResult(i,0);
                        break;
                    case Resource.Id.next_button:
                        curQuestionIdx = (curQuestionIdx + 1) % questions.Length;
                        NextQuestion();
                        break;
                    case Resource.Id.true_button:
                        CheckAnswer(true);
                        ReportAnswerEvt("true");
                        break;
                    case Resource.Id.false_button:
                        CheckAnswer(false);
                        ReportAnswerEvt("false");
                        break;
                    case Resource.Id.post_score_button:
                        PostScore();
                        break;
                    default:
                        break;
                }
            }
            catch (Exception e)
            {
                Log.Error(TAG, "MainActivity Exception:" + e.Message);
            }
        }

        protected override void OnDestroy()
        {
            base.OnDestroy();
            // UnRegistering the HMS Service
            instance.UnRegHmsSvcEvent();
        }

        private void NextQuestion()
        {
            txtQuestion.SetText(questions[curQuestionIdx]);
        }

        private bool CheckAnswer(bool answer)
        {
            if (answer == answers[curQuestionIdx])
            {
                score += 20;
                Toast.MakeText(this, Resource.String.correct_answer, ToastLength.Short).Show();

            }
            else
            {
                Toast.MakeText(this, Resource.String.wrong_answer, ToastLength.Short).Show();
            }
            return answers[curQuestionIdx];
        }

        private void ReportAnswerEvt(String answer)
        {
            // Initiate Parameters
            Bundle bundle = new Bundle();
            bundle.PutString("question", txtQuestion.Text.Trim());
            bundle.PutString("answer", answer);
            CultureInfo culture = new CultureInfo("tr-TR");
            // Get current UTC time.   
            DateTime utcDate = DateTime.UtcNow;
            // Change time to match GMT + 3.
            DateTime gmt1Date = TimeZoneInfo.ConvertTimeBySystemTimeZoneId(utcDate, TimeZoneInfo.Local.Id);
            // Output the GMT+3 time in our specified format using the TR-culture. 
            string strDate = gmt1Date.ToString("yyyy-MM-dd HH:mm:ss", culture);
            bundle.PutString("answerTime", strDate);

            // Report a preddefined Event
            instance.OnEvent("Answer", bundle);
        }

        private void PostScore()
        {
            // TODO: Report score by using SUBMITSCORE Event
            // Initiate Parameters
            Bundle bundle = new Bundle();
            bundle.PutLong(HAParamType.Score, score);

            // Report a preddefined Event
            instance.OnEvent(HAEventType.Submitscore, bundle);
        }
    }
}