package com.levelup.java.date.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
 * This java example will demonstrate using Java 8 
 * TemporalQuery.  
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/workday-temporal-query-java8/'>Work day query</a>
 */
public class WorkDayQuery implements TemporalQuery<Boolean>{

	/* 
	 * 
	 * (non-Javadoc)
	 * @see java.time.temporal.TemporalQuery#queryFrom(java.time.temporal.TemporalAccessor)
	 */
	@Override
	public Boolean queryFrom(TemporalAccessor date) {
		
		int dayOfWeekNumber = date.get(ChronoField.DAY_OF_WEEK);
		DayOfWeek dayOfWeek = DayOfWeek.of(dayOfWeekNumber);
		
		if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
			return Boolean.FALSE; 
		} else {
			return Boolean.TRUE; 
		}
	}

	
	@Test
	public void work_day_query () {
		
		LocalDate date = LocalDate.of(2014, Month.FEBRUARY, 02); // Sunday
		
		Boolean workDay = date.query(new WorkDayQuery());
		
		assertFalse(workDay);
	}
	
	@Test
	public void work_day_query_lambda () {
		
		List<LocalDate> randomDays = Lists.newArrayList(
				LocalDate.of(2014, Month.FEBRUARY, 16), // Sunday
				LocalDate.of(2014, Month.APRIL, 19), // Saturday
				LocalDate.of(2014, Month.MAY, 30), // Friday
				LocalDate.of(2014, Month.DECEMBER, 12), // Friday
				LocalDate.of(2014, Month.DECEMBER, 17) // Wednesday
				);
		
		// filter work days from random days 
		List<LocalDate> workDays = randomDays
				.stream()
				.filter(p -> p.query(new WorkDayQuery()))
				.collect(Collectors.toList());
		
		assertEquals(3, workDays.size());
	}
	
}
