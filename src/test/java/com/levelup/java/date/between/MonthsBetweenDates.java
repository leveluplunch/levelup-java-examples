package com.levelup.java.date.between;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.junit.Test;

/**
 * This java example will demonstrate finding the 
 * number of months between two dates.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/number-of-months-between-two-dates/'>Number of months between dates</a>
 * 
 */
public class MonthsBetweenDates {

	@Test
	public void months_between_two_dates_in_java_with_joda () {

		DateTime start = new DateTime(2005, 1, 1, 0, 0, 0, 0);
		DateTime end = new DateTime(2006, 1, 1, 0, 0, 0, 0);

		Months months = Months.monthsBetween(start, end);
		
		int monthsInYear = months.getMonths();
		
		assertEquals(12, monthsInYear);
	}
	
}
