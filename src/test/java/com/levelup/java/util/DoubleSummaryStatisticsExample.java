package com.levelup.java.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate how to use 
 * DoubleSummaryStatistics.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/doublesummarystatistics-example/'>DoubleSummaryStatistics example</a>
 */
public class DoubleSummaryStatisticsExample {
	
	class Company {
		
		double revenue;
		
		public Company(double revenue) {
			super();
			this.revenue = revenue;
		}

		public double getRevenue() {
			return revenue;
		}
	}

	List<Company> companies;

	@Before
	public void setUp() {
		companies = new ArrayList<>();
		companies.add(new Company(100.12));
		companies.add(new Company(142.65));
		companies.add(new Company(12.1));
		companies.add(new Company(184.90));
	}
	
	
	@Test
	public void double_summary_stats_with_stream() {

		DoubleSummaryStatistics stats = companies.stream()
				.mapToDouble((x) -> x.getRevenue()).summaryStatistics();

		// average
		assertEquals(109.9425, stats.getAverage(), 0);

		// count
		assertEquals(4, stats.getCount(), 0);

		// max
		assertEquals(184.9, stats.getMax(), 0);
		
		// min
		assertEquals(12.1, stats.getMin(), 0);

		// sum
		assertEquals(439.77, stats.getSum(), 0);
	}
	
	@Test
	public void double_summary_stats_stream_reduction_target() {

		DoubleSummaryStatistics stats = companies.stream().collect(
				Collectors.summarizingDouble(Company::getRevenue));

		// average
		assertEquals(109.9425, stats.getAverage(), 0);

		// count
		assertEquals(4, stats.getCount(), 0);

		// max
		assertEquals(184.9, stats.getMax(), 0);
		
		// min
		assertEquals(12.1, stats.getMin(), 0);

		// sum
		assertEquals(439.77, stats.getSum(), 0);
	}
	
}
