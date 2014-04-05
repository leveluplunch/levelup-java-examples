package com.levelup.java.json;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.google.common.collect.Multimap;

/**
 * This java example will demonstrate how to convert
 * json string to guava multimap.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-json-to-guava-multimap-with-jackson/'>Json to guava multimap</a>
 */
public class JsonToGuavaMultimap {

	private static final Logger logger = Logger
			.getLogger(JsontoJavaObject.class);

	String jsonString = "{\n \"123455\":[\n {\n \"key\":\"Java Exercises\",\n \"url\":\"www.leveluplunch.com/java/exercises/\"\n },\n {\n \"key\":\"Java Examples\",\n \"url\":\"www.leveluplunch.com/java/examples/\"\n }\n ],\n \"999999\":[\n {\n \"key\":\"Java Tutorials\",\n \"url\":\"www.leveluplunch.com/java/tutorials/\"\n },\n {\n \"key\":\"Java Examples\",\n \"url\":\"www.leveluplunch.com/java/examples/\"\n }\n ]\n}";

	static class NavItem {

		public NavItem() {
		}

		private String key;
		private String url;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		@Override
		public String toString() {
			return com.google.common.base.Objects.toStringHelper(this)
					.add("key", key).add("url", url).toString();
		}
	}

	@Test
	public void convert() throws JsonParseException, JsonMappingException,
			JsonProcessingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new GuavaModule());

		Multimap<String, NavItem> navs = objectMapper.readValue(
				objectMapper.treeAsTokens(objectMapper.readTree(jsonString)),
				objectMapper.getTypeFactory().constructMapLikeType(
						Multimap.class, String.class, NavItem.class));

		logger.info(navs);
		
	    assertThat(navs.keys(), hasItems("123455", "999999"));
	}

}
