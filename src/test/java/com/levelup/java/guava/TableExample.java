package com.levelup.java.guava;

import java.util.Map.Entry;
import java.util.Random;

import org.junit.Test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * This java example demonstrate how to use 
 * Google Guava Tables.  Tables can be thought a <table>
 * on a web page (columns, rows, and values).  
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/'>Google Guava Table Example</a>
 * 
 */
public class TableExample {


	@Test
	public void google_table_example () {
		
		Random r = new Random(3000);
		
		Table<Integer, String, Workout> table = HashBasedTable.create();
		table.put(1, "Filthy 50", new Workout(r.nextLong()));
		table.put(1, "Fran", new Workout(r.nextLong()));
		table.put(1, "The Seven", new Workout(r.nextLong()));
		table.put(1, "Murph", new Workout(r.nextLong()));
		table.put(1, "The Ryan", new Workout(r.nextLong()));
		table.put(1, "King Kong", new Workout(r.nextLong()));
		
		table.put(2, "Filthy 50", new Workout(r.nextLong()));
		table.put(2, "Fran", new Workout(r.nextLong()));
		table.put(2, "The Seven", new Workout(r.nextLong()));
		table.put(2, "Murph", new Workout(r.nextLong()));
		table.put(2, "The Ryan", new Workout(r.nextLong()));
		table.put(2, "King Kong", new Workout(r.nextLong()));
		// for each row key
		for (Integer key : table.rowKeySet()) {
			
			System.out.println("Person: " + key);
			
			for (Entry<String, Workout> row : table.row(key).entrySet()) {
				System.out.println("Workout name: " + row.getKey() + " for elapsed time of " + row.getValue().getElapsedTime());
			}
		}
		
//		Person: 1
//		Workout name: Fran for elapsed time of -3977836004464389794
//		Workout name: Filthy 50 for elapsed time of -1829658912453740411
//		Workout name: The Ryan for elapsed time of -5936096732377749355
//		Workout name: King Kong for elapsed time of -8907559694567582447
//		Workout name: The Seven for elapsed time of 6521040382569966014
//		Workout name: Murph for elapsed time of 6409947991931540389
//		Person: 2
//		Workout name: Fran for elapsed time of 4788962511073602185
//		Workout name: Filthy 50 for elapsed time of -8862458082187530072
//		Workout name: The Ryan for elapsed time of -8390610864514533585
//		Workout name: King Kong for elapsed time of -6941701245565016971
//		Workout name: The Seven for elapsed time of -1334074812925499922
//		Workout name: Murph for elapsed time of -2915469141161687325
	}
	
	class Workout {
		private long elapsedTime;

		public Workout(long elapsedTime) {
			super();
			this.elapsedTime = elapsedTime;
		}
		
		public long getElapsedTime() {
			return elapsedTime;
		}
	}
}
