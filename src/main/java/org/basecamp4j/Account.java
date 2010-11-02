package org.basecamp4j;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.jdom.Element;

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
	
	
	public static class Builder {
		
		private final Account account;
		
		public Builder() {
			this.account = new Account();
		}
		
		public Builder(Element element) {
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
		
		public Builder id(Long id) {
			this.account.setId(id);
			return this;
		}
		
		public Builder id(String id) {
			this.account.setId(Long.valueOf(id));
			return this;
		}
		
		public Builder name(String name) {
			this.account.setName(name);
			return this;
		}
		
		public Builder accountHolderId(Long accountHolderId) {
			this.account.setAccountHolderId(accountHolderId);		
			return this;
		}
		
		public Builder accountHolderId(String accountHolderId) {
			this.account.setAccountHolderId(Long.valueOf(accountHolderId));
			return this;
		}
		
		public Builder primaryCompanyId(Long primaryCompanyId) {
			this.account.setPrimaryCompanyId(primaryCompanyId);		
			return this;
		}
		
		public Builder primaryCompanyId(String primaryCompanyId) {
			this.account.setPrimaryCompanyId(Long.valueOf(primaryCompanyId));
			return this;
		}
		
		public Builder sslEnabled(Boolean sslEnabled) {
			this.account.setSslEnabled(sslEnabled);
			return this;
		}
		
		public Builder sslEnabled(String sslEnabled) {
			this.account.setSslEnabled(Boolean.valueOf(sslEnabled));
			return this;
		}
		
		public Builder emailNotificiationEnabled(Boolean emailNotificationEnabled) {
			this.account.setEmailNotificationEnabled(emailNotificationEnabled);
			return this;
		}
		
		public Builder emailNotificiationEnabled(String emailNotificationEnabled) {
			this.account.setEmailNotificationEnabled(Boolean.valueOf(emailNotificationEnabled));
			return this;
		}
		
		public Builder timeTrackingEnabled(Boolean timeTrackingEnabled) {
			this.account.setTimeTrackingEnabled(timeTrackingEnabled);
			return this;
		}
		
		public Builder timeTrackingEnabled(String timeTrackingEnabled) {
			this.account.setTimeTrackingEnabled(Boolean.valueOf(timeTrackingEnabled));
			return this;
		}
		
		public Builder updatedAt(Date updatedAt) {
			this.account.setUpdatedAt(updatedAt);
			return this;
		}
		
		public Builder updatedAt(String updatedAt) {
			this.account.setUpdatedAt(BasecampApi.parseISODateTime(updatedAt));
			return this;
		}
		
		public Builder createdAt(String createdAt) {
			this.account.setCreatedAt(BasecampApi.parseISODateTime(createdAt));
			return this;
		}
		
		public Builder createdAt(Date createdAt) {
			this.account.setCreatedAt(createdAt);
			return this;
		}
		
		public Builder storage(Long storage) {
			this.account.setStorage(storage);
			return this;
		}
		
		public Builder storage(String storage) {
			this.account.setStorage(Long.valueOf(storage));
			return this;
		}
		
		public Account build() {
			return account;
		}
	}
	
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
