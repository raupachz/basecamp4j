package org.basecamp4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
abstract class AbstractResourceBuilder<T> {
	
	private final SimpleDateFormat isodate;
	private final SimpleDateFormat isodatetime;
	
	public abstract T build();
	
	public AbstractResourceBuilder() {
		isodate = new SimpleDateFormat("yyyy-MM-dd");
		isodatetime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	}
	
	protected Date parseISODate(String source) {
		Date date = null;
		try {
			date = isodate.parse(source);
		} catch (ParseException e) {
			onCaughtException(e);
		}
		return date;
	}

	protected String formatISODate(Date date) {
		return isodate.format(date);
	}

	protected Date parseISODateTime(String source) {
		Date date = null;
		try {
			date = isodatetime.parse(source);
		} catch (ParseException e) {
			onCaughtException(e);
		}
		return date;
	}

	protected String formatISODateTime(Date date) {
		return isodatetime.format(date);
	}
	
	protected void onCaughtException(Exception e) {
		throw new IllegalStateException(e);
	}

}
