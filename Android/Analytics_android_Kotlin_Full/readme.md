# HMS AnalyticsKit Demo for Android


## Table of Contents

* [Introduction](#introduction)
* [Getting Started](#getting-started)
* [Installation](#installation)
* [Configuration ](#configuration )
* [Environment requirements](#environment-requirements)
* [Result](#result)
* [License](#license)


## Introduction
Hmsanalyticskitdemo provides an example of integrating HUAWEI Analytics Kit with an app. It illustrates how to collect predefined events and custom events to improve user engagement and user preference.
[Read more about Hianalytics](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/introduction-0000001050745149).

## Getting Started

For more development guidance, please refer to the links below:

[Development Guide](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/android-dev-process-0000001050163813).

[API References](https://developer.huawei.com/consumer/en/doc/development/HMSCore-References/android-api-analytics-overview-0000001051067140).

In this example, we demonstrate how to use the analytics SDK for Android by using the Gradle build system.

First download Hmsanalyticskitdemo by cloning this repository or downloading an archived snapshot.

In Android Studio, click Open an existing Android Studio project, and select "Analytics_android_Kotlin_Full".

You can use the gradlew build command to build the project directly.

You should create an app in AppGallery Connect, and obtain the agconnect-services.json file and add it to the project. You should also generate a signing certificate fingerprint and add the certificate file to the project, and add configuration to the build.gradle file.  More to [Development Process](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/android-dev-process-0000001050163813).


## Installation
Use Android Studio to open the decompressed project.

## Configuration
1. Create an app in AppGallery Connect and obtain the project configuration file agconnect-services.json. In Android Studio, switch to the Project view and move the agconnect-services.json file to the root directory of the app.
2. Change the value of applicationId in the build.gradle file of the app to the name of the app package applied for in the preceding step.

## Environment requirements
Hardware requirements:
1. A computer (desktop or laptop)
2. A Huawei phone, which is used to debug the developed app
  
Software requirements:
1. HUAWEI Analytics Kit 6.2.0
2. Android SDK applicable to devices using Android 4.3 Jelly Bean (API level 18) and later versions
3. Android Studio 
4. JDK version: 1.8 or later

## Result
After running the app you should see a screen like this:

<img src="./images/screen_0.PNG" height="534" width="300" style="max-width:100%;">

Click TRUE or FALSE to answer the question; Click NEXT to show the next question; Click POST SCORE, log the score user got. All the information will be uploaded to the Hianalytics Console, and you can see these information in real time using Debug View.

Click button SETTINGS:

<img src="./images/screen_1.PNG" height="534" width="300" style="max-width:100%;">

When you click SETTINGS, you will be asked for your favorite sport. Your choice will be logged by Hianalytics as a user attribute.

##  License
HmsAnalyticsKitDemo is licensed under the [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
