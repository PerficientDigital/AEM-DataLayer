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
 * A DataLayer object to represent a profile for transactions.s
 * 
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.6</a>
 */
public class TransactionProfile extends BaseDataObject {

	public static final String DATA_KEY_SHIPPING_ADDRESS = "shippingAddress";

	public Address getAddress() {
		return get(DataLayerConstants.DATA_KEY_ADDRESS, Address.class);
	}

	public TransactionProfileInfo getProfileInfo() {
		return get(DataLayerConstants.DATA_KEY_PROFILE_INFO, TransactionProfileInfo.class);
	}

	public Address getShippingAddress() {
		return get(DATA_KEY_SHIPPING_ADDRESS, Address.class);
	}

	public void setAddress(Address address) {
		put(DataLayerConstants.DATA_KEY_ADDRESS, address);
	}

	public void setProfileInfo(TransactionProfileInfo profileInfo) {
		put(DataLayerConstants.DATA_KEY_PROFILE_INFO, profileInfo);
	}

	public void setShippingAddress(Address shippingAddress) {
		put(DATA_KEY_SHIPPING_ADDRESS, shippingAddress);
	}
}
