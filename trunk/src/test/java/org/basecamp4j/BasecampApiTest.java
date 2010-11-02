package org.basecamp4j;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BasecampApiTest {
	
	public static final String yourBasecampUrl = "yourdomain.basecamphq.com"; // enter your domain
	public static final String yourApiToken = "x"; // enter your token
	
	private BasecampApi api;
	
	@Before
	public void setUp() {
		api = new BasecampApi(yourBasecampUrl , yourApiToken);
	}
	
	@After
	public void tearDown() {
		api.dispose();
		api = null;
	}
	
	@Test @Ignore
	public void testGetAccount() {
		api.getAccount();
	}
	
	@Test @Ignore
	public void testGetProjects() {
		api.getProjects();
	}
	
	@Test @Ignore
	public void testGetCurrentPerson() {
		api.getCurrentPerson();
	}
	
	@Test @Ignore
	public void testGetPeople() {
		api.getPeople();
	}
	
	@Test @Ignore
	public void testGetPeopleOfProject() {
		Long projectId = 1L;
		Project project = api.getProject(projectId);
		List<Person> people = api.getPeople(project);
		for (Person p : people) {
			System.out.println(p);
		}
	}
	
	@Test @Ignore
	public void testGetCategory() {
		Long id = 1L;
		Category category = api.getCategory(id);
		System.out.println(category);
		
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
		api.deleteCategory(category);
	}
	
	@Test @Ignore
	public void testGetCategoriesOfProject() {
		Project project = api.getProject(1L);
		List<Category> categories = api.getCategories(project);
		for (Category category : categories) {
			System.out.println(category);
		}
	}
	
	@Test @Ignore
	public void testCreateCategory() {
		Project project = api.getProject(1L);
		api.createCategory(project, "Testkategorie", "post");
	}
	
}
