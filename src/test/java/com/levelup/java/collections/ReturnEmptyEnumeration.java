package com.levelup.java.collections;

import static org.junit.Assert.assertFalse;

import java.util.Collections;
import java.util.Enumeration;

import org.junit.Test;

/**
 * This java example will demonstrate how to return an empty enumeration.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/return-empty-enumeration-instead-of-null/'>Return empty enumeration</a>
 */
public class ReturnEmptyEnumeration {

	@Test
	public void return_empty_enumeration_java () {
	
		Enumeration<String> strings = Collections.emptyEnumeration();
		
		assertFalse(strings.hasMoreElements());
	}
		
	class DomainObject {
		Enumeration<String> getStrings () {
			return null;
		}
	}
	
	/**
	 * Used for exception example
	 */
	@SuppressWarnings("unused")
	private void return_empty_set_java_exception () {
		
		DomainObject domain = null; // dao populate domain

		Enumeration<String> strings;
		if (domain != null && domain.getStrings() != null 
				&& domain.getStrings().hasMoreElements()) {
			strings = domain.getStrings();
		} else {
			strings = Collections.emptyEnumeration();
		}
		
		//...
	}

}
