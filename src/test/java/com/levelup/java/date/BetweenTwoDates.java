package com.levelup.java.date;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Years;
import org.junit.Test;

/**
 * This java snippet will demonstrate day, months, years seconds between two dates
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class BetweenTwoDates {

	@Test
	public void days_between_two_dates_in_java_with_yoda () {
		
		// start day is 1 day in the past
		DateTime startDate = new DateTime().minusDays(1);
		DateTime endDate = new DateTime();
		
		Days d = Days.daysBetween(startDate, endDate);
		int days = d.getDays();
		
		assertEquals(1, days);
		
	}
	
	@Test
	public void months_between_two_dates_in_java_with_yoda () {

		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2006, 1, 1, 0, 0, 0, 0);

		Months months = Months.monthsBetween(start, end);
		
		assertEquals(12, months.getMonths());
	}

	@Test
	public void years_between_two_dates_in_java_with_yoda () {
		
		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2006, 1, 1, 0, 0, 0, 0);
		
		Years years = Years.yearsBetween(start, end);
		
		assertEquals(1, years.getYears());

	}

	@Test
	public void seconds_between_two_dates_in_java_with_yoda () {

		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2006, 1, 1, 0, 0, 0, 0);
		
		Seconds seconds = Seconds.secondsBetween(start, end);
		
		assertEquals(32140800, seconds.getSeconds());
		
	}
	
}
