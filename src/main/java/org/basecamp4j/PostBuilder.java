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
class PostBuilder {
	
	private final Post post;
	
	public PostBuilder() {
		super();
		this.post = new Post();
	}
	
	public PostBuilder(Element element) {
		this();
		id(element.getChildText("id"));
		title(element.getChildText("title"));
		body(element.getChildText("body"));
		displayBody(element.getChildText("display-body"));
		postedOn(element.getChildText("posted-on"));
		projectId(element.getChildText("project-id"));
		categoryId(element.getChildText("category-id"));
		authorId(element.getChildText("author-id"));
		authorName(element.getChildText("author-name"));
		milestoneId(element.getChildText("milestone-id"));
		commentsCount(element.getChildText("comments-count"));
		useTextile(element.getChildText("use-textile"));
		attachmentsCount(element.getChildText("attachments-count"));
		priva4e(element.getChildText("private"));
	}
	
	public PostBuilder id(Long id) {
		this.post.setId(id);
		return this;
	}
	
	public PostBuilder id(String id) {
		this.post.setId(Long.valueOf(id));
		return this;
	}
	
	public PostBuilder title(String title) {
		this.post.setTitle(title);
		return this;
	}
	
	public PostBuilder body(String body) {
		this.post.setBody(body);
		return this;
	}
	
	public PostBuilder displayBody(String displayBody) {
		this.post.setDisplayBody(displayBody);
		return this;
	}
	
	public PostBuilder postedOn(Date postedOn) {
		this.post.setPostedOn(postedOn);
		return this;
	}
	
	public PostBuilder postedOn(String postedOn) {
		this.post.setPostedOn(IsoDateTimeFormat.parseDateTime(postedOn));
		return this;
	}
	
	public PostBuilder projectId(Long projectId) {
		this.post.setProjectId(projectId);
		return this;
	}
	
	public PostBuilder projectId(String projectId) {
		this.post.setProjectId(Long.valueOf(projectId));
		return this;
	}
	
	public PostBuilder categoryId(Long categoryId) {
		this.post.setCategoryId(categoryId);
		return this;
	}
	
	public PostBuilder categoryId(String categoryId) {
		if (StringUtils.isNotBlank(categoryId)) {
			this.post.setCategoryId(Long.valueOf(categoryId));
		}
		return this;
	}
	
	public PostBuilder authorId(Long authorId) {
		this.post.setAuthorId(authorId);
		return this;
	}
	
	public PostBuilder authorId(String authorId) {
		this.post.setAuthorId(Long.valueOf(authorId));
		return this;
	}
	
	public PostBuilder authorName(String authorName) {
		this.post.setAuthorName(authorName);
		return this;
	}
	
	public PostBuilder milestoneId(Long milestoneId) {
		this.post.setMilestoneId(milestoneId);
		return this;
	}
	
	public PostBuilder milestoneId(String milestoneId) {
		this.post.setMilestoneId(Long.valueOf(milestoneId));
		return this;
	}
	
	public PostBuilder commentsCount(Long commentsCount) {
		this.post.setCommentsCount(commentsCount);
		return this;
	}
	
	public PostBuilder commentsCount(String commentsCount) {
		this.post.setCommentsCount(Long.valueOf(commentsCount));
		return this;
	}
	
	public PostBuilder useTextile(Boolean useTextile) {
		this.post.setUseTextile(useTextile);
		return this;
	}
	
	public PostBuilder useTextile(String useTextile) {
		this.post.setUseTextile(Boolean.valueOf(useTextile));
		return this;
	}
	
	public PostBuilder attachmentsCount(Long attachmentsCount) {
		this.post.setAttachmentsCount(attachmentsCount);
		return this;
	}
	
	public PostBuilder attachmentsCount(String attachmentsCount) {
		this.post.setAttachmentsCount(Long.valueOf(attachmentsCount));
		return this;
	}
	
	public PostBuilder priva4e(Boolean priva4e) {
		this.post.setPrivate(priva4e);
		return this;
	}
	
	public PostBuilder priva4e(String priva4e) {
		this.post.setPrivate(Boolean.valueOf(priva4e));
		return this;
	}
	
	public Post build() {
		return post;
	}
	
}