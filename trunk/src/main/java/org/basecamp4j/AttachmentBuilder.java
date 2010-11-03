package org.basecamp4j;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

class AttachmentBuilder extends AbstractResourceBuilder<Attachment> {
	
	private final Attachment attachment;
	
	public AttachmentBuilder() {
		this.attachment = new Attachment();
	}
	
	public AttachmentBuilder(Element element) {
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
		if (StringUtils.isNotBlank(categoryId)) {
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
		this.attachment.setCreatedOn(parseISODateTime(createdOn));
		return this;
	}
	
	public AttachmentBuilder ownerId(Long ownerId) {
		this.attachment.setOwnerId(ownerId);
		return this;
	}
	
	public AttachmentBuilder ownerId(String ownerId) {
		if (StringUtils.isNotBlank(ownerId)) {
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