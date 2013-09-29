package com.levelup.java.date.math;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * This java example will demonstrate subtracting milliseconds from date.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/subtract-milliseconds-from-date/'>Subtract milliseconds from date</a>
 * 
 */
public class DateMinusMilliseconds {
	
	private static final Logger logger = Logger.getLogger(DateMinusMilliseconds.class);

	@Test
	public void subtract_milliseconds_from_date_in_java () {
		
		Calendar newYearsDay = Calendar.getInstance();
		newYearsDay.set(2013, 0, 1, 0, 0, 0);
		
		Calendar newYearsEve = Calendar.getInstance();
		newYearsEve.setTimeInMillis(newYearsDay.getTimeInMillis());
		newYearsEve.add(Calendar.MILLISECOND, -100);		
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(newYearsDay.getTime()));
		logger.info(dateFormatter.format(newYearsEve.getTime()));

		assertTrue(newYearsEve.before(newYearsDay));
		
	}
	
	@Test
	public void subtract_milliseconds_from_date_in_java_with_yoda () {
		
		DateTime newYearsDay = new DateTime(2013, 1, 1, 0, 0, 0, 0);
		DateTime newYearsEve = newYearsDay.minusMillis(60);

		DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss S z");
		
		logger.info(newYearsDay.toString(fmt));
		logger.info(newYearsEve.toString(fmt));

		assertTrue(newYearsEve.isBefore(newYearsDay));
		
	}
	
	@Test
	public void subtract_milliseconds_from_date_in_java_apachecommons () {
		
		Calendar newYearsDay = Calendar.getInstance();
		newYearsDay.set(2013, 0, 1, 0, 0, 0);
		
		Date newYearsEve = DateUtils.addMilliseconds(newYearsDay.getTime(), -1000);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(newYearsDay.getTime()));
		logger.info(dateFormatter.format(newYearsEve));

		assertTrue(newYearsEve.before(newYearsDay.getTime()));

	}
	
}
