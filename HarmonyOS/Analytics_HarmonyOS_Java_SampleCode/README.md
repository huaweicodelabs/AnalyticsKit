# AnalyticsKit Demo


## Table of Contents

* [Introduction](#introduction)
* [Getting Started](#getting-started)
* [Installation](#installation)
* [Configuration ](#configuration )
* [Supported Environments](#supported-environments)
* [Result](#result)
* [License](#license)


## Introduction
AnalyticsKitDemo is a app that applying HUAWEI Analytics Kit SDK used for showing how to collect user engagement and user preference.
[Read more about Analytics Kit](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/introduction-0000001050745149).

## Getting Started

For more development guidance, please refer to the links below:

[Development Guide](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/introduction-0000001050745149).

[API References](https://developer.huawei.com/consumer/en/doc/development/HMSCore-References/overview-0000001077819400).

We also provide an example to demonstrate the use of analytics SDK for HarmonyOS.

This sample uses the Gradle build system.

First download the demo by cloning this repository or downloading an archived snapshot.

In HUAWEI DevEco Studio, use the `Open Project`, and select the directory of `Analytics_HarmonyOS_Java_SampleCode`.

You can use the `gradle build` command to build the project directly.

You should create an app in AppGallery Connect, and obtain the file of `agconnect-services.json` and add to the project. You should also generate a signing certificate fingerprint and add the certificate file to the project, and add configuration to build.gradle. More to [Development Process](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/introduction-0000001050745149).


## Installation
    1. Extracting sample code to the src directory
       a. Copying Code files
       b. Copying resource files
    2. Modifying config.json
    3. Modifying MainAbilitySlice Class
    4. Modifying SettingAbilitySlice Class

## Configuration
    1. Add the AppGallery Connect configuration file of the current Hap to your HUAWEI DevEco Studio.
    Create an app in AppGallery Connect and obtain the project configuration file agconnect-services.json. In HUAWEI DevEco Studio, switch to the Project view and move the agconnect-services.json file to the root directory of the entry module.
    2. Add the dependency of the agconnect service on the main project gradle.
    3. Add the plug-in configuration on the gradle of the entry module.
    4. Click Sync now to build a project.

## Supported Environments
    Hardware requirements:
    1. A computer (desktop or laptop)
    2. A Huawei phone, which is used to debug the developed Hap

    Software requirements:
    1. HUAWEI Analytics Kit 6.2.0
    2. HarmonyOS SDK applicable to devices using HarmonyOS 2.0.0 (API level 4) and later versions
    3. HUAWEI DevEco Studio
    4. JDK version: 1.8 or later

## Result
After running the Hap you should see a screen like this:

<img src="./images/screen_0.PNG" height="650" width="313" style="max-width:100%;">

Click the button True or False to answer the question; Click the Next, show the next question; Click Post Score, log the score user got. All the infomations will be upload to Analytics Kit Console, and you can see these infomations in real time using Debug View.

Click button Settings:

<img src="./images/screen_1.PNG" height="650" width="313" style="max-width:100%;">

You will be asked what your favorite sport is. This choice will be logged to Analytics Kit as a User Property.


##  License
    AnalyticsKitDemo is licensed under the [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
