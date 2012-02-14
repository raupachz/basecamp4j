package org.basecamp4j;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.basecamp4j.model.Account;
import org.basecamp4j.model.Category;
import org.basecamp4j.model.Comment;
import org.basecamp4j.model.Company;
import org.basecamp4j.model.Filter;
import org.basecamp4j.model.Milestone;
import org.basecamp4j.model.Person;
import org.basecamp4j.model.Project;
import org.basecamp4j.model.ProjectCounts;
import org.basecamp4j.model.Resource;
import org.basecamp4j.model.TodoItem;
import org.basecamp4j.model.TodoList;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BasecampApiTest {
	
	public static String host = "domain.basecamphq.com";
	public static String token = "token";
	public static long projectId = 1L;
	
	private BasecampApi api;
	
	@Before
	public void setUp() throws IOException {
		api = new BasecampApi(host , token);
	}
	
	@Test @Ignore
	public void testGetAccount() {
		Account account = api.getAccount();
		assertNotNull(account);
	}
	
	@Test @Ignore
	public void testGetProjects() {
		List<Project> projects = api.getProjects();
		assertNotNull(projects);
	}
	
	@Test @Ignore
	public void testGetCurrentPerson() {
		Person person = api.getCurrentPerson();
		assertNotNull(person);
	}
	
	@Test @Ignore
	public void testGetPeople() {
		List<Person> people = api.getPeople();
		assertNotNull(people);
	}
	
	@Test @Ignore
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
		category.setName("acme");
		api.updateCategory(category);
	}
	
	@Test @Ignore
	public void testDeleteCategory() {
		Long id = 1L;
		Category category = api.getCategory(id);
		System.out.println(category);
		api.destroyCategory(category);
	}
	
	@Test @Ignore
	public void testGetCategoriesOfProject() {
		Project project = api.getProject(projectId);
		List<Category> categories = api.getCategories(project);
		assertNotNull(categories);
	}
	
	@Test @Ignore
	public void testCreateCategory() {
		Project project = api.getProject(1L);
		api.createCategory(project, "acme", "acme");
	}
	
	@Test @Ignore
	public void testCreateMessge() {
		Project project = api.getProject(projectId);
		api.createMessage(project, "Test " + new Date().toString(), "Test " + new Date().toString());
	}
	
	@Test @Ignore
	public void testGetRecentComments() {
		List<Comment> comments = api.getComments(Resource.posts, 1l);
		for (Comment c : comments) {
			System.out.println(c);
		}
	}
	
	@Test @Ignore
	public void testCreateComment() {
		String comment = "Comment about API";
		api.createComment(Resource.posts, 1l, comment);
	}
	
	@Test @Ignore
	public void testGetTodoLists() {
		List<TodoList> todos = api.getTodoLists();
		assertNotNull(todos);
	}
	
	@Test @Ignore
	public void testGetTodoListsByResponsibleParty() {
		List<TodoList> todos = api.getTodoLists("");
		assertNotNull(todos);
	}
	
	@Test @Ignore
	public void testGetTodoListsByProject() {
		Project project = api.getProject(projectId);
		List<TodoList> todos = api.getTodoLists(project);
		assertNotNull(todos);
	}
	
	@Test @Ignore
	public void testGetTodoListsByProjectByFilter() {
		Project project = api.getProject(projectId);
		List<TodoList> todos = api.getTodoLists(project, Filter.finished);
		for (TodoList list : todos) {
			System.out.println(list);
		}
	}
	
	@Test @Ignore
	public void testGetTodoList() {
		TodoList todo = api.getTodoList(1l);
		for (TodoItem item : todo.getTodoItems()) {
			System.out.println(item);
		}
		assertNotNull(todo);
	}
	
	@Test @Ignore
	public void testProjectCounts() {
		ProjectCounts counts = api.getProjectCounts();
		assertNotNull(counts);
	}
	
	@Test @Ignore
	public void testCreateProject() {
		api.createProject("My new project");
	}
	
	@Test @Ignore
	public void testGetMilestones() {
		Project project = api.getProject(projectId);
		List<Milestone> milestones = api.getMilestones(project);
		assertNotNull(milestones);
		for (Milestone m : milestones) {
			System.out.println(m);
		}
	}
	
	@Test @Ignore
	public void testCompleteAndUncompleteMilestones() {
		Project project = api.getProject(projectId);
		List<Milestone> milestones = api.getMilestones(project);
		if (milestones.size() > 0) {
			Milestone milestone = milestones.get(0);
			api.completeMilestone(milestone);
			api.uncompleteMilestone(milestone);
		}
	}
	
	@Test @Ignore
	public void testUpdateMilestone() {
		Project project = api.getProject(projectId);
		List<Milestone> milestones = api.getMilestones(project);
		if (milestones.size() > 0) {
			Milestone milestone = milestones.get(0);
			milestone.setDeadline(new Date());
			milestone.setTitle("current milestones");
			api.updateMilestone(milestone, false, false, false);
		}
	}
	
	@Test @Ignore
	public void testGetAllItems() {
		TodoList todo = api.getTodoList(1l);
		List<TodoItem> items = api.getAllItems(todo);
		for (TodoItem item : items) {
			System.out.println(item);
		}
	}
	
	@Test @Ignore
	public void testGetItem() {
		TodoItem item = api.getItem(1l);
		System.out.println(item);
	}
	
	@Test @Ignore
	public void testCompleteUncompleteItem() {
		TodoItem item = api.getItem(1l);
		api.completeItem(item);
		api.uncompleteItem(item);
	}
	
	@Test @Ignore
	public void testCreateNewTodoItem() {
		Company me = api.getCompany(1l);
		TodoList todo = api.getTodoList(1l);
		api.createItem(todo, "write something", new Date(), me, false);
	}
	
}
