package org.basecamp4j;

import java.io.Serializable;
import java.util.Date;

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
public class TodoItem implements Serializable {
	
	private Long id;
	private Long todoListId;
	private String content;
	private Integer position;
	private Date createdOn;
	private Long creatorId;
	private String creatorName;
	private Boolean completed;
	private Integer commentsCount;
	private String responsiblePartyType;
	private Long responsiblePartyId;
	private String responsiblePartyName;
	private Date completedOn;
	private Long completerId;
	private String completerName;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getTodoListId() {
		return todoListId;
	}
	
	public void setTodoListId(Long todoListId) {
		this.todoListId = todoListId;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getPosition() {
		return position;
	}
	
	public void setPosition(Integer position) {
		this.position = position;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public Long getCreatorId() {
		return creatorId;
	}
	
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}
	
	public String getCreatorName() {
		return creatorName;
	}
	
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	
	public Boolean getCompleted() {
		return completed;
	}
	
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
	public Integer getCommentsCount() {
		return commentsCount;
	}
	
	public void setCommentsCount(Integer commentsCount) {
		this.commentsCount = commentsCount;
	}
	
	public String getResponsiblePartyType() {
		return responsiblePartyType;
	}
	
	public void setResponsiblePartyType(String responsiblePartyType) {
		this.responsiblePartyType = responsiblePartyType;
	}
	
	public Long getResponsiblePartyId() {
		return responsiblePartyId;
	}
	
	public void setResponsiblePartyId(Long responsiblePartyId) {
		this.responsiblePartyId = responsiblePartyId;
	}
	
	public String getResponsiblePartyName() {
		return responsiblePartyName;
	}
	
	public void setResponsiblePartyName(String responsiblePartyName) {
		this.responsiblePartyName = responsiblePartyName;
	}
	
	public Date getCompletedOn() {
		return completedOn;
	}
	
	public void setCompletedOn(Date completedOn) {
		this.completedOn = completedOn;
	}
	
	public Long getCompleterId() {
		return completerId;
	}
	
	public void setCompleterId(Long completerId) {
		this.completerId = completerId;
	}
	
	public String getCompleterName() {
		return completerName;
	}
	
	public void setCompleterName(String completerName) {
		this.completerName = completerName;
	}
	
}
