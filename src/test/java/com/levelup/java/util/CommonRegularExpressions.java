package com.levelup.java.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * This java example will demonstrate a few common
 * regular expression.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/common-regular-expressions/'>Common regular expression</a>
 */
public class CommonRegularExpressions {

	@Test
	public void regex_tax_id_or_employer_identification_number () {
		
		String taxIdRegex = "^([07][1-7]|1[0-6]|2[0-7]|[35][0-9]|[468][0-8]|9[0-589])-?\\d{7}$";
		
		assertTrue("45-4444444".matches(taxIdRegex));
		assertTrue("454444444".matches(taxIdRegex));
		
		assertFalse("98765432".matches(taxIdRegex));
	}
	
	
	@Test
	public void regex_html_tag () {
		
		String htmlRegex = "(\\<(/?[^\\>]+)\\>)";
		
		assertTrue("<h2>".matches(htmlRegex));
		assertTrue("</h2>".matches(htmlRegex));
		assertTrue("<p>".matches(htmlRegex));
		assertTrue("<script type='text/javascript'>".matches(htmlRegex));
		assertTrue("<a href=''>".matches(htmlRegex));
		assertTrue("<img src=''>".matches(htmlRegex));
		
		assertFalse("* bullet point".matches(htmlRegex));
	}
	
	@Test
	public void regex_valid_url () {
		
		String urlRegex = "\\b(https?|ftp|file|ldap)://"
				+ "[-A-Za-z0-9+&@#/%?=~_|!:,.;]"
				+ "*[-A-Za-z0-9+&@#/%=~_|]";
		
		assertTrue("http://www.leveluplunch.com".matches(urlRegex));
		
		assertTrue("http://www.leveluplunch.com/index.html".matches(urlRegex));
		
		assertTrue("http://leveluplunch.com".matches(urlRegex));
		
		assertTrue("https://www.leveluplunch.com/examples".matches(urlRegex));
		
		assertTrue("http://www.leveluplunch.com/examples?abc=123".matches(urlRegex));
		
		assertTrue("ldap://myhost:389".matches(urlRegex));
		
		assertTrue("ftp://user:password@host:port/URI?queryParameters".matches(urlRegex));
		
		assertFalse("www.leveluplunch.com".matches(urlRegex));
	}
	
	
	@Test
	public void regex_number_range () {
		
		String numberRangeRegex = "\\d{3}";
		
		assertTrue("123".matches(numberRangeRegex));

		assertFalse("1223".matches(numberRangeRegex));
		
		assertFalse("12".matches(numberRangeRegex));
	}
	
	
	@Test
	public void regex_consecutive_duplicated_words () {
		
		String duplicatedWordRegex = "\\b(\\w+)\\s+\\1\\b";
		
		assertTrue("so so".matches(duplicatedWordRegex));
		
		assertFalse("so this, so this".matches(duplicatedWordRegex));
	}

	@Test
	public void regex_phone_numbers () {
		
		String phoneNumberRegex = "^(\\([2-9]|[2-9])"
				+ "(\\d{2}|\\d{2}\\))"
				+ "(-|.|\\s)?\\d{3}(-|.|\\s)?\\d{4}$";
		
		assertTrue("223-123-1234".matches(phoneNumberRegex));

		assertTrue("800-123-1234".matches(phoneNumberRegex));

		assertTrue("(223) 123-1234".matches(phoneNumberRegex));
		
		assertTrue("(223)123-1234".matches(phoneNumberRegex));

		assertTrue("223.123.1234".matches(phoneNumberRegex));

		assertFalse("000-000-0000".matches(phoneNumberRegex));
		
		assertFalse("1-223-123-1234".matches(phoneNumberRegex));
	}
	
	
	@Test
	public void regex_zip_code () {
		
		String zipCodeRegEx = "[0-9]{5}(\\-?[0-9]{4})?$";
		
		assertTrue("53546".matches(zipCodeRegEx));
		assertTrue("53546-1234".matches(zipCodeRegEx));
		
		assertFalse("a53546".matches(zipCodeRegEx));
	}
	
	
	@Test
	public void regex_email_address () {
		
		String emailRegEx = "^[a-zA-Z0-9'._%+-]+@"
				+ "(?:[a-zA-Z0-9-]+\\.)"
				+ "+[a-zA-Z]{2,4}$";

		assertTrue("first@leveluplunch.com".matches(emailRegEx));
		
		assertTrue("first.last@leveluplunch.com".matches(emailRegEx));
		
		assertTrue("first.last@mail.leveluplunch.com".matches(emailRegEx));
		
		assertTrue("f_last@mail.leveluplunch.com".matches(emailRegEx));
		
		assertTrue("f-last@mail.leveluplunch.com".matches(emailRegEx));
		
		assertFalse("f-last@leveluplunch".matches(emailRegEx));
	}
	

	@Test
	public void regex_image_file_names () {
		
		String fileImageTypes = "([^\\s]+(?=\\.(jpg|gif|png))\\.\\2)";

		assertTrue("/images/leveluplunch.jpg".matches(fileImageTypes));
		
		assertTrue("/assets/images/leveluplunch.gif".matches(fileImageTypes));
		
		assertTrue("/img/leveluplunch.png".matches(fileImageTypes));
		
		assertFalse("leveluplunch.mov".matches(fileImageTypes));
	}
	
}
