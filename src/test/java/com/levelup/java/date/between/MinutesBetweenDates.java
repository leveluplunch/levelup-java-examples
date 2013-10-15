package com.levelup.java.date.between;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.junit.Test;

/**
 * This java example will demonstrate finding the 
 * number of minutes between two dates.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/number-of-minutes-between-two-dates/'>Number of minutes between dates</a>
 * 
 */
public class MinutesBetweenDates {

	
	@Test
	public void minutes_between_two_dates_in_java_with_joda () {
		
		// start day is 1 day in the past
		DateTime startDate = new DateTime().minusDays(1);
		DateTime endDate = new DateTime();
		
		Minutes minutes = Minutes.minutesBetween(startDate, endDate);
		
		int numberOfMinutesInDay = minutes.getMinutes();
		
		assertEquals(1440, numberOfMinutesInDay);
	}
	
}
