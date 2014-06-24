package com.levelup.java.string;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * This java example will demonstrate how divide a string based on length and in between words.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/split-string-into-substring-length/'>Divide on words and length</a>
 */
public class SplitOnWordsAndLength {

	String val = "Start at position 179 of the string (or at the end if it isn't that long) and work backwards until you hit the end of a word or a period. Chop that segment off and throw it into"
			+ " your pot, then repeat until there's nothing left. Note that the end of a word can be followed by a space, or by a non-period punctuation mark like a comma, or by the end"
			+ " of the string. Be careful not to go past the end of the string in the latter case.";

	@Test
	public void splitWordAndLength() {

		StringBuilder sb = new StringBuilder();
		List<String> brokenStrings = new ArrayList<String>(); 
		
		BreakIterator boundary = BreakIterator.getWordInstance();
		boundary.setText(val);

		int start = boundary.first();
		for (int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary
				.next()) {
			
			int lengthOfNext = end - start; 
			
			if ((sb.length() + lengthOfNext) > 180) {
				brokenStrings.add(sb.toString());
				sb = new StringBuilder(); // or set to 0
			} 
			
			sb.append(val.substring(start, end));
			
			// if last element
			if (end == val.length()) {
				brokenStrings.add(sb.toString());
			}
		}
		
		for (String x : brokenStrings) {
			System.out.println(x);
		}
	}
}
