package org.basecamp4j;

import java.io.Serializable;

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
public class Person implements Serializable {
	
	private Long id;
	private String firstname;
	private String lastname;
	private String title;
	private String emailAddress;
	private String imHandle;
	private String imService;
	private String phoneNumberOffice;
	private String phoneNumberOfficeExt;
	private String phoneNumberMobile;
	private String phoneNumberHome;
	private String phoneNumberFax;
	private Long companyId;
	private Long clientId;
	private String avatarUrl;
	private String username;
	private Boolean administrator;
	private Boolean deleted;
	private Boolean hasAccessToNewProjects;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getImHandle() {
		return imHandle;
	}
	
	public void setImHandle(String imHandle) {
		this.imHandle = imHandle;
	}
	
	public String getImService() {
		return imService;
	}
	
	public void setImService(String imService) {
		this.imService = imService;
	}
	
	public String getPhoneNumberOffice() {
		return phoneNumberOffice;
	}
	
	public void setPhoneNumberOffice(String phoneNumberOffice) {
		this.phoneNumberOffice = phoneNumberOffice;
	}
	
	public String getPhoneNumberOfficeExt() {
		return phoneNumberOfficeExt;
	}
	
	public void setPhoneNumberOfficeExt(String phoneNumberOfficeExt) {
		this.phoneNumberOfficeExt = phoneNumberOfficeExt;
	}
	
	public String getPhoneNumberMobile() {
		return phoneNumberMobile;
	}
	
	public void setPhoneNumberMobile(String phoneNumberMobile) {
		this.phoneNumberMobile = phoneNumberMobile;
	}
	
	public String getPhoneNumberHome() {
		return phoneNumberHome;
	}
	
	public void setPhoneNumberHome(String phoneNumberHome) {
		this.phoneNumberHome = phoneNumberHome;
	}
	
	public String getPhoneNumberFax() {
		return phoneNumberFax;
	}
	
	public void setPhoneNumberFax(String phoneNumberFax) {
		this.phoneNumberFax = phoneNumberFax;
	}
	
	public Long getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	public Long getClientId() {
		return clientId;
	}
	
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	
	public String getAvatarUrl() {
		return avatarUrl;
	}
	
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Boolean getAdministrator() {
		return administrator;
	}
	
	public void setAdministrator(Boolean administrator) {
		this.administrator = administrator;
	}
	
	public Boolean getDeleted() {
		return deleted;
	}
	
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	public Boolean getHasAccessToNewProjects() {
		return hasAccessToNewProjects;
	}
	
	public void setHasAccessToNewProjects(Boolean hasAccessToNewProjects) {
		this.hasAccessToNewProjects = hasAccessToNewProjects;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("id",getId())
			.append("firstname",getFirstname())
			.append("lastname",getLastname())
			.append("title",getTitle())
			.append("emailAddress",getEmailAddress())
			.append("imHandle",getImHandle())
			.append("imService",getImService())
			.append("phoneNumberOffice",getPhoneNumberOffice())
			.append("phoneNumberOfficeExt",getPhoneNumberOfficeExt())
			.append("phoneNumberMobile",getPhoneNumberMobile())
			.append("phoneNumberHome",getPhoneNumberHome())
			.append("phoneNumberFax",getPhoneNumberFax())
			.append("companyId",getCompanyId())
			.append("clientId",getClientId())
			.append("avatarUrl",getAvatarUrl())
			.append("username",getUsername())
			.append("administrator",getAdministrator())
			.append("deleted",getDeleted())
			.append("hasAccessToNewProjects",getHasAccessToNewProjects())
			.toString();
	}
	
}
