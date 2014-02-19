package com.levelup.java.collections;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Set;

import org.apache.commons.collections.SetUtils;
import org.junit.Test;

import com.google.common.collect.ImmutableSortedSet;

/**
 * This java example will demonstrate how to return an empty sorted set.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/return-empty-sorted-set-instead-of-null/'>Return empty sorted set</a>
 */
public class ReturnEmptySortedSet {

	@Test
	public void return_empty_sorted_set_java8 () {
		
		Set<String> emptySortedSet = Collections.emptySortedSet();
		
		assertTrue(emptySortedSet.isEmpty());
	}

	@Test
	public void return_empty_sorted_set_guava () {
		
		Set<String> emptySortedSet = ImmutableSortedSet.of();
		
		assertTrue(emptySortedSet.isEmpty());
	}
	
	@Test
	public void return_empty_sorted_set_apache_commons () {

		@SuppressWarnings("unchecked")
		Set<String> emptySortedSet = SetUtils.EMPTY_SORTED_SET;
		
		assertTrue(emptySortedSet.isEmpty());

	}
}
