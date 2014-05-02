package com.levelup.java.date.adjuster;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

import org.junit.Test;

import com.levelup.java.date.query.WeekendQuery;

/**
 * This java example will demonstrate ninety business days.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/ninety-day-weekend-java8-adjuster/'>90 Day Weekend Adjuster</a>
 */
public class NinetyDayWeekendAdjuster implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {

		LocalDateTime currentDateTime = LocalDateTime.from(temporal);

		LocalDateTime futureDate = LocalDateTime.from(temporal).plus(90,
				ChronoUnit.DAYS);

		for (LocalDateTime startDate = currentDateTime; startDate
				.isBefore(futureDate); startDate = startDate.plusDays(1)) {

			if (startDate.query(new WeekendQuery())) {
				futureDate = futureDate.plusDays(1);
			}
		}
		return futureDate;
	}

	@Test
	public void test() {

		LocalDateTime currentDateTime = LocalDateTime.of(2014, Month.APRIL, 30,
				0, 0);

		LocalDateTime adjustedDate = currentDateTime
				.with(new NinetyDayWeekendAdjuster());

		assertEquals(LocalDateTime.of(2014, Month.SEPTEMBER, 3, 0, 0),
				adjustedDate);

	}
}
