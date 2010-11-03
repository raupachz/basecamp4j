package org.basecamp4j;

import org.jdom.Element;

class CategoryBuilder extends AbstractResourceBuilder<Category>{
	
	private final Category category;
	
	public CategoryBuilder() {
		super();
		this.category = new Category();
	}
	
	public CategoryBuilder(Element element) {
		this();
		id(element.getChildText("id"));
		name(element.getChildText("name"));
		projectId(element.getChildText("project-id"));
		elementsCount(element.getChildText("elements-count"));
		type(element.getChildText("type"));
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