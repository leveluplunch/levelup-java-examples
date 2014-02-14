package com.levelup.java.collections;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate finding the distinct
 * number of elements in list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/distinct-elements-collection-arraylist/'>Distinct elements in collection</a>
 */
public class DistinctElementsInList {

	private static final Logger logger = Logger.getLogger(CountElementsInList.class);
	
	@Test
	public void distinct_elements_java8_numbers () {
		
		List<Integer> distinctIntegers = IntStream.of(5, 6, 6, 6, 3, 2, 2)
			.distinct()
			.boxed()
			.collect(Collectors.toList());
		
		logger.info(distinctIntegers);
		
		assertEquals(4, distinctIntegers.size());
		assertThat(distinctIntegers, contains(
	    		5, 6, 3, 2));
	}
	
	@Test
	public void distinct_elements_java8_objects () {

		List<String> objects = new ArrayList<>();
		objects.add("Hello");
		objects.add("Hello");
		objects.add("World");
		objects.add("Good morning");

		List<String> distinctObjects = objects.stream().distinct()
				.collect(Collectors.toList());
		
		logger.info(distinctObjects);
		
		assertEquals(3, distinctObjects.size());
		assertThat(distinctObjects, contains(
	    		"Hello", "World", "Good morning"));
	}
	
	@Test
	public void distinct_elements_guava_objects () {
		
		List<Integer> integers = Lists.newArrayList(5, 6, 6, 6, 3, 2, 2);
		
		ImmutableSet<Integer> distinctIntegers = ImmutableSet.copyOf(integers);
		
		logger.info(distinctIntegers);
		
		assertEquals(4, distinctIntegers.size());
		assertThat(distinctIntegers, contains(
	    		5, 6, 3, 2));
	}
	
	
}
