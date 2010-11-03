package org.basecamp4j;

import java.util.Date;

import org.jdom.Element;

class MilestoneBuilder extends AbstractResourceBuilder<Milestone>{
	
	private final Milestone milestone;
	
	public MilestoneBuilder() {
		super();
		this.milestone = new Milestone();
	}
	
	public MilestoneBuilder(Element element) {
		this();
		id(element.getChildText("id"));
		title(element.getChildText("title"));
		deadline(element.getChildText("deadline"));
		completed(element.getChildText("completed"));
		projectId(element.getChildText("project-id"));
		createdOn(element.getChildText("created-on"));
		creatorId(element.getChildText("creator-id"));
		creatorName(element.getChildText("creator-name"));
		responsiblePartyId(element.getChildText("responsible-party-id"));
		responsiblePartyType(element.getChildText("responsible-party-type"));
		responsiblePartyName(element.getChildText("responsible-party-name"));
		commentsCount(element.getChildText("comments-count"));
		completedOn(element.getChildText("completed-on"));
		completerId(element.getChildText("completer-id"));
		completerName(element.getChildText("completer-name"));
	}
	
	public MilestoneBuilder id(Long id) {
		this.milestone.setId(id);
		return this;
	}
	
	public MilestoneBuilder id(String id) {
		this.milestone.setId(Long.valueOf(id));
		return this;
	}
	
	public MilestoneBuilder title(String title) {
		this.milestone.setTitle(title);
		return this;
	}
	
	public MilestoneBuilder deadline(Date deadline) {
		this.milestone.setDeadline(deadline);
		return this;
	}
	
	public MilestoneBuilder deadline(String deadline) {
		this.milestone.setDeadline(parseISODate(deadline));
		return this;
	}
	
	public MilestoneBuilder completed(Boolean completed) {
		this.milestone.setCompleted(completed);
		return this;
	}
	
	public MilestoneBuilder completed(String completed) {
		this.milestone.setCompleted(Boolean.valueOf(completed));
		return this;
	}
	
	public MilestoneBuilder projectId(Long projectId) {
		this.milestone.setProjectId(projectId);
		return this;
	}
	
	public MilestoneBuilder projectId(String projectId) {
		this.milestone.setProjectId(Long.valueOf(projectId));
		return this;
	}
	
	public MilestoneBuilder createdOn(Date createdOn) {
		this.milestone.setCreatedOn(createdOn);
		return this;
	}
	
	public MilestoneBuilder createdOn(String createdOn) {
		this.milestone.setCreatedOn(parseISODateTime(createdOn));
		return this;
	}
	
	public MilestoneBuilder creatorId(Long creatorId) {
		this.milestone.setCreatorId(creatorId);
		return this;
	}
	
	public MilestoneBuilder creatorId(String creatorId) {
		this.milestone.setCreatorId(Long.valueOf(creatorId));
		return this;
	}
	
	public MilestoneBuilder creatorName(String creatorName) {
		this.milestone.setCreatorName(creatorName);
		return this;
	}
	
	public MilestoneBuilder responsiblePartyId(Long responsiblePartyId) {
		this.milestone.setResponsiblePartyId(responsiblePartyId);
		return this;
	}
	
	public MilestoneBuilder responsiblePartyId(String responsiblePartyId) {
		this.milestone.setResponsiblePartyId(Long.valueOf(responsiblePartyId));
		return this;
	}
	
	public MilestoneBuilder responsiblePartyType(String responsiblePartyType) {
		this.milestone.setResponsiblePartyType(responsiblePartyType);
		return this;
	}
	
	public MilestoneBuilder responsiblePartyName(String responsiblePartyName) {
		this.milestone.setResponsiblePartyName(responsiblePartyName);
		return this;
	}
	
	public MilestoneBuilder commentsCount(Long commentsCount) {
		this.milestone.setCommentsCount(commentsCount);
		return this;
	}
	
	public MilestoneBuilder commentsCount(String commentsCount) {
		this.milestone.setCommentsCount(Long.valueOf(commentsCount));
		return this;
	}
	
	public MilestoneBuilder completedOn(Date completedOn) {
		this.milestone.setCompletedOn(completedOn);
		return this;
	}
	
	public MilestoneBuilder completedOn(String completedOn) {
		this.milestone.setCompletedOn(parseISODateTime(completedOn));
		return this;
	}
	
	public MilestoneBuilder completerId(Long completerId) {
		this.milestone.setCompleterId(completerId);
		return this;
	}
	
	public MilestoneBuilder completerId(String completerId) {
		this.milestone.setCompleterId(Long.valueOf(completerId));
		return this;
	}
	
	public MilestoneBuilder completerName(String completerName) {
		this.milestone.setCompleterName(completerName);
		return this;
	}
	
	public Milestone build() {
		return milestone;
	}
}