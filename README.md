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

## Implementing Your Data Layer

To get started, you may want to review the [weretail-reference project](https://github.com/PerficientDigital/AEM-DataLayer/tree/master/weretail-reference) to get a better idea of how to implement the AEM DataLayer for your project.

The implementation process is pretty simple, you simply create Sling Models for each component you want to use to populate your DataLayer. Each Sling Model should implement the interface [ComponentDataElement](https://github.com/PerficientDigital/AEM-DataLayer/blob/master/core/src/main/java/com/perficient/aem/datalayer/api/ComponentDataElement.java) and specify a resource type as shown below:

	@Model(adaptables = Resource.class, resourceType = {
		"weretail/components/structure/page" }, adapters = ComponentDataElement.class)
	public class DefaultPageDataElement implements ComponentDataElement {
	
As this is a Sling Model, you can inject any OSGi Service, Resource property or the Resource itself into your Model class.

The [ComponentDataElement#updateDataLayer](https://github.com/PerficientDigital/AEM-DataLayer/blob/master/core/src/main/java/com/perficient/aem/datalayer/api/ComponentDataElement.java) method will be called by the AEM DataLayer API when your Sling Model is adapted from a Resource in order to update the DataLayer.

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



