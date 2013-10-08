package com.levelup.java.jsonpath;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.jayway.jsonpath.JsonPath;


/**
 * This java example will demonstrate testing
 * json with jsonpath and junit
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/junit-test-json-with-jsonpath-hamcrest/'>Test Json</a>
 * 
 */
public class TestJsonpath {

	private static final Logger logger = Logger.getLogger(JsonPathExample.class);

	
	/**
	 * Test fields
	 */
	@Test
	public void test_json_fields () {
		
		String rawJson = "{\r\n   \"id\":1,\r\n   \"description\":\"Biodiesel XOXO pug, irony roof party Helvetica selfies vinyl...\",\r\n   \"url\":\"http://hipsteripsum.me/\"\r\n}";		
		
		String description = JsonPath.read(rawJson, "$.description");
		String url = JsonPath.read(rawJson, "$.url");
		
		logger.info(description);		
		
		assertEquals("Biodiesel XOXO pug, irony roof party Helvetica selfies vinyl...", description);
		assertThat(url, containsString("http://"));
	}
	
	/**
	 * Validate size of json array
	 */
	@Test
	public void test_json_array_size () {
		
		String rawJson = "{\r\n   \"labels\":[\r\n      {\r\n         \"url\":\"https://api.github.com/...\",\r\n         \"name\":\"enhancement\",\r\n         \"color\":\"84b6eb\"\r\n      },\r\n      {\r\n         \"url\":\"https://api.github.com/...\",\r\n         \"name\":\"bug\",\r\n         \"color\":\"84b6eb\"\r\n      },\r\n      {\r\n         \"url\":\"https://api.github.com/...\",\r\n         \"name\":\"Technical\",\r\n         \"color\":\"84b6eb\"\r\n      },\r\n      {\r\n         \"url\":\"https://api.github.com/...\",\r\n         \"name\":\"User Story\",\r\n         \"color\":\"84b6eb\"\r\n      }\r\n   ]\r\n}";
		
		List<Object> labels = JsonPath.read(rawJson, "$.labels");
		
		logger.info(labels);		
		
		assertThat(labels, hasSize(4));
	}

	/**
	 * Test each url in array starts with http OR https
	 */
	@Test
	public void test_json_array_elements_start_with () {

		String rawJson = "{\r\n   \"labels\":[\r\n      {\r\n         \"url\":\"https://api.github.com/...\",\r\n         \"name\":\"enhancement\",\r\n         \"color\":\"84b6eb\"\r\n      },\r\n      {\r\n         \"url\":\"http://api.github.com/...\",\r\n         \"name\":\"bug\",\r\n         \"color\":\"84b6eb\"\r\n      },\r\n      {\r\n         \"url\":\"https://api.github.com/...\",\r\n         \"name\":\"Technical\",\r\n         \"color\":\"84b6eb\"\r\n      },\r\n      {\r\n         \"url\":\"http://api.github.com/...\",\r\n         \"name\":\"User Story\",\r\n         \"color\":\"84b6eb\"\r\n      }\r\n   ]\r\n}";

		List<Object> urls = JsonPath.read(rawJson, "$.labels[*].url");

		logger.info(urls);		

		assertThat(urls, hasItem(
				anyOf(startsWith("https://"), 
						startsWith("http://"))));
	}
	
}
