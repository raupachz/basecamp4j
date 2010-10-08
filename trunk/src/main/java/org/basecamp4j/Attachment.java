package org.basecamp4j;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jdom.Element;

public class Attachment implements Serializable {
	
	private Long id;
	private String name;
	private String description;
	private Long byteSize;
	private URL downloadUrl;
	private Long projectId;
	private Long categoryId;
	private Long personId;
	private Boolean priva4e;
	private Date createdOn;
	private Long ownerId;
	private String ownerType;
	private Long collection;
	private Long version;
	private Boolean current;
	
	public static class Builder {
		
		private final Attachment attachment;
		
		public Builder() {
			this.attachment = new Attachment();
		}
		
		public Builder(Element element) {
			this();
			id(element.getChildText("id"));
			name(element.getChildText("name"));
			description(element.getChildText("description"));
			byteSize(element.getChildText("byte-size"));
			downloadUrl(element.getChildText("download-url"));
			projectId(element.getChildText("project-id"));
			categoryId(element.getChildText("category-id"));
			personId(element.getChildText("person-id"));
			priva4e(element.getChildText("private"));
			createdOn(element.getChildText("created-on"));
			ownerId(element.getChildText("owner-id"));
			ownerType(element.getChildText("owner-type"));
			collection(element.getChildText("collection"));
			version(element.getChildText("version"));
			current(element.getChildText("current"));
		}
		
		public Builder id(Long id) {
			this.attachment.setId(id);
			return this;
		}
		
		public Builder id(String id) {
			this.attachment.setId(Long.valueOf(id));
			return this;
		}
		
		public Builder name(String name) {
			this.attachment.setName(name);
			return this;
		}
		
		public Builder description(String description) {
			this.attachment.setDescription(description);
			return this;
		}
		
		public Builder byteSize(Long byteSize) {
			this.attachment.setByteSize(byteSize);
			return this;
		}
		
		public Builder byteSize(String byteSize) {
			this.attachment.setByteSize(Long.valueOf(byteSize));
			return this;
		}
		
		public Builder downloadUrl(URL downloadUrl) {
			this.attachment.setDownloadUrl(downloadUrl);
			return this;
		}
		
		public Builder downloadUrl(String downloadUrl) {
			try {
				this.attachment.setDownloadUrl(new URL(downloadUrl));
			} catch (MalformedURLException e) {
				throw new RuntimeException(e);
			}
			return this;
		}
		
		public Builder projectId(Long projectId) {
			this.attachment.setProjectId(projectId);
			return this;
		}
		
		public Builder projectId(String projectId) {
			this.attachment.setProjectId(Long.valueOf(projectId));
			return this;
		}
		
		public Builder categoryId(Long categoryId) {
			this.attachment.setCategoryId(categoryId);
			return this;
		}
		
		public Builder categoryId(String categoryId) {
			if (StringUtils.isNotBlank(categoryId)) {
				this.attachment.setCategoryId(Long.valueOf(categoryId));
			}
			return this;
		}
		
		public Builder personId(Long personId) {
			this.attachment.setPersonId(personId);
			return this;
		}
		
		public Builder personId(String personId) {
			this.attachment.setPersonId(Long.valueOf(personId));
			return this;
		}
		
		public Builder priva4e(Boolean priva4e) {
			this.attachment.setPrivate(priva4e);
			return this;
		}
		
		public Builder priva4e(String priva4e) {
			this.attachment.setPrivate(Boolean.valueOf(priva4e));
			return this;
		}
		
		public Builder createdOn(Date createdOn) {
			this.attachment.setCreatedOn(createdOn);
			return this;
		}
		
		public Builder createdOn(String createdOn) {
			this.attachment.setCreatedOn(BasecampApi.parseISODateTime(createdOn));
			return this;
		}
		
		public Builder ownerId(Long ownerId) {
			this.attachment.setOwnerId(ownerId);
			return this;
		}
		
		public Builder ownerId(String ownerId) {
			if (StringUtils.isNotBlank(ownerId)) {
				this.attachment.setOwnerId(Long.valueOf(ownerId));
			}
			return this;
		}
		
		public Builder ownerType(String ownerType) {
			this.attachment.setOwnerType(ownerType);
			return this;
		}
		
		public Builder collection(Long collection) {
			this.attachment.setCollection(collection);
			return this;
		}
		
		public Builder collection(String collection) {
			this.attachment.setCollection(Long.valueOf(collection));
			return this;
		}
		
		public Builder version(Long version) {
			this.attachment.setVersion(version);
			return this;
		}
		
		public Builder version(String version) {
			this.attachment.setVersion(Long.valueOf(version));
			return this;
		}
		
		public Builder current(Boolean current) {
			this.attachment.setCurrent(current);
			return this;
		}
		
		public Builder current(String current) {
			this.attachment.setCurrent(Boolean.valueOf(current));
			return this;
		}
		
		public Attachment build() {
			return this.attachment;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getByteSize() {
		return byteSize;
	}
	
	public void setByteSize(Long byteSize) {
		this.byteSize = byteSize;
	}
	
	public URL getDownloadUrl() {
		return downloadUrl;
	}
	
	public void setDownloadUrl(URL downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	
	public Long getProjectId() {
		return projectId;
	}
	
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public Long getPersonId() {
		return personId;
	}
	
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	public Boolean getPrivate() {
		return priva4e;
	}
	
	public void setPrivate(Boolean priva4e) {
		this.priva4e = priva4e;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public Long getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	
	public String getOwnerType() {
		return ownerType;
	}
	
	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}
	
	public Long getCollection() {
		return collection;
	}

	public void setCollection(Long collection) {
		this.collection = collection;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Boolean getCurrent() {
		return current;
	}

	public void setCurrent(Boolean current) {
		this.current = current;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("id",getId())
			.append("name",getName())
			.append("description",getDescription())
			.append("byteSize",getByteSize())
			.append("downloadUrl",getDownloadUrl())
			.append("projectId",getProjectId())
			.append("categoryId",getCategoryId())
			.append("personId",getPersonId())
			.append("createdOn",getCreatedOn())
			.append("ownerId",getOwnerId())
			.append("ownerType",getOwnerType())
			.append("collection",getCollection())
			.append("version",getVersion())
			.append("current",getCurrent())
			.toString();
	}

}
