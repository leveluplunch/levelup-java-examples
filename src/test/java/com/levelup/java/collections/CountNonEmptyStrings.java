package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate counting
 * non empty strings in a collection.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/count-non-empty-strings-in-collection-arraylist/'>Count non empty strings</a>
 */
public class CountNonEmptyStrings {
	
	@Test
	public void count_non_empty_strings_java () {
		
		List<String> valentineSayings = new ArrayList<String>();
		valentineSayings.add("crush");
		valentineSayings.add("");
		valentineSayings.add("blind date");
		valentineSayings.add("puppy luv");
		valentineSayings.add("mr right");
		valentineSayings.add("");
		valentineSayings.add("first kiss");
		valentineSayings.add("4 ever yours");
		
		List<String> string = new ArrayList<String>();
		string.add("");
		
		valentineSayings.removeAll(string); 

		assertEquals(6, valentineSayings.size());
	}
	
	@Test
	public void count_non_empty_strings_java_8 () {

		List<String> valentineSayings = new ArrayList<>();
		valentineSayings.add("crush");
		valentineSayings.add("");
		valentineSayings.add("blind date");
		valentineSayings.add("puppy luv");
		valentineSayings.add("mr right");
		valentineSayings.add("");
		valentineSayings.add("first kiss");
		valentineSayings.add("4 ever yours");
		
		long count = valentineSayings.stream().filter(x -> !x.isEmpty()).count();
		
		assertEquals(6, count);
	}

	@Test
	public void count_non_empty_strings_guava () {
		
		List<String> valentineSayings = Lists.newArrayList(
				"crush", 
				"", 
				"blind date", 
				"puppy luv", 
				"mr right", 
				"", 
				"first kiss", 
				"4 ever yours");
		
		int count = FluentIterable.from(valentineSayings).filter(new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return !input.isEmpty();
			}
		}).size();
		
		assertEquals(6, count);		
	}

		
}
