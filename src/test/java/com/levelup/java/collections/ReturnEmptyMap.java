package com.levelup.java.collections;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableMap;

/**
 * This java example will demonstrate how to return an empty map.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/return-empty-map-instead-of-null/'>Return empty map</a>
 */
public class ReturnEmptyMap {

	@Test
	public void return_empty_map_java () {

		Map<String, String> emptyMap = Collections.emptyMap();
		
		assertTrue(emptyMap.isEmpty());
	}

	@Test
	public void return_empty_map_guava () {
		
		Map<String, String> emptyMap = ImmutableMap.of();

		assertTrue(emptyMap.isEmpty());
	}
	
	@Test
	public void return_empty_map_apache_commons () {
		
		@SuppressWarnings("unchecked")
		Map<String, String> emptyMap = MapUtils.EMPTY_MAP;
		
		assertTrue(emptyMap.isEmpty());
	}
	
	/**
	 * Used for post example
	 */
	class DomainObject {
		Map<String, String> getMap () {
			return null;
		}
	}
	
	/**
	 * Used for post example
	 */
	@SuppressWarnings("unused")
	private void return_empty_map_java_exception () {
		
		DomainObject domain = null; // dao populate domain

		Map<String, String> mapOfStrings;
		if (domain != null 
				&& domain.getMap() != null 
				&& !domain.getMap().isEmpty()) {
			mapOfStrings = domain.getMap();
		} else {
			mapOfStrings = Collections.emptyMap();
		}
		
		//...
	}

	/**
	 * Used for post example
	 */
	@SuppressWarnings({ "unused" })
	private void return_empty_map_guava_exception () {
		
		DomainObject domain = null; // dao populate domain
		
		Map<String, String> mapOfStrings = Objects.firstNonNull(
				domain != null ? domain.getMap() : null, 
				ImmutableMap.<String, String>of());
		
		//...
	}
	
	/**
	 * Used for post example
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private void return_empty_map_apache_commons_exception () {
		
		DomainObject domain = null; // dao populate domain

		Map<String, String> mapOfStrings;

		if (domain != null && !MapUtils.isEmpty(domain.getMap())) {
			mapOfStrings = domain.getMap();
		} else {
			mapOfStrings = MapUtils.EMPTY_MAP;
		}

		//...
	}
	
}
