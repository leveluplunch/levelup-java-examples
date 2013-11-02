package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate finding 
 * the first non null object in a list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'>Find first non null</a>
 * 
 */
public class FindFirstNonNull {

	@Test
	public void find_first_non_null_list_java () {

		List<String> strings = new ArrayList<String>();
		strings.add(null);
		strings.add("Hello");
		strings.add(null);
		strings.add("World");

		String firstNonNull = null;
		for (String string : strings) {
			if (string != null) {
				firstNonNull = string;
				break;
			}
		}

		assertEquals("Hello", firstNonNull);
	}

	@Test
	public void find_first_non_null_list_guava () {

		List<String> strings = Lists.newArrayList(
				null, 
				"Hello",
				null,
				"World");
		
		String firstNonNull = Iterables.find(strings, Predicates.notNull());
		
		assertEquals("Hello", firstNonNull);
	}
	
	@Test
	public void find_first_non_null_list_apache () {
		
		List<String> strings = new ArrayList<String>();
		strings.add(null);
		strings.add("Hello");
		strings.add(null);
		strings.add("World");
		
		String firstNonNull = (String) ObjectUtils.firstNonNull(strings.toArray());
		
		assertEquals("Hello", firstNonNull);
	}
	
}
