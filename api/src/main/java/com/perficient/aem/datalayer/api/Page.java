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
 * Data Layer object representing a particular page.
 * 
 * @author danklco
 */
public class Page extends BaseDataObject {

	public Page() {
		super();
		setPageInfo(new PageInfo());
	}

	public static final String DATA_KEY_PAGE_INFO = "pageInfo";

	public PageInfo getPageInfo() {
		return get(DATA_KEY_PAGE_INFO, PageInfo.class);
	}

	public void setPageInfo(PageInfo pageInfo) {
		put(DATA_KEY_PAGE_INFO, pageInfo);
	}

}
