package com.perficient.aem.datalayer.test;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.perficient.aem.datalayer.api.ComponentDataElement;
import com.perficient.aem.datalayer.api.DataLayer;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { SomeResourceTypeModel.class,
		ComponentDataElement.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL, resourceType = "some/resource/type")
public class SomeResourceTypeModel implements ComponentDataElement {

	@Override
	public void updateDataLayer(DataLayer dataLayer) {
	}

}
