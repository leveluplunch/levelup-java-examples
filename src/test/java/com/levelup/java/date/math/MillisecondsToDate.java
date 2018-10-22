package com.levelup.java.date.math;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class MillisecondsToDate {

    public static String dateFormat = "dd-MM-yyyy hh:mm:ss S";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

    @Test
    public void milliseconds_to_date_in_java() {
        long now = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now);
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }

}
