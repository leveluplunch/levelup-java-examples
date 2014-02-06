package com.levelup.java.date.adjuster;

import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

/**
 * This java example will demonstrate predefined java 8 month adjusters.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/predefined-java-8-month-adjusters/'>Predefined java 8 month adjusters</a>
 */
public class MonthAdjusters {

	@Test
	public void first_day_of_month() {

		LocalDate date = LocalDate.of(1955, Month.FEBRUARY, 11);

		LocalDate firstDayOfMonth = date.with(TemporalAdjusters
				.firstDayOfMonth());

		assertEquals(LocalDate.of(1955, Month.FEBRUARY, 1), firstDayOfMonth);
	}

	@Test
	public void first_day_of_next_month() {

		LocalDate date = LocalDate.of(1955, Month.MARCH, 11);

		LocalDate firstDayOfMonth = date.with(TemporalAdjusters
				.firstDayOfNextMonth());

		assertEquals(LocalDate.of(1955, Month.APRIL, 1), firstDayOfMonth);
	}

	@Test
	public void first_in_month() {

		LocalDate date = LocalDate.of(1955, Month.MAY, 11);

		LocalDate firstMondayInMonth = date.with(TemporalAdjusters
				.firstInMonth(DayOfWeek.MONDAY));

		assertEquals(LocalDate.of(1955, Month.MAY, 2), firstMondayInMonth);
	}

	@Test
	public void last_day_of_month() {

		LocalDate date = LocalDate.of(1955, Month.JUNE, 11);

		LocalDate firstMondayInMonth = date.with(TemporalAdjusters
				.lastDayOfMonth());

		assertEquals(LocalDate.of(1955, Month.JUNE, 30), firstMondayInMonth);
	}

	@Test
	public void last_in_month() {

		LocalDate date = LocalDate.of(1955, Month.JULY, 11);

		LocalDate firstMondayInMonth = date.with(TemporalAdjusters
				.lastInMonth(DayOfWeek.TUESDAY));

		assertEquals(LocalDate.of(1955, Month.JULY, 26), firstMondayInMonth);
	}

}
