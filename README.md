# AEM DataLayer

This project is an implementation of the [Customer Experience Digital Data Layer 1.0](https://www.w3.org/2013/12/ceddl-201312.pdf)
specification produced by the W3C. 

It provides a flexible, extensible model for implementers to create a Data Layer in Adobe
Experience Manager by implementing clean, reusable Java code.


## Modules

The main parts of the template are:

* core: Java bundle containing all core functionality for the AEM DataLayer including the API and Sling Models for interacting with the AEM DataLayer
* ui.apps: contains the cloud services configurations and testing mechanism for validating the Data Layer
* weretail-reference: reference implementation based on the We.Retail Reference site from Adobe

## Using this Project

The goal of this project is to create an easily extensible, flexible API for exposing CMS data to 
Digital Marketing tools. In order to use the AEM DataLayer on your project, you must create Sling
Models to expose data to the DataLayer based on your needs.



## How to build

To build all the modules run in the project root directory the following command with Maven 3:

    mvn clean install

If you have a running AEM instance you can build and package the whole project and deploy into AEM with  

    mvn clean install -PautoInstallPackage
    
Or to deploy it to a publish instance, run

    mvn clean install -PautoInstallPackagePublish
    
Or to deploy only the bundle to the author, run

    mvn clean install -PautoInstallBundle

## Testing

There are three levels of testing contained in the project:

* unit test in core: this show-cases classic unit testing of the code contained in the bundle. To test, execute:

    mvn clean test

* server-side integration tests: this allows to run unit-like tests in the AEM-environment, ie on the AEM server. To test, execute:

    mvn clean integration-test -PintegrationTests



