package com.levelup.java;

import static org.junit.Assert.assertTrue;

import java.security.SecureRandom;
import java.util.Random;

import org.junit.Test;

/** 
 * This java snippet will demonstrate generating a random number with java.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class GenerateRandomNumber {
	
//	Describe the differenc between securrandom and random
	
	@Test
	public void generate_random_number_with_java () {
		Random random = new Random();
		
		double randomNumber = random.nextInt(10);
		
		assertTrue(randomNumber <=10);
	}
	
	@Test
	public void generate_secure_random_number_with_java () {
		SecureRandom random = new SecureRandom();

		double randomNumber = random.nextInt(10);
		
		assertTrue(randomNumber <=10);

	}
	

}
