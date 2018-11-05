package com.levelup.java.date.format;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * This java example will demonstrate using 
 * java predefined date formats.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/predefined-date-formats/'>Predefined date formats</a>
 * 
 */
public class PredefinedDateFormats {
	
	private static final Logger logger = Logger.getLogger(PredefinedDateFormats.class);
	

	@Test
	public void format_date_predefined_default () {
		
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT);
		
		Date today = Date.from(Instant.now());
		
		logger.info(dateFormatter.format(today));
		
		assertThat(dateFormatter.format(today), containsString(","));
	}
	
	@Test
	public void format_date_predefined_short () {
		
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
		
		Date today = Date.from(Instant.now());
		
		logger.info(dateFormatter.format(today));

		assertThat(dateFormatter.format(today), containsString("/"));		
	}

	
	@Test
	public void format_date_predefined_medium () {
		
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
		
		Date today = Date.from(Instant.now());
		
		logger.info(dateFormatter.format(today));
		
		assertThat(dateFormatter.format(today), containsString(","));
	}

	@Test
	public void format_date_predefined_long () {
		
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.LONG);
		
		Date today = Date.from(Instant.now());
		
		logger.info(dateFormatter.format(today));
		
		assertThat(dateFormatter.format(today), containsString(","));
	}
	
	@Test
	public void format_date_predefined_full () {
		
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.FULL);
		
		Date today = Date.from(Instant.now());
		
		logger.info(dateFormatter.format(today));
		
		assertThat(dateFormatter.format(today), containsString(","));
	}
	
}
