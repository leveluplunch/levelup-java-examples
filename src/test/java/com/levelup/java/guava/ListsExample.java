package com.levelup.java.guava;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate common usages of
 * Google Guava Lists Utility.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-lists-utility-example/'>Guava Lists Example</a>
 */
public class ListsExample {
	
	/**
	 * Create new list
	 */
	@Test
	public void create_new_list () {
		
		List<String> myList = Lists.newArrayList();
		
		assertNotNull(myList);
	}

	/**
	 * Create new list w/ parameters
	 */
	@Test
	public void create_new_list_with_parameters () {
	
		List<String> myList = Lists.newArrayList("one", "two");
		
		assertNotNull(myList);
	}

	/**
	 * Create list with capacity
	 */
	@Test
	public void create_new_list_with_capacity () {

		List<String> listWithSize10 = Lists.newArrayListWithCapacity(10);
		
		assertNotNull(listWithSize10);
	}

	/**
	 * Create new list w/ expected size
	 */
	@Test
	public void create_new_list_with_expected_size () {

		List<String> listWithSize10 = Lists.newArrayListWithExpectedSize(10);
		
		assertNotNull(listWithSize10);
	}
	
	
	/**
	 * New unmodifiable list from varargs
	 */
	@Test
	public void create_new_unmodified_list () {
		
		String[] vals = {"test1", "test2"};
		List<String> myList = Lists.asList("test0", vals);
		
		assertNotNull(myList);
	}
	
	/**
	 * Partition list
	 */
	@Test
	public void partition_list () {
		
		List<String> myList = Lists.newArrayList("one", "two", "three");
		
		List<List<String>> myListBy1 = Lists.partition(myList, 1);

	    assertThat(myListBy1.get(0), hasItems("one"));
	    assertThat(myListBy1.get(1), hasItems("two"));
	    assertThat(myListBy1.get(2), hasItems("three"));
	}
	

	/**
	 * Reverse list
	 */
	@Test
	public void reverse_list () {

		List<String> myList = Lists.newArrayList("one", "two", "three");

		List<String> reverseMyList = Lists.reverse(myList);
		
		assertThat(reverseMyList, contains(
				 "three", "two", "one"));
	}

	/**
	 * Tranform elements in list
	 */
	@Test
	public void tranform_elements_in_list () {
		
		List<String> numbersAsStrings = Lists.newArrayList(
				"1", "2", "3");
		
		List<Double> doubles = Lists.transform(numbersAsStrings, new Function<String, Double>() {
			@Override
			public Double apply(String input) {
				return new Double(input);
			}
		});
		
		assertThat(doubles, contains(
				 new Double(1), new Double(2), 
				 new Double(3)));
	}
}
