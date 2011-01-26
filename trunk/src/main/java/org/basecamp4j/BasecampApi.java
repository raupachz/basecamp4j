package org.basecamp4j;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class BasecampApi {

	private final HttpConnection httpConnection;
	private final ResourceFactory factory;

	/**
	 * @see <a href="http://developer.37signals.com/basecamp/">Basecamp API</a>
	 * @param host your basecamp domain
	 * @param token your authentication token
	 */
	public BasecampApi(String host, String token) {
		this.httpConnection = new HttpConnection(host, token).openConnection();
		this.factory = new ResourceFactory();
	}

	/**
	 * Returns info about the current Basecamp account, its subscription, 
	 * and the default post and attachment categories. 
	 * @return info about the current Basecamp account
	 */
	public Account getAccount() {
		URI uri = httpConnection.createURI("/account.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildAccount(httpStream);
	}

	/**
	 * Returns a single project identified by its integer ID.
	 * 
	 * @param id project ID
	 * @return single project identified by its integer ID, or null if there is
	 *         no project with this ID.
	 */
	public Project getProject(Long id) {
		URI uri = httpConnection.createURI("/projects/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildProject(httpStream);
	}
	
	/**
	 * Returns a count of all projects, by project status. If there are no
	 * projects with a particular status, that status entry will be
	 * omitted from the report.
	 * @return count of all projects
	 */
	public ProjectCounts getProjectCounts() {
		URI uri = httpConnection.createURI("/projects/count.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildProjectCounts(httpStream);
	}

	/**
	 * Returns all accessible projects. This includes active, inactive, and
	 * archived projects.
	 * 
	 * @return all accessible projects.
	 */
	public List<Project> getProjects() {
		URI uri = httpConnection.createURI("/projects.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildProjects(httpStream);
	}
	
	/**
	 * Creates a new project with the given name.
	 * @param name name of the new project
	 */
	public void createProject(String name) {
		URI uri = httpConnection.createURI("/projects.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<request>");
		sb.append("<project>");
		sb.append("<name>").append(name).append("</name>");
		sb.append("</project>");
		sb.append("</request>");
		
		httpConnection.doPost(uri, sb.toString());
	}

	/**
	 * Returns a list of all companies visible to the requesting user.
	 * 
	 * @return list of visible companies.
	 */
	public List<Company> getCompanies() {
		URI uri = httpConnection.createURI("/companies.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildCompanies(httpStream);
	}

	/**
	 * Returns a list of all companies associated with the given project.
	 * 
	 * @param project
	 * @return all companies associated with the given project, or null if there
	 *         is no company with this ID.
	 */
	public List<Company> getCompanies(Project project) {
		URI uri = httpConnection.createURI("/projects/" + project.getId() + "/companies.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildCompanies(httpStream);
	}

	/**
	 * Returns a single company identified by its integer ID.
	 * 
	 * @param id
	 *            company ID
	 * @return single company identified by its integer ID.
	 */
	public Company getCompany(Long id) {
		URI uri = httpConnection.createURI("/companies/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildCompany(httpStream);
	}
	
	/**
	 * Returns all categories for the given project. 
	 * @param project
	 * @return all categories for the given project.
	 */
	public List<Category> getCategories(Project project) {
		URI uri = httpConnection.createURI("/projects/" + project.getId() + "/categories.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.getCategories(httpStream);
	}
	
	/**
	 * Creates a new category of the given type for the given project.
	 * @param project
	 * @param name 
	 * @param type muste be one of "post" or "attachment"
	 */
	public void createCategory(Project project, final String name, final String type) {
		URI uri = httpConnection.createURI("/projects/" + project.getId() + "/categories.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<category>");
		sb.append("  <type>").append(type).append("</type>");
		sb.append("  <name>").append(name).append("</name>");
		sb.append("</category>");
		
		httpConnection.doPost(uri, sb.toString());
	}
	
	/**
	 * Updates an existing category.
	 * @param category
	 */
	public void updateCategory(Category category) {
		URI uri = httpConnection.createURI("/categories/" + category.getId() + ".xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<category>");
		sb.append("  <name>").append(category.getName()).append("</name>");
		sb.append("</category>");
		
		httpConnection.doPut(uri, sb.toString());
	}
	
	/**
	 * Deletes the category. Note that only categories without elements can be deleted.
	 * @param category
	 */
	public void destroyCategory(Category category) {
		URI uri = httpConnection.createURI("/categories/" + category.getId() + ".xml");
		httpConnection.doDelete(uri);
	}

	
	/**
	 * Returns a single category identified by its integer ID.
	 * @param id
	 * @return a single category identified by its integer ID.
	 */
	public Category getCategory(Long id) {
		URI uri = httpConnection.createURI("/categories/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildCategory(httpStream);
	}

	/**
	 * Returns the currently logged in person.
	 * @return you
	 */
	public Person getCurrentPerson() {
		URI uri = httpConnection.createURI("/me.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildPerson(httpStream);
	}
	
	/**
	 * Returns all people visible to (and including) the requesting user.
	 * @return all people visible to (and including) the requesting user.
	 */
	public List<Person> getPeople() {
		URI uri = httpConnection.createURI("/people.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildPeople(httpStream);
	}
	
	/**
	 * Returns all people with access to the given project.
	 * @param project
	 * @return all people with access to the given project.
	 */
	public List<Person> getPeople(Project project) {
		URI uri = httpConnection.createURI("/projects/" + project.getId() + "/people.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildPeople(httpStream);
	}
	
	/**
	 * Returns all people from the given company that are visible to the requesting user.
	 * @param company
	 * @return all people from the given company that are visible to the requesting user.
	 */
	public List<Person> getPeople(Company company) {
		List<Person> resultList = new ArrayList<Person>();
		URI uri = httpConnection.createURI("/companies/" + company.getId() + "/people.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildPeople(httpStream);
	}
	
	/**
	 * Returns a single person identified by their integer ID.
	 * @param id 
	 * @return a single person identified by their integer ID.
	 */
	public Person getPerson(Long id) {
		URI uri = httpConnection.createURI("/people/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildPerson(httpStream);
	}

	public List<Attachment> getFiles(Project project) {
		URI uri = httpConnection.createURI("/projects/" + project.getId() + "/attachments.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildAttachments(httpStream);
	}
	
	/**
	 * Returns the 25 most recent messages in the given project.
	 * @param project
	 * @return the 25 most recent messages in the given project.
	 */
	public List<Post> getMessages(Project project) {
		URI uri = httpConnection.createURI("/projects/" + project.getId() + "/posts.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildPosts(httpStream);
	}
	
	/**
	 * Returns a single message record identified by its integer ID.
	 * @param id
	 * @return a single message record identified by its integer ID.
	 */
	public Post getMessage(Long id) {
		URI uri = httpConnection.createURI("/posts/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildPost(httpStream);
	}
	
	/**
	 * Returns the most 25 most recent messages in the given project for the given category.
	 * @param project
	 * @param category
	 * @return the most 25 most recent messages in the given project for the given category.
	 */
	public List<Post> getMessages(Project project, Category category) {
		List<Post> resultList = new ArrayList<Post>();
		URI uri = httpConnection.createURI("/projects/" + project.getId() + "/cat/" + category.getId()  + "/posts.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildPosts(httpStream);
	}
	
	public void editMessage(Post post) {
		
	}
	
	public void createMessage(Project project, String title, String body) {
		URI uri = httpConnection.createURI("/projects/" + project.getId() + "/posts.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<request>");
		sb.append("<post>");
		sb.append("  <title>").append(title).append("</title>");
		sb.append("  <body>").append(body).append("</body>");
		sb.append("</post>");
		sb.append("</request>");
		
		httpConnection.doPost(uri, sb.toString());
	}
	
	/**
	 * Destroys the given message and all of its associated comments.
	 * @param post
	 */
	public void destroyMessage(Post post) {
		URI uri = httpConnection.createURI("/posts/" + post.getId() + ".xml");
		httpConnection.doDelete(uri);
	}
	
	/**
	 * Return a list of the 50 most recent comments associated with the specified resource.
	 */
	public List<Comment> getComments(Resource resource, Long resourceId) {
		URI uri = httpConnection.createURI("/" + resource  +  "/" + resourceId + "/comments.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildComments(httpStream);
	}
	
	/**
	 * Retrieve a specific comment by its id.
	 */
	public Comment getComment(Long id) {
		URI uri = httpConnection.createURI("/comments/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildComment(httpStream);
	}
	
	/**
	 * Create a new comment, associating it with a specific resource.
	 * @param resource posts, milestones, or todo_items
	 * @param resourceId
	 * @param comment
	 */
	public void createComment(Resource resource, Long resourceId, String comment) {
		URI uri = httpConnection.createURI("/" + resource  +  "/" + resourceId + "/comments.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<comment>");
		sb.append("  <body>").append(comment).append("</body>");
		sb.append("</comment>");
		
		httpConnection.doPost(uri, sb.toString());
	}
	
	/**
	 * Delete the comment with the given ID.
	 * @param comment
	 */
	public void destroyComment(Comment comment) {
		URI uri = httpConnection.createURI("/comments/" + comment.getId() + ".xml");
		httpConnection.doDelete(uri);
	}
	
	/**
	 * This lets you query the list of milestones for a project. 
	 * You can either return all milestones, or only those that 
	 * are late, completed, or upcoming.
	 * @param project
	 * @return
	 */
	public List<Milestone> getMilestones(Project project) {
		URI uri = httpConnection.createURI("/projects/" + project.getId() + "/milestones/list.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildMilestones(httpStream);
	}
	
	/**
	 * Marks the specified milestone as complete.
	 * @param milestone
	 * @return 
	 */
	public void completeMilestone(Milestone milestone) {
		URI uri = httpConnection.createURI("/milestones/complete/" + milestone.getId());
		httpConnection.doPut(uri);
	}
	
	/**
	 * Marks the specified milestone as uncomplete.
	 * @param milestone
	 */
	public void uncompleteMilestone(Milestone milestone) {
		URI uri = httpConnection.createURI("/milestones/uncomplete/" + milestone.getId());
		httpConnection.doPut(uri);
	}
	
	/**
	 * Creates a single milestone.
	 * @param project
	 * @param title
	 * @param deadline
	 * @param responsiblePerson
	 * @param notify
	 */
	public void createMilestone(Project project, String title, Date deadline, Person responsiblePerson,  boolean notify) {
		URI uri = httpConnection.createURI("/projects/" + project.getId() + "/milestones/create");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<request>");
		sb.append("<milestone>");
		sb.append("<title>").append(title).append("</title>");
		sb.append("<deadline>").append(IsoDateTimeFormat.formatDate(deadline)).append("</deadline>");
		sb.append("<responsible-party>").append(responsiblePerson.getId()).append("</responsible-party>");
		sb.append("<notify>").append(notify).append("</notify>");
		sb.append("</milestone>");
		sb.append("</request>");
		
		httpConnection.doPost(uri, sb.toString());
	}
	
	/**
	 * Deletes the given milestone from the project.
	 * @param milestone
	 */
	public void deleteMilestone(Milestone milestone) {
		URI uri = httpConnection.createURI("/milestones/delete/" + milestone.getId());
		httpConnection.doPost(uri);
	}
	
	/**
	 * Creates a single milestone.
	 * @param project
	 * @param title
	 * @param deadline
	 * @param responsibleCompany
	 * @param notify
	 */
	public void createMilestone(Project project, String title, Date deadline, Company responsibleCompany,  boolean notify) {
		URI uri = httpConnection.createURI("/projects/" + project.getId() + "/milestones/create");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<request>");
		sb.append("<milestone>");
		sb.append("<title>").append(title).append("</title>");
		sb.append("<deadline>").append(IsoDateTimeFormat.formatDate(deadline)).append("</deadline>");
		sb.append("<responsible-party>").append("c" + responsibleCompany.getId()).append("</responsible-party>");
		sb.append("<notify>").append(notify).append("</notify>");
		sb.append("</milestone>");
		sb.append("</request>");
		
		httpConnection.doPost(uri, sb.toString());
	}
	
	public void updateMilestone(Milestone milestone, boolean notify, boolean moveUpcomingMilestones, boolean moveUpcomingMilestonesOffWeekends) {
		URI uri = httpConnection.createURI("/milestones/update/" + milestone.getId());
		
		StringBuilder sb = new StringBuilder();
		sb.append("<request>");
		sb.append("<milestone>");
		sb.append("<title>").append(milestone.getTitle()).append("</title>");
		sb.append("<deadline>").append(IsoDateTimeFormat.formatDate(milestone.getDeadline())).append("</deadline>");
		sb.append("<responsible-party>").append(milestone.getResponsiblePartyId()).append("</responsible-party>");
		sb.append("<notify>").append(notify).append("</notify>");
		sb.append("</milestone>");
		sb.append("<move-upcoming-milestones>").append(moveUpcomingMilestones).append("</move-upcoming-milestones>");
		sb.append("<move-upcoming-milestones>").append(moveUpcomingMilestonesOffWeekends).append("</move-upcoming-milestones>");
		sb.append("</request>");
		
		httpConnection.doPost(uri, sb.toString());
	}
	
	/**
	 * Returns a list of todo-list records
	 * @return todo-lists
	 */
	public List<TodoList> getTodoLists() {
		URI uri = httpConnection.createURI("/todo_lists.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildTodoLists(httpStream);
	}
	
	public List<TodoList> getTodoLists(Project project) {
		List<TodoList> resultList = new ArrayList<TodoList>();
		URI uri = httpConnection.createURI("/projects/" + project.getId() + "/todo_lists.xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildTodoLists(httpStream);
	}
	
	public TodoList getTodoList(Long id) {
		URI uri = httpConnection.createURI("/todo_lists/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(uri);
		return factory.buildTodoList(httpStream);
	}
	
	public void dispose() {
		httpConnection.close();
	}
	
}
