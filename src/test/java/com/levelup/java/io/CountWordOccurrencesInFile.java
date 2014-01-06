package com.levelup.java.io;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.io.Files;

/**
 * This java example will demonstrate how to count
 * distinct word occurrences in a file.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/count-distinct-word-occurrences-in-file/'>Count words in file</a>
 */
public class CountWordOccurrencesInFile {
	
	private static final Logger logger = Logger.getLogger(CountWordOccurrencesInFile.class);

	private static final String SOURCE = "com/levelup/java/io/word-occurrences-in-file.txt";

	private URI sourceFileURI;
	
	@Before
	public void setUp () throws URISyntaxException {
		sourceFileURI = this.getClass().getClassLoader().getResource(SOURCE).toURI();
	}
	
	@Test
	public void distinct_words_in_file_java() throws IOException {

		File file = new File(sourceFileURI);

		List<String> lines = java.nio.file.Files.readAllLines(
				Paths.get(file.toURI()), Charsets.UTF_8);

		Map<String, Integer> wordOccurrences = new HashMap<String, Integer>();

		// for each line in file
		for (String line : lines) {

			String[] words = line.split(" ");

			// for every word in file
			for (String word : words) {

				word = word.replace(".", "");

				if (!word.trim().isEmpty()) {
					if (wordOccurrences.containsKey(word)) {
						int count = wordOccurrences.get(word).intValue();
						wordOccurrences.put(word, new Integer(count + 1));
					} else {
						wordOccurrences.put(word, new Integer(1));
					}
				}
			}
		}

		logger.info(wordOccurrences);

		assertEquals(80, wordOccurrences.size());
	}

	/**
	 * Example was modified from the guava site to remove 
	 * periods
	 * 
	 * @throws IOException
	 */
	@Test 
	public void count_distinct_words_in_file_guava () throws IOException {

		File file = new File(sourceFileURI);
		
		Multiset<String> wordOccurrences = HashMultiset.create(
		  Splitter.on(CharMatcher.WHITESPACE)
		  	.trimResults(CharMatcher.is('.'))
		    .omitEmptyStrings()
		    .split(Files.asCharSource(file, Charsets.UTF_8).read()));

		
		logger.info(wordOccurrences);

		assertEquals(80, wordOccurrences.elementSet().size());
	}
		
}
