package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 * This java example will use Google Guava RangeMap to 
 * demonstrate grade scale.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-rangemap-example/'>Range Map Example</a>
 * 
 */
public class RangeMapExample {

	@Test
	public void google_guava_range_map_example () {
	
		RangeMap<Integer, String> gradeScale = TreeRangeMap.create();
		gradeScale.put(Range.closed(0, 60), "F");
		gradeScale.put(Range.closed(61, 70), "D");
		gradeScale.put(Range.closed(71, 80), "C");
		gradeScale.put(Range.closed(81, 90), "B");
		gradeScale.put(Range.closed(91, 100), "A");
		
		String grade = gradeScale.get(77);
		
		assertEquals("C", grade);
	}
	
}
