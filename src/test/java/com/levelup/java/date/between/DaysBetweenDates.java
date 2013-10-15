 package com.levelup.java.date.between;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Test;

/**
 * This java example will demonstrate finding the 
 * number of days between two dates.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/number-of-days-between-two-dates/'>Number of days between two dates</a>
 * 
 */
public class DaysBetweenDates {

	@Test
	public void days_between_two_dates_in_java_with_joda () {
		
		// start day is 1 day in the past
		DateTime startDate = new DateTime().minusDays(1);
		DateTime endDate = new DateTime();
		
		Days d = Days.daysBetween(startDate, endDate);
		int days = d.getDays();
		
		assertEquals(1, days);
	}

}
