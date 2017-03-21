/*
 *  Copyright 2017 - Perficient
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.perficient.aem.weretail.datalayer;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;

import com.perficient.aem.datalayer.api.Component;
import com.perficient.aem.datalayer.api.ComponentDataElement;
import com.perficient.aem.datalayer.api.DataLayer;

/**
 * Adds in the video details for the AEM Mobile Video component into the
 * AEMDataLayer
 * 
 * @author danklco
 */
@Model(adaptables = Resource.class, resourceType = {
		"mobileapps/components/mobilevideo" }, adapters = ComponentDataElement.class)
public class MobileVideoComponent implements ComponentDataElement {

	private final Resource resource;

	public MobileVideoComponent(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void updateDataLayer(DataLayer dataLayer) {

		Component component = new Component();
		component.getComponentInfo().setComponentID(resource.getPath());

		ValueMap properties = resource.getValueMap();

		component.addAttribute("video", properties.get("fileReference", String.class));

		dataLayer.addComponent(component);
	}

}
