package org.basecamp4j;

import java.util.Date;

import org.jdom.Element;

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
class AccountBuilder extends AbstractResourceBuilder<Account> {
	
	private final Account account;
	
	public AccountBuilder() {
		super();
		this.account = new Account();
	}
	
	public AccountBuilder(Element element) {
		this();
		id(element.getChildText("id"));
		name(element.getChildText("name"));
		accountHolderId(element.getChildText("account-holder-id"));
		primaryCompanyId(element.getChildText("primary-company-id"));
		sslEnabled(element.getChildText("ssl-enabled"));
		emailNotificiationEnabled(element.getChildText("email-notification-enabled"));
		timeTrackingEnabled(element.getChildText("time-tracking-enabled"));
		updatedAt(element.getChildText("updated-at"));
		createdAt(element.getChildText("created-at"));
		storage(element.getChildText("storage"));
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
		this.account.setUpdatedAt(parseISODateTime(updatedAt));
		return this;
	}
	
	public AccountBuilder createdAt(String createdAt) {
		this.account.setCreatedAt(parseISODateTime(createdAt));
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