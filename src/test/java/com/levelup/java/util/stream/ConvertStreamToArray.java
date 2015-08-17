package com.levelup.java.util.stream;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * This java example will demonstrate how to convert stream to array.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/convert-java-util-stream-to-array/'>Convert
 *      stream to array</a>
 */
public class ConvertStreamToArray {

	private static final Logger logger = Logger
			.getLogger(ConvertStreamToArray.class);

	@Test
	public void stream_of_strings_to_array() {

		String[] stringArray = Stream.of("One", "Two", "Three").toArray(
				String[]::new);

		logger.info(Arrays.toString(stringArray));

		assertTrue(stringArray.length == 3);
	}

	@Test
	public void stream_of_strings_to_ints_array() {

		Integer[] stringArray = Stream.of(1, 2, 3).toArray(Integer[]::new);

		logger.info(Arrays.toString(stringArray));

		assertTrue(stringArray.length == 3);
	}

	@Test
	public void int_stream_to_array() {

		int[] intArray = IntStream.of(1, 2, 3).toArray();

		logger.info(Arrays.toString(intArray));

		assertTrue(intArray.length == 3);
	}

	@Test
	public void long_stream_to_array() {

		long[] longArray = LongStream.of(1, 2, 3).toArray();

		logger.info(Arrays.toString(longArray));

		assertTrue(longArray.length == 3);
	}

	@Test
	public void double_stream_to_array() {

		double[] doubleArray = DoubleStream.of(1, 2, 3).toArray();

		logger.info(Arrays.toString(doubleArray));

		assertTrue(doubleArray.length == 3);
	}

}
