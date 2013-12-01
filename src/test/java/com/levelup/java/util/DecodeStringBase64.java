package com.levelup.java.util;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.Ignore;
import org.junit.Test;

import com.google.common.io.BaseEncoding;
import com.sun.jersey.core.util.Base64;

/**
 * This java example will demonstrate decoding a base64 string.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/decode-base64-string/'>Decode base64 string</a>
 */
public class DecodeStringBase64 {

	// TODO: http://download.java.net/jdk8/docs/api/java/util/Base64.html
	@Ignore("Java 8 not yet released")
	@Test
	public void string_base64_decode_java_8() {
	}

	@Test
	public void string_base64_decode_guava() throws UnsupportedEncodingException {

		String encodedPhrase = "TGVhcm4uIEVhdC4gQ29kZS4=";
		
		byte[] decodedPhraseAsBytes = BaseEncoding.base64().decode(encodedPhrase);

		String phraseDecodedToString = new String(decodedPhraseAsBytes, "utf-8");
		
		assertEquals("Learn. Eat. Code.", phraseDecodedToString);
	}

	@Test
	public void string_base64_decode_apache() throws UnsupportedEncodingException {

		String encodedPhrase = "TGVhcm4uIEVhdC4gQ29kZS4=";
		
		byte[] decodedPhraseAsBytes = Base64.decode(encodedPhrase);

		String phraseDecodedToString = new String(decodedPhraseAsBytes, "utf-8");
		
		assertEquals("Learn. Eat. Code.", phraseDecodedToString);
	}

}
