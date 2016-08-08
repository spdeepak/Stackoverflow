package com.destack.overflow.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateUtilsTest {

    protected static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyddMM");

    @Test
    public void test() throws ParseException {
        assertEquals(Long.valueOf(1467763200), DateUtils.dateToMilliSecondsConverter(20160607L));
        assertEquals("20160607", DateUtils.milliSecondsDateToProperDate(1467763200L));
        assertEquals(Long.valueOf(1467763200), DateUtils.dateToMilliSecondsConverter(new Date(20160607L).getTime()));
        assertTrue(DateUtils.dateVerifier(new Date(20160607L).getTime()));
        assertTrue(DateUtils.datesVerifier(new Date(20160607L).getTime(), new Date(20160607L).getTime()));
        assertTrue(DateUtils.datesVerifier(20160607L, 20160607L));
        assertTrue(DateUtils.dateVerifier(20160607L));
    }

}
