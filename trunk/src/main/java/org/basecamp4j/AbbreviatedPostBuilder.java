package org.basecamp4j;

import java.util.Date;

import org.jdom.Element;

class AbbreviatedPostBuilder extends AbstractResourceBuilder<AbbreviatedPost> {
	
	private final AbbreviatedPost post;
	
	public AbbreviatedPostBuilder() {
		this.post = new AbbreviatedPost();
	}
	
	public AbbreviatedPostBuilder(Element element) {
		this();
		id(element.getChildText("id"));
		title(element.getChildText("title"));
		authorName(element.getChildText("author-name"));
		postedOn(element.getChildText("posted-on"));
		attachmentsCount(element.getChildText("attachments-count"));
	}
	
	public AbbreviatedPostBuilder id(Long id) {
		this.post.setId(id);
		return this;
	}
	
	public AbbreviatedPostBuilder id(String id) {
		this.post.setId(Long.valueOf(id));
		return this;
	}
	
	public AbbreviatedPostBuilder title(String title) {
		this.post.setTitle(title);
		return this;
	}
	
	public AbbreviatedPostBuilder authorName(String authorName) {
		this.post.setAuthorName(authorName);
		return this;
	}
	
	public AbbreviatedPostBuilder postedOn(Date postedOn) {
		this.post.setPostedOn(postedOn);
		return this;
	}
	
	public AbbreviatedPostBuilder postedOn(String postedOn) {
		this.post.setPostedOn(parseISODateTime(postedOn));
		return this;
	}
	
	public AbbreviatedPostBuilder attachmentsCount(Long attachmentsCount) {
		this.post.setAttachmentsCount(attachmentsCount);
		return this;
	}
	
	public AbbreviatedPostBuilder attachmentsCount(String attachmentsCount) {
		this.post.setAttachmentsCount(Long.valueOf(attachmentsCount));
		return this;
	}
	
	public AbbreviatedPost build() {
		return post;
	}
	
}