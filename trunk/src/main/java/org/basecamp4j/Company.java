package org.basecamp4j;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.jdom.Element;

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
	
	public static class Builder {
		
		private final Company company;
		
		public Builder() {
			this.company = new Company();
		}
		
		public Builder(Element element) {
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
		
		public Builder id(Long id) {
			this.company.setId(id);
			return this;
		}
		
		public Builder id(String id) {
			this.company.setId(Long.valueOf(id));
			return this;
		}
		
		public Builder name(String name) {
			this.company.setName(name);
			return this;
		}
		
		public Builder addressOne(String addressOne) {
			this.company.setAddressOne(addressOne);
			return this;
		}
		
		public Builder addressTwo(String addressTwo) {
			this.company.setAddressTwo(addressTwo);
			return this;
		}
		
		public Builder city(String city) {
			this.company.setCity(city);
			return this;
		}
		
		public Builder state(String state) {
			this.company.setState(state);
			return this;
		}
		
		public Builder zip(String zip) {
			this.company.setZip(zip);
			return this;
		}
		
		public Builder country(String country) {
			this.company.setCountry(country);
			return this;
		}
		
		public Builder webAddress(String webAddress) {
			this.company.setWebAddress(webAddress);
			return this;
		}
		
		public Builder phoneNumberOffice(String phoneNumberOffice) {
			this.company.setPhoneNumberOffice(phoneNumberOffice);
			return this;
		}
		
		public Builder phoneNumberFax(String phoneNumberFax) {
			this.company.setPhoneNumberFax(phoneNumberFax);
			return this;
		}
		
		public Builder timeZoneId(String timeZoneId) {
			this.company.setTimeZoneId(timeZoneId);
			return this;
		}
		
		public Builder canSeePrivate(Boolean canSeePrivate) {
			this.company.setCanSeePrivate(canSeePrivate);
			return this;
		}
		
		public Builder canSeePrivate(String canSeePrivate) {
			this.company.setCanSeePrivate(Boolean.valueOf(canSeePrivate));
			return this;
		}
		
		public Builder urlName(String urlName) {
			this.company.setUrlName(urlName);
			return this;
		}
		
		public Company build() {
			return company;
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
