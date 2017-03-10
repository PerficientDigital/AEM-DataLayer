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
 * A Data Layer object representing the information for a particular product.
 * 
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.4</a>
 */
public class ProductInfo extends BaseDataObject {

	public static final String DATA_KEY_COLOR = "color";
	public static final String DATA_KEY_DESCRIPTION = "description";
	public static final String DATA_KEY_MANUFACTURER = "manufacturer";
	public static final String DATA_KEY_PRODUCT_ID = "productID";
	public static final String DATA_KEY_PRODUCT_IMAGE = "productImage";
	public static final String DATA_KEY_PRODUCT_NAME = "productName";
	public static final String DATA_KEY_PRODUCT_THUMBNAIL = "productThumbnail";
	public static final String DATA_KEY_PRODUCT_URL = "productURL";
	public static final String DATA_KEY_SIZE = "size";
	public static final String DATA_KEY_SKU = "sku";

	public String getColor() {
		return get(DATA_KEY_COLOR, String.class);
	}

	public String getDescription() {
		return get(DATA_KEY_DESCRIPTION, String.class);
	}

	public String getManufacturer() {
		return get(DATA_KEY_MANUFACTURER, String.class);
	}

	public String getProductID() {
		return get(DATA_KEY_PRODUCT_ID, String.class);
	}

	public String getProductImage() {
		return get(DATA_KEY_PRODUCT_IMAGE, String.class);
	}

	public String getProductName() {
		return get(DATA_KEY_PRODUCT_NAME, String.class);
	}

	public String getProductThumbnail() {
		return get(DATA_KEY_PRODUCT_THUMBNAIL, String.class);
	}

	public String getProductURL() {
		return get(DATA_KEY_PRODUCT_URL, String.class);
	}

	public String getSize() {
		return get(DATA_KEY_SIZE, String.class);
	}

	public String getSku() {
		return get(DATA_KEY_SKU, String.class);
	}

	public void setColor(String color) {
		put(DATA_KEY_COLOR, color);
	}

	public void setDescription(String description) {
		put(DATA_KEY_DESCRIPTION, description);
	}

	public void setManufacturer(String manufacturer) {
		put(DATA_KEY_MANUFACTURER, manufacturer);
	}

	public void setProductID(String productID) {
		put(DATA_KEY_PRODUCT_ID, productID);
	}

	public void setProductImage(String productImage) {
		put(DATA_KEY_PRODUCT_IMAGE, productImage);
	}

	public void setProductName(String productName) {
		put(DATA_KEY_PRODUCT_NAME, productName);
	}

	public void setProductThumbnail(String productThumbnail) {
		put(DATA_KEY_PRODUCT_THUMBNAIL, productThumbnail);
	}

	public void setProductURL(String productURL) {
		put(DATA_KEY_PRODUCT_URL, productURL);
	}

	public void setSize(String size) {
		put(DATA_KEY_SIZE, size);
	}

	public void setSku(String sku) {
		put(DATA_KEY_SKU, sku);
	}
}
