package com.levelup.java.util;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.io.BaseEncoding;

/**
 * This java example will demonstrate decoding a base64 url.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/decode-base64-url/'>Decode URL Base64</a>
 */
public class DecodeURLBase64 {

	// TODO: http://download.java.net/jdk8/docs/api/java/util/Base64.html
	@Ignore("Java 8 not yet released")
	@Test
	public void string_base64_decode_java_8() {
	}

	@Test
	public void string_base64_decode_guava() throws UnsupportedEncodingException {

		String encodedURL = "aHR0cDovL2xldmVsdXBsdW5jaC5jb20vZXhhbXBsZXMvP3Bhcm09VGhpcyBwYXJhbWV0ZXI=";

		byte[] decodedURLAsBytes = BaseEncoding.base64Url().decode(
				encodedURL);
		
		String decodedURL = new String(decodedURLAsBytes, "utf-8");

		assertEquals(
				"http://leveluplunch.com/examples/?parm=This parameter",
				decodedURL);
	}

	@Test
	public void string_base64_decode_apache() throws UnsupportedEncodingException {

		String encodedURL = "aHR0cDovL2xldmVsdXBsdW5jaC5jb20vZXhhbXBsZXMvP3Bhcm09VGhpcyBwYXJhbWV0ZXI=";

		byte[] decodedURLAsBytes = Base64.decodeBase64(encodedURL);
		
		String decodedURL = new String(decodedURLAsBytes, "utf-8");

		assertEquals(
				"http://leveluplunch.com/examples/?parm=This parameter",
				decodedURL);
	}
	
}
