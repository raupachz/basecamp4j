package org.basecamp4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.jdom.Element;

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
	
	public static class Builder {
		
		private final Comment comment;
		
		public Builder() {
			this.comment = new Comment();
		}
		
		public Builder(Element element) {
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
		
		public Builder id(Long id) {
			this.comment.setId(id);
			return this;
		}
		
		public Builder id(String id) {
			this.comment.setId(Long.valueOf(id));
			return this;
		}
		
		public Builder authorId(Long authorId) {
			this.comment.setAuthorId(authorId);
			return this;
		}
		
		public Builder authorId(String authorId) {
			this.comment.setAuthorId(Long.valueOf(authorId));
			return this;
		}
		
		public Builder authorName(String authorName) {
			this.comment.setAuthorName(authorName);
			return this;
		}
		
		public Builder commentableId(Long commentableId) {
			this.comment.setCommentableId(commentableId);
			return this;
		}
		
		public Builder commentableId(String commentableId) {
			this.comment.setCommentableId(Long.valueOf(commentableId));
			return this;
		}
		
		public Builder commentableType(String commentableType) {
			this.comment.setCommentableType(commentableType);
			return this;
		}
		
		public Builder body(String body) {
			this.comment.setBody(body);
			return this;
		}
		
		public Builder emailedFrom(String emailedFrom) {
			this.comment.setEmailedFrom(emailedFrom);
			return this;
		}
		
		public Builder createdAt(Date createdAt) {
			this.comment.setCreatedAt(createdAt);
			return this;
		}
		
		public Builder createdAt(String createdAt) {
			this.comment.setCreatedAt(BasecampApi.parseISODateTime(createdAt));
			return this;
		}
		
		public Builder attachmentsCount(Long attachmentsCount) {
			this.comment.setAttachmentsCount(attachmentsCount);
			return this;
		}
		
		public Builder attachmentsCount(String attachmentsCount) {
			this.comment.setAttachmentsCount(Long.valueOf(attachmentsCount));
			return this;
		}
		
		public Comment build() {
			return comment;
		}
		
	}
	
	
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
