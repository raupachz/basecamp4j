package org.basecamp4j.model.builder;

import java.util.Date;

import org.basecamp4j.model.Comment;
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
public class CommentBuilder {
	
	private final Comment comment;
	
	public CommentBuilder() {
		super();
		this.comment = new Comment();
	}
	
	public CommentBuilder(Element element) {
		this();
		id(DOMUtils.getChildText(element,"id"));
		authorId(DOMUtils.getChildText(element,"author-id"));
		authorName(DOMUtils.getChildText(element,"author-name"));
		commentableId(DOMUtils.getChildText(element,"commentable-id"));
		commentableType(DOMUtils.getChildText(element,"commentable-type"));
		body(DOMUtils.getChildText(element,"body"));
		emailedFrom(DOMUtils.getChildText(element,"emailed-from"));
		createdAt(DOMUtils.getChildText(element,"created-at"));
		attachmentsCount(DOMUtils.getChildText(element,"attachments-count"));
	}
	
	public CommentBuilder id(Long id) {
		this.comment.setId(id);
		return this;
	}
	
	public CommentBuilder id(String id) {
		this.comment.setId(Long.valueOf(id));
		return this;
	}
	
	public CommentBuilder authorId(Long authorId) {
		this.comment.setAuthorId(authorId);
		return this;
	}
	
	public CommentBuilder authorId(String authorId) {
		this.comment.setAuthorId(Long.valueOf(authorId));
		return this;
	}
	
	public CommentBuilder authorName(String authorName) {
		this.comment.setAuthorName(authorName);
		return this;
	}
	
	public CommentBuilder commentableId(Long commentableId) {
		this.comment.setCommentableId(commentableId);
		return this;
	}
	
	public CommentBuilder commentableId(String commentableId) {
		this.comment.setCommentableId(Long.valueOf(commentableId));
		return this;
	}
	
	public CommentBuilder commentableType(String commentableType) {
		this.comment.setCommentableType(commentableType);
		return this;
	}
	
	public CommentBuilder body(String body) {
		this.comment.setBody(body);
		return this;
	}
	
	public CommentBuilder emailedFrom(String emailedFrom) {
		this.comment.setEmailedFrom(emailedFrom);
		return this;
	}
	
	public CommentBuilder createdAt(Date createdAt) {
		this.comment.setCreatedAt(createdAt);
		return this;
	}
	
	public CommentBuilder createdAt(String createdAt) {
		this.comment.setCreatedAt(IsoDateTimeFormat.parseDateTime(createdAt));
		return this;
	}
	
	public CommentBuilder attachmentsCount(Long attachmentsCount) {
		this.comment.setAttachmentsCount(attachmentsCount);
		return this;
	}
	
	public CommentBuilder attachmentsCount(String attachmentsCount) {
		this.comment.setAttachmentsCount(Long.valueOf(attachmentsCount));
		return this;
	}
	
	public Comment build() {
		return comment;
	}
	
}