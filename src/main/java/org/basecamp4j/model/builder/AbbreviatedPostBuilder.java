package org.basecamp4j.model.builder;

import java.util.Date;

import org.basecamp4j.model.AbbreviatedPost;
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
class AbbreviatedPostBuilder {
	
	private final AbbreviatedPost post;
	
	public AbbreviatedPostBuilder() {
		this.post = new AbbreviatedPost();
	}
	
	public AbbreviatedPostBuilder(Element element) {
		this();
		id(DOMUtils.getChildText(element,"id"));
		title(DOMUtils.getChildText(element,"title"));
		authorName(DOMUtils.getChildText(element,"author-name"));
		postedOn(DOMUtils.getChildText(element,"posted-on"));
		attachmentsCount(DOMUtils.getChildText(element,"attachments-count"));
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
		this.post.setPostedOn(IsoDateTimeFormat.parseDateTime(postedOn));
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