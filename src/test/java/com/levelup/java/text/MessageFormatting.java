package com.levelup.java.text;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * This java snippet will demonstrate formatting messages in java
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'></a>
 * 
 */
public class MessageFormatting {

	@Test
	public void format_message_with_out_messageformatter_java() {
		String value1 = "Your account balance was ";
		String value2 = "2,500 ";
		String value3 = "on ";
		String value4 = "5/15/2013";

		String output = value1 + value2 + value3 + value4;

		// ouput = Your account balance is 2,500 on 5/15/2013

		assertEquals("Your account balance was 2,500 on 5/15/2013", output);
	}

	@Test
	public void format_message_with_messageformatter() {

		Object[] accountValues = { "2,500", "5/15/2013" };
		String output = MessageFormat.format("Your account balance was {0} on {1}", accountValues);

		// ouput = Your account balance is 2,500 on 5/15/2013
		assertEquals("Your account balance was 2,500 on 5/15/2013", output);
	}

	@Test
	public void messageformatter_mutliple_records() {

		Object[][] statementValues = { { "2,500", "5/15/2013" },
				{ "2,200", "6/15/2013" } };

		MessageFormat formatter = new MessageFormat("Your account balance was {0} on {1}");

		List<String> statementOutput = new ArrayList<String>();
		for (Object[] monthlyStatements : statementValues) {
			statementOutput.add(formatter.format(monthlyStatements));
		}

		// statement output:
		// Your account balance was 2,500 on 5/15/2013
		// Your account balance was 2,200 on 6/15/2013

		assertTrue(statementOutput.size() == 2);
		assertEquals("Your account balance was 2,500 on 5/15/2013", statementOutput.get(0));
		assertEquals("Your account balance was 2,200 on 6/15/2013",statementOutput.get(1));

	}

	@Test
	public void messageformatter_with_format_type_and_style() {

		DateTime statementDate = new DateTime(2013, 5, 15, 0, 0, 0, 0);
		double satementBalance = 2500;

		Object[] statementValues = { satementBalance, statementDate.toDate() };

		String output = MessageFormat.format("Your account balance was {0, number, currency} on {1, date, MM/dd/yyyy}", statementValues);

		assertEquals("Your account balance was $2,500.00 on  05/15/2013", output);
	}
	
	@Test
	public void messageformatter_with_choice() {
		
		String pattern = "Your statement on {0, date, MM/dd/yyyy} {1,choice,0#is not available|1#is {1, number, currency}}";
		MessageFormat statementFormat = new MessageFormat(pattern);
		
		DateTime statementDate1 = new DateTime(2013, 5, 15, 0, 0, 0, 0);

		Object[] statement1 = {statementDate1.toDate(), 23444};
		assertEquals("Your statement on  05/15/2013 is $23,444.00", statementFormat.format(statement1));
		
		DateTime statementDate2 = new DateTime(2013, 6, 15, 0, 0, 0, 0);
		Object[] statement2 = {statementDate2.toDate(), 0};
		assertEquals("Your statement on  06/15/2013 is not available", statementFormat.format(statement2));
		
	}
	
}
