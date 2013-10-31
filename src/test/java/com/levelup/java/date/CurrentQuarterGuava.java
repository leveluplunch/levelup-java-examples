package com.levelup.java.date;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Date;
import java.util.Map.Entry;

import org.joda.time.DateTime;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

/**
 * This java example will demonstrate getting current
 * quarter based on date that is passed.
 * 
 * @author Justin Musgrove
 * @see <a href='http://www.leveluplunch.com/java/examples/current-quarter-guava/'>Current quarter guava</a>
 * 
 */
public class CurrentQuarterGuava {

	private RangeMap<Date, Integer> quarters = TreeRangeMap.create();
	private Date dateToCompare;
	
	public CurrentQuarterGuava (Date date) {
		
		checkNotNull(date);
		
		this.dateToCompare = date;
		
		// create a JODA current time instance
		DateTime currentDate = new DateTime(dateToCompare);

		// set quarters
		DateTime q1BeginDate = new DateTime(currentDate.getYear(), 1, 1, 0, 0, 0, 0);
		DateTime q1EndDate = new DateTime(currentDate.getYear(), 3, 31, 0, 0, 0, 0);

		DateTime q2BeginDate = new DateTime(currentDate.getYear(), 4, 1, 0, 0, 0, 0);
		DateTime q2EndDate = new DateTime(currentDate.getYear(), 6, 30, 0, 0, 0, 0);

		DateTime q3BeginDate = new DateTime(currentDate.getYear(), 7, 1, 0, 0, 0, 0);
		DateTime q3EndDate = new DateTime(currentDate.getYear(), 9, 30, 0, 0, 0, 0);

		DateTime q4BeginDate = new DateTime(currentDate.getYear(), 10, 1, 0, 0, 0, 0);
		DateTime q4EndDate = new DateTime(currentDate.getYear(), 12, 31, 0, 0, 0, 0);

		//add to quarters
		quarters.put(Range.closed(q1BeginDate.toDate(), q1EndDate.toDate()), 1);
		quarters.put(Range.closed(q2BeginDate.toDate(), q2EndDate.toDate()), 2);
		quarters.put(Range.closed(q3BeginDate.toDate(), q3EndDate.toDate()), 3);
		quarters.put(Range.closed(q4BeginDate.toDate(), q4EndDate.toDate()), 4);
	}
	
	/**
	 * Method should return a integer representing
	 * the quarter in which the quarter date is in. 
	 * 
	 * @return integer 
	 */
	public Integer getQuarter () {
		return quarters.get(dateToCompare);
	}
	
	/**
	 * Method should return the quarter begin date
	 * 
	 * @return Date
	 */
	public Date getQuarterBeginDate () {
		
		Entry<Range<Date>, Integer> quarterAsDate = quarters.getEntry(dateToCompare);
		
		Range<Date> range = quarterAsDate.getKey();
		
		return range.lowerEndpoint();
	}
	
	/**
	 * Method should return the quarter end date
	 * 
	 * @return Date
	 */
	public Date getQuarterEndDate () {
		
		Entry<Range<Date>, Integer> quarterAsDate = quarters.getEntry(dateToCompare);

		Range<Date> range = quarterAsDate.getKey();
		
		return range.upperEndpoint();
	}
	
}
