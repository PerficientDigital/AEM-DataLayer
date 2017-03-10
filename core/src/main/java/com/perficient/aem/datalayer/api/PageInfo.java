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

import java.util.Date;

import com.perficient.aem.datalayer.DataLayerConstants;

/**
 * Data Layer object representing the data for a particular page.
 * 
 * @author danklco
 * @see <a href="https://www.w3.org/2013/12/ceddl-201312.pdf">Customer
 *      Experience Digital Data Layer, Section 6.3</a>
 */
public class PageInfo extends BaseDataObject {

	public static final String DATA_KEY_AUTHOR = "author";
	public static final String DATA_KEY_BREADCRUMBS = "breadcrumbs";
	public static final String DATA_KEY_DESTINATION_URL = "destinationURL";
	public static final String DATA_KEY_EFFECTIVE_DATE = "effectiveDate";
	public static final String DATA_KEY_EXPIRY_DATE = "expiryDate";
	public static final String DATA_KEY_INDUSTRY_CODES = "industryCodes";
	public static final String DATA_KEY_ISSUE_DATE = "issueDate";
	public static final String DATA_KEY_PAGE_ID = "pageID";
	public static final String DATA_KEY_PAGE_NAME = "pageName";
	public static final String DATA_KEY_PUBLISHER = "publisher";
	public static final String DATA_KEY_REFERRING_URL = "referringURL";
	public static final String DATA_KEY_SYS_ENV = "sysEnv";
	public static final String DATA_KEY_VARIANT = "variant";

	public String getAuthor() {
		return get(DATA_KEY_AUTHOR, String.class);
	}

	public String[] getBreadcrumbs() {
		return get(DATA_KEY_BREADCRUMBS, String[].class);
	}

	public String getDestinationUrl() {
		return get(DATA_KEY_DESTINATION_URL, String.class);
	}

	public Date getEffectiveDate() {
		return get(DATA_KEY_EFFECTIVE_DATE, Date.class);
	}

	public Date getExpiryDate() {
		return get(DATA_KEY_EXPIRY_DATE, Date.class);
	}

	public String getIndustryCodes() {
		return get(DATA_KEY_INDUSTRY_CODES, String.class);
	}

	public Date getIssueDate() {
		return get(DATA_KEY_ISSUE_DATE, Date.class);
	}

	public String getLanguage() {
		return get(DataLayerConstants.DATA_KEY_LANGUAGE, String.class);
	}

	public String getPageId() {
		return get(DATA_KEY_PAGE_ID, String.class);
	}

	public String getPageName() {
		return get(DATA_KEY_PAGE_NAME, String.class);
	}

	public String getPublisher() {
		return get(DATA_KEY_PUBLISHER, String.class);
	}

	public String getReferringUrl() {
		return get(DATA_KEY_REFERRING_URL, String.class);
	}

	public String getSysEnv() {
		return get(DATA_KEY_SYS_ENV, String.class);
	}

	public String getVariant() {
		return get(DATA_KEY_VARIANT, String.class);
	}

	public void setAuthor(String author) {
		put(DATA_KEY_AUTHOR, author);
	}

	public void setBreadcrumbs(String[] breadcrumbs) {
		put(DATA_KEY_BREADCRUMBS, breadcrumbs);
	}

	public void setDestinationUrl(String destinationUrl) {
		put(DATA_KEY_DESTINATION_URL, destinationUrl);
	}

	public void setEffectiveDate(Date effectiveDate) {
		put(DATA_KEY_EFFECTIVE_DATE, effectiveDate);
	}

	public void setExpiryDate(Date expiryDate) {
		put(DATA_KEY_EXPIRY_DATE, expiryDate);
	}

	public void setIndustryCodes(String industryCodes) {
		put(DATA_KEY_INDUSTRY_CODES, industryCodes);
	}

	public void setIssueDate(Date issueDate) {
		put(DATA_KEY_ISSUE_DATE, issueDate);
	}

	public void setLanguage(String language) {
		put(DataLayerConstants.DATA_KEY_LANGUAGE, language);
	}

	public void setPageId(String pageId) {
		put(DATA_KEY_PAGE_ID, pageId);
	}

	public void setPageName(String pageName) {
		put(DATA_KEY_PAGE_NAME, pageName);
	}

	public void setPublisher(String publisher) {
		put(DATA_KEY_PUBLISHER, publisher);
	}

	public void setReferringUrl(String referringUrl) {
		put(DATA_KEY_REFERRING_URL, referringUrl);
	}

	public void setSysEnv(String sysEnv) {
		put(DATA_KEY_SYS_ENV, sysEnv);
	}

	public void setVariant(String variant) {
		put(DATA_KEY_VARIANT, variant);
	}

}
