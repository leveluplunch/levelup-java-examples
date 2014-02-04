package com.levelup.java.date;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This java example will demonstrate parsing a date strings
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/parse-date/'>Parse date</a>
 * 
 */
public class ParseDate {

	@Test
	public void parse_date_string_in_java () throws ParseException {
		
		String superBowlIIAsString = "January 14, 1968";
		
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT-0600"));
        Date superBowlIIAsDate = formatter.parse(superBowlIIAsString);

        assertEquals(-62013600000l, superBowlIIAsDate.getTime());
	}
	
	@Test
	public void parse_date_string_in_java8 () {
		
		java.time.format.DateTimeFormatter formatter =
                java.time.format.DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		
		String superBowlIIAsString = "January 14, 1968";

		LocalDate superBowlIIAsDate = LocalDate.parse(superBowlIIAsString, formatter);
		
        assertEquals(1968, superBowlIIAsDate.getYear());
	}

	@Test
	public void parse_date_string_in_java_with_joda () {
		
	    String superBowlIIAsString = "January 14, 1968";

	    DateTimeFormatter fmt = DateTimeFormat.forPattern("MMMM dd, yyyy")
	    		.withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT-0600")));

	    DateTime superBowlIIAsDate = fmt.parseDateTime(superBowlIIAsString);

        assertEquals(-62013600000l, superBowlIIAsDate.getMillis());
	}
	
	@Test
	@Ignore("Build fails due to timezone discrepancy")
	public void parse_date_string_in_java_with_apache_commons () throws ParseException {

	    String superBowlIIAsString = "January 14, 1968";

		Date superBowlIIAsDate = DateUtils.parseDate(superBowlIIAsString, "MMMM dd, yyyy");

        assertEquals(-62013600000l, superBowlIIAsDate.getTime());
	}

}
