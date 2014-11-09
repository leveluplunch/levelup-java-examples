package com.levelup.java.string;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This java example will demonstrate how to replace a string within a string
 * 
 * @author Justin Musgrove
 * @see <a href=
 *      'http://www.leveluplunch.com/java/examples/replace-substring-in-string-with-another-character/'>Replace
 *      char within a string</a>
 * 
 */
public class ReplaceStringInString {

	@Test
	public void replace_string_java() {

		String randomTweet = "I didn't realize that texting through "
				+ "@GoogleVoice worked while riding on a "
				+ "jet plane #forgottoblockport";

		String modifiedPhrase = randomTweet.replace("@GoogleVoice", "@GVoice");

		assertEquals("I didn't realize that texting through @GVoice "
				+ "worked while riding on a jet plane #forgottoblockport",
				modifiedPhrase);
	}

	@Test
	public void replace_string_apache() {

		String randomTweet = "Millennials are much more likely to share "
				+ "personal data with retailers in "
				+ "order to get customized offers";

		String modifiedPhrase = StringUtils.replace(randomTweet, "personal",
				"privae");

		assertEquals("Millennials are much more likely to share privae "
				+ "data with retailers in order to get customized offers",
				modifiedPhrase);

	}
}
