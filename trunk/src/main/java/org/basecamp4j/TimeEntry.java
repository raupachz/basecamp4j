package org.basecamp4j;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class TimeEntry implements Serializable {
	
	private Long id;
	private Long projectId;
	private Long personId;
	private Date date;
	private String hours;
	private String description;
	private Long todoItemId;
	
	public static class Builder {
		
		private final TimeEntry timeEntry;
		
		public Builder() {
			this.timeEntry = new TimeEntry();
		}
		
		public Builder id(Long id) {
			this.timeEntry.setId(id);
			return this;
		}
		
		public Builder id(String id) {
			this.timeEntry.setId(Long.valueOf(id));
			return this;
		}
		
		public Builder projectId(Long projectId) {
			this.timeEntry.setProjectId(projectId);
			return this;
		}
		
		public Builder projectId(String projectId) {
			this.timeEntry.setProjectId(Long.valueOf(projectId));
			return this;
		}
		
		public Builder personId(Long personId) {
			this.timeEntry.setPersonId(personId);
			return this;
		}
		
		public Builder personId(String personId) {
			this.timeEntry.setPersonId(Long.valueOf(personId));
			return this;
		}
		
		public Builder date(Date date) {
			this.timeEntry.setDate(date);
			return this;
		}
		
		public Builder date(String date) {
			this.timeEntry.setDate(BasecampApi.parseISODate(date));
			return this;
		}
		
		public Builder hours(String hours) {
			this.timeEntry.setHours(hours);
			return this;
		}
		
		public Builder description(String description) {
			this.timeEntry.setDescription(description);
			return this;
		}
		
		public Builder todoItemId(Long todoItemId) {
			this.timeEntry.setTodoItemId(todoItemId);
			return this;
		}
		
		public Builder todoItemId(String todoItemId) {
			this.timeEntry.setTodoItemId(Long.valueOf(todoItemId));
			return this;
		}
		
		public TimeEntry build() {
			return timeEntry;
		}
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getProjectId() {
		return projectId;
	}
	
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	public Long getPersonId() {
		return personId;
	}
	
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getHours() {
		return hours;
	}
	
	public void setHours(String hours) {
		this.hours = hours;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getTodoItemId() {
		return todoItemId;
	}
	
	public void setTodoItemId(Long todoItemId) {
		this.todoItemId = todoItemId;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("id",getId())
			.append("projectId",getProjectId())
			.append("personId",getPersonId())
			.append("date",getDate())
			.append("hours",getHours())
			.append("description",getDescription())
			.append("todoItemId",getTodoItemId())
			.toString();
	}
	
}
