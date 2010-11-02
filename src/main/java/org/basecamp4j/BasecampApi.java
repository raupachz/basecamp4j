package org.basecamp4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class BasecampApi {

	final static SimpleDateFormat isodate = new SimpleDateFormat("yyyy-MM-dd");
	final static SimpleDateFormat isodatetime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	final static byte[] buffer = new byte[4096];

	private URL url;
	private String token;
	private final DefaultHttpClient httpclient;
	private final SAXBuilder saxBuilder;

	/**
	 * @see <a href="http://developer.37signals.com/basecamp/">Basecamp API</a>
	 *      You can't use the helper methods.
	 * @param url
	 *            your basecamp domain
	 * @param token
	 *            your authentication token
	 */
	public BasecampApi(URL url, String token) {
		this.url = url;
		this.token = token;
		this.saxBuilder = new SAXBuilder();
		this.httpclient = new DefaultHttpClient();
		AuthScope authScope = new AuthScope(url.getHost(), 443);
		Credentials credentials = new UsernamePasswordCredentials(token, "X");
		this.httpclient.getCredentialsProvider().setCredentials(authScope,
				credentials);
	}

	public BasecampApi(URL url, String username, String password) {
		this.url = url;
		this.saxBuilder = new SAXBuilder();
		this.httpclient = new DefaultHttpClient();
		this.token = new WebScraper(httpclient, url, username, password)
				.scrapeToken();
		AuthScope authScope = new AuthScope(url.getHost(), 443);
		Credentials credentials = new UsernamePasswordCredentials(token, "X");
		this.httpclient.getCredentialsProvider().setCredentials(authScope,
				credentials);
	}

	public String getToken() {
		return token;
	}

	public URL getURL() {
		return url;
	}

	public Account getAccount() {
		Account acc = null;
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/account.xml");
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
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/projects/" + id + ".xml");
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
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/projects.xml");
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
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/companies.xml");
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
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/projects/" + project.getId() + "/companies.xml");
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
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/companies/" + id + ".xml");
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		company = new Company.Builder(root).build();
		return company;
	}

	
	/**
	 * Returns a single category identified by its integer ID.
	 * @param id
	 * @return a single category identified by its integer ID.
	 */
	public Category getCategory(Long id) {
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/categories/" + id + ".xml");
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new Category.Builder(root).build();
	}

	/**
	 * Returns the currently logged in person.
	 * @return you
	 */
	public Person getCurrentPerson() {
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/me.xml");
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
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/people.xml");
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
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/projects/" + project.getId() + "/people.xml");
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
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/companies/" + company.getId() + "/people.xml");
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
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/people/" + id + ".xml");
		Document document = buildDocument(httpStream);
		Element root = document.getRootElement();
		return new Person.Builder(root).build();
	}

	public List<Attachment> getFiles(Project project) {
		List<Attachment> resultList = new ArrayList<Attachment>();
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/projects/" + project.getId() + "/attachments.xml");
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
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/projects/" + project.getId() + "/posts.xml");
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
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/posts/" + id + ".xml");
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
		InputStream httpStream = getHttpInputStream(getURL().toString()
				+ "/projects/" + project.getId() + "/cat/" + category.getId()  + "/posts.xml");
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

	private InputStream getHttpInputStream(String uri) {
		try {
			HttpGet httpget = new HttpGet(uri);
			HttpResponse response = httpclient.execute(httpget);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
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

	public void downloadFilesToDirectory(File directory, Project project) {
		for (Attachment attach : getFiles(project)) {
			downloadFileToDirectory(directory, attach);
		}
	}

	public void downloadFileToDirectory(File directory, Attachment attachment) {
		InputStream in = null;
		OutputStream out = null;
		try {
			File dest = new File(directory, attachment.getName());
			in = getHttpInputStream(attachment.getDownloadUrl().toString());
			out = new FileOutputStream(dest, false);
			copy(in, out);
		} catch (IOException e) {
			throw new BasecampApiException(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ignore) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException ignore) {
				}
			}
		}
	}

	private static void copy(InputStream in, OutputStream out) {
		try {
			int len = 0;
			while ((len = in.read(buffer)) >= 0) {
				out.write(buffer, 0, len);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
