package com.levelup.java.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate how to use LongSummaryStatistics.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/longsummarystatistics-example/'>LongSummaryStatistics Example</a>
 */
public class LongSummaryStatisticsExample {

	class Shipment {

		long cost;

		public Shipment(long cost) {
			super();
			this.cost = cost;
		}

		public long getCost() {
			return cost;
		}
	}

	List<Shipment> shipments;

	@Before
	public void setUp() {
		shipments = new ArrayList<>();
		shipments.add(new Shipment(45));
		shipments.add(new Shipment(65));
		shipments.add(new Shipment(901));
		shipments.add(new Shipment(230));
	}

	@Test
	public void long_summary_stats_with_stream() {

		LongSummaryStatistics stats = shipments.stream()
				.mapToLong((x) -> x.getCost()).summaryStatistics();

		// average
		assertEquals(310.25, stats.getAverage(), 0);

		// count
		assertEquals(4, stats.getCount(), 0);

		// max
		assertEquals(901.0, stats.getMax(), 0);

		// min
		assertEquals(45.0, stats.getMin(), 0);

		// sum
		assertEquals(1241.0, stats.getSum(), 0);
	}

	@Test
	public void long_summary_stats_stream_reduction_target() {

		LongSummaryStatistics stats = shipments.stream().collect(
				Collectors.summarizingLong(Shipment::getCost));

		// average
		assertEquals(310.25, stats.getAverage(), 0);

		// count
		assertEquals(4, stats.getCount(), 0);

		// max
		assertEquals(901.0, stats.getMax(), 0);

		// min
		assertEquals(45.0, stats.getMin(), 0);

		// sum
		assertEquals(1241.0, stats.getSum(), 0);
	}

}
