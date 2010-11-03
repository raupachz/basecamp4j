package org.basecamp4j;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

class ProjectBuilder extends AbstractResourceBuilder<Project> {
	
	private final Project project;
	
	public ProjectBuilder() {
		super();
		this.project = new Project();
	}
	
	public ProjectBuilder(Element element) {
		this();
		id(element.getChildText("id"));
		createdOn(element.getChildText("created-on"));
		lastChangedOn(element.getChildText("last-changed-on"));
		name(element.getChildText("name"));
		status(element.getChildText("status"));
	}
	
	public ProjectBuilder id(Long id) {
		this.project.setId(id);
		return this;
	}
	
	public ProjectBuilder id(String id) {
		this.project.setId(Long.valueOf(id));
		return this;
	}
	
	public ProjectBuilder createdOn(Date createdOn) {
		this.project.setCreatedOn(createdOn);
		return this;
	}
	
	public ProjectBuilder createdOn(String createdOn) {
		if (StringUtils.isNotBlank(createdOn)) {
			this.project.setCreatedOn(parseISODate(createdOn));
		}
		return this;
	}
	
	public ProjectBuilder lastChangedOn(Date lastChangedOn) {
		this.project.setLastChangedOn(lastChangedOn);
		return this;
	}
	
	public ProjectBuilder lastChangedOn(String lastChangedOn) {
		if (StringUtils.isNotBlank(lastChangedOn)) {
			this.project.setLastChangedOn(parseISODateTime(lastChangedOn));
		}
		return this;
	}
	
	public ProjectBuilder name(String name) {
		this.project.setName(name);
		return this;
	}
	
	public ProjectBuilder status(String status) {
		this.project.setStatus(status);
		return this;
	}
	
	public Project build() {
		return project;
	}
}