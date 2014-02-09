package com.levelup.java.date.query;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

import org.junit.Test;

/**
 * This java example will show how to check if a date
 * or temporal is during hurricane season.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/hurricane-season-temporal-query-java8/'>Hurricane season query</a>
 */
public class HurricaneSeasonQuery implements TemporalQuery<Boolean> {

	/* (non-Javadoc)
	 * @see java.time.temporal.TemporalQuery#queryFrom(java.time.temporal.TemporalAccessor)
	 */
	@Override
	public Boolean queryFrom(TemporalAccessor temporal) {

		LocalDate date = LocalDate.from(temporal);
		
		MonthDay juneFirst = MonthDay.of(Month.JUNE.getValue(), 1);
		MonthDay novemberThirty = MonthDay.of(Month.NOVEMBER.getValue(), 30);
		
		if (date.isAfter(juneFirst.atYear(date.getYear())) 
				&& date.isBefore(novemberThirty.atYear(date.getYear()))) {
			return true;
		} else {
			return false;
		}
	}
	
	@Test
	public void is_before_hurricane_season () {

		LocalDate date = LocalDate.of(2014, Month.JANUARY, 02); 

		Boolean isHurricaneSeason = date.query(new HurricaneSeasonQuery());

		assertFalse(isHurricaneSeason);
	}

	@Test
	public void is_during_hurricane_season () {

		LocalDate date = LocalDate.of(2014, Month.JUNE, 30); 

		Boolean isHurricaneSeason = date.query(new HurricaneSeasonQuery());

		assertTrue(isHurricaneSeason);
	}
	
	@Test
	public void is_after_hurricane_season () {

		LocalDate date = LocalDate.of(2014, Month.DECEMBER, 30); 

		Boolean isHurricaneSeason = date.query(new HurricaneSeasonQuery());

		assertFalse(isHurricaneSeason);
	}
	
}
