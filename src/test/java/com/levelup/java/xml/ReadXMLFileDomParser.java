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

        System.out.println("Root element :" + document.getDocumentElement().getNodeName());

		
		NodeList nodeList = document.getElementsByTagName("locations");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			
			System.out.println(node);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				String content = node.getLastChild().getTextContent().trim();

				switch (node.getNodeName()) {
				case "long":
					System.out.println("Long name:" + content);
				case "city":
					System.out.println("city name:" + content);
				case "state":
					System.out.println("state name:" + content);
				case "country":
					System.out.println("country name:" + content);

				}
			}
		}
	}

	@Test
	public void parse_xml_string_with_dom_parser() {

	}

}
