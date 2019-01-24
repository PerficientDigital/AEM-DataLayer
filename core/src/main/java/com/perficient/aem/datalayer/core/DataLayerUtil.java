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

import java.text.SimpleDateFormat;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.perficient.aem.datalayer.DataLayerConstants;
import com.perficient.aem.datalayer.api.DataLayer;
import com.perficient.aem.datalayer.core.models.AEMDataLayerConfig;

/**
 * Utilities for the AEM DataLayer library
 * 
 * @author danklco
 */
public class DataLayerUtil {

	private static final Logger log = LoggerFactory.getLogger(DataLayerUtil.class);

	private DataLayerUtil() {
		// hidden
	}

	public static final DataLayer getDataLayer(ServletRequest request) {
		return (DataLayer) request.getAttribute(DataLayerConstants.REQUEST_PROPERTY_AEM_DATALAYER);
	}

	public static final String getSiteSubpath(Page page, AEMDataLayerConfig config) {
		return page.getPath().replace(page.getAbsoluteParent(config.getSiteRootLevel()).getPath(), "");
	}

	public static final String getSiteUrl(Page page, AEMDataLayerConfig config) {
		String subpath = getSiteSubpath(page, config);
		return config.getUrlPrefix() + subpath + ".html";
	}

	public static final String toJSON(DataLayer dataLayer) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat(DataLayerConstants.DATE_FORMAT));

		ObjectWriter writer = null;
		if (dataLayer.getConfig().getPrettyPrint()) {
			writer = objectMapper.writerWithDefaultPrettyPrinter();
		} else {
			writer = objectMapper.writer();
		}
		try {
			return writer.writeValueAsString(dataLayer);
		} catch (JsonProcessingException e) {
			log.error("Exception writing DataLayer to JSON", e);
			return "{\"error\":true}";
		}
	}
}
