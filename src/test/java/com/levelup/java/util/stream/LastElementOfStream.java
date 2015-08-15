package com.levelup.java.util.stream;

import static org.junit.Assert.assertEquals;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * This java example will demonstrate how to find last element in stream.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/find-last-element-java8-stream/'>Last element in stream</a>
 */
public class LastElementOfStream {

	@Test
	public void last_element_stream() {

		Optional<String> optionalJava = Stream.of("a", "b", "c").reduce(
				(a, b) -> b);

		assertEquals("c", optionalJava.get());

		String lastValue = Stream.of("a", "b", "c").reduce((a, b) -> b)
				.orElse("false");

		assertEquals("c", lastValue);
	}
}
