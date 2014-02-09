package com.levelup.java.date.query;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

import org.junit.Test;

/**
 * This java example will demonstrate finding the current quarter.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/current-quarter-temporal-query-java8/'>Current quarter query</a>
 */
public class CurrentQuarterQuery implements TemporalQuery<Integer> {

	/* (non-Javadoc)
	 * @see java.time.temporal.TemporalQuery#queryFrom(java.time.temporal.TemporalAccessor)
	 */
	@Override
	public Integer queryFrom(TemporalAccessor date) {
		
		int month = date.get(ChronoField.MONTH_OF_YEAR);
		
		if (month <= Month.MARCH.getValue()) {
			return new Integer(1);
		} else if (month <= Month.JUNE.getValue()) {
			return new Integer(2);
		} else if (month <= Month.SEPTEMBER.getValue()) {
			return new Integer(3);
		} else {
			return new Integer(4);
		}
	}
	
	
	@Test
	public void validate_first_quarter () {
		
		LocalDate date = LocalDate.of(2014, Month.MARCH, 4); 

		Integer quarter = date.query(new CurrentQuarterQuery());
		
		assertEquals(new Integer(1), quarter);
	}

	
	@Test
	public void validate_second_quarter () {
		
		LocalDate date = LocalDate.of(2014, Month.MAY, 8); 

		Integer quarter = date.query(new CurrentQuarterQuery());
		
		assertEquals(new Integer(2), quarter);
	}

	
	@Test
	public void validate_third_quarter () {
		
		LocalDate date = LocalDate.of(2014, Month.SEPTEMBER, 2); 

		Integer quarter = date.query(new CurrentQuarterQuery());
		
		assertEquals(new Integer(3), quarter);
	}

	
	@Test
	public void validate_fourth_quarter () {
		
		LocalDate date = LocalDate.of(2014, Month.DECEMBER, 18); 

		Integer quarter = date.query(new CurrentQuarterQuery());
		
		assertEquals(new Integer(4), quarter);
	}
	
}
