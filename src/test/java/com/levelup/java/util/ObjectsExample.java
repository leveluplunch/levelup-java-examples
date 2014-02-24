package com.levelup.java.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Objects;
import java.util.function.Supplier;

import org.junit.Ignore;
import org.junit.Test;

/**
 * This java example will demonstrate java
 * Objects utility method.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/java-util-objects-example/'>Objects example</a>
 */
public class ObjectsExample {

	@Test
	public void objects_isNull () {
		
		boolean isNull = Objects.isNull(null);
		
		assertTrue(isNull);
	}

	@Test
	public void objects_nonNull () {
		
		boolean nonNull = Objects.nonNull("");

		assertTrue(nonNull);
	}

	@Test(expected = NullPointerException.class)
	public void objects_requireNonNull () {
		
		Integer val = null;
		
		Objects.requireNonNull(val); //throws null pointer
	}

	@Test
	public void objects_requireNonNullMessage () {
		
		Integer val = null;

		try {
			Objects.requireNonNull(val, "Val must not be null");	
		} catch (NullPointerException e) {
			assertEquals("Val must not be null", e.getMessage());
		}
	}
	
	@Test
	public void objects_requireNonNullMessageSupplier () {
		
		Integer val = null;

		Supplier<String> messageSupplier = new Supplier<String>() {
			@Override
			public String get() {
				return "Val must not be null";
			}
		};
		
		try {
			Objects.requireNonNull(val, messageSupplier);	
		} catch (NullPointerException e) {
			assertEquals("Val must not be null", e.getMessage());
		}
	}

	@Test
	public void objects_hashcode () {
		
		int hashCode = Objects.hashCode(this);
		
		assertEquals(1067938912, hashCode);
	}
	
	class Sample {
		String val;
	}
	
	@Ignore
	@Test
	public void objects_tostring() {
		
		Sample sample = new Sample();
		sample.val = "hello";
		
		String val = Objects.toString(sample);
		
		assertEquals("", val);
	}
	
}
