package org.basecamp4j;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.basecamp4j.factory.ResourceFactory;
import org.basecamp4j.logging.DefaultFormatter;
import org.basecamp4j.model.Account;
import org.basecamp4j.model.Attachment;
import org.basecamp4j.model.Category;
import org.basecamp4j.model.Comment;
import org.basecamp4j.model.Company;
import org.basecamp4j.model.Filter;
import org.basecamp4j.model.Milestone;
import org.basecamp4j.model.Person;
import org.basecamp4j.model.Post;
import org.basecamp4j.model.Project;
import org.basecamp4j.model.ProjectCounts;
import org.basecamp4j.model.Resource;
import org.basecamp4j.model.TodoItem;
import org.basecamp4j.model.TodoList;
import org.basecamp4j.model.http.HttpConnection;
import org.basecamp4j.model.http.URLBuilder;
import org.basecamp4j.utils.IsoDateTimeFormat;

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
	
	private static final Logger logger = Logger.getLogger("org.basecamp4j");

	private final String host;
	private final HttpConnection httpConnection;
	private final ResourceFactory factory;

	/**
	 * @see <a href="http://developer.37signals.com/basecamp/">Basecamp API</a>
	 * @param host your basecamp domain
	 * @param token your authentication token
	 */
	public BasecampApi(String host, String token) {
		this.host = host;
		this.httpConnection = new HttpConnection(token, "X");
		this.factory = new ResourceFactory();
	}
	
	public BasecampApi(String host, String token, boolean debug) {
		this.host = host;
		this.httpConnection = new HttpConnection(token, "X");
		this.factory = new ResourceFactory();
		if (debug) {
			initializeLogging();
		}
	}
	
	private void initializeLogging() {
		Handler[] handlers = Logger.getLogger("").getHandlers();
		for (Handler h : handlers) {
			h.setLevel(Level.FINE);
			h.setFormatter(new DefaultFormatter());
		}
		logger.setLevel(Level.FINE);
	}

	/**
	 * Returns info about the current Basecamp account, its subscription, 
	 * and the default post and attachment categories. 
	 * @return info about the current Basecamp account
	 */
	public Account getAccount() {
		URLBuilder url = new URLBuilder(host, "/account.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
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
		URLBuilder url = new URLBuilder(host, "/projects/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildProject(httpStream);
	}
	
	/**
	 * Returns a count of all projects, by project status. If there are no
	 * projects with a particular status, that status entry will be
	 * omitted from the report.
	 * @return count of all projects
	 */
	public ProjectCounts getProjectCounts() {
		URLBuilder url = new URLBuilder(host, "/projects/count.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildProjectCounts(httpStream);
	}

	/**
	 * Returns all accessible projects. This includes active, inactive, and
	 * archived projects.
	 * 
	 * @return all accessible projects.
	 */
	public List<Project> getProjects() {
		URLBuilder url = new URLBuilder(host, "/projects.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildProjects(httpStream);
	}
	
	/**
	 * Creates a new project with the given name.
	 * @param name name of the new project
	 */
	public void createProject(String name) {
		URLBuilder url = new URLBuilder(host, "/projects.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<request>");
		sb.append("<project>");
		sb.append("<name>").append(name).append("</name>");
		sb.append("</project>");
		sb.append("</request>");
		
		httpConnection.doPost(url.toURL(), sb.toString());
	}

	/**
	 * Returns a list of all companies visible to the requesting user.
	 * 
	 * @return list of visible companies.
	 */
	public List<Company> getCompanies() {
		URLBuilder url = new URLBuilder(host, "/companies.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
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
		URLBuilder url = new URLBuilder(host, "/projects/" + project.getId() + "/companies.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildCompanies(httpStream);
	}

	/**
	 * Returns a single company identified by its integer ID.
	 * 
	 * @param id company ID
	 * @return single company identified by its integer ID.
	 */
	public Company getCompany(Long id) {
		URLBuilder url = new URLBuilder(host, "/companies/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildCompany(httpStream);
	}
	
	/**
	 * Returns all categories for the given project. 
	 * @param project
	 * @return all categories for the given project.
	 */
	public List<Category> getCategories(Project project) {
		URLBuilder url = new URLBuilder(host, "/projects/" + project.getId() + "/categories.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.getCategories(httpStream);
	}
	
	/**
	 * Creates a new category of the given type for the given project.
	 * @param project
	 * @param name 
	 * @param type muste be one of "post" or "attachment"
	 */
	public void createCategory(Project project, final String name, final String type) {
		URLBuilder url = new URLBuilder(host, "/projects/" + project.getId() + "/categories.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<category>");
		sb.append("  <type>").append(type).append("</type>");
		sb.append("  <name>").append(name).append("</name>");
		sb.append("</category>");
		
		httpConnection.doPost(url.toURL(), sb.toString());
	}
	
	/**
	 * Updates an existing category.
	 * @param category
	 */
	public void updateCategory(Category category) {
		URLBuilder url = new URLBuilder(host, "/categories/" + category.getId() + ".xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<category>");
		sb.append("  <name>").append(category.getName()).append("</name>");
		sb.append("</category>");
		
		httpConnection.doPut(url.toURL(), sb.toString());
	}
	
	/**
	 * Deletes the category. Note that only categories without elements can be deleted.
	 * @param category
	 */
	public void destroyCategory(Category category) {
		URLBuilder url = new URLBuilder(host, "/categories/" + category.getId() + ".xml");
		httpConnection.doDelete(url.toURL());
	}

	
	/**
	 * Returns a single category identified by its integer ID.
	 * @param id
	 * @return a single category identified by its integer ID.
	 */
	public Category getCategory(Long id) {
		URLBuilder url = new URLBuilder(host, "/categories/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildCategory(httpStream);
	}

	/**
	 * Returns the currently logged in person.
	 * @return you
	 */
	public Person getCurrentPerson() {
		URLBuilder url = new URLBuilder(host, "/me.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildPerson(httpStream);
	}
	
	/**
	 * Returns all people visible to (and including) the requesting user.
	 * @return all people visible to (and including) the requesting user.
	 */
	public List<Person> getPeople() {
		URLBuilder url = new URLBuilder(host, "/people.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildPeople(httpStream);
	}
	
	/**
	 * Returns all people with access to the given project.
	 * @param project
	 * @return all people with access to the given project.
	 */
	public List<Person> getPeople(Project project) {
		URLBuilder url = new URLBuilder(host, "/projects/" + project.getId() + "/people.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildPeople(httpStream);
	}
	
	/**
	 * Returns all people from the given company that are visible to the requesting user.
	 * @param company
	 * @return all people from the given company that are visible to the requesting user.
	 */
	public List<Person> getPeople(Company company) {
		List<Person> resultList = new ArrayList<Person>();
		URLBuilder url = new URLBuilder(host, "/companies/" + company.getId() + "/people.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildPeople(httpStream);
	}
	
	/**
	 * Returns a single person identified by their integer ID.
	 * @param id 
	 * @return a single person identified by their integer ID.
	 */
	public Person getPerson(Long id) {
		URLBuilder url = new URLBuilder(host, "/people/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildPerson(httpStream);
	}

	public List<Attachment> getFiles(Project project) {
		URLBuilder url = new URLBuilder(host, "/projects/" + project.getId() + "/attachments.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildAttachments(httpStream);
	}
	
	/**
	 * Returns the 25 most recent messages in the given project.
	 * @param project
	 * @return the 25 most recent messages in the given project.
	 */
	public List<Post> getMessages(Project project) {
		URLBuilder url = new URLBuilder(host, "/projects/" + project.getId() + "/posts.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildPosts(httpStream);
	}
	
	/**
	 * Returns a single message record identified by its integer ID.
	 * @param id
	 * @return a single message record identified by its integer ID.
	 */
	public Post getMessage(Long id) {
		URLBuilder url = new URLBuilder(host, "/posts/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildPost(httpStream);
	}
	
	/**
	 * Returns the most 25 most recent messages in the given project for the given category.
	 * @param project
	 * @param category
	 * @return the most 25 most recent messages in the given project for the given category.
	 */
	public List<Post> getMessages(Project project, Category category) {
		URLBuilder url = new URLBuilder(host, "/projects/" + project.getId() + "/cat/" + category.getId()  + "/posts.xml");
		List<Post> resultList = new ArrayList<Post>();
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildPosts(httpStream);
	}
	
	public void editMessage(Post post) {
		
	}
	
	public void createMessage(Project project, String title, String body) {
		URLBuilder url = new URLBuilder(host, "/projects/" + project.getId() + "/posts.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<request>");
		sb.append("<post>");
		sb.append("  <title>").append(title).append("</title>");
		sb.append("  <body>").append(body).append("</body>");
		sb.append("</post>");
		sb.append("</request>");
		
		httpConnection.doPost(url.toURL(), sb.toString());
	}
	
	/**
	 * Destroys the given message and all of its associated comments.
	 * @param post
	 */
	public void destroyMessage(Post post) {
		URLBuilder url = new URLBuilder(host, "/posts/" + post.getId() + ".xml");
		httpConnection.doDelete(url.toURL());
	}
	
	/**
	 * Return a list of the 50 most recent comments associated with the specified resource.
	 */
	public List<Comment> getComments(Resource resource, Long resourceId) {
		URLBuilder url = new URLBuilder(host, "/" + resource  +  "/" + resourceId + "/comments.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildComments(httpStream);
	}
	
	/**
	 * Retrieve a specific comment by its id.
	 */
	public Comment getComment(Long id) {
		URLBuilder url = new URLBuilder(host, "/comments/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildComment(httpStream);
	}
	
	/**
	 * Create a new comment, associating it with a specific resource.
	 * @param resource posts, milestones, or todo_items
	 * @param resourceId
	 * @param comment
	 */
	public void createComment(Resource resource, Long resourceId, String comment) {
		URLBuilder url = new URLBuilder(host, "/" + resource  +  "/" + resourceId + "/comments.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<comment>");
		sb.append("  <body>").append(comment).append("</body>");
		sb.append("</comment>");
		
		httpConnection.doPost(url.toURL(), sb.toString());
	}
	
	/**
	 * Delete the comment with the given ID.
	 * @param comment
	 */
	public void destroyComment(Comment comment) {
		URLBuilder url = new URLBuilder(host, "/comments/" + comment.getId() + ".xml");
		httpConnection.doDelete(url.toURL());
	}
	
	/**
	 * This lets you query the list of milestones for a project. 
	 * You can either return all milestones, or only those that 
	 * are late, completed, or upcoming.
	 * @param project
	 * @return
	 */
	public List<Milestone> getMilestones(Project project) {
		URLBuilder url = new URLBuilder(host, "/projects/" + project.getId() + "/milestones/list.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildMilestones(httpStream);
	}
	
	/**
	 * Marks the specified milestone as complete.
	 * @param milestone
	 * @return 
	 */
	public void completeMilestone(Milestone milestone) {
		URLBuilder url = new URLBuilder(host, "/milestones/complete/" + milestone.getId());
		httpConnection.doPut(url.toURL());
	}
	
	/**
	 * Marks the specified milestone as uncomplete.
	 * @param milestone
	 */
	public void uncompleteMilestone(Milestone milestone) {
		URLBuilder url = new URLBuilder(host, "/milestones/uncomplete/" + milestone.getId());
		httpConnection.doPut(url.toURL());
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
		URLBuilder url = new URLBuilder(host, "/projects/" + project.getId() + "/milestones/create");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<request>");
		sb.append("<milestone>");
		sb.append("<title>").append(title).append("</title>");
		sb.append("<deadline>").append(IsoDateTimeFormat.formatDate(deadline)).append("</deadline>");
		sb.append("<responsible-party>").append(responsiblePerson.getId()).append("</responsible-party>");
		sb.append("<notify>").append(notify).append("</notify>");
		sb.append("</milestone>");
		sb.append("</request>");
		
		httpConnection.doPost(url.toURL(), sb.toString());
	}
	
	/**
	 * Deletes the given milestone from the project.
	 * @param milestone
	 */
	public void deleteMilestone(Milestone milestone) {
		URLBuilder url = new URLBuilder(host, "/milestones/delete/" + milestone.getId());
		httpConnection.doPost(url.toURL());
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
		URLBuilder url = new URLBuilder(host, "/projects/" + project.getId() + "/milestones/create");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<request>");
		sb.append("<milestone>");
		sb.append("<title>").append(title).append("</title>");
		sb.append("<deadline>").append(IsoDateTimeFormat.formatDate(deadline)).append("</deadline>");
		sb.append("<responsible-party>").append("c").append(responsibleCompany.getId()).append("</responsible-party>");
		sb.append("<notify>").append(notify).append("</notify>");
		sb.append("</milestone>");
		sb.append("</request>");
		
		httpConnection.doPost(url.toURL(), sb.toString());
	}
	
	public void updateMilestone(Milestone milestone, boolean notify, boolean moveUpcomingMilestones, boolean moveUpcomingMilestonesOffWeekends) {
		URLBuilder url = new URLBuilder(host, "/milestones/update/" + milestone.getId());
		
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
		
		httpConnection.doPost(url.toURL(), sb.toString());
	}
	
	/**
	 * Returns a list of todo-list records
	 * @return todo-lists
	 */
	public List<TodoList> getTodoLists() {
		URLBuilder url = new URLBuilder(host, "/todo_lists.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildTodoLists(httpStream);
	}
	
	/**
	 * Returns a list of todo-list records, with todo-item records 
	 * that are assigned to the given “responsible party”. If no
	 * responsible party is given, the current user is assumed to
	 * be the responsible party. The responsible party may be changed
	 * by setting the “responsible_party” query parameter to a blank
	 * string (for unassigned items), a person-id, or a company-id
	 * prefixed by a “c” (e.g., c1234).
	 * @param responsibleParty
	 * @return todo-lists
	 */
	public List<TodoList> getTodoLists(String responsibleParty) {
		URLBuilder url = new URLBuilder(host, "/todo_lists.xml?responsible_party=" + responsibleParty);
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildTodoLists(httpStream);
	}
	
	/**
	 * Returns a list of todo-list records that are in the given project.
	 * @param project
	 * @return list of todo-list records
	 */
	public List<TodoList> getTodoLists(Project project) {
		URLBuilder url = new URLBuilder(host, "/projects/" + project.getId() + "/todo_lists.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildTodoLists(httpStream, false);
	}
	
	/**
	 * Returns a list of todo-list records that are in the given project. 
	 * By default, all lists are returned, but you can filter the result
	 * by giving the “filter” query parameter, set to “all” (the default),
	 * “pending” (for lists with uncompleted items), and “finished”
	 * (for lists that have no uncompleted items).
	 * @param project
	 * @param filter
	 * @return
	 */
	public List<TodoList> getTodoLists(Project project, Filter filter) {
		URLBuilder url = new URLBuilder(host, "/projects/" + project.getId() + "/todo_lists.xml?filter=" + filter.toString());
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildTodoLists(httpStream, false);
	}
	
	/**
	 * Returns a single todo-list record identified by its integer ID.
	 * @param id
	 * @return
	 */
	public TodoList getTodoList(Long id) {
		URLBuilder url = new URLBuilder(host, "/todo_lists/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildTodoList(httpStream);
	}
	
	/**
	 * Destroys the given todo-list and all of its associated todo items.
	 * @param todoList
	 */
	public void destroyTodoList(TodoList todoList) {
		URLBuilder url = new URLBuilder(host, "/todo_lists/" + todoList.getId() + ".xml");
		httpConnection.doDelete(url.toURL());
	}
	
	/**
	 * Returns all todo item records for a single todo list. 
	 * This is almost the same as the “Get list” action, except
	 * it does not return any information about the list itself. 
	 * The items are returned in priority order, as defined by 
	 * how they were ordered either in the web UI, or via the 
	 * “Reorder items” action.
	 * @param list
	 * @return
	 */
	public List<TodoItem> getAllItems(TodoList list) {
		URLBuilder url = new URLBuilder(host, "/todo_lists/" + list.getId() + "/todo_items.xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildTodoItemsList(httpStream);
	}
	
	/**
	 * Returns a single todo item record, given its integer ID.
	 * @param id
	 * @return
	 */
	public TodoItem getItem(Long id) {
		URLBuilder url = new URLBuilder(host, "/todo_items/" + id + ".xml");
		InputStream httpStream = httpConnection.doGet(url.toURL());
		return factory.buildTodoItem(httpStream);
	}
	
	/**
	 * Marks the specified todo item as completed.
	 * @param item
	 */
	public void completeItem(TodoItem item) {
		URLBuilder url = new URLBuilder(host, "/todo_items/" + item.getId() + "/complete.xml");
		httpConnection.doPut(url.toURL());
	}
	
	/**
	 * If the specified todo item was previously marked as completed, 
	 * this unmarks it, restoring it to an “uncompleted” state. 
	 * If it was already in the uncompleted state, this call has no effect.
	 * @param item
	 */
	public void uncompleteItem(TodoItem item) {
		URLBuilder url = new URLBuilder(host, "/todo_items/" + item.getId() + "/uncomplete.xml");
		httpConnection.doPut(url.toURL());
	}
	
	/**
	 * Creates a new todo item record for the given list.
	 * @param list
	 * @param content
	 * @param dueAt
	 * @param responsibleParty
	 * @param notify
	 */
	public void createItem(TodoList list, String content, Date dueAt, Person responsiblePerson, boolean notify) {
		URLBuilder url = new URLBuilder(host, "/todo_lists/" + list.getId() + "/todo_items.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<request>");
		sb.append("<todo-item>");
		sb.append("<content>").append(content).append("</content>");
		sb.append("<due-at>").append(IsoDateTimeFormat.formatDate(dueAt)).append("</due-at>");
		sb.append("<responsible-party>").append(responsiblePerson.getId()).append("</responsible-party>");
		sb.append("<notify>").append(notify).append("</notify>");
		sb.append("</todo-item>");
		sb.append("</request>");
		
		httpConnection.doPost(url.toURL(), sb.toString());
	}
	
	/**
	 * Creates a new todo item record for the given list.
	 * @param list
	 * @param content
	 * @param dueAt
	 * @param responsibleParty
	 * @param notify
	 */
	public void createItem(TodoList list, String content, Date dueAt, Company responsibleCompany, boolean notify) {
		URLBuilder url = new URLBuilder(host, "/todo_lists/" + list.getId() + "/todo_items.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<request>");
		sb.append("<todo-item>");
		sb.append("<content>").append(content).append("</content>");
		sb.append("<due-at>").append(IsoDateTimeFormat.formatDate(dueAt)).append("</due-at>");
		sb.append("<responsible-party>").append("c").append(responsibleCompany.getId()).append("</responsible-party>");
		sb.append("<notify>").append(notify).append("</notify>");
		sb.append("</todo-item>");
		sb.append("</request>");
		
		httpConnection.doPost(url.toURL(), sb.toString());
	}
	
	/**
	 * Destroys the given todo item record.
	 * @param item
	 */
	public void destroyItem(TodoItem item) {
		URLBuilder url = new URLBuilder(host, "/todo_items/" + item.getId() + ".xml");
		httpConnection.doDelete(url.toURL());
	}
	
}
