package com.levelup.java.date;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;
import org.joda.time.chrono.GregorianChronology;
import org.junit.Test;

/**
 * This java example will demonstrate finding the difference between two dates.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/calculate-time-difference/'>Calculate time differnece</a>
 * 
 */
public class CalculateDateTimeDifference {

	private static final Logger logger = Logger.getLogger(CalculateDateTimeDifference.class);
	
	@Test
	public void difference_between_two_dates_java () {
		// not recommended, use JODA or java 8 time
	}

	@Test
	public void difference_between_two_dates_java8_period() {

		LocalDate sinceGraduation = LocalDate.of(1984, Month.JUNE, 4);
		LocalDate currentDate = LocalDate.now();

		Period betweenDates = Period.between(sinceGraduation, currentDate);

		int diffInDays = betweenDates.getDays();
		int diffInMonths = betweenDates.getMonths();
		int diffInYears = betweenDates.getYears();

		logger.info(diffInDays);
		logger.info(diffInMonths);
		logger.info(diffInYears);

		assertTrue(diffInDays >= anyInt());
		assertTrue(diffInMonths >= anyInt());
		assertTrue(diffInYears >= anyInt());
	}

	
	@Test
	public void difference_between_two_dates_java8_chrono_period() {

		LocalDate sinceGraduation = LocalDate.of(1984, Month.JUNE, 4);
		LocalDate currentDate = LocalDate.now();

		long diffInDays = ChronoUnit.DAYS.between(sinceGraduation, currentDate);
		long diffInMonths = ChronoUnit.MONTHS.between(sinceGraduation,
				currentDate);
		long diffInYears = ChronoUnit.YEARS.between(sinceGraduation,
				currentDate);

		logger.info(diffInDays);
		logger.info(diffInMonths);
		logger.info(diffInYears);

		assertTrue(diffInDays >= anyLong());
		assertTrue(diffInMonths >= anyLong());
		assertTrue(diffInYears >= anyLong());
	}

	@Test
	public void difference_between_two_dates_java8_duration() {

		LocalDateTime dateTime = LocalDateTime.of(1984, 6, 4, 0, 0);
		LocalDateTime dateTime2 = LocalDateTime.now();

		int diffInNano = java.time.Duration.between(dateTime, dateTime2)
				.getNano();
		long diffInSeconds = java.time.Duration.between(dateTime, dateTime2)
				.getSeconds();

		long diffInMilli = java.time.Duration.between(dateTime, dateTime2)
				.toMillis();
		long diffInMinutes = java.time.Duration.between(dateTime, dateTime2)
				.toMinutes();
		long diffInHours = java.time.Duration.between(dateTime, dateTime2)
				.toHours();

		logger.info(diffInNano);
		logger.info(diffInSeconds);
		logger.info(diffInMilli);
		logger.info(diffInMinutes);
		logger.info(diffInHours);

		assertTrue(diffInNano >= anyLong());
		assertTrue(diffInSeconds >= anyLong());
		assertTrue(diffInMilli >= anyLong());
		assertTrue(diffInMinutes >= anyLong());
		assertTrue(diffInHours >= anyLong());
	}

	@Test
	public void difference_between_two_dates_java8_chrono_duration() {

		LocalDateTime dateTime = LocalDateTime.of(1984, 6, 4, 0, 0);
		LocalDateTime dateTime2 = LocalDateTime.now();

		long diffInNano = ChronoUnit.NANOS.between(dateTime, dateTime2);
		long diffInSeconds = ChronoUnit.SECONDS.between(dateTime, dateTime2);

		long diffInMilli = ChronoUnit.MILLIS.between(dateTime, dateTime2);
		long diffInMinutes = ChronoUnit.MINUTES.between(dateTime, dateTime2);
		long diffInHours = ChronoUnit.HOURS.between(dateTime, dateTime2);

		logger.info(diffInNano);
		logger.info(diffInSeconds);
		logger.info(diffInMilli);
		logger.info(diffInMinutes);
		logger.info(diffInHours);

		assertTrue(diffInNano >= anyLong());
		assertTrue(diffInSeconds >= anyLong());
		assertTrue(diffInMilli >= anyLong());
		assertTrue(diffInMinutes >= anyLong());
		assertTrue(diffInHours >= anyLong());

	}
	
	@Test
	public void difference_between_two_dates_joda () {
		
		DateTime sinceGraduation = new DateTime(1984, 6, 4, 0, 0, GregorianChronology.getInstance());
		DateTime currentDate = new DateTime(); //current date

		Days diffInDays = Days.daysBetween(sinceGraduation, currentDate);
		Hours diffInHours = Hours.hoursBetween(sinceGraduation, currentDate);
		Minutes diffInMinutes = Minutes.minutesBetween(sinceGraduation, currentDate);
		Seconds seconds = Seconds.secondsBetween(sinceGraduation, currentDate);
		
		logger.info(diffInDays.getDays());
		logger.info(diffInHours.getHours());
		logger.info(diffInMinutes.getMinutes());
		logger.info(seconds.getSeconds());
		
		assertTrue(diffInDays.getDays() >= 10697);
		assertTrue(diffInHours.getHours() >= 256747);
		assertTrue(diffInMinutes.getMinutes() >= 15404876);
		assertTrue(seconds.getSeconds() >= 924292577);
	
	}

	@Test
	public void difference_between_two_dates_joda_duration () {

		DateTime sinceGraduation = new DateTime(1984, 6, 4, 0, 0, GregorianChronology.getInstance());
		DateTime currentDate = new DateTime(); //current date

		Duration duration = new Duration(sinceGraduation, currentDate);

		logger.info(duration.getStandardDays());
		logger.info(duration.getStandardHours());
		logger.info(duration.getStandardMinutes());
		logger.info(duration.getStandardSeconds());
		
		assertTrue(duration.getStandardDays() >= 10697);
		assertTrue(duration.getStandardHours() >= 256747);
		assertTrue(duration.getStandardMinutes() >= 15404876);
		assertTrue(duration.getStandardSeconds() >= 924292577);
	}

}
