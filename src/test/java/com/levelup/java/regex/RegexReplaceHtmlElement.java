package com.levelup.java.regex;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This java example will demonstrate how to replace h2 elements.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/regex-append-replace-html-heading-elements/'>Regex to replace html heading elements</a>
 */
public class RegexReplaceHtmlElement {

@Test
public void replace_heading_elements() {

	String htmlContent = "<h2>Replace html heading</h2>";

	String h2Toh3 = htmlContent.replaceAll("<h2[^>]*>(.*?)</h2>",
			"<h3>$1 - HTML replaced</h3>");

	assertEquals("<h3>Replace html heading - HTML replaced</h3>", h2Toh3);
}

}
