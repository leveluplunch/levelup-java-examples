package com.levelup.java.hamcrest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.object.HasToString.hasToString;
import static org.hamcrest.object.IsCompatibleType.typeCompatibleWith;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.base.Objects;

/**
 * This java example will demonstrate using 
 * hamcrest object matcher to test java objects
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/hamcrest-object-matchers-junit-testing/'>Object matchers</a>
 * 
 */
public class ObjectMatchers {

	class Drink {
		
		private String brand;
		private String name;
		private String type;
		
		public Drink(String brand, String name, String type) {
			super();
			this.brand = brand;
			this.name = name;
			this.type = type;
		}

		@Override
		public String toString() {
			return Objects.toStringHelper(this)
					.add("", brand)
					.add(name, name)
					.add(name, type)
					.toString();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((brand == null) ? 0 : brand.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Drink other = (Drink) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (brand == null) {
				if (other.brand != null)
					return false;
			} else if (!brand.equals(other.brand))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}

		private ObjectMatchers getOuterType() {
			return ObjectMatchers.this;
		}
		
	}

	@Test
	public void test_object_toString () {

		Drink softDrink = new Drink("Pepsi", "Mountain Dew", "Soft Drink");

		assertThat(
				softDrink,
				hasToString("Drink{=Pepsi, Mountain Dew=Mountain Dew, Mountain Dew=Soft Drink}"));
	}
	
	@Test
	public void test_object_equals_hashcode () {
		
		Drink softDrink1 = new Drink("coca-cola", "Coke Zero", "Soft Drink");
		Drink softDrink2 = new Drink("coca-cola", "Coke Zero", "Soft Drink");
		
		assertThat(softDrink1, equalTo(softDrink2)); 
	}

	@Test
	public void test_object_instanceOf () {

		Drink softDrink = new Drink(null, "Iced Tea", "Natural");

		assertThat(softDrink, instanceOf(Object.class));
	}

	@Test
	public void test_object_isCompatible_with() {

		assertThat(Drink.class, not(typeCompatibleWith(Number.class)));
		
		assertThat(Drink.class, typeCompatibleWith(Object.class));
	}

	@Test
	public void test_object_notNullValue () {
		
		Drink sportDrink = new Drink("Gatorade Co", "Gatorade", "Sport");

		assertThat(sportDrink, notNullValue());
	}
	
	@Test
	public void test_object_nullValue () {
		
		Drink sportDrink = null;

		assertThat(sportDrink, nullValue());
	}
	
}
