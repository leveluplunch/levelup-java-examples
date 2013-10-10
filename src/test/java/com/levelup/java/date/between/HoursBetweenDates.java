package com.levelup.java.date.between;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.junit.Test;

/**
 * This java example will demonstrate finding the 
 * number of hours between two dates.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/number-of-hours-between-dates/'>Number of hours between dates</a>
 * 
 */
public class HoursBetweenDates {

	// number-of-hours-between-dates
	
	@Test
	public void hours_between_two_dates_in_java_with_joda () {
		
		// start day is 1 day in the past
		DateTime startDate = new DateTime().minusDays(1);
		DateTime endDate = new DateTime();
		
		Hours hours = Hours.hoursBetween(startDate, endDate);
		int numberOfHours = hours.getHours();
		
		assertEquals(24, numberOfHours);
		
	}

	
}
