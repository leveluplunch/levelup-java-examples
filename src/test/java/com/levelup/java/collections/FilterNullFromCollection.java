package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hamcrest.collection.IsIterableWithSize;
import org.junit.Test;

import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate how to remove or filter
 * null elements from a collection.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/remove-filter-null-references-from-collection-list/'>Filter null from collection</a>
 */
public class FilterNullFromCollection {


	@Test
	public void remove_null_from_list_java () {

		List<String> strings = new ArrayList<>();
		strings.add(null);
		strings.add("www");
		strings.add(null);
		strings.add("leveluplunch");
		strings.add("com");
		strings.add(null);
		
		strings.removeAll(Collections.singleton(null));
		
		assertEquals(3, strings.size());
	}

	
	@Test
	public void remove_null_from_list_guava_collections2 () {

		List<String> strings = Lists.newArrayList(
				null, "www", null, 
				"leveluplunch", "com", null);

		
		Collection<String> filterStrings = Collections2
				.filter(strings, Predicates.notNull());

		assertEquals(3, filterStrings.size());
	}

	@Test
	public void remove_null_from_list_guava_fluentiterbale () {

		List<String> strings = Lists.newArrayList(
				null, "www", null, 
				"leveluplunch", "com", null);

		
		List<String> filterStrings = FluentIterable.from(strings)
				.filter(Predicates.notNull())
				.toList();

		assertEquals(3, filterStrings.size());
	}
	
	@Test
	public void remove_null_from_list_guava_iterables () {

		List<String> strings = Lists.newArrayList(
				null, "www", null, 
				"leveluplunch", "com", null);

		Iterable<String> filterStrings = Iterables.filter(strings, 
				Predicates.notNull());
		
		assertThat(filterStrings, IsIterableWithSize.<String>iterableWithSize(3));
	}
	
	@Test
	public void remove_null_from_list_apache_commons () {
		
		List<String> strings = new ArrayList<>();
		strings.add(null);
		strings.add("www");
		strings.add(null);
		strings.add("leveluplunch");
		strings.add("com");
		strings.add(null);

		
		CollectionUtils.filter(strings, new org.apache.commons.collections.Predicate() {
			public boolean evaluate(Object obj) {
				return obj != null;
			}
		});
		
		assertEquals(3, strings.size());
	}

	
}
