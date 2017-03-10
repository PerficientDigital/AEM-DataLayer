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
package com.perficient.aem.datalayer.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.sling.api.wrappers.ValueMapDecorator;

/**
 * This class represents a Digital Marketing DataLayer driven through AEM Pages
 * and Components.
 * 
 * @author danklco
 */
public class DataLayer extends ValueMapDecorator {

	public static final String DATA_KEY_CART = "cart";
	public static final String DATA_KEY_COMPONENT = "component";
	public static final String DATA_KEY_EVENT = "event";
	public static final String DATA_KEY_PAGE = "page";
	public static final String DATA_KEY_PAGE_INSTANCE_ID = "pageInstanceID";
	public static final String DATA_KEY_PRODUCT = "product";
	public static final String DATA_KEY_TRANSACTION = "transaction";
	public static final String DATA_KEY_VERSION = "version ";

	public DataLayer() {
		super(new HashMap<String, Object>());
		put(DATA_KEY_EVENT, new ArrayList<EventInfo>());
		put(DATA_KEY_PAGE, new Page());
	}

	public List<Component> getComponents() {
		List<Component> defaultComponents = new ArrayList<Component>();
		if (!containsKey(DATA_KEY_COMPONENT)) {
			put(DATA_KEY_COMPONENT, defaultComponents);
		}
		return get(DATA_KEY_COMPONENT, defaultComponents);
	}

	public List<EventInfo> getEvents() {
		return get(DATA_KEY_EVENT, new ArrayList<EventInfo>());
	}

	public Page getPage() {
		return get(DATA_KEY_PAGE, Page.class);
	}

	public String getPageInstanceID() {
		return this.get(DATA_KEY_PAGE_INSTANCE_ID, String.class);
	}

	public List<Product> getProducts() {
		List<Product> defaultProducts = new ArrayList<Product>();
		if (!containsKey(DATA_KEY_PRODUCT)) {
			put(DATA_KEY_PRODUCT, defaultProducts);
		}
		return get(DATA_KEY_PRODUCT, defaultProducts);
	}

	public void setComponents(List<Component> components) {
		put(DATA_KEY_COMPONENT, components);
	}

	public void setEvents(List<EventInfo> events) {
		put(DATA_KEY_EVENT, events);
	}

	public void setPage(Page page) {
		put(DATA_KEY_PAGE, page);
	}

	public void setPageInstanceID(String pageInstanceID) {
		put(DATA_KEY_PAGE_INSTANCE_ID, pageInstanceID);
	}

}
