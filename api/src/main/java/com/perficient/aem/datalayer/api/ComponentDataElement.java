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

import com.perficient.aem.datalayer.api.DataLayer;

/**
 * Interface for all component-based data elements to implement.
 * 
 * @author danklco
 */
public interface ComponentDataElement {

	/**
	 * Method called by the AEMDataLayerModel when adapting this class from a
	 * resource in order to update the information in the Data Layer.
	 * 
	 * @param dataLayer
	 *            the data layer to update
	 */
	void updateDataLayer(DataLayer dataLayer);
}
