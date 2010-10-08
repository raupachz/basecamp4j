package org.basecamp4j;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.jdom.Element;

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
	
	public static class Builder {
		
		private final Person person;
		
		public Builder() {
			this.person = new Person();
		}
		
		public Builder(Element element) {
			this();
			id(element.getChildText("id"));
			firstname(element.getChildText("first-name"));
			lastname(element.getChildText("last-name"));
			title(element.getChildText("title"));
			emailAddress(element.getChildText("email-address"));
			imHandle(element.getChildText("im-handle"));
			imService(element.getChildText("im-service"));
			phoneNumberOffice(element.getChildText("phone-number-office"));
			phoneNumberOfficeExt(element.getChildText("phone-number-office-ext"));
			phoneNumberMobile(element.getChildText("phone-number-mobile"));
			phoneNumberHome(element.getChildText("phone-number-home"));
			phoneNumberFax(element.getChildText("phone-number-fax"));
			companyId(element.getChildText("company-id"));
			avatarUrl(element.getChildText("avatar-url"));
			username(element.getChildText("user-name"));
			administrator(element.getChildText("administrator"));
			deleted(element.getChildText("deleted"));
			hasAccessToNewProjects(element.getChildText("has-access-to-new-projects"));
			
		}
		
		public Builder id(Long id) {
			this.person.setId(id);
			return this;
		}
		
		public Builder id(String id) {
			this.person.setId(Long.valueOf(id));
			return this;
		}
		
		public Builder firstname(String firstname) {
			this.person.setFirstname(firstname);
			return this;
		}
		
		public Builder lastname(String lastname) {
			this.person.setLastname(lastname);
			return this;
		}
		
		public Builder title(String title) {
			this.person.setTitle(title);
			return this;
		}
		
		public Builder emailAddress(String emailAddress) {
			this.person.setEmailAddress(emailAddress);
			return this;
		}
		
		public Builder imHandle(String imHandle) {
			this.person.setImHandle(imHandle);
			return this;
		}
		
		public Builder imService(String imService) {
			this.person.setImService(imService);
			return this;
		}
		
		public Builder phoneNumberOffice(String phoneNumberOffice) {
			this.person.setPhoneNumberOffice(phoneNumberOffice);
			return this;
		}
		
		public Builder phoneNumberOfficeExt(String phoneNumberOfficeExt) {
			this.person.setPhoneNumberOfficeExt(phoneNumberOfficeExt);
			return this;
		}
		
		public Builder phoneNumberMobile(String phoneNumberMobile) {
			this.person.setPhoneNumberMobile(phoneNumberMobile);
			return this;
		}
		
		public Builder phoneNumberHome(String phoneNumberHome) {
			this.person.setPhoneNumberHome(phoneNumberHome);
			return this;
		}
		
		public Builder phoneNumberFax(String phoneNumberFax) {
			this.person.setPhoneNumberFax(phoneNumberFax);
			return this;
		}
		
		public Builder companyId(Long companyId) {
			this.person.setCompanyId(companyId);
			return this;
		}
		
		public Builder companyId(String companyId) {
			this.person.setCompanyId(Long.valueOf(companyId));
			return this;
		}
		
		public Builder clientId(Long clientId) {
			this.person.setClientId(clientId);
			return this;
		}
		
		public Builder clientId(String clientId) {
			this.person.setClientId(Long.valueOf(clientId));
			return this;
		}
		
		public Builder avatarUrl(String avatarUrl) {
			this.person.setAvatarUrl(avatarUrl);
			return this;
		}
		
		public Builder username(String username) {
			this.person.setUsername(username);
			return this;
		}
		
		public Builder administrator(Boolean administrator) {
			this.person.setAdministrator(administrator);
			return this;
		}
		
		public Builder administrator(String administrator) {
			this.person.setAdministrator(Boolean.valueOf(administrator));
			return this;
		}
		
		public Builder deleted(Boolean deleted) {
			this.person.setDeleted(deleted);
			return this;
		}
		
		public Builder deleted(String deleted) {
			this.person.setDeleted(Boolean.valueOf(deleted));
			return this;
		}
		
		public Builder hasAccessToNewProjects(Boolean hasAccessToNewProjects) {
			this.person.setHasAccessToNewProjects(hasAccessToNewProjects);
			return this;
		}
		
		public Builder hasAccessToNewProjects(String hasAccessToNewProjects) {
			this.person.setHasAccessToNewProjects(Boolean.valueOf(hasAccessToNewProjects));
			return this;
		}
		
		public Person build() {
			return this.person;
		}
	
	}
	
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
