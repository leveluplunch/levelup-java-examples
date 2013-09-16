package com.levelup.java.date;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * This java snippet will demonstrate formatting a date of January 15, 1967.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/format-date/'></a>
 * 
 */
public class FormatDate {
	
	@Test
	public void format_date_in_java () {
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 15);
		cal.set(Calendar.YEAR, 1967);

		// http://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
		String dateFirstSuperBowlWasPlayed = dateFormatter.format(cal.getTime());
		
		// dateFirstSuperBowlWasPlayed = 01/15/1967
		assertEquals("01/15/1967", dateFirstSuperBowlWasPlayed);
		
	}
	
	@Test
	public void format_date_in_java_with_yoda () {
		
		DateTime dateFirstSuperBowlWasPlayed = new DateTime(1967, 1, 15, 0, 0);

		DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy");
		
		assertEquals("01/15/1967", dateFirstSuperBowlWasPlayed.toString(fmt));

	}
	
	@Test
	public void format_date_in_java_with_apachecommons () {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 15);
		cal.set(Calendar.YEAR, 1967);

		String dateFirstSuperBowlWasPlayed = DateFormatUtils.format(cal, "MM/dd/yyyy");
		assertEquals("01/15/1967", dateFirstSuperBowlWasPlayed);
	}
	
	

}
