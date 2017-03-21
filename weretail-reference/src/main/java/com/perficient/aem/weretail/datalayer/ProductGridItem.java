package com.perficient.aem.weretail.datalayer;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.adobe.cq.commerce.api.Product;
import com.day.cq.wcm.api.Page;
import com.perficient.aem.datalayer.api.Component;
import com.perficient.aem.datalayer.api.ComponentDataElement;
import com.perficient.aem.datalayer.api.DataLayer;
import com.perficient.aem.datalayer.api.ProductInfo;
import com.perficient.aem.datalayer.core.DataLayerUtil;

@Model(adaptables = Resource.class, resourceType = {
		"weretail/components/content/productgrid/item" }, adapters = ComponentDataElement.class)
public class ProductGridItem implements ComponentDataElement {

	private Resource resource;
	private Resource productDataResource;
	private Product productData;

	public ProductGridItem(Resource resource) {
		this.resource = resource;
		this.productDataResource = resource.getResourceResolver()
				.getResource(resource.getValueMap().get("cq:productMaster", String.class));
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
		Page page = dataLayer.getAEMPage();
		productInfo.setProductURL(DataLayerUtil.getSiteUrl(page, dataLayer.getConfig()));
		productInfo.setSku(productData.getSKU());
		product.setProductInfo(productInfo);
		product.addAttribute("displayType", "productgrid/item");
		dataLayer.addProduct(product);

		Component component = new Component();
		component.getComponentInfo().setComponentID(resource.getPath());
		component.addAttribute("type", "productgrid/item");
		component.addAttribute("productID", productData.getPath());
		dataLayer.addComponent(component);
	}

}
