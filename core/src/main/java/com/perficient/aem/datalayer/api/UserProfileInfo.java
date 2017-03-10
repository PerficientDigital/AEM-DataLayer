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

import com.perficient.aem.datalayer.DataLayerConstants;

/**
 * Data Layer object for representing a user's profile.
 * 
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.9</a>
 */
public class UserProfileInfo extends TransactionProfileInfo {
	public static final String DATA_KEY_RETURNING_STATUS = "returningStatus";
	public static final String DATA_KEY_TYPE = "type";

	public String getLanguage() {
		return get(DataLayerConstants.DATA_KEY_LANGUAGE, String.class);
	}

	public String getReturningStatus() {
		return get(DATA_KEY_RETURNING_STATUS, String.class);
	}

	public String getType() {
		return get(DATA_KEY_TYPE, String.class);
	}

	public void setLanguage(String language) {
		put(DataLayerConstants.DATA_KEY_LANGUAGE, language);
	}

	public void setReturningStatus(String returningStatus) {
		put(DATA_KEY_RETURNING_STATUS, returningStatus);
	}

	public void setType(String type) {
		put(DATA_KEY_TYPE, type);
	}

}
