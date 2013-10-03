package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate examples
 * using a {@link FluentIterable}
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-fluent-iterableterable-example'>Fluentiterable example</a>
 * 
 */
public class FluentIterableExample {
	
	private static final Logger logger = Logger.getLogger(FluentIterableExample.class);

	
	class State {
		
		private String stateAbbreviation;
		private boolean expandedMedicade;

		public State(String stateAbbreviation, boolean expandedMedicade) {
			super();
			this.stateAbbreviation = stateAbbreviation;
			this.expandedMedicade = expandedMedicade;
		}
		
		public String getStateAbbreviation() {
			return stateAbbreviation;
		}
		public boolean isExpandedMedicade() {
			return expandedMedicade;
		}

		@Override
		public String toString() {
			return Objects.toStringHelper(State.class)
					.add("stateAbbreviation", stateAbbreviation)
					.add("expandedMedicade", expandedMedicade)
					.toString();
		}

	}
	
	class Message {

		private String stateAbbreviation;
		private String messageToResidence;

		public String getMessageToResidence() {
			return messageToResidence;
		}

		public void setMessageToResidence(String messageToResidence) {
			this.messageToResidence = messageToResidence;
		}
		
		public String getStateAbbreviation() {
			return stateAbbreviation;
		}

		public void setStateAbbreviation(String stateAbbreviation) {
			this.stateAbbreviation = stateAbbreviation;
		}

		@Override
		public String toString() {
			return Objects.toStringHelper(State.class)
					.add("stateAbbreviation", stateAbbreviation)
					.add("messageToResidence", messageToResidence)
					.toString();
		}
	}
	
	
	List<State> states = Lists.newArrayList(
			new State("MT", false),
			new State("ID", false),
			new State("WY", false),
			new State("SD", false),
			new State("NE", false),
			new State("WI", false), 
			new State("IN", false),
			new State("TX", false), 
			new State("CA", true),
			new State("AZ", true),
			new State("NM", true),
			new State("AR", true),
			new State("IL", true),
			new State("IA", true));

	Predicate<State> byExpandedMedicade = new Predicate<State>() {
		public boolean apply(State input) {
			return input.isExpandedMedicade();
		}
	};
	
	Function<State, Message> messages = new Function<State, Message>() {
		public Message apply(State state) {

			String stateCode = state.getStateAbbreviation();
			Message message = new Message();
			message.setStateAbbreviation(stateCode);
			message.setMessageToResidence("<a href='" + stateCode + "'>"
					+ stateCode + "</a>");

			return message;
		}
	};

	/**
	 *	This test will filter a list of states and then transform
	 *  elements into messages
	 *  
	 */
	@Test
	public void filter_transform_list () {
		
		List<Message> stateMessages = FluentIterable.from(states)
			.filter(byExpandedMedicade)
			.transform(messages)
			.toList();
		
		logger.info(stateMessages);
		
		assertEquals(6, stateMessages.size());
		
	}
	

}
