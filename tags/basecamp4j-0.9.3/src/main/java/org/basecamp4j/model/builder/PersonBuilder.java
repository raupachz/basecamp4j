package org.basecamp4j.model.builder;

import org.basecamp4j.model.Person;
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
public class PersonBuilder {
	
	private final Person person;
	
	public PersonBuilder() {
		super();
		this.person = new Person();
	}
	
	public PersonBuilder(Element element) {
		this();
		id(DOMUtils.getChildText(element,"id"));
		firstname(DOMUtils.getChildText(element,"first-name"));
		lastname(DOMUtils.getChildText(element,"last-name"));
		title(DOMUtils.getChildText(element,"title"));
		emailAddress(DOMUtils.getChildText(element,"email-address"));
		imHandle(DOMUtils.getChildText(element,"im-handle"));
		imService(DOMUtils.getChildText(element,"im-service"));
		phoneNumberOffice(DOMUtils.getChildText(element,"phone-number-office"));
		phoneNumberOfficeExt(DOMUtils.getChildText(element,"phone-number-office-ext"));
		phoneNumberMobile(DOMUtils.getChildText(element,"phone-number-mobile"));
		phoneNumberHome(DOMUtils.getChildText(element,"phone-number-home"));
		phoneNumberFax(DOMUtils.getChildText(element,"phone-number-fax"));
		companyId(DOMUtils.getChildText(element,"company-id"));
		avatarUrl(DOMUtils.getChildText(element,"avatar-url"));
		username(DOMUtils.getChildText(element,"user-name"));
		administrator(DOMUtils.getChildText(element,"administrator"));
		deleted(DOMUtils.getChildText(element,"deleted"));
		hasAccessToNewProjects(DOMUtils.getChildText(element,"has-access-to-new-projects"));
		
	}
	
	public PersonBuilder id(Long id) {
		this.person.setId(id);
		return this;
	}
	
	public PersonBuilder id(String id) {
		return id(Long.valueOf(id));
	}
	
	public PersonBuilder firstname(String firstname) {
		this.person.setFirstname(firstname);
		return this;
	}
	
	public PersonBuilder lastname(String lastname) {
		this.person.setLastname(lastname);
		return this;
	}
	
	public PersonBuilder title(String title) {
		this.person.setTitle(title);
		return this;
	}
	
	public PersonBuilder emailAddress(String emailAddress) {
		this.person.setEmailAddress(emailAddress);
		return this;
	}
	
	public PersonBuilder imHandle(String imHandle) {
		this.person.setImHandle(imHandle);
		return this;
	}
	
	public PersonBuilder imService(String imService) {
		this.person.setImService(imService);
		return this;
	}
	
	public PersonBuilder phoneNumberOffice(String phoneNumberOffice) {
		this.person.setPhoneNumberOffice(phoneNumberOffice);
		return this;
	}
	
	public PersonBuilder phoneNumberOfficeExt(String phoneNumberOfficeExt) {
		this.person.setPhoneNumberOfficeExt(phoneNumberOfficeExt);
		return this;
	}
	
	public PersonBuilder phoneNumberMobile(String phoneNumberMobile) {
		this.person.setPhoneNumberMobile(phoneNumberMobile);
		return this;
	}
	
	public PersonBuilder phoneNumberHome(String phoneNumberHome) {
		this.person.setPhoneNumberHome(phoneNumberHome);
		return this;
	}
	
	public PersonBuilder phoneNumberFax(String phoneNumberFax) {
		this.person.setPhoneNumberFax(phoneNumberFax);
		return this;
	}
	
	public PersonBuilder companyId(Long companyId) {
		this.person.setCompanyId(companyId);
		return this;
	}
	
	public PersonBuilder companyId(String companyId) {
		this.person.setCompanyId(Long.valueOf(companyId));
		return this;
	}
	
	public PersonBuilder clientId(Long clientId) {
		this.person.setClientId(clientId);
		return this;
	}
	
	public PersonBuilder clientId(String clientId) {
		this.person.setClientId(Long.valueOf(clientId));
		return this;
	}
	
	public PersonBuilder avatarUrl(String avatarUrl) {
		this.person.setAvatarUrl(avatarUrl);
		return this;
	}
	
	public PersonBuilder username(String username) {
		this.person.setUsername(username);
		return this;
	}
	
	public PersonBuilder administrator(Boolean administrator) {
		this.person.setAdministrator(administrator);
		return this;
	}
	
	public PersonBuilder administrator(String administrator) {
		this.person.setAdministrator(Boolean.valueOf(administrator));
		return this;
	}
	
	public PersonBuilder deleted(Boolean deleted) {
		this.person.setDeleted(deleted);
		return this;
	}
	
	public PersonBuilder deleted(String deleted) {
		this.person.setDeleted(Boolean.valueOf(deleted));
		return this;
	}
	
	public PersonBuilder hasAccessToNewProjects(Boolean hasAccessToNewProjects) {
		this.person.setHasAccessToNewProjects(hasAccessToNewProjects);
		return this;
	}
	
	public PersonBuilder hasAccessToNewProjects(String hasAccessToNewProjects) {
		this.person.setHasAccessToNewProjects(Boolean.valueOf(hasAccessToNewProjects));
		return this;
	}
	
	public Person build() {
		return this.person;
	}

}