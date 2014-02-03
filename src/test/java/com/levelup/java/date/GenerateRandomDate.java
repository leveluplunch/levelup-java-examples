package com.levelup.java.date;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

/**
 * This java example will demonstrate getting a random date within 
 * a given year.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/generate-random-date/'>Generate random date</a>
 * 
 */
public class GenerateRandomDate {

	private static final Logger logger = Logger.getLogger(GenerateRandomDate.class);

	private long beginTime;
	private long endTime;
	
	@Before
	public void setUp () {
		beginTime = Timestamp.valueOf("2013-01-01 00:00:00").getTime();
		endTime = Timestamp.valueOf("2013-12-31 00:58:00").getTime();
	}
	
	/**
	 * Method should generate random number that represents 
	 * a time between two dates.
	 * 
	 * @return
	 */
	private long getRandomTimeBetweenTwoDates () {
		long diff = endTime - beginTime + 1;
		return beginTime + (long) (Math.random() * diff);
	}
	
	@Test
	public void generate_random_date_java() {

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");

		for (int x = 0; x < 7; x++) {
			Date randomDate = new Date(getRandomTimeBetweenTwoDates());

			logger.info(dateFormat.format(randomDate));

			assertThat(
					randomDate.getTime(),
					allOf(lessThanOrEqualTo(endTime),
							greaterThanOrEqualTo(beginTime)));
		}
	}

	@Test
	public void generate_random_date_java8() {

	    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		
		for (int x = 0; x < 7; x++) {
			
			Instant instant = Instant.ofEpochSecond(getRandomTimeBetweenTwoDates());
			LocalDateTime randomDate = LocalDateTime.ofInstant(instant, ZoneId.of("UTC-06:00")); 

			logger.info(randomDate.format(format));

			assertThat(
					randomDate.atZone(ZoneId.of("UTC-06:00")).toEpochSecond(),
					allOf(lessThanOrEqualTo(endTime),
							greaterThanOrEqualTo(beginTime)));
		}
	}
	
	@Test
	public void generate_random_date_joda () {

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		for (int x=0; x < 7; x ++) {
			
			DateTime randomDate = new DateTime(getRandomTimeBetweenTwoDates());
			
			logger.info(dateFormat.format(randomDate.getMillis()));
			
			assertThat(
					randomDate.getMillis(),
					allOf(lessThanOrEqualTo(endTime),
							greaterThanOrEqualTo(beginTime)));
		}
	}
	
}
