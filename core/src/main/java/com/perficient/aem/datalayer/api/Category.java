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

import java.util.Map;

/**
 * Represents an object of categories in the data layer.
 *
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.3</a>
 */
public class Category extends BaseDataObject {

	public Category(Map<String,Object> map){
		super(map);
	}
	public Category(){
		super();
	}

	public static final String DATA_KEY_PRIMARY_CATEGORY = "primaryCategory";

	public String getPrimaryCategory() {
		return get(DATA_KEY_PRIMARY_CATEGORY, String.class);
	}

	public void setPrimaryCategory(String primaryCategory) {
		put(DATA_KEY_PRIMARY_CATEGORY, primaryCategory);
	}
}
