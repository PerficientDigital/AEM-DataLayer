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

import org.apache.sling.api.wrappers.ValueMapDecorator;

/**
 * Basic data object which extends ValueMapDecorator allowing for arbitrary keys
 * while still providing named fields.
 * 
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.11</a>
 */
public class BaseDataObject extends ValueMapDecorator {

	public static final String DATA_ATTRIBUTE_SECURITY = "security";

	public BaseDataObject() {
		super(new HashMap<String, Object>());
	}

	/**
	 * Gets the security object. This can be one of:
	 * <ul>
	 * <li>An access category</li>
	 * <li>An array of access categories</li>
	 * <li>A Map of fields and access category instances or arrays</li>
	 * </ul>
	 * 
	 * @return the security object for this DataLayer Object
	 */
	public Object getSecurity() {
		return get(DATA_ATTRIBUTE_SECURITY, Object.class);
	}

	/**
	 * Sets the security object to an access group
	 * 
	 * @param accessGroup
	 *            the access group name
	 */
	public void setAccessGroup(String accessGroup) {
		put(DATA_ATTRIBUTE_SECURITY, accessGroup);
	}

	/**
	 * Sets the security object to an array of access groups
	 * 
	 * @param accessGroups
	 *            the access group names
	 */
	public void setAccessGroups(String[] accessGroups) {
		put(DATA_ATTRIBUTE_SECURITY, accessGroups);
	}

	/**
	 * Sets the security object to a map of properties and access groupss
	 * 
	 * @param propertyAccess
	 *            the map of properties and access groupss
	 */
	public void setPropertyAccess(Map<String, Object> propertyAccess) {
		put(DATA_ATTRIBUTE_SECURITY, propertyAccess);
	}

}
