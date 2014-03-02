package com.levelup.java.util.stream;

import static java.lang.Double.parseDouble;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import org.junit.Test;

/**
 * This java example will demonstrate .
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/java-util-stream-doublestream-example/'>DoubleStream example</a>
 */
public class DoubleStreamExample {

	@Test
	public void doublestream_builder() {

		double sum = DoubleStream.builder().add(10).add(10).build().sum();

		assertEquals(20, sum, 0);
	}

	@Test
	public void doublestream_concat() {

		DoubleStream first = DoubleStream.builder().add(10).build();
		DoubleStream second = DoubleStream.builder().add(10).build();

		DoubleStream third = DoubleStream.concat(first, second);

		assertEquals(20, third.sum(), 0);
	}

	@Test
	public void doublestream_empty() {

		DoubleStream emptyStream = DoubleStream.empty();

		assertEquals(0, emptyStream.count());
	}

	@Test
	public void doublestream_generate() {

		OptionalDouble one = DoubleStream.generate(() -> 1).limit(10)
				.distinct().findFirst();

		assertEquals(1, one.getAsDouble(), 0);
	}

	@Test
	public void doublestream_iterate() {

		List<Double> numbers = DoubleStream.iterate(0, n -> n + 3).limit(3)
				.boxed().collect(Collectors.toList());

		assertThat(numbers,
				contains(new Double(0), new Double(3), new Double(6)));
	}

	@Test
	public void doublestream_of() {

		OptionalDouble max = DoubleStream.of(5, 10).max();

		assertEquals(10, max.getAsDouble(), 0);
	}

	@Test
	public void map_to_doublestream() {

		List<String> doubles = new ArrayList<String>();
		doubles.add("1");
		doubles.add("2");
		doubles.add("3");

		OptionalDouble doubleStream = doubles.stream()
				.mapToDouble(Double::parseDouble).max();

		assertEquals(3, doubleStream.getAsDouble(), 0);
	}

	@Test
	public void convert_to_stream_of_objects() {

		double[] numbers = { 1, 2, 3, 4, 5, 6 };

		List<Double> listOfDoubles = Arrays.stream(numbers).boxed()
				.collect(Collectors.toList());

		assertThat(
				listOfDoubles,
				contains(new Double(1), new Double(2), new Double(3),
						new Double(4), new Double(5), new Double(6)));

	}

	@Test
	public void provide_default() {

		List<String> doubles = new ArrayList<String>();

		double optionalDouble = doubles.stream()
				.mapToDouble(Double::parseDouble).max().orElse(5);

		assertEquals(5, optionalDouble, 0);
	}

}
