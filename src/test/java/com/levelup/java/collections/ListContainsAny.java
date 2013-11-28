package com.levelup.java.collections;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This java example will demonstrate if a list 
 * containing any element.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/where-list-contains-any-elements/'>List contains any element</a>
 */
public class ListContainsAny {

	class Vehicle {

		String manufacturer;
		String model;
		int year;
		
		public Vehicle(String manufacturer, String model, int year) {
			super();
			this.manufacturer = manufacturer;
			this.model = model;
			this.year = year;
		}
		
		@Override
		public String toString() {
			return Objects.toStringHelper(this)
					.add("manufacturer", manufacturer)
					.add("model", model)
					.add("year", year)
					.toString();
		}
	}
	
	List<Vehicle> vehicles;
	
	@Before
	public void setUp () {
		vehicles = Lists.newArrayList();
		vehicles.add(new Vehicle("Dodge", "CHARGER", 1965));
		vehicles.add(new Vehicle("Dodge", "VIPER CONVERTIBLE", 2006));
		vehicles.add(new Vehicle("Oldsmobile", "BRAVADA", 2004));
		vehicles.add(new Vehicle("GMC", "C1500 YUKON 2WD HYBRID", 2012));
		vehicles.add(new Vehicle("GMC", "K1500 YUKON 4WD", 2013));
		vehicles.add(new Vehicle("Chrysler", "PT Cruiser", 2006));
	}
	
	@Test
	public void list_contains_any_java () {
		
		// assuming 2013
		boolean vehiclesFiveYearOrOlder = false;
		for (Vehicle vehicle : vehicles) {
			if ( (vehicle.year - 5) <= 2008) {
				vehiclesFiveYearOrOlder = true;
				break;
			}
		}

		assertTrue(vehiclesFiveYearOrOlder);
	}
	
	@Test
	public void list_contains_any_guava () {

		boolean vehiclesContainDodge = Iterables.any(vehicles, new Predicate<Vehicle>() {
			public boolean apply(Vehicle input) {
				return input.manufacturer.equals("Dodge");
			}
		});
		
		assertTrue(vehiclesContainDodge);
	}

	@Test
	public void list_contains_any_apache_commons () {

		int numberOfYukons = CollectionUtils.countMatches(vehicles, new org.apache.commons.collections.Predicate() {
			public boolean evaluate(Object object) {
				Vehicle vehicle = (Vehicle) object;
				return vehicle.model.contains("YUKON");
			}
		});
		
		assertTrue(numberOfYukons != 0);
	}
	
}
