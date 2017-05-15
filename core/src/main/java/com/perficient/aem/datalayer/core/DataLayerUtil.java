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
package com.perficient.aem.datalayer.core;

import javax.servlet.ServletRequest;

import com.day.cq.wcm.api.Page;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.perficient.aem.datalayer.DataLayerConstants;
import com.perficient.aem.datalayer.api.DataLayer;
import com.perficient.aem.datalayer.core.models.AEMDataLayerConfig;

/**
 * Utilities for the AEM DataLayer library
 * 
 * @author danklco
 */
public class DataLayerUtil {

	public static final DataLayer getDataLayer(ServletRequest request) {
		return (DataLayer) request.getAttribute(DataLayerConstants.REQUEST_PROPERTY_AEM_DATALAYER);
	}

	public static final String getSiteSubpath(Page page, AEMDataLayerConfig config) {
		String path = page.getPath().replace(page.getAbsoluteParent(config.getSiteRootLevel()).getPath(), "");
		return path;
	}

	public static final String getSiteUrl(Page page, AEMDataLayerConfig config) {
		String subpath = getSiteSubpath(page, config);
		return config.getUrlPrefix() + subpath + ".html";
	}

	public static final String toJSON(DataLayer dataLayer) {
		String json = null;
		GsonBuilder builder = new GsonBuilder().setDateFormat(DataLayerConstants.DATE_FORMAT);
		if (dataLayer.getConfig().getPrettyPrint() == true) {
			builder.setPrettyPrinting();
		}
		Gson gson = builder.create();
		json = gson.toJson(dataLayer);
		return json;
	}
}
