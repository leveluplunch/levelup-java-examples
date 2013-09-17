package com.levelup.java.date;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Stopwatch;

/**
 * This java snippet will demonstrate calculating elapsed time in java.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class MeasureElapsedTime {

	// keywords = calculate date and time difference,

	private static final Logger logger = Logger.getLogger(MeasureElapsedTime.class);
	
	@Test
	public void calculate_elapsed_time_in_java () {
		
		long startTime = System.currentTimeMillis();
		
		// do something
		
		long estimatedTime = System.currentTimeMillis() - startTime;

		logger.info("time: " + estimatedTime); // <time: 4.000>

		assertTrue(estimatedTime >= 0);
	}
	
	@Test
	public void calculate_elapsed_time_nano_in_java () {
		
		long startTime = System.nanoTime();

		// do something
		
		long estimatedTime = System.nanoTime() - startTime;

		logger.info("time: " + estimatedTime); // <time: 4.000>
		
		assertTrue(estimatedTime >= 0);
	}
	
	@Test
	public void calculate_elapsed_time_in_guava() {
		Stopwatch stopwatch = Stopwatch.createStarted();
		stopwatch.stop(); // optional

		long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);

		logger.info("time: " + stopwatch); // <time: 4.000 μs>
		
		assertTrue(millis >= 0);

	}

	@Test
	public void calculate_elapsed_time_in_apache_commons () {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// do something
		
		stopWatch.stop();
		long millis = stopWatch.getNanoTime();

		logger.info("time: " + millis); // <time: 4.000>
		
		assertTrue(millis >= 0);
		
			
	}

}
