package org.basecamp4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.junit.runner.Request;

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

	private final String host;
	private final DefaultHttpClient httpclient;
	private final SAXBuilder saxBuilder;

	/**
	 * @see <a href="http://developer.37signals.com/basecamp/">Basecamp API</a>
	 * @param host
	 *            your basecamp domain
	 * @param token
	 *            your authentication token
	 */
	public BasecampApi(String host, String token) {
		this.host = host;
		this.saxBuilder = new SAXBuilder();
		this.httpclient = new DefaultHttpClient();
		AuthScope authScope = new AuthScope(host, 443);
		Credentials credentials = new UsernamePasswordCredentials(token, "X");
		this.httpclient.getCredentialsProvider().setCredentials(authScope,
				credentials);
	}

	public Account getAccount() {
		Account acc = null;
		URI uri = createURI("/account.xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element account = document.getRootElement();
		acc = new AccountBuilder(account).build();
		Subscription subscription = new SubscriptionBuilder(
				account.getChild("subscription")).build();
		acc.setSubscription(subscription);
		return acc;
	}

	/**
	 * Returns a single project identified by its integer ID.
	 * 
	 * @param id project ID
	 * @return single project identified by its integer ID, or null if there is
	 *         no project with this ID.
	 */
	public Project getProject(Long id) {
		URI uri = createURI("/projects/" + id + ".xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new ProjectBuilder(root).build();
	}

	/**
	 * Returns all accessible projects. This includes active, inactive, and
	 * archived projects.
	 * 
	 * @return all accessible projects.
	 */
	public List<Project> getProjects() {
		List<Project> resultList = new ArrayList<Project>();
		URI uri = createURI("/projects.xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element projects = document.getRootElement();
		for (Iterator it = projects.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Project project = new ProjectBuilder(e).build();
			resultList.add(project);
		}
		return resultList;
	}

	/**
	 * Returns a list of all companies visible to the requesting user.
	 * 
	 * @return list of visible companies.
	 */
	public List<Company> getCompanies() {
		List<Company> resultList = new ArrayList<Company>();
		URI uri = createURI("/companies.xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Company company = new CompanyBuilder(e).build();
			resultList.add(company);
		}
		return resultList;
	}

	/**
	 * Returns a list of all companies associated with the given project.
	 * 
	 * @param project
	 * @return all companies associated with the given project, or null if there
	 *         is no company with this ID.
	 */
	public List<Company> getCompanies(Project project) {
		List<Company> resultList = new ArrayList<Company>();
		URI uri = createURI("/projects/" + project.getId() + "/companies.xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Company company = new CompanyBuilder(e).build();
			resultList.add(company);
		}
		return resultList;
	}

	/**
	 * Returns a single company identified by its integer ID.
	 * 
	 * @param id
	 *            company ID
	 * @return single company identified by its integer ID.
	 */
	public Company getCompany(Long id) {
		URI uri = createURI("/companies/" + id + ".xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new CompanyBuilder(root).build();
	}
	
	/**
	 * Returns all categories for the given project. 
	 * @param project
	 * @return all categories for the given project.
	 */
	public List<Category> getCategories(Project project) {
		List<Category> resultList = new ArrayList<Category>();
		URI uri = createURI("/projects/" + project.getId() + "/categories.xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Category category = new CategoryBuilder(e).build();
			resultList.add(category);
		}
		return resultList; 
	}
	
	/**
	 * Creates a new category of the given type for the given project.
	 * @param project
	 * @param name 
	 * @param type muste be one of "post" or "attachment"
	 */
	public void createCategory(Project project, final String name, final String type) {
		URI uri = createURI("/projects/" + project.getId() + "/categories.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<category>");
		sb.append("  <type>").append(type).append("</type>");
		sb.append("  <name>").append(name).append("</name>");
		sb.append("</category>");
		
		doPost(uri, sb.toString());
	}
	
	/**
	 * Updates an existing category.
	 * @param category
	 */
	public void updateCategory(Category category) {
		URI uri = createURI("/categories/" + category.getId() + ".xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<category>");
		sb.append("  <name>").append(category.getName()).append("</name>");
		sb.append("</category>");
		
		doPut(uri, sb.toString());
	}
	
	/**
	 * Deletes the category. Note that only categories without elements can be deleted.
	 * @param category
	 */
	public void destroyCategory(Category category) {
		URI uri = createURI("/categories/" + category.getId() + ".xml");
		doDelete(uri);
	}

	
	/**
	 * Returns a single category identified by its integer ID.
	 * @param id
	 * @return a single category identified by its integer ID.
	 */
	public Category getCategory(Long id) {
		URI uri = createURI("/categories/" + id + ".xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new CategoryBuilder(root).build();
	}

	/**
	 * Returns the currently logged in person.
	 * @return you
	 */
	public Person getCurrentPerson() {
		URI uri = createURI("/me.xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new PersonBuilder(root).build();
	}
	
	/**
	 * Returns all people visible to (and including) the requesting user.
	 * @return all people visible to (and including) the requesting user.
	 */
	public List<Person> getPeople() {
		List<Person> resultList = new ArrayList<Person>();
		URI uri = createURI("/people.xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Person person = new PersonBuilder(e).build();
			resultList.add(person);
		}
		return resultList;
	}
	
	/**
	 * Returns all people with access to the given project.
	 * @param project
	 * @return all people with access to the given project.
	 */
	public List<Person> getPeople(Project project) {
		List<Person> resultList = new ArrayList<Person>();
		URI uri = createURI("/projects/" + project.getId() + "/people.xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Person person = new PersonBuilder(e).build();
			resultList.add(person);
		}
		return resultList;
	}
	
	/**
	 * Returns all people from the given company that are visible to the requesting user.
	 * @param company
	 * @return all people from the given company that are visible to the requesting user.
	 */
	public List<Person> getPeople(Company company) {
		List<Person> resultList = new ArrayList<Person>();
		URI uri = createURI("/companies/" + company.getId() + "/people.xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Person person = new PersonBuilder(e).build();
			resultList.add(person);
		}
		return resultList;
	}
	
	/**
	 * Returns a single person identified by their integer ID.
	 * @param id 
	 * @return a single person identified by their integer ID.
	 */
	public Person getPerson(Long id) {
		URI uri = createURI("/people/" + id + ".xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new PersonBuilder(root).build();
	}

	public List<Attachment> getFiles(Project project) {
		List<Attachment> resultList = new ArrayList<Attachment>();
		URI uri = createURI("/projects/" + project.getId() + "/attachments.xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Attachment attachment = new AttachmentBuilder(e).build();
			resultList.add(attachment);
		}
		return resultList;
	}
	
	/**
	 * Returns the 25 most recent messages in the given project.
	 * @param project
	 * @return the 25 most recent messages in the given project.
	 */
	public List<Post> getMessages(Project project) {
		List<Post> resultList = new ArrayList<Post>();
		URI uri = createURI("/projects/" + project.getId() + "/posts.xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Post post = new PostBuilder(e).build();
			resultList.add(post);
		}
		return resultList;
	}
	
	/**
	 * Returns a single message record identified by its integer ID.
	 * @param id
	 * @return a single message record identified by its integer ID.
	 */
	public Post getMessage(Long id) {
		URI uri = createURI("/posts/" + id + ".xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new PostBuilder(root).build();
	}
	
	/**
	 * Returns the most 25 most recent messages in the given project for the given category.
	 * @param project
	 * @param category
	 * @return the most 25 most recent messages in the given project for the given category.
	 */
	public List<Post> getMessages(Project project, Category category) {
		List<Post> resultList = new ArrayList<Post>();
		URI uri = createURI("/projects/" + project.getId() + "/cat/" + category.getId()  + "/posts.xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Post post = new PostBuilder(e).build();
			resultList.add(post);
		}
		return resultList;
	}
	
	public void editMessage(Post post) {
		
	}
	
	public void createMessage(Project project, String title, String body) {
		URI uri = createURI("/projects/" + project.getId() + "/posts.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<request>");
		sb.append("<post>");
		sb.append("  <title>").append(title).append("</title>");
		sb.append("  <body>").append(body).append("</body>");
		sb.append("</post>");
		sb.append("</request>");
		
		doPost(uri, sb.toString());
	}
	
	/**
	 * Destroys the given message and all of its associated comments.
	 * @param post
	 */
	public void destroyMessage(Post post) {
		URI uri = createURI("/posts/" + post.getId() + ".xml");
		doDelete(uri);
	}
	
	/**
	 * Return a list of the 50 most recent comments associated with the specified resource.
	 */
	public List<Comment> getComments(Resource resource, Long resourceId) {
		List<Comment> resultList = new ArrayList<Comment>();
		URI uri = createURI("/" + resource  +  "/" + resourceId + "/comments.xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Comment comment = new CommentBuilder(e).build();
			resultList.add(comment);
		}
		return resultList;
	}
	
	/**
	 * Retrieve a specific comment by its id.
	 */
	public Comment getComment(Long id) {
		URI uri = createURI("/comments/" + id + ".xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new CommentBuilder(root).build();
	}
	
	/**
	 * Create a new comment, associating it with a specific resource.
	 * @param resource posts, milestones, or todo_items
	 * @param resourceId
	 * @param comment
	 */
	public void createComment(Resource resource, Long resourceId, String comment) {
		URI uri = createURI("/" + resource  +  "/" + resourceId + "/comments.xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<comment>");
		sb.append("  <body>").append(comment).append("</body>");
		sb.append("</comment>");
		
		doPost(uri, sb.toString());
	}
	
	/**
	 * Delete the comment with the given ID.
	 * @param comment
	 */
	public void destroyComment(Comment comment) {
		URI uri = createURI("/comments/" + comment.getId() + ".xml");
		doDelete(uri);
	}
	
	/**
	 * This lets you query the list of milestones for a project. 
	 * You can either return all milestones, or only those that 
	 * are late, completed, or upcoming.
	 * @param project
	 * @return
	 */
	public List<Milestone> getMilestones(Project project) {
		List<Milestone> resultList = new ArrayList<Milestone>();
		URI uri = createURI("/projects/" + project.getId() + "/milestones/list.xml");
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Milestone milestone = new MilestoneBuilder(e).build();
			resultList.add(milestone);
		}
		return resultList;
	}
	
	/**
	 * Marks the specified milestone as complete.
	 * @param milestone
	 * @return
	 */
	public Milestone completeMilestone(Milestone milestone) {
		URI uri = createURI("/milestones/complete/" + milestone.getId());
		InputStream httpStream = doGet(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new MilestoneBuilder(root).build();
	}
	
	/**
	 * Shut down connection and release allocated system resources. Be sure to call
	 * this method when you are done using the API.
	 */
	public void dispose() {
		if (httpclient != null) {
			httpclient.getConnectionManager().shutdown();
		}
	}
	
	// -- Http helper methods
	
	private URI createURI(String path) {
		URI uri = null;
		try {
			uri = URIUtils.createURI("https", host, -1, path, null, null);
		} catch (URISyntaxException e) {
			onCaughtException(e);
		}
		return uri;
	}

	private InputStream doGet(URI uri) {
		HttpGet httpget = new HttpGet(uri);
		return doMethod(httpget);
	}
	
	private void doPost(URI uri, String request) {
		try {
			StringEntity entity = new StringEntity(request, "UTF-8");
			HttpPost httppost = new HttpPost(uri);
			httppost.addHeader("Accept", "application/xml");
			httppost.addHeader("Content-Type", "application/xml");
			httppost.setEntity(entity);
			doMethod(httppost);
		} catch (UnsupportedEncodingException ignore) {}
	}
	
	private void doPut(URI uri, String request) {
		try {
			StringEntity entity = new StringEntity(request, "UTF-8");
			HttpPut httpput = new HttpPut(uri);
			httpput.addHeader("Accept", "application/xml");
			httpput.addHeader("Content-Type", "application/xml");
			httpput.setEntity(entity);
			doMethod(httpput);
		} catch (UnsupportedEncodingException ignore) {}
	}
	
	private void doDelete(URI uri) {
		HttpDelete httpdelete = new HttpDelete(uri);
		doMethod(httpdelete);
	}
	
	private InputStream doMethod(HttpUriRequest request) {
		InputStream httpStream = null;
		try {
			HttpResponse response = httpclient.execute(request);
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() != HttpStatus.SC_OK 
					&& statusLine.getStatusCode() != HttpStatus.SC_CREATED) {
				raiseIllegalState(statusLine.getStatusCode() + " - " + statusLine.getReasonPhrase());
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				httpStream  = entity.getContent();
			}
		} catch (IOException e) {
			onCaughtException(e);
		}
		return httpStream;
	}
	
	// -- Exception handling
	
	private void onCaughtException(Exception e) {
		throw new RuntimeException(e);
	}
	
	private void raiseIllegalState(String reason) {
		throw new IllegalStateException(reason);
	}
	
	// -- JDOM helper method
	
	private Document buildDocument(InputStream in) {
		Document document = null;
		try {
			document = saxBuilder.build(in);
		} catch (Exception e) {
			onCaughtException(e);
		}
		return document;
	}
	
}
