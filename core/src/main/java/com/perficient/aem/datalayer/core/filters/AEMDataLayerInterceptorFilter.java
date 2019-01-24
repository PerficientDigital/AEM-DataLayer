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
package com.perficient.aem.datalayer.core.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang.ObjectUtils;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingFilter;
import org.apache.felix.scr.annotations.sling.SlingFilterScope;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.factory.ModelClassException;
import org.apache.sling.models.factory.ModelFactory;
import org.osgi.framework.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.perficient.aem.datalayer.DataLayerConstants;
import com.perficient.aem.datalayer.api.ComponentDataElement;
import com.perficient.aem.datalayer.api.DataLayer;
import com.perficient.aem.datalayer.core.DataLayerUtil;
import com.perficient.aem.datalayer.core.models.AEMDataLayerConfig;

/**
 * Filter for intercepting the AEM Component includes and thereby generating the
 * AEM DataLayer for a particular request.
 * 
 * @author danklco
 */
@SlingFilter(order = 0, scope = SlingFilterScope.COMPONENT)
@Properties({ @Property(name = Constants.SERVICE_VENDOR, value = DataLayerConstants.SERVICE_VENDOR) })
public class AEMDataLayerInterceptorFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(AEMDataLayerInterceptorFilter.class);

	public static final String REQUEST_PROPERTY_AEM_DATALAYER_APPLICABLE = "AEM_DATALAYER_APPLICABLE";

	@Reference
	private ModelFactory modelFactory;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (request instanceof SlingHttpServletRequest && isApplicable((SlingHttpServletRequest) request)) {

			SlingHttpServletRequest slingRequest = (SlingHttpServletRequest) request;

			DataLayer dataLayer = DataLayerUtil.getDataLayer(slingRequest);
			try {
				updateDataLayer(slingRequest, dataLayer);
			} catch (Exception e) {
				log.warn("Exception updating DataLayer for resource " + slingRequest.getResource().getPath(), e);
			}
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	private boolean isApplicable(SlingHttpServletRequest request) {
		Object appliable = request.getAttribute(REQUEST_PROPERTY_AEM_DATALAYER_APPLICABLE);
		if (appliable == null) {
			Resource resource = request.getResource();
			PageManager pMgr = resource.getResourceResolver().adaptTo(PageManager.class);
			Page page = pMgr.getContainingPage(resource);
			AEMDataLayerConfig config = AEMDataLayerConfig.getDataLayerConfig(page);
			if (config != null) {
				DataLayer dataLayer = new DataLayer(config, page);
				request.setAttribute(DataLayerConstants.REQUEST_PROPERTY_AEM_DATALAYER, dataLayer);
				request.setAttribute(REQUEST_PROPERTY_AEM_DATALAYER_APPLICABLE, new Boolean(true));
				return true;
			} else {
				request.setAttribute(REQUEST_PROPERTY_AEM_DATALAYER_APPLICABLE, new Boolean(false));
				return false;
			}
		} else {
			return new Boolean(true).equals(appliable);
		}
	}

	private void updateDataLayer(SlingHttpServletRequest request, DataLayer dataLayerModel) {

		log.trace("Updating DataLayer with {}", request.getResource().getPath());
		Object model = null;
		Resource resource = request.getResource();

		// Check to make sure we're not about to run into a stack overflow
		if (resource.getResourceType() != null) {
			ResourceResolver resolver = request.getResourceResolver();
			String parentResourceType = resolver.getParentResourceType(resource.getResourceType());
			Resource parentResource = resolver.getResource(resource.getResourceType());
			if (parentResource != null && parentResourceType != null) {
				String grandparentResourceType = resolver.getParentResourceType(parentResource.getResourceType());
				if (ObjectUtils.equals(parentResourceType, grandparentResourceType)) {
					log.debug("Invalid resource {} with recursive resource type, not evaluating", resource);
					return;
				}
			}
		}

		try {
			model = modelFactory.getModelFromRequest(request);
			if (!(model instanceof ComponentDataElement)) {
				model = null;
			}
		} catch (ModelClassException mce) {
			log.debug("Failed to adapt request " + request + " to ComponentDataElement: ", mce);
		} catch (Exception e) {
			log.debug("Unexpected exception adapting request " + request + " to ComponentDataElement: ", e);
		}

		if (model == null) {
			try {
				model = modelFactory.getModelFromResource(resource);
			} catch (ModelClassException mce) {
				log.debug("Failed to adapt resource " + resource + " to ComponentDataElement: ", mce);
			} catch (Exception e) {
				log.debug("Unexpected exception adapting resource " + resource + " to ComponentDataElement: ", e);
			}
		}

		if (model != null) {
			if (model instanceof ComponentDataElement) {
				ComponentDataElement cde = (ComponentDataElement) model;
				log.debug("Found ComponentDataElement {} for {}", cde.getClass().getName(), resource);
				cde.updateDataLayer(dataLayerModel);
			} else {
				log.debug("Found model of unexpected class {}", model.getClass().getName());
			}
		} else {
			log.trace("No ComponentDataElement found for {}", resource);
		}
	}

}
