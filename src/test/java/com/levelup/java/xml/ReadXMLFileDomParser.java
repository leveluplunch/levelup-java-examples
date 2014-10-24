package com.levelup.java.xml;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * This java example will demonstrate how to read XML file with DOM parser.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/parse-xml-from-file-string-with-dom-parser/'></a>
 */
public class ReadXMLFileDomParser {

	@Test
	public void read_xml_file_with_dom_parser()
			throws ParserConfigurationException, SAXException, IOException {

		Path xmlFilePath = Paths
				.get("src/test/resources/com/levelup/java/xml/read-xml-file-dom-parser.xml")
				.toAbsolutePath();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.parse(xmlFilePath.toFile());
		document.getDocumentElement().normalize();

		NodeList nodeList = document.getElementsByTagName("*");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				String content = node.getLastChild().getTextContent().trim();

				switch (node.getNodeName()) {
				case "long":
					System.out.println("Long name:" + content);
					break;
				case "city":
					System.out.println("city name:" + content);
					break;
				case "state":
					System.out.println("state name:" + content);
					break;
				case "country":
					System.out.println("country name:" + content);
					break;

				}
			}
		}
	}

}
