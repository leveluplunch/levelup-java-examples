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
 * This java example will demonstrate adding days to date
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class DatePlusDays {

	private static final Logger logger = Logger.getLogger(DatePlusDays.class);

	
	@Test
	public void add_days_to_date_in_java () {
		
		Calendar superBowlXLV = Calendar.getInstance();
		superBowlXLV.set(2011, 1, 6, 0, 0);
		
		Calendar celebration = Calendar.getInstance();
		celebration.setTimeInMillis(superBowlXLV.getTimeInMillis());
		celebration.add(Calendar.DATE, 1);		
		
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(superBowlXLV.getTime()));
		logger.info(dateFormatter.format(celebration.getTime()));

		assertTrue(celebration.after(superBowlXLV));
		
	}

	
	@Test
	public void add_days_to_date_in_java_with_yoda () {

		DateTime superBowlXLV = new DateTime(2011, 2, 6, 0, 0, 0, 0);
		DateTime celebration = superBowlXLV.plusDays(1);

		DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss z");
		
		logger.info(superBowlXLV.toString(fmt));
		logger.info(celebration.toString(fmt));

		assertTrue(celebration.isAfter(superBowlXLV));
	}

	
	@Test
	public void add_days_to_date_in_java_with_apachecommons () {

		Calendar superBowlXLV = Calendar.getInstance();
		superBowlXLV.set(2011, 1, 6, 0, 0);
		
		Date celebration = DateUtils.addDays(superBowlXLV.getTime(), 1);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(superBowlXLV.getTime()));
		logger.info(dateFormatter.format(celebration));

		assertTrue(celebration.after(superBowlXLV.getTime()));

	}

	
}
