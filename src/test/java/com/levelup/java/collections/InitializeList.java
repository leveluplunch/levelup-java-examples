package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate the variety ways
 * to initialize a list
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/initialize-list/'>Initialize list</a>
 * 
 */
public class InitializeList {

	@Test
	public void initialize_list_java() {
		List<String> cheeses = new ArrayList<String>();
		cheeses.add("Munster");
		cheeses.add("Swiss");
		cheeses.add("Sharp cheddar");

		assertEquals(3, cheeses.size());
	}

	@Test
	public void initialize_list_java_with_arrays () {

		List<String> cheeses = Arrays.asList("Munster",
				"Swiss", "Sharp cheddar");
		
		assertEquals(3, cheeses.size());
	}

	@Test
	public void initialize_list_java_with_double_brace_initialziation () {
		
		@SuppressWarnings("serial")
		ArrayList<String> cheeses = new ArrayList<String>() {
			{
				add("Munster");
				add("Swiss");
				add("Sharp cheddar");
			}
		};

		assertEquals(3, cheeses.size());
	}
	
	@Test
	public void initialize_list_with_guava() {
		
		List<String> cheeses = Lists.newArrayList("Munster", "Swiss",
				"Sharp cheddar");
		
		assertEquals(3, cheeses.size());
	}

}
