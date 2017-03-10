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
package com.perficient.aem.datalayer.core.servlets;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.perficient.aem.datalayer.core.models.DataLayerModel;

/**
 * Servlet for testing the AEM DataLayer
 * 
 * @author danklco
 *
 */
@SlingServlet(resourceTypes = "aemdatalayer/components/cloudconfig", methods = "GET", extensions = "json", selectors = "datalayer")
public class DataLayerTestServlet extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = -1422202443028345759L;
	private static final Logger log = LoggerFactory.getLogger(DataLayerTestServlet.class);

	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
		log.trace("doGet");
		String suffix = request.getRequestPathInfo().getSuffix();
		log.debug("Retrieving data layer for {}", suffix);

		if (StringUtils.isNotEmpty(suffix)) {
			Resource resource = request.getResourceResolver().getResource(suffix);
			if (resource != null) {
				DataLayerModel digitalDataModel = resource.adaptTo(DataLayerModel.class);
				if (digitalDataModel != null) {
					response.setContentType("application/json");
					response.getWriter().write(digitalDataModel.getJson());
				} else {
					response.sendError(404, "No Data Layer found for " + suffix);
				}
			} else {
				response.sendError(404, "No Resource found at " + suffix);
			}
		} else {

			response.sendError(400, "Missing Suffix");
		}

	}
}
