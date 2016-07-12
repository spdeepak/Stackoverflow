package com.destack.overflow.initializers;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

import com.destack.overflow.enums.AnswerSortBy;
import com.destack.overflow.enums.Order;

public class AnswerItemInitializerTest {

    @Test
    public void test() throws ParseException {
        AnswerItemInitializer ai = AnswerItemInitializer.createAllAnswersInitializerInstance(1, 100, 20140101, 20143101,
                Order.ASC, AnswerSortBy.ACTIVITY,
                20140101, 20143101);
        assertEquals(Integer.valueOf(1), ai.getPage());
        assertEquals(Integer.valueOf(100), ai.getPageSize());
        assertEquals(1388534400, ai.getFromDate().longValue());
        assertEquals(1391126400, ai.getToDate().longValue());
        assertEquals(Order.ASC, ai.getOrder());
        assertEquals(AnswerSortBy.ACTIVITY, ai.getSort());
        assertEquals(1388534400, ai.getMin().intValue());
        assertEquals(1391126400, ai.getMax().intValue());
        //System.out.println(new SimpleDateFormat("yyyyddMM").format(new Date()));
    }

}
