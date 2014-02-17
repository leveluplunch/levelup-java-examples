package com.levelup.java.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate how to use IntSummaryStatistics.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/intsummarystatistics-example/'>IntSummaryStatistics example</a>
 */
public class IntSummaryStatisticsExample {

	class OrderEntry {

		int amount;

		public OrderEntry(int amount) {
			super();
			this.amount = amount;
		}

		public int getAmount() {
			return amount;
		}
	}

	List<OrderEntry> orderEntries;

	@Before
	public void setUp() {
		orderEntries = new ArrayList<>();
		orderEntries.add(new OrderEntry(10));
		orderEntries.add(new OrderEntry(14));
		orderEntries.add(new OrderEntry(12));
		orderEntries.add(new OrderEntry(18));
	}

	@Test
	public void int_summary_stats_with_stream() {

		IntSummaryStatistics stats = orderEntries.stream()
				.mapToInt((x) -> x.getAmount()).summaryStatistics();

		// average
		assertEquals(13.5, stats.getAverage(), 0);

		// count
		assertEquals(4, stats.getCount(), 0);

		// max
		assertEquals(18, stats.getMax(), 0);

		// min
		assertEquals(10, stats.getMin(), 0);

		// sum
		assertEquals(54, stats.getSum(), 0);
	}

	@Test
	public void int_summary_stats_stream_reduction_target() {

		IntSummaryStatistics stats = orderEntries.stream().collect(
				Collectors.summarizingInt(OrderEntry::getAmount));

		// average
		assertEquals(13.5, stats.getAverage(), 0);

		// count
		assertEquals(4, stats.getCount(), 0);

		// max
		assertEquals(18, stats.getMax(), 0);

		// min
		assertEquals(10, stats.getMin(), 0);

		// sum
		assertEquals(54, stats.getSum(), 0);
	}

}
