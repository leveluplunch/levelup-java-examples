package com.levelup.java;

import static org.junit.Assert.assertTrue;

import java.security.SecureRandom;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.junit.Test;

/** 
 * This java example will demonstrate generating a random number with java.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/generate-random-number/'>Generate random number</a>
 * 
 */
public class GenerateRandomNumber {
	
	@Test
	public void generate_random_number_with_java () {
		Random random = new Random();
		
		int randomNumber = random.nextInt(10);
		
		assertTrue(randomNumber <=10);
	}

	@Test
	public void generate_secure_random_number_with_java () {
		SecureRandom random = new SecureRandom();

        int randomNumber = random.nextInt(10);

		assertTrue(randomNumber <=10);
	}

    @Test
    public void generate_random_number_ThreadLocalRandom() {
        int randomNumber = ThreadLocalRandom.current().nextInt(10);
        assertTrue(randomNumber <=10);
    }

    @Test
    public void generate_random_number_ThreadLocalRandom_in_range() {
	    int x = 40;
	    int y = 50;
        int randomNumber = ThreadLocalRandom.current().nextInt(y - x) + x;
        assertTrue(randomNumber >= x && randomNumber <= y);
    }
	
	@Test
	public void generate_single_random_number () {

		int randomNumber = (int)(Math.random() * 10);

		assertTrue(randomNumber < 10);
	}
	
	@Test
	public void generate_random_number_java8 () {

		Random random = new Random(10);

		OptionalInt randomNumber = random.ints(0, 10).findFirst();
		
		assertTrue(randomNumber.getAsInt() < 10);
	}

	@Test
	public void generate_random_integer_range_apache() {
        int leftLimit = 1;
        int rightLimit = 10;
        int randomInt = new RandomDataGenerator().nextInt(leftLimit, rightLimit);
        assertTrue( randomInt <= rightLimit);
    }
}
