package com.destack.overflow.urlgenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.destack.overflow.enums.AnswerSortBy;
import com.destack.overflow.enums.Order;
import com.destack.overflow.initializers.AnswerInitializer;

public class AnswerItemURLGeneratorTest {

    @Test
    public void answerURLGeneratorTest() throws Exception {
        AnswerItemURLGenerator aiURLgen = new AnswerItemURLGenerator();
        AnswerInitializer ai = new AnswerInitializer(1, 10, 20140101, 20143101, Order.DESC, AnswerSortBy.ACTIVITY,
                20140101, 20143101);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&fromdate=1388534400&todate=1391126400&order=desc&sort=activity&min=1388534400&max=1391126400&site=stackoverflow",
                aiURLgen.urlGenerator(ai).toString());

        ai = new AnswerInitializer(1, 10, 0, 0, null, null, 10, 100);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&order=desc&sort=activity&site=stackoverflow",
                aiURLgen.urlGenerator(ai).toString());

        ai = new AnswerInitializer(1, 10, 20140101, 20143101, Order.ASC, AnswerSortBy.VOTES, 0, 0);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&fromdate=1388534400&todate=1391126400&order=asc&sort=votes&site=stackoverflow",
                aiURLgen.urlGenerator(ai).toString());
        ai = null;
        aiURLgen = null;
    }


}