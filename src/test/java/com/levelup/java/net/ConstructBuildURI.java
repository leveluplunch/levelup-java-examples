package com.levelup.java.net;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * This java example will demonstrate constructing a URI
 * using java, apache and spring framework.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/construct-build-uri/'>Construct or Build URI</a>
 */
public class ConstructBuildURI {
	
	@Test
	public void construct_uri_jersey () {
		          
		UriBuilder builder = UriBuilder
				.fromPath("www.leveluplunch.com")
				.scheme("http")
				.path("java/examples/");
		
		URI uri = builder.build();
		
		assertEquals(
				"http:/www.leveluplunch.com/java/examples/", 
				uri.toString());
	}
	
	@Test
	public void construct_uri_encoded_jersey () {
	
		UriBuilder builder = UriBuilder
				.fromPath("www.leveluplunch.com")
				.scheme("http")
				.path("java/examples/?sample=uri encode");
		
		URI uri = builder.build();
		
		assertEquals(
				"http:/www.leveluplunch.com/java/examples/%3Fsample=uri%20encode", 
				uri.toString());
	}
	
	@Test
	public void construct_uri_template_jersey () {
		
		UriBuilder builder = UriBuilder
				.fromPath("www.leveluplunch.com")
				.path("/{lanuage}/{type}/");
		
		URI uri = builder.build("java", "examples");
		
		assertEquals(
				"www.leveluplunch.com/java/examples/", 
				uri.toString());
	}

	@Test
	public void construct_uri_parameter_jersey () {
	
		UriBuilder builder = UriBuilder
				.fromPath("www.leveluplunch.com")
				.path("/{lanuage}/{type}/")
				.queryParam("test", "a", "b");
		
		URI uri = builder.build("java", "examples");
		
		assertEquals(
				"www.leveluplunch.com/java/examples/?test=a&test=b", 
				uri.toString());
	}

	
	@Test
	public void construct_uri_guava () {
//		https://code.google.com/p/guava-libraries/issues/detail?id=1005
	}
	
	// apache
	
	@Test
	public void contruct_uri_apache () throws URISyntaxException {
		
		URIBuilder builder = new URIBuilder()
				.setScheme("http")
				.setHost("www.leveluplunch.com")
				.setPath("/java/examples/");
		
		URI uri = builder.build();
		
		assertEquals(
				"http://www.leveluplunch.com/java/examples/", 
				uri.toString());
	}
	
	@Test
	public void contruct_uri_encoded_apache () throws URISyntaxException {
		
		URIBuilder builder = new URIBuilder()
				.setScheme("http")
				.setHost("www.leveluplunch.com")
				.setPath("/java/examples/?sample=uri encode");
		
		URI uri = builder.build();
		
		assertEquals(
				"http://www.leveluplunch.com/java/examples/%3Fsample=uri%20encode", 
				uri.toString());
	}
	
	@Test
	public void contruct_uri_parameters_apache () throws URISyntaxException {
		
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	    nameValuePairs.add(new BasicNameValuePair("test","a"));
	    nameValuePairs.add(new BasicNameValuePair("test","b"));
	      
		URIBuilder builder = new URIBuilder()
				.setScheme("http")
				.setHost("www.leveluplunch.com")
				.setParameters(nameValuePairs);
		
		URI uri = builder.build();
		
		assertEquals(
				"http://www.leveluplunch.com?test=a&test=b", 
				uri.toString());
	}
	
	// spring
	
	@Test
	public void construct_uri_spring () {
		
		UriComponents uriComponents =
		        UriComponentsBuilder.newInstance()
		            .scheme("http").host("www.leveluplunch.com").path("/java/examples/")
		            .build();
		
		assertEquals("http://www.leveluplunch.com/java/examples/", uriComponents.toUriString());
	}

	@Test
	public void construct_uri_encoded_spring () {
		
		UriComponents uriComponents =
		        UriComponentsBuilder.newInstance()
		            .scheme("http").host("www.leveluplunch.com")
		            .path("/java/examples/?sample=uri encode")
		            .build()
		            .encode();
		
		assertEquals("http://www.leveluplunch.com/java/examples/%3Fsample=uri%20encode", 
				uriComponents.toUriString());
	}
	
	@Test
	public void construct_uri_template_spring () {
		
		UriComponents uriComponents =
		        UriComponentsBuilder.newInstance()
		            .scheme("http")
		            .host("www.leveluplunch.com")
		            .path("/{lanuage}/{type}/")
		            .build()
		            .expand("java", "examples")
		            .encode();
		
		assertEquals("http://www.leveluplunch.com/java/examples/", 
				uriComponents.toUriString());
	}

	
	@Test
	public void construct_uri_queryparmeter_spring () {
		
		UriComponents uriComponents =
		        UriComponentsBuilder.newInstance()
		            .scheme("http")
		            .host("www.leveluplunch.com")
		            .path("/{lanuage}/{type}/")
		            .queryParam("test", "a", "b")
		            .build()
		            .expand("java", "examples")
		            .encode();
		
		assertEquals("http://www.leveluplunch.com/java/examples/?test=a&test=b", 
				uriComponents.toUriString());
	}
	
}
