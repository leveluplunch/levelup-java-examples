package com.levelup.java.collections;

import static org.junit.Assert.assertFalse;

import java.util.Collections;
import java.util.Iterator;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.collections.iterators.EmptyIterator;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;

/**
 * This java example will demonstrate how to return an empty iterator.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/return-empty-list-iterator-instead-of-null/'>Return empty list iterator</a>
 */
public class ReturnEmptyIterator {

	@Test
	public void return_empty_list_iterator_java () {
	
		Iterator<String> strings = Collections.emptyIterator();
		
		assertFalse(strings.hasNext());
	}

	@Test
	public void return_empty_list_iterator_guava () {
	
		Iterator<String> strings = Iterators.emptyIterator();
		
		assertFalse(strings.hasNext());
	}

	@Test
	public void return_empty_iterator_java () {
		
		@SuppressWarnings("unchecked")
		Iterator<String> strings = IteratorUtils.emptyIterator();
		
		assertFalse(strings.hasNext());
	}
	
	class DomainObject {
		Iterator<String> getStrings () {
			return null;
		}
	}
	
	/**
	 * Used for exception example
	 */
	@SuppressWarnings("unused")
	private void return_empty_iterator_java_exception () {

		DomainObject domain = null; // dao populate domain

		Iterator<String> strings;
		if (domain != null && domain.getStrings() != null 
				&& domain.getStrings().hasNext()) {
			strings = domain.getStrings();
		} else {
			strings = Collections.emptyIterator();
		}
		
		//...
	}

	/**
	 * Used for exception example
	 */
	@SuppressWarnings("unused")
	private void return_empty_iterator_guava_exception () {
		
		DomainObject domain = null; // dao populate domain
		
		Iterator<String> strings = Objects.firstNonNull(
				domain != null ? domain.getStrings() : null, 
				Iterators.<String>emptyIterator());

		//...
	}
	
	/**
	 * Used for exception example
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private void return_empty_iterator_apache_commons_exception () {
		
		DomainObject domain = null; // dao populate domain

		Iterator<String> strings;
		if (domain != null && !CollectionUtils.sizeIsEmpty(domain.getStrings())) {
			strings = domain.getStrings();
		} else {
			strings = EmptyIterator.INSTANCE;
		}
		
		//...
	}

}
