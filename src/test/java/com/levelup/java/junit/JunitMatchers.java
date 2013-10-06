package com.levelup.java.junit;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.*;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * This java example will demonstrate Junit matchers
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/junit-matchers/'>Junit matchers</a>
 * 
 */
public class JunitMatchers {

//	Per release notes https://github.com/junit-team/junit/blob/master/doc/ReleaseNotes4.11.md
//	Most of the matchers in JUnitMatchers have been deprecated. Please use org.hamcrest.CoreMatchers directly.
//	http://junit-team.github.io/junit/javadoc/latest/org/junit/matchers/JUnitMatchers.html
	
	@SuppressWarnings("deprecation")
	@Test
	public void test_string_contains_two_elements () {
		
		assertThat("B-double E double R U-N beer run", 
				both(containsString("beer"))
				.and(containsString("run")));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test_string_contains () {
		
		assertThat("Meet the press",
				containsString("press"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test_string_either_or () {

		assertThat("the simpsons",
				either(containsString("the")).or(containsString("simpsons")));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test_every_item_contains () {
		
		List<String> movies = Lists.newArrayList(
				"the matrix", 
				"the lord of the rings", 
				"the lion king", 
				"the dark knight");
		assertThat(movies, everyItem(containsString("the")));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test_list_has_items () {

		List<String> websites = Lists.newArrayList(
				"leveluplunch.com", 
				"www.leveluplunch.com" );

	    assertThat(websites, hasItems("leveluplunch.com"));
	}

}
