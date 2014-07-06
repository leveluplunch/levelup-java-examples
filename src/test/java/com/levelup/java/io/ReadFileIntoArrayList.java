package com.levelup.java.io;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * This java example will demonstrate how to read a file into an {@link ArrayList}.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/read-load-import-file-into-arraylist/'>Read file into arraylist</a>
 */
public class ReadFileIntoArrayList {

	private static final Logger logger = Logger
			.getLogger(ReadFileIntoArrayList.class);

	Path worldSeriesWinners = Paths
			.get("src/test/resources/com/levelup/java/io/read-file-into-arraylist.txt")
			.toAbsolutePath();

	@Test
	public void read_file_array_list_java() throws FileNotFoundException {

		InputStream in = new FileInputStream(worldSeriesWinners.toFile());

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		List<String> teams = new ArrayList<String>();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				teams.add(line);
			}
		} catch (IOException e) {
			logger.error(e);
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				logger.error(e);
			}
		}
		assertEquals(10, teams.size());

	}

	@Test
	public void read_file_array_list_java7() throws IOException {

		List<String> teams = java.nio.file.Files.readAllLines(
				worldSeriesWinners, Charset.defaultCharset());

		assertEquals(10, teams.size());
	}

	@Test
	public void read_file_array_list_java8() throws IOException {

		List<String> teams = java.nio.file.Files.lines(worldSeriesWinners)
				.collect(Collectors.toList());

		assertEquals(10, teams.size());

	}

	@Test
	public void read_file_array_list_guava() throws IOException {

		List<String> teams = Files.readLines(worldSeriesWinners.toFile(),
				Charsets.UTF_8);

		assertEquals(10, teams.size());
	}

	@Test
	public void read_file_array_list_apache() throws IOException {

		List<String> teams = FileUtils.readLines(worldSeriesWinners.toFile());

		assertEquals(10, teams.size());
	}

}
