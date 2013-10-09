package com.levelup.java.util;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.google.common.io.InputSupplier;
import com.google.common.io.Resources;

/**
 * This java example will demonstrate reading
 * a properties file.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/read-properties-files/'>Read properties file</a>
 * 
 */
public class ReadPropertiesFile {
	
	private static final Logger logger = Logger.getLogger(ReadPropertiesFile.class);

	private static final String PROPERTY_FILE_NAME = "read.properties";
	
	@Test
	public void read_properties_file_java() throws FileNotFoundException,
			IOException {

		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME));
		
		logger.info(properties);
		
		assertEquals("http://www.leveluplunch.com", properties.getProperty("website"));
		assertEquals("English", properties.getProperty("language"));
		assertEquals("Welcome up to leveluplunch.com", properties.getProperty("message"));
	}
	
	@Test
	public void read_properties_file_guava() throws IOException {
		
		URL url = Resources.getResource(PROPERTY_FILE_NAME);
		InputSupplier<InputStream> inputSupplier = 
				Resources.newInputStreamSupplier(url);
		
		Properties properties = new Properties();
		properties.load(inputSupplier.getInput());
		
		logger.info(properties);
		
		assertEquals("http://www.leveluplunch.com", properties.getProperty("website"));
		assertEquals("English", properties.getProperty("language"));
		assertEquals("Welcome up to leveluplunch.com", properties.getProperty("message"));
	}
	
	@Test
	public void read_properties_file_apache_commons () throws ConfigurationException {
	
		PropertiesConfiguration properties = new PropertiesConfiguration(PROPERTY_FILE_NAME);
		
		logger.info(properties);
		
		assertEquals("http://www.leveluplunch.com", properties.getProperty("website"));
		assertEquals("English", properties.getProperty("language"));
		assertEquals("Welcome up to leveluplunch.com", properties.getProperty("message"));
	}

	/**
	 * This is just one way to get properties in the springframework and 
	 * could be based on environment, xml configuration, java config, etc.
	 * 		
	 * @see PropertyPlaceholderConfigurer
	 * @see PropertySourcesPlaceholderConfigurer
	 * @throws IOException
	 */
	@Test
	public void read_properties_file_springframework () throws IOException {

		Resource resource = new ClassPathResource(PROPERTY_FILE_NAME);
		Properties properties = PropertiesLoaderUtils.loadProperties(resource);

		logger.info(properties);
		
		assertEquals("http://www.leveluplunch.com", properties.getProperty("website"));
		assertEquals("English", properties.getProperty("language"));
		assertEquals("Welcome up to leveluplunch.com", properties.getProperty("message"));
	}
	
}
