package org.basecamp4j;

import org.jdom.Element;

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
class ProjectCountsBuilder extends AbstractResourceBuilder<ProjectCounts>{
	
	private final ProjectCounts projectCounts;
	
	public ProjectCountsBuilder() {
		this.projectCounts = new ProjectCounts();
	}
	
	public ProjectCountsBuilder(Element element) {
		this();
		active(element.getChildText("active"));
		onHold(element.getChildText("on-hold"));
		archived(element.getChildText("archived"));
	}
	
	public ProjectCountsBuilder active(String active) {
		return active(Integer.valueOf(active));
	}
	
	public ProjectCountsBuilder active(Integer active) {
		projectCounts.setActive(active);
		return this;
	}
	
	public ProjectCountsBuilder onHold(String onHold) {
		return onHold(onHold);
	}
	
	public ProjectCountsBuilder onHold(Integer onHold) {
		projectCounts.setOnHold(onHold);
		return this;
	}
	
	public ProjectCountsBuilder archived(String archived) {
		return archived(Integer.valueOf(archived));
	}
	
	public ProjectCountsBuilder archived(Integer archived) {
		projectCounts.setArchived(archived);
		return this;
	}

	@Override
	public ProjectCounts build() {
		return projectCounts;
	}

}
