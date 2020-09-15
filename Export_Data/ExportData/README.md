## Export_Data_CodeLab


## Table of Contents

 * [Introduction](#introduction)
 * [Installation](#installation)
 * [Configuration ](#configuration )
 * [Supported Environments](#supported-environments)
 * [Sample Code](# Sample Code)
 * [License](#license)
 
 
## Introduction
    The sample code introduces a demo for your task to export data. It provides a main function ExportDemoApi to perofrm the demo.

## Installation
    Before using sample code, check whether the JDK environment and Maven environment have been installed. 
    Decompress the sample code package called HAClientExample.
    
    Open the project with tools with IDEA and configure the settings of Maven environment for sample code to download packages of references.
 
    
## Supported Environments
	JDK 1.8 or a later version is recommended.
	Maven 3.6 or a later version is recommended.
	
## Configuration 
    To use functions provided by packages in examples, you need to set related parameters in ExportDemoApi.java in the client package.
    The following describes parameters in ExportDemoApi.java.
    
    clientId:   App ID, which is obtained from app information.
    clientSecret:  Secret access key of an app, which is obtained from app information.
    productId: Product ID, which is obtained from product information.
    startDate: Date params to filter export data.
    endDate: Date params to filter export data.
	
## Sample Code
    Export_Data_CodeLab is a demo to introduce how to create a task with API of HA server for exporting data.
    The following describes methods in the Client structure.
    
    ExportDemoApi.java: the entry function for perofrming the demo.
    HttpClientUtil.java: the common function for sending network requests.

##  License
     Export_Data_CodeLab is licensed under the [Apache License, version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

