package org.basecamp4j.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.basecamp4j.model.Account;
import org.basecamp4j.model.Attachment;
import org.basecamp4j.model.Category;
import org.basecamp4j.model.Comment;
import org.basecamp4j.model.Company;
import org.basecamp4j.model.Milestone;
import org.basecamp4j.model.Person;
import org.basecamp4j.model.Post;
import org.basecamp4j.model.Project;
import org.basecamp4j.model.ProjectCounts;
import org.basecamp4j.model.Subscription;
import org.basecamp4j.model.TodoItem;
import org.basecamp4j.model.TodoList;
import org.basecamp4j.model.builder.AccountBuilder;
import org.basecamp4j.model.builder.AttachmentBuilder;
import org.basecamp4j.model.builder.CategoryBuilder;
import org.basecamp4j.model.builder.CommentBuilder;
import org.basecamp4j.model.builder.CompanyBuilder;
import org.basecamp4j.model.builder.MilestoneBuilder;
import org.basecamp4j.model.builder.PersonBuilder;
import org.basecamp4j.model.builder.PostBuilder;
import org.basecamp4j.model.builder.ProjectBuilder;
import org.basecamp4j.model.builder.ProjectCountsBuilder;
import org.basecamp4j.model.builder.SubscriptionBuilder;
import org.basecamp4j.model.builder.TodoItemBuilder;
import org.basecamp4j.model.builder.TodoListBuilder;
import org.basecamp4j.xml.DOMUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
public class ResourceFactory {
	
	public Account buildAccount(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		Account acc = new AccountBuilder(root).build();
		Subscription subscription = new SubscriptionBuilder(account.getChild("subscription")).build();
		acc.setSubscription(subscription);
		return acc;
	}

	public Project buildProject(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		return new ProjectBuilder(root).build();
	}
	
	public ProjectCounts buildProjectCounts(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		return new ProjectCountsBuilder(root).build();
	}

	public List<Project> buildProjects(InputStream httpStream) {
		List<Project> resultList = new ArrayList<Project>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		for (Iterator it = projects.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Project project = new ProjectBuilder(e).build();
			resultList.add(project);
		}
		return resultList;
	}

	public List<Company> buildCompanies(InputStream httpStream) {
		List<Company> resultList = new ArrayList<Company>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Company company = new CompanyBuilder(e).build();
			resultList.add(company);
		}
		return resultList;
	}

	public Company buildCompany(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		return new CompanyBuilder(root).build();
	}

	public List<Category> getCategories(InputStream httpStream) {
		List<Category> resultList = new ArrayList<Category>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Category category = new CategoryBuilder(e).build();
			resultList.add(category);
		}
		return resultList; 
	}

	public Category buildCategory(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		return new CategoryBuilder(root).build();
	}

	public Person buildPerson(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		return new PersonBuilder(root).build();
	}

	public List<Person> buildPeople(InputStream httpStream) {
		List<Person> resultList = new ArrayList<Person>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Person person = new PersonBuilder(e).build();
			resultList.add(person);
		}
		return resultList;
	}

	public List<Attachment> buildAttachments(InputStream httpStream) {
		List<Attachment> resultList = new ArrayList<Attachment>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Attachment attachment = new AttachmentBuilder(e).build();
			resultList.add(attachment);
		}
		return resultList;
	}

	public List<Post> buildPosts(InputStream httpStream) {
		List<Post> resultList = new ArrayList<Post>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Post post = new PostBuilder(e).build();
			resultList.add(post);
		}
		return resultList;
	}

	public Post buildPost(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		return new PostBuilder(root).build();
	}

	public List<Comment> buildComments(InputStream httpStream) {
		List<Comment> resultList = new ArrayList<Comment>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Comment comment = new CommentBuilder(e).build();
			resultList.add(comment);
		}
		return resultList;
	}

	public Comment buildComment(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		return new CommentBuilder(root).build();
	}

	public List<Milestone> buildMilestones(InputStream httpStream) {
		List<Milestone> resultList = new ArrayList<Milestone>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Milestone milestone = new MilestoneBuilder(e).build();
			resultList.add(milestone);
		}
		return resultList;
	}

	public Milestone buildMilestone(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		return new MilestoneBuilder(root).build();
	}
	
	public List<TodoList> buildTodoLists(InputStream httpStream) {
		return buildTodoLists(httpStream, true);
	}

	public List<TodoList> buildTodoLists(InputStream httpStream, boolean withTodoItems) {
		List<TodoList> resultList = new ArrayList<TodoList>();
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			TodoList list = new TodoListBuilder(e).build();
			if (withTodoItems) {
				for (Object obj : e.getChild("todo-items").getChildren()) {
					Element item = (Element) obj;
					list.getTodoItems().add(new TodoItemBuilder(item).build());
				}
			}
			resultList.add(list);
		}
		return resultList;
	}
	
	public TodoList buildTodoList(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		TodoList list = new TodoListBuilder(root).build();
		for (Object obj : root.getChild("todo-items").getChildren()) {
			Element item = (Element) obj;
			list.getTodoItems().add(new TodoItemBuilder(item).build());
		}
		return list;
	}

	public List<TodoItem> buildTodoItemsList(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		List<TodoItem> list = new ArrayList<TodoItem>();
		for (Iterator it = root.getChildren().iterator(); it.hasNext();) {
			Element e = (Element) it.next();
			TodoItem item = new TodoItemBuilder(e).build();
			list.add(item);
		}
		return list;
	}

	public TodoItem buildTodoItem(InputStream httpStream) {
		Document document = DOMUtils.buildDocument(httpStream);
		Element root = document.getDocumentElement();
		return new TodoItemBuilder(root).build();
	}

}
