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
 * This java example will demonstrate subtracting weeks from a date
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/subtract-weeks-from-date/'>Subtract weeks from date</a>
 * 
 */
public class DateMinusWeeks {
	
	private static final Logger logger = Logger.getLogger(DateMinusWeeks.class);

	@Test
	public void subtract_weeks_from_date_in_java () {
		
		Calendar newYearsDay = Calendar.getInstance();
		newYearsDay.set(2013, 0, 1, 0, 0, 0);
		
		Calendar xmas = Calendar.getInstance();
		xmas.setTimeInMillis(newYearsDay.getTimeInMillis());
		xmas.add(Calendar.WEEK_OF_YEAR, -1);		
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(newYearsDay.getTime()));
		logger.info(dateFormatter.format(xmas.getTime()));

		assertTrue(xmas.before(newYearsDay));
	}

	@Test
	public void subtract_weeks_from_date_in_java_with_joda () {
		
		DateTime newYearsDay = new DateTime(2013, 1, 1, 0, 0, 0, 0);
		DateTime xmas = newYearsDay.minusWeeks(1);

		DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss z");
		
		logger.info(newYearsDay.toString(fmt));
		logger.info(xmas.toString(fmt));

		assertTrue(xmas.isBefore(newYearsDay));
	}

	@Test
	public void subtract_weeks_from_date_in_java_apachecommons () {
		
		Calendar newYearsDay = Calendar.getInstance();
		newYearsDay.set(2013, 0, 1, 0, 0, 0);
		
		Date xmas = DateUtils.addWeeks(newYearsDay.getTime(), -1);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(newYearsDay.getTime()));
		logger.info(dateFormatter.format(xmas));

		assertTrue(xmas.before(newYearsDay.getTime()));
	}

	
}
