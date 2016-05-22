package com.destack.overflow.fetcher;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.destack.overflow.model.AnswerItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class AnswerItemFetcherTest {

    @Resource
    AnswerItemFetcher aAnswerItemFetcher;

    @Test
    public void test() throws FileNotFoundException, IOException {
        File file = new File(System.getProperty("user.dir") + "/resources/JSONs/answerexample.json");
        List<AnswerItem> answerItems = aAnswerItemFetcher.objectFetcher(file.toURI().toURL());
        assertEquals(10, answerItems.size());
        assertEquals(1102, answerItems.get(0).getAnswerOwner().getReputation().intValue());
        assertEquals(2041077, answerItems.get(0).getAnswerOwner().getUser_id().intValue());
        assertEquals("registered", answerItems.get(0).getAnswerOwner().getUser_type());
        assertEquals(40, answerItems.get(0).getAnswerOwner().getAccept_range().intValue());
        assertEquals("https://www.gravatar.com/avatar/51bd9b4617d8a0f072d2fbd38ba9189f?s=128&d=identicon&r=PG",
                answerItems.get(0).getAnswerOwner().getProfile_image());
        assertEquals("Dave Galvin", answerItems.get(0).getAnswerOwner().getDisplay_name());
        assertEquals("http://stackoverflow.com/users/2041077/dave-galvin",
                answerItems.get(0).getAnswerOwner().getLink());
        assertEquals(false, answerItems.get(0).isIs_accepted());
        assertEquals(0, answerItems.get(0).getScore().intValue());
        assertEquals(1463702395, answerItems.get(0).getLast_activity_date().intValue());
        assertEquals(1463702395, answerItems.get(0).getCreation_date().intValue());
        assertEquals(37335929, answerItems.get(0).getAnswer_id().intValue());
        assertEquals(37214057, answerItems.get(0).getQuestion_id().intValue());
    }
}
