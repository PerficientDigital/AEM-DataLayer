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
 * Data Layer Object representing a customer's shopping cart.
 * 
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.5</a>
 */
public class Cart extends CategorizableDataObject {

	public static final String DATA_KEY_CART_ID = "cartID";

	public Cart() {
		put(DataLayerConstants.DATA_KEY_ITEM, new ArrayList<Item>());
		put(DataLayerConstants.DATA_KEY_PRICE, new Price());
	}

	public String getCartID() {
		return get(DATA_KEY_CART_ID, String.class);
	}

	public List<Item> getItems() {
		if (!containsKey(DataLayerConstants.DATA_KEY_ITEM)) {
			return null;
		}
		return get(DataLayerConstants.DATA_KEY_ITEM, new ArrayList<Item>());
	}

	public Price getPrice() {
		return get(DataLayerConstants.DATA_KEY_PRICE, Price.class);
	}

	public void setCartID(String cartID) {
		put(DATA_KEY_CART_ID, cartID);
	}

	public void setItems(List<Item> items) {
		put(DataLayerConstants.DATA_KEY_ITEM, items);
	}

	public void setPrice(Price price) {
		put(DataLayerConstants.DATA_KEY_PRICE, price);
	}
}
