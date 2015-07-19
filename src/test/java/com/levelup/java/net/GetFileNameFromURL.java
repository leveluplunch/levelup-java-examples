package com.levelup.java.net;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.ws.rs.core.UriBuilder;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

/**
 * This java example will demonstrate how to get the file name from a URL.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/get-file-name-from-url/'>Get file name from URL</a>
 */
public class GetFileNameFromURL {

	private String IMAGE_URL = "https://www.google.com/images/srpr/logo11w.png";
	private String IMAGE_URL_WITH_PARAMS = "http://www.google.com/images/srpr/logo11w.png?something=whatever";

	@Test
	public void fileNameUrl_java7() throws MalformedURLException,
			URISyntaxException {

		Path fileName = Paths.get(IMAGE_URL);

		assertEquals("logo11w.png", fileName.getFileName().toString());
	}

	@Test
	public void file_name_url_apache() {

		String fullFileName = FilenameUtils.getName(IMAGE_URL);

		assertEquals("logo11w.png", fullFileName.toString());
	}

	@Test
	public void uri_with_parameters_jersey() {

		UriBuilder buildURI = UriBuilder.fromUri(IMAGE_URL_WITH_PARAMS);

		URI uri = buildURI.build();

		assertEquals("logo11w.png", Paths.get(uri.getPath()).getFileName()
				.toString());
	}

}
