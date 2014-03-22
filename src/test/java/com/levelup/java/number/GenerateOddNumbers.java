package com.levelup.java.number;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Iterables;
import com.google.common.collect.Range;

/**
 * This java example will demonstrate returning all odd
 * numbers within a given range.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/generate-odd-numbers-within-range/'>Generate odd numbers in range</a>
 */
public class GenerateOddNumbers {

	private static final Logger logger = Logger
			.getLogger(GenerateOddNumbers.class);

	@Test
	public void generate_odd_numbers_in_range_java8() {

		Set<Integer> oddNumbers = IntStream.rangeClosed(1, 10)
				.filter(n -> n % 2 != 0).boxed().collect(Collectors.toSet());

		logger.info(oddNumbers);

		assertThat(
				oddNumbers,
				contains(new Integer(1), new Integer(3), new Integer(5),
						new Integer(7), new Integer(9)));
	}

	@Test
	public void generate_odd_numbers_in_range_guava() {

		Set<Integer> set = ContiguousSet.create(Range.closed(1, 10),
				DiscreteDomain.integers());

		Iterable<Integer> oddNumbers = Iterables.filter(set,
				new Predicate<Integer>() {
					@Override
					public boolean apply(Integer input) {
						return input % 2 != 0;
					}
				});

		logger.info(oddNumbers);

		assertThat(
				oddNumbers,
				contains(new Integer(1), new Integer(3), new Integer(5),
						new Integer(7), new Integer(9)));
	}

}
