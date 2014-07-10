package com.levelup.java.util.stream;

import static org.junit.Assert.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * This java example will demonstrate how to convert a stream to a {@link String}.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-java-util-stream-to-string/'>Convert stream to String</a>
 */
public class ConvertStreamToString {

	@Test
	public void stream_to_list() {

		String streamToString = Stream.of("a", "b", "c")
				.collect(Collectors.joining());

		assertEquals("abc", streamToString);
	}
	
}
