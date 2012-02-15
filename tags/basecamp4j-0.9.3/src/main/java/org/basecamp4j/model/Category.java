package org.basecamp4j.model;

import java.io.Serializable;

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
public class Category implements Serializable {
	
	private Long id;
	private String name;
	private Long projectId;
	private Long elementsCount;
	private String type;
	
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
	
	public Long getProjectId() {
		return projectId;
	}
	
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	public Long getElementsCount() {
		return elementsCount;
	}
	
	public void setElementsCount(Long elementsCount) {
		this.elementsCount = elementsCount;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
					.append("id",getId())
					.append("name",getName())
					.append("projectId",getProjectId())
					.append("elementsCount",getElementsCount())
					.append("type",getType())
					.toString();
	}
	
}
