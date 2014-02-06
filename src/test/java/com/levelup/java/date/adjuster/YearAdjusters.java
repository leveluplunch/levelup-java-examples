package com.levelup.java.date.adjuster;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

/**
 * This java example will demonstrate predefined java 8 year
 * adjusters.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com//'></a>
 */
public class YearAdjusters {

	@Test
	public void first_day_of_next_year() {

		LocalDate date = LocalDate.of(1971, Month.AUGUST, 11);

		LocalDate firstDayOfMonth = date.with(TemporalAdjusters
				.firstDayOfNextYear());

		assertEquals(LocalDate.of(1972, Month.JANUARY, 1), firstDayOfMonth);
	}
	
	@Test
	public void first_day_of_year() {

		LocalDate date = LocalDate.of(1971, Month.SEPTEMBER, 11);

		LocalDate firstDayOfMonth = date.with(TemporalAdjusters
				.firstDayOfYear());

		assertEquals(LocalDate.of(1971, Month.JANUARY, 1), firstDayOfMonth);
	}
	
	@Test
	public void last_day_of_year() {

		LocalDate date = LocalDate.of(1971, Month.OCTOBER, 11);

		LocalDate firstDayOfMonth = date
				.with(TemporalAdjusters.lastDayOfYear());

		assertEquals(LocalDate.of(1971, Month.DECEMBER, 31), firstDayOfMonth);
	}
	
}
