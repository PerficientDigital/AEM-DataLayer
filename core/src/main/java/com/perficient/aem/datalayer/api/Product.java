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

/**
 * A DataLayer object representing a product.
 * 
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.4</a>
 */
public class Product extends CategorizableDataObject {

	public static final String DATA_KEY_LINKED_PRODUCT = "linkedProduct";

	public static final String DATA_KEY_PRODUCT_INFO = "productInfo";

	public Product() {
		put(DATA_KEY_PRODUCT_INFO, new ProductInfo());
	}

	public List<ProductInfo> getLinkedProducts() {
		List<ProductInfo> defaultLinkedProducts = new ArrayList<ProductInfo>();
		if (!containsKey(DATA_KEY_LINKED_PRODUCT)) {
			return null;
		}
		return get(DATA_KEY_LINKED_PRODUCT, defaultLinkedProducts);
	}

	public ProductInfo getProductInfo() {
		return get(DATA_KEY_PRODUCT_INFO, ProductInfo.class);
	}

	public void setLinkedProducts(List<ProductInfo> linkedProducts) {
		put(DATA_KEY_LINKED_PRODUCT, linkedProducts);
	}

	public void setProductInfo(ProductInfo productInfo) {
		put(DATA_KEY_PRODUCT_INFO, productInfo);
	}
}
