package com.levelup.java.string;

import java.util.Random;

import org.junit.Test;

/**
 * This java example will demonstrate how to generate random vowel.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/generate-random-vowel/'>Genera
 *      t e random vowel</a>
 */
public class GenerateRandomVowel {

	@Test
	public void random_vowels_java() {

		char[] vowel = { 'a', 'e', 'i', 'o', 'u' };

		Random random = new Random(vowel.length);

		for (int x = 0; x < 10; x++) {
			int arrayElement = random.nextInt(vowel.length);
			System.out.println(vowel[arrayElement]);
		}
	}

	@Test
	public void generate_random_vowels_java8() {

		char[] vowel = { 'a', 'e', 'i', 'o', 'u' };

		Random random = new Random(vowel.length);

		random.ints(1, vowel.length).limit(10)
				.forEach(e -> System.out.println(vowel[e]));
	}

}
