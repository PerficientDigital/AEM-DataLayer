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

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.commons.inherit.HierarchyNodeInheritanceValueMap;
import com.day.cq.commons.inherit.InheritanceValueMap;
import com.day.cq.wcm.api.Page;

/**
 * Cloud configuration for the AEM DataLayer.
 * 
 * @author danklco
 */
@Model(adaptables = Resource.class)
public class AEMDataLayerConfig {

	public static final String AEM_DATALAYER_CONFIG_PATH = "/etc/cloudservices/aemdatalayer";

	private static final Logger log = LoggerFactory.getLogger(AEMDataLayerConfig.class);

	public static final String PN_CLOUD_SERVICE_CONFIGS = "cq:cloudserviceconfigs";

	/**
	 * Retrieves the DataLayer config for the page or none if it is not
	 * configured for that page or any inherited page.
	 * 
	 * @param page
	 *            the page for which to get the data layer configuration
	 * @return the DataLayer configuration
	 */
	public static AEMDataLayerConfig getDataLayerConfig(Page page) {
		if (page != null) {
			log.trace("Finding Digital Data config for {}", page.getPath());
			InheritanceValueMap properties = new HierarchyNodeInheritanceValueMap(page.getContentResource());
			String[] cloudServices = properties.getInherited(PN_CLOUD_SERVICE_CONFIGS, new String[0]);
			for (String cloudService : cloudServices) {
				if (cloudService.startsWith(AEM_DATALAYER_CONFIG_PATH)) {
					Page cloudServicePage = page.getPageManager().getContainingPage(cloudService);
					if (cloudServicePage != null) {
						return cloudServicePage.getContentResource().adaptTo(AEMDataLayerConfig.class);
					} else {
						log.warn("Cloud service not found at {}", cloudService);
					}
				}
			}
			log.warn("No Digital Data config found for {}", page.getPath());
		}
		return null;

	}

	@Inject
	private String environment;

	@Inject
	private String objectName;

	@Inject
	@Optional
	@Default(booleanValues = false)
	private Boolean prettyPrint;

	@Inject
	@Optional
	private String publisher;

	@Inject
	@Optional
	@Default(booleanValues = false)
	private Boolean setAuthor;

	@Inject
	private String siteId;

	@Inject
	private Integer siteRootLevel;

	@Inject
	private String urlPrefix;

	public String getEnvironment() {
		return environment;
	}

	public String getObjectName() {
		return objectName;
	}

	public Boolean getPrettyPrint() {
		return prettyPrint;
	}

	public String getPublisher() {
		return publisher;
	}

	public Boolean getSetAuthor() {
		return setAuthor;
	}

	public String getSiteId() {
		return siteId;
	}

	public Integer getSiteRootLevel() {
		return siteRootLevel;
	}

	public String getUrlPrefix() {
		return urlPrefix;
	}
}
