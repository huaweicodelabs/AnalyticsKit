## Import_Data_CodeLab


## Table of Contents

 * [Introduction](#introduction)
 * [Installation](#installation)
 * [Configuration ](#configuration )
 * [Supported Environments](#supported-environments)
 * [Sample Code](# Sample Code)
 * [License](#license)


## Introduction
The sample code introduces a demo for your task to import user properties. It provides a main function ImportUserSample to perofrm the demo.

## Installation
Before using sample code, check whether the JDK environment and Maven environment have been installed. 

Open the project with tools with IDEA and configure the settings of Maven environment for sample code to download packages of references.

## Supported Environments
JDK 1.8 or a later version is recommended.
Maven 3.6 or a later version is recommended.

## Configuration 
To use functions provided by packages in examples, you need to set related parameters in ImportUserSample.java in the client package.
The following describes parameters in ExportDemoApi.java.

clientId:  Client ID, which is obtained from app information.
clientSecret:  Secret access key of an app, which is obtained from app information.
productId: Product ID, which is obtained from product information.
AppId: App ID, which is obtained from app information.

## Sample Code
DataImportSample is a demo to introduce how to create a task with API of HA server for importing user properties.
The following describes methods in the Client structure.

ImportUserSample.java: the entry function for importing user properties.
HttpClientUtil.java: the common function for sending network requests.

##  License
DataImportSample is licensed under the [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
