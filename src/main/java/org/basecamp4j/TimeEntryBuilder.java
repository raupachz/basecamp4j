package org.basecamp4j;

import java.util.Date;

class TimeEntryBuilder extends AbstractResourceBuilder<TimeEntry> {
	
	private final TimeEntry timeEntry;
	
	public TimeEntryBuilder() {
		super();
		this.timeEntry = new TimeEntry();
	}
	
	public TimeEntryBuilder id(Long id) {
		this.timeEntry.setId(id);
		return this;
	}
	
	public TimeEntryBuilder id(String id) {
		this.timeEntry.setId(Long.valueOf(id));
		return this;
	}
	
	public TimeEntryBuilder projectId(Long projectId) {
		this.timeEntry.setProjectId(projectId);
		return this;
	}
	
	public TimeEntryBuilder projectId(String projectId) {
		this.timeEntry.setProjectId(Long.valueOf(projectId));
		return this;
	}
	
	public TimeEntryBuilder personId(Long personId) {
		this.timeEntry.setPersonId(personId);
		return this;
	}
	
	public TimeEntryBuilder personId(String personId) {
		this.timeEntry.setPersonId(Long.valueOf(personId));
		return this;
	}
	
	public TimeEntryBuilder date(Date date) {
		this.timeEntry.setDate(date);
		return this;
	}
	
	public TimeEntryBuilder date(String date) {
		this.timeEntry.setDate(parseISODate(date));
		return this;
	}
	
	public TimeEntryBuilder hours(String hours) {
		this.timeEntry.setHours(hours);
		return this;
	}
	
	public TimeEntryBuilder description(String description) {
		this.timeEntry.setDescription(description);
		return this;
	}
	
	public TimeEntryBuilder todoItemId(Long todoItemId) {
		this.timeEntry.setTodoItemId(todoItemId);
		return this;
	}
	
	public TimeEntryBuilder todoItemId(String todoItemId) {
		this.timeEntry.setTodoItemId(Long.valueOf(todoItemId));
		return this;
	}
	
	public TimeEntry build() {
		return timeEntry;
	}
	
}