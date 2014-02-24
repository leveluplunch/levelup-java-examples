package com.levelup.java.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.OptionalInt;
import java.util.function.IntSupplier;

import org.junit.Test;

/**
 * This java example will demonstrate uses 
 * of OptionalInt.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/java-util-optionalint-example/'>OptionalInt example</a>
 */
public class OptionalIntExample {

	@Test
	public void optional_int_getAsInt() {

		OptionalInt optionalInt = OptionalInt.of(90);
		
		assertEquals(90, optionalInt.getAsInt(), 0);
	}

	@Test
	public void optional_int_ifPresent() {
		
		OptionalInt optionalInt = OptionalInt.of(56);

		optionalInt.ifPresent(p -> System.out.println(p));
		
		// or
		
		optionalInt.ifPresent(System.out::println);
	}

	@Test
	public void optional_int_isPresent() {
		
		OptionalInt optionalInt = OptionalInt.of(56);
		
		assertTrue(optionalInt.isPresent());
	}

	@Test
	public void optional_int_orElse() {
		
		OptionalInt optionalInt = OptionalInt.empty();
		
		assertEquals(77, optionalInt.orElse(77), 0);
	}

	@Test
	public void optional_int_orElseGet() {
		
		OptionalInt optionalInt = OptionalInt.empty();

		assertEquals(10, optionalInt.orElseGet(() -> 10), 0);
		
		// or 
		IntSupplier intSupplier = new IntSupplier() {
			@Override
			public int getAsInt() {
				return 10;
			}
		};
		
		assertEquals(10, optionalInt.orElseGet(intSupplier), 0);
	}

	@Test(expected=IllegalStateException.class)
	public void optional_int_orElseThrow() {
		
		OptionalInt optionalFramework = OptionalInt.empty();

		optionalFramework.orElseThrow(IllegalStateException::new);
	}

	@Test
	public void optional_int_empty() {

		OptionalInt optionalInt = OptionalInt.empty();
		
		assertFalse(optionalInt.isPresent());
	}

	@Test
	public void optional_int_of() {

		OptionalInt optionalInt = OptionalInt.of(89);
		
		assertEquals(89, optionalInt.getAsInt(), 0);
	}
}
