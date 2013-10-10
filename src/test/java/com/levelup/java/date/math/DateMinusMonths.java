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
 * This java example will demonstrate subtracting months from a date
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/subtract-months-from-date/'>Subtract months from date</a>
 * 
 */
public class DateMinusMonths {
	
	private static final Logger logger = Logger.getLogger(DateMinusMonths.class);
	
	
	@Test
	public void subtract_months_from_date_in_java () {
		
		Calendar superBowlXLV = Calendar.getInstance();
		superBowlXLV.set(2011, 1, 6, 0, 0);
		
		Calendar championshipWeekend = Calendar.getInstance();
		championshipWeekend.setTimeInMillis(superBowlXLV.getTimeInMillis());
		championshipWeekend.add(Calendar.MONTH, -1);		
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(superBowlXLV.getTime()));
		logger.info(dateFormatter.format(championshipWeekend.getTime()));

		assertTrue(championshipWeekend.before(superBowlXLV));
	}

	
	@Test
	public void subtract_months_from_date_in_java_joda () {

		DateTime superBowlXLV = new DateTime(2011, 2, 6, 0, 0, 0, 0);
		DateTime championshipWeekend = superBowlXLV.minusMonths(1);

		DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss z");
		
		logger.info(superBowlXLV.toString(fmt));
		logger.info(championshipWeekend.toString(fmt));

		assertTrue(championshipWeekend.isBefore(superBowlXLV));

	}

	@Test
	public void subtract_months_from_date_in_java_apachecommons () {

		Calendar superBowlXLV = Calendar.getInstance();
		superBowlXLV.set(2011, 1, 6, 0, 0);
		
		Date championshipWeekend = DateUtils.addMonths(superBowlXLV.getTime(), -1);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(superBowlXLV.getTime()));
		logger.info(dateFormatter.format(championshipWeekend));

		assertTrue(championshipWeekend.before(superBowlXLV.getTime()));
		
	}


}
