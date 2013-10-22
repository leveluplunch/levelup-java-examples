package com.levelup.java.date;

import static org.junit.Assert.assertNotNull;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * This java example will demonstrate converting a date to XMLGregorianCalendar
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/date-to-xmlgregoriancalendar/'>Date to XMLGregorianCalendar</a>
 * 
 */
public class DateToXMLGregorianCalendar {

	private static final Logger logger = Logger.getLogger(DateToXMLGregorianCalendar.class);
	
	@Test
	public void convert_date_to_XMLGregorianCalendar()
			throws DatatypeConfigurationException {

		GregorianCalendar gCalendar = new GregorianCalendar();

		XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory
				.newInstance().newXMLGregorianCalendar(gCalendar);

		logger.info(xmlGregorianCalendar);

		assertNotNull(xmlGregorianCalendar);
	}
	
}
