package com.levelup.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;

import com.google.common.base.Objects;

/**
 * This java example will demonstrate how to override the toString in java with 
 * straight up java, google guava and apache commons.
 * 
 * @author Justin Musgrove
 * @see <a href="http://www.leveluplunch.com/java/examples/override-object-tostring/">Override toString</a>
 */
public class OverrideToString {

	private static final String CAPITAL = "Madison";
	private static final String STATE_CODE = "WI";
	
	class OverrideTooStringWithJava {
		
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
	
	class OverrideToStringWithGuava {
		
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
	
	class OverrideToStringWithApacheCommons {
		
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
	
	
	@Test 
	public void override_toString_With_java () {
		OverrideTooStringWithJava overrideTooString = new OverrideTooStringWithJava();
		overrideTooString.setCapital(CAPITAL);
		overrideTooString.setStateCode(STATE_CODE);

		assertEquals("state capital Madison , state code WI", overrideTooString.toString());
		
	}
	
	@Test 
	public void override_toString_with_guava () {
		OverrideToStringWithGuava guavaOverrideToString = new OverrideToStringWithGuava();
		guavaOverrideToString.setCapital(CAPITAL);
		guavaOverrideToString.setStateCode(STATE_CODE);

		assertEquals("OverrideToStringWithGuava{state capital=Madison, state code=WI}", guavaOverrideToString.toString());
	}
	
	@Test 
	public void override_toString_with_apachecommons () {
		OverrideToStringWithApacheCommons apacheCommonsToString = new OverrideToStringWithApacheCommons();
		apacheCommonsToString.setCapital(CAPITAL);
		apacheCommonsToString.setStateCode(STATE_CODE);

		assertTrue(apacheCommonsToString.toString().contains("[state capital=Madison,state code=WI]"));
	}


	
	
}
