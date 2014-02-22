package com.levelup.java.util;

import static org.junit.Assert.assertEquals;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import com.google.common.io.BaseEncoding;

/**
 * This java example will demonstrate encoding 
 * url w/ Base64.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/encode-url-to-base64/'>Encode url base64</a>
 */
public class EncodeURLBase64 {

	@Test
	public void string_base64_encode_java_8() {

		String levelUpLunchURL = "http://leveluplunch.com/examples/?parm=This parameter";

		String encodedURL = java.util.Base64.getEncoder().encodeToString(
				levelUpLunchURL.getBytes());

		assertEquals(
				"aHR0cDovL2xldmVsdXBsdW5jaC5jb20vZXhhbXBsZXMvP3Bhcm09VGhpcyBwYXJhbWV0ZXI=",
				encodedURL);
	}

	@Test
	public void string_base64_encode_guava() {

		String levelUpLunchURL = "http://leveluplunch.com/examples/?parm=This parameter";

		String encodedURL = BaseEncoding.base64Url().encode(
				levelUpLunchURL.getBytes());

		assertEquals(
				"aHR0cDovL2xldmVsdXBsdW5jaC5jb20vZXhhbXBsZXMvP3Bhcm09VGhpcyBwYXJhbWV0ZXI=",
				encodedURL);
	}

	@Test
	public void string_base64_encoding_apache() {

		String levelUpLunchURL = "http://leveluplunch.com/examples/?parm=This parameter";

		String encodedURL = Base64.encodeBase64URLSafeString(levelUpLunchURL
				.getBytes());

		assertEquals(
				"aHR0cDovL2xldmVsdXBsdW5jaC5jb20vZXhhbXBsZXMvP3Bhcm09VGhpcyBwYXJhbWV0ZXI",
				encodedURL);
	}

}
