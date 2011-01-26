package org.basecamp4j;

import java.util.Date;

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
class TimeEntryBuilder {
	
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
		this.timeEntry.setDate(IsoDateTimeFormat.parseDate(date));
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