package org.basecamp4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jdom.Element;

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
	
	public static class Builder {
		
		private final Post post;
		
		public Builder() {
			this.post = new Post();
		}
		
		public Builder(Element element) {
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
		
		public Builder id(Long id) {
			this.post.setId(id);
			return this;
		}
		
		public Builder id(String id) {
			this.post.setId(Long.valueOf(id));
			return this;
		}
		
		public Builder title(String title) {
			this.post.setTitle(title);
			return this;
		}
		
		public Builder body(String body) {
			this.post.setBody(body);
			return this;
		}
		
		public Builder displayBody(String displayBody) {
			this.post.setDisplayBody(displayBody);
			return this;
		}
		
		public Builder postedOn(Date postedOn) {
			this.post.setPostedOn(postedOn);
			return this;
		}
		
		public Builder postedOn(String postedOn) {
			this.post.setPostedOn(BasecampApi.parseISODateTime(postedOn));
			return this;
		}
		
		public Builder projectId(Long projectId) {
			this.post.setProjectId(projectId);
			return this;
		}
		
		public Builder projectId(String projectId) {
			this.post.setProjectId(Long.valueOf(projectId));
			return this;
		}
		
		public Builder categoryId(Long categoryId) {
			this.post.setCategoryId(categoryId);
			return this;
		}
		
		public Builder categoryId(String categoryId) {
			if (StringUtils.isNotBlank(categoryId)) {
				this.post.setCategoryId(Long.valueOf(categoryId));
			}
			return this;
		}
		
		public Builder authorId(Long authorId) {
			this.post.setAuthorId(authorId);
			return this;
		}
		
		public Builder authorId(String authorId) {
			this.post.setAuthorId(Long.valueOf(authorId));
			return this;
		}
		
		public Builder authorName(String authorName) {
			this.post.setAuthorName(authorName);
			return this;
		}
		
		public Builder milestoneId(Long milestoneId) {
			this.post.setMilestoneId(milestoneId);
			return this;
		}
		
		public Builder milestoneId(String milestoneId) {
			this.post.setMilestoneId(Long.valueOf(milestoneId));
			return this;
		}
		
		public Builder commentsCount(Long commentsCount) {
			this.post.setCommentsCount(commentsCount);
			return this;
		}
		
		public Builder commentsCount(String commentsCount) {
			this.post.setCommentsCount(Long.valueOf(commentsCount));
			return this;
		}
		
		public Builder useTextile(Boolean useTextile) {
			this.post.setUseTextile(useTextile);
			return this;
		}
		
		public Builder useTextile(String useTextile) {
			this.post.setUseTextile(Boolean.valueOf(useTextile));
			return this;
		}
		
		public Builder attachmentsCount(Long attachmentsCount) {
			this.post.setAttachmentsCount(attachmentsCount);
			return this;
		}
		
		public Builder attachmentsCount(String attachmentsCount) {
			this.post.setAttachmentsCount(Long.valueOf(attachmentsCount));
			return this;
		}
		
		public Builder priva4e(Boolean priva4e) {
			this.post.setPrivate(priva4e);
			return this;
		}
		
		public Builder priva4e(String priva4e) {
			this.post.setPrivate(Boolean.valueOf(priva4e));
			return this;
		}
		
		public Post build() {
			return post;
		}
		
	}
	
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
