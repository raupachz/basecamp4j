Project Description
-------------------
basecamp4j is a Java wrapper library for the Basecamp REST API. With basecamp4j you no longer need to work with HTTP and XML to access your projects. The library takes care of mapping XML to POJOs. 

Please keep in mind basecamp4j is an unofficial library and everything is still in a very early stage. I started working on basecamp4j because I wanted to connect Basecamp to a Third-Party Application. The roadmap of the project is mostly driven by needed features, e.g. I don't use time-tracking so there isn't much done in this direction. In case you really need a feature just drop me an email. We figure something out.

Quick Start
===========
You need a API token before you can work with your data. Your API token can be found by logging into your Basecamp account, clicking on the "My Info" link in the upper-right, and then clicking the "Show your tokens" at the bottom (under "Authentication tokens").

First we need an instance of the class BasecampApi:
    BasecampApi = new BasecampApi(<your domain> , <your token>);

Lets get all the projects:
    List<Project>projects =  api.getProjects();
    
Getting all messages of a specific project:
    List<Post> messages = api.getMessages(project);

Some facts about you:
    Person me = api.getCurrentPerson();

Lets create a new category in a given project:
    api.createCategory(project, "foo", "post");

How to use basecamp4j with Maven
================================
Just add the following to your pom.xml.
```
<dependency>
    <groupId>org.basecamp4j</groupId>
    <artifactId>basecamp4j</artifactId>
    <version>0.9.3</version>
</dependency>
```

You can also use the snapshot repository.
```
<repository>
    <id>basecamp4j-snapshot</id>
    <name>basecamp4j Snapshot Repository</name>
    <url>https://oss.sonatype.org/content/repositories/snapshots</url>
</repository>
```

Additional Notes
================
Objects of the class BasecampApi are not thread safe. You need to synchronize access to the methods yourself or use the object in a narrow scope e.g. request scope in a web container.
This project was automatically exported from code.google.com/p/basecamp4j. 
