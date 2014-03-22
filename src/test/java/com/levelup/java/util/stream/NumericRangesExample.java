package com.levelup.java.util.stream;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.levelup.java.number.CheckIfNumberInBetween;

/**
 * This java example will demonstrate how to create a 
 * numeric range in java 8.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/java8-numeric-ranges-example/'>Numeric Ranges Example</a>
 */
public class NumericRangesExample {

	private static final Logger logger = Logger.getLogger(CheckIfNumberInBetween.class);
	
	@Test
	public void instream_range() {

		Set<Integer> range = IntStream.range(1, 10).boxed()
				.collect(Collectors.toSet());

		logger.info(range);
	}
	
	@Test
	public void instream_range_closed() {

		Set<Integer> range = IntStream.rangeClosed(1, 10).boxed()
				.collect(Collectors.toSet());

		logger.info(range);
	}
}
