package com.levelup.java.json;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;


/**
 * This java example will demonstrate how to/from xml to json using xstream
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-xml-to-from-json-using-xstream/'>Convert xml to json using Xstream</a>
 * 
 */
public class XMLToFromJSONXStream {

	class Status {
		
		String status_code;
		String sub_code;
		String message;
		
		public Status(String status_code, String sub_code, String message) {
			super();
			this.status_code = status_code;
			this.sub_code = sub_code;
			this.message = message;
		}
	}

	String XML ="<com.levelup.java.json.XMLToFromJSONXStream_-Status>\n"+
			"  <status__code>400</status__code>\n"+
			"  <sub__code>120</sub__code>\n"+
			"  <message>Query param start_index out of bounds.</message>\n"+
			"  <outer-class/>\n"+
			"</com.levelup.java.json.XMLToFromJSONXStream_-Status>";

	String JSON = "{\"com.levelup.java.json.XMLToFromJSONXStream$Status\":"
			+ "{\"status_code\":400,\"sub_code\":120,\"message\":"
			+ "\"Query param start_index out of bounds.\",\"outer-class\":\"\"}}";
	
	
	@Test
	public void convert_xml_to_json() {

		// create xstream object for reading xml
		XStream xstream = new XStream();
		xstream.setMode(XStream.NO_REFERENCES);
		Status status = (Status) xstream.fromXML(XML);

		// create a new xstream object w/json provider
		XStream xstreamForJson = new XStream(new JettisonMappedXmlDriver());
		xstreamForJson.setMode(XStream.NO_REFERENCES);
		xstream.alias("status", Status.class);
		
		assertEquals(JSON, xstreamForJson.toXML(status));
	}
	
	@Test
	public void convert_json_to_xml() {
		
		
		// create a new xstream object w/json provider
		XStream xstreamForJson = new XStream(new JettisonMappedXmlDriver());
		xstreamForJson.setMode(XStream.NO_REFERENCES);
		xstreamForJson.alias("status", Status.class);		
		Status status = (Status) xstreamForJson.fromXML(JSON);

		// create xstream object for reading xml
		XStream xstream = new XStream();
		xstream.setMode(XStream.NO_REFERENCES);

		assertEquals(XML, xstream.toXML(status));
	}
}
