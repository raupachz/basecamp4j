package org.basecamp4j;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

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
public class Milestone implements Serializable {
	
	private Long id;
	private String title;
	private Date deadline;
	private Boolean completed;
	private Long projectId;
	private Date createdOn;
	private Long creatorId;
	private String creatorName;
	private Long responsiblePartyId;
	private String responsiblePartyType;
	private String responsiblePartyName;
	private Long commentsCount;
	private Date completedOn;
	private Long completerId;
	private String completerName;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public Boolean getCompleted() {
		return completed;
	}
	
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
	public Long getProjectId() {
		return projectId;
	}
	
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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
	
	public Long getResponsiblePartyId() {
		return responsiblePartyId;
	}
	
	public void setResponsiblePartyId(Long responsiblePartyId) {
		this.responsiblePartyId = responsiblePartyId;
	}
	
	public String getResponsiblePartyType() {
		return responsiblePartyType;
	}
	
	public void setResponsiblePartyType(String responsiblePartyType) {
		this.responsiblePartyType = responsiblePartyType;
	}
	
	public String getResponsiblePartyName() {
		return responsiblePartyName;
	}
	
	public void setResponsiblePartyName(String responsiblePartyName) {
		this.responsiblePartyName = responsiblePartyName;
	}
	
	public Long getCommentsCount() {
		return commentsCount;
	}
	
	public void setCommentsCount(Long commentsCount) {
		this.commentsCount = commentsCount;
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
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("id",getId())
			.append("title",getTitle())
			.append("deadline",getDeadline())
			.append("completed",getCompleted())
			.append("projectId",getProjectId())
			.append("createdOn",getCreatedOn())
			.append("creatorId",getCreatorId())
			.append("creatorName",getCreatorName())
			.append("responsiblePartyId", getResponsiblePartyId())
			.append("responsiblePartyType",getResponsiblePartyType())
			.append("responsiblePartyName",getResponsiblePartyName())
			.append("commentsCount",getCommentsCount())
			.append("completedOn",getCompletedOn())
			.append("completedId",getCompleterId())
			.append("completerName",getCompleterName())
			.toString();
	}
}
