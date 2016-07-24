package com.destack.overflow.util;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class DateUtilsTest {

    @Test
    public void test() throws ParseException {
        assertEquals(Long.valueOf(1467763200), DateUtils.dateToMilliSecondsConverter(20160607L));
        assertEquals("6-7-2016", DateUtils.milliSecondsDateToProperDate(1467763200L));
    }

}
