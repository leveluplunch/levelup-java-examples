package com.levelup.java.collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SumFirstXNumbersArrayList {

	List<Integer> numbers;

	@Before
	public void setUp() {

		numbers = new ArrayList<>();

		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);

	}

	@Test
	public void sum_n_values_java() {

		int sumNValues = 0;
		for (int x = 0; x < 5; x++) {
			sumNValues += numbers.get(x);
		}

		assertEquals(15, sumNValues);
	}

	@Test
	public void sum_n_values_java8() {

		int sumXValues = numbers.stream().mapToInt(Integer::intValue).limit(5)
				.sum();

		assertEquals(15, sumXValues);
	}

}
