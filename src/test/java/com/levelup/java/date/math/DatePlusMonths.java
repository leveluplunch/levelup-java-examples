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
 * This java snippet will demonstrate adding months to a date
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/add-months-to-date/'>Add months to date</a>
 * 
 */
public class DatePlusMonths {
	
	private static final Logger logger = Logger.getLogger(DatePlusMonths.class);

	@Test
	public void add_months_to_date_in_java () {
		
		Calendar superBowlXLV = Calendar.getInstance();
		superBowlXLV.set(2011, 1, 6, 0, 0);
		
		Calendar sippinFruityDrinksInMexico = Calendar.getInstance();
		sippinFruityDrinksInMexico.setTimeInMillis(superBowlXLV.getTimeInMillis());
		sippinFruityDrinksInMexico.add(Calendar.MONTH, 1);		
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(superBowlXLV.getTime()));
		logger.info(dateFormatter.format(sippinFruityDrinksInMexico.getTime()));

		assertTrue(sippinFruityDrinksInMexico.after(superBowlXLV));

	}

	
	@Test
	public void add_months_to_date_in_java_yoda () {
		
		DateTime superBowlXLV = new DateTime(2011, 2, 6, 0, 0, 0, 0);
		DateTime sippinFruityDrinksInMexico = superBowlXLV.plusMonths(1);

		DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss z");
		
		logger.info(superBowlXLV.toString(fmt));
		logger.info(sippinFruityDrinksInMexico.toString(fmt));

		assertTrue(sippinFruityDrinksInMexico.isAfter(superBowlXLV));

	}
	
	@Test
	public void add_months_to_date_in_java_apachecommons () {
		
		Calendar superBowlXLV = Calendar.getInstance();
		superBowlXLV.set(2011, 1, 6, 0, 0);
		
		Date sippinFruityDrinksInMexico = DateUtils.addMonths(superBowlXLV.getTime(), 1);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");

		logger.info(dateFormatter.format(superBowlXLV.getTime()));
		logger.info(dateFormatter.format(sippinFruityDrinksInMexico));

		assertTrue(sippinFruityDrinksInMexico.after(superBowlXLV.getTime()));		
	}


	
}
