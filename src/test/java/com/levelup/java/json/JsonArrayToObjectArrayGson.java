package com.levelup.java.json;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This java example will demonstrate converting json to java arraylist using
 * gson .
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-json-array-to-arraylist-gson/'>Json array to ArrayList gson</a>
 */
public class JsonArrayToObjectArrayGson {

	private static final Logger logger = Logger
			.getLogger(JsontoJavaObject.class);

	String jsonString = "[ { \"key\":\"Level up lunch\", \"url\":\"www.leveluplunch.com\" }, { \"key\":\"Java examples\", \"url\":\"www.leveluplunch.com/java/examples/\" }, { \"key\":\"Java exercises\", \"url\":\"www.leveluplunch.com/java/exercises/\" }, { \"key\":\"Java tutorials\", \"url\":\"www.leveluplunch.com/java/tutorials/\" }]";

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
	public void convert_list_to_json() {

		NavItem item1 = new NavItem();
		item1.setKey("examples");
		item1.setUrl("http://leveluplunch.com/java/examples");

		NavItem item2 = new NavItem();
		item2.setKey("exercises");
		item2.setUrl("http://leveluplunch.com/java/exercises");

		List<NavItem> navigation = Lists.newArrayList(item1, item2);

		Gson gson = new GsonBuilder()
		// .setPrettyPrinting()
				.create();

		String arrayListToJson = gson.toJson(navigation);

		logger.info(arrayListToJson);

		assertEquals(
				"[{\"key\":\"examples\",\"url\":\"http://leveluplunch.com/java/examples\"},"
						+ "{\"key\":\"exercises\",\"url\":\"http://leveluplunch.com/java/exercises\"}]",
				arrayListToJson);

	}

	@Test
	public void convert_json_to_array_or_list() {

		Gson gson = new Gson();

		NavItem[] navigationArray = gson.fromJson(jsonString, NavItem[].class);

		logger.info(navigationArray);

		assertEquals(4, navigationArray.length);

		// or

		@SuppressWarnings("serial")
		Type collectionType = new TypeToken<List<NavItem>>() {
		}.getType();
		List<NavItem> navigation = gson.fromJson(jsonString, collectionType);

		logger.info(navigation);

		assertEquals(4, navigation.size());
	}

}
