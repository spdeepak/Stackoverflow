package com.destack.overflow.fetcher;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class InfoItemFetcherTest {

    @Resource
    InfoItemFetcher infoItemFetcher;

    @Test
    public void test() throws MalformedURLException {
        assertTrue(infoItemFetcher.objectFetcher().getNew_active_users() != null);
        assertTrue(infoItemFetcher.objectFetcher().getTotal_users() != null);
        assertTrue(infoItemFetcher.objectFetcher().getBadges_per_minute() != 0);
        assertTrue(infoItemFetcher.objectFetcher().getTotal_badges() != null);
        assertTrue(infoItemFetcher.objectFetcher().getTotal_votes() != null);
        assertTrue(infoItemFetcher.objectFetcher().getTotal_comments() != null);
        assertTrue(infoItemFetcher.objectFetcher().getAnswers_per_minute() != 0);
        assertTrue(infoItemFetcher.objectFetcher().getQuestions_per_minute() != 0);
        assertTrue(infoItemFetcher.objectFetcher().getTotal_answers() != null);
        assertTrue(infoItemFetcher.objectFetcher().getTotal_accepted() != null);
        assertTrue(infoItemFetcher.objectFetcher().getTotal_unanswered() != null);
        assertTrue(infoItemFetcher.objectFetcher().getTotal_questions() != null);
        assertTrue(!infoItemFetcher.objectFetcher().getApi_revision().isEmpty());
    }

}
