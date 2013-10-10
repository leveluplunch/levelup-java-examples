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
 * This java example will demonstrate subtracting days from a date.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/subtract-days-from-date/'>Subtract days from date</a>
 * 
 */
public class DateMinusDays {

	private static final Logger logger = Logger.getLogger(DateMinusDays.class);


	@Test
	public void subtract_days_from_date_in_java () {
		
		Calendar superBowlXLV = Calendar.getInstance();
		superBowlXLV.set(2011, 1, 6, 0, 0);
		
		Calendar pregame = Calendar.getInstance();
		pregame.setTimeInMillis(superBowlXLV.getTimeInMillis());
		pregame.add(Calendar.DATE, -1);		
		
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(superBowlXLV.getTime()));
		logger.info(dateFormatter.format(pregame.getTime()));

		assertTrue(pregame.before(superBowlXLV));
		
	}

	@Test
	public void subtract_days_from_date_in_java_joda () {
		
		DateTime superBowlXLV = new DateTime(2011, 2, 6, 0, 0, 0, 0);
		DateTime pregame = superBowlXLV.minusDays(1);

		DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss z");
		
		logger.info(superBowlXLV.toString(fmt));
		logger.info(pregame.toString(fmt));

		assertTrue(pregame.isBefore(superBowlXLV));
		
	}
	
	@Test
	public void subtract_days_from_date_in_java_apachecommons () {
		
		Calendar superBowlXLV = Calendar.getInstance();
		superBowlXLV.set(2011, 1, 6, 0, 0);
		
		Date pregame = DateUtils.addDays(superBowlXLV.getTime(), -1);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(superBowlXLV.getTime()));
		logger.info(dateFormatter.format(pregame));

		assertTrue(pregame.before(superBowlXLV.getTime()));

	}


	
}
