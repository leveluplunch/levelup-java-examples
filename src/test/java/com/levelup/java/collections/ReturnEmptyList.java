package com.levelup.java.collections;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

/**
 * This java example will demonstrate how to return an empty list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/return-empty-list-instead-of-null/'>Return empty list</a>
 */
public class ReturnEmptyList {
	
	@Test
	public void return_empty_list_java () {
		
		List<String> emptyList = Collections.emptyList();
		
		assertTrue(emptyList.isEmpty());
	}
	
	@Test
	public void return_empty_list_guava () {
		
		List<String> emptyList = ImmutableList.of();

		assertTrue(emptyList.isEmpty());
	}

	@Test
	public void return_empty_list_apache_commons () {
		
		@SuppressWarnings("unchecked")
		List<String> emptyList = ListUtils.EMPTY_LIST;
		
		assertTrue(emptyList.isEmpty());
	}
	
	class DomainObject {
		List<String> getStrings () {
			return null;
		}
	}

	/**
	 * Used for post example
	 */
	@SuppressWarnings("unused")
	private void return_empty_list_java_exception () {
		
		DomainObject domain = null; // dao populate domain

		List<String> strings;
		if (domain != null && domain.getStrings() != null 
				&& domain.getStrings().size() > 0) {
			strings = domain.getStrings();
		} else {
			strings = Collections.emptyList();
		}
	}
	
	/**
	 * Used for post example
	 */
	@SuppressWarnings({ "unused" })
	private void return_empty_list_guava_exception () {
		
		DomainObject domain = null; // dao populate domain
		
		List<String> strings = Objects.firstNonNull(
				domain != null ? domain.getStrings() : null, 
				ImmutableList.<String>of());

		//...
	}

	
	/**
	 * Used for post example
	 */
	@SuppressWarnings({"unchecked", "unused" })
	private void return_empty_list_apache_commons_exception () {

		DomainObject domain = null; // dao populate domain

		List<String> strings;
		if (domain != null && !CollectionUtils.isEmpty(domain.getStrings())) {
			strings = domain.getStrings();
		} else {
			strings = ListUtils.EMPTY_LIST;
		}

		//...
	}

	
}
