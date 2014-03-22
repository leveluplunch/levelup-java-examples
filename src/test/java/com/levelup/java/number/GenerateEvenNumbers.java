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
 * This java example will demonstrate returning all even
 * numbers within a given range.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/generate-even-numbers-within-range/'>Generate even numbers</a>
 */
public class GenerateEvenNumbers {

	private static final Logger logger = Logger.getLogger(GenerateEvenNumbers.class);

	@Test
	public void generate_even_numbers_in_range_java8() {

		Set<Integer> evenNumbers = IntStream.rangeClosed(1, 10)
				.filter(n -> n % 2 == 0).boxed().collect(Collectors.toSet());

		logger.info(evenNumbers);

		assertThat(
				evenNumbers,
				contains(new Integer(2), new Integer(4), new Integer(6),
						new Integer(8), new Integer(10)));
	}

	@Test
	public void generate_even_numbers_in_range_guava() {

		Set<Integer> set = ContiguousSet.create(Range.closed(1, 10),
				DiscreteDomain.integers());

		Iterable<Integer> evenNumbers = Iterables.filter(set,
				new Predicate<Integer>() {
					@Override
					public boolean apply(Integer input) {
						return input % 2 == 0;
					}
				});


		assertThat(
				evenNumbers,
				contains(new Integer(2), new Integer(4), new Integer(6),
						new Integer(8), new Integer(10)));
	}

}
