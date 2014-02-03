package com.levelup.java.date;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * This java example will demonstrate
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/first-day-in-year/'>First year in year</a>
 * 
 */
public class FirstDayInYear {

	private static final Logger logger = Logger.getLogger(GenerateRandomDate.class);
	
	@Test
	public void first_day_in_year_current_year_java8 () {
		
		LocalDate date = LocalDate.of(2014, Month.FEBRUARY, 01);

		LocalDate firstDayOfYear = date.with(TemporalAdjusters.firstDayOfYear());
		
		assertEquals(1, firstDayOfYear.getDayOfMonth());
	}
	
	@Test
	public void first_day_in_year_current_year_joda () {
		
		DateTime dateTime = new DateTime(2012, 1, 1, 0, 0, 0, 0);

		DateTime firstDayOfTheFirstWeek = dateTime
				.withWeekyear(dateTime.getYear()).withWeekOfWeekyear(1)
				.withDayOfWeek(1);
	
		logger.info(firstDayOfTheFirstWeek);
		
		assertEquals(2012, firstDayOfTheFirstWeek.getYear());
		assertEquals(1, firstDayOfTheFirstWeek.getMonthOfYear());
		assertEquals(2, firstDayOfTheFirstWeek.getDayOfMonth());
	}

	@Test
	public void first_day_in_year_prior_year_joda () {
		
		DateTime dateTime = new DateTime(2013, 1, 1, 0, 0, 0, 0);

		DateTime firstDayOfTheFirstWeek = dateTime
				.withWeekyear(dateTime.getYear()).withWeekOfWeekyear(1)
				.withDayOfWeek(1);	
		
		logger.info(firstDayOfTheFirstWeek);
		
		assertEquals(2012, firstDayOfTheFirstWeek.getYear());
		assertEquals(12, firstDayOfTheFirstWeek.getMonthOfYear());
		assertEquals(31, firstDayOfTheFirstWeek.getDayOfMonth());
	}

}
