package com.levelup.java.xml;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.base.Objects;
import com.levelup.java.util.ReadPropertiesFile;

/**
 * This java example will demonstrate converting json
 * to XML.  There are quite a few various libs that appear
 * to do it, this example will focus on jackson.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-json-to-xml/'>Convert json to xml</a>
 * 
 */
public class ConvertJSONtoXML {
	
	private static final Logger logger = Logger.getLogger(ReadPropertiesFile.class);
	
	class Browser {
		private String name;

		public Browser(String name) {
			super();
			this.name = name;
		}
		
		@Override
		public String toString() {
			return Objects.toStringHelper(this)
					.add("name", name)
					.toString();
		}

		public String getName() {
			return name;
		}
	}
	
	
	@Test
	public void convert_json_to_xml_jackson () throws IOException {
		
		String browsersAsJson ="[{\"name\":\"Chrome\"},{\"name\":\"FireFox\"},{\"name\":\"Internet Explorer\"}]\n";
		
		ObjectMapper jsonMapper = new ObjectMapper();
	    
		@SuppressWarnings("unchecked")
		List<Browser> browsers = jsonMapper.readValue(browsersAsJson, List.class);

	    XmlMapper xmlMapper = new XmlMapper();
	    
	    String browsersAsXml = xmlMapper.writeValueAsString(browsers);
	    
	    logger.info(browsersAsXml);
	    
	    assertTrue(browsersAsXml.length() > 0);
	}
	 
}
