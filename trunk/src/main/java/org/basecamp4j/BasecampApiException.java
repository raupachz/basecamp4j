package org.basecamp4j;

import org.apache.http.HttpResponse;

public class BasecampApiException extends RuntimeException {
	
	public BasecampApiException(Exception e) {
		super(e);
	}
	
	public BasecampApiException(HttpResponse response) {
		super(response.getStatusLine().getReasonPhrase());
	}
	
}
