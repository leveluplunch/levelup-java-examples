package com.levelup.java.date;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;
import org.joda.time.chrono.GregorianChronology;
import org.junit.Test;

/**
 * This java example will demonstrate finding the difference between two dates.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class CaculateDateTimeDifference {

	private static final Logger logger = Logger.getLogger(CaculateDateTimeDifference.class);
	
	@Test
	public void difference_between_two_dates_java () {
		// not recommended, use JODA
	}
	
	@Test
	public void difference_between_two_dates_joda () {
		
		DateTime sinceGraduation = new DateTime(1984, 6, 4, 0, 0, GregorianChronology.getInstance());
		DateTime currentDate = new DateTime(); //current date

		Days diffInDays = Days.daysBetween(sinceGraduation, currentDate);
		Hours diffInHours = Hours.hoursBetween(sinceGraduation, currentDate);
		Minutes diffInMinutes = Minutes.minutesBetween(sinceGraduation, currentDate);
		Seconds seconds = Seconds.secondsBetween(sinceGraduation, currentDate);
		
		logger.info(diffInDays.getDays());
		logger.info(diffInHours.getHours());
		logger.info(diffInMinutes.getMinutes());
		logger.info(seconds.getSeconds());
		
		assertTrue(diffInDays.getDays() >= 10697);
		assertTrue(diffInHours.getHours() >= 256747);
		assertTrue(diffInMinutes.getMinutes() >= 15404876);
		assertTrue(seconds.getSeconds() >= 924292577);
	
	}

	@Test
	public void difference_between_two_dates_joda_duration () {

		DateTime sinceGraduation = new DateTime(1984, 6, 4, 0, 0, GregorianChronology.getInstance());
		DateTime currentDate = new DateTime(); //current date

		Duration duration = new Duration(sinceGraduation, currentDate);

		logger.info(duration.getStandardDays());
		logger.info(duration.getStandardHours());
		logger.info(duration.getStandardMinutes());
		logger.info(duration.getStandardSeconds());
		
		assertTrue(duration.getStandardDays() >= 10697);
		assertTrue(duration.getStandardHours() >= 256747);
		assertTrue(duration.getStandardMinutes() >= 15404876);
		assertTrue(duration.getStandardSeconds() >= 924292577);
		
	}

	
}
