package com.levelup.java.util;

import static org.junit.Assert.assertEquals;

import org.apache.commons.codec.binary.Base64;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.io.BaseEncoding;

/**
 * This java example will demonstrate how to encode
 * a string using Base64 encoding.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/encode-string-to-base64/'>Encode string using base64</a>
 */
public class EncodeStringBase64 {

	// TODO: http://download.java.net/jdk8/docs/api/java/util/Base64.html
	@Ignore("Java 8 not yet released")
	@Test
	public void string_base64_encode_java_8 () {
	}
	
	@Test
	public void string_base64_encode_guava () {
		
		String randomPhrase = "Learn. Eat. Code.";
		
		String encodedPhrase = BaseEncoding.base64().encode(randomPhrase.getBytes());
		
		assertEquals("TGVhcm4uIEVhdC4gQ29kZS4=", encodedPhrase);
	}
	
	@Test
	public void string_base64_encoding_apache () {
		
		String randomPhrase = "Learn. Eat. Code.";
		
		Base64 base64 = new Base64();
		String encodedPhrase = base64.encodeAsString(randomPhrase.getBytes());
		
		assertEquals("TGVhcm4uIEVhdC4gQ29kZS4=", encodedPhrase);
	}
	
}
