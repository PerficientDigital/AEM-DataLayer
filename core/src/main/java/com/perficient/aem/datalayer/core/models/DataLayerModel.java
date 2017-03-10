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

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Source;
import org.apache.sling.models.factory.ModelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.PageManager;
import com.google.gson.Gson;
import com.perficient.aem.datalayer.api.ComponentDataElement;
import com.perficient.aem.datalayer.api.DataLayer;

/**
 * This class represents a Digital Marketing DataLayer driven through AEM Pages
 * and Components.
 * 
 * @author danklco
 */
@Model(adaptables = Resource.class, adapters = { DataLayer.class, DataLayerModel.class })
public class DataLayerModel extends DataLayer {

	private static final Logger log = LoggerFactory.getLogger(DataLayerModel.class);

	private AEMDataLayerConfig config;

	@Inject
	@Source("osgi-services")
	private ModelFactory modelFactory;

	private final com.day.cq.wcm.api.Page page;

	public DataLayerModel(Resource resource) {
		PageManager pMgr = resource.getResourceResolver().adaptTo(PageManager.class);
		this.page = pMgr.getContainingPage(resource);
	}

	public com.day.cq.wcm.api.Page getAEMPage() {
		return page;
	}

	public AEMDataLayerConfig getConfig() {
		return this.config;
	}

	public String getJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	@PostConstruct
	protected void init() {
		config = AEMDataLayerConfig.getDataLayerConfig(page);

		if (config != null) {
			log.debug("Using configuration {}", config);
			String path = page.getPath().replace(page.getAbsoluteParent(config.getSiteRootLevel()).getPath(), "");
			put(DATA_KEY_PAGE_INSTANCE_ID, config.getEnvironment() + ":" + config.getSiteId() + path);

			updateDataLayer(page.getContentResource());
		} else {
			log.warn("Page " + page.getPath() + " not configured to use AEM DataLayer");
			throw new IllegalArgumentException("Page " + page.getPath() + " not configured to use AEM DataLayer");
		}
	}

	public void setConfig(AEMDataLayerConfig config) {
		this.config = config;
	}

	private void updateDataLayer(Resource resource) {
		if (!StringUtils.isEmpty(resource.getValueMap().get(ResourceResolver.PROPERTY_RESOURCE_TYPE, String.class))) {
			ComponentDataElement cde = null;

			try {
				cde = (ComponentDataElement) modelFactory.getModelFromResource(resource);
			} catch (Exception e) {
				log.debug("Exception adapting resource " + resource + " to ComponentDataElement: " + e);
			}
			if (cde != null) {
				log.trace("Found ComponentDataElement {} for {}", cde.getClass().getName(), resource);
				cde.updateDataLayer(this);
			} else {
				log.trace("No ComponentDataElement found for {}", resource);
			}

		} else {
			log.trace("No Resource Type set for {}", resource);
		}
		for (Resource child : resource.getChildren()) {
			updateDataLayer(child);
		}

	}
}
