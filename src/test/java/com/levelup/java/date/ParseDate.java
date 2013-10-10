package com.levelup.java.date;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * This java example will demonstrate parsing a date strings
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/parse-date-with-java/'>Parse date</a>
 * 
 */
public class ParseDate {

	@Test
	public void parse_date_string_in_java () throws ParseException {
		String superBowlIIAsString = "January 14, 1968";
		
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
        Date superBowlIIAsDate = formatter.parse(superBowlIIAsString);
        
        assertEquals(-62013600000l, superBowlIIAsDate.getTime());
	}

	@Test
	public void parse_date_string_in_java_with_joda () {
		
	    String superBowlIIAsString = "January 14, 1968";

	    DateTimeFormatter fmt = DateTimeFormat.forPattern("MMMM dd, yyyy");
	    DateTime superBowlIIAsDate = fmt.parseDateTime(superBowlIIAsString);

        assertEquals(-62013600000l, superBowlIIAsDate.getMillis());

	}
	
	@Test
	public void parse_date_string_in_java_with_apache_commons () throws ParseException {

	    String superBowlIIAsString = "January 14, 1968";

		Date superBowlIIAsDate = DateUtils.parseDate(superBowlIIAsString, "MMMM dd, yyyy");
		
        assertEquals(-62013600000l, superBowlIIAsDate.getTime());
	}

	
}
