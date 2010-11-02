package org.basecamp4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class BasecampApi {

	final static SimpleDateFormat isodate = new SimpleDateFormat("yyyy-MM-dd");
	final static SimpleDateFormat isodatetime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

	private final String host;
	private final DefaultHttpClient httpclient;
	private final SAXBuilder saxBuilder;

	/**
	 * @see <a href="http://developer.37signals.com/basecamp/">Basecamp API</a>
	 * @param url
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
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element account = document.getRootElement();
		acc = new Account.Builder(account).build();
		Subscription subscription = new Subscription.Builder(
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
		Project project = null;
		URI uri = createURI("/projects/" + id + ".xml");
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		project = new Project.Builder(root).build();
		return project;
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
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element projects = document.getRootElement();
		for (Iterator it = projects.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Project project = new Project.Builder(e).build();
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
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Company company = new Company.Builder(e).build();
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
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Company company = new Company.Builder(e).build();
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
		Company company = null;
		URI uri = createURI("/companies/" + id + ".xml");
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		company = new Company.Builder(root).build();
		return company;
	}
	
	/**
	 * Returns all categories for the given project. 
	 * @param project
	 * @return all categories for the given project.
	 */
	public List<Category> getCategories(Project project) {
		List<Category> resultList = new ArrayList<Category>();
		URI uri = createURI("/projects/" + project.getId() + "/categories.xml");
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Category category = new Category.Builder(e).build();
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
		
		try {
			StringEntity entity = new StringEntity(sb.toString(), "UTF-8");
			HttpPost httppost = new HttpPost(uri);
			httppost.setEntity(entity);
			httppost.addHeader("Accept", "application/xml");
			httppost.addHeader("Content-Type", "application/xml");
			HttpResponse response = httpclient.execute(httppost);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_CREATED) {
				throw new BasecampApiException(response);
			}
		} catch (IOException e) {
			throw new BasecampApiException(e);
		}
	}
	
	public void updateCategory(Category category) {
		URI uri = createURI("/categories/" + category.getId() + ".xml");
		
		StringBuilder sb = new StringBuilder();
		sb.append("<category>");
		sb.append("  <name>").append(category.getName()).append("</name>");
		sb.append("</category>");
		
		try {
			StringEntity entity = new StringEntity(sb.toString(), "UTF-8");
			HttpPut httpput = new HttpPut(uri);
			httpput.setEntity(entity);
			httpput.addHeader("Accept", "application/xml");
			httpput.addHeader("Content-Type", "application/xml");
			HttpResponse response = httpclient.execute(httpput);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new BasecampApiException(response);
			}
		} catch (IOException e) {
			throw new BasecampApiException(e);
		}
	}
	
	public void deleteCategory(Category category) {
		URI uri = createURI("/categories/" + category.getId() + ".xml");
		
		try {
			HttpDelete httpdelete = new HttpDelete(uri);
			HttpResponse response = httpclient.execute(httpdelete);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new BasecampApiException(response);
			}
		} catch (IOException e) {
			throw new BasecampApiException(e);
		}
	}

	
	/**
	 * Returns a single category identified by its integer ID.
	 * @param id
	 * @return a single category identified by its integer ID.
	 */
	public Category getCategory(Long id) {
		URI uri = createURI("/categories/" + id + ".xml");
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new Category.Builder(root).build();
	}

	/**
	 * Returns the currently logged in person.
	 * @return you
	 */
	public Person getCurrentPerson() {
		URI uri = createURI("/me.xml");
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new Person.Builder(root).build();
	}
	
	/**
	 * Returns all people visible to (and including) the requesting user.
	 * @return all people visible to (and including) the requesting user.
	 */
	public List<Person> getPeople() {
		List<Person> resultList = new ArrayList<Person>();
		URI uri = createURI("/people.xml");
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Person person = new Person.Builder(e).build();
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
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Person person = new Person.Builder(e).build();
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
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Person person = new Person.Builder(e).build();
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
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new Person.Builder(root).build();
	}

	public List<Attachment> getFiles(Project project) {
		List<Attachment> resultList = new ArrayList<Attachment>();
		URI uri = createURI("/projects/" + project.getId() + "/attachments.xml");
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Attachment attachment = new Attachment.Builder(e).build();
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
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Post post = new Post.Builder(e).build();
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
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new Post.Builder(root).build();
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
		InputStream httpStream = getHttpInputStream(uri);
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Post post = new Post.Builder(e).build();
			resultList.add(post);
		}
		return resultList;
	}
	
	public void dispose() {
		if (httpclient != null) {
			httpclient.getConnectionManager().shutdown();
		}
	}

	// -- Little Helpers
	
	private URI createURI(String path) {
		try {
			return URIUtils.createURI("https", host, -1, path, null, null);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	private InputStream getHttpInputStream(URI uri) {
		try {
			HttpGet httpget = new HttpGet(uri);
			HttpResponse response = httpclient.execute(httpget);
			if (!(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK 
					|| response.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED)) {
				throw new BasecampApiException(response);
			}
			return response.getEntity().getContent();
		} catch (IOException e) {
			throw new BasecampApiException(e);
		}
	}
	
	private Document buildDocument(InputStream in) {
		try {
			return saxBuilder.build(in);
		} catch (Exception e) {
			throw new BasecampApiException(e);
		}
	}

	public static Date parseISODate(String source) {
		try {
			return isodate.parse(source);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static String formatISODate(Date date) {
		return isodate.format(date);
	}

	public static Date parseISODateTime(String source) {
		try {
			return isodatetime.parse(source);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static String formatISODateTime(Date date) {
		return isodatetime.format(date);
	}

}