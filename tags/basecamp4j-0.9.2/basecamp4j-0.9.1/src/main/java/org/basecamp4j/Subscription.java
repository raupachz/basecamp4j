package org.basecamp4j;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

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
public class Subscription implements Serializable {
	
	private String writeboards;
	private Boolean ssl;
	private Boolean timeTracking;
	private String name;
	private Integer projects;
	private Long storage;
	
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
