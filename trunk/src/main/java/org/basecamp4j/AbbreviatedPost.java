package org.basecamp4j;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.jdom.Element;

public class AbbreviatedPost implements Serializable {
	
	private Long id;
	private String title;
	private String authorName;
	private Date postedOn;
	private Long attachmentsCount;
	private Category category;
	
	public static class Builder {
		
		private final AbbreviatedPost post;
		
		public Builder() {
			this.post = new AbbreviatedPost();
		}
		
		public Builder(Element element) {
			this();
			id(element.getChildText("id"));
			title(element.getChildText("title"));
			authorName(element.getChildText("author-name"));
			postedOn(element.getChildText("posted-on"));
			attachmentsCount(element.getChildText("attachments-count"));
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
		
		public Builder authorName(String authorName) {
			this.post.setAuthorName(authorName);
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
		
		public Builder attachmentsCount(Long attachmentsCount) {
			this.post.setAttachmentsCount(attachmentsCount);
			return this;
		}
		
		public Builder attachmentsCount(String attachmentsCount) {
			this.post.setAttachmentsCount(Long.valueOf(attachmentsCount));
			return this;
		}
		
		public AbbreviatedPost build() {
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
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public Date getPostedOn() {
		return postedOn;
	}
	
	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}
	
	public Long getAttachmentsCount() {
		return attachmentsCount;
	}
	
	public void setAttachmentsCount(Long attachmentsCount) {
		this.attachmentsCount = attachmentsCount;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("id",getId())
			.append("title",getTitle())
			.append("authorName",getAuthorName())
			.append("postedOn",getPostedOn())
			.append("attachmentsCount",getAttachmentsCount())
			.toString();
	}
	
	
	
}
