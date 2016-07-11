package com.destack.overflow.urlgenerator;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.destack.overflow.enums.AnswerSortBy;
import com.destack.overflow.enums.Order;
import com.destack.overflow.initializers.AnswerInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class AnswerItemURLGeneratorTest {

    @Resource
    AnswerItemURLGenerator answerItemURLGenerator;

    @Test
    public void answerURLGeneratorTest() throws Exception {
        AnswerInitializer ai = new AnswerInitializer(1, 10, 20140101L, 20143101L, Order.DESC, AnswerSortBy.ACTIVITY,
                20140101L, 20143101L);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&fromdate=1388534400&todate=1391126400&order=desc&min=1388534400&max=1391126400&sort=activity&site=stackoverflow",
                answerItemURLGenerator.urlGenerator(ai).toString());
        ai = null;
        ai = new AnswerInitializer(1, 10, 0, 0, null, null, 10, 100);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&order=desc&sort=activity&site=stackoverflow",
                answerItemURLGenerator.urlGenerator(ai).toString());
        ai = null;
        ai = new AnswerInitializer(1, 10, 20140101L, 20143101L, Order.ASC, AnswerSortBy.VOTES, 0, 0);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&fromdate=1388534400&todate=1391126400&order=asc&sort=votes&site=stackoverflow",
                answerItemURLGenerator.urlGenerator(ai).toString());
        ai = null;
        ai = new AnswerInitializer(1, 10, 20140101L, 20143101L, Order.ASC, AnswerSortBy.CREATION, 0, 0);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&fromdate=1388534400&todate=1391126400&order=asc&sort=creation&site=stackoverflow",
                answerItemURLGenerator.urlGenerator(ai).toString());
    }

}