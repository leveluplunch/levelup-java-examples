package com.levelup.java.net;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * This java example will demonstrate constructing or building
 * a URI from http servlet request.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/construct-build-uri-from-http-servlet-request/'>Construct or Build URI from request</a>
 */
public class BuildURIFromHttpRequest {

	
	@Test
	public void create_URI_from_http_request () {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		UriComponents ucb =
		        ServletUriComponentsBuilder
			        .fromContextPath(request)
			        .path("/examples/java")
			        .build();

		URI uri = ucb.toUri();
		
		assertEquals("http://localhost/examples/java", uri.toString());
	}
	
	@Test
	public void replace_query_parameter () {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setQueryString("primaryKey=987");
		
		UriComponents ucb =
		        ServletUriComponentsBuilder
			        .fromRequest(request)
			        .replaceQueryParam("primaryKey", "{id}")
		        	.build()
		            .expand("123")
		            .encode();
		
		assertEquals("http://localhost?primaryKey=123", ucb.toString());
	}

	@Test
	public void replace_path () {

		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setPathInfo("/java/examples");

		UriComponents ucb =
		        ServletUriComponentsBuilder
			        .fromRequest(request)
			        .replacePath("/java/exercises")
			        .build()
		            .encode();
		
		URI uri = ucb.toUri();
		
		assertEquals("http://localhost/java/exercises", uri.toString());
	}
}
