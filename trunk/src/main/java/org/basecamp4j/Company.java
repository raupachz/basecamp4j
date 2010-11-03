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
public class Company implements Serializable {
	
	private Long id;
	private String name;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String webAddress;
	private String phoneNumberOffice;
	private String phoneNumberFax;
	private String timeZoneId;
	private Boolean canSeePrivate;
	private String urlName;
	
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
	
	public String getAddressOne() {
		return addressOne;
	}
	
	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}
	
	public String getAddressTwo() {
		return addressTwo;
	}
	
	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getWebAddress() {
		return webAddress;
	}
	
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	
	public String getPhoneNumberOffice() {
		return phoneNumberOffice;
	}
	
	public void setPhoneNumberOffice(String phoneNumberOffice) {
		this.phoneNumberOffice = phoneNumberOffice;
	}
	
	public String getPhoneNumberFax() {
		return phoneNumberFax;
	}
	
	public void setPhoneNumberFax(String phoneNumberFax) {
		this.phoneNumberFax = phoneNumberFax;
	}
	
	public String getTimeZoneId() {
		return timeZoneId;
	}
	
	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}
	
	public Boolean getCanSeePrivate() {
		return canSeePrivate;
	}
	
	public void setCanSeePrivate(Boolean canSeePrivate) {
		this.canSeePrivate = canSeePrivate;
	}
	
	public String getUrlName() {
		return urlName;
	}
	
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}	
	
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("id",getId())
			.append("name",getName())
			.append("addressOne",getAddressOne())
			.append("addressTwo",getAddressTwo())
			.append("city",getCity())
			.append("state",getState())
			.append("zip",getZip())
			.append("country",getCountry())
			.append("webAddress",getWebAddress())
			.append("phoneNumberOffice",getPhoneNumberFax())
			.append("phoneNumberFax",getPhoneNumberFax())
			.append("timeZoneId",getTimeZoneId())
			.append("canSeePrivate",getCanSeePrivate())
			.append("urlName",getUrlName())
			.toString();
	}

}
