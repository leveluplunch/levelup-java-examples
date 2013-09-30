package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate getting the last
 * element in a list with straight up java and google guava.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'>Get Last Element in List</a>
 * 
 */
public class GetLastElementInList {

	@Test
	public void get_last_element_in_list_with_java () {
		
		List<String> strings = new ArrayList<String>();
		strings.add("one");
		strings.add("two");
		strings.add("three");
		
		String lastElement = null;
		if (!strings.isEmpty() && strings.size() > 0) {
			lastElement = strings.get(strings.size() - 1);
		}
		
		// lastElement = three
		
		assertEquals("three", lastElement);
	}
	
	
	@Test
	public void get_last_element_in_list_with_guava () {
		List<String> strings = Lists.newArrayList("one", "two", "three");
		
		String lastElement = Iterables.getLast(strings, null);
		
		// lastElement = three
		
		assertEquals("three", lastElement);
	}
	
	@Test
	public void get_last_element_in_list_with_apachecommons () {

		List<String> strings = Lists.newArrayList("one", "two", "three");
		
		String lastElement = (String) CollectionUtils.get(strings, (strings.size() - 1));
		
		// lastElement = three
		
		assertEquals("three", lastElement);

	}
	
}
