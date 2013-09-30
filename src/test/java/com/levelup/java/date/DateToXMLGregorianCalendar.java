package com.levelup.java.date;

import static org.junit.Assert.assertNotNull;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Test;

/**
 * This java example will demonstrate converting a date to XMLGregorianCalendar
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class DateToXMLGregorianCalendar {

	
	@Test
	public void convert_date_to_XMLGregorianCalendar () throws DatatypeConfigurationException { 

		GregorianCalendar gCalendar = new GregorianCalendar();

		XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
		
		assertNotNull(xmlGregorianCalendar);

	}
	
}
