package com.levelup.java.date.adjuster;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.IsoFields;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

/**
 * This java example will demonstrate getting the last day in the quarter.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/last-day-of-quarter-java8-adjuster/'>Last day of quarter</a>
 */
public class LastDayOfQuarter implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {

		int currentQuarter = YearMonth.from(temporal).get(
				IsoFields.QUARTER_OF_YEAR);

		if (currentQuarter == 1) {

			return LocalDate.from(temporal).withMonth(Month.MARCH.getValue())
					.with(TemporalAdjusters.lastDayOfMonth());

		} else if (currentQuarter == 2) {

			return LocalDate.from(temporal).withMonth(Month.JUNE.getValue())
					.with(TemporalAdjusters.lastDayOfMonth());

		} else if (currentQuarter == 3) {

			return LocalDate.from(temporal)
					.withMonth(Month.SEPTEMBER.getValue())
					.with(TemporalAdjusters.lastDayOfMonth());

		} else {

			return LocalDate.from(temporal).with(
					TemporalAdjusters.lastDayOfYear());
		}

	}

	@Test
	public void first_quarter_last_day() {

		LocalDate date = LocalDate.of(2009, Month.FEBRUARY, 1);

		LocalDate firstQuarter = date.with(new LastDayOfQuarter());

		assertEquals(LocalDate.of(2009, Month.MARCH, 31), firstQuarter);
	}

	@Test
	public void second_quarter_last_day() {

		LocalDate date = LocalDate.of(2009, Month.MAY, 1);

		LocalDate secondQuarter = date.with(new LastDayOfQuarter());

		assertEquals(LocalDate.of(2009, Month.JUNE, 30), secondQuarter);
	}

	@Test
	public void third_quarter_last_day() {

		LocalDate date = LocalDate.of(2009, Month.AUGUST, 1);

		LocalDate thirdQuarter = date.with(new LastDayOfQuarter());

		assertEquals(LocalDate.of(2009, Month.SEPTEMBER, 30), thirdQuarter);
	}

	@Test
	public void fourth_quarter_first_day() {

		LocalDate date = LocalDate.of(2009, Month.NOVEMBER, 1);

		LocalDate fourthQuarter = date.with(new LastDayOfQuarter());

		assertEquals(LocalDate.of(2009, Month.DECEMBER, 31), fourthQuarter);
	}

}
