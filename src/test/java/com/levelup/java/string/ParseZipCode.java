package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

/**
 * This example will demonstrate parsing 
 * a zipcode in java and guava.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/parse-zipcode-from-string/'>Parse a zip code</a>
 * 
 */
public class ParseZipCode {

	@Test
	public void zip_code_parser_java () {

        String zipCode = "535381234";
        
        String zip5 = zipCode.substring(0, 5);
        
        String zip4 = "";
        if (zipCode.length() == 9) {
        	zip4 = zipCode.substring(5);
        }
        assertEquals("53538", zip5);
        assertEquals("1234", zip4);
	}
	
    @Test
    public void zip_code_parser_guava_delimiter () {

        String fullZipCode = "53538-1234";

        Iterable<String> zipCodePieces =
                        Splitter.on(CharMatcher.anyOf("-"))
                        .trimResults()
                        .omitEmptyStrings().split(fullZipCode);
       
        String zip5 = Iterables.get(zipCodePieces, 0);
        String zip4 = Iterables.get(zipCodePieces, 1);

        assertEquals("53538", zip5);
        assertEquals("1234", zip4);
    }

    @Test
    public void zip_code_parser_guava_by_fixed_length () {

        String zipCode = "535381234";

        Iterable<String> zipCodePieces =
                        Splitter.fixedLength(5)
                        .trimResults()
                        .omitEmptyStrings().split(zipCode);
       
        String zip5 = Iterables.get(zipCodePieces, 0);
        String zip4 = Iterables.get(zipCodePieces, 1);

        assertEquals("53538", zip5);
        assertEquals("1234", zip4);
    }

}
