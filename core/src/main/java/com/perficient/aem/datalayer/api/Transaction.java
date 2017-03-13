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
import java.util.List;

import com.perficient.aem.datalayer.DataLayerConstants;

/**
 * DataLayer object representing a completed transaction.
 * 
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.6</a>
 */
public class Transaction extends CategorizableDataObject {
	public static final String DATA_KEY_TOTAL = "total";
	public static final String DATA_KEY_TRANSACTION_ID = "transactionID";

	public Transaction() {
		setItems(new ArrayList<Item>());
	}

	public List<Item> getItems() {
		if (!containsKey(DataLayerConstants.DATA_KEY_ITEM)) {
			return null;
		}
		return get(DataLayerConstants.DATA_KEY_ITEM, new ArrayList<Item>());
	}

	public TransactionProfile getProfile() {
		return get(DataLayerConstants.DATA_KEY_PROFILE, TransactionProfile.class);
	}

	public Price getTotal() {
		return get(DATA_KEY_TOTAL, Price.class);
	}

	public String getTransactionID() {
		return get(DATA_KEY_TRANSACTION_ID, String.class);
	}

	public void setItems(List<Item> items) {
		put(DataLayerConstants.DATA_KEY_ITEM, items);
	}

	public void setProfile(TransactionProfile profile) {
		put(DataLayerConstants.DATA_KEY_PROFILE, profile);
	}

	public void setTotal(Price total) {
		put(DATA_KEY_TOTAL, total);
	}

	public void setTransactionID(String transactionID) {
		put(DATA_KEY_TRANSACTION_ID, transactionID);
	}
}
