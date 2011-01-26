package org.basecamp4j;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

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
public class TimeEntry implements Serializable {
	
	private Long id;
	private Long projectId;
	private Long personId;
	private Date date;
	private String hours;
	private String description;
	private Long todoItemId;
	
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
