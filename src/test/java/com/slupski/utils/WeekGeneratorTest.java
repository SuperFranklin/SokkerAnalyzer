package com.slupski.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class WeekGeneratorTest {

    @Test
    public void testGetWeekNumber0(){
        LocalDate date1 = LocalDate.of(2019, 04,25);
        int result1 = WeekGenerator.getWeekNumber(date1);
        Assert.assertEquals(result1, 0);

    }
    @Test
    public void testGetWeekNumberNextWeek(){
        LocalDate date3 = LocalDate.of(2019, 05,01);
        int result3 = WeekGenerator.getWeekNumber(date3);
        Assert.assertEquals(1, result3);
    }

    @Test
    public void testGetWeekNumberNextMonth(){
        LocalDate date3 = LocalDate.of(2019, 06,01);
        int result3 = WeekGenerator.getWeekNumber(date3);
        Assert.assertEquals(5, result3);
    }

    @Test
    public void testGetWeekNumberNextYear(){
        LocalDate date3 = LocalDate.of(2020, 04,24);
        int result3 = WeekGenerator.getWeekNumber(date3);
        Assert.assertEquals(54, result3);
    }
}
