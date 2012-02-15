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
class TodoItemBuilder {
	
	private final TodoItem todoItem;
	
	public TodoItemBuilder() {
		this.todoItem = new TodoItem();
	}
	
	public TodoItemBuilder(Element element) {
		this();
		id(element.getChildText("id"));
		todoListId(element.getChildText("todo-list-id"));
		content(element.getChildText("content"));
		position(element.getChildText("position"));
		createdOn(element.getChildText("created-on"));
		creatorId(element.getChildText("creator-id"));
		creatorName(element.getChildText("creator-name"));
		completed(element.getChildText("completed"));
		commentsCount(element.getChildText("comments-count"));
		responsiblePartyType(element.getChildText("responsible-party-type"));
		responsiblePartyId(element.getChildText("responsible-party-id"));
		responsiblePartyName(element.getChildText("responsible-party-name"));
	}
	
	public TodoItemBuilder id(String id) {
		return id(Long.valueOf(id));
	}
	
	public TodoItemBuilder id(Long id) {
		todoItem.setId(id);
		return this;
	}
	
	public TodoItemBuilder todoListId(String todoListId) {
		return todoListId(Long.valueOf(todoListId));
	}
	
	public TodoItemBuilder todoListId(Long todoListId) {
		todoItem.setTodoListId(todoListId);
		return this;
	}
	
	public TodoItemBuilder content(String content) {
		todoItem.setContent(content);
		return this;
	}
	
	public TodoItemBuilder position(String position) {
		return position(Integer.valueOf(position));
	}
	
	public TodoItemBuilder position(Integer position) {
		todoItem.setPosition(position);
		return this;
	}
	
	public TodoItemBuilder createdOn(String createdOn) {
		return createdOn(IsoDateTimeFormat.parseDateTime(createdOn));
	}
	
	public TodoItemBuilder createdOn(Date createdOn) {
		todoItem.setCreatedOn(createdOn);
		return this;
	}
	
	public TodoItemBuilder creatorId(String creatorId) {
		return creatorId(Long.valueOf(creatorId));
	}
	
	public TodoItemBuilder creatorId(Long creatorId) {
		todoItem.setCreatorId(creatorId);
		return this;
	}
	
	public TodoItemBuilder creatorName(String creatorName) {
		todoItem.setCreatorName(creatorName);
		return this;
	}
	
	public TodoItemBuilder completed(String completed) {
		return completed(Boolean.valueOf(completed));
	}
	
	public TodoItemBuilder completed(Boolean completed) {
		todoItem.setCompleted(completed);
		return this;
	}
	
	public TodoItemBuilder commentsCount(Integer commentsCount) {
		todoItem.setCommentsCount(commentsCount);
		return this;
	}
	
	public TodoItemBuilder commentsCount(String commentsCount) {
		return commentsCount(Integer.valueOf(commentsCount));
	}
	
	public TodoItemBuilder responsiblePartyType(String responsiblePartyType) {
		todoItem.setResponsiblePartyType(responsiblePartyType);
		return this;
	}
	
	public TodoItemBuilder responsiblePartyId(String responsiblePartyId) {
		if (StringUtils.isBlank(responsiblePartyId)) {
			return this;
		} else {
			return responsiblePartyId(Long.valueOf(responsiblePartyId));
		}
		
	}
	
	public TodoItemBuilder responsiblePartyId(Long responsiblePartyId) {
		todoItem.setResponsiblePartyId(responsiblePartyId);
		return this;
	}
	
	public TodoItemBuilder responsiblePartyName(String responsiblePartyName) {
		todoItem.setResponsiblePartyName(responsiblePartyName);
		return this;
	}
	
	public TodoItemBuilder completedOn(String completedOn) {
		return completedOn(IsoDateTimeFormat.parseDateTime(completedOn));
	}
	
	public TodoItemBuilder completedOn(Date completedOn) {
		todoItem.setCompletedOn(completedOn);
		return this;
	}
	
	public TodoItemBuilder completerId(String completerId) {
		return completerId(Long.valueOf(completerId));
	}
	
	public TodoItemBuilder completerId(Long completerId) {
		todoItem.setCompleterId(completerId);
		return this;
	}
	
	public TodoItemBuilder completerName(String completerName) {
		todoItem.setCompleterName(completerName);
		return this;
	}
	
	public TodoItem build() {
		return todoItem;
	}

}
