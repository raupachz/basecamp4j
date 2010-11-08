package org.basecamp4j;

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
class CompanyBuilder extends AbstractResourceBuilder<Company> {
	
	private final Company company;
	
	public CompanyBuilder() {
		super();
		this.company = new Company();
	}
	
	public CompanyBuilder(Element element) {
		this();
		id(element.getChildText("id"));
		name(element.getChildText("name"));
		addressOne(element.getChildText("address-one"));
		addressTwo(element.getChildText("address-two"));
		city(element.getChildText("city"));
		state(element.getChildText("state"));
		zip(element.getChildText("zip"));
		country(element.getChildText("country"));
		webAddress(element.getChildText("web-address"));
		phoneNumberOffice(element.getChildText("phone-number-office"));
		phoneNumberFax(element.getChildText("phone-number-fax"));
		timeZoneId(element.getChildText("time-zone-id"));
		canSeePrivate(element.getChildText("can-see-private"));
		urlName(element.getChildText("url-name"));
	}
	
	public CompanyBuilder id(Long id) {
		this.company.setId(id);
		return this;
	}
	
	public CompanyBuilder id(String id) {
		this.company.setId(Long.valueOf(id));
		return this;
	}
	
	public CompanyBuilder name(String name) {
		this.company.setName(name);
		return this;
	}
	
	public CompanyBuilder addressOne(String addressOne) {
		this.company.setAddressOne(addressOne);
		return this;
	}
	
	public CompanyBuilder addressTwo(String addressTwo) {
		this.company.setAddressTwo(addressTwo);
		return this;
	}
	
	public CompanyBuilder city(String city) {
		this.company.setCity(city);
		return this;
	}
	
	public CompanyBuilder state(String state) {
		this.company.setState(state);
		return this;
	}
	
	public CompanyBuilder zip(String zip) {
		this.company.setZip(zip);
		return this;
	}
	
	public CompanyBuilder country(String country) {
		this.company.setCountry(country);
		return this;
	}
	
	public CompanyBuilder webAddress(String webAddress) {
		this.company.setWebAddress(webAddress);
		return this;
	}
	
	public CompanyBuilder phoneNumberOffice(String phoneNumberOffice) {
		this.company.setPhoneNumberOffice(phoneNumberOffice);
		return this;
	}
	
	public CompanyBuilder phoneNumberFax(String phoneNumberFax) {
		this.company.setPhoneNumberFax(phoneNumberFax);
		return this;
	}
	
	public CompanyBuilder timeZoneId(String timeZoneId) {
		this.company.setTimeZoneId(timeZoneId);
		return this;
	}
	
	public CompanyBuilder canSeePrivate(Boolean canSeePrivate) {
		this.company.setCanSeePrivate(canSeePrivate);
		return this;
	}
	
	public CompanyBuilder canSeePrivate(String canSeePrivate) {
		this.company.setCanSeePrivate(Boolean.valueOf(canSeePrivate));
		return this;
	}
	
	public CompanyBuilder urlName(String urlName) {
		this.company.setUrlName(urlName);
		return this;
	}
	
	public Company build() {
		return company;
	}
}