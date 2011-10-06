package org.basecamp4j.model.builder;

import org.basecamp4j.model.Category;
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
public class CategoryBuilder {
	
	private final Category category;
	
	public CategoryBuilder() {
		super();
		this.category = new Category();
	}
	
	public CategoryBuilder(Element element) {
		this();
		id(DOMUtils.getChildText(element,"id"));
		name(DOMUtils.getChildText(element,"name"));
		projectId(DOMUtils.getChildText(element,"project-id"));
		elementsCount(DOMUtils.getChildText(element,"elements-count"));
		type(DOMUtils.getChildText(element,"type"));
	}
	
	public CategoryBuilder id(Long id) {
		this.category.setId(id);
		return this;
	}
	
	public CategoryBuilder id(String id) {
		this.category.setId(Long.valueOf(id));
		return this;
	}
	
	public CategoryBuilder name(String name) {
		this.category.setName(name);
		return this;
	}
	
	public CategoryBuilder projectId(Long projectId) {
		this.category.setProjectId(projectId);
		return this;
	}
	
	public CategoryBuilder projectId(String projectId) {
		this.category.setProjectId(Long.valueOf(projectId));
		return this;
	}
	
	public CategoryBuilder elementsCount(Long elementsCount) {
		this.category.setElementsCount(elementsCount);
		return this;
	}
	
	public CategoryBuilder elementsCount(String elementsCount) {
		this.category.setElementsCount(Long.valueOf(elementsCount));
		return this;
	}
	
	public CategoryBuilder type(String type) {
		this.category.setType(type);
		return this;
	}
	
	public Category build() {
		return category;
	}
}