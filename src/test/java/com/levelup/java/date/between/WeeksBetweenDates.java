package com.levelup.java.date.between;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import org.joda.time.DateTime;
import org.joda.time.Weeks;
import org.junit.Test;

/**
 * This java example will demonstrate finding the 
 * number of weeks between two dates.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/number-of-weeks-between-two-dates/'>Number of weeks between dates</a>
 * 
 */
public class WeeksBetweenDates {

	@Test
	public void weeks_between_two_dates_in_java_with_java8 () {
		
		LocalDate startDate = LocalDate.of(2005, Month.JANUARY, 1);
		LocalDate endDate = LocalDate.of(2006, Month.JANUARY, 1);

		long weeksInYear = ChronoUnit.WEEKS.between(startDate, endDate);
		
		assertEquals(52, weeksInYear);
	}
	
	@Test
	public void weeks_between_two_dates_in_java_with_joda () {
		
		DateTime start = new DateTime(2005, 1, 1, 0, 0, 0, 0);
		DateTime end = new DateTime(2006, 1, 1, 0, 0, 0, 0);
		
		Weeks weeks = Weeks.weeksBetween(start, end);

		int weeksInYear = weeks.getWeeks();
		
		assertEquals(52, weeksInYear);
	}


}
