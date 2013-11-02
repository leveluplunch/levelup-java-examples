package com.levelup.java;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import com.google.common.base.Objects;

/**
 * This java example will demonstrate getting the 
 * first non null object.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/get-first-non-null-object/'>First non null object</a>
 * 
 */
public class GetFirstNonNullObject {

	@Test
	public void get_first_non_null_java () {

		String first = null;
		String second = "Stomp the Hawks, Badgers!";
		
		String firstNullObject = null;
		
		if (first == null) {
			if (second != null) {
				firstNullObject = second;
			}
		}
		assertEquals(second, firstNullObject);
	}
	

	@Test
	public void get_first_non_null_guava () {
		
		String first = null;
		String second = "Go Badgers!";
		
		String firstNullObject = Objects.firstNonNull(first, second);
		
		assertEquals(second, firstNullObject);
	}

	@Test
	public void get_first_non_null_apache () {

		String first = null;
		String second = "On, Wisconsin!";

		String firstNullObject = ObjectUtils.firstNonNull(first, second);
		
		assertEquals(second, firstNullObject);
	}

}
