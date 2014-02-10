package com.levelup.java.date.adjuster;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate getting the next 
 * company holiday.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/next-holiday-java8-adjuster/'>Next holiday adjuster</a>
 */
public class NextHolidayAdjuster implements TemporalAdjuster {

	static List<MonthDay> COMPANY_HOLIDAYS = Lists.newArrayList(
			MonthDay.of(Month.JANUARY, 1), // New Years Day	January 1
			MonthDay.of(Month.JANUARY, 20), // Martin Luther King, Jr. Day	January 20
			MonthDay.of(Month.APRIL, 18), // Good Friday	April 18
			MonthDay.of(Month.MAY, 26), // Memorial Day	May 26
			MonthDay.of(Month.JULY, 4), // Independence Day	July 4**
			MonthDay.of(Month.SEPTEMBER, 1), // Labor Day	September 1
			MonthDay.of(Month.NOVEMBER, 27), // Thanksgiving Day	November 27*
			MonthDay.of(Month.NOVEMBER, 28), // Day after thanksgiving November 28*
			MonthDay.of(Month.DECEMBER, 25), // Christmas	December 25***
			MonthDay.of(Month.DECEMBER, 26) // Day after xmas	December 26***
	);

	@Override
	public Temporal adjustInto(Temporal temporal) {

		MonthDay currentMonthDay = MonthDay.from(temporal);
		int year = temporal.get(ChronoField.YEAR);
		
		for (MonthDay element : COMPANY_HOLIDAYS) {
			if (currentMonthDay.isBefore(element)) {
				return element.atYear(year);
			}
		}
		
		// if it hasn't been returned, then return the first element
		return COMPANY_HOLIDAYS.get(0).atYear(year + 1);
	}
	
	@Test
	public void next_holiday () {
		
		LocalDate date = LocalDate.of(2009, Month.DECEMBER, 15);
		
		LocalDate nextHoliday = date.with(new NextHolidayAdjuster());

		assertEquals(
				LocalDate.of(2009, Month.DECEMBER, 25), 
				nextHoliday);
	}

	@Test
	public void next_holiday_next_year () {
		
		LocalDate date = LocalDate.of(2010, Month.DECEMBER, 26);
		
		LocalDate nextHoliday = date.with(new NextHolidayAdjuster());

		assertEquals(
				LocalDate.of(2011, Month.JANUARY, 1), 
				nextHoliday);
	}
	
}
