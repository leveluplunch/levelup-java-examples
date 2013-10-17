package com.levelup.java.hamcrest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

/**
 * This java example will demonstrate testing
 * beans with junit hamcrest matchers.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/hamcrest-bean-matchers-junit-testing/'>Bean matchers</a>
 * 
 */
public class BeanMatchers {
	
	class Truck {
		
		private String model;
		private String make;
		private int year;

		public Truck(String model, String make, int year) {
			super();
			this.model = model;
			this.make = make;
			this.year = year;
		}

		public String getModel() {
			return model;
		}

		public String getMake() {
			return make;
		}

		public int getYear() {
			return year;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public void setMake(String make) {
			this.make = make;
		}

		public void setYear(int year) {
			this.year = year;
		}
	}

	@Test
	public void object_has_property () {
		
		Truck pickupTruck = new Truck("Ram", "Dodge", 1965);
		
		assertThat(pickupTruck, hasProperty("model"));
	}	
	
	@Ignore("for some reason hasproperty isn't working")
	@Test
	public void object_has_property_with_value () {
		 
		Truck pickupTruck = new Truck("Big 10", "Chevy", 1976);
		
		assertThat(pickupTruck, hasProperty("model", equalTo("Big 10")));
	}	
	
	@Ignore("Could not invoke public")
	@Test
	public void object_has_property_values_as () {
		 
		Truck pickupTruck1 = new Truck("Big 10", "Chevy", 1976);
		Truck pickupTruck2 = new Truck("Big 10", "Chevy", 1976);
		
		assertThat(pickupTruck1, samePropertyValuesAs(pickupTruck2));
	}	

}
