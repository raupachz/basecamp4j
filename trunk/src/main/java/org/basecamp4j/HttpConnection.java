package org.basecamp4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

class HttpConnection {
	
	private final String host;
	private final String token;
	private boolean connected;
	private DefaultHttpClient httpclient;
	
	public HttpConnection(String host, String token) {
		this.host = host;
		this.token = token;
	}
	
	public HttpConnection openConnection() {
		if (isConnected()) {
			throw new IllegalStateException("HttpConnection is already open.");
		} else {
			httpclient = new DefaultHttpClient();
			AuthScope authScope = new AuthScope(host, 443);
			Credentials credentials = new UsernamePasswordCredentials(token, "X");
			httpclient.getCredentialsProvider().setCredentials(authScope, credentials);
			connected = true;
		}
		return this;
	}
	
	public boolean isConnected() {
		return connected;
	}
	
	public void close() {
		if (httpclient != null) {
			httpclient.getConnectionManager().shutdown();
			connected = false;
		}
	}
	
	public URI createURI(String path) {
		URI uri = null;
		try {
			uri = URIUtils.createURI("https", host, -1, path, null, null);
		} catch (URISyntaxException e) {
			onCaughtException(e);
		}
		return uri;
	}
	
	public InputStream doGet(URI uri) {
		HttpGet httpget = new HttpGet(uri);
		return doMethod(httpget);
	}
	
	public void doPost(URI uri, String request) {
		try {
			StringEntity entity = new StringEntity(request, "UTF-8");
			HttpPost httppost = new HttpPost(uri);
			httppost.setEntity(entity);
			doMethod(httppost);
		} catch (UnsupportedEncodingException e) {
			onCaughtException(e);
		}
	}
	
	public void doPost(URI uri) {
		HttpPost httppost = new HttpPost(uri);
		doMethod(httppost);
	}
	
	public void doPut(URI uri, String request) {
		try {
			StringEntity entity = new StringEntity(request, "UTF-8");
			HttpPut httpput = new HttpPut(uri);
			httpput.setEntity(entity);
			doMethod(httpput);
		} catch (UnsupportedEncodingException e) {
			onCaughtException(e);
		}
	}
	
	public void doPut(URI uri) {
		HttpPut httpput = new HttpPut(uri);
		doMethod(httpput);
	}
	
	public void doDelete(URI uri) {
		HttpDelete httpdelete = new HttpDelete(uri);
		doMethod(httpdelete);
	}
	
	public InputStream doMethod(HttpUriRequest request) {
		appendHttpHeader(request);
		InputStream httpStream = null;
		try {
			HttpResponse response = httpclient.execute(request);
			StatusLine statusLine = response.getStatusLine();
			if (hasInvalidStatusCode(statusLine)) {
				raiseIllegalState(statusLine);
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				httpStream  = entity.getContent();
			}
		} catch (IOException e) {
			onCaughtException(e);
		}
		return httpStream;
	}
	
	public void appendHttpHeader(HttpUriRequest request) {
		request.addHeader("Accept", "application/xml");
		request.addHeader("Content-Type", "application/xml");
	}
	
	private void onCaughtException(Exception e) {
		throw new RuntimeException(e);
	}
	
	private boolean hasInvalidStatusCode(StatusLine statusLine) {
		return statusLine.getStatusCode() != HttpStatus.SC_OK 
				&& statusLine.getStatusCode() != HttpStatus.SC_CREATED;
	}
	
	private void raiseIllegalState(StatusLine statusLine) {
		throw new IllegalStateException(statusLine.getStatusCode() + " - " + statusLine.getReasonPhrase());
	}

}