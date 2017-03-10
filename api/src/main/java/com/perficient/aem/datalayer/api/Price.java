package com.perficient.aem.datalayer.api;

import java.util.HashMap;

import org.apache.sling.api.wrappers.ValueMapDecorator;

public class Price extends ValueMapDecorator {

	public Price() {
		super(new HashMap<String,Object>());
	}
	
	
	/*basePrice (Number), voucherCode (String), voucherDiscount (Number),
	currency (String), taxRate (Number), shipping (Number), shippingMethod (String),
	priceWithTax (Number)*/


}
