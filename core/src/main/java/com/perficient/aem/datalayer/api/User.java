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
import java.util.Map;

import com.perficient.aem.datalayer.DataLayerConstants;

/**
 * Data object for representing a user.
 * 
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.9</a>
 */
public class User extends CategorizableDataObject {

	public static final String DATA_KEY_SEGMENT = "segment";

	public User() {
		setProfiles(new ArrayList<UserProfile>());
	}

	public List<UserProfile> getProfiles() {
		return get(DataLayerConstants.DATA_KEY_PROFILE, new ArrayList<UserProfile>());
	}

	public Map<String, Object> getSegments() {
		return get(DATA_KEY_SEGMENT, new HashMap<String, Object>());
	}

	public void setProfiles(List<UserProfile> profiles) {
		put(DataLayerConstants.DATA_KEY_PROFILE, profiles);
	}

	public void setSegments(Map<String, Object> segments) {
		put(DATA_KEY_SEGMENT, segments);
	}
}
