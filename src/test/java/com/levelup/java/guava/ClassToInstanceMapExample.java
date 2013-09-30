package com.levelup.java.guava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

/**
 * This java example will demonstrate a use case for ClassToInstanceMap.
 * 
 * In many cases you need to gather multiple objects that relate to each other.  You may make 
 * 1:M db calls to get a set of objects, make web service requests, etc.  For instance, 
 * lets say you have a person, a person has addresses,  a person has jobs.  
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'>ClassToInstanceMap Example</a>
 * 
 */
public class ClassToInstanceMapExample {

	class Person {
		private String name;
		
		public Person(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
	
	class Jobs {
		private String jobName;

		public Jobs(String jobName) {
			super();
			this.jobName = jobName;
		}
		
		public String getJobName() {
			return jobName;
		}
	}
	
	class Address {
		private String streetName;

		public Address(String streetName) {
			super();
			this.streetName = streetName;
		}

		public String getStreetName() {
			return streetName;
		}
	}
	
	@Test
	public void classToINstanceMap_example () {
		
		Person person = new Person("Jackson");
		Jobs jobs = new Jobs("IT person");
		Address address = new  Address("505 Williams Street");
		
		ClassToInstanceMap<Object> classToInstanceMap = MutableClassToInstanceMap.create();
		classToInstanceMap.put(Person.class, person);
		classToInstanceMap.put(Jobs.class, jobs);
		classToInstanceMap.put(Address.class, address);
		
		// classToInstanceMap = {class com.levelup.java.guava.ClassToInstanceMapExample$Address=com.levelup.java.guava.ClassToInstanceMapExample$Address@7a148bd3, class com.levelup.java.guava.ClassToInstanceMapExample$Person=com.levelup.java.guava.ClassToInstanceMapExample$Person@5ae80842, class com.levelup.java.guava.ClassToInstanceMapExample$Jobs=com.levelup.java.guava.ClassToInstanceMapExample$Jobs@377653ae}
		assertEquals("IT person", classToInstanceMap.getInstance(Jobs.class).getJobName());
	}
	
	
	
}
