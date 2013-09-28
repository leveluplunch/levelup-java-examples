package com.levelup.java.date.between;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.Years;
import org.junit.Test;

/**
 * This java example will demonstrate finding the 
 * number of years between two dates.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/number-of-years-between-dates/'>Number of years between dates</a>
 * 
 */
public class YearsBetweenDates {

	@Test
	public void years_between_two_dates_in_java_with_yoda () {
		
		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2006, 1, 1, 0, 0, 0, 0);
		
		Years years = Years.yearsBetween(start, end);
		
		int numberOfYears = years.getYears();
		
		assertEquals(1, numberOfYears);

	}

	
}
