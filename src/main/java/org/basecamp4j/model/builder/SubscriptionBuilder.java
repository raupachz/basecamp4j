package org.basecamp4j.model.builder;

import org.basecamp4j.model.Subscription;
import org.basecamp4j.xml.DOMUtils;
import org.w3c.dom.Element;


/*
 * Copyright 2010 Björn Raupach

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
public class SubscriptionBuilder {
	
	private final Subscription subscription;
	
	public SubscriptionBuilder() {
		super();
		this.subscription = new Subscription();
	}
	
	public SubscriptionBuilder(Element element) {
		this();
		name(DOMUtils.getChildText(element,"name"));
		writeboards(DOMUtils.getChildText(element,"writeboards"));
		projects(DOMUtils.getChildText(element,"projects"));
		storage(DOMUtils.getChildText(element,"storage"));
		ssl(DOMUtils.getChildText(element,"ssl"));
		timeTracking(DOMUtils.getChildText(element,"time-tracking"));
	}
	
	public SubscriptionBuilder name(String name) {
		this.subscription.setName(name);
		return this;
	}
	
	public SubscriptionBuilder writeboards(String writeboards) {
		this.subscription.setWriteboards(writeboards);
		return this;
	}
	
	public SubscriptionBuilder projects(Integer projects) {
		this.subscription.setProjects(projects);
		return this;
	}
	
	public SubscriptionBuilder projects(String projects) {
		this.subscription.setProjects(Integer.valueOf(projects));
		return this;
	}
	
	public SubscriptionBuilder storage(Long storage) {
		this.subscription.setStorage(storage);
		return this;
	}
	
	public SubscriptionBuilder storage(String storage) {
		this.subscription.setStorage(Long.valueOf(storage));
		return this;
	}
	
	public SubscriptionBuilder ssl(Boolean ssl) {
		this.subscription.setSsl(ssl);
		return this;
	}
	
	public SubscriptionBuilder ssl(String ssl) {
		this.subscription.setSsl(Boolean.valueOf(ssl));
		return this;
	}
	
	public SubscriptionBuilder timeTracking(Boolean timeTracking) {
		this.subscription.setTimeTracking(timeTracking);
		return this;
	}
	
	public SubscriptionBuilder timeTracking(String timeTracking) {
		this.subscription.setTimeTracking(Boolean.valueOf(timeTracking));
		return this;
	}
	
	public Subscription build() {
		return subscription;
	}
	
}