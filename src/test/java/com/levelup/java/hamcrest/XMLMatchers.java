package com.levelup.java.hamcrest;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.xml.HasXPath.hasXPath;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;

/**
 * This java example will demonstrate testing
 * xml with junit and hamcrest matchers.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/hamcrest-xml-matchers-junit-testing/'>XML matchers</a>
 * 
 */
public class XMLMatchers {

	@Test
	public void test_xml_path () throws Exception {

		String aListApartXML = "<daily-values> " + 
				 "	<total-fat units=\"g\">65</total-fat> " + 
				 "	<saturated-fat units=\"g\">20</saturated-fat> " + 
				 "	<cholesterol units=\"mg\">300</cholesterol> " + 
				 "	<sodium units=\"mg\">2400</sodium> " + 
				 "	<carb units=\"g\">300</carb> " + 
				 "	<fiber units=\"g\">25</fiber> " + 
				 "	<protein units=\"g\">50</protein> " + 
				 "</daily-values> ";
		
		Document xml = parse(aListApartXML);
        
        assertThat(xml, hasXPath("/daily-values/saturated-fat", equalTo("20")));
	}
	
    private static Document parse(String xml) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(false);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        return documentBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
    }

}
