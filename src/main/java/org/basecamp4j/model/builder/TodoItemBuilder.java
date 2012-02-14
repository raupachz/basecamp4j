package org.basecamp4j.model.builder;

import java.util.Date;

import org.basecamp4j.model.TodoItem;
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
public class TodoItemBuilder {
	
	private final TodoItem todoItem;
	
	public TodoItemBuilder() {
		this.todoItem = new TodoItem();
	}
	
	public TodoItemBuilder(Element element) {
		this();
		id(DOMUtils.getChildText(element,"id"));
		todoListId(DOMUtils.getChildText(element,"todo-list-id"));
		content(DOMUtils.getChildText(element,"content"));
		position(DOMUtils.getChildText(element,"position"));
		createdOn(DOMUtils.getChildText(element,"created-on"));
		creatorId(DOMUtils.getChildText(element,"creator-id"));
		creatorName(DOMUtils.getChildText(element,"creator-name"));
		completed(DOMUtils.getChildText(element,"completed"));
		commentsCount(DOMUtils.getChildText(element,"comments-count"));
		responsiblePartyType(DOMUtils.getChildText(element,"responsible-party-type"));
		responsiblePartyId(DOMUtils.getChildText(element,"responsible-party-id"));
		responsiblePartyName(DOMUtils.getChildText(element,"responsible-party-name"));
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
		if (responsiblePartyId == null) {
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
