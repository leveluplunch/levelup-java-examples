package com.levelup.java.util.stream;

import org.junit.Test;

/**
 * This java example will demonstrate how to convert
 * a string to a stream.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-string-to-java-util-stream-java8/'>String to stream</a>
 */
public class ConvertStringToStream {

	@Test
	public void string_to_stream() {
		String val = "Levelup Lunch";

		val.chars().forEach(
				e -> System.out.println(Character.toString((char) e)));
	}

}
