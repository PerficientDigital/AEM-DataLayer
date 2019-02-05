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
package com.perficient.aem.datalayer;

/**
 * Constants for the AEM DataLayer library.
 * 
 * @author danklco
 */
public class DataLayerConstants {

	public static final String DATA_KEY_PRICE = "price";
	public static final String DATA_KEY_ITEM = "item";
	public static final String DATA_KEY_PROFILE = "profile";
	public static final String DATA_KEY_PROFILE_INFO = "profileInfo";
	public static final String DATA_KEY_ADDRESS = "address";
	public static final String DATA_KEY_ATTRIBUTES = "attributes";
	public static final String DATA_KEY_LANGUAGE = "language";
	public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssX'00'";
	public static final String REQUEST_PROPERTY_AEM_DATALAYER = "AEM_DATALAYER";
	public static final String SERVICE_VENDOR = "Perficient";
	@SuppressWarnings("squid:S1075")
	public static final String AEM_DATALAYER_CONFIG_PATH = "/etc/cloudservices/aemdatalayer";
	public static final String PN_CLOUD_SERVICE_CONFIGS = "cq:cloudserviceconfigs";

	private DataLayerConstants() {
		// hidden
	}
}
