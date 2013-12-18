package com.levelup.java.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

/**
 * This java example will demonstrate how to format a phone number
 * using java and Google phone number library.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/format-phone-number/'>Format phone number</a>
 */
public class FormatPhoneNumber {
	
	@Test
	public void format_phone_number_java () {
		
		String rawNumber = "1234567890";
		
		String formattedNumber = String.format("(%s) %s-%s", 
				rawNumber.substring(0, 3), 
				rawNumber.substring(3, 6), 
				rawNumber.substring(6, 10));
		
		assertEquals("(123) 456-7890", formattedNumber);
	}

	
	@Test
	public void format_phone_number_google_libphonenumber () throws NumberParseException {
		
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setCountryCode(1);
		phoneNumber.setExtension("12345");
		phoneNumber.setNationalNumber(1234567890);

		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		String formattedPhoneNumber = phoneUtil.format(phoneNumber, PhoneNumberFormat.NATIONAL);

		assertEquals("(123) 456-7890 ext. 12345", formattedPhoneNumber);
	}
	
}
