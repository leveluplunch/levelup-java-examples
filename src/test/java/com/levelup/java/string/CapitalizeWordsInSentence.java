package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import java.text.BreakIterator;

import org.apache.commons.lang3.text.WordUtils;
import org.junit.Test;

/**
 * This java example will demonstrate capitalizing
 * the first letter of each word in a sentence.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/capitalize-words-in-sentence/'>Capitalize words in sentence</a>
 * 
 */
public class CapitalizeWordsInSentence {

	@Test
	public void capitalize_first_letter_of_sentence () { 
		
		String superWhyLyrics = "who’s got the power? The power to read.";
		String sentenceStartsWithCapital = Character
				.toUpperCase(superWhyLyrics.charAt(0)) + superWhyLyrics.substring(1);
		
		assertEquals("Who’s got the power? The power to read.", sentenceStartsWithCapital);	
	}

	/**
	 * There is gaps w/ this method such as, what if there is multiple 
	 * spaces between each, it automatically adds a space at the end, 
	 * etc.  
	 */
	@Test
	public void capitalize_each_word_in_sentence_java () {

		String superWhyexample = "Come along With the Super Readers.";
		
		String[] exampleSplit = superWhyexample.split(" ");
		
		StringBuffer sb = new StringBuffer();
		for (String word : exampleSplit) {
			sb.append(word.substring(0, 1).toUpperCase() + word.substring(1));
			sb.append(" ");
		}
		assertEquals("Come Along With The Super Readers. ", sb.toString());
	} 
	
	private static int nextWordStartAfter(int pos, String text) {
	     BreakIterator wb = BreakIterator.getWordInstance();
	     wb.setText(text);
	     int last = wb.following(pos);
	     int current = wb.next();
	     while (current != BreakIterator.DONE) {
	         for (int p = last; p < current; p++) {
	             if (Character.isLetter(text.codePointAt(p)))
	                 return last;
	         }
	         last = current;
	         current = wb.next();
	     }
	     return BreakIterator.DONE;
	 }	
	
	@Test
	public void capitalize_each_word_in_sentence_java_with_BreakIterator () {

		String nineTeenEightyFourQuote = "It was a bright cold day in April, "
				+ "and the clocks were striking thirteen.";

		StringBuffer wordCapitalSentence = new StringBuffer();
		int startPosition = 0, nextWordPosition = 0;
		String word = null;
		while (startPosition < nineTeenEightyFourQuote.length()) {
			
			nextWordPosition = nextWordStartAfter(startPosition, nineTeenEightyFourQuote);
			
			// check to see if there is a next word
			if (nextWordPosition == BreakIterator.DONE) {
				nextWordPosition = nineTeenEightyFourQuote.length();
			}
			
			// get the next word
			word = nineTeenEightyFourQuote.substring(startPosition, nextWordPosition);

			// upper case first letter of word
			wordCapitalSentence.append(word.substring(0, 1).toUpperCase() + word.substring(1));

			// set start to the next word position
			startPosition = nextWordPosition;
		}
		
		assertEquals("It Was A Bright Cold Day In April, And The Clocks Were Striking Thirteen.", 
				wordCapitalSentence.toString());
	}

	
	@Test
	public void capitalize_each_word_in_sentence_apache_commons () {
		
		String prideAndPrejudiceSentence = "It is a truth universally acknowledged, "
				+ "that a single man in possession of a good fortune, must be in want of a wife.";
		
		String eachWordCapitalized = WordUtils.capitalizeFully(prideAndPrejudiceSentence);
		
		assertEquals("It Is A Truth Universally Acknowledged, That A Single "
				+ "Man In Possession Of A Good Fortune, Must Be In Want Of A Wife.",
				eachWordCapitalized);
	}

	
}
