package com.levelup.java.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.OptionalLong;
import java.util.function.LongSupplier;

import org.junit.Test;

/**
 * This java example will demonstrate uses 
 * of OptionalLong.
 *  
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/java-util-optionallong-example/'>OptionalLong example</a>
 */
public class OptionalLongExample {

	@Test
	public void optional_long_getAsLong() {

		OptionalLong optionalLong = OptionalLong.of(90);
		
		assertEquals(90, optionalLong.getAsLong(), 0);
	}

	@Test
	public void optional_long_ifPresent() {
		
		OptionalLong optionalLong = OptionalLong.of(56);

		optionalLong.ifPresent(p -> System.out.println(p));
		
		// or
		
		optionalLong.ifPresent(System.out::println);
	}

	@Test
	public void optional_long_isPresent() {
		
		OptionalLong optionalLong = OptionalLong.of(56);
		
		assertTrue(optionalLong.isPresent());
	}

	@Test
	public void optional_long_orElse() {
		
		OptionalLong optionalLong = OptionalLong.empty();
		
		assertEquals(77, optionalLong.orElse(77), 0);
	}

	@Test
	public void optional_long_orElseGet() {
		
		OptionalLong optionalLong = OptionalLong.empty();

		assertEquals(10, optionalLong.orElseGet(() -> 10), 0);
		
		// or 
		LongSupplier longSupplier = new LongSupplier() {
			@Override
			public long getAsLong() {
				return 10;
			}
		};
		
		assertEquals(10, optionalLong.orElseGet(longSupplier), 0);
	}

	@Test(expected=IllegalStateException.class)
	public void optional_long_orElseThrow() {
		
		OptionalLong optionalFramework = OptionalLong.empty();

		optionalFramework.orElseThrow(IllegalStateException::new);
	}

	@Test
	public void optional_long_empty() {

		OptionalLong optionalLong = OptionalLong.empty();
		
		assertFalse(optionalLong.isPresent());
	}

	@Test
	public void optional_long_of() {

		OptionalLong optionalLong = OptionalLong.of(89);
		
		assertEquals(89, optionalLong.getAsLong(), 0);
	}
	
}
