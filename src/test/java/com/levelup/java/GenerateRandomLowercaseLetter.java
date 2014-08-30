package com.levelup.java;

import java.util.Random;

import org.junit.Test;

/**
 * This java example will demonstrate how to generate random lower case letter.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/generate-random-lowercase-letter/'>Generate
 *      random lowercase letter</a>
 */
public class GenerateRandomLowercaseLetter {

	@Test
	public void random_lowercase_java8() {

		Random random = new Random();
		random.ints(97, 126).limit(10)
				.forEach(a -> System.out.println(Character.toString((char) a)));

	}

}
