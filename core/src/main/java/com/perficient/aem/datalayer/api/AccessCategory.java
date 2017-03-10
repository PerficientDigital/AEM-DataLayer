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

import java.util.HashMap;

import org.apache.sling.api.wrappers.ValueMapDecorator;

/**
 * Data Object representing an access category which is used to determine what
 * services are available and should be restricted from accessing which data
 * objects
 * 
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.10</a>
 */
public class AccessCategory extends ValueMapDecorator {

	public static final String DATA_KEY_CATEGORY_NAME = "categoryName";

	public static final String DATA_KEY_DOMAINS = "domains";

	public AccessCategory() {
		super(new HashMap<String, Object>());
	}

	public String getCategoryName() {
		return get(DATA_KEY_CATEGORY_NAME, String.class);
	}

	public String[] getDomains() {
		return get(DATA_KEY_DOMAINS, String[].class);
	}

	public void setCategoryName(String categoryName) {
		put(DATA_KEY_CATEGORY_NAME, categoryName);
	}

	public void setDomains(String[] domains) {
		put(DATA_KEY_DOMAINS, domains);
	}

}
