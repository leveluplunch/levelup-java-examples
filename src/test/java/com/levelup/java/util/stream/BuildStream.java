package com.levelup.java.util.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.Test;

/**
 * This java example will demonstrate common ways to create a string in java 8.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/how-to-build-java-util-stream/'>Build
 *      a stream</a>
 */
public class BuildStream {

	@Test
	public void stream_from_values() {

		Stream<String> stream = Stream.of("java 8 ", "leveluplunch.com",
				"examples", "exercises");

		String joined = stream.map(String::trim).collect(
				Collectors.joining(","));

		assertEquals("java 8,leveluplunch.com,examples,exercises", joined);
	}

	@Test
	public void empty_stream() {

		Stream<String> emptyStream = Stream.empty();

		long val = emptyStream.count();

		assertTrue(val == 0);
	}

	@Test
	public void stream_from_array() {

		int[] numbers = { 1, 2, 3, 4, 5, 6, 7 };

		int sum = Arrays.stream(numbers).sum();

		assertEquals(28, sum);
	}

	@Ignore("used from count distinct words")
	@Test
	public void stream_from_file() throws IOException {

		long uniqueWords = java.nio.file.Files
				.lines(Paths.get("word-occurrences-in-file.txt"),
						Charset.defaultCharset())
				.flatMap(line -> Arrays.stream(line.split(" ."))).distinct()
				.count();

		assertEquals(80, uniqueWords);
	}

	@Test
	public void stream_from_function() {

		Stream.iterate(0, n -> n + 3).limit(10).forEach(System.out::println);

	}

	@Test
	public void stream_from_random() {

		Stream.generate(Math::random).limit(10).forEach(System.out::println);
	}

}
