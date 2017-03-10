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
 * An DataLayer object representing an item in a user's cart
 * 
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.5</a>
 */
public class Item extends Product {

	public static final String DATA_KEY_QUANTITY = "quantity";

	public Item() {
		put(DataLayerConstants.DATA_KEY_PRICE, new Price());
	}

	public Price getPrice() {
		return get(DataLayerConstants.DATA_KEY_PRICE, Price.class);
	}

	public long getQuantity() {
		return get(DATA_KEY_QUANTITY, Long.class);
	}

	public void setPrice(Price price) {
		put(DataLayerConstants.DATA_KEY_PRICE, price);
	}

	public void setQuantity(long quantity) {
		put(DATA_KEY_QUANTITY, quantity);
	}

}
