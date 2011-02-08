package org.basecamp4j;

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
class TodoListBuilder {
	
	private final TodoList todoList;
	
	public TodoListBuilder() {
		super();
		this.todoList = new TodoList();
	}
	
	public TodoListBuilder(Element element) {
		this();
		id(element.getChildText("id"));
		name(element.getChildText("name"));
		description(element.getChildText("description"));
		projectId(element.getChildText("project-id"));
		milestoneId(element.getChildText("milestone-id"));
		position(element.getChildText("position"));
		priva4e(element.getChildText("private"));
		tracked(element.getChildText("tracked"));
	}
	
	public TodoListBuilder id(Long id) {
		this.todoList.setId(id);
		return this;
	}
	
	public TodoListBuilder id(String id) {
		this.todoList.setId(Long.valueOf(id));
		return this;
	}
	
	public TodoListBuilder name(String name) {
		this.todoList.setName(name);
		return this;
	}
	
	public TodoListBuilder description(String description) {
		this.todoList.setDescription(description);
		return this;
	}
	
	public TodoListBuilder projectId(Long projectId) {
		this.todoList.setProjectId(projectId);
		return this;
	}
	
	public TodoListBuilder projectId(String projectId) {
		this.todoList.setProjectId(Long.valueOf(projectId));
		return this;
	}
	
	public TodoListBuilder milestoneId(Long milestoneId) {
		this.todoList.setMilestoneId(milestoneId);
		return this;
	}
	
	public TodoListBuilder milestoneId(String milestoneId) {
		if (StringUtils.isNotBlank(milestoneId)) {
			this.todoList.setMilestoneId(Long.valueOf(milestoneId));
		}
		return this;
	}
	
	public TodoListBuilder position(Long position) {
		this.todoList.setPosition(position);
		return this;
	}
	
	public TodoListBuilder position(String position) {
		this.todoList.setPosition(Long.valueOf(position));
		return this;
	}
	
	public TodoListBuilder priva4e(Boolean priva4e) {
		this.todoList.setPrivate(priva4e);
		return this;
	}
	
	public TodoListBuilder priva4e(String priva4e) {
		this.todoList.setPrivate(Boolean.valueOf(priva4e));
		return this;
	}
	
	public TodoListBuilder tracked(Boolean tracked) {
		this.todoList.setTracked(tracked);
		return this;
	}
	
	public TodoListBuilder tracked(String tracked) {
		this.todoList.setTracked(Boolean.valueOf(tracked));
		return this;
	}

	public TodoList build() {
		return todoList;
	}

}
