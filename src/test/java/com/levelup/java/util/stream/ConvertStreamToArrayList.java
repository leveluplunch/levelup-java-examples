package com.levelup.java.util.stream;

import static org.junit.Assert.assertTrue;

import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * This java example will demonstrate how to convert a stream to a list.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-java-util-stream-to-arraylist/'>Stream to list</a>
 */
public class ConvertStreamToArrayList {

	@Test
	public void stream_to_list() {

		List<String> abc = Stream.of("a", "b", "c")
				.collect(toList());

		assertTrue(abc.size() == 3);
	}

}
