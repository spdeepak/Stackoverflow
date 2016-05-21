package com.destack.overflow.initializers;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.destack.overflow.enums.Order;
import com.destack.overflow.enums.SortBy;
import com.destack.overflow.initializers.AnswerInitializer;

public class AnswerInitializerTest {

    @Test
    public void test() throws ParseException {
        AnswerInitializer ai = new AnswerInitializer(1, 100, 20140101, 20143101, Order.ASC, SortBy.ACTIVITY, 20140101,
                20143101);
        assertEquals(1, ai.getPage());
        assertEquals(100, ai.getPageSize());
        assertEquals(1388534400, ai.getFromDate());
        assertEquals(1391126400, ai.getToDate());
        assertEquals(Order.ASC, ai.getOrder());
        assertEquals(SortBy.ACTIVITY, ai.getSort());
        assertEquals(1388534400, ai.getMin());
        assertEquals(1391126400, ai.getMax());
        System.out.println(new SimpleDateFormat("yyyyddMM").format(new Date()));
    }

}
