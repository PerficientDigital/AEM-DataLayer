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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Model;

import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.NameConstants;
import com.perficient.aem.datalayer.api.Category;
import com.perficient.aem.datalayer.api.ComponentDataElement;
import com.perficient.aem.datalayer.api.DataLayer;
import com.perficient.aem.datalayer.api.EventInfo;
import com.perficient.aem.datalayer.api.Page;
import com.perficient.aem.datalayer.api.PageInfo;
import com.perficient.aem.datalayer.core.DataLayerUtil;

/**
 * Default model for AEM pages. Sets the default values.
 * 
 * @author danklco
 */
@Model(adaptables = Resource.class, resourceType = {
		"weretail/components/structure/page" }, adapters = ComponentDataElement.class)
public class DefaultPageDataElement implements ComponentDataElement {

	@Override
	public void updateDataLayer(DataLayer dataLayer) {
		EventInfo event = new EventInfo();
		event.setEventAction("pageLoad");
		event.setEventName("Page Load");
		dataLayer.getEvents().add(event);

		Page page = dataLayer.getPage();

		PageInfo pageInfo = new PageInfo();
		if (dataLayer.getConfig().getSetAuthor() == true) {
			pageInfo.setAuthor(dataLayer.getAEMPage().getLastModifiedBy());
		}

		List<String> breadcrumbs = new ArrayList<String>();
		com.day.cq.wcm.api.Page currentPage = dataLayer.getAEMPage();
		while (currentPage.getDepth() > dataLayer.getConfig().getSiteRootLevel()) {
			breadcrumbs.add(currentPage.getTitle());
			currentPage = currentPage.getParent();
		}

		Collections.reverse(breadcrumbs);
		pageInfo.setBreadcrumbs(breadcrumbs.toArray(new String[breadcrumbs.size()]));

		currentPage = dataLayer.getAEMPage();
		ValueMap properties = currentPage.getContentResource().getValueMap();
		String path = DataLayerUtil.getSiteSubpath(currentPage, dataLayer.getConfig());

		pageInfo.setDestinationUrl(DataLayerUtil.getSiteUrl(currentPage, dataLayer.getConfig()));
		if (currentPage.getOnTime() != null) {
			pageInfo.setEffectiveDate(currentPage.getOnTime().getTime());
		} else if (properties.containsKey(JcrConstants.JCR_CREATED)) {
			pageInfo.setEffectiveDate(properties.get(JcrConstants.JCR_CREATED, Date.class));
		}
		if (currentPage.getOffTime() != null) {
			pageInfo.setExpiryDate(currentPage.getOffTime().getTime());
		}
		if (properties.containsKey(JcrConstants.JCR_CREATED)) {
			pageInfo.setIssueDate(properties.get(JcrConstants.JCR_CREATED, Date.class));
		}
		pageInfo.setLanguage(currentPage.getLanguage(false).toString());
		pageInfo.setPageId(path);
		pageInfo.setPageName(currentPage.getTitle());
		if (StringUtils.isNotEmpty(dataLayer.getConfig().getPublisher())) {
			pageInfo.setPublisher(dataLayer.getConfig().getPublisher());
		}
		pageInfo.setSysEnv(dataLayer.getConfig().getEnvironment());

		page.setPageInfo(pageInfo);

		String templateName = StringUtils.substringAfterLast(properties.get(NameConstants.NN_TEMPLATE, String.class),
				"/");
		List<String> tags = new ArrayList<String>();

		Category category = new Category();
		category.setPrimaryCategory(templateName);
		for (int i = 0; i < currentPage.getTags().length; i++) {
			category.put("tag" + i, currentPage.getTags()[i].getTitle());
			tags.add(currentPage.getTags()[i].getTitle());
		}
		page.setCategory(category);

		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("tags", tags.toArray(new String[tags.size()]));
		attributes.put("template", templateName);
		page.setAttributes(attributes);

	}
}
