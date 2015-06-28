package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.base.Joiner;

/**
 * This java example will demonstrate how to join strings with a hyphen.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/join-strings-with-hyphen-dash/'>Join strings with dash</a>
 */
public class JoinStringsHyphenDash {

	@Test
	public void join_strings_java8_string_joiner() {
	
		StringJoiner joiner = new StringJoiner("-");
	
		String stringsWithDash = joiner.add("53544").add("1234").toString();
	
		assertEquals("53544-1234", stringsWithDash);
	}
	
	@Test
	public void join_strings_java8_string_join() {
	
		String stringsWithHyphen = String.join("-", "53544", "1234");
	
		assertEquals("53544-1234", stringsWithHyphen);
	}
	
	@Test
	public void join_strings_guava() {
	
		String seperatedByDash = Joiner.on("-").join("53544", "1234");
	
		assertEquals("53544-1234", seperatedByDash);
	}
	
	@Test
	public void join_strings_apache() {
	
		String seperatedByHypen = StringUtils.join(
				Arrays.asList("53544", "1234"), "-");
	
		assertEquals("53544-1234", seperatedByHypen);
	}
}
