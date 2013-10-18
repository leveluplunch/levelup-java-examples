package com.levelup.java.number;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

import org.apache.commons.math3.primes.Primes;
import org.junit.Test;

/**
 * This java example will demonstrate determining if a
 * number is prime.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/determine-prime-number/'>Is prime number</a>
 * 
 */
public class NumberIsPrime {

	/**
	 * Method will determine if n is prime
	 * 
	 * @param n
	 * @return boolean
	 */
	boolean isPrime(int n) {

		if (n % 2 == 0) {
	    	return false;
	    } else {
		    for(int i=3; i*i <=n; i+=2) {
		        if(n % i == 0) {
		        	return false;
		        }
		    }
	    }
	    return true;
	}

	@Test
	public void determine_if_number_is_prime_java () {
		
		boolean isPrimeNumber = isPrime(5779);
		assertTrue(isPrimeNumber);
	}


	@Test
	public void determine_if_number_is_prime_java_big_integer () {
		
		Random rnd = new Random();
		BigInteger isPrimeNumber = BigInteger.probablePrime(3, rnd);
		
		assertEquals(5, isPrimeNumber.intValue());
	}

	
	@Test
	public void determine_if_number_is_prime_java_regular_expresison () {
		 
		char n = 5779;
		boolean isPrimeNumber = false;
		if (!new String(new char[n]).matches(".?|(..+?)\\1+")) {
			isPrimeNumber = true;
		}
		assertTrue(isPrimeNumber);
	}
	
	
	
	@Test
	public void determine_if_number_prime_with_apache_commons () {
		
		boolean isPrimeNumber = Primes.isPrime(5779);
		assertTrue(isPrimeNumber);
	}
	
	@Test
	public void find_next_prime_number_with_apache_commons () {
		
		int nextPrimeNumber = Primes.nextPrime(5780);
		
		assertEquals(5783, nextPrimeNumber);
	}
	
	@Test
	public void determine_prime_factors_of_a_number_with_apache_commons () {
		
		List<Integer> primeFactors = Primes.primeFactors(5782);
		
		assertThat(primeFactors, hasItems(2, 7, 7, 59));
	}
	
}
