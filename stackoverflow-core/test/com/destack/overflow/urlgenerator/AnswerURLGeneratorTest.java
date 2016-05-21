package com.destack.overflow.urlgenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.destack.overflow.enums.Order;
import com.destack.overflow.enums.SortBy;
import com.destack.overflow.initializers.AnswerInitializer;
import com.destack.overflow.urlgenerator.AnswerURLGenerator;

public class AnswerURLGeneratorTest {

    AnswerURLGenerator af = new AnswerURLGenerator();

    AnswerInitializer ai;

    @Test
    public void answerURLGeneratorTest() throws Exception {
        ai = new AnswerInitializer(1, 10, 20140101, 20143101, Order.DESC, SortBy.ACTIVITY, 20140101, 20143101);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&fromdate=1388534400&todate=1391126400&order=desc&sort=activity&min=1388534400&max=1391126400&site=stackoverflow",
                af.urlGenerator(ai).toString());

        ai = new AnswerInitializer(1, 10, 0, 0, null, null, 10, 100);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&order=desc&sort=activity&site=stackoverflow",
                af.urlGenerator(ai).toString());

        ai = new AnswerInitializer(1, 10, 20140101, 20143101, Order.ASC, SortBy.VOTES, 0, 0);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&fromdate=1388534400&todate=1391126400&order=asc&sort=votes&site=stackoverflow",
                af.urlGenerator(ai).toString());
    }

}
