package com.perficient.aem.datalayer.core;

import com.day.cq.wcm.api.Page;
import com.perficient.aem.datalayer.core.models.AEMDataLayerConfig;

public class DataLayerUtil {

	public static String getSiteUrl(Page page, AEMDataLayerConfig config) {
		String subpath = getSiteSubpath(page, config);
		return config.getUrlPrefix() + subpath + ".html";
	}

	public static String getSiteSubpath(Page page, AEMDataLayerConfig config) {
		String path = page.getPath().replace(page.getAbsoluteParent(config.getSiteRootLevel()).getPath(), "");
		return path;
	}
}
