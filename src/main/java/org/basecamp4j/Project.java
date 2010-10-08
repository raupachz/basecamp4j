package org.basecamp4j;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jdom.Element;

public class Project implements Serializable {
	
	private static final long serialVersionUID = 3566481067977477036L;
	
	private Long id;
	private String name;
	private Date createdOn;
	private String status;
	private Company company;
	private Date lastChangedOn;
	private String announcement;
	private String startPage;
	private Boolean showWriteboards;
	private Boolean showAnnouncement;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public Date getLastChangedOn() {
		return lastChangedOn;
	}
	
	public void setLastChangedOn(Date lastChangedOn) {
		this.lastChangedOn = lastChangedOn;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public static class Builder {
		
		private final Project project;
		
		public Builder() {
			this.project = new Project();
		}
		
		public Builder(Element element) {
			this();
			id(element.getChildText("id"));
			createdOn(element.getChildText("created-on"));
			lastChangedOn(element.getChildText("last-changed-on"));
			name(element.getChildText("name"));
			status(element.getChildText("status"));
		}
		
		public Builder id(Long id) {
			this.project.setId(id);
			return this;
		}
		
		public Builder id(String id) {
			this.project.setId(Long.valueOf(id));
			return this;
		}
		
		public Builder createdOn(Date createdOn) {
			this.project.setCreatedOn(createdOn);
			return this;
		}
		
		public Builder createdOn(String createdOn) {
			if (StringUtils.isNotBlank(createdOn)) {
				this.project.setCreatedOn(BasecampApi.parseISODate(createdOn));
			}
			return this;
		}
		
		public Builder lastChangedOn(Date lastChangedOn) {
			this.project.setLastChangedOn(lastChangedOn);
			return this;
		}
		
		public Builder lastChangedOn(String lastChangedOn) {
			if (StringUtils.isNotBlank(lastChangedOn)) {
				this.project.setLastChangedOn(BasecampApi.parseISODateTime(lastChangedOn));
			}
			return this;
		}
		
		public Builder name(String name) {
			this.project.setName(name);
			return this;
		}
		
		public Builder status(String status) {
			this.project.setStatus(status);
			return this;
		}
		
		public Project build() {
			return project;
		}
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public String getStartPage() {
		return startPage;
	}

	public void setStartPage(String startPage) {
		this.startPage = startPage;
	}

	public Boolean getShowWriteboards() {
		return showWriteboards;
	}

	public void setShowWriteboards(Boolean showWriteboards) {
		this.showWriteboards = showWriteboards;
	}

	public Boolean getShowAnnouncement() {
		return showAnnouncement;
	}

	public void setShowAnnouncement(Boolean showAnnouncement) {
		this.showAnnouncement = showAnnouncement;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
					.append("id", getId())
					.append("name", getName())
					.append("createdOn", getCreatedOn())
					.append("lastChangedOn", getLastChangedOn())
					.append("status",getStatus())
					.toString();
	}

}
