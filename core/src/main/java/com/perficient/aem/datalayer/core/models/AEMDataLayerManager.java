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

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.perficient.aem.datalayer.DataLayerConstants;

/**
 * This class wraps the AEMDataLayer to enable EL bean access to the JSON
 * representation of the data layer.
 * 
 * @author danklco
 */
@Model(adaptables = Resource.class)
public class AEMDataLayerManager {
	private final DataLayerModel dataLayer;

	public AEMDataLayerManager(Resource resource) {
		dataLayer = resource.adaptTo(DataLayerModel.class);
	}

	public String getJson() {
		String json = null;
		if (dataLayer.getConfig().getPrettyPrint() == true) {
			Gson gson = new GsonBuilder().setDateFormat(DataLayerConstants.DATE_FORMAT).setPrettyPrinting().create();
			json = gson.toJson(dataLayer);
		} else {
			json = dataLayer.getJson();
		}
		return json;
	}

	public AEMDataLayerConfig getConfig() {
		return dataLayer.getConfig();
	}
}
