package com.levelup.java.date;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * This java example will demonstrate how to find
 * the number days in a month.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/find-number-of-days-in-month/'>Days in month</a>
 */
public class DaysInMonth {

	@Test
	public void days_in_month_java() {
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 3);
		c.set(Calendar.DAY_OF_MONTH, 4);
		c.set(Calendar.YEAR, 2014);
		
		int numberOfDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);

		assertEquals(30, numberOfDays);
	}	
	
	
	@Test
	public void days_in_month_java8() {
		
		LocalDate date = LocalDate.of(2014, Month.APRIL, 01);

		int length = date.getMonth().length(true);
		
		assertEquals(30, length);
		
		int length2 = date.lengthOfMonth();
		
		assertEquals(30, length2);		
	}
	
	@Test
	public void days_in_month_joda() {
		
		DateTime dateTime = new DateTime(2014, 4, 3, 0, 0, 0, 0);
		
		int daysInMonth = dateTime.dayOfMonth().getMaximumValue();

		assertEquals(30, daysInMonth);		
	}


}
