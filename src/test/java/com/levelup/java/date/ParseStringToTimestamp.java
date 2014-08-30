package com.levelup.java.date;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import org.junit.Test;

/**
 * This java example will demonstrate how to convert a string into a timestamp.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-string-to-timestamp/'>Convert string to java.sql.Timestamp</a>
 */
public class ParseStringToTimestamp {

	@Test
	public void parse_string_timestamp_java() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss:SSS");

		Date parsedTimeStamp = dateFormat.parse("2014-08-22 15:02:51:580");

		Timestamp timestamp = new Timestamp(parsedTimeStamp.getTime());

		assertEquals(1408737771580l, timestamp.getTime());
	}

	@Test
	public void parse_date_string_in_java8() {

		LocalTime parsedTimeStamp = LocalTime.parse("01:06:45.170");

		assertEquals(1, parsedTimeStamp.getHour());
	}

}
