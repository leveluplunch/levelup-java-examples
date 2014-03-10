package com.levelup.java.date.query;

import static org.junit.Assert.assertTrue;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQuery;

import org.junit.Test;

/**
 * This java example will demonstrate determining if the date is within daylight
 * saving while using TemporalQuery.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/daylight-saving-query-java8/'>Daylight
 *      saving query</a>
 */
public class DaylightSavingQuery implements TemporalQuery<Boolean> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.time.temporal.TemporalQuery#queryFrom(java.time.temporal.
	 * TemporalAccessor)
	 */
	@Override
	public Boolean queryFrom(TemporalAccessor temporal) {

		LocalDate date = LocalDate.from(temporal);

		LocalDate secondSundayInMarch = LocalDate.from(date)
				.withMonth(Month.MARCH.getValue())
				.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY))
				.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

		LocalDate firstSundayInNovember = LocalDate.from(date)
				.withMonth(Month.NOVEMBER.getValue())
				.with(TemporalAdjusters.firstDayOfMonth())
				.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

		if (date.isAfter(secondSundayInMarch)
				|| date.isBefore(firstSundayInNovember)) {
			return true;
		} else {
			return false;
		}
	}

	@Test
	public void during_daylight_savings() {

		LocalDate date = LocalDate.of(2014, Month.JULY, 02);

		Boolean daylightSavings = date.query(new DaylightSavingQuery());

		assertTrue(daylightSavings);
	}

	@Test
	public void not_during_daylight_savings() {

		LocalDate date = LocalDate.of(2014, Month.DECEMBER, 02);

		Boolean daylightSavings = date.query(new DaylightSavingQuery());

		assertTrue(daylightSavings);
	}

}
