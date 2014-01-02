package com.levelup.java.collections;

import static org.junit.Assert.assertFalse;

import java.util.Collections;
import java.util.ListIterator;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.collections.iterators.EmptyListIterator;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

/**
 * This java example will demonstrate how to return an empty list iterator.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/return-empty-iterator-instead-of-null/'>Return empty iterator</a>
 */
public class ReturnEmptyListIterator {

	@Test
	public void return_empty_list_iterator_java () {
		
		ListIterator<String> strings = Collections.emptyListIterator();

		assertFalse(strings.hasNext());
	}

	@Test
	public void return_empty_list_iterator_guava () {
		
		ListIterator<String> strings = ImmutableList.<String>of().listIterator();

		assertFalse(strings.hasNext());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void return_empty_list_iterator_apache () {

		ListIterator<String> strings = IteratorUtils.emptyListIterator();

		assertFalse(strings.hasNext());
	}
	
	class DomainObject {
		ListIterator<String> getStrings () {
			return null;
		}
	}
	
	/**
	 * Used for exception example
	 */
	@SuppressWarnings("unused")
	private void return_empty_list_iterator_java_exception () {

		DomainObject domain = null; // dao populate domain

		ListIterator<String> strings;
		if (domain != null && domain.getStrings() != null 
				&& domain.getStrings().hasNext()) {
			strings = domain.getStrings();
		} else {
			strings = Collections.emptyListIterator();
		}
		
		//...
	}

	/**
	 * Used for exception example
	 */
	@SuppressWarnings("unused")
	private void return_empty_list_iterator_guava_exception () {
		
		DomainObject domain = null; // dao populate domain
		
		ListIterator<String> strings = Objects.firstNonNull(
				domain != null ? domain.getStrings() : null, 
				ImmutableList.<String>of().listIterator());

		//...
	}
	
	/**
	 * Used for exception example
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private void return_empty_list_iterator_apache_commons_exception () {
		
		DomainObject domain = null; // dao populate domain

		ListIterator<String> strings;
		if (domain != null && !CollectionUtils.sizeIsEmpty(domain.getStrings())) {
			strings = domain.getStrings();
		} else {
			strings = EmptyListIterator.INSTANCE;
		}

		//...
	}

}
