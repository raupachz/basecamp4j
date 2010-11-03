package org.basecamp4j;

import java.util.Date;

import org.jdom.Element;

class CommentBuilder extends AbstractResourceBuilder<Comment>{
	
	private final Comment comment;
	
	public CommentBuilder() {
		super();
		this.comment = new Comment();
	}
	
	public CommentBuilder(Element element) {
		this();
		id(element.getChildText("id"));
		authorId(element.getChildText("author-id"));
		authorName(element.getChildText("author-name"));
		commentableId(element.getChildText("commentable-id"));
		commentableType(element.getChildText("commentable-type"));
		body(element.getChildText("body"));
		emailedFrom(element.getChildText("emailed-from"));
		createdAt(element.getChildText("created-at"));
		attachmentsCount(element.getChildText("attachments-count"));
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
		this.comment.setCreatedAt(parseISODateTime(createdAt));
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