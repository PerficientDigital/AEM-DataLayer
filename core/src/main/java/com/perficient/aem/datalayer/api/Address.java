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
 * Represents the address for a website user.
 * 
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.6</a>
 */
public class Address extends BaseDataObject {

	public static final String DATA_KEY_LINE_1 = "line1";
	public static final String DATA_KEY_LINE_2 = "line2";
	public static final String DATA_KEY_CITY = "city";
	public static final String DATA_KEY_STATE_PROVINCE = "stateProvince";
	public static final String DATA_KEY_POSTAL_CODE = "postalCode";
	public static final String DATA_KEY_COUNTRY = "country";

	public String getLine1() {
		return get(DATA_KEY_LINE_1, String.class);
	}

	public String getLine2() {
		return get(DATA_KEY_LINE_2, String.class);
	}

	public String getCity() {
		return get(DATA_KEY_CITY, String.class);
	}

	public String getStateProvince() {
		return get(DATA_KEY_STATE_PROVINCE, String.class);
	}

	public String getPostalCode() {
		return get(DATA_KEY_POSTAL_CODE, String.class);
	}

	public String getCountry() {
		return get(DATA_KEY_COUNTRY, String.class);
	}

	public void setLine1(String line1) {
		put(DATA_KEY_LINE_1, line1);
	}

	public void setLine2(String line2) {
		put(DATA_KEY_LINE_2, line2);
	}

	public void setCity(String city) {
		put(DATA_KEY_CITY, city);
	}

	public void setStateProvince(String stateProvince) {
		put(DATA_KEY_STATE_PROVINCE, stateProvince);
	}

	public void setPostalCode(String postalCode) {
		put(DATA_KEY_POSTAL_CODE, postalCode);
	}

	public void setCountry(String country) {
		put(DATA_KEY_COUNTRY, country);
	}
}
