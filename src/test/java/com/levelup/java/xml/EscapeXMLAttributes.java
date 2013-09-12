package com.levelup.java.xml;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;

import com.google.common.xml.XmlEscapers;

public class EscapeXMLAttributes {

	// This example is just to show escaping attributes not the data that is between the tags
	// If you want to escape data within your tags you could use <![CDATA[ your text here ]]>
	
	private static final String XML_TO_ESCAPE = "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>";
	private static final String ESCAPED_XML = "&lt;note&gt;&lt;to&gt;Tove&lt;/to&gt;&lt;from&gt;Jani&lt;/from&gt;&lt;heading&gt;Reminder&lt;/heading&gt;&lt;body&gt;Don&apos;t forget me this weekend!&lt;/body&gt;&lt;/note&gt;";

	@Test
	public void escape_xml_with_straight_java () {
		
		StringBuilder escapedXML = new StringBuilder();
		for (int i = 0; i < XML_TO_ESCAPE.length(); i++) {
			char c = XML_TO_ESCAPE.charAt(i);
			switch (c) {
			case '<':
				escapedXML.append("&lt;");
				break;
			case '>':
				escapedXML.append("&gt;");
				break;
			case '\"':
				escapedXML.append("&quot;");
				break;
			case '&':
				escapedXML.append("&amp;");
				break;
			case '\'':
				escapedXML.append("&apos;");
				break;
			default:
				if (c > 0x7e) {
					escapedXML.append("&#" + ((int) c) + ";");
				} else
					escapedXML.append(c);
			}
		}
		
		assertEquals(ESCAPED_XML, escapedXML.toString());
	}
	
	@Test
	public void escape_xml_with_google_guava () {
		String escapedXML = XmlEscapers.xmlAttributeEscaper().escape(XML_TO_ESCAPE);
		assertEquals(ESCAPED_XML, escapedXML);
	}
	
	@Test
	public void escape_xml_with_apache_commons () {
		String escapedXML = StringEscapeUtils.escapeXml(XML_TO_ESCAPE);
		assertEquals(ESCAPED_XML, escapedXML);
	}
	
	
}
