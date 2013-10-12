package com.levelup.java.html;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;
import org.springframework.web.util.HtmlUtils;

import com.google.common.html.HtmlEscapers;

/**
 * This java example will demonstrate escaping html
 * using java methods
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/escape-html/'>Escape Html</a>
 * 
 */
public class EscapeHtml {

	private static final String HTML_TO_ESCAPE = "<html><p>Escape this</p></html>";
	
	@Test
	public void escape_html_with_straight_java () {
		
		// Do not recommend escaping HTML this way
		String escapedHtml = HTML_TO_ESCAPE
								.replaceAll("&", "&amp;")
								.replaceAll("\"", "&quot;")
								.replaceAll("<", "&lt;")
								.replaceAll(">", "&gt;");
		
		assertEquals("&lt;html&gt;&lt;p&gt;Escape this&lt;/p&gt;&lt;/html&gt;", escapedHtml);
	}

	@Test
	public void escape_html_with_guava () {
		
		// escapes the following:  '"&<>.  
		String escapedHtml = HtmlEscapers.htmlEscaper().escape(HTML_TO_ESCAPE);

		// escapedHTML = &lt;html&gt;&lt;p&gt;Escape this&lt;/p&gt;&lt;/html&gt;
		
		assertEquals("&lt;html&gt;&lt;p&gt;Escape this&lt;/p&gt;&lt;/html&gt;", escapedHtml);
	}
	
	@Test
	public void escape_html_with_spring () {
		
		String escapedHtml = HtmlUtils.htmlEscape(HTML_TO_ESCAPE);

		// escapedHTML = &lt;html&gt;&lt;p&gt;Escape this&lt;/p&gt;&lt;/html&gt;
		
		assertEquals("&lt;html&gt;&lt;p&gt;Escape this&lt;/p&gt;&lt;/html&gt;", escapedHtml);
	}
	
	@Test
	public void escape_html_with_apache_commons () {
	
		//escapes \&<>, ISO-8859-1 charachters, escape additional entities for more infor
		String escapedHTML = StringEscapeUtils.escapeHtml4(HTML_TO_ESCAPE);

		// escapedHtml = &lt;html&gt;&lt;p&gt;Escape this&lt;/p&gt;&lt;/html&gt;
		assertEquals("&lt;html&gt;&lt;p&gt;Escape this&lt;/p&gt;&lt;/html&gt;", escapedHTML);
	
	}
	
	// at this time I don't want to include android dependency
	@Test
	public void escape_html_with_android () {
//		TextUtils.htmlEncode(String)
	}
	
	
	
}
