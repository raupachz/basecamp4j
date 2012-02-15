package org.basecamp4j.model;

import java.io.Serializable;
import java.net.URL;
import java.util.Date;

import org.basecamp4j.utils.ToStringBuilder;

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
public class Attachment implements Serializable {
	
	private static final long serialVersionUID = -7018352992057978151L;
	
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
