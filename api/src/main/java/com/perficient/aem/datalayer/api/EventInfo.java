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

/**
 * Represents the information stored in the data layer for an event.
 * 
 * @author danklco
 */
public class EventInfo extends BaseDataObject {

	public static final String DATA_KEY_CAUSE = "cause";
	public static final String DATA_KEY_EFFECT = "effect";
	public static final String DATA_KEY_EVENT_ACTION = "eventAction";
	public static final String DATA_KEY_EVENT_NAME = "eventName";
	public static final String DATA_KEY_EVENT_POINTS = "eventPoints";
	public static final String DATA_KEY_TIMESTAMP = "timeStamp";
	public static final String DATA_KEY_TYPE = "type";

	public String getCause() {
		return get(DATA_KEY_CAUSE, String.class);
	}

	public String getEffect() {
		return get(DATA_KEY_EFFECT, String.class);
	}

	public String getEventAction() {
		return get(DATA_KEY_EVENT_ACTION, String.class);
	}

	public String getEventName() {
		return get(DATA_KEY_EVENT_NAME, String.class);
	}

	public Integer getEventPoints() {
		return get(DATA_KEY_EVENT_POINTS, Integer.class);
	}

	public Date getTimestamp() {
		return get(DATA_KEY_TIMESTAMP, Date.class);
	}

	public String getType() {
		return get(DATA_KEY_TYPE, String.class);
	}

	public void setCause(String cause) {
		put(DATA_KEY_CAUSE, cause);
	}

	public void setEffect(String effect) {
		put(DATA_KEY_EFFECT, effect);
	}

	public void setEventAction(String eventAction) {
		put(DATA_KEY_EVENT_ACTION, eventAction);
	}

	public void setEventName(String eventName) {
		put(DATA_KEY_EVENT_NAME, eventName);
	}

	public void setEventPoints(Integer eventPoints) {
		put(DATA_KEY_EVENT_POINTS, eventPoints);
	}

	public void setTimestamp(Date timestamp) {
		put(DATA_KEY_TIMESTAMP, timestamp);
	}

	public void setType(Date type) {
		put(DATA_KEY_TYPE, type);
	}

}
