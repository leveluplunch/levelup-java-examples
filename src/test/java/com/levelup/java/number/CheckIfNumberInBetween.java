package com.levelup.java.number;

import static org.junit.Assert.assertTrue;

import java.util.OptionalLong;
import java.util.stream.LongStream;

import org.junit.Test;

import com.google.common.collect.Range;

/**
 * This java example will demonstrate how to check if a number is
 * within range.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/check-if-number-in-within-range/'>Number within range</a>
 */
public class CheckIfNumberInBetween {
	
	@Test
	public void number_between_java8() {

		OptionalLong containsValue = LongStream.range(1, 10)
				.filter(p -> p == 4).findAny();

		assertTrue(containsValue.isPresent());
	}

	@Test
	public void number_between_guava() {

		boolean containsValue = Range.open(1, 10).contains(new Integer(4));

		assertTrue(containsValue);
	}

}
