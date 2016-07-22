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
import com.destack.overflow.enums.TagPeriod;
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

        try {
            tii = TagItemInitializer.createAllTagsInitializer(null, null, null, null, null, TagSortBy.POPULAR,
                    "a", "z", "java");
        } catch (IllegalArgumentException e) {
            assertEquals("When TagSortBy is POPULAR min and max should be count", e.getMessage());
        }

        try {
            tii = TagItemInitializer.createAllTagsInitializer(null, null, null, null, null, TagSortBy.POPULAR,
                    12, "z", "java");
        } catch (IllegalArgumentException e) {
            assertEquals("When TagSortBy is POPULAR min and max should be count", e.getMessage());
        }

        try {
            tii = TagItemInitializer.createAllTagsInitializer(null, null, null, null, null, TagSortBy.ACTIVITY, "a",
                    "z", "java");
        } catch (IllegalArgumentException e) {
            assertEquals("When TagSortBy is ACTIVITY min and max should be Date(yyyyddMM)", e.getMessage());
        }

        try {
            tii = TagItemInitializer.createAllTagsInitializer(null, null, null, null, null, TagSortBy.ACTIVITY,
                    20100405L, "z",
                    "java");
        } catch (IllegalArgumentException e) {
            assertEquals("When TagSortBy is ACTIVITY min and max should be Date(yyyyddMM)", e.getMessage());
        }

        try {
            tii = TagItemInitializer.createAllTagsInitializer(null, null, null, null, null, TagSortBy.NAME, 12, "z",
                    "java");
        } catch (IllegalArgumentException e) {
            assertEquals("When TagSortBy is ACTIVITY min and max should be Tag Name", e.getMessage());
        }

        try {
            tii = TagItemInitializer.createAllTagsInitializer(null, null, null, null, null, TagSortBy.NAME, "a", 12,
                    "java");
        } catch (IllegalArgumentException e) {
            assertEquals("When TagSortBy is ACTIVITY min and max should be Tag Name", e.getMessage());
        }
    }

    @Test
    public void testCreateModeratorOnlyTagsInitializer()
            throws ParseException, MalformedURLException, IllegalAccessException {
        TagItemInitializer tagItemInitializer = TagItemInitializer.createModeratorOnlyTagsInitializer(1, 100, 20100405L,
                20160707L, Order.ASC, TagSortBy.POPULAR, null, null, "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/moderator-only?page=1&pagesize=100&fromdate=1272931200&todate=1467849600&order=asc&sort=popular&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tagItemInitializer).toString());

        tagItemInitializer = TagItemInitializer.createModeratorOnlyTagsInitializer(1, 100, 20100405L, 20160707L,
                Order.ASC, TagSortBy.POPULAR, 10, 20, "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/moderator-only?page=1&pagesize=100&fromdate=1272931200&todate=1467849600&order=asc&min=10&max=20&sort=popular&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
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
                TagSortBySynonyms.APPLIED, 12, 20);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/synonyms?page=1&pagesize=10&fromdate=1272931200&todate=1468195200&order=asc&min=12&max=20&sort=applied&site=stackoverflow&filter=!-*f(6qOIRgw-",
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

        try {
            tagItemInitializer = TagItemInitializer.createSynonymsTagsInitializer(1, 10, 20100405L, 20161107L, null,
                    TagSortBySynonyms.ACTIVITY, "a", "z");
        } catch (IllegalArgumentException e) {
            assertEquals("When TagSortBySynonyms is ACTIVITY/CREATION min and max should be Date(yyyyddMM)",
                    e.getMessage());
        }

        try {
            tagItemInitializer = TagItemInitializer.createSynonymsTagsInitializer(1, 10, 20100405L, 20161107L, null,
                    TagSortBySynonyms.ACTIVITY, 20100405L, "z");
        } catch (IllegalArgumentException e) {
            assertEquals("When TagSortBySynonyms is ACTIVITY/CREATION min and max should be Date(yyyyddMM)",
                    e.getMessage());
        }

        try {
            tagItemInitializer = TagItemInitializer.createSynonymsTagsInitializer(1, 10, 20100405L, 20161107L, null,
                    TagSortBySynonyms.APPLIED, "a", "z");
        } catch (IllegalArgumentException e) {
            assertEquals("When TagSortBySynonyms is APPLIED min and max should be count (i.e., a number)",
                    e.getMessage());
        }

        try {
            tagItemInitializer = TagItemInitializer.createSynonymsTagsInitializer(1, 10, 20100405L, 20161107L, null,
                    TagSortBySynonyms.APPLIED, 321, "z");
        } catch (IllegalArgumentException e) {
            assertEquals("When TagSortBySynonyms is APPLIED min and max should be count (i.e., a number)",
                    e.getMessage());
        }
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

        tii = TagItemInitializer.createNameBasedTagInitializer(1, 100, 20100405L, 20161107L, null, null, null, null,
                new HashSet<>(Arrays.asList("java")));
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java/info?page=1&pagesize=100&fromdate=1272931200&todate=1468195200&order=desc&sort=popular&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        tii = TagItemInitializer.createNameBasedTagInitializer(null, null, 20100405L, 20161107L, null, TagSortBy.NAME,
                null, null, new HashSet<>(Arrays.asList("java", "php")));
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java;php/info?fromdate=1272931200&todate=1468195200&order=desc&sort=name&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        tii = TagItemInitializer.createNameBasedTagInitializer(null, null, 20100405L, 20161107L, null, TagSortBy.NAME,
                "a", "b", new HashSet<>(Arrays.asList("java", "php")));
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java;php/info?fromdate=1272931200&todate=1468195200&order=desc&min=a&max=b&sort=name&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        try {
            tii = TagItemInitializer.createNameBasedTagInitializer(null, null, 20100405L, 20161107L, null,
                    TagSortBy.NAME, null, null, null);
        } catch (IllegalArgumentException e) {
            assertEquals("Tag names are mandatory", e.getMessage());
        }

        try {
            tii = TagItemInitializer.createNameBasedTagInitializer(null, null, 20100405L, 20161107L, null,
                    TagSortBy.NAME, null, null, new HashSet<>());
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

    @Test
    public void testCreateFAQTagInitializer() throws MalformedURLException, IllegalAccessException {
        TagItemInitializer tii = TagItemInitializer.createFAQTagInitializer(1, 100,
                new HashSet<>(Arrays.asList("java", "php")));
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java;php/faq?page=1&pagesize=100&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        tii = TagItemInitializer.createFAQTagInitializer(null, null, new HashSet<>(Arrays.asList("java", "php")));
        assertEquals("https://api.stackexchange.com/2.2/tags/java;php/faq?&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        try {
            tii = TagItemInitializer.createFAQTagInitializer(1, 100, null);
        } catch (IllegalArgumentException e) {
            assertEquals("Tag names are mandatory", e.getMessage());
        }

        try {
            tii = TagItemInitializer.createFAQTagInitializer(1, 100, new HashSet<>());
        } catch (IllegalArgumentException e) {
            assertEquals("Tag names are mandatory", e.getMessage());
        }
    }

    @Test
    public void testCreateRelatedTagsInitializer() throws MalformedURLException, IllegalAccessException {
        TagItemInitializer tii = TagItemInitializer.createRelatedTagsInitializer(1, 100,
                new HashSet<>(Arrays.asList("java", "php")));
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java;php/related?page=1&pagesize=100&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        tii = TagItemInitializer.createRelatedTagsInitializer(null, null, new HashSet<>(Arrays.asList("java", "php")));
        assertEquals("https://api.stackexchange.com/2.2/tags/java;php/related?&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        try {
            tii = TagItemInitializer.createRelatedTagsInitializer(null, null, null);
        } catch (IllegalArgumentException e) {
            assertEquals("Tag names are mandatory", e.getMessage());
        }
    }

    @Test
    public void testCreateTopAnswerTagInitializer() throws MalformedURLException, IllegalAccessException {
        TagItemInitializer tii = TagItemInitializer.createTopAnswerTagInitializer(1, 100, "java", TagPeriod.ALL_TIME);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java/top-answerers/all_time?page=1&pagesize=100&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        try {
            tii = TagItemInitializer.createTopAnswerTagInitializer(1, 100, null, TagPeriod.ALL_TIME);
        } catch (IllegalArgumentException e) {
            assertEquals("Tag name is mandatory", e.getMessage());
        }
        try {
            tii = TagItemInitializer.createTopAnswerTagInitializer(1, 100, " ", TagPeriod.ALL_TIME);
        } catch (IllegalArgumentException e) {
            assertEquals("Tag name is mandatory", e.getMessage());
        }
    }

    @Test
    public void testCreateTopAskerTagInitializer() throws MalformedURLException, IllegalAccessException {
        TagItemInitializer tii = TagItemInitializer.createTopAskerTagInitializer(1, 100, "java", TagPeriod.ALL_TIME);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java/top-askers/all_time?page=1&pagesize=100&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        tii = TagItemInitializer.createTopAskerTagInitializer(1, 100, "java", TagPeriod.MONTH);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java/top-askers/month?page=1&pagesize=100&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        tii = TagItemInitializer.createTopAskerTagInitializer(1, 100, "java", null);
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java/top-askers/all_time?page=1&pagesize=100&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        try {
            tii = TagItemInitializer.createTopAskerTagInitializer(1, 100, null, TagPeriod.ALL_TIME);
        } catch (IllegalArgumentException e) {
            assertEquals("Tag name is mandatory", e.getMessage());
        }
    }

    @Test
    public void testCreateWikiTagInitializer() throws MalformedURLException, IllegalAccessException {
        TagItemInitializer tii = TagItemInitializer.createWikiTagInitializer(1, 10,
                new HashSet<>(Arrays.asList("java", "php")));
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/java;php/wikis?page=1&pagesize=10&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        tii = TagItemInitializer.createWikiTagInitializer(null, null, new HashSet<>(Arrays.asList("java", "php")));
        assertEquals("https://api.stackexchange.com/2.2/tags/java;php/wikis?&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        try {
            tii = TagItemInitializer.createWikiTagInitializer(null, null, null);
        } catch (IllegalArgumentException e) {
            assertEquals("Tag names are mandatory", e.getMessage());
        }

        try {
            tii = TagItemInitializer.createWikiTagInitializer(null, null, new HashSet<>());
        } catch (IllegalArgumentException e) {
            assertEquals("Tag names are mandatory", e.getMessage());
        }
    }

    @Test
    public void testCreateRequiredNameTagInitializer()
            throws ParseException, MalformedURLException, IllegalAccessException {
        TagItemInitializer tii = TagItemInitializer.createRequiredNameTagInitializer(1, 100, 20100405L, 20160707L,
                Order.ASC, TagSortBy.POPULAR, null, null, "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/required?page=1&pagesize=100&fromdate=1272931200&todate=1467849600&order=asc&sort=popular&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        tii = TagItemInitializer.createRequiredNameTagInitializer(1, 100, 20100405L, 20160707L, Order.DESC,
                TagSortBy.ACTIVITY, null, null, "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/required?page=1&pagesize=100&fromdate=1272931200&todate=1467849600&order=desc&sort=activity&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        tii = TagItemInitializer.createRequiredNameTagInitializer(1, 100, 20100405L, 20160707L, Order.DESC,
                TagSortBy.ACTIVITY, 20100405L, 20160707L, "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/required?page=1&pagesize=100&fromdate=1272931200&todate=1467849600&order=desc&min=1272931200&max=1467849600&sort=activity&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        tii = TagItemInitializer.createRequiredNameTagInitializer(1, 100, 20100405L, 20160707L, Order.DESC,
                TagSortBy.NAME, "a", "b", "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/required?page=1&pagesize=100&fromdate=1272931200&todate=1467849600&order=desc&min=a&max=b&sort=name&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());

        tii = TagItemInitializer.createRequiredNameTagInitializer(1, 100, 20100405L, 20160707L, null, TagSortBy.POPULAR,
                null, null, "java");
        assertEquals(
                "https://api.stackexchange.com/2.2/tags/required?page=1&pagesize=100&fromdate=1272931200&todate=1467849600&order=desc&sort=popular&inname=java&site=stackoverflow&filter=!-*f(6qOIRgw-",
                tagItemURLGenerator.urlGenerator(tii).toString());
    }
}
