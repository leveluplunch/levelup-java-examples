package com.levelup.java.xml;

import static org.junit.Assert.assertEquals;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Text;

/**
 * This java example will creating xml with DOM parser.
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/create-xml-node-with-dom-parser/'>Create
 *      xml/node with dom parser</a>
 * 
 */
public class CreateXMLWithDomParser {

	String formattedXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"
			+ "<movie id=\"tt0111161\">\n"
			+ "<rating>9.3</rating>\n"
			+ "<title>The Shawshank Redemption</title>\n"
			+ "<genre>Crime|Drama</genre>\n" + "</movie>\n" + "";

	@Test
	public void create_xml() throws TransformerException,
			ParserConfigurationException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document movieDocument = db.newDocument();

		org.w3c.dom.Element movieElement = movieDocument.createElement("movie");
		movieElement.setAttribute("id", "tt0111161");
		movieDocument.appendChild(movieElement);

		org.w3c.dom.Element ratingElement = movieDocument
				.createElement("rating");
		Text text1 = movieDocument.createTextNode("9.3");
		ratingElement.appendChild(text1);
		movieElement.appendChild(ratingElement);

		org.w3c.dom.Element titleElement = movieDocument.createElement("title");
		Text text2 = movieDocument.createTextNode("The Shawshank Redemption");
		titleElement.appendChild(text2);
		movieElement.appendChild(titleElement);

		org.w3c.dom.Element genreElement = movieDocument.createElement("genre");
		Text text3 = movieDocument.createTextNode("Crime|Drama");
		genreElement.appendChild(text3);
		movieElement.appendChild(genreElement);

		// Output the XML
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");

		DOMSource source = new DOMSource(movieDocument);
		StringWriter xmlWrittenToString = new StringWriter();
		StreamResult streamResult = new StreamResult(xmlWrittenToString);

		// transform xml source to result
		transformer.transform(source, streamResult);

		assertEquals(formattedXML, xmlWrittenToString.toString());
	}

}
