package com.levelup.java.util.stream;

import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * This java example will demonstrate how to convert a stream to a set.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com//'></a>
 */
public class ConvertStreamToSet {
	
	@Test
	public void stream_to_set() {

		Set<Integer> numbers = Stream.of(1, 2, 3)
				.collect(toSet());

		assertTrue(numbers.size() == 3);
	}

}
