package com.levelup.java.number;

import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

/**
 * This java example will demonstrate return a range of numbers.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/generate-sequential-numbers-from-range/'>Generate numbers from range</a>
 */
public class GenerateRangeOfSequentialNumbers {

	private static final Logger logger = Logger
			.getLogger(GenerateRangeOfSequentialNumbers.class);

	@Test
	public void range_sequential_numbers_java8() {

		Set<Integer> range = IntStream.rangeClosed(20, 30).boxed()
				.collect(Collectors.toSet());

		logger.info(range);

		assertTrue(range.size() == 11);
	}

	@Test
	public void range_sequential_numbers_guava() {

		Range<Integer> range = Range.closed(20, 30);

		Set<Integer> ranges = ContiguousSet.create(range,
				DiscreteDomain.integers());

		logger.info(ranges);

		assertTrue(ranges.size() == 11);
	}

}
