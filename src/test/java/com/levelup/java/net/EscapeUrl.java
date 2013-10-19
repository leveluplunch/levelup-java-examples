package com.levelup.java.net;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import org.springframework.web.util.UriUtils;

import com.google.common.base.Charsets;
import com.google.common.net.UrlEscapers;

/**
 * This java example will demonstrate encoding
 * a URL string.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/encode-url-string/'>Encode URL string</a>
 * 
 */
public class EscapeUrl {
	
	
	private static final String URL_TO_ESCAPE = "http://www.leveluplunch.com?somevar=abc123&someothervar";
											   
	@Test
	public void escape_url_with_straight_java () throws UnsupportedEncodingException {

		//The URLEncoder and URLDecoder classes can also be used, but only for 
		//HTML form encoding, which is not the same as the encoding scheme defined in RFC2396.
		// In this example we want to encode the URL not form encoding.

		String urlEscaped = URLEncoder.encode(URL_TO_ESCAPE, "UTF-8")
	                .replaceAll("\\+", "%20")
	                .replaceAll("\\%21", "!")
	                .replaceAll("\\%27", "'")
	                .replaceAll("\\%28", "(")
	                .replaceAll("\\%29", ")")
	                .replaceAll("\\%7E", "~");	
		
		assertEquals("http%3A%2F%2Fwww.leveluplunch.com%3Fsomevar%3Dabc123%26someothervar", urlEscaped);
	}
	
	@Test
	public void escape_url_with_google_guava () {
		
		String urlEscaped = UrlEscapers.urlPathSegmentEscaper().escape(URL_TO_ESCAPE);
		assertEquals("http:%2F%2Fwww.leveluplunch.com%3Fsomevar=abc123&someothervar", urlEscaped);
	}
	
	@Test
	public void escpae_url_with_spring () throws UnsupportedEncodingException {
		
		// If you are using Java 7 you can use StandardCharsets OR use Guava Charsets 
		
		String urlEscaped = UriUtils.encodePath(URL_TO_ESCAPE, Charsets.UTF_8.toString());
		 
		assertEquals("http://www.leveluplunch.com%3Fsomevar=abc123&someothervar", urlEscaped);
	}

	@Test
	public void escape_url_with_apache_commons () throws EncoderException {

		URLCodec codec = new URLCodec();
		String urlEscaped = codec.encode(URL_TO_ESCAPE);
		
		assertEquals("http%3A%2F%2Fwww.leveluplunch.com%3Fsomevar%3Dabc123%26someothervar", urlEscaped);
	}
	
}
