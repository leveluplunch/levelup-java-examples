package com.levelup.java.util.stream;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate how to convert a stream to a map.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com//'></a>
 */
public class ConvertStreamToMap {

	class Item {

		String key;

		public Item(String key) {
			super();
			this.key = key;
		}

		public String getKey() {
			return key;
		}
	}
	
	List<Item> items;
	
	@Before
	public void setUp () {
		
		items = new ArrayList<>();
		
		items.add(new Item("ONE"));
		items.add(new Item("TWO"));
		items.add(new Item("THREE"));
	}
	
	@Test
	public void stream_to_map() {

		Map<String, Item> map = items.stream().collect(
				Collectors.toMap(Item::getKey, item -> item));
		
		assertTrue(map.keySet().size() == 3);
	}
	
	
	
}
