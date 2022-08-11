# 华为分析服务QuickGame SDK示例代码

## 目录

* [简介](#简介)
* [快速入门](#快速入门)
* [安装](#安装)
* [配置](#配置)
* [环境要求](#环境要求)
* [示例代码](#示例代码)
* [授权许可](#授权许可)

## 简介

HmsAnalyticsKitDemo提供了华为分析服务（HUAWEI Analytics Kit）与快游戏集成的示例代码。其演示了如何通过收集预定义事件和自定义事件以提高用户参与度和用户偏好。
[了解更多有关Hianalytics的信息](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides/introduction-0000001050745149).

## 快速入门

更多开发指导，请参考以下链接文档：

[开发指南](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides/introduction-0000001050745149)。

[API参考](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-References/overview-0000001077819400)。

以HmsAnalyticsKitDemo为例演示了如何使用快游戏分析服务SDK。

1. 我们通过克隆此仓库或下载压缩包的方式来下载HmsAnalyticsKitDemo。

2. 打开 CocosDashboard 导入项目并配置项目开发环境。

    1. “Editor”分页选择下载所需 cocos-creator 版本。

    2. “Project”分页点击“Add”，选择“HmsAnalyticsKitDemo”。

    3. 打开导入的“HmsAnalyticsKitDemo”项目。

    4. 点击“文件”-“设置”，打开设置菜单并设置“数据编辑”和“原生开发环境”。

        1. “数据编辑”的“外部脚本编辑器”设置为 Visual Studio Code

        2. “原生开发环境”的“NDK路径”设置为 ndk 路径

        3. “原生开发环境”的“Android SDK路径”设置为 android sdk 路径

3. 引入sdk。下载并引入sdk，位于“assets/Lib”目录下。

    1. [hmscore-analytics-sdk-quickgame-xx.xx.xx.esm.js](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Library/quickapp-sdk-download-0000001090739375) 为sdk文件，引入并设置为“导入为插件”

    2. [agconnect-quickgame-xx.xx.xx-min.js](https://developer.huawei.com/consumer/cn/doc/development/AppGallery-connect-Library/agc-auth-quickgame-sdkdownload-0000001182308451) 为sdk依赖的agc文件，引入并设置为“导入为插件”

4. 构建和运行项目。

    1. 启动 HUAWEI QuickApp IDE，创建一个项目，点击“实时编译“进行项目调试，为手机安装“华为快应用加载器”，然后返回 CocosDashboard 。

    2. 点击菜单的“项目”-“构建发布...”按钮，打开“构建发布...”弹窗界面。

    3. “发布平台”选择“华为快游戏”之后，点击“构建”按钮，待构建完成后，点击“运行”按钮打开“快游戏调试工具”弹窗界面。

    4. 点击代表运行的▶按钮，运行工程。

    5. 如需查看日志信息，请在 HUAWEI QuickApp IDE 的“输出”面板查看手机日志信息。

您需要在AppGallery Connect中创建应用，获取agconnect-services.json文件，并将文件中的json数据赋值给Analytics.js文件的aGConnectServicesConfig变量。[进一步了解开发流程](https://developer.huawei.com/consumer/cn/doc/development/HMSCore-Guides/introduction-0000001050745149).

## 安装

1. 使用HUAWEI QuickGame IDE打开压缩项目，该示例共包含两个demo:
   1. hmsanalyticskitdemo: 已集成sdk的demo。
   2. hmsanalyticskitdemo-start: 未集成sdk的demo，你可以从这个demo开始尝试如何集成sdk

## 配置

在AppGallery Connect中创建应用，获取项目配置，并将项目配置添加到您的QuickGame项目。

## 环境要求

硬件要求：

1. 电脑（台式机或笔记本）
2. 一台android手机

软件要求：

1. [CocosDashboard](https://www.cocos.com/creator)
2. [Visual Studio Code](https://code.visualstudio.com/)，用于 CocosDashboard 配置“外部脚本编辑器”路径。
3. [Android SDK](https://www.androiddevtools.cn/)，用于 CocosDashboard 配置 Android SDK 路径。
4. [NDK](https://developer.android.google.cn/ndk/downloads)，用于 CocosDashboard 配置 NDK 路径。
5. [HUAWEI QuickApp IDE](https://developer.huawei.com/consumer/cn/quickApp-ide/)，用于为手机安装[华为快应用加载器](https://developer.huawei.com/consumer/cn/doc/development/quickApp-Guides/quickapp-installtool-0000001126543467)。
6. Codelab的示例代码
7. 终端/控制台

## 示例代码

运行该app后，您将会看到如下页面：

![screen_0](screenshot/screen_0.PNG)

点击“TRUE”或“FALSE”按钮进行答题；点击“POST SCORE”按钮记录用户获得的分数。所有信息将被上传到Hianalytics控制台，您可以通过实时监控来实时查看这些信息。

点击“SETTINGS”按钮：

![screen_1](screenshot/screen_1.PNG)

您将被要求提供最喜欢的运动。您的选择将作为用户属性记录到Hianalytics中。

## 授权许可

HmsAnalyticsKitDemo 经过 [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0) 许可。
