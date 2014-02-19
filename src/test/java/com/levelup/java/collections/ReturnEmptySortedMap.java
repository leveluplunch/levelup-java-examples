package com.levelup.java.collections;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.junit.Test;

import com.google.common.collect.ImmutableSortedMap;

/**
 * This java example will demonstrate how to return an empty sorted map.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/return-empty-sorted-map-instead-of-null/'>Return empty sorted map</a>
 */
public class ReturnEmptySortedMap {

	@Test
	public void return_empty_sorted_map_java () {

		Map<String, String> sortedEmptyMap = Collections.emptySortedMap();
		
		assertTrue(sortedEmptyMap.isEmpty());
	}

	@Test
	public void return_empty_sorted_map_guava () {
		
		Map<String, String> sortedEmptyMap = ImmutableSortedMap.of();

		assertTrue(sortedEmptyMap.isEmpty());
	}
	
	@Test
	public void return_empty_sorted_map_apache_commons () {
		
		@SuppressWarnings("unchecked")
		Map<String, String> sortedEmptyMap = MapUtils.EMPTY_SORTED_MAP;
		
		assertTrue(sortedEmptyMap.isEmpty());
	}
	
}
