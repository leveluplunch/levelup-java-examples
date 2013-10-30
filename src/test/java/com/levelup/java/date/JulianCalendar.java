package com.levelup.java.date;

import static org.junit.Assert.assertNotNull;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.JulianChronology;
import org.junit.Test;

/**
 * This java example will demonstrate creating
 * a Julian Calendar.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/julian-calendar/'>Julian Calendar</a>
 * 
 */
public class JulianCalendar {

	@Test
	public void create_julian_date_instance () {
		
		// Battle of Megiddo
		Chronology chrono = JulianChronology.getInstance();
		DateTime dateTime = new DateTime(1457, 5, 9, 0, 0, 0, 0, chrono);

		assertNotNull(dateTime);
	}
	
}
