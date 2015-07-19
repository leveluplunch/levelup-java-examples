package com.levelup.java.net;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.google.common.io.Resources;

/**
 * This java example will show how to download image from webpage.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/download-image-from-webpage/'>Download
 *      image from web page</a>
 */
public class DownloadImageFromWebPage {

	String IMAGE_URL = "https://www.google.com/images/srpr/logo11w.png";
	String IMAGE_NAME = "google-logo.png";

	@Test
	public void using_using_awt() throws IOException {

		URL imageUrlToDownload = new URL(IMAGE_URL);
		BufferedImage imageToDownload = ImageIO.read(imageUrlToDownload);

		File outputFile = new File("awt-" + IMAGE_NAME);
		ImageIO.write(imageToDownload, "png", outputFile);
	}

	@Test
	public void download_image_java7() throws IOException {

		URL imageLocation = new URL(IMAGE_URL);
		ReadableByteChannel rbc = Channels.newChannel(imageLocation
				.openStream());
		FileOutputStream outputStream = new FileOutputStream("java7-"
				+ IMAGE_NAME);
		outputStream.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		outputStream.close();
	}

	@Test
	public void download_image_guava() throws IOException {

		URL fetchImage = new URL(IMAGE_URL);
		byte[] imageAsArray = Resources.toByteArray(fetchImage);

		File fileToWriteTo = new File("guava-" + IMAGE_NAME);

		com.google.common.io.Files.write(imageAsArray, fileToWriteTo);
	}
}
