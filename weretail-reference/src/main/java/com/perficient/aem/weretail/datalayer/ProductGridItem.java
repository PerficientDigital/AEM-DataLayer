package com.perficient.aem.weretail.datalayer;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.adobe.cq.commerce.api.CommerceConstants;
import com.adobe.cq.commerce.api.Product;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.perficient.aem.datalayer.api.Component;
import com.perficient.aem.datalayer.api.ComponentDataElement;
import com.perficient.aem.datalayer.api.ProductInfo;
import com.perficient.aem.datalayer.core.DataLayerUtil;
import com.perficient.aem.datalayer.core.models.DataLayerModel;

@Model(adaptables = Resource.class, resourceType = {
		"weretail/components/content/productgrid/item" }, adapters = ComponentDataElement.class)
public class ProductGridItem implements ComponentDataElement {
	
	private Resource resource;
	private Resource productDataResource;
	private Product productData;

	public ProductGridItem(Resource resource){
		this.resource = resource;
		this.productDataResource = resource.getResourceResolver()
				.getResource(resource.getValueMap().get(CommerceConstants.PN_PRODUCT_DATA, String.class));
		productData = productDataResource.adaptTo(Product.class);
	}

	@Override
	public void updateDataLayer(DataLayerModel dataLayer) {

		List<com.perficient.aem.datalayer.api.Product> products = dataLayer.getProducts();
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
		products.add(product);
		
		Component component = new Component();
		component.getComponentInfo().setComponentID(resource.getPath());
		component.addAttribute("type", "productgrid/item");
		dataLayer.addComponent(component);
	}

}
