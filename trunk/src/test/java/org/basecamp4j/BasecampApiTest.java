package org.basecamp4j;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BasecampApiTest {
	
	public static final String yourBasecampUrl = "https://acme.basecamphq.com"; // enter your domain
	public static final String yourApiToken = "12345"; // enter your token
	public static final String yourUsername = "username"; // enter your username
	public static final String yourPassword = "password"; // enter your password
	
	private BasecampApi api;
	
	@Before
	public void setUp() {
		try {
			api = new BasecampApi(new URL(yourBasecampUrl) , yourUsername, yourPassword);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
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
		Project project = api.getProject(4018799L);
		List<Person> people = api.getPeople(project);
		for (Person p : people) {
			System.out.println(p);
		}
	}
	
}
