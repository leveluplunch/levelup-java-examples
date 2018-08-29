package com.levelup.java.number;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * This java example will demonstrate how to generate 
 * random numbers from a range.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/generate-random-number-within-range/'>Generate random number in range</a>
 */
public class GenerateRandomNumberInRange {

	private static final Logger logger = Logger
			.getLogger(GenerateRandomNumberInRange.class);

	@Test
	public void generate_random_number_in_range_java() {
		
		int rangeUpper = 10;
		
		Random random = new Random();
		
		List<Integer> randomNumbers = new ArrayList<>();
		
		for (int x = 0; x < rangeUpper; x++) {
			randomNumbers.add(random.nextInt(rangeUpper));			
		}

		logger.info(randomNumbers);

		assertTrue(randomNumbers.size() == 10);
	}
	
	
	@Test
	public void generate_random_number_in_range_java8() {

		Random random = new Random(10);

		List<Integer> randomNumbers = random.ints(0, 10).limit(10).boxed()
				.collect(Collectors.toList());

		logger.info(randomNumbers);

		assertTrue(randomNumbers.size() == 10);
	}

	@Test
	public void generate_random_number_in_range_java7() {
	    double rangeMin = 500.0;
	    double rangeMax = 700.1;
        double randomInRange = ThreadLocalRandom.current().nextDouble(rangeMin, rangeMax);
        logger.info(randomInRange);
	}

}
