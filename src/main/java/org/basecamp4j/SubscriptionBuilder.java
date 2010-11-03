package org.basecamp4j;

import org.jdom.Element;

class SubscriptionBuilder extends AbstractResourceBuilder<Subscription> {
	
	private final Subscription subscription;
	
	public SubscriptionBuilder() {
		super();
		this.subscription = new Subscription();
	}
	
	public SubscriptionBuilder(Element element) {
		this();
		name(element.getChildText("name"));
		writeboards(element.getChildText("writeboards"));
		projects(element.getChildText("projects"));
		storage(element.getChildText("storage"));
		ssl(element.getChildText("ssl"));
		timeTracking(element.getChildText("time-tracking"));
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