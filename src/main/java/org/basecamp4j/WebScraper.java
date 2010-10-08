package org.basecamp4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

class WebScraper {
	
	private final DefaultHttpClient httpclient;
	private final URL url;
	private final String username;
	private final String password;
	
	public WebScraper(DefaultHttpClient httpclient, URL url, String username, String password) {
		this.httpclient = httpclient;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public String scrapeToken() {
		String token = null;
		try  {
			HttpGet httpget = new HttpGet("https://e2n.basecamphq.com/login");
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			String loginHtml = readHTML(entity);
			
			HttpPost httpost = new HttpPost("https://launchpad.37signals.com/authenticate");
	        List <NameValuePair> nvps = new ArrayList <NameValuePair>();
	        nvps.add(new BasicNameValuePair("username", username));
	        nvps.add(new BasicNameValuePair("password", password));
	        nvps.add(new BasicNameValuePair("authenticity_token", scrapeHiddenInputValue(loginHtml, "authenticity_token")));
	        nvps.add(new BasicNameValuePair("product", scrapeHiddenInputValue(loginHtml, "product")));
	        nvps.add(new BasicNameValuePair("subdomain", scrapeHiddenInputValue(loginHtml, "subdomain")));
	        httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
	        response = httpclient.execute(httpost);
	        entity = response.getEntity();
	        String loginResponseHtml = readHTML(entity);
	        
	        String redirectURL = scrapeRedirectURL(loginResponseHtml);
	        httpget = new HttpGet(redirectURL); 
	        response = httpclient.execute(httpget);
	        entity = response.getEntity();
	        String startPage = readHTML(entity);
	        
	        String myInfoURL = scrapeMyInfoURL(startPage);
	        httpget = new HttpGet(myInfoURL);
	        response = httpclient.execute(httpget);
	        entity = response.getEntity();

	        String myInfoHtml = readHTML(entity);
	        token = scrapeTokenValue(myInfoHtml);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return token;
	}
	
	private String scrapeHiddenInputValue(String html, String name) {
		int i = html.indexOf(name);
		i = html.indexOf("value=\"", i);
		i = i + "value=\"".length();
		int j = html.indexOf("\"", i);
		String value = html.substring(i, j);
		return value;
	}
	
	private String scrapeRedirectURL(String html) {
		int i = html.indexOf("href=\"");
		i = i + "href=\"".length();
		int j = html.indexOf("\"", i);
		String value = html.substring(i, j);
		return value;
	}
	
	private String scrapeMyInfoURL(String html) {
		int i = html.indexOf("href=\"/people/");
		i = i + "href=\"/people/".length();
		int j = html.indexOf("/", i);
		String value = html.substring(i, j);
		return url.toString() + "/people/" + value + "/edit";
	}
	
	private String scrapeTokenValue(String html) {
		final String str = "<input type=\"text\" readonly=\"readonly\" id=\"token\" value=\"";
		int i = html.indexOf(str);
		i = i + str.length();
		int j = html.indexOf("\"", i);
		String value = html.substring(i, j);
		return value;
	}
	
	private String readHTML(HttpEntity entity) {
		String html = null;
		ByteArrayOutputStream out = null;
		try {
			out = new ByteArrayOutputStream();
			entity.writeTo(out);
			html = new String(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return html;
	}

}
