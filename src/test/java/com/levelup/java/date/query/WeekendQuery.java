package com.levelup.java.date.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate how to check if 
 * a date is Saturday or Sunday using TemporalQuery.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/weekend-temporal-query-java8/'>Weekend query</a>
 */
public class WeekendQuery implements TemporalQuery<Boolean> {

	/* (non-Javadoc)
	 * @see java.time.temporal.TemporalQuery#queryFrom(java.time.temporal.TemporalAccessor)
	 */
	@Override
	public Boolean queryFrom(TemporalAccessor date) {

		int dayOfWeekNumber = date.get(ChronoField.DAY_OF_WEEK);
		DayOfWeek dayOfWeek = DayOfWeek.of(dayOfWeekNumber);

		if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
			return Boolean.TRUE; 
		} else {
			return Boolean.FALSE; 
		}
	}
	
	@Test
	public void check_if_date_is_weekend () {
		
		LocalDate date = LocalDate.of(2014, 02, 02); // Sunday
		
		Boolean workDay = date.query(new WeekendQuery());

		assertTrue(workDay);
	}

	@Test
	public void filter_dates_by_weekend () {
		
		List<LocalDate> randomDays = Lists.newArrayList(
				LocalDate.of(2014, Month.FEBRUARY, 16), // Sunday
				LocalDate.of(2014, Month.APRIL, 19), // Saturday
				LocalDate.of(2014, Month.MAY, 30), // Friday
				LocalDate.of(2014, Month.DECEMBER, 12), // Friday
				LocalDate.of(2014, Month.DECEMBER, 17) // Wednesday
				);

		// filter weekend days 
		List<LocalDate> weekendDays = randomDays
				.stream()
				.filter(p -> p.query(new WeekendQuery()))
				.collect(Collectors.toList());
		
		assertEquals(2, weekendDays.size());
	}

	
}
