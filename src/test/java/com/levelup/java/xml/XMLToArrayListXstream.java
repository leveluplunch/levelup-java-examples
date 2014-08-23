package com.levelup.java.xml;

import static org.junit.Assert.assertNotNull;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.XStream;

/**
 * This java example will demonstrate converting xml to java and back.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/convert-xml-to-arraylist-xstream/'>Convert xml to arraylist using xstream</a>
 */
public class XMLToArrayListXstream {

	private static final Logger logger = Logger
			.getLogger(XMLToArrayListXstream.class);

	class Funeral {

		Date date;
		String funeralHome;
		String person;

		public Funeral(Date date, String funeralHome, String person) {
			super();
			this.date = date;
			this.funeralHome = funeralHome;
			this.person = person;
		}

		public Date getDate() {
			return date;
		}

		public String getFuneralHome() {
			return funeralHome;
		}

		public String getPerson() {
			return person;
		}

		@Override
		public String toString() {
			return "Funeral [date=" + date + ", funeralHome=" + funeralHome
					+ ", person=" + person + "]";
		}

	}

	private List<Funeral> funerals;

	@Before
	public void setUp() {

		Funeral funeral1 = new Funeral(Date.from(Instant.now()),
				"Nitardy Funeral Home", "Jack");
		Funeral funeral2 = new Funeral(Date.from(Instant.now()),
				"Dunlap Memorial Home", "Cindie");
		Funeral funeral3 = new Funeral(Date.from(Instant.now()),
				"Olsen Funeral Home", "Perry");

		funerals = Lists.newArrayList(funeral1, funeral2, funeral3);
	}

	@Test
	public void serialize_object_to_xml() {

		XStream xStream = new XStream();

		String funeralsAsXML = xStream.toXML(funerals);

		logger.info(funeralsAsXML);

		assertNotNull(funeralsAsXML);
	}

	@Test
	public void deserialize_xml_to_arraylist() {

		String rawXML = "<list> <com.levelup.java.xml.XMLToArrayListXstream_-Funeral> <date>2014-08-21 22:03:30.367 UTC</date> <funeralHome>Nitardy Funeral Home</funeralHome> <person>Jack</person> <outer-class> <funerals reference=\"../../..\"/> </outer-class> </com.levelup.java.xml.XMLToArrayListXstream_-Funeral> <com.levelup.java.xml.XMLToArrayListXstream_-Funeral> <date>2014-08-21 22:03:30.367 UTC</date> <funeralHome>Dunlap Memorial Home</funeralHome> <person>Cindie</person> <outer-class reference=\"../../com.levelup.java.xml.XMLToArrayListXstream_-Funeral/outer-class\"/> </com.levelup.java.xml.XMLToArrayListXstream_-Funeral> <com.levelup.java.xml.XMLToArrayListXstream_-Funeral> <date>2014-08-21 22:03:30.367 UTC</date> <funeralHome>Olsen Funeral Home</funeralHome> <person>Perry</person> <outer-class reference=\"../../com.levelup.java.xml.XMLToArrayListXstream_-Funeral/outer-class\"/> </com.levelup.java.xml.XMLToArrayListXstream_-Funeral> </list>";

		XStream xStream = new XStream();

		@SuppressWarnings("unchecked")
		List<Funeral> funeral2 = (List<Funeral>) xStream.fromXML(rawXML);

		logger.info(funeral2);

		assertNotNull(funeral2.size() == 2);
	}

}
