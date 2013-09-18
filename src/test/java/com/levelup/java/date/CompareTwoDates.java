package com.levelup.java.date;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.chrono.GregorianChronology;
import org.junit.Test;

/**
 * This java snippet will demonstrate how to compare two dates
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class CompareTwoDates {
	
	@Test
	public void compare_two_dates_java () {
		
		Calendar sinceGraduation = Calendar.getInstance();
		sinceGraduation.set(Calendar.YEAR, 1984);
		sinceGraduation.set(Calendar.MONTH, 6);
		sinceGraduation.set(Calendar.DAY_OF_MONTH, 4);
		
		Calendar today = Calendar.getInstance();
		
		assertTrue(today.after(sinceGraduation));
	}
	
	@Test
	public void compare_two_dates_with_yoda () {
		
		DateTime sinceGraduation = new DateTime(1984, 6, 4, 0, 0, GregorianChronology.getInstance());
		DateTime today = new DateTime(); //current date
		
		assertTrue(today.isAfter(sinceGraduation));
	}
	
	@Test
	public void compare_two_Dates_apachecommons () {

		Calendar sinceGraduation = Calendar.getInstance();
		sinceGraduation.set(Calendar.YEAR, 1984);
		sinceGraduation.set(Calendar.MONTH, 6);
		sinceGraduation.set(Calendar.DAY_OF_MONTH, 4);
		
		Calendar today = Calendar.getInstance();

		// in this instance we will use a truncate
		
		int val = DateUtils.truncatedCompareTo(sinceGraduation, today, Calendar.MINUTE);
		
		assertTrue(val <= 0);
	}
	
	
}
