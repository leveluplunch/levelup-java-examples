package com.levelup.java.io;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * This java example will demonstrate creating a 
 * {@link InputStream} from a {@link String}.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-string-to-inputstream/'>String to InputStream</a>
 * 
 */
public class StringToInputstream {

	private static final String PHRASE = "like turkeys voting for (an early) Christmas";
	
	@Test
	public void convert_string_to_inputstream () throws IOException {
		
		InputStream inputStream = new ByteArrayInputStream(PHRASE.getBytes());

		// now to do some work w/ it
		StringBuffer phraseThroughStream = new StringBuffer();
		int c;
        while ((c = inputStream.read()) != -1) {
        	phraseThroughStream.append((char) c);
        }
		
		assertEquals(phraseThroughStream.toString(), PHRASE);
	}
	
	@Test
	public void convert_string_to_inputstream_guava () {
		//	https://code.google.com/p/guava-libraries/issues/detail?id=642
	}


	@Test
	public void convert_string_to_inputstream_apache () throws IOException {

		InputStream inputStream = IOUtils.toInputStream(PHRASE);
		
		// now to do some work w/ it
		StringBuffer phraseThroughStream = new StringBuffer();
		int c;
        while ((c = inputStream.read()) != -1) {
        	phraseThroughStream.append((char) c);
        }
		
		assertEquals(phraseThroughStream.toString(), PHRASE);
	}

}
