package com.levelup.java.net;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.common.io.Resources;

/**
 * This java example will show how to read the contents of a webpage.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/get-webpage-contents-url-uri-as-string/'>Get
 *      web page contents as string</a>
 */
public class GetWebPageContents {

	private static final Logger logger = Logger
			.getLogger(GetWebPageContents.class);

	@Test
	public void web_page_contents_java() throws IOException {

		URL getUrlContent = new URL("http://www.example.com/");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				getUrlContent.openStream()));

		String webpageAsString;
		while ((webpageAsString = in.readLine()) != null)
			System.out.println(webpageAsString);
		in.close();

		logger.info(webpageAsString);

		assertNotNull(webpageAsString);
	}

	@Test
	public void web_page_contents_java7() throws IOException {

		URL url = new URL("http://www.example.com/");

		String readUrlContents;
		try (InputStreamReader reader = new InputStreamReader(url.openStream(),
				Charsets.UTF_8)) {
			readUrlContents = CharStreams.toString(reader);
		}

		logger.info(readUrlContents);

		assertNotNull(readUrlContents);
	}

	@Test
	public void web_page_contents_guava() throws IOException {

		URL url = new URL("http://www.example.com/");

		String downloadWebpage = Resources.asByteSource(url)
				.asCharSource(Charsets.UTF_8).read();

		logger.info(downloadWebpage);

		assertNotNull(downloadWebpage);
	}

	@Test
	public void web_page_contents_apache() throws IOException,
			URISyntaxException {

		URL url = new URL("http://www.example.com/");
		String pageContents = IOUtils.toString(url, Charsets.UTF_8);

		logger.info(pageContents);

		assertNotNull(pageContents);

		// or

		URI uri = new URI("http://www.example.com/");
		String siteContents = IOUtils.toString(uri, Charsets.UTF_8);

		logger.info(siteContents);

		assertNotNull(siteContents);
	}

}
