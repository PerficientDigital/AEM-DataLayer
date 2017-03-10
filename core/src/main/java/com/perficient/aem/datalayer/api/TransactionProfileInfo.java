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

/**
 * A DataObject for representing the profile data for a transaction.
 * 
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.6</a>
 */
public class TransactionProfileInfo extends BaseDataObject {

	public static final String DATA_KEY_PROFILE_ID = "profileID";

	public static final String DATA_KEY_USERNAME = "userName";

	public static final String DATA_KEY_EMAIL = "email";

	public String getProfileID() {
		return get(DATA_KEY_PROFILE_ID, String.class);
	}

	public String getUserName() {
		return get(DATA_KEY_USERNAME, String.class);
	}

	public String getEmail() {
		return get(DATA_KEY_EMAIL, String.class);
	}

	public void setProfileID(String profileID) {
		put(DATA_KEY_PROFILE_ID, profileID);
	}

	public void setUserName(String userName) {
		put(DATA_KEY_USERNAME, userName);
	}

	public void setEmail(String email) {
		put(DATA_KEY_EMAIL, email);
	}

}
