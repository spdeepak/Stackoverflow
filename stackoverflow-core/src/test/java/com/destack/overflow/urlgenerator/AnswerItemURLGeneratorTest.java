package com.destack.overflow.urlgenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashSet;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.destack.overflow.enums.AnswerSortBy;
import com.destack.overflow.enums.FetchFromAnswer;
import com.destack.overflow.enums.Order;
import com.destack.overflow.initializers.AnswerItemInitializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class AnswerItemURLGeneratorTest {

    @Resource
    AnswerItemURLGenerator answerItemURLGenerator;

    @Test
    public void testCreateAllAnswersInitializerInstance() throws Exception {
        AnswerItemInitializer ai = AnswerItemInitializer.createAllAnswersInitializerInstance(1, 10, 20140101L,
                20143101L, Order.DESC, AnswerSortBy.ACTIVITY, 20140101L, 20143101L);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&fromdate=1388534400&todate=1391126400&order=desc&min=1388534400&max=1391126400&sort=activity&site=stackoverflow",
                answerItemURLGenerator.urlGenerator(ai).toString());

        ai = AnswerItemInitializer.createAllAnswersInitializerInstance(1, 10, null, null, null, null, null, null);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&order=desc&sort=activity&site=stackoverflow",
                answerItemURLGenerator.urlGenerator(ai).toString());

        ai = AnswerItemInitializer.createAllAnswersInitializerInstance(1, 10, 20140101L, 20143101L, Order.ASC,
                AnswerSortBy.VOTES, null, null);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&fromdate=1388534400&todate=1391126400&order=asc&sort=votes&site=stackoverflow",
                answerItemURLGenerator.urlGenerator(ai).toString());

        ai = AnswerItemInitializer.createAllAnswersInitializerInstance(1, 10, 20140101L, 20143101L, Order.ASC,
                AnswerSortBy.CREATION, null, null);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers?page=1&pagesize=10&fromdate=1388534400&todate=1391126400&order=asc&sort=creation&site=stackoverflow",
                answerItemURLGenerator.urlGenerator(ai).toString());
    }

    @Test
    public void testCreateAnswerIdInitializerInstance() throws ParseException, MalformedURLException {
        AnswerItemInitializer ai = AnswerItemInitializer.createAnswerIdInitializerInstance(0, 0, 20110101L, 20161407L,
                Order.ASC, AnswerSortBy.CREATION, null, null, new HashSet<>(Arrays.asList(11775670L, 14396416L)),
                FetchFromAnswer.ID_ANSWER);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers/14396416;11775670?fromdate=1293840000&todate=1468454400&order=asc&sort=creation&site=stackoverflow",
                answerItemURLGenerator.urlGenerator(ai).toString());

        ai = AnswerItemInitializer.createAnswerIdInitializerInstance(0, 0, 20110101L, 20161407L, Order.ASC,
                AnswerSortBy.CREATION, null, null, new HashSet<>(Arrays.asList(11775670L, 14396416L)),
                FetchFromAnswer.QUESTIONS_IDANSWER);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers/14396416;11775670/questions?fromdate=1293840000&todate=1468454400&order=asc&sort=creation&site=stackoverflow",
                answerItemURLGenerator.urlGenerator(ai).toString());

        ai = AnswerItemInitializer.createAnswerIdInitializerInstance(0, 0, 20110101L, 20161407L, Order.ASC,
                AnswerSortBy.CREATION, null, null, new HashSet<>(Arrays.asList(11775670L, 14396416L)),
                FetchFromAnswer.COMMENTS_IDANSWER);
        assertEquals(
                "https://api.stackexchange.com/2.2/answers/14396416;11775670/comments?fromdate=1293840000&todate=1468454400&order=asc&sort=creation&site=stackoverflow",
                answerItemURLGenerator.urlGenerator(ai).toString());
    }

    @Test
    public void testExceptions() throws ParseException {
        AnswerItemInitializer ai;
        try {
            ai = AnswerItemInitializer.createAnswerIdInitializerInstance(0, 0, 20110101L, 20161407L, Order.ASC,
                    AnswerSortBy.CREATION, null, null, null, FetchFromAnswer.ID_ANSWER);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("IDs cannot be null or empty"));
        }

        try {
            ai = AnswerItemInitializer.createAnswerIdInitializerInstance(0, 0, 20110101L, 20161407L, Order.ASC,
                    AnswerSortBy.CREATION, null, null, new HashSet<>(Arrays.asList(11775670L, 14396416L)), null);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().equals("FetchFromAnswer is not valid"));
        }

        try {
            ai = AnswerItemInitializer.createAllAnswersInitializerInstance(1, 10, null, null, null, null, 10L, 100L);
        } catch (IllegalArgumentException e) {
            assertEquals("As AnswerSortBy is not by Votes Min & Max should be dates and in 'yyyyddMM' format",
                    e.getMessage());
        }
    }

    @Test
    public void testDateVerifier() throws ParseException {
        AnswerItemInitializer ai = AnswerItemInitializer.createAllAnswersInitializerInstance(0, 0, 32653265L, 32653232L,
                Order.ASC, AnswerSortBy.ACTIVITY, null, null);
        assertEquals(Long.valueOf(0L), ai.getFromDate());
        assertEquals(Long.valueOf(0L), ai.getToDate());
    }

}