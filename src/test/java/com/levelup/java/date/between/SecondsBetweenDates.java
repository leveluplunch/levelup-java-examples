package com.levelup.java.date.between;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.joda.time.DateTime;
import org.joda.time.Seconds;
import org.junit.Test;

/**
 * This java example will demonstrate finding the 
 * number of seconds between two dates.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/number-of-seconds-between-two-dates/'>Number of seconds between dates</a>
 * 
 */
public class SecondsBetweenDates {
	
	@Test
	public void seconds_between_two_dates_in_java_with_java8 () {
		
		LocalDateTime startDate = LocalDateTime.now().minusDays(1);
		LocalDateTime endDate = LocalDateTime.now();
		
		long secondsInDay = Duration.between(startDate, endDate).toMinutes()*60;
		assertEquals(86400, secondsInDay);

		// or
		
		long secondsInDay2 = ChronoUnit.SECONDS.between(startDate, endDate);
		assertEquals(86400, secondsInDay2);
	}
	
	@Test
	public void seconds_between_two_dates_in_java_with_joda () {

		// start day is 1 day in the past
		DateTime startDate = new DateTime().minusDays(1);
		DateTime endDate = new DateTime();
		
		Seconds seconds = Seconds.secondsBetween(startDate, endDate);
		
		int secondsInDay = seconds.getSeconds();
		
		assertEquals(86400, secondsInDay);
	}

}
