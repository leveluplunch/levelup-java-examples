package com.levelup.java.number;

import static java.lang.Math.toIntExact;

import org.junit.Test;

public class Casting {

    @Test
    public void longToInt() {
        long longValue = 1223321L;
        int longTointValue = toIntExact(longValue);
        System.out.println(longTointValue);
    }
}
