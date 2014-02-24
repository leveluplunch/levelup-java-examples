package com.levelup.java.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.OptionalDouble;
import java.util.function.DoubleSupplier;

import org.junit.Test;

/**
 * This java example will demonstrate uses 
 * of OptionalDouble.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/java-util-optionaldouble-example/'>OptionalDouble example</a>
 */
public class OptionalDoubleExample {

	@Test
	public void optional_double_getAsDouble() {

		OptionalDouble optionalDouble = OptionalDouble.of(90);
		
		assertEquals(90, optionalDouble.getAsDouble(), 0);
	}

	@Test
	public void optional_double_ifPresent() {
		
		OptionalDouble optionalDouble = OptionalDouble.of(56);

		optionalDouble.ifPresent(p -> System.out.println(p));
		
		// or
		
		optionalDouble.ifPresent(System.out::println);
	}

	@Test
	public void optional_double_isPresent() {
		
		OptionalDouble optionalDouble = OptionalDouble.of(56);
		
		assertTrue(optionalDouble.isPresent());
	}

	@Test
	public void optional_double_orElse() {
		
		OptionalDouble optionalDouble = OptionalDouble.empty();
		
		assertEquals(77, optionalDouble.orElse(77), 0);
	}

	@Test
	public void optional_double_orElseGet() {
		
		OptionalDouble optionalDouble = OptionalDouble.empty();

		assertEquals(10, optionalDouble.orElseGet(() -> 10), 0);
		
		// or 
		DoubleSupplier doubleSupplier = new DoubleSupplier() {
			@Override
			public double getAsDouble() {
				return 10;
			}
		};
		
		assertEquals(10, optionalDouble.orElseGet(doubleSupplier), 0);
	}

	@Test(expected=IllegalStateException.class)
	public void optional_double_orElseThrow() {
		
		OptionalDouble optionalFramework = OptionalDouble.empty();

		optionalFramework.orElseThrow(IllegalStateException::new);
	}

	@Test
	public void optional_double_empty() {

		OptionalDouble optionalDouble = OptionalDouble.empty();
		
		assertFalse(optionalDouble.isPresent());
	}

	@Test
	public void optional_double_of() {

		OptionalDouble optionalDouble = OptionalDouble.of(89);
		
		assertEquals(89, optionalDouble.getAsDouble(), 0);
	}

}
