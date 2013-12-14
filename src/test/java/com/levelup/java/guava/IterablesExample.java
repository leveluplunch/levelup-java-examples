package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * This java example will demonstrate common use cases 
 * for Google guava Iterables utility.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-iterables-example/'>Iterables example</a>
 */
public class IterablesExample {

	
	/**
	 * Filter by class type
	 */
	@Test
	public void filter_elements_by_type () {
		
		List<Object> randomObjects = Lists.newArrayList();
		randomObjects.add(new Integer(15));
		randomObjects.add(new Double(12));
		randomObjects.add("hello");
		randomObjects.add(Lists.newArrayList());
		randomObjects.add(Maps.newConcurrentMap());
		randomObjects.add("world");
		
		Iterable<String> strings = Iterables.filter(randomObjects, String.class);
		
		assertThat(strings, IsIterableContainingInAnyOrder.
				<String>containsInAnyOrder("hello", "world"));
	}
	
	/**
	 * Combine two iterables
	 */
	@Test
	public void concat_two_iterables () {
		
		List<String> list1 = Lists.newArrayList("one");
		List<String> list2 = Lists.newArrayList("two");
		
		Iterable<String> oneAndTwo = Iterables.concat(list1, list2);
		
		assertThat(oneAndTwo, IsIterableContainingInAnyOrder.
				<String>containsInAnyOrder("one", "two"));
	}
	
	/**
	 * Find element
	 */
	@Test
	public void find_element_in_iterable () {
		
		List <Integer> numbers = Lists.newArrayList(
				new Integer(1), 
				new Integer(2), 
				new Integer(3));
		
		Integer value = Iterables.find(numbers, new Predicate<Integer> () {
			public boolean apply(Integer number) {
				return number == 3 ;
			}
		});

		assertEquals(new Integer(3), value);
	}
	
	/**
	 * First non null
	 */
	@Test
	public void find_first_non_null () {

		List<String> strings = Lists.newArrayList(
				null, 
				"Little",
				null,
				"Drummer", 
				"Boy");
		
		String firstNonNull = Iterables.find(strings, Predicates.notNull());
		
		assertEquals("Little", firstNonNull);
	}
	
	/**
	 * Frequency of objects
	 */
	@Test
	public void frequency_of_object_in_iterable () {
		
		String jingleChorus = "Oh, jingle bells, jingle bells "
				+ "Jingle all the way "
				+ "Oh, what fun it is to ride "
				+ "In a one horse open sleigh "
				+ "Jingle bells, jingle bells "
				+ "Jingle all the way "
				+ "Oh, what fun it is to ride "
				+ "In a one horse open sleigh";
		
		List<String> words = Splitter.on(CharMatcher.anyOf(" ."))
				.trimResults(CharMatcher.is('.'))
				.omitEmptyStrings()
				.splitToList(jingleChorus.toLowerCase());
		
		int numberOfOccurences = Iterables.frequency(words, "jingle");

		assertEquals(6, numberOfOccurences);
	}

	/**
	 * First element
	 */
	@Test
	public void get_first_element_in_list () {

		List<String> strings = Lists.newArrayList("one", "two", "three");
		
		String firstElement = Iterables.getFirst(strings, null);
		
		assertEquals("one", firstElement);
	}
	
	/**
	 * Last element
	 */
	@Test
	public void get_last_element_in_iterable () {

		List<String> strings = Lists.newArrayList("one", "two", "three");
		
		String firstElement = Iterables.getLast(strings, null);
		
		assertEquals("three", firstElement);
	}
	
	/**
	 * All elements 
	 */
	@Test
	public void iterable_contains_all () {

		List<String> cookies = Lists.newArrayList(
				"Peanut Butter Cookies", 
				"Oatmeal-Raisin Cookies", 
				"Basic Chocolate Chip Cookies");
		
		
		boolean containsCookie = Iterables.all(cookies, new Predicate<String>() {
			public boolean apply(String input) {
				return input.toLowerCase().contains("cookie");
			}
		});
		
		assertTrue(containsCookie);
	}
	
	/**
	 * Any element in iterable
	 */
	@Test
	public void iterable_contains_any () {

		List<String> cookies = Lists.newArrayList(
				"Peanut Butter", 
				"Oatmeal-Raisin", 
				"Basic Chocolate Chip Cookies");
		
		
		boolean containsCookie = Iterables.any(cookies, new Predicate<String>() {
			public boolean apply(String input) {
				return input.toLowerCase().contains("cookie");
			}
		});
		
		assertTrue(containsCookie);
	}
	
	/**
	 * Number of elements in iterable
	 */
	@Test
	public void iterables_size () {
		
		List<Integer> randomNumbers = Lists.newArrayList(
				new Integer(23),
				new Integer(33),
				new Integer(44));
		
		int iterableSize = Iterables.size(randomNumbers);
		
		assertEquals(3, iterableSize);
	}
	
	/**
	 * Get element at specified position
	 */
	@Test
	public void get_iterable_element_by_index () {
		
		String baconIpsum = "Bacon ipsum dolor sit "
				+ "amet tri-tip rump shoulder "
				+ "kielbasa strip steak";
		
		Iterable<String> chars = Splitter.on(CharMatcher.WHITESPACE)
				.split(baconIpsum);
		
		String elementAtPos5 = Iterables.get(chars, 5);
		
		assertEquals("tri-tip", elementAtPos5);
	}
	
}
