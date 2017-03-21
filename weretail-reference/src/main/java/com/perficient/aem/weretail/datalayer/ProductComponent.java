package com.perficient.aem.weretail.datalayer;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.adobe.cq.commerce.api.CommerceConstants;
import com.adobe.cq.commerce.api.Product;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.perficient.aem.datalayer.api.Component;
import com.perficient.aem.datalayer.api.ComponentDataElement;
import com.perficient.aem.datalayer.api.DataLayer;
import com.perficient.aem.datalayer.api.ProductInfo;
import com.perficient.aem.datalayer.core.DataLayerUtil;

@Model(adaptables = Resource.class, resourceType = {
		"weretail/components/structure/product" }, adapters = ComponentDataElement.class)
public class ProductComponent implements ComponentDataElement {

	private final Resource resource;

	private final Resource productDataResource;

	private final Product productData;

	public ProductComponent(Resource resource) {
		this.resource = resource;
		this.productDataResource = resource.getResourceResolver()
				.getResource(resource.getValueMap().get(CommerceConstants.PN_PRODUCT_DATA, String.class));
		productData = productDataResource.adaptTo(Product.class);
	}

	@Override
	public void updateDataLayer(DataLayer dataLayer) {

		com.perficient.aem.datalayer.api.Product product = new com.perficient.aem.datalayer.api.Product();
		ProductInfo productInfo = product.getProductInfo();
		productInfo.setDescription(productData.getDescription());
		productInfo.setProductID(productData.getPath());
		productInfo.setProductImage(dataLayer.getConfig().getUrlPrefix() + productData.getImageUrl());
		productInfo.setProductName(productData.getTitle());
		productInfo.setProductThumbnail(dataLayer.getConfig().getUrlPrefix() + productData.getThumbnailUrl());
		Page page = resource.getResourceResolver().adaptTo(PageManager.class).getContainingPage(resource);
		productInfo.setProductURL(DataLayerUtil.getSiteUrl(page, dataLayer.getConfig()));
		productInfo.setSku(productData.getSKU());
		product.setProductInfo(productInfo);
		dataLayer.addProduct(product);
		
		Component component = new Component();
		component.getComponentInfo().setComponentID(resource.getPath());
		component.addAttribute("type", "product");
		dataLayer.addComponent(component);
	}

}
