package org.basecamp4j;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class TodoList implements Serializable {
	
	private Long id;
	private String name;
	private String description;
	private Long projectId;
	private Long milestoneId;
	private Long position;
	private Boolean priva4e;
	private Boolean tracked;
	private List<TodoItem> todoItems;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getProjectId() {
		return projectId;
	}
	
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	public Long getMilestoneId() {
		return milestoneId;
	}
	
	public void setMilestoneId(Long milestoneId) {
		this.milestoneId = milestoneId;
	}
	
	public Long getPosition() {
		return position;
	}
	
	public void setPosition(Long position) {
		this.position = position;
	}
	
	public Boolean getPrivate() {
		return priva4e;
	}
	
	public void setPrivate(Boolean priva4e) {
		this.priva4e = priva4e;
	}
	
	public Boolean getTracked() {
		return tracked;
	}
	
	public void setTracked(Boolean tracked) {
		this.tracked = tracked;
	}
	
	public List<TodoItem> getTodoItems() {
		return todoItems;
	}
	
	public void setTodoItems(List<TodoItem> todoItems) {
		this.todoItems = todoItems;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("id",getId())
			.append("name",getName())
			.append("description",getDescription())
			.append("projectId",getProjectId())
			.append("milestoneId",getMilestoneId())
			.append("positionId",getPosition())
			.append("private",getPrivate())
			.append("tracked",getTracked())
			.toString();
	}
	
}
