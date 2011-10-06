package org.basecamp4j.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class Post implements Serializable {
	
	private Long id;
	private String title;
	private String body;
	private String displayBody;
	private Date postedOn;
	private Long projectId;
	private Long categoryId;
	private Long authorId;
	private String authorName;
	private Long milestoneId;
	private Long commentsCount;
	private Boolean useTextile;
	private Long attachmentsCount;
	private List<Attachment> attachments;
	private Boolean priva4e;
	
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
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getDisplayBody() {
		return displayBody;
	}
	
	public void setDisplayBody(String displayBody) {
		this.displayBody = displayBody;
	}
	
	public Date getPostedOn() {
		return postedOn;
	}
	
	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}
	
	public Long getProjectId() {
		return projectId;
	}
	
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public Long getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public Long getMilestoneId() {
		return milestoneId;
	}
	
	public void setMilestoneId(Long milestoneId) {
		this.milestoneId = milestoneId;
	}
	
	public Long getCommentsCount() {
		return commentsCount;
	}
	
	public void setCommentsCount(Long commentsCount) {
		this.commentsCount = commentsCount;
	}
	
	public Boolean getUseTextile() {
		return useTextile;
	}
	
	public void setUseTextile(Boolean useTextile) {
		this.useTextile = useTextile;
	}
	
	public Long getAttachmentsCount() {
		return attachmentsCount;
	}
	
	public void setAttachmentsCount(Long attachmentsCount) {
		this.attachmentsCount = attachmentsCount;
	}
	
	public List<Attachment> getAttachments() {
		if (attachments == null) {
			attachments = new ArrayList<Attachment>();
		}
		return attachments;
	}
	
	public Boolean getPrivate() {
		return priva4e;
	}
	
	public void setPrivate(Boolean priva4e) {
		this.priva4e = priva4e;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
				.append("id",getId())
				.append("title",getTitle())
				.append("body",getBody())
				.append("displayBody",getDisplayBody())
				.append("postedOn",getPostedOn())
				.append("projectId",getProjectId())
				.append("categoryId",getCategoryId())
				.append("authorId",getAuthorId())
				.append("authorName",getAuthorName())
				.append("milestoneId",getMilestoneId())
				.append("comments-count",getCommentsCount())
				.append("useTextile",getUseTextile())
				.append("attachmentsCount",getAttachmentsCount())
				.append("private",getPrivate())
				.toString();
	}
	

}
