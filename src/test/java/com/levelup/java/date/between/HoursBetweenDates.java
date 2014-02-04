package com.levelup.java.date.between;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.junit.Test;

/**
 * This java example will demonstrate finding the 
 * number of hours between two dates.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/number-of-hours-between-two-dates/'>Number of hours between dates</a>
 * 
 */
public class HoursBetweenDates {

	@Test
	public void hours_between_two_dates_in_java_with_java8 () {
		
		LocalDateTime startDate = LocalDateTime.now().minusDays(1);
		LocalDateTime endDate = LocalDateTime.now();
		
		long numberOfHours = Duration.between(startDate, endDate).toHours();
		assertEquals(24, numberOfHours);
		
		// or
		
		long numberOfHours2 = ChronoUnit.HOURS.between(startDate, endDate);
		assertEquals(24, numberOfHours2);
	}

	
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
