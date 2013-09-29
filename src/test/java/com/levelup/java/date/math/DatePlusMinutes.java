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
 * This java example will demonstrate adding minutes to date.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/add-minutes-to-date/'>Add minutes to date</a>
 * 
 */
public class DatePlusMinutes {

	private static final Logger logger = Logger.getLogger(DatePlusMinutes.class);

	@Test
	public void add_minutes_to_date_in_java () {
		
		Calendar newYearsEve = Calendar.getInstance();
		newYearsEve.set(2012, 11, 31, 23, 59, 0);
		
		Calendar newYearsDay = Calendar.getInstance();
		newYearsDay.setTimeInMillis(newYearsEve.getTimeInMillis());
		newYearsDay.add(Calendar.MINUTE, 1);		
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(newYearsEve.getTime()));
		logger.info(dateFormatter.format(newYearsDay.getTime()));

		assertTrue(newYearsDay.after(newYearsEve));
		
	}

	@Test
	public void add_minutes_to_date_in_java_with_yoda () {

		DateTime newYearsEve = new DateTime(2012, 12, 31, 23, 59, 0, 0);
		DateTime newYearsDay = newYearsEve.plusMinutes(1);

		DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss z");
		
		logger.info(newYearsEve.toString(fmt));
		logger.info(newYearsDay.toString(fmt));

		assertTrue(newYearsDay.isAfter(newYearsEve));
	}

	@Test
	public void add_minutes_to_date_in_java_with_apachecommons () {

		Calendar newYearsEve = Calendar.getInstance();
		newYearsEve.set(2012, 11, 31, 23, 59, 0);
		
		Date newYearsDay = DateUtils.addMinutes(newYearsEve.getTime(), 1);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(newYearsEve.getTime()));
		logger.info(dateFormatter.format(newYearsDay));

		assertTrue(newYearsDay.after(newYearsEve.getTime()));

	}

}
