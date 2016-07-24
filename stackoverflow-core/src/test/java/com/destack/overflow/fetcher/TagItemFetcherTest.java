package com.destack.overflow.fetcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.destack.overflow.model.TagItem;
import com.destack.overflow.util.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class TagItemFetcherTest {

    @Resource
    private TagItemFetcher tagItemFetcher;

    @Test
    public void testTagExample() throws FileNotFoundException, MalformedURLException, IOException {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/JSONs/tagexample.json");
        List<TagItem> answerItems = tagItemFetcher.objectFetcher(file.toURI().toURL());
        assertEquals(30, answerItems.size());
        assertThat(Arrays.asList(answerItems.get(0).getSynonyms()),
                containsInAnyOrder("js", "ecmascript", ".js", "javascript-execution", "classic-javascript",
                        "javascript-alert", "javascript-dom", "javascript-disabled", "javascript-library",
                        "javascript-runtime", "vanilla-javascript", "javascript-module"));
        assertEquals(Long.valueOf(1469270369), answerItems.get(0).getLastActivityDate());
        assertTrue(answerItems.get(0).isHasSynonyms());
        assertFalse(answerItems.get(0).isModeratorOnly());
        assertFalse(answerItems.get(0).isRequired());
        assertEquals(Integer.valueOf(1175718), answerItems.get(0).getCount());
        assertEquals("javascript", answerItems.get(0).getName());
    }

    @Test
    public void testTagSynonymsExample()
            throws FileNotFoundException, MalformedURLException, IOException, NumberFormatException, ParseException {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/JSONs/tagsynonyms.json");
        List<TagItem> answerItems = tagItemFetcher.objectFetcher(file.toURI().toURL());
        assertEquals(30, answerItems.size());
        assertEquals("5-7-2016", answerItems.get(3).getCreationDate());
        assertEquals("6-7-2016", answerItems.get(3).getLastAppliedDate());
        assertEquals(Long.valueOf(1467808321),
                DateUtils.dateToMilliSecondsConverter(Long.valueOf(20160607)));
        assertEquals(Long.valueOf(1), answerItems.get(3).getAppliedCount());
    }

}
