package org.basecamp4j;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class BasecampApiTest {
	
	public static String host;
	public static String token;
	public static long projectId;
	
	private BasecampApi api;
	
	@BeforeClass
	public static void loadAuthenticationProperties() throws FileNotFoundException, IOException {
		ClassLoader classLoader = BasecampApiTest.class.getClassLoader();
		InputStream in = classLoader.getResourceAsStream("org/basecamp4j/authentication.properties");
		Properties authenticationProperties = new Properties();
		authenticationProperties.load(in);
		host = authenticationProperties.getProperty("host");
		token = authenticationProperties.getProperty("token");
		projectId = Long.valueOf(authenticationProperties.getProperty("project-id"));
	}
	
	@Before
	public void setUp() throws IOException {
		api = new BasecampApi(host , token);
	}
	
	@After
	public void tearDown() {
		api.dispose();
	}
	
	@Test
	public void testGetAccount() {
		Account account = api.getAccount();
		assertNotNull(account);
	}
	
	@Test
	public void testGetProjects() {
		List<Project> projects = api.getProjects();
		assertNotNull(projects);
	}
	
	@Test
	public void testGetCurrentPerson() {
		Person person = api.getCurrentPerson();
		assertNotNull(person);
	}
	
	@Test
	public void testGetPeople() {
		List<Person> people = api.getPeople();
		assertNotNull(people);
	}
	
	@Test
	public void testGetPeopleOfProject() {
		Project project = api.getProject(projectId);
		List<Person> people = api.getPeople(project);
		assertNotNull(people);
	}
	
	@Test @Ignore
	public void testGetCategory() {
		Long id = 1L;
		Category category = api.getCategory(id);
		assertNotNull(category);
	}
	
	@Test @Ignore
	public void testUpdateCategory() {
		Long id = 1L;
		Category category = api.getCategory(id);
		System.out.println(category);
		category.setName("Muahhaha");
		api.updateCategory(category);
	}
	
	@Test @Ignore
	public void testDeleteCategory() {
		Long id = 1L;
		Category category = api.getCategory(id);
		System.out.println(category);
		api.destroyCategory(category);
	}
	
	@Test
	public void testGetCategoriesOfProject() {
		Project project = api.getProject(projectId);
		List<Category> categories = api.getCategories(project);
		assertNotNull(categories);
	}
	
	@Test @Ignore
	public void testCreateCategory() {
		Project project = api.getProject(1L);
		api.createCategory(project, "Testkategorie", "post");
	}
	
	@Test
	public void testCreateMessge() {
		Project project = api.getProject(projectId);
		api.createMessage(project, "Test " + new Date().toString(), "Test " + new Date().toString());
	}
	
	@Test @Ignore
	public void testGetRecentComments() {
		List<Comment> comments = api.getComments(Resource.posts, 38637044L);
		for (Comment c : comments) {
			System.out.println(c);
		}
	}
	
	@Test @Ignore
	public void testCreateComment() {
		String comment = "Kommentar über API";
		api.createComment(Resource.posts, 38637044L, comment);
	}
	
	@Test
	public void testGetMilestones() {
		Project project = api.getProject(projectId);
		List<Milestone> milestones = api.getMilestones(project);
		assertNotNull(milestones);
	}
	
	@Test
	public void testGetTodoLists() {
		List<TodoList> todos = api.getTodoLists();
		assertNotNull(todos);
	}
	
	@Test
	public void testGetTodoListsByProject() {
		Project project = api.getProject(projectId);
		List<TodoList> todos = api.getTodoLists(project);
		assertNotNull(todos);
	}
	
	
	
}
