package org.basecamp4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class Comment implements Serializable {
	
	private Long id;
	private Long authorId;
	private String authorName;
	private Long commentableId;
	private String commentableType;
	private String body;
	private String emailedFrom;
	private Date createdAt;
	private Long attachmentsCount;
	private List<Attachment> attachments;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public Long getCommentableId() {
		return commentableId;
	}
	
	public void setCommentableId(Long commentableId) {
		this.commentableId = commentableId;
	}
	
	public String getCommentableType() {
		return commentableType;
	}
	
	public void setCommentableType(String commentableType) {
		this.commentableType = commentableType;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getEmailedFrom() {
		return emailedFrom;
	}
	
	public void setEmailedFrom(String emailedFrom) {
		this.emailedFrom = emailedFrom;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Long getAttachmentsCount() {
		return attachmentsCount;
	}
	
	public void setAttachmentsCount(Long attachmentsCount) {
		this.attachmentsCount = attachmentsCount;
	}
	
	public List<Attachment> getAttachments() {
		if (attachments == null) {
			this.attachments = new ArrayList<Attachment>();
		}
		return attachments;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
					.append("id",getId())
					.append("authorId",getAuthorId())
					.append("authorName",getAuthorName())
					.append("commentableId",getCommentableId())
					.append("commentableType",getCommentableType())
					.append("body",getBody())
					.append("emailedForm",getEmailedFrom())
					.append("createdAt",getCreatedAt())
					.append("attachmentsCount",getAttachmentsCount())
					.toString();
	}
	
}
