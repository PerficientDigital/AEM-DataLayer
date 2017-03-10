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
 * Data Layer object representing the profile data for a particular user.
 * 
 * @author danklco
 *
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.9</a>
 */
public class UserProfile extends BaseDataObject {

	public static final String DATA_KEY_SOCIAL = "social";

	public Address getAddress() {
		return get(DataLayerConstants.DATA_KEY_ADDRESS, Address.class);
	}

	public Map<String, Object> getAttributes() {
		if (!containsKey(DataLayerConstants.DATA_KEY_ATTRIBUTES)) {
			put(DataLayerConstants.DATA_KEY_ATTRIBUTES, new HashMap<String, Object>());
		}
		return get(DataLayerConstants.DATA_KEY_ATTRIBUTES, new HashMap<String, Object>());
	}

	public UserProfileInfo getProfileInfo() {
		return get(DataLayerConstants.DATA_KEY_PROFILE_INFO, UserProfileInfo.class);
	}

	public Map<String, Object> getSocial() {
		return get(DATA_KEY_SOCIAL, new HashMap<String, Object>());
	}

	public void setAddress(Address address) {
		put(DataLayerConstants.DATA_KEY_ADDRESS, address);
	}

	public void setAttributes(Map<String, Object> attributes) {
		put(DataLayerConstants.DATA_KEY_ATTRIBUTES, attributes);
	}

	public void setProfileInfo(UserProfileInfo profileInfo) {
		put(DataLayerConstants.DATA_KEY_PROFILE_INFO, profileInfo);
	}

	public void setSocial(Map<String, Object> social) {
		put(DATA_KEY_SOCIAL, social);
	}

}
