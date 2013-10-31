package com.levelup.java.date;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * Should test all facets of {@link CurrentQuarterGuava}
 * 
 * @author Justin Musgrove
 * 
 */
public class CurrentQuarterGuavaTest {
	
	private static final DateTime quarterBeginDate = new DateTime(2013, 1, 1, 0, 0, 0, 0);
	private static final DateTime quarterEndDate = new DateTime(2013, 3, 31, 0, 0, 0, 0);

	@Test
	public void current_quarter () {
		
		DateTime firstQuarterCheck = new DateTime(2013, 1, 15, 0, 0, 0, 0);
		
		CurrentQuarterGuava currentQuarterWithGuava = 
				new CurrentQuarterGuava(firstQuarterCheck.toDate());
		
		assertEquals(new Integer(1), 
				currentQuarterWithGuava.getQuarter());
	}

	@Test
	public void current_quarter_begin_date () {

		DateTime firstQuarterCheck = new DateTime(2013, 1, 15, 0, 0, 0, 0);

		CurrentQuarterGuava currentQuarterWithGuava = 
				new CurrentQuarterGuava(firstQuarterCheck.toDate());
		
		assertEquals(quarterBeginDate.toDate(), 
				currentQuarterWithGuava.getQuarterBeginDate());

	}

	@Test
	public void current_quarter_end_date () {

		DateTime firstQuarterCheck = new DateTime(2013, 1, 15, 0, 0, 0, 0);

		CurrentQuarterGuava currentQuarterWithGuava = 
				new CurrentQuarterGuava(firstQuarterCheck.toDate());
		
		assertEquals(quarterEndDate.toDate(), 
				currentQuarterWithGuava.getQuarterEndDate());

	}
}
