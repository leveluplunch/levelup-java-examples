package com.levelup.java.io;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.LineProcessor;

/**
 * This java example will count the number of lines within a text file using
 * java, java 8, guava and apache commons.
 * 
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/count-number-of-lines-in-text-file/'>Cop
 *      y file</a>
 * 
 */
public class CountLinesTextFile {

	URI fileLocation;

	@Before
	public void setUp() throws URISyntaxException {
		fileLocation = this.getClass()
				.getResource("/com/levelup/java/io/count-lines-text-file.txt").toURI();

	}

	@Test
	public void count_lines_text_java() throws IOException {

		LineNumberReader lineReader = new LineNumberReader(new FileReader(Paths
				.get(fileLocation).toFile()));
		lineReader.skip(Long.MAX_VALUE);

		long totalNumberOfLines = lineReader.getLineNumber() + 1;

		lineReader.close();

		assertEquals(10, totalNumberOfLines);
	}

	@Test
	public void count_lines_text_java8() throws IOException, URISyntaxException {

		long numberOfLines;
		try (Stream<String> s = Files.lines(Paths.get(fileLocation),
				Charset.defaultCharset())) {

			numberOfLines = s.count();

		} catch (IOException e) {
			throw e;
		}

		assertEquals(10, numberOfLines);
	}

	@Test
	public void count_lines_text_file_guava() throws IOException {

		long linesCounted = com.google.common.io.Files.readLines(
				Paths.get(fileLocation).toFile(), Charsets.UTF_8,
				new LineProcessor<Long>() {

					long numberOfLinesInTextFile = 0;

					@Override
					public boolean processLine(String line) throws IOException {

						numberOfLinesInTextFile++;
						return true;
					}

					@Override
					public Long getResult() {
						return numberOfLinesInTextFile;
					}
				});

		assertEquals(10, linesCounted);
	}

	@Test
	public void count_lines_text_apache() throws IOException {

		LineIterator lineIterator = FileUtils.lineIterator(
				Paths.get(fileLocation).toFile(), Charset.defaultCharset()
						.toString());

		long linesInTextFile = 0;
		try {
			while (lineIterator.hasNext()) {
				linesInTextFile++;
				lineIterator.nextLine();
			}
		} finally {
			LineIterator.closeQuietly(lineIterator);
		}

		assertEquals(10, linesInTextFile);
	}
}
