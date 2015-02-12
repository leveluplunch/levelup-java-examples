package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyInt;

import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Objects;

/**
 * This java example will demonstrate how to use methods on Guava Object
 * utility.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/guava-objects-example/'>Objects
 *      example</a>
 */
public class ObjectsExample {

	@Test
	public void to_string_helper() {

		String overRideToString = Objects.toStringHelper(this)
				.add("name", "value").toString();

		assertEquals("ObjectsExample{name=value}", overRideToString);
	}

	@Test
	public void objects_equals() {

		String value1 = "Ice cold beer fest";
		String value2 = "Ice cold beer fest 2013";

		boolean objectEqual = Objects.equal(value1, value2);
		assertFalse(objectEqual);
	}

	@Test
	public void first_non_null() {

		String first = null;
		String second = "What's shakin' bacon?";

		String firstNullObject = Objects.firstNonNull(first, second);

		assertEquals(second, firstNullObject);
	}

	@Ignore
	@Test
	public void object_hashcode() {

		int hashCode = Objects.hashCode(this);

		assertEquals(anyInt(), hashCode);
	}

}
