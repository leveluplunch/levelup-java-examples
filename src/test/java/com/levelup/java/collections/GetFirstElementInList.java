package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate getting the first element 
 * in list with straight up java and google guava.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/get-first-element-in-list/'>First element in list</a>
 * 
 */
public class GetFirstElementInList {
	
	@Test
	public void get_first_element_in_list_with_java () {
		
		List<String> strings = new ArrayList<String>();
		strings.add("one");
		strings.add("two");
		strings.add("three");
		
		String firstElement = null;
		if (!strings.isEmpty() && strings.size() > 0) {
			firstElement = strings.get(0);
		}

		assertEquals("one", firstElement);
	}
	
	
	@Test
	public void get_first_element_in_list_with_guava () {
		List<String> strings = Lists.newArrayList("one", "two", "three");
		
		String firstElement = Iterables.getFirst(strings, null);
		
		assertEquals("one", firstElement);
	}
	
	@Test
	public void get_first_element_in_list_with_apachecommons () {
		List<String> strings = Lists.newArrayList("one", "two", "three");

		String firstElement = (String) CollectionUtils.get(strings, 0);

		assertEquals("one", firstElement);
	}
	
	

}
