package org.basecamp4j;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.jdom.Element;

public class Subscription implements Serializable {
	
	private String writeboards;
	private Boolean ssl;
	private Boolean timeTracking;
	private String name;
	private Integer projects;
	private Long storage;
	
	public static class Builder {
		
		private final Subscription subscription;
		
		public Builder() {
			this.subscription = new Subscription();
		}
		
		public Builder(Element element) {
			this();
			name(element.getChildText("name"));
			writeboards(element.getChildText("writeboards"));
			projects(element.getChildText("projects"));
			storage(element.getChildText("storage"));
			ssl(element.getChildText("ssl"));
			timeTracking(element.getChildText("time-tracking"));
		}
		
		public Builder name(String name) {
			this.subscription.setName(name);
			return this;
		}
		
		public Builder writeboards(String writeboards) {
			this.subscription.setWriteboards(writeboards);
			return this;
		}
		
		public Builder projects(Integer projects) {
			this.subscription.setProjects(projects);
			return this;
		}
		
		public Builder projects(String projects) {
			this.subscription.setProjects(Integer.valueOf(projects));
			return this;
		}
		
		public Builder storage(Long storage) {
			this.subscription.setStorage(storage);
			return this;
		}
		
		public Builder storage(String storage) {
			this.subscription.setStorage(Long.valueOf(storage));
			return this;
		}
		
		public Builder ssl(Boolean ssl) {
			this.subscription.setSsl(ssl);
			return this;
		}
		
		public Builder ssl(String ssl) {
			this.subscription.setSsl(Boolean.valueOf(ssl));
			return this;
		}
		
		public Builder timeTracking(Boolean timeTracking) {
			this.subscription.setTimeTracking(timeTracking);
			return this;
		}
		
		public Builder timeTracking(String timeTracking) {
			this.subscription.setTimeTracking(Boolean.valueOf(timeTracking));
			return this;
		}
		
		public Subscription build() {
			return subscription;
		}
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getWriteboards() {
		return writeboards;
	}
	
	public void setWriteboards(String writeboards) {
		this.writeboards = writeboards;
	}
	
	public Integer getProjects() {
		return projects;
	}
	
	public void setProjects(Integer projects) {
		this.projects = projects;
	}
	
	public Long getStorage() {
		return storage;
	}
	
	public void setStorage(Long storage) {
		this.storage = storage;
	}
	
	public Boolean getSsl() {
		return ssl;
	}
	
	public void setSsl(Boolean ssl) {
		this.ssl = ssl;
	}
	
	public Boolean getTimeTracking() {
		return timeTracking;
	}
	
	public void setTimeTracking(Boolean timeTracking) {
		this.timeTracking = timeTracking;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("name",getName())
			.append("writeboards",getWriteboards())
			.append("projects",getProjects())
			.append("storage",getStorage())
			.append("ssl",getSsl())
			.append("timeTracking",getTimeTracking())
			.toString();
	}

}
