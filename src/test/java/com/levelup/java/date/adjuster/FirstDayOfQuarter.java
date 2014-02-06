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
 * This java example will demonstrate getting the 
 * the first day of the quarter.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/first-day-of-quarter-java8-adjuster/'>First day of quarter</a>
 */
public class FirstDayOfQuarter implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {

		int currentQuarter = YearMonth.from(temporal).get(
				IsoFields.QUARTER_OF_YEAR);

		if (currentQuarter == 1) {

			return LocalDate.from(temporal).with(
					TemporalAdjusters.firstDayOfYear());

		} else if (currentQuarter == 2) {

			return LocalDate.from(temporal).withMonth(Month.APRIL.getValue())
					.with(TemporalAdjusters.firstDayOfMonth());

		} else if (currentQuarter == 3) {

			return LocalDate.from(temporal).withMonth(Month.JULY.getValue())
					.with(TemporalAdjusters.firstDayOfMonth());

		} else {

			return LocalDate.from(temporal).withMonth(Month.OCTOBER.getValue())
					.with(TemporalAdjusters.firstDayOfMonth());

		}
	}
	
	@Test
	public void first_quarter_first_day () {
		
		LocalDate date = LocalDate.of(2009, Month.FEBRUARY, 1);
		
		LocalDate firstQuarter = date.with(new FirstDayOfQuarter());
		
		assertEquals(
				LocalDate.of(2009, Month.JANUARY, 1), 
				firstQuarter);
	}

	@Test
	public void second_quarter_first_day () {
		
		LocalDate date = LocalDate.of(2009, Month.JUNE, 1);
		
		LocalDate secondQuarter = date.with(new FirstDayOfQuarter());
		
		assertEquals(
				LocalDate.of(2009, Month.APRIL, 1), 
				secondQuarter);
	}
	
	@Test
	public void third_quarter_first_day () {

		LocalDate date = LocalDate.of(2009, Month.SEPTEMBER, 1);
		
		LocalDate thirdQuarter = date.with(new FirstDayOfQuarter());
		
		assertEquals(
				LocalDate.of(2009, Month.JULY, 1), 
				thirdQuarter);
	}

	@Test
	public void fourth_quarter_first_day () {

		LocalDate date = LocalDate.of(2009, Month.NOVEMBER, 1);
		
		LocalDate fourthQuarter = date.with(new FirstDayOfQuarter());
		
		assertEquals(
				LocalDate.of(2009, Month.OCTOBER, 1), 
				fourthQuarter);
	}
}
