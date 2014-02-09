package com.levelup.java.date.query;

import static org.junit.Assert.assertEquals;
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
 * This java example will demonstrate how to 
 * determine if a date is a market day.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/market-day-temporal-query-java8/'>Market day query</a>
 */
public class MarketDayQuery implements TemporalQuery<Boolean> {

	static List<MonthDay> nyxHolidays = Lists.newArrayList(
			MonthDay.of(Month.JANUARY, 1), // New Years Day	January 1
			MonthDay.of(Month.JANUARY, 20), // Martin Luther King, Jr. Day	January 20
			MonthDay.of(Month.FEBRUARY, 17), // Washington's Birthday	February 17
			MonthDay.of(Month.APRIL, 18), // Good Friday	April 18
			MonthDay.of(Month.MAY, 26), // Memorial Day	May 26
			MonthDay.of(Month.JULY, 4), // Independence Day	July 4**
			MonthDay.of(Month.SEPTEMBER, 1), // Labor Day	September 1
			MonthDay.of(Month.NOVEMBER, 27), // Thanksgiving Day	November 27*
			MonthDay.of(Month.DECEMBER, 25) // Christmas	December 25***
	);
	
	/* (non-Javadoc)
	 * @see java.time.temporal.TemporalQuery#queryFrom(java.time.temporal.TemporalAccessor)
	 */
	@Override
	public Boolean queryFrom(TemporalAccessor date) {

		MonthDay currentMonthDay = MonthDay.from(date);
		
		return !nyxHolidays.contains(currentMonthDay);
	}
	

	@Test
	public void check_if_random_date_is_market_day() {
		
		LocalDate date = LocalDate.of(2014, 02, 02); // Sunday

		Boolean marketDay = date.query(new MarketDayQuery());

		assertTrue(marketDay);
	}
	
	
	@Test
	public void number_of_market_days_in_year () {
		
		int totalMarketDays = 0;
		for (LocalDate date = MonthDay.of(Month.JANUARY, 1).atYear(2014); 
				date.isBefore(MonthDay.of(Month.DECEMBER, 31).atYear(2014)); 
				date = date.plusDays(1)) {

			boolean isMarketDay = date.query(new MarketDayQuery());
			
			if (isMarketDay) { 
				totalMarketDays += 1;
			}
		}
		assertEquals(355, totalMarketDays);
	}
	

}
