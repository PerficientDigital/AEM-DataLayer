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

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.engine.SlingRequestProcessor;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.contentsync.handler.util.RequestResponseFactory;
import com.perficient.aem.datalayer.DataLayerConstants;
import com.perficient.aem.datalayer.api.DataLayer;
import com.perficient.aem.datalayer.core.DataLayerUtil;

/**
 * Servlet for testing the AEM DataLayer
 * 
 * @author danklco
 *
 */
@SlingServlet(resourceTypes = "aemdatalayer/components/cloudconfig", methods = "GET", extensions = "json", selectors = "datalayer")
@Properties({ @Property(name = Constants.SERVICE_VENDOR, value = DataLayerConstants.SERVICE_VENDOR) })
public class DataLayerTestServlet extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = -1422202443028345759L;
	private static final Logger log = LoggerFactory.getLogger(DataLayerTestServlet.class);

	@Reference
	private RequestResponseFactory requestResponseFactory;

	@Reference
	private SlingRequestProcessor requestProcessor;

	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws IOException, ServletException {
		log.trace("doGet");
		String suffix = request.getRequestPathInfo().getSuffix();

		if (StringUtils.isNotEmpty(suffix)) {
			log.debug("Retrieving data layer for {}", suffix);
			Resource resource = request.getResourceResolver().getResource(suffix);
			if (resource != null) {

				HttpServletRequest req = requestResponseFactory.createRequest("GET", suffix + ".html");
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				HttpServletResponse resp = requestResponseFactory.createResponse(baos);
				requestProcessor.processRequest(req, resp, request.getResourceResolver());

				DataLayer dataLayer = DataLayerUtil.getDataLayer(req);
				if (dataLayer != null) {
					response.setContentType("application/json");
					response.getWriter().write(DataLayerUtil.toJSON(dataLayer));
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
