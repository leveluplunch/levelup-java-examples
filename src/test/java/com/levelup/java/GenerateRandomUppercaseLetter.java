package com.levelup.java;

import java.util.Random;

import org.junit.Test;

/**
 * This java example will demonstrate how to generate random upper case letter.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/generate-random-uppercase-letter/'>Generate
 *      random upper case letter</a>
 */
public class GenerateRandomUppercaseLetter {

	@Test
	public void random_uppercase_java8() {

		Random random = new Random();
		random.ints(65, 90).limit(10)
				.forEach(a -> System.out.println(Character.toString((char) a)));

	}

}
