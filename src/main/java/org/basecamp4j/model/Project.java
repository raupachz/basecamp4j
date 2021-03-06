package org.basecamp4j.model;

import java.io.Serializable;
import java.util.Date;

import org.basecamp4j.utils.ToStringBuilder;

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
public class Project implements Serializable {
	
	private static final long serialVersionUID = 3566481067977477036L;
	
	private Long id;
	private String name;
	private Date createdOn;
	private String status;
	private Company company;
	private Date lastChangedOn;
	private String announcement;
	private String startPage;
	private Boolean showWriteboards;
	private Boolean showAnnouncement;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public Date getLastChangedOn() {
		return lastChangedOn;
	}
	
	public void setLastChangedOn(Date lastChangedOn) {
		this.lastChangedOn = lastChangedOn;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public String getStartPage() {
		return startPage;
	}

	public void setStartPage(String startPage) {
		this.startPage = startPage;
	}

	public Boolean getShowWriteboards() {
		return showWriteboards;
	}

	public void setShowWriteboards(Boolean showWriteboards) {
		this.showWriteboards = showWriteboards;
	}

	public Boolean getShowAnnouncement() {
		return showAnnouncement;
	}

	public void setShowAnnouncement(Boolean showAnnouncement) {
		this.showAnnouncement = showAnnouncement;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
					.append("id", getId())
					.append("name", getName())
					.append("createdOn", getCreatedOn())
					.append("lastChangedOn", getLastChangedOn())
					.append("status",getStatus())
					.toString();
	}

}
