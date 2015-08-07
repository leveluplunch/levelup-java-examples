package com.levelup.java.collections;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * This java example will demonstrate how to filter a collection by type.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/filter-collection-by-class-type/'>Filter collection by type</a>
 */
public class FilterElementsByType {

	
	List<Object> objects;
	
	@Before
	public void setUp () {
		objects = Lists.newArrayList();
		
		objects.add(new Integer(15));
		objects.add(new Double(12));
		objects.add("hello");
		objects.add(Lists.newArrayList());
		objects.add(Maps.newConcurrentMap());
		objects.add("world");
	}
	
	
	@Test
	public void filter_elements_by_type_java () {
		
		List<String> strings = new ArrayList<String>();
		
		for (Object obj : objects) {
			
			if (obj instanceof String) {
				strings.add((String) obj); 
			}
		}
		
		assertThat(strings, contains(
	    		"hello", "world"));
	}
	
	@Test
	public void filter_elements_by_type_java8_lambda () {
		
		List<String> strings = objects
				.stream()
				.filter(p -> p instanceof String)
				.map(p -> (String) p)
				.collect(Collectors.toList());

		System.out.println(strings);
		
		assertThat(strings, contains(
	    		"hello", "world"));
	}
	
	
	@Test
	public void filter_elements_by_type_guava_fluentiterable () {
		
		List<String> strings = FluentIterable.from(objects)
			.filter(String.class)
			.toList();
		
		assertThat(strings, contains(
	    		"hello", "world"));
	}
	
	@Test
	public void filter_elements_by_type_iterable () {
		
		Iterable<String> strings = Iterables.filter(objects, String.class);
		
		assertThat(strings, contains(
	    		"hello", "world"));
	}
	
	@Test
	public void filter_elements_by_type_apache () {
		
		CollectionUtils.filter(objects, new org.apache.commons.collections.Predicate() {
			public boolean evaluate(Object obj) {
				return obj instanceof String;
			}
		});
		
		@SuppressWarnings("unchecked")
		Collection<String> strings = CollectionUtils.typedCollection(objects, String.class);
		
		assertThat(strings, contains(
	    		"hello", "world"));
	}
	
	
}
