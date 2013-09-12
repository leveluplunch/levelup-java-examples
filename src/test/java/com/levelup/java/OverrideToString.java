package com.levelup.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;

import com.google.common.base.Objects;

/**
 * This java snippet will demonstrate how to override the toString in java with 
 * straight up java, google guava and apache commons.
 * 
 * @author Justin Musgrove
 * @see <a href="http://www.leveluplunch.com/java">Override toString</a>
 */
public class OverrideToString {

	private static final String CAPITAL = "Madison";
	private static final String STATE_CODE = "WI";
	
	class OverrideTooString {
		
		private String capital = null;
		private String stateCode = null;
		
		@Override
		public String toString() {
			
			StringBuffer sb = new StringBuffer();
			sb.append("state capital ");
			sb.append(capital);
			sb.append(" , ");
			sb.append("state code ");
			sb.append(stateCode);
			
			return sb.toString();
		}

		public void setCapital(String capital) {
			this.capital = capital;
		}

		public void setStateCode(String stateCode) {
			this.stateCode = stateCode;
		}
	}
	

	class ApacheCommonsToString {
		
		private String capital = null;
		private String stateCode = null;
		
		@Override
		public String toString() {

			return new ToStringBuilder(this).
				       append("state capital", capital).
				       append("state code", stateCode).
				       toString();
			
		}

		public void setCapital(String capital) {
			this.capital = capital;
		}

		public void setStateCode(String stateCode) {
			this.stateCode = stateCode;
		}
		
		
	}
	
	class GuavaOverrideToString {
		
		private String capital = null;
		private String stateCode = null;
		
		@Override
		public String toString() {
			return Objects.toStringHelper(this)
					.add("state capital", capital)
					.add("state code", stateCode)
					.toString();
		}

		public void setCapital(String capital) {
			this.capital = capital;
		}

		public void setStateCode(String stateCode) {
			this.stateCode = stateCode;
		}
		
	}
	
	@Test 
	public void override_ToString_With_Java () {
		OverrideTooString overrideTooString = new OverrideTooString();
		overrideTooString.setCapital(CAPITAL);
		overrideTooString.setStateCode(STATE_CODE);

		assertEquals("state capital Madison , state code WI", overrideTooString.toString());
		
	}
	
	@Test 
	public void apachecommons_toString () {
		ApacheCommonsToString apacheCommonsToString = new ApacheCommonsToString();
		apacheCommonsToString.setCapital(CAPITAL);
		apacheCommonsToString.setStateCode(STATE_CODE);

		assertTrue(apacheCommonsToString.toString().contains("[state capital=Madison,state code=WI]"));

		
	}

	@Test 
	public void guava_override_toString () {
		GuavaOverrideToString guavaOverrideToString = new GuavaOverrideToString();
		guavaOverrideToString.setCapital(CAPITAL);
		guavaOverrideToString.setStateCode(STATE_CODE);

		assertEquals("GuavaOverrideToString{state capital=Madison, state code=WI}", guavaOverrideToString.toString());
	}

	
	
}
