package org.basecamp4j.model.builder;

import java.util.Date;

import org.basecamp4j.model.Account;
import org.basecamp4j.utils.IsoDateTimeFormat;
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
public class AccountBuilder {
	
	private final Account account;
	
	public AccountBuilder() {
		super();
		this.account = new Account();
	}
	
	public AccountBuilder(Element element) {
		this();
		id(DOMUtils.getChildText(element,"id"));
		name(DOMUtils.getChildText(element,"name"));
		accountHolderId(DOMUtils.getChildText(element,"account-holder-id"));
		primaryCompanyId(DOMUtils.getChildText(element,"primary-company-id"));
		sslEnabled(DOMUtils.getChildText(element,"ssl-enabled"));
		emailNotificiationEnabled(DOMUtils.getChildText(element,"email-notification-enabled"));
		timeTrackingEnabled(DOMUtils.getChildText(element,"time-tracking-enabled"));
		updatedAt(DOMUtils.getChildText(element,"updated-at"));
		createdAt(DOMUtils.getChildText(element,"created-at"));
		storage(DOMUtils.getChildText(element,"storage"));
	}
	
	public AccountBuilder id(Long id) {
		this.account.setId(id);
		return this;
	}
	
	public AccountBuilder id(String id) {
		this.account.setId(Long.valueOf(id));
		return this;
	}
	
	public AccountBuilder name(String name) {
		this.account.setName(name);
		return this;
	}
	
	public AccountBuilder accountHolderId(Long accountHolderId) {
		this.account.setAccountHolderId(accountHolderId);		
		return this;
	}
	
	public AccountBuilder accountHolderId(String accountHolderId) {
		this.account.setAccountHolderId(Long.valueOf(accountHolderId));
		return this;
	}
	
	public AccountBuilder primaryCompanyId(Long primaryCompanyId) {
		this.account.setPrimaryCompanyId(primaryCompanyId);		
		return this;
	}
	
	public AccountBuilder primaryCompanyId(String primaryCompanyId) {
		this.account.setPrimaryCompanyId(Long.valueOf(primaryCompanyId));
		return this;
	}
	
	public AccountBuilder sslEnabled(Boolean sslEnabled) {
		this.account.setSslEnabled(sslEnabled);
		return this;
	}
	
	public AccountBuilder sslEnabled(String sslEnabled) {
		this.account.setSslEnabled(Boolean.valueOf(sslEnabled));
		return this;
	}
	
	public AccountBuilder emailNotificiationEnabled(Boolean emailNotificationEnabled) {
		this.account.setEmailNotificationEnabled(emailNotificationEnabled);
		return this;
	}
	
	public AccountBuilder emailNotificiationEnabled(String emailNotificationEnabled) {
		this.account.setEmailNotificationEnabled(Boolean.valueOf(emailNotificationEnabled));
		return this;
	}
	
	public AccountBuilder timeTrackingEnabled(Boolean timeTrackingEnabled) {
		this.account.setTimeTrackingEnabled(timeTrackingEnabled);
		return this;
	}
	
	public AccountBuilder timeTrackingEnabled(String timeTrackingEnabled) {
		this.account.setTimeTrackingEnabled(Boolean.valueOf(timeTrackingEnabled));
		return this;
	}
	
	public AccountBuilder updatedAt(Date updatedAt) {
		this.account.setUpdatedAt(updatedAt);
		return this;
	}
	
	public AccountBuilder updatedAt(String updatedAt) {
		this.account.setUpdatedAt(IsoDateTimeFormat.parseDateTime(updatedAt));
		return this;
	}
	
	public AccountBuilder createdAt(String createdAt) {
		this.account.setCreatedAt(IsoDateTimeFormat.parseDateTime(createdAt));
		return this;
	}
	
	public AccountBuilder createdAt(Date createdAt) {
		this.account.setCreatedAt(createdAt);
		return this;
	}
	
	public AccountBuilder storage(Long storage) {
		this.account.setStorage(storage);
		return this;
	}
	
	public AccountBuilder storage(String storage) {
		this.account.setStorage(Long.valueOf(storage));
		return this;
	}
	
	public Account build() {
		return account;
	}
}