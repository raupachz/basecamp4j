package org.basecamp4j.model.builder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.basecamp4j.model.Attachment;
import org.basecamp4j.utils.IsoDateTimeFormat;
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
public class AttachmentBuilder {
	
	private final Attachment attachment;
	
	public AttachmentBuilder() {
		this.attachment = new Attachment();
	}
	
	public AttachmentBuilder(Element element) {
		this();
		id(DOMUtils.getChildText(element,"id"));
		name(DOMUtils.getChildText(element,"name"));
		description(DOMUtils.getChildText(element,"description"));
		byteSize(DOMUtils.getChildText(element,"byte-size"));
		downloadUrl(DOMUtils.getChildText(element,"download-url"));
		projectId(DOMUtils.getChildText(element,"project-id"));
		categoryId(DOMUtils.getChildText(element,"category-id"));
		personId(DOMUtils.getChildText(element,"person-id"));
		priva4e(DOMUtils.getChildText(element,"private"));
		createdOn(DOMUtils.getChildText(element,"created-on"));
		ownerId(DOMUtils.getChildText(element,"owner-id"));
		ownerType(DOMUtils.getChildText(element,"owner-type"));
		collection(DOMUtils.getChildText(element,"collection"));
		version(DOMUtils.getChildText(element,"version"));
		current(DOMUtils.getChildText(element,"current"));
	}
	
	public AttachmentBuilder id(Long id) {
		this.attachment.setId(id);
		return this;
	}
	
	public AttachmentBuilder id(String id) {
		this.attachment.setId(Long.valueOf(id));
		return this;
	}
	
	public AttachmentBuilder name(String name) {
		this.attachment.setName(name);
		return this;
	}
	
	public AttachmentBuilder description(String description) {
		this.attachment.setDescription(description);
		return this;
	}
	
	public AttachmentBuilder byteSize(Long byteSize) {
		this.attachment.setByteSize(byteSize);
		return this;
	}
	
	public AttachmentBuilder byteSize(String byteSize) {
		this.attachment.setByteSize(Long.valueOf(byteSize));
		return this;
	}
	
	public AttachmentBuilder downloadUrl(URL downloadUrl) {
		this.attachment.setDownloadUrl(downloadUrl);
		return this;
	}
	
	public AttachmentBuilder downloadUrl(String downloadUrl) {
		try {
			this.attachment.setDownloadUrl(new URL(downloadUrl));
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		return this;
	}
	
	public AttachmentBuilder projectId(Long projectId) {
		this.attachment.setProjectId(projectId);
		return this;
	}
	
	public AttachmentBuilder projectId(String projectId) {
		this.attachment.setProjectId(Long.valueOf(projectId));
		return this;
	}
	
	public AttachmentBuilder categoryId(Long categoryId) {
		this.attachment.setCategoryId(categoryId);
		return this;
	}
	
	public AttachmentBuilder categoryId(String categoryId) {
		if (categoryId != null) {
			this.attachment.setCategoryId(Long.valueOf(categoryId));
		}
		return this;
	}
	
	public AttachmentBuilder personId(Long personId) {
		this.attachment.setPersonId(personId);
		return this;
	}
	
	public AttachmentBuilder personId(String personId) {
		this.attachment.setPersonId(Long.valueOf(personId));
		return this;
	}
	
	public AttachmentBuilder priva4e(Boolean priva4e) {
		this.attachment.setPrivate(priva4e);
		return this;
	}
	
	public AttachmentBuilder priva4e(String priva4e) {
		this.attachment.setPrivate(Boolean.valueOf(priva4e));
		return this;
	}
	
	public AttachmentBuilder createdOn(Date createdOn) {
		this.attachment.setCreatedOn(createdOn);
		return this;
	}
	
	public AttachmentBuilder createdOn(String createdOn) {
		this.attachment.setCreatedOn(IsoDateTimeFormat.parseDateTime(createdOn));
		return this;
	}
	
	public AttachmentBuilder ownerId(Long ownerId) {
		this.attachment.setOwnerId(ownerId);
		return this;
	}
	
	public AttachmentBuilder ownerId(String ownerId) {
		if (ownerId != null) {
			this.attachment.setOwnerId(Long.valueOf(ownerId));
		}
		return this;
	}
	
	public AttachmentBuilder ownerType(String ownerType) {
		this.attachment.setOwnerType(ownerType);
		return this;
	}
	
	public AttachmentBuilder collection(Long collection) {
		this.attachment.setCollection(collection);
		return this;
	}
	
	public AttachmentBuilder collection(String collection) {
		this.attachment.setCollection(Long.valueOf(collection));
		return this;
	}
	
	public AttachmentBuilder version(Long version) {
		this.attachment.setVersion(version);
		return this;
	}
	
	public AttachmentBuilder version(String version) {
		this.attachment.setVersion(Long.valueOf(version));
		return this;
	}
	
	public AttachmentBuilder current(Boolean current) {
		this.attachment.setCurrent(current);
		return this;
	}
	
	public AttachmentBuilder current(String current) {
		this.attachment.setCurrent(Boolean.valueOf(current));
		return this;
	}
	
	public Attachment build() {
		return this.attachment;
	}
	
}