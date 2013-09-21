package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

/**
 * This java snippet will demonstrate examples of 
 * Google Guava Splitter
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class SplitterExample {

	@Test
	public void split_string_to_list_using_delimiter () {
		
		List<String> oakTrees =  
			Splitter.on(',')
				.trimResults()
				.omitEmptyStrings()
				.splitToList("Granit Oak, Bartek, Gernikako Arbola, Queen Elizabeth Oak, Kongeegen (the King Oak), Chêne chapelle, Poltava Oak,,,");
		
		assertEquals(7, oakTrees.size());
	}
	
	@Test
	public void split_string_to_list_using_charmatchers () {

		List<String> abcs123s = Splitter.on(CharMatcher.anyOf(";,.)"))
				.trimResults()
				.omitEmptyStrings()
				.splitToList("a,b;c.d,e.f),g,h.i;j.1,2.3;4.5,6;7.8,9;0");
		
		assertEquals(20, abcs123s.size());
			
	}
	
	@Test
	public void split_string_using_regular_expresion () {
		List<String> splitOnLetter = Splitter.onPattern("a|b").splitToList("12312a31231b23123");

		assertEquals(3, splitOnLetter.size());
	}
	
	@Test
	public void split_string_to_list_using_fix_length () {
		List<String> digits = Splitter.fixedLength(1).splitToList("1234567890");
		
		assertEquals(10, digits.size());

	}
	
	
}
