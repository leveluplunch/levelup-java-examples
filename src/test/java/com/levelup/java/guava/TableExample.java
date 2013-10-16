package com.levelup.java.guava;

import java.util.Map.Entry;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * This java example demonstrate how to use 
 * Google Guava Tables.  Tables can be thought a <table>
 * on a web page (columns, rows, and values).  
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/guava-table-example/'>Table example</a>
 * 
 */
public class TableExample {
	
	private static final Logger logger = Logger.getLogger(TableExample.class);

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

	@Test
	public void guava_table_example () {
		
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
			
			logger.info("Person: " + key);

			for (Entry<String, Workout> row : table.row(key).entrySet()) {
				logger.info("Workout name: " + row.getKey() + " for elapsed time of " + row.getValue().getElapsedTime());
			}
		}
	}
	
}
