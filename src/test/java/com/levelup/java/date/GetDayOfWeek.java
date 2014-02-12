package com.levelup.java.date;

import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.junit.Test;

/**
 * This java example will demonstrate .
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/get-day-of-week/'>Get day of week</a>
 */
public class GetDayOfWeek {

	@Test
	public void get_day_of_week_java () {
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.DAY_OF_MONTH, 4);
		cal.set(Calendar.YEAR, 2014);
	
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		assertEquals(Calendar.FRIDAY, dayOfWeek);
	}
	
	@Test
	public void get_day_of_week_java8 () {
		
		LocalDate date = LocalDate.of(2014, Month.APRIL, 4);
		
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		
		assertEquals(DayOfWeek.FRIDAY, dayOfWeek);
		
		// or 
		int dayOfWeek2 = dayOfWeek.get(ChronoField.DAY_OF_WEEK);
		
		assertEquals(DayOfWeek.FRIDAY.getValue(), dayOfWeek2);
		
		// or
		LocalDateTime localDateTime = LocalDateTime.of(2014, Month.APRIL, 4, 5, 4);
		
		DayOfWeek dayOfWeek3 = localDateTime.getDayOfWeek();
		
		assertEquals(DayOfWeek.FRIDAY, dayOfWeek3);
		
	}

	@Test
	public void get_day_of_week_joda () {
		
		DateTime dateTime = new DateTime(2014, 4, 4, 0, 0);

	    int dayOfWeek = dateTime.getDayOfWeek();
	    
	    assertEquals(DateTimeConstants.FRIDAY, dayOfWeek);
	}
	
}
