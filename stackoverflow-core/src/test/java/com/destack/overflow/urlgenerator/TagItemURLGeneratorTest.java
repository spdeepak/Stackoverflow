package com.destack.overflow.urlgenerator;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashSet;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.destack.overflow.enums.Order;
import com.destack.overflow.enums.TagSortBy;
import com.destack.overflow.enums.TagSortBySynonyms;
import com.destack.overflow.initializers.TagItemInitializer;

/**
 * @author Deepak
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring/applicationContext.xml" })
public class TagItemURLGeneratorTest {

    @Resource
    private TagItemURLGenerator tagItemURLGenerator;

    @Test
    public void testCreateAllTagsInitializer() throws ParseException, MalformedURLException, IllegalAccessException {
        TagItemInitializer tii = TagItemInitializer.createAllTagsInitializer(1, 100, 20100405L, 20160707L, Order.ASC,
                TagSortBy.POPULAR, null, null, "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/tags?page=1&pagesize=100&fromdate=1272931200&todate=1467849600&order=asc&sort=popular&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());
        tii = TagItemInitializer.createAllTagsInitializer(1, 100, 20100405L, 20160707L, null, null, null, null, null);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags?page=1&pagesize=100&fromdate=1272931200&todate=1467849600&order=desc&sort=popular&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());
        tii = TagItemInitializer.createAllTagsInitializer(null, null, null, null, null, null, null, null, null);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags?order=desc&sort=popular&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());
        tii = TagItemInitializer.createAllTagsInitializer(null, null, null, null, null, TagSortBy.NAME, "a", "z",
                "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/tags?order=desc&min=a&max=z&sort=name&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());
        tii = TagItemInitializer.createAllTagsInitializer(null, null, null, null, null, TagSortBy.ACTIVITY, 20100405L,
                20160707L, "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/tags?order=desc&min=1272931200&max=1467849600&sort=activity&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());
    }

    @Test
    public void testCreateModeratorOnlyTagsInitializer()
            throws ParseException, MalformedURLException, IllegalAccessException {
        TagItemInitializer tagItemInitializer = TagItemInitializer.createModeratorOnlyTagsInitializer(1, 100, 20100405L,
                20160707L, Order.ASC, TagSortBy.POPULAR, null, null, "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/moderator-only?page=1&pagesize=100&fromdate=1272931200&todate=1467849600&order=asc&sort=popular&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tagItemInitializer).toString());
        tagItemInitializer = TagItemInitializer.createModeratorOnlyTagsInitializer(null, null, null, null, Order.ASC,
                null, null, null, "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/moderator-only?order=asc&sort=popular&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tagItemInitializer).toString());
        tagItemInitializer = TagItemInitializer.createModeratorOnlyTagsInitializer(null, null, null, null, null, null,
                null, null, null);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/moderator-only?order=desc&sort=popular&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tagItemInitializer).toString());

        tagItemInitializer = TagItemInitializer.createModeratorOnlyTagsInitializer(null, null, null, null, null,
                TagSortBy.NAME, "a", "z", "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/moderator-only?order=desc&min=a&max=z&sort=name&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tagItemInitializer).toString());
        tagItemInitializer = TagItemInitializer.createModeratorOnlyTagsInitializer(null, null, null, null, null,
                TagSortBy.ACTIVITY, 20100405L, 20160707L, "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/moderator-only?order=desc&min=1272931200&max=1467849600&sort=activity&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tagItemInitializer).toString());
    }

    @Test
    public void testCreateSynonymsTagsInitializer()
            throws ParseException, MalformedURLException, IllegalAccessException {
        TagItemInitializer tagItemInitializer = TagItemInitializer.createSynonymsTagsInitializer(1, 10, 20100405L,
                20161107L, Order.ASC, TagSortBySynonyms.ACTIVITY, 20100405L, 20161107L);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/synonyms?page=1&pagesize=10&fromdate=1272931200&todate=1468195200&order=asc&min=1272931200&max=1468195200&sort=activity&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tagItemInitializer).toString());
        tagItemInitializer = TagItemInitializer.createSynonymsTagsInitializer(1, 10, 20100405L, 20161107L, Order.ASC,
                TagSortBySynonyms.APPLIED, null, null);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/synonyms?page=1&pagesize=10&fromdate=1272931200&todate=1468195200&order=asc&sort=applied&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tagItemInitializer).toString());
        tagItemInitializer = TagItemInitializer.createSynonymsTagsInitializer(1, 10, 20100405L, 20161107L, Order.ASC,
                TagSortBySynonyms.CREATION, null, null);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/synonyms?page=1&pagesize=10&fromdate=1272931200&todate=1468195200&order=asc&sort=creation&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tagItemInitializer).toString());
        tagItemInitializer = TagItemInitializer.createSynonymsTagsInitializer(1, 10, 20100405L, 20161107L, null,
                TagSortBySynonyms.CREATION, null, null);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/synonyms?page=1&pagesize=10&fromdate=1272931200&todate=1468195200&order=desc&sort=creation&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tagItemInitializer).toString());
        tagItemInitializer = TagItemInitializer.createSynonymsTagsInitializer(1, 10, 20100405L, 20161107L, null, null,
                null, null);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/synonyms?page=1&pagesize=10&fromdate=1272931200&todate=1468195200&order=desc&sort=applied&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tagItemInitializer).toString());
    }

    @Test
    public void testCreateNameBasedTagInitializer()
            throws ParseException, MalformedURLException, IllegalAccessException {
        TagItemInitializer tii = TagItemInitializer.createNameBasedTagInitializer(1, 100, 20100405L, 20161107L, null,
                TagSortBy.ACTIVITY, 0, 0, new HashSet<>(Arrays.asList("java")));
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java/info?page=1&pagesize=100&fromdate=1272931200&todate=1468195200&order=desc&sort=activity&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());
        tii = TagItemInitializer.createNameBasedTagInitializer(1, 100, 20100405L, 20161107L, null, TagSortBy.POPULAR,
                null, null, new HashSet<>(Arrays.asList("java")));
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java/info?page=1&pagesize=100&fromdate=1272931200&todate=1468195200&order=desc&sort=popular&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());
        tii = TagItemInitializer.createNameBasedTagInitializer(null, null, 20100405L, 20161107L, null,
                TagSortBy.NAME, null, null, new HashSet<>(Arrays.asList("java", "php")));
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java;php/info?fromdate=1272931200&todate=1468195200&order=desc&sort=name&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());
        tii = TagItemInitializer.createNameBasedTagInitializer(null, null, 20100405L, 20161107L, null, TagSortBy.NAME,
                "a", "b", new HashSet<>(Arrays.asList("java", "php")));
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java;php/info?fromdate=1272931200&todate=1468195200&order=desc&min=a&max=b&sort=name&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());
        try{
            tii = TagItemInitializer.createNameBasedTagInitializer(null, null, 20100405L, 20161107L, null, TagSortBy.NAME,
                    null, null, null);
        } catch (IllegalArgumentException e) {
            assertEquals("Tag names are mandatory", e.getMessage());
        }

    }

    @Test
    public void testCreateNameBasedSynonymsTagInitializer()
            throws ParseException, MalformedURLException, IllegalAccessException {
        TagItemInitializer tii = TagItemInitializer.createNameBasedSynonymsTagInitializer(1, 100, 20100405L, 20161107L,
                Order.DESC, TagSortBy.ACTIVITY, null, null, new HashSet<>(Arrays.asList("java", "php")));
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java;php/synonyms?page=1&pagesize=100&fromdate=1272931200&todate=1468195200&order=desc&sort=activity&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());
        tii = TagItemInitializer.createNameBasedSynonymsTagInitializer(1, 100, 20100405L, 20161107L, Order.DESC,
                TagSortBy.NAME, "a", "d", new HashSet<>(Arrays.asList("java", "php")));
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java;php/synonyms?page=1&pagesize=100&fromdate=1272931200&todate=1468195200&order=desc&min=a&max=d&sort=name&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());
        try {
            tii = TagItemInitializer.createNameBasedSynonymsTagInitializer(1, 100, 20100405L, 20161107L, Order.DESC,
                    TagSortBy.ACTIVITY, 0, 0, null);
        } catch (IllegalArgumentException e) {
            assertEquals("Tag names are mandatory", e.getMessage());
        }
    }

}
