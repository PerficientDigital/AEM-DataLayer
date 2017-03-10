package com.perficient.aem.datalayer.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This class wraps the AEMDataLayer to enable EL bean access to the JSON
 * representation of the data layer.
 * 
 * @author danklco
 */
@Model(adaptables = Resource.class)
public class AEMDataLayerManager {
	private final DataLayerModel dataLayer;

	public AEMDataLayerManager(Resource resource) {
		dataLayer = resource.adaptTo(DataLayerModel.class);
	}

	public String getJson() {
		String json = null;
		if (dataLayer.getConfig().getPrettyPrint() == true) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			json = gson.toJson(dataLayer);
		} else {
			json = dataLayer.getJson();
		}
		return json;
	}

	public AEMDataLayerConfig getConfig() {
		return dataLayer.getConfig();
	}
}
