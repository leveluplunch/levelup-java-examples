package com.levelup.java.json;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This java example will demonstrate how to convert json array to object array
 * using jackson.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-json-array-to-arraylist-of-objects-jackson/'>Json to arraylist jackson</a>
 */
public class JsonArrayToObjectArray {

	private static final Logger logger = Logger.getLogger(JsontoJavaObject.class);
	
	String jsonString = "[ { \"key\":\"Level up lunch\", \"url\":\"www.leveluplunch.com\" }, { \"key\":\"Java examples\", \"url\":\"www.leveluplunch.com/java/examples/\" }, { \"key\":\"Java exercises\", \"url\":\"www.leveluplunch.com/java/exercises/\" }, { \"key\":\"Java tutorials\", \"url\":\"www.leveluplunch.com/java/tutorials/\" }]";

	static class NavItem {

		public NavItem () {
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
			IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		List<NavItem> navigation = objectMapper.readValue(
				jsonString,
				objectMapper.getTypeFactory().constructCollectionType(
						List.class, NavItem.class));

		logger.info(navigation);

		assertEquals(4, navigation.size());
	}

}
