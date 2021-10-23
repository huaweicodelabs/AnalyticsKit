# 华为分析服务Android SDK 示例代码


## 目录

* [简介](#简介)
* [快速入门](#快速入门)
* [安装](#安装)
* [配置](#配置)
* [环境要求](#环境要求)
* [操作结果](#操作结果)
* [授权许可](#授权许可)


## 简介
AnalyticsKit HDC Demo提供了应用集成华为分析服务（HUAWEI Analytics Kit）的示例代码。指导开发者学会如何使用 HUAWEI Analytics Kit的主要接口，例如：“记录自定义事件”、“设置用户属性”等。
[了解更多有关AnalyticsKit的信息](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides/introduction-0000001050745149).

## 快速入门

更多开发指导，请参考以下链接文档：

[开发指南](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides/android-dev-process-0000001050163813).

[API参考](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-References/android-api-analytics-overview-0000001051067140).

AnalyticsKit HDC Demo以Gradle构建系统为例演示了如何使用Android分析服务SDK。

首先，我们通过克隆此仓库或下载压缩包的方式来下载AnalyticsKit HDC Demo。

在Android Studio中，点击“Open an existing Android Studio project”，选择“AnalyticsKitHDCDemo”。

您可以直接运行gradlew build命令构建工程。

您需要在AppGallery Connect中创建应用，获取agconnect-services.json文件，并将文件添加到项目中。 [进一步了解开发流程](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides/android-dev-process-0000001050163813).


## 安装
使用Android Studio打开解压后的工程。

## 配置
1. 在AppGallery Connect中创建应用，并获取项目配置文件agconnect-services.json。在Android Studio中，切换到Project视图，将agconnect-services.json文件移动到app的根目录下。 
2. 修改app的build.gradle文件中的applicationId为上一步申请的app包名。

## 环境要求
硬件要求：
1. 电脑（台式机或笔记本）
2. 华为手机，用于应用调试
  
软件要求：
1. 华为分析服务6.2.0
2. 适配Android API-Level 18（Android 4.3 Jelly Bean）及以上版本的设备
3. Android studio 3.6.1及以上版本 
4. Android Gradle插件 3.5.4及以上
5. JDK 1.8及以上

## 操作结果
开启调试模式。运行该app后，您将会看到如下页面：

<img src="images/screen_0.PNG" height="770" width="368" style="max-width:100%;">

数据成功上报后，“华为分析 > 应用调试”页面会展示出数据，如下图：

<img src="images/screen_1.png" height="415" width="827" style="max-width:100%;">

## 授权许可
AnalyticsKitHDCDemo经过[Apache 2.0授权许可](http://www.apache.org/licenses/LICENSE-2.0).

