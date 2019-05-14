package com.slupski.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

import static java.util.Locale.getDefault;

public class WeekGenerator {

    private static LocalDate ABSOLUTE_START = LocalDate.of(2019, 04,26);
    private static int WEEK_OF_ABOLUTE_YEAR = ABSOLUTE_START.get(WeekFields.of(getDefault()).weekOfWeekBasedYear());
    private static int WEEKS_IN_YEAR = 54;

    public static int getWeekNumber(){
        return getWeekNumber(LocalDate.now());
    }

    public static int getWeekNumber(LocalDate day){
        int result = 0;
        int actualWeekThisYear = day.get(WeekFields.of(getDefault()).weekOfWeekBasedYear());

        int year = day.getYear();
        result+= (year - ABSOLUTE_START.getYear()) * WEEKS_IN_YEAR;
        result+=actualWeekThisYear-WEEK_OF_ABOLUTE_YEAR;

        return result;
    }
}
