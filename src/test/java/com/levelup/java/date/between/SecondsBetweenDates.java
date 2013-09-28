package com.levelup.java.date.between;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.Seconds;
import org.junit.Test;

/**
 * This java example will demonstrate finding the 
 * number of seconds between two dates.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/number-of-seconds-between-dates/'>Number of seconds between dates</a>
 * 
 */
public class SecondsBetweenDates {
	
	@Test
	public void seconds_between_two_dates_in_java_with_yoda () {

		// start day is 1 day in the past
		DateTime startDate = new DateTime().minusDays(1);
		DateTime endDate = new DateTime();
		
		Seconds seconds = Seconds.secondsBetween(startDate, endDate);
		
		int secondsInDay = seconds.getSeconds();
		
		assertEquals(86400, secondsInDay);
		
	}

}
