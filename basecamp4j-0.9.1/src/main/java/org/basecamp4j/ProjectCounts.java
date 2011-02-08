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
public class ProjectCounts implements Serializable {
	
	private Integer active;
	private Integer onHold;
	private Integer archived;
	
	public Integer getActive() {
		return active;
	}
	
	public void setActive(Integer active) {
		this.active = active;
	}
	
	public Integer getOnHold() {
		return onHold;
	}
	
	public void setOnHold(Integer onHold) {
		this.onHold = onHold;
	}
	
	public Integer getArchived() {
		return archived;
	}
	
	public void setArchived(Integer archived) {
		this.archived = archived;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
			.append("active",getActive())
			.append("onHold",getOnHold())
			.append("archived",getArchived())
			.toString();
	}

}
