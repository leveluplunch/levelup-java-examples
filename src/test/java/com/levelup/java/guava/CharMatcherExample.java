package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.google.common.base.CharMatcher;

/**
 * This java example will demonstrate Google
 * Guava Charmatcher
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-charmatcher-example/'>Charmatcher example</a>
 * 
 */
public class CharMatcherExample {

	@Test
	public void remove_all_lower_case_from_string () {
		
		String allButLowerCase = CharMatcher.JAVA_LOWER_CASE
				.negate()
				.retainFrom("B-double E double R U-N beer run");
		
		assertEquals("B- E  R U-N  ", allButLowerCase);
	}
	
	@Test
	public void trim_leading_spaces_from_string () {
		
		String leftTrimmedString = CharMatcher.WHITESPACE
				.trimLeadingFrom("       Some String       ");
		
		assertEquals("Some String       ", leftTrimmedString);
	}
	
	@Test
	public void trim_trailing_spaces_from_string () {
		
		String rightTrimmedString = CharMatcher.WHITESPACE
				.trimTrailingFrom("       Some String       ");
		
		assertEquals("       Some String", rightTrimmedString);
	}
	
	@Test
	public void trim_all_spaces_from_string () {
		
		String trimmedString = CharMatcher.WHITESPACE
				.trimFrom("       Some String       ");
		
		assertEquals("Some String", trimmedString);
	}
	
	@Test
	public void remove_all_asterisk_from_string () {
		
		String stringWithoutAstricks = CharMatcher.is('*')
				.removeFrom("(* This is a comment.  The compiler will ignore it. *)");
		
		assertEquals("( This is a comment.  The compiler will ignore it. )", 
				stringWithoutAstricks);
	}
	
	@Test 
	public void validate_all_charachters_in_string_is_digit_or_letter () {
		
		boolean randomPharse = CharMatcher.JAVA_LETTER_OR_DIGIT
				.matchesAllOf("wefwewef3r343fwdSVD()I#KMFI");
		
		assertFalse(randomPharse);
	}
	
	@Test
	public void grade_within_passing_range () {
		
		boolean failedGrade = CharMatcher
				.inRange('A', 'C')
				.apply('F');
		
		assertFalse(failedGrade);
	}
	
	@Test
	public void obtain_digits_from_telephone_number () {
		
		String telephoneNumber = CharMatcher
				.inRange('0','9')
				.retainFrom("123-456-7890");
		
		assertEquals("1234567890", telephoneNumber);
		
		// worried about performance
		CharMatcher digits = CharMatcher
				.inRange('0','9')
				.precomputed();
		
		String teleNumber = digits.retainFrom("123-456-7890");
		assertEquals("1234567890", teleNumber);
	}
	
	@Test
	public void count_number_of_matching_chars () {
		
		int numberOfDigits = CharMatcher.DIGIT.countIn("123-LevelUpLunch");
		
		assertEquals(3, numberOfDigits);
	}
	
	@Test
	public void collapse_whitespace_dash () {
	
		String address = "505 Williams Street";
 
		String addressWithDash = CharMatcher.WHITESPACE.collapseFrom(address, '-');
		
		assertEquals("505-Williams-Street", addressWithDash);
	}
	
}
