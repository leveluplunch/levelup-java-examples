package com.levelup.java.util.function;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Objects;
import java.util.function.Predicate;

import org.junit.Test;

/**
 * This java example will demonstrate common 
 * uses of java.util.function.Predicate.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/java-util-function-predicate-example/'>Predicate Example</a>
 */
public class PredicateExample {

	// show different ways to show a predicate

	Predicate<String> hasLengthOf10 = new Predicate<String>() {
		@Override
		public boolean test(String t) {
			return t.length() > 10;
		}
	};

	@Test
	public void predicate_test() {

		String randomString = "The 2014 Winter Olympics, officially "
				+ "known as the XXII Olympic Winter Games, "
				+ "is a major international multi-sport "
				+ "event currently being held in Sochi, "
				+ "Russia, in the tradition of the " + "Winter Olympic Games";

		boolean outcome = hasLengthOf10.test(randomString);

		assertTrue(outcome);
	}

	@Test
	public void predicate_and() {

		Predicate<String> nonNullPredicate = Objects::nonNull;

		String nullString = null;

		boolean outcome = nonNullPredicate.and(hasLengthOf10).test(nullString);
		assertFalse(outcome);

		String lengthGTThan10 = "Welcome to the machine";

		boolean outcome2 = nonNullPredicate.and(hasLengthOf10).test(
				lengthGTThan10);

		assertTrue(outcome2);
	}

	@Test
	public void predicate_negate() {

		String lengthGTThan10 = "Thunderstruck is a 2012 children's "
				+ "film starring Kevin Durant";

		boolean outcome = hasLengthOf10.negate().test(lengthGTThan10);
		assertFalse(outcome);
	}

	@Test
	public void predicate_or() {

		Predicate<String> containsLetterA = p -> p.contains("A");

		String containsA = "And";

		boolean outcome = hasLengthOf10.or(containsLetterA).test(containsA);

		assertTrue(outcome);
	}

}
