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
package com.perficient.aem.datalayer.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;

import com.perficient.aem.datalayer.api.DataLayer;
import com.perficient.aem.datalayer.core.DataLayerUtil;

/**
 * This class wraps the AEMDataLayer to enable EL bean access to the JSON
 * representation of the data layer.
 * 
 * @author danklco
 */
@Model(adaptables = SlingHttpServletRequest.class)
public class AEMDataLayerManager {
	private final DataLayer dataLayer;

	public AEMDataLayerManager(SlingHttpServletRequest request) {
		dataLayer = DataLayerUtil.getDataLayer(request);
	}

	public String getJson() {
		return DataLayerUtil.toJSON(dataLayer);
	}

	public AEMDataLayerConfig getConfig() {
		return dataLayer.getConfig();
	}
}
