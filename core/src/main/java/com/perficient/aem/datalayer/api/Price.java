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
 * Data Layer Object representing the price of a shopping cart or an item in the
 * cart.
 * 
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.5</a>
 */
public class Price extends BaseDataObject {

	public static final String DATA_KEY_BASE_PRICE = "basePrice";
	public static final String DATA_KEY_CURRENCY = "currency";
	public static final String DATA_KEY_PRICE_WITH_TAX = "priceWithTax";
	public static final String DATA_KEY_SHIPPING = "shipping";
	public static final String DATA_KEY_SHIPPING_METHOD = "shippingMethod";
	public static final String DATA_KEY_TAX_RATE = "taxRate";
	public static final String DATA_KEY_VOUCHER_CODE = "voucherCode";
	public static final String DATA_KEY_VOUCHER_DISCOUNT = "voucherDiscount";

	public double getBasePrice() {
		return get(DATA_KEY_BASE_PRICE, Double.class);
	}

	public String getCurrency() {
		return get(DATA_KEY_CURRENCY, String.class);
	}

	public double getPriceWithTax() {
		return get(DATA_KEY_PRICE_WITH_TAX, Double.class);
	}

	public double getShipping() {
		return get(DATA_KEY_SHIPPING, Double.class);
	}

	public String getShippingMethod() {
		return get(DATA_KEY_SHIPPING_METHOD, String.class);
	}

	public double getTaxRate() {
		return get(DATA_KEY_TAX_RATE, Double.class);
	}

	public String getVoucherCode() {
		return get(DATA_KEY_VOUCHER_CODE, String.class);
	}

	public double getVoucherDisount() {
		return get(DATA_KEY_VOUCHER_DISCOUNT, Double.class);
	}

	public void setBasePrice(double basePrice) {
		put(DATA_KEY_BASE_PRICE, basePrice);
	}

	public void setCurrency(String currency) {
		put(DATA_KEY_CURRENCY, currency);
	}

	public void setPriceWithTax(double priceWithTax) {
		put(DATA_KEY_PRICE_WITH_TAX, priceWithTax);
	}

	public void setShipping(double shipping) {
		put(DATA_KEY_SHIPPING, shipping);
	}

	public void setShippingMethod(String shippingMethod) {
		put(DATA_KEY_SHIPPING_METHOD, shippingMethod);
	}

	public void setTaxRate(double taxRate) {
		put(DATA_KEY_TAX_RATE, taxRate);
	}

	public void setVoucherCode(String voucherCode) {
		put(DATA_KEY_VOUCHER_CODE, voucherCode);
	}

	public void setVoucherDiscount(double voucherDiscount) {
		put(DATA_KEY_VOUCHER_DISCOUNT, voucherDiscount);
	}

}
