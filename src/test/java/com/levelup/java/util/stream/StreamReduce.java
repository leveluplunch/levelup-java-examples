package com.levelup.java.util.stream;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate .
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/java-util-stream-reduce-example/'>Stream reduce</a>
 */
public class StreamReduce {

	class Precipitation {

		private LocalDate occurrence;
		private double amount;

		public Precipitation(LocalDate occurrence, double amount) {
			super();
			this.occurrence = occurrence;
			this.amount = amount;
		}

		public LocalDate getOccurrence() {
			return occurrence;
		}

		public double getAmount() {
			return amount;
		}
	}

	List<Precipitation> precip;

	@Before
	public void setUp() {

		precip = new ArrayList<>();

		precip.add(new Precipitation(LocalDate.of(2014, Month.JANUARY, 7), .25));
		precip.add(new Precipitation(LocalDate.of(2014, Month.FEBRUARY, 9), .10));
		precip.add(new Precipitation(LocalDate.of(2014, Month.FEBRUARY, 15),
				.50));
		precip.add(new Precipitation(LocalDate.of(2014, Month.MARCH, 9), 1.09));
	}

	@Test
	public void sum_elements() {

		double totalPrecipYear = precip.stream()
				.mapToDouble(Precipitation::getAmount).sum();

		assertEquals(1.9399999999999997, totalPrecipYear, 0);

		// or
		OptionalDouble totalPrecipYear2 = precip.stream()
				.mapToDouble(Precipitation::getAmount).reduce(Double::max);

		assertEquals(1.94, totalPrecipYear2.getAsDouble(), 0);
		
		// or 
		double totalPrecipYear3 = precip.stream()
				.mapToDouble(Precipitation::getAmount).reduce(0, (a, b) -> a + b);
		
		assertEquals(1.94, totalPrecipYear3, 0);
	}

	@Test
	public void max_elements() {

		OptionalDouble max = precip.stream()
				.mapToDouble(Precipitation::getAmount).max();

		assertEquals(1.09, max.getAsDouble(), 0);

		// or

		OptionalDouble max2 = precip.stream()
				.mapToDouble(Precipitation::getAmount).reduce(Double::max);

		assertEquals(1.09, max2.getAsDouble(), 0);
	}

	@Test
	public void min_elements() {

		OptionalDouble min = precip.stream()
				.mapToDouble(Precipitation::getAmount).min();

		assertEquals(.1, min.getAsDouble(), 0);

		// or

		OptionalDouble min2 = precip.stream()
				.mapToDouble(Precipitation::getAmount).reduce(Double::min);

		assertEquals(.1, min2.getAsDouble(), 0);
	}

}
