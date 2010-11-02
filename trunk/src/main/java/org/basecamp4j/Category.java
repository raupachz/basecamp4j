package org.basecamp4j;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.jdom.Element;

public class Category implements Serializable {
	
	private Long id;
	private String name;
	private Long projectId;
	private Long elementsCount;
	private String type;
	
	public static class Builder {
		
		private final Category category;
		
		public Builder() {
			this.category = new Category();
		}
		
		public Builder(Element element) {
			this();
			id(element.getChildText("id"));
			name(element.getChildText("name"));
			projectId(element.getChildText("project-id"));
			elementsCount(element.getChildText("elements-count"));
			type(element.getChildText("type"));
		}
		
		public Builder id(Long id) {
			this.category.setId(id);
			return this;
		}
		
		public Builder id(String id) {
			this.category.setId(Long.valueOf(id));
			return this;
		}
		
		public Builder name(String name) {
			this.category.setName(name);
			return this;
		}
		
		public Builder projectId(Long projectId) {
			this.category.setProjectId(projectId);
			return this;
		}
		
		public Builder projectId(String projectId) {
			this.category.setProjectId(Long.valueOf(projectId));
			return this;
		}
		
		public Builder elementsCount(Long elementsCount) {
			this.category.setElementsCount(elementsCount);
			return this;
		}
		
		public Builder elementsCount(String elementsCount) {
			this.category.setElementsCount(Long.valueOf(elementsCount));
			return this;
		}
		
		public Builder type(String type) {
			this.category.setType(type);
			return this;
		}
		
		public Category build() {
			return category;
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
