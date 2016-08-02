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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext.xml" })
public class TagItemFetcherTest {

    @Resource
    private TagItemFetcher tagItemFetcher;

    @Test
    public void testTagExample() throws FileNotFoundException, MalformedURLException, IOException {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/JSONs/tagexample.json");
        List<TagItem> tagItems = tagItemFetcher.objectFetcher(file.toURI().toURL());
        assertEquals(30, tagItems.size());
        assertThat(Arrays.asList(tagItems.get(0).getSynonyms()),
                containsInAnyOrder("js", "ecmascript", ".js", "javascript-execution", "classic-javascript",
                        "javascript-alert", "javascript-dom", "javascript-disabled", "javascript-library",
                        "javascript-runtime", "vanilla-javascript", "javascript-module"));
        assertEquals(Long.valueOf(1469270369), tagItems.get(0).getLastActivityDate());
        assertTrue(tagItems.get(0).isHasSynonyms());
        assertFalse(tagItems.get(0).isModeratorOnly());
        assertFalse(tagItems.get(0).isRequired());
        assertEquals(Integer.valueOf(1175718), tagItems.get(0).getCount());
        assertEquals("javascript", tagItems.get(0).getName());
    }

    @Test
    public void testTagSynonymsExample()
            throws FileNotFoundException, MalformedURLException, IOException, NumberFormatException, ParseException {
        File file = new File(System.getProperty("user.dir") + "/src/main/resources/JSONs/tagsynonyms.json");
        List<TagItem> tagItems = tagItemFetcher.objectFetcher(file.toURI().toURL());
        assertEquals(30, tagItems.size());
        assertEquals("20160507", tagItems.get(3).getCreationDate());
        assertEquals("20160607", tagItems.get(3).getLastAppliedDate());
        assertEquals(Long.valueOf(1), tagItems.get(3).getAppliedCount());
        assertEquals("sql-execution-plan", tagItems.get(3).getToTag());
        assertEquals("execution-plan", tagItems.get(3).getFromTag());
    }

}
