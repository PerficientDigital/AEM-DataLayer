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
import java.util.Map;

import com.perficient.aem.datalayer.DataLayerConstants;

/**
 * Basic data object which extends the BaseDataObject to allow for setting
 * additional attributes and categories.
 * 
 * @author danklco
 */
public class CategorizableDataObject extends BaseDataObject {

	public static final String DATA_KEY_CATEGORY = "category";

	public void addAttribute(String key, Object value){
		Map<String, Object> attributes = getAttributes();
		if(attributes == null){
			attributes = new HashMap<String, Object>();
			setAttributes(attributes);
		}
		attributes.put(key, value);
	}
	
	public Map<String, Object> getAttributes() {
		if (!containsKey(DataLayerConstants.DATA_KEY_ATTRIBUTES)) {
			return null;
		}
		return get(DataLayerConstants.DATA_KEY_ATTRIBUTES, new HashMap<String, Object>());
	}

	public Category getCategory() {
		if (!containsKey(DATA_KEY_CATEGORY)) {
			return null;
		}
		return get(DATA_KEY_CATEGORY, Category.class);
	}

	public void setAttributes(Map<String, Object> attributes) {
		put(DataLayerConstants.DATA_KEY_ATTRIBUTES, attributes);
	}

	public void setCategory(Category category) {
		put(DATA_KEY_CATEGORY, category);
	}
}
