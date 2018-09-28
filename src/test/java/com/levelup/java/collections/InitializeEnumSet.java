package com.levelup.java.collections;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class InitializeEnumSet {

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    @Test
    public void initialize_immutable_enumset() {
        Set<Day> daySet = Collections.unmodifiableSet(EnumSet.of(Day.MONDAY,
                Day.TUESDAY,
                Day.WEDNESDAY,
                Day.THURSDAY,
                Day.FRIDAY,
                Day.SATURDAY,
                Day.SUNDAY));

        assertEquals(7, daySet.size());

    }

}
