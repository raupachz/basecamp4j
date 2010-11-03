package org.basecamp4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		throw new RuntimeException(e);
	}

}
