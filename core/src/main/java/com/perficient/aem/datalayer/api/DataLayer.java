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

import com.perficient.aem.datalayer.core.models.AEMDataLayerConfig;

/**
 * This class represents a Digital Marketing DataLayer driven through AEM Pages
 * and Components.
 * 
 * @author danklco
 */
public class DataLayer extends ValueMapDecorator {

	public static final String DATA_KEY_ACCESS_CATEGORY = "accessCategory";
	public static final String DATA_KEY_CART = "cart";
	public static final String DATA_KEY_COMPONENT = "component";
	public static final String DATA_KEY_EVENT = "event";
	public static final String DATA_KEY_PAGE = "page";
	public static final String DATA_KEY_PAGE_INSTANCE_ID = "pageInstanceID";
	public static final String DATA_KEY_PRIVACY = "privacy";
	public static final String DATA_KEY_PRODUCT = "product";
	public static final String DATA_KEY_TRANSACTION = "transaction";
	public static final String DATA_KEY_USER = "user";
	public static final String DATA_KEY_VERSION = "version ";
	private final AEMDataLayerConfig config;
	private final com.day.cq.wcm.api.Page page;

	public DataLayer(AEMDataLayerConfig config, com.day.cq.wcm.api.Page page) {
		super(new HashMap<String, Object>());
		this.config = config;
		this.page = page;
		put(DATA_KEY_EVENT, new ArrayList<EventInfo>());
		put(DATA_KEY_PAGE, new Page());
		put(DATA_KEY_VERSION, "1.0");
	}

	public void addComponent(Component component) {
		List<Component> components = getComponents();
		if (components == null) {
			components = new ArrayList<Component>();
			setComponents(components);
		}
		components.add(component);
	}

	public void addEvent(EventInfo event) {
		List<EventInfo> events = getEvents();
		if (events == null) {
			events = new ArrayList<EventInfo>();
			setEvents(events);
		}
		events.add(event);
	}

	public void addProduct(Product product) {
		if (!containsKey(DATA_KEY_PRODUCT)) {
			put(DATA_KEY_PRODUCT, new ArrayList<Product>());
		}
		getProducts().add(product);
	}

	public List<AccessCategory> getAccessCategories() {
		if (!containsKey(DATA_KEY_PRIVACY)) {
			return null;
		}
		return get(DATA_KEY_COMPONENT, new HashMap<String, List<AccessCategory>>()).get(DATA_KEY_ACCESS_CATEGORY);
	}

	public com.day.cq.wcm.api.Page getAEMPage() {
		return page;
	}

	public Cart getCart() {
		return get(DATA_KEY_CART, Cart.class);
	}

	public List<Component> getComponents() {
		if (!containsKey(DATA_KEY_COMPONENT)) {
			return null;
		}
		return get(DATA_KEY_COMPONENT, new ArrayList<Component>());
	}

	public AEMDataLayerConfig getConfig() {
		return this.config;
	}

	public List<EventInfo> getEvents() {
		if (!containsKey(DATA_KEY_EVENT)) {
			return null;
		}
		return get(DATA_KEY_EVENT, new ArrayList<EventInfo>());
	}

	public Page getPage() {
		return get(DATA_KEY_PAGE, Page.class);
	}

	public String getPageInstanceID() {
		return this.get(DATA_KEY_PAGE_INSTANCE_ID, String.class);
	}

	public List<Product> getProducts() {
		if (!containsKey(DATA_KEY_PRODUCT)) {
			return null;
		}
		return get(DATA_KEY_PRODUCT, new ArrayList<Product>());
	}

	public Transaction getTransaction() {
		return get(DATA_KEY_TRANSACTION, Transaction.class);
	}

	public List<User> getUsers() {
		if (!containsKey(DATA_KEY_USER)) {
			return null;
		}
		return get(DATA_KEY_USER, new ArrayList<User>());
	}

	public String getVersion() {
		return get(DATA_KEY_VERSION, String.class);
	}

	public void setAccessCategories(List<AccessCategory> accessCategories) {
		HashMap<String, List<AccessCategory>> defaultPrivacy = new HashMap<String, List<AccessCategory>>();
		if (!containsKey(DATA_KEY_PRIVACY)) {
			put(DATA_KEY_COMPONENT, defaultPrivacy);
		}
		get(DATA_KEY_COMPONENT, defaultPrivacy).put(DATA_KEY_ACCESS_CATEGORY, accessCategories);
	}

	public void setCart(Cart cart) {
		put(DATA_KEY_CART, cart);
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

	public void setTransaction(Transaction transaction) {
		put(DATA_KEY_TRANSACTION, transaction);
	}

	public void setUsers(List<User> users) {
		put(DATA_KEY_USER, users);
	}

}
