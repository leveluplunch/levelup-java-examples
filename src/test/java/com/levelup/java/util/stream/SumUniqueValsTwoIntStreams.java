package com.levelup.java.util.stream;

import static org.junit.Assert.assertEquals;

import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * This java example will demonstrate how to find the sum unique values from two
 * IntStreams .
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/sum-unique-values-two-intstream/'>Sum
 *      unique values of numeric streams</a>
 */
public class SumUniqueValsTwoIntStreams {

	@Test
	public void sum_unique_values_intstream() {

		IntStream stream1 = IntStream.of(1, 2, 3);
		IntStream stream2 = IntStream.of(1, 2, 3);

		int val = IntStream.concat(stream1, stream2).distinct().sum();

		assertEquals(6, val);

		// or
		OptionalInt sum2 = IntStream.concat(stream1, stream2).reduce(
				(a, b) -> a + b);

		assertEquals(6, sum2.getAsInt());
	}

}
