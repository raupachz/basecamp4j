package org.basecamp4j;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
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
class ProjectBuilder {
	
	private final Project project;
	
	public ProjectBuilder() {
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
		return id(Long.valueOf(id));
	}
	
	public ProjectBuilder createdOn(Date createdOn) {
		this.project.setCreatedOn(createdOn);
		return this;
	}
	
	public ProjectBuilder createdOn(String createdOn) {
		if (StringUtils.isNotBlank(createdOn)) {
			this.project.setCreatedOn(IsoDateTimeFormat.parseDate(createdOn));
		}
		return this;
	}
	
	public ProjectBuilder lastChangedOn(Date lastChangedOn) {
		this.project.setLastChangedOn(lastChangedOn);
		return this;
	}
	
	public ProjectBuilder lastChangedOn(String lastChangedOn) {
		if (StringUtils.isNotBlank(lastChangedOn)) {
			this.project.setLastChangedOn(IsoDateTimeFormat.parseDateTime(lastChangedOn));
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