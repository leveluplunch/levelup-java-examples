package com.levelup.java.junit;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * This java example will demonstrate testing for exception with junit.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/junit-exception-testing/'>Junit exception testing</a>
 * 
 */
public class ExceptionTesting {

	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void check_for_nullpointer_exception_junit() {
		
		String test = null;
		
		if (test.length() == 5) {}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void check_for_indexoutofbounds_exception_junit() {
		new ArrayList<String>().get(0);
	}

	@Test
	public void test_for_exception_try_catch_junit() {
		try {
			new ArrayList<String>().get(0);
			fail("Expected an IndexOutOfBoundsException to be thrown");
			
		} catch (IndexOutOfBoundsException e) {
			assertThat(
					e.getMessage(),
					isA(String.class));
		}
	}
	  
	@Rule public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_for_exception_with_rule_junit() throws IndexOutOfBoundsException {
        List<String> list = new ArrayList<String>();

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");
        list.get(0); // execution will never get past this line
    }
	
}
