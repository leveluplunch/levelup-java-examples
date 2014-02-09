package com.levelup.java.date.query;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate checking to 
 * see if a date or temporal object is a company holiday.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/company-holiday-temporal-query-java8/'>Company holiday query</a>
 */
public class CompanyHolidayQuery implements TemporalQuery<Boolean> {
	
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
	
	/* (non-Javadoc)
	 * @see java.time.temporal.TemporalQuery#queryFrom(java.time.temporal.TemporalAccessor)
	 */
	@Override
	public Boolean queryFrom(TemporalAccessor date) {

		MonthDay currentMonthDay = MonthDay.from(date);
		
		return COMPANY_HOLIDAYS.contains(currentMonthDay);
	}

	@Test
	public void is_date_a_holiday () {
		
		LocalDate date = LocalDate.of(2014, Month.DECEMBER, 25); // XMAS

		Boolean isHoliday = date.query(new CompanyHolidayQuery());
		
		assertTrue(isHoliday);
	}
	
	@Test
	public void is_not_date_a_holiday () {
		
		LocalDate date = LocalDate.of(2014, Month.NOVEMBER, 22);

		Boolean isHoliday = date.query(new CompanyHolidayQuery());
		
		assertFalse(isHoliday);
	}
	
}
