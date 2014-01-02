package com.levelup.java.collections;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.SetUtils;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;

/**
 * This java example will demonstrate how to return an empty set.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/return-empty-set-instead-of-null/'>Return empty set</a>
 */
public class ReturnEmptySet {

	@Test
	public void return_empty_set_java () {

		Set<String> emptySet = Collections.emptySet();
		
		assertTrue(emptySet.isEmpty());
	}
	
	@Test
	public void return_empty_set_guava () {
		
		ImmutableSet<Object> emptySet = ImmutableSet.of();

		assertTrue(emptySet.isEmpty());
	}
	
	@Test
	public void return_empty_set_apache_commons () {
		
		@SuppressWarnings("unchecked")
		Set<String> emptySet = SetUtils.EMPTY_SET;
		
		assertTrue(emptySet.isEmpty());
	}
	
	class DomainObject {
		Set<String> getStrings () {
			return null;
		}
	}
	
	/**
	 * Used for post example
	 */
	@SuppressWarnings("unused")
	private void return_empty_set_java_exception () {
		
		DomainObject domain = null; // dao populate domain

		Set<String> strings;
		if (domain != null 
				&& domain.getStrings() != null 
				&& domain.getStrings().size() > 0) {
			strings = domain.getStrings();
		} else {
			strings = Collections.emptySet();
		}
	}

	/**
	 * Used for post example
	 */
	@SuppressWarnings({ "unused" })
	private void return_empty_set_guava_exception () {
		
		DomainObject domain = null; // dao populate domain
		
		Set<String> strings = Objects.firstNonNull(
				domain != null ? domain.getStrings() : null, 
				ImmutableSet.<String>of());

		//...
	}
	
	/**
	 * Used for post example
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private void return_empty_set_apache_commons_exception () {
		DomainObject domain = null; // dao populate domain

		Set<String> strings;
		if (domain != null && !CollectionUtils.isEmpty(domain.getStrings())) {
			strings = domain.getStrings();
		} else {
			strings = SetUtils.EMPTY_SET;
		}

		//...
	}

	
}
