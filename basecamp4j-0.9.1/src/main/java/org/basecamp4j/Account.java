package org.basecamp4j;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

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
public class Account implements Serializable {
	
	private Date createdAt;
	private Long id;
	private Date updatedAt;
	private String name;
	private Long accountHolderId;
	private Boolean sslEnabled;
	private Boolean timeTrackingEnabled;
	private Boolean emailNotificationEnabled;
	private Long storage;
	private Long primaryCompanyId;
	private Subscription subscription;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getAccountHolderId() {
		return accountHolderId;
	}
	
	public void setAccountHolderId(Long accountHolderId) {
		this.accountHolderId = accountHolderId;
	}
	
	public Long getPrimaryCompanyId() {
		return primaryCompanyId;
	}
	
	public void setPrimaryCompanyId(Long primaryCompanyId) {
		this.primaryCompanyId = primaryCompanyId;
	}
	
	public Boolean getSslEnabled() {
		return sslEnabled;
	}
	
	public void setSslEnabled(Boolean sslEnabled) {
		this.sslEnabled = sslEnabled;
	}
	
	public Boolean getEmailNotificationEnabled() {
		return emailNotificationEnabled;
	}
	
	public void setEmailNotificationEnabled(Boolean emailNotificationEnabled) {
		this.emailNotificationEnabled = emailNotificationEnabled;
	}
	
	public Boolean getTimeTrackingEnabled() {
		return timeTrackingEnabled;
	}
	
	public void setTimeTrackingEnabled(Boolean timeTrackingEnabled) {
		this.timeTrackingEnabled = timeTrackingEnabled;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getStorage() {
		return storage;
	}

	public void setStorage(Long storage) {
		this.storage = storage;
	}
	
	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id",getId())
			.append("name",getName())
			.append("accountHolderId",getAccountHolderId())
			.append("primaryCompanyId",getPrimaryCompanyId())
			.append("sslEnabled",getSslEnabled())
			.append("emailNotificationEnabled",getEmailNotificationEnabled())
			.append("timeTrackingEnabled",getTimeTrackingEnabled())
			.append("updatedAt",getUpdatedAt())
			.append("createdAt",getUpdatedAt())
			.append("storage",getStorage())
			.append("subscription",getSubscription())
			.toString();
	}

	
	
}
