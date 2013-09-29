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
 * This java example will demonstrate adding weeks to date.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/add-weeks-to-date/'>Add weeks to date</a>
 * 
 */
public class DatePlusWeeks {

	private static final Logger logger = Logger.getLogger(DatePlusWeeks.class);

	@Test
	public void add_weeks_to_date_in_java () {
		
		Calendar xmas = Calendar.getInstance();
		xmas.set(2012, 11, 25, 0, 0, 0);
		
		Calendar newYearsDay = Calendar.getInstance();
		newYearsDay.setTimeInMillis(xmas.getTimeInMillis());
		newYearsDay.add(Calendar.WEEK_OF_YEAR, 1);		
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(xmas.getTime()));
		logger.info(dateFormatter.format(newYearsDay.getTime()));

		assertTrue(newYearsDay.after(xmas));
		
	}

	@Test
	public void add_weeks_to_date_in_java_with_yoda () {

		DateTime xmas = new DateTime(2012, 12, 25, 0, 0, 0, 0);
		DateTime newYearsDay = xmas.plusWeeks(1);

		DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss z");
		
		logger.info(xmas.toString(fmt));
		logger.info(newYearsDay.toString(fmt));

		assertTrue(newYearsDay.isAfter(xmas));
	}

	@Test
	public void add_weeks_to_date_in_java_with_apachecommons () {

		Calendar xmas = Calendar.getInstance();
		xmas.set(2012, 11, 25, 0, 0, 0);
		
		Date newYearsDay = DateUtils.addWeeks(xmas.getTime(), 1);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(xmas.getTime()));
		logger.info(dateFormatter.format(newYearsDay));

		assertTrue(newYearsDay.after(xmas.getTime()));

	}

	
}
